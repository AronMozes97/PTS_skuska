package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\aronm\\Desktop\\Files\\UKF MGR 2\\Testing\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //OPEN FIRST PAGE BY DRIVER
        driver.get("https://ais2.ukf.sk/ais/start.do");

        try {
            Thread.sleep(1000);

            //LOGIND DATA
            String login = "303092";
            String password = "9708181670";

            //LOGIN TO AIS
            driver.findElement(
                    By.id("login")
            ).sendKeys(login);

            driver.findElement(
                    By.id("heslo")
            ).sendKeys(password);

            driver.findElement(
                    By.id("login-form-submit-btn")
            ).click();

            Thread.sleep(1000);

            //START THE VIDEO

            driver.switchTo().frame(driver.findElement(By.xpath("/html/body/app-root/div/div[1]/div[3]/app-banner/div/div/section/mat-expansion-panel/div/div/iframe")));

            driver.findElement(
                    By.xpath("/html/body")
            ).click();

            Thread.sleep(7000);

            driver.findElement(
                    By.xpath("/html/body")
            ).click();

            Thread.sleep(2000);

            driver.switchTo().defaultContent();

            driver.findElement(
                    By.xpath("/html/body/app-root/lib-app-header/nav/div[3]")
            ).click();

            driver.findElement(
                    By.xpath("/html/body/app-root/lib-app-header/nav/div[3]/div/a")
            ).click();



        } catch (InterruptedException e){
                //PRINT THE ERROR OUT
                e.printStackTrace();
            }

            //CLOSE THE BROWSER
            driver.quit();
    }
}