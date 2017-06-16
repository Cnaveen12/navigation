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
public class AlertsTest {
    public static WebDriver driver;
    @Before
    public void getDriver(){
        driver = new ChromeDriver();
        driver.navigate().to("http://www.compendiumdev.co.uk/selenium/alerts.html");
    }
    @Test
    public void acceptAndDismissAlert(){
            WebElement element =driver.findElement(By.cssSelector("#alertexamples"));
            element.click();
            driver.switchTo().alert().accept();
        WebElement element1 =driver.findElement(By.cssSelector("#alertexamples"));
        element.click();
        driver.switchTo().alert().dismiss();
    }
    @Test
    public void acceptAndDismissAlertAssertTextChanges(){
        WebElement buttonAlert = driver.findElement(By.cssSelector("#confirmexample"));
        buttonAlert.click();
        driver.switchTo().alert().accept();
        WebElement text = driver.findElement(By.cssSelector("#confirmreturn"));
        assertThat(text.getText(), is("true"));
        buttonAlert.click();
        driver.switchTo().alert().dismiss();
        text = driver.findElement(By.cssSelector("#confirmreturn"));
        assertThat(text.getText(), is("false"));
    }
    @Test
    public void promtExample(){
        WebElement buttomAlert = driver.findElement(By.cssSelector("#promptexample"));

        WebElement text = driver.findElement(By.cssSelector("#promptreturn"));
        assertThat(text.getText(),is("pret"));
        buttomAlert.click();
        driver.switchTo().alert().dismiss();
        assertThat(text.getText(),is("pret"));
        buttomAlert.click();
        driver.switchTo().alert().accept();
        assertThat(text.getText(),is("change me"));
        buttomAlert.click();
        driver.switchTo().alert().sendKeys("Hello world");
        driver.switchTo().alert().accept();
        assertThat(text.getText(),is("Hello world"));


    }
    @After
    public  void closeDriver(){
        driver.close();
    }
}
