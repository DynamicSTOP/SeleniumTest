package com.koms;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by leonid on 23.01.17.
 */
public class Browser {
    WebDriver driver;
    private String loginUrl = "https://www.dmm.com/my/-/login/=/path=Sg__/";
    public Browser() {

        System.setProperty("webdriver.chrome.driver", ConfigLoader.DriverPath);
        ChromeOptions options = new ChromeOptions();

        //options.addArguments("-incognito");
        options.addArguments("--user-data-dir=" + ConfigLoader.UserDataDir);
        options.addArguments("--profile-directory=Default");
        options.setBinary(ConfigLoader.BrowserPath);
        options.addArguments("load-extension=" + ConfigLoader.KC3Path);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(capabilities);


        try {
            Thread.currentThread().sleep(2000);
            navigateToDMM();
            Thread.currentThread().sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean navigateToDMM(){
        driver.navigate().to("http://minedeeper.net");//loginUrl
        try{
            (new WebDriverWait(driver, 10)).
                    until(ExpectedConditions.presenceOfElementLocated(By.id("login_id")));
            return true;
        }catch (NoSuchElementException exception){
            return false;
        }
    }

    private void login(){
        navigateToDMM();

    }

    private void navigateToPopup(){
        driver.navigate().to(ConfigLoader.ExtensionPath + "pages/popup/popup.html");
    }
}
