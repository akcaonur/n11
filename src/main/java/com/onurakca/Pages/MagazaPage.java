package com.onurakca.Pages;

import com.onurakca.BasePage.BasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MagazaPage extends BasePage {

    final static Logger Log = Logger.getLogger(MagazaPage.class);

    @FindBy(xpath = "//a[@title='Mağaza Yorumları']")
    private WebElement magazaYorumlar;

    @FindBy(xpath = "//em")
    private WebElement yorumYok;

    @FindBy(xpath = "//span[@class='selectedReview']")
    private WebElement yorumlar;

    public MagazaPage(WebDriver driver) {
        super(driver);
    }
    public void magazaYorumlari(){
        magazaYorumlar.click();
        wait(1);
        Log.info("magaza yorumlarına tıklanır");

        if(yorumlar.isDisplayed()){
            String yorumSayisi=yorumlar.getText();
            String[] words = yorumSayisi.split(" ");
            Log.info("magaza yorumları görüntülenir");
            Log.info("magaza yorumları:"+words[2]);
        }else{
            Log.info("yorum yok");
        }

    }
}
