package com.ivan.SeleniumLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginEncapsulate {

    public WebDriver driver;

    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();

        driver.get("https://www.imooc.com");
        driver.manage().window().maximize();
        driver.findElement(By.id("js-signin-btn")).click();
    }


    public void loginScript() throws InterruptedException {
        this.InitDriver();

        String username = "ivanzhong0310@gmail.com";
        String emailElement = "email";
        String userBy = "id";
        String userpass = "aaaaaaaa";
        String passBy = "name";
        String passwordElement = "password";
        String buttonElement = "moco-btn";
        String buttonBy = "className";
        String headerElement = "header-avator";
        String nameElement = "name";



        Thread.sleep(3000);

        //WebElement user = driver.findElement(By.name(emailElement));
        //WebElement user = driver.findElement(this.byStr(userBy,emailElement));
        WebElement user = this.element(this.byStr(userBy,emailElement));

        user.isDisplayed();
        //WebElement password = driver.findElement(By.name(passwordElement));
        //WebElement password = driver.findElement(this.byStr(passBy,passwordElement));
        WebElement password = this.element(this.byStr(passBy,passwordElement));

        password.isDisplayed();
        //WebElement loginButton = driver.findElement(By.className(buttonElement));
        //WebElement loginButton = driver.findElement(this.byStr(buttonBy,buttonElement));
        WebElement loginButton = this.element(this.byStr(buttonBy,buttonElement));

        loginButton.isDisplayed();

        user.sendKeys(username);
        password.sendKeys(userpass);
        loginButton.click();

        Thread.sleep(3000);

        //driver.findElement(By.id("header-avator")).isDisplayed();
        //WebElement header = driver.findElement(By.id(headerElement));

        //TODO
        WebElement header = this.element(By.id(headerElement));

        header.isDisplayed();


        Actions actions = new Actions(driver);
        actions.moveToElement(header).perform();


        //driver.findElement(By.id("name")).isDisplayed();
        //String userInfo = driver.findElement(By.className(nameElement)).getText();

        //TODO
        String userInfo = this.element(By.className(nameElement)).getText();

        //System.out.println(userInfo);
        if (userInfo.equals("xxxxxxx")){
            System.out.println("login success");
        }else {
            System.out.println("login fail");
        }


    }

    public By byStr(String by, String local){
        if (by.equals("id")){
            return By.id(local);
        }else if (by.equals("name")){
            return By.name(local);
        }else if (by.equals("className")){
            return By.className(local);
        }else {
            return By.xpath(local);
        }

    }

    /**
     * 封装findElement
     * @param by
     * @return
     */
    public WebElement element(By by){
        WebElement ele = driver.findElement(by);
        return ele;
    }

    public static void main(String[] args) throws InterruptedException {
        LoginEncapsulate login = new LoginEncapsulate();
        //login.InitDriver();
        login.loginScript();
    }
}
