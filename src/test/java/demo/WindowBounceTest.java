package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Kanna on 5/16/2017.
 */
public class WindowBounceTest {
    public WebDriver driver;
    @Before
    public void getDriver(){
        driver = new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/bounce.html");
    }
    @Test
    public void windowBounce(){
        WebDriver.Window window = driver.manage().window();
        window.maximize();
        Dimension dimension = window.getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        driver.manage().window().setSize(new Dimension(width/2,height/2));
        driver.manage().window().setPosition(new Point(width/4, height/4));
    }
    @After
    public void closeDriver(){
       // driver.close();
    }
}
