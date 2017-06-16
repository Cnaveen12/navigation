package DifferentBrowsers;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kanna on 5/31/2017.
 */
public class OpenABrowser {
    private static WebDriver driver;
    @BeforeClass
    public static void openDriver(){
        driver = new ChromeDriver();
    }

    @Test

    public void openBrowser() {

        driver.get("http://www.ratatype.com/login/");

        driver.findElement(By.cssSelector("#email")).sendKeys("Fazle");



    }


}
