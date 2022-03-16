package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Test32_1 {
    WebDriver wd;

    @BeforeMethod
    public void preConditions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        System.setProperty("webdriver.chromedriver","C:/Users/Tatiana/Automatization/QA_32Start/chromdriver.exe");
        wd.navigate().to("https://trello.com/");
    }


    @Test
    public void test1() {
        //tag
        WebElement el = wd.findElement(By.tagName("a"));
        WebElement el2 = wd.findElement(By.tagName("div"));
        WebElement el22 = wd.findElement(By.cssSelector("a"));
        WebElement el222 = wd.findElement(By.cssSelector("div"));

        //id
        WebElement el3 = wd.findElement(By.id("hero"));
        WebElement el4 = wd.findElement(By.cssSelector("#hero"));
        WebElement el44 = wd.findElement(By.xpath("//*[@id='hero']"));

        //class
        WebElement el5 = wd.findElement(By.className("d-block float-left"));
        WebElement el6 = wd.findElement(By.cssSelector(".float-left"));
        WebElement el116 = wd.findElement(By.xpath("//*[@class='float-left']"));

        //link/[at=value]
        WebElement link = wd.findElement(By.linkText("Sign up"));
        WebElement link2 = wd.findElement(By.cssSelector("[href='/signup']"));

        //starts-contains-ends(css)
        WebElement el7 = wd.findElement(By.cssSelector("[data-analytics-screen='homeScreen']"));
        WebElement el8 = wd.findElement(By.cssSelector("[data-analytics-screen *='Screen']"));
        WebElement el88 = wd.findElement(By.cssSelector("[data-analytics-screen ^='ho']"));
        WebElement el89 = wd.findElement(By.cssSelector("[data-analytics-screen $='enn']"));

        //starts-contains-ends(xpsth)
        WebElement el177 = wd.findElement(By.xpath("//*[@data-analytics-screen='homeScreen']"));
        WebElement el178 = wd.findElement(By.xpath("//*[contains(@data-analytics-screen,'Screen')]"));
        WebElement el179 = wd.findElement(By.xpath("//*[starts-with(@data-analytics-screen,'ho')]"));

    }

    @Test
    public void test2() {
        List<WebElement> eln = wd.findElements(By.tagName("a"));
        System.out.println(eln.size());
    }

    @Test
    public void enterPositiveEmail() {
        WebElement elm = wd.findElement(By.cssSelector("input[name='email]"));
        type(elm, "juliakliot.jk@gmail.com");
    }

    public void type(WebElement elm, String text) {
        elm.click();
        elm.clear();
        elm.sendKeys(text);
    }

    @Test
    public void enterNegEmail(){
        WebElement elm = wd.findElement(By.cssSelector("input[name='email]"));
        type(elm,"juliakliot.jk@gmail.");
    }



    @AfterMethod
    public void postConditions() {
        wd.close();
        wd.quit();
    }


}