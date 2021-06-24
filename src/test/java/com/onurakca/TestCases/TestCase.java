package com.onurakca.TestCases;

import com.onurakca.BaseTest.BaseTest;
import com.onurakca.Pages.*;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TestCase extends BaseTest {


    final static Logger Log = Logger.getLogger(TestCase.class);
    @Test
    public void test_1_1()  {
        HomePage homePage = new HomePage(driver);
        homePage.pageOpening();
        homePage.wait(10);
        homePage.magazaGoster();
        MagazalarPage magazalarPage= new MagazalarPage(driver);
        magazalarPage.magazalarListesi();
        magazalarPage.randomMagaza();
        MagazaPage magazaPage = new MagazaPage(driver);
        magazaPage.magazaYorumlari();
    }
    @Test
    public void test_1_2(){
        HomePage homePage = new HomePage(driver);
        homePage.pageOpening();
        homePage.wait(10);
        homePage.closePopUp2();
        homePage.search("ekran kartı");
        SearchPage searchPage = new SearchPage(driver);
        searchPage.markaSec();
        UrunPage urunPage = new UrunPage(driver);
        urunPage.sepeteEkle();
        SepetPage sepetPage = new SepetPage(driver);
        sepetPage.sepettekiUrunSayisiKontrol();

    }

}
