package com.onurakca.Pages;

import com.onurakca.BasePage.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    final static Logger Log = Logger.getLogger(SearchPage.class);

    @FindBy(xpath = "//input[@id='brand-m-Afox']")
    private WebElement markaSec;

    @FindBy(xpath="//div[@data-position='3']//img")
    private WebElement urun;

    public SearchPage(WebDriver driver) {
        super(driver);
    }
    public void markaSec(){
        markaSec.click();
        Log.info("marka seçilir");
        wait(2);
        urun.click();
        Log.info("3.ürün seçilir");
        waitForPageLoad();
        wait(2);

    }
}
