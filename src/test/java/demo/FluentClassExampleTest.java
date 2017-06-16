package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/**
 * Created by Kanna on 5/23/2017.
 */
public class FluentClassExampleTest {
    public WebDriver driver;
    @Before
    public void getDriver(){
        driver = new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/javascript_countdown.html");
    }
    @Test
    public void fluentWaitExample(){

    }

    @After
    public void closeDriver(){
        driver.close();
    }

}
