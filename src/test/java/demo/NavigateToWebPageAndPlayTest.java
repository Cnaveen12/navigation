package demo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

/**
 * Created by Kanna on 5/4/2017.
 */
public class NavigateToWebPageAndPlayTest {
    private static WebDriver driver;
    @BeforeClass
    public static void driverInit(){
        driver = new HtmlUnitDriver();
    }
   @Test
   public void getElementById(){
        driver.navigate().to("http://compendiumdev.co.uk/selenium/find_by_playground.php");
        WebElement para= driver.findElement(By.tagName("div"));

        System.out.println(para.getText());

   }
    @AfterClass
    public static void closeDriver(){
        driver.quit();
    }
}
