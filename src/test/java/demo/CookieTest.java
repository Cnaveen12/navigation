package demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Kanna on 5/24/2017.
 */
public class CookieTest {

    public WebDriver driver;
    @Before
    public void getDriver(){
        driver= new ChromeDriver();
        driver.navigate().to("http://compendiumdev.co.uk/selenium/search.php");
    }
    @Test
    public void cookieTestExample(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        Cookie aCookie = driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");

        String value = aCookie.getValue();
        assertThat(value, is("1"));

    }
    @Test
    public void cookieTestSecondExample(){
        driver.manage().deleteAllCookies();

        //Cookie aCookie = driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");
        Cookie.Builder newCookie = new Cookie.Builder("seleniumSimplifiedSearchNumVisits","42");
        newCookie.domain("compendiumdev.co.uk");
        newCookie.path("/selenium");

        driver.manage().addCookie(newCookie.build());
        driver.navigate().refresh();
        assertThat(driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits").getValue(), is("43"));
    }
    @Test
    public void cookieTestThirdExample(){


        Cookie aCookie = driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits");
        Cookie.Builder newCookie = new Cookie.Builder(aCookie.getName(),"43");
        newCookie.domain(aCookie.getDomain());
        newCookie.path(aCookie.getPath());
        driver.manage().deleteCookie(aCookie);
        driver.manage().addCookie(newCookie.build());
        driver.navigate().refresh();
        assertThat(driver.manage().getCookieNamed("seleniumSimplifiedSearchNumVisits").getValue(), is("44"));
    }
    @After
    public void closeDriver(){
        driver.close();
    }
}
