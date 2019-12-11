package com.google.codelabs.mdc.java.emotivo.utils;

import java.lang.ref.WeakReference;
import java.util.HashMap;

public class DataHolder {
    private static String data;
    public static String getData() {return data;}
    public static void setData(String data) {DataHolder.data = data;}
}