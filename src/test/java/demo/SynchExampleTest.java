package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

/**
 * Created by Kanna on 5/23/2017.
 */
public class SynchExampleTest {

    public WebDriver driver;
    @Before
    public void startDriver(){

        driver = new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_ajax.html");




    }
    @Test
    public void syncTestExample(){
        WebElement category = driver.findElement(By.id("combo1")).findElement(By.cssSelector("option[value='3']"));
        category.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("option[value='23']")));
        driver.findElement(By.cssSelector("option[value='23']")).click();
        driver.findElement(By.cssSelector("input[value='Code In It']")).click();

        WebElement s = driver.findElement(By.cssSelector("#_valuelanguage_id"));
        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));
        assertThat(s.getText(), is("23"));


    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
