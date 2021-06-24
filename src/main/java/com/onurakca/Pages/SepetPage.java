package com.onurakca.Pages;

import com.onurakca.BasePage.BasePage;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SepetPage extends BasePage {

    final static Logger Log = Logger.getLogger(SepetPage.class);

    @FindBy(xpath = "//div[@class='spinnerField ']/input")
    private WebElement sepettekiSayi;

    public SepetPage(WebDriver driver) {
        super(driver);
    }
    public void sepettekiUrunSayisiKontrol(){
        String urunSayisi=sepettekiSayi.getAttribute("value").toString();

        if(urunSayisi.equals("2")){
            Log.info("sepette 2 adet ürün olduğu doğrulanır");
        }else{
            Log.info("sepette 2 adet ürün yok");
            Assert.fail();
        }

    }


}
