package demo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

/**
 * Created by Kanna on 5/6/2017.
 */
public class FindElementByTest {

    public static WebDriver driver;

    @BeforeClass
    public static void getDriver(){
        driver= new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/find_by_playground.php");

    }
    @Test
    public void FindElementByEx(){
        //WebElement element = driver.findElement(By.id("p31"));
        //WebElement element = driver.findElement(By.cssSelector("#p31"));
        WebElement element = driver.findElement(By.xpath("//*[@id=\"p31\"]"));
        assertEquals("pName31",element.getAttribute("name"));


    }
    @Test
    public void FindElementByName(){
        //WebElement element = driver.findElement(By.name("ulName1"));
        WebElement element = driver.findElement(By.xpath("//*[@name='ulName1']"));
        assertEquals("ul1",element.getAttribute("id"));
    }
    @Test
    public void FindElementByClassName(){
        //WebElement element = driver.findElement(By.className("specialDiv"));
        WebElement element = driver.findElement(By.xpath("//*[@class=\"specialDiv\"]"));
        assertEquals("div1", element.getAttribute("id"));
    }
    @Test
    public void FindElementByTagName(){
        //WebElement element = driver.findElement(By.tagName("li"));
        WebElement element = driver.findElement(By.xpath("//li"));
        assertEquals("liName1", element.getAttribute("name"));
    }

    @AfterClass
    public static void closeDriver(){
        driver.close();
    }
}
