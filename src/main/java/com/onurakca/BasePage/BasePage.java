package com.onurakca.BasePage;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class BasePage {

    final static Logger Log = Logger.getLogger(BasePage.class);
    WebDriverWait wait;
    protected WebDriver driver;

    @FindBy(xpath = "//input[@id='searchData']")
    private WebElement searchBar;

    @FindBy(xpath = "//span[@class='icon iconSearch']")
    private WebElement searchButton;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait= new WebDriverWait(this.driver , 500);
        PageFactory.initElements(driver, this);
    }

    public void waitForPageLoad() {

        Log.info("sayfanın yüklenmesini bekler");
        Wait<WebDriver> wait = new WebDriverWait(driver, 10);
        wait.until(new Function<WebDriver, Boolean>() {
            public Boolean apply(WebDriver driver) {
                System.out.println("Current Window State       : "
                        + String.valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")));
                return String
                        .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                        .equals("complete");
            }
        });
    }
    public void currentTitleCheck(String title){
        Log.info("sayfanın title'nı kontrol eder");
        String currentTitle = driver.getTitle();
        if (currentTitle.equals(title)){
            Log.info("Sayfanın title'ı doğru bir şekilde gelmiştir");
        }
        else{
            Log.info("Sayfanın title'ı doğru değildir");
            Assert.fail("Sayfanın title'ı doğru değildir");

        }
    }
    public void hoverElement(WebElement webElement){
        Log.info("elementin üzerine gider");
        if (webElement.isDisplayed()) {
            Actions actions = new Actions(driver); //1CFP
            actions.moveToElement(webElement).perform();//1CFP
        }
    }
    public void wait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void search(String search){
        searchBar.sendKeys(search);
        Log.info("serchbar'a search değeri girilir");
        wait(1);
        searchButton.click();
        Log.info("arama buttonuna tıklanır");
    }

}
