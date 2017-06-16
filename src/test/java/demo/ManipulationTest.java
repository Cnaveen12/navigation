package demo;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.assertFalse;

/**
 * Created by Kanna on 5/7/2017.
 */
public class ManipulationTest {
    public  WebDriver driver;
    @Before
    public  void getDriver(){
        driver = new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_html_form.html");
    }
    @Test
    public void findElementAndSelect(){

        WebElement element = driver.findElement(By.cssSelector("input[value=\"submit\"]"));
        element.click();
        new WebDriverWait(driver,10).until(ExpectedConditions.titleIs("Processed Form Details"));
        assertFalse("HTMl Form Elements", equals(driver.getTitle()));
        System.out.println(driver.getTitle());
    }
    @Test
    public void findElementByCommentsSubmit(){

        WebElement element1 = driver.findElement(By.cssSelector("textarea[name='comments']"));
        element1.clear();
        element1.sendKeys("Hello Naveen");
        WebElement element2 = driver.findElement(By.cssSelector("input[value=\"submit\"]"));
        element2.click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.titleIs("Processed Form Details"));
        assertFalse("Hello Naveen", equals(driver.findElement(By.cssSelector("#_valuecomments")).getText()));
        System.out.println(driver.findElement(By.cssSelector("#_valuecomments")).getText());

    }
    /*@Test
    public void findElementByRadioCheckboxMultiple(){
        WebElement element = driver.findElement(By.cssSelector("input[value='rd2']"));
        element.click();
        WebElement element2 = driver.findElement(By.cssSelector("input[value='cb1']"));
        element2.click();
        WebElement element5 = driver.findElement(By.cssSelector("input[value='cb3']"));
        element5.click();
        WebElement element3 = driver.findElement(By.cssSelector("option[value='dd5']"));
        element3.click();
        WebElement multiple = driver.findElement(By.cssSelector("[multiple='multiple']"));
        List<WebElement> elements = multiple.findElements(By.cssSelector("option"));
        for(WebElement e: elements){
            e.click();
        }
        WebElement element4 = driver.findElement(By.cssSelector("input[value='submit']"));
        element4.click();

    }*/
    @After
    public  void closeDriver(){
        driver.close();
    }
}
