package DifferentBrowsers;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kanna on 5/25/2017.
 */
public class FireFoxDriverTest {
    public  WebDriver  driver;
    @Before
    public  void getDriver(){
        String currentDirectory = System.getProperty("user.dir");
        String directory = currentDirectory + "/../tools/Marionette/wires.exe";
        System.setProperty("webdriver.gecko.driver", directory);




    }
    @Test
    public void testFireFoxDriver(){

        FirefoxProfile profile = new FirefoxProfile();
        profile.addExtension(new File("C:\\Users\\Naveenkumar\\Downloads\\tools\\Extensions\\firebug\\firebug-2.0.19.xpi"));
        driver = new FirefoxDriver(profile);
        driver.get("https://www.google.com/");
        String title = driver.getTitle();
        assertThat(title,is("Google"));
    }
//    @After
//    public void closeDriver(){
//        driver.quit();
//    }
}
