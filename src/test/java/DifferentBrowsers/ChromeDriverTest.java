package DifferentBrowsers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kanna on 5/27/2017.
 */
public class ChromeDriverTest {
    public WebDriver driver;
    @Before
    public void getDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-extensions");
        options.addArguments("disable-plugins");
        driver = new ChromeDriver(options);
    }
    @Test
    public void chromeDriverTest(){

        driver.navigate().to("https://www.google.com/");
        assertThat(driver.getTitle(), is("Google"));
    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
