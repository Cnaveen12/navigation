package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kanna on 5/24/2017.
 */
public class JavaScriptInjectionTest {
    public WebDriver driver;
    @Before
    public void getDriver(){
        driver = new ChromeDriver();
    }
    @Ignore
    @Test
    public void javaScriptInjectionTest(){
        JavascriptExecutor jsEx = (JavascriptExecutor) driver;
        driver.navigate().to("http://compendiumdev.co.uk/selenium/canvas_basic.html");
        int count = driver.findElements(By.cssSelector("#commandlist > li:nth-child(1)")).size();
         ((JavascriptExecutor) driver).executeScript(" draw(arguments[0], 150, 150, 100, arguments[1]);", 1,"blue");
        int count2 = driver.findElements(By.cssSelector("#commandlist > li:nth-child(1)")).size();
        assertEquals("Count and Count2 are equal", count, count2);
    }
    @Ignore
    @Test
    public void javaScriptArgs(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long sum = Long.parseLong("3");

        Long total =(Long) js.executeScript(" return arguments[0]+arguments[1]",1,2);
        assertEquals("sum==total",sum, total);
    }
    @Test
    public void javaScriptHidePassedElementArgument(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.navigate().to("http://compendiumdev.co.uk/selenium/canvas_basic.html");
       // WebElement actionsList = driver.findElement(By.cssSelector("#commandlist"));
        js.executeScript("document.getElementById(\"commandlist\").style.display = \"none\";");



    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
