package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kanna on 5/16/2017.
 */
public class WindowsTest {
    public static WebDriver driver;
    @Before
    public void getDriver(){

        driver = new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/frames/index.html");
    }
//    @Test
//    public void threeDiffWindowsTest(){
//        String currentWindowHandle = driver.getWindowHandle();
//        driver.switchTo().frame("content");
//        driver.findElement(By.cssSelector("a[href='http://www.seleniumsimplified.com']")).click();
//        Set<String> windows = driver.getWindowHandles();
//        String newWindowHandle = "";
//        for(String tempWindow: windows) {
//            if (!currentWindowHandle.contentEquals(tempWindow)) {
//                newWindowHandle = tempWindow;
//            }
//
//        }
//        driver.switchTo().window(newWindowHandle);
//        assertThat(driver.getTitle(),containsString("Selenium Simplified"));
//        driver.close();
//        driver.switchTo().window(currentWindowHandle);
//
//        assertThat(driver.getTitle(), containsString("Frameset Example"));
//    }
    @Test
    public void swithBetweenWindows(){
        String firstWindowHandle = driver.getWindowHandle();


        driver.switchTo().frame("content");
        driver.findElement(By.cssSelector("#goevil")).click();
        driver.findElement(By.cssSelector("a[href=\"http://www.compendiumdev.co.uk\"]")).click();

        driver.switchTo().window(firstWindowHandle);
        driver.close();
        driver.switchTo().window("compdev");
        driver.close();
        driver.switchTo().window("evil");









    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
