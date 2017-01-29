package com.koms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by leonid on 23.01.17.
 */
public class Browser {
    WebDriver driver;
    public Browser(){

        System.setProperty("webdriver.chrome.driver", ConfigLoader.DriverPath);
        ChromeOptions options = new ChromeOptions();

        options.addArguments("-incognito");
        options.addArguments("--user-data-dir="+ConfigLoader.UserDataDir);
        options.addArguments("--profile-directory=Default");
        options.setBinary(ConfigLoader.BrowserPath);
        options.addArguments("load-extension="+ConfigLoader.KC3Path);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(capabilities);


        try{
            Thread.currentThread().sleep(2000);
            driver.navigate().to("http://ya.ru");
            Thread.currentThread().sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
