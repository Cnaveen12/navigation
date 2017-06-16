package demo;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kanna on 5/16/2017.
 */
public class FramesTest {
    public static WebDriver driver;
    @Before
    public  void getDriver(){
        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/frames/");
    }
    @Test
    public void switchToFrame(){
        driver.switchTo().frame("content");
        WebElement link = driver.findElement(By.cssSelector("a[href='green.html']"));
        link.click();
        link = driver.findElement(By.cssSelector("a[href='content.html']"));
        link.click();
        link = driver.findElement(By.cssSelector("h1"));
        String header = link.getText();
        assertThat(header, is("Content"));

    }
    @Test
    public void switchToFrameAndIFrame(){
        driver.switchTo().frame("menu");
        WebElement element =driver.findElement(By.cssSelector("a[href=\"iframe.html\"]"));
        element.click();
       element = driver.findElement(By.cssSelector("iframe"));
       driver.switchTo().frame(element);
      element= driver.findElement(By.cssSelector("a[href='frames_example_5.html']"));
       element.click();
        driver.switchTo().frame("menu");
        element= driver.findElement(By.cssSelector("h3"));
        String text = element.getText();
        assertThat(text, is("Menu 1"));
    }

    @After
    public  void closeDriver(){
        driver.close();
    }
}
