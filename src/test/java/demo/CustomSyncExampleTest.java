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



import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kanna on 5/23/2017.
 */
public class CustomSyncExampleTest {
    public WebDriver driver;
    @Before
    public void getDriver(){
        driver = new ChromeDriver();

    }
    @Test
    public void customSyncExample(){
        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_ajax.html");
        driver.findElement(By.cssSelector("#combo1 > option:nth-child(3)")).click();
        WebElement java= new WebDriverWait(driver,10).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver webDriver){
                WebElement element = webDriver.findElement(By.cssSelector("#combo2 > option:nth-child(4)"));
                if(element.isDisplayed()){
                return element;
                }else{
                    return null;
                }
            }

        });
        assertThat(java.getText(), is("Java"));

    }
    @Test
    public void customSyncExampleMethodWrappedOverAnonymousClass(){
        driver.navigate().to("http://compendiumdev.co.uk/selenium/basic_redirect.html");
        driver.findElement(By.cssSelector("#delaygotobounce")).click();
        String s1= new WebDriverWait(driver,10).until(titleDoesNotContain("Basic"));
        assertThat(s1,is("Bounce"));

    }

    private ExpectedCondition<String> titleDoesNotContain(final String s) {


        return new ExpectedCondition<String>() {
            public String apply(WebDriver webDriver) {
                if(webDriver.getTitle().contains(s)!= true){
                    return webDriver.getTitle();
                }
                else{
                    return null;
                }
            }
        };
    }


    @After
    public void closeDriver(){
        driver.close();
    }
}
