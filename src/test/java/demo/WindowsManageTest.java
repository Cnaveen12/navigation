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
public class WindowsManageTest {
    public WebDriver driver;
    @Before
    public void getDriver(){
        driver= new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/frames");
    }
    @Test
    public void windowsPositionSizeManage(){
        driver.manage().window().setPosition(new Point(10,40));
        driver.manage().window().setSize(new Dimension(100,200));


    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
