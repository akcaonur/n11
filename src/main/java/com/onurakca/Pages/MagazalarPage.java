package com.onurakca.Pages;

import com.onurakca.BasePage.BasePage;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class MagazalarPage extends BasePage {


    Workbook wb= new HSSFWorkbook();
    Sheet sheet=wb.createSheet("Mağazalar");
    final static Logger Log = Logger.getLogger(MagazalarPage.class);


    @FindBy(xpath = "//div[@class='tabPanel allSellers']//li[2]/a")
    private WebElement randomMagaza;


    public MagazalarPage(WebDriver driver) {
        super(driver);
    }

    public void magazalarListesi() {

        for(int i=1;i<7857;i++){
            WebElement webElement = driver
                    .findElement(By
                            .xpath("//div[@class='tabPanel allSellers']//li["+i+"]/a"));

            Row row = sheet.createRow((short)i);
            Cell cell=row.createCell(0);
            cell.setCellValue(webElement.getText());
            try {
                FileOutputStream fileout=new FileOutputStream("workbook.xlsx");
                try {
                    wb.write(fileout);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    fileout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        Log.info("Magaza listesi exel'e aktarılır");

    }
    public void randomMagaza(){
        Random r=new Random(); //random sınıfı
        int random=r
                .nextInt(7857);
        driver.findElement(By
                .xpath("//div[@class='tabPanel allSellers']//li["+random+"]/a"))
                .click();
        Log.info("Random magaza seçilir ve tıklanır");
        waitForPageLoad();
    }

}
