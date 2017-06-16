package demo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * Created by Kanna on 5/10/2017.
 */
public class UserInteractions {

    public static WebDriver driver;
    @BeforeClass
    public static void getDriver(){
        driver = new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/gui_user_interactions.html");
    }
//    @Test
//    public void dragAndDrop(){
//        WebElement draggable1= driver.findElement(By.cssSelector("div[id='draggable1']"));
//        WebElement droppable1 = driver.findElement(By.cssSelector("div[id='droppable1']"));
//        new Actions(driver).dragAndDrop(draggable1,droppable1).release().perform();
//        assertThat(droppable1.getText(),is("Dropped!"));
//
//    }
    @Test
    public void controlB(){
        new Actions(driver).keyDown(Keys.CONTROL).sendKeys("B").perform();
        assertThat(driver.findElement(By.cssSelector("div[id='draggable1']")).getText(),is("Bwa! Ha!Ha!"));
    }
   /* @AfterClass
    public static void closeDriver(){
        driver.close();
    }*/
}
