package com.onurakca.Pages;

import com.onurakca.BasePage.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    final static Logger Log = Logger.getLogger(HomePage.class);

    @FindBy(xpath = "//*[@id=\"seg-giybi\"]/span")
    private WebElement popUp1;

    @FindBy(xpath = "//div[@class='dn-slide-buttons horizontal']/button[@class='dn-slide-deny-btn']")
    private WebElement popUp2;

    @FindBy(xpath = "//span[@title='Mağazalar']")
    private WebElement magazalar;

    @FindBy(xpath = "//a[@href='https://www.n11.com/magazalar']")
    private WebElement magazalariGoster;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public static String getUrl() {
        return "https://www.n11.com/";
    }
    public void pageOpening(){
        driver.get(getUrl());
        Log.info("https://www.n11.com/ adresine gidilir");
        waitForPageLoad();
        Log.info("sayfanın açıldığı kontrol edildi");
        currentTitleCheck("n11.com - Hayat Sana Gelir");
        Log.info("doğru sayfa açıldığı kontrol edildi");
    }

    public void magazaGoster() {
        hoverElement(magazalar);
        Log.info("mouse,magazalar elementinin üzerine gider");
        wait(1);
        closePopUp();
        Log.info("popuplar kapatılır");
        wait(3);
        magazalariGoster.click();
        Log.info("magazaları göster button'una tıklanır");
        wait(1);
        waitForPageLoad();

    }
    public void closePopUp(){

        popUp1.click();
        Log.info("1.popup kapatıldı");
        wait(1);


    }
    public void closePopUp2(){
        popUp1.click();
        Log.info("1.popup kapatıldı");
        wait(1);
        popUp2.click();
        Log.info("2.popup kapatıldı");
    }
}
