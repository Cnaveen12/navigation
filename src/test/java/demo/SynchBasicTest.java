package demo;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kanna on 5/16/2017.
 */
public class SynchBasicTest {
    public WebDriver driver;
    @Before
    public void getDriver(){
        driver= new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_ajax.html");

    }
    @Test
    public void synchBasic(){

        driver.findElement(By.cssSelector("#combo1 > option:nth-child(3)")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable( (By.cssSelector("option[value='23']"))));
        driver.findElement(By.cssSelector("#combo2 > option:nth-child(4)")).click();
        driver.findElement(By.cssSelector("[name='submitbutton']")).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));
        String value = driver.findElement(By.cssSelector("#_valuelanguage_id")).getText();
        assertThat(value,is("23"));

    }
}
