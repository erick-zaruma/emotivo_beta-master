package com.google.codelabs.mdc.java.emotivo;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Fade;

import com.google.codelabs.mdc.java.emotivo.authoring.MenuFragment;

public class MainActivity extends AppCompatActivity implements NavigationHost,SendNameListener {

    private FragmentManager mFragmentManager;

    private Handler mDelayedTransactionHandler = new Handler();
    private Runnable mRunnable = this::performTransition;

    private static final long MOVE_DEFAULT_TIME = 1000;
    private static final long FADE_DEFAULT_TIME = 300;

    public static OnboardingScreen4Fragment screen4Fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shr_main_activity);

        mFragmentManager = getSupportFragmentManager();
        loadInitialFragment();
        mDelayedTransactionHandler.postDelayed(mRunnable,1000);
        
        /*if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new IntroHomeFragment())
                    .commit();
        }*/
    }


    private void loadInitialFragment() {
        Fragment initialFragment = IntroHomeFragment.newInstance();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,initialFragment);
        fragmentTransaction.commit();
    }

    private void performTransition()
    {
        if (isDestroyed())
        {
            return;
        }

        //LOADING INITIAL FRAGMENT FOR TESTING
        Fragment previousFragment = mFragmentManager.findFragmentById(R.id.container);
        Fragment nextFragment = IntroQuestion1Fragment.newInstance();
       // Fragment nextFragment = MenuFragment.newInstance();


        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        // 1. Exit for Previous Fragment
        Fade exitFade = new Fade();
        exitFade.setDuration(FADE_DEFAULT_TIME);
        previousFragment.setExitTransition(exitFade);

        // 2. Shared Elements Transition
      /*  TransitionSet enterTransitionSet = new TransitionSet();
        enterTransitionSet.addTransition(TransitionInflater.from(this).inflateTransition(android.R.transition.move));
        enterTransitionSet.setDuration(MOVE_DEFAULT_TIME);
        enterTransitionSet.setStartDelay(FADE_DEFAULT_TIME);
        nextFragment.setSharedElementEnterTransition(enterTransitionSet);
*/
        // 3. Enter Transition for New Fragment
        Fade enterFade = new Fade();
        enterFade.setStartDelay(MOVE_DEFAULT_TIME + FADE_DEFAULT_TIME);
        enterFade.setDuration(FADE_DEFAULT_TIME);
        nextFragment.setEnterTransition(enterFade);

        View logo = findViewById(R.id.iv_intro_screen);
       // fragmentTransaction.addSharedElement(logo, logo.getTransitionName());
        fragmentTransaction.replace(R.id.container, nextFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mDelayedTransactionHandler.removeCallbacks(mRunnable);
    }

    /**
     * Navigate to the given fragment.
     *
     * @param fragment       Fragment to navigate to.
     * @param addToBackstack Whether or not the current fragment should be added to the backstack.
     */
    @Override
    public void navigateTo(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction transaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment);

        if (addToBackstack) {
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }

    @Override
    public void sendData(String message) {
        //String tag = "android:switcher:" + R.id.viewPager + ":" + 1;
         screen4Fragment = (OnboardingScreen4Fragment) OnboardingScreen4Fragment.newScreen4Instance();
        //OnboardingScreen4Fragment fragment = (OnboardingScreen4Fragment) getSupportFragmentManager().findFragmentById(R.id.container);
        screen4Fragment.displayReceivedData(message);

    }
}
