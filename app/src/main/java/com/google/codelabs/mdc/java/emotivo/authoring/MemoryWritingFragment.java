package com.google.codelabs.mdc.java.emotivo.authoring;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.codelabs.mdc.java.emotivo.NavigationHost;
import com.google.codelabs.mdc.java.emotivo.R;
import com.google.codelabs.mdc.java.emotivo.common.TutorialShiba;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MemoryWritingFragment extends Fragment {
    private String nameId;
    private ProgressBar progressBar;
    private EditText textBox;
    private ImageButton saveButton;
    private final int maxWordLength = 100;
    private Boolean updatingProgressBar = true;
    private HashMap<String, String> dbStrings = new HashMap<>();
    private Handler mHandler = new Handler();
    public MemoryWritingFragment(String nameId) {
        this.nameId = nameId; // use this name id as key to saving and writing memory
    }

    private void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("db.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            System.out.println(context.getFilesDir());
            InputStream inputStream = context.openFileInput("db.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString+"\n");
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
            return "";
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
            return "";
        } catch (Exception e) {
            return "";
        }

        return ret;
    }

    public void saveText(Context context) {
        String dbPayload = "";
        for (HashMap.Entry<String, String> entry : dbStrings.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String cleanValue = value.replaceAll("\n|=" , " ");
            dbPayload += key + "=" + value.replaceAll("\n", " ") + "\n";
        }
        writeToFile(dbPayload, getContext());
    }

    private void loadTextFromDatabase(Context context) {
        String data = readFromFile(context);
        if (data.equals("")) {
            return;
        }
        String[] dataStrings = data.split("\n");
        for (int i = 0; i < dataStrings.length; i++) {
            String key = dataStrings[i].split("=")[0];
            String value = dataStrings[i].split("=")[1]; // will cause bug when : in text
            dbStrings.put(key, value);
        }
        return;
    }

    public void setTextFromDatabase() {
        if (dbStrings.containsKey(nameId)) {
            textBox.setText(dbStrings.get(nameId));
        }
    }

    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_authoring_memory_writing, container, false);
        if (view == null) {
            return null;
        }
        ((TextView)view.findViewById(R.id.pastwritingtitle)).setText(nameId.split("/")[2]);


        if (readFromFile(getContext()) == "") {
            writeToFile("", getContext());
        }
        loadTextFromDatabase(getContext());
        textBox = view.findViewById(R.id.editText);
        setTextFromDatabase();
        textBox.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int c) {
                dbStrings.put(nameId, textBox.getText().toString());
                saveText(getContext());
            }
        });
        progressBar = view.findViewById(R.id.progressBar);
        new Thread(() -> {
            while (updatingProgressBar) {
                android.os.SystemClock.sleep(30);
                int charLength = textBox.getText().length();
                mHandler.post(() -> {
                    progressBar.setProgress(100 * charLength / maxWordLength);
                });
            }
        }).start();

        saveButton = view.findViewById(R.id.nextwritebutton);
        saveButton.setOnClickListener((View unused) -> {
            saveText(getContext());
            if (textBox.getText().length() > maxWordLength) {
                ((NavigationHost) getActivity()).navigateTo(new RewardPageFragment(), true);
            }
        });

        new TutorialShiba(getContext(), view.findViewById(R.id.root), new ArrayList<>(Arrays.asList("As you begin to" +
                " write the bar will fill up. When you hit the bar, you will get a special surprise! Don't worry too much about" +
                " your writing, just let it come to you and let yourself go.", "Once you hit your word goal hit the play button" +
                " to advance and get the reward. The more you write the more you will earn.")));
        return view;
    }
}
