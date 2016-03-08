package learn.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by zuhair.mukry on 3/8/2016.
 */
public class WikipediaTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
        driver.get("http://www.wikipedia.org");
    }

    @Test
    public void verifyWikipediaPage() {
        wait.until(ExpectedConditions.titleIs("Wikipedia"));
    }

    @Test
    public void verifyWikipediaClickEnglish() {
        wait.until(ExpectedConditions.urlMatches("https://www.wikipedia.org/"));

        WebElement englishLink = driver.findElement(By.cssSelector("a[href='//en.wikipedia.org/'].link-box"));

        wait.until(ExpectedConditions.elementToBeClickable(englishLink));
        englishLink.click();
        wait.until(ExpectedConditions.urlContains("https://en.wikipedia.org"));
    }


    @After
    public void closeBrowser() {
        driver.quit();
    }
}
