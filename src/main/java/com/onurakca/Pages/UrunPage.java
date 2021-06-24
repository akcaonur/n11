package com.onurakca.Pages;

import com.onurakca.BasePage.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UrunPage extends BasePage {

    final static Logger Log = Logger.getLogger(UrunPage.class);

    @FindBy(xpath = "//div[@class='pDetail-spinner']//span[@class='spinnerUp spinnerArrow']")
    private WebElement urunEkle;

    @FindBy(xpath = "//a[@class='btn btnGrey addBasketUnify']/span[@class='icon-white-basket']")
    private WebElement sepeteEkleButton;

    @FindBy(xpath = "//a[@class='btn btnBlack btnGoBasket']")
    private WebElement sepeteGit;

    public UrunPage(WebDriver driver) {
        super(driver);
    }

    public void sepeteEkle(){
        urunEkle.click();
        Log.info("urun sayisi 1 arttırılır 2 olur");
        wait(1);
        sepeteEkleButton.click();
        Log.info("urunler sepete eklenir");
        wait(1);
        sepeteGit.click();
        Log.info("sepete git buttonuna tıklanır");
        waitForPageLoad();
    }
}
