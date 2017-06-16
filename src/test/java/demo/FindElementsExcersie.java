package demo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kanna on 5/6/2017.
 */
public class FindElementsExcersie {

    public static WebDriver driver;
    @BeforeClass
    public static void openDriver(){
        driver= new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/find_by_playground.php");

    }
    @Test
    public void findElementsByExercise(){

        List<WebElement> elements = driver.findElements(By.tagName("div"));
        assertEquals(19, elements.size());

    }

    @Test
    public void findElementsByHref(){
        List<WebElement> elements = driver.findElements(By.partialLinkText("jump to para"));
        assertEquals(25, elements.size());
    }
    @Test
    public void findElemetntsByDivAndParas(){

        List<WebElement> paras1 = driver.findElements(By.tagName("p"));
        assertEquals(41, paras1.size());
        List<WebElement> paras2 = driver.findElements(By.tagName("p"));
        assertEquals(16, paras2.size());
    }

    @AfterClass
    public static void closeDriver(){
        driver.close();
    }

}
