import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestCheapTicketSearch {
    private WebDriver driver;
    String appURL = "https://www.cheaptickets.com/";
    private WebDriverWait wait;
    private CheapTicketHomePage homepage;
    private CheapTicketSearchPage searchpage;

    @BeforeClass
    public void testSetpUP() {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 15);
    }

    @Test
    public void TestCheapTicket() {
        homepage = new CheapTicketHomePage(driver);
        driver.navigate().to(appURL);
        driver.findElement(By.id("tab-hotel-tab-hp")).click();
        homepage.setLocationElement("Miami Beach");
        //homepage.clickCheckinbtn();
        driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys("06/12/2019");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        homepage.clickdateCheckin();
        //driver.findElement(By.id("hotel-checkin-hp-hotel")).click();

        //homepage.setCheckinElement("06/19/2019");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("hotel-checkout-hp-hotel")).click();
        homepage.clickDateCheckOut();
        //((JavascriptExecutor) driver).executeScript("document.getElementById('hotel-checkout-hp-hotel').value = '06/28/2019';");
        homepage.setNumAdultsElement("4");
        homepage.setNumChildrenElement("1");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.className("cols-nested")).click();
        homepage.setAgeChildrenElement("7");
        homepage.clickSearchButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchpage = new CheapTicketSearchPage(driver);
        String titleResultSearch = searchpage.getTitleResultSearchElement().getText();
        String[] titleSplit = titleResultSearch.split(" ");
        String qaSearch = titleSplit[2];
        int qaFound = Integer.parseInt(qaSearch);
        String location = titleSplit[0] + " " + titleSplit[1];
        Assert.assertTrue(qaFound > 0);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy--HH.mm.ss");
        String dateNow = formatter.format(date);
        takeScreen(driver, dateNow + "ResultadoDeBusquedaHotel.jpg");

        Assert.assertEquals("Miami Beach:", location);
        String city = searchpage.getCityElement().getText();
        searchpage.setNameHotelElement("Fae");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        searchpage.clickFirstSearch();
        searchpage.clickFilterHotel();

        String nameHotel = searchpage.getNameHotelResultElement().getText();


        Assert.assertEquals("Faena Hotel Miami Beach", nameHotel);
        takeScreen(driver, dateNow + "HotelFaena.jpg");


    }

    @AfterClass
    public void teestSetpUeeP() {
        driver.quit();


    }

    public void takeScreen(WebDriver driver, String name) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("imagen\\" + name));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}