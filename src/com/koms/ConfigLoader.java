package com.koms;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;

/**
 * Created by Leonid on 29.01.2017.
 */
public class ConfigLoader {
    public static String UserDataDir;
    public static String DriverPath;
    public static String BrowserPath;
    public static String KC3Path;
    public static String ExtensionPath;

    private class Config {
        private String UserDataDir;
        private String DriverPath;
        private String BrowserPath;
        private String KC3Path;
        private String ExtensionPath;
    }

    public ConfigLoader() {
        loadConfig();
        System.out.println("udd = " + UserDataDir);
        System.out.println("dp  = " + DriverPath);
        System.out.println("bp  = " + BrowserPath);
        System.out.println("kc3 = " + KC3Path);
    }

    private void loadConfig() {
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("config.json"));
            Config c = gson.fromJson(reader, Config.class);
            BrowserPath = c.BrowserPath;
            DriverPath = c.DriverPath;
            UserDataDir = c.UserDataDir;
            KC3Path = c.KC3Path;
            ExtensionPath = c.ExtensionPath;
        } catch (Exception e) {
            System.out.println("Error while loading json");
            System.out.println(e.getStackTrace());
        }
    }
}
