package com.ivan.SeleniumLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {

    public WebDriver driver;

    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.imooc.com");
        driver.manage().window().maximize();
    }


    public void loginScript() throws InterruptedException {
        driver.findElement(By.id("js-signin-btn")).click();

        Thread.sleep(3000);

        WebElement user = driver.findElement(By.name("email"));
        user.isDisplayed();
        WebElement password = driver.findElement(By.name("password"));
        password.isDisplayed();
        WebElement loginButton = driver.findElement(By.className("moco-btn"));
        loginButton.isDisplayed();

        user.sendKeys("ivanzhong0310@gmail.com");
        password.sendKeys("aaaaaaaa");
        loginButton.click();

        Thread.sleep(3000);

        //driver.findElement(By.id("header-avator")).isDisplayed();
        WebElement header = driver.findElement(By.id("header-avator"));
        header.isDisplayed();


        Actions actions = new Actions(driver);
        actions.moveToElement(header).perform();


        //driver.findElement(By.id("name")).isDisplayed();
        String userInfo = driver.findElement(By.className("name")).getText();
        //System.out.println(userInfo);
        if (userInfo.equals("xxxxxxx")){
            System.out.println("login success");
        }else {
            System.out.println("login fail");
        }


    }

    public static void main(String[] args) throws InterruptedException {
        Login login = new Login();
        login.InitDriver();
        login.loginScript();
    }
}
