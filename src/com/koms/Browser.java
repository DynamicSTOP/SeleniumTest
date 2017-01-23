package com.koms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Created by leonid on 23.01.17.
 */
public class Browser {
    WebDriver driver;
    public Browser(){
        System.setProperty("webdriver.chrome.driver", "/home/leonid/phpstorm-workspace/webDriver/chromedriver64");
        driver = new ChromeDriver();
        driver.navigate().to("http://ya.ru");
        try{
            Thread.currentThread().sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
