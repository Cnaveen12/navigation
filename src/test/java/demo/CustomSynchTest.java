package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kanna on 5/23/2017.
 */
public class CustomSynchTest {
    public WebDriver driver;
    @Before
    public void getDriver(){
        driver = new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_ajax.html");

    }
    @Test
    public void customSynchTest(){
        driver.findElement(By.cssSelector("#combo1 > option:nth-child(3)")).click();
        new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver webDriver){
                return webDriver.findElement(By.cssSelector("#combo2 > option:nth-child(4)")).isDisplayed();
            }
        }
        );
        driver.findElement(By.cssSelector("#combo2 > option:nth-child(4)")).click();
        driver.findElement(By.cssSelector("body > form > input[type=\"submit\"]:nth-child(7)")).click();
        new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webDriver){
                return driver.findElement(By.cssSelector("#_valuelanguage_id")).isDisplayed();
            }

        });
        WebElement e =driver.findElement(By.cssSelector("#_valuelanguage_id"));
        assertThat(e.getText(),is("23"));
    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
