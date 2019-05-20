import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheapTicketHomePage {

    private WebDriver driver;


    @FindBy(how = How.ID, using = "hotel-destination-hp-hotel")
    private WebElement locationElement;
    //@FindBy(how = How.ID, using = "hotel-checkin-hp-hotel")
    @FindBy(how = How.CSS, using = ".datepicker-cal-date[data-day='12'][data-month='5']")
    private WebElement checkinElement;
    //@FindBy(how=How.ID,using="hotel-checkout-hp-hotel")
    @FindBy(how = How.CSS, using = ".datepicker-cal-date[data-day='28'][data-month='5']")
    private WebElement checkoutElement;
    @FindBy(how = How.ID, using = "hotel-1-adults-hp-hotel")
    private WebElement numAdultsElement;
    @FindBy(how = How.ID, using = "hotel-1-children-hp-hotel")
    private WebElement numChildrenElement;
    @FindBy(how = How.ID, using = "hotel-1-age-select-1-hp-hotel")
    private WebElement ageChildrenElement;
    @FindBy(how = How.CSS, using = "#section-hotel-tab-hp .gcw-submit")
    private WebElement searchButton;
    @FindBy(how = How.CLASS_NAME, using = "datepicker-cal-dates")
    private List<WebElement> calender;
    @FindBy(how = How.ID, using = "hotel-checkin-hp-hotel")
    private WebElement checkinbtn;
    @FindBy(how = How.ID, using = "tab-hotel-tab-hp")
    private WebElement hotelbtn;
    @FindBy(how = How.ID, using = "hotel-checkout-hp-hotel")
    private WebElement checkOutbtn;
    @FindBy(how=How.ID,using = "hotel-checkin-hp-hotel")
            private WebElement checkinFirstElement;



    public void setCheckinFirst(String cidate)
    {
        checkinFirstElement.sendKeys(cidate);
    }
    public void clickCheckOutbtn() {
        checkOutbtn.click();
    }

    public void clickHotelbtn() {
        hotelbtn.click();
    }

    public void clickCheckinbtn() {
        checkinbtn.click();
    }

    public void clickdateCheckin() {
        checkinElement.click();
    }

    public void clickDateCheckOut() {
        checkoutElement.click();
    }


    public void clickSearchButton() {
        searchButton.click();
    }

    public WebElement getLocationElement() {
        return locationElement;
    }

    public WebElement getCheckinElement() {
        return checkinElement;
    }

    public WebElement getCheckoutElement() {
        return checkoutElement;
    }

    public WebElement getNumAdultsElement() {
        return numAdultsElement;
    }

    public WebElement getNumChildrenElement() {
        return numChildrenElement;
    }

    public WebElement getAgeChildrenElement() {
        return ageChildrenElement;
    }


    public void setLocationElement(String location) {
        locationElement.sendKeys(location);
    }

    public void setCheckinElement(String checkin) {

        driver.findElement(By.id("hotel-checkin-hp-hotel")).click();

        checkinElement.sendKeys(checkin);
    }

    public void setCheckoutElement(String checkout) {
        checkoutElement.sendKeys(checkout);
    }

    public void setNumAdultsElement(String numAdul) {
        numAdultsElement.sendKeys(numAdul);
    }

    public void setNumChildrenElement(String numChild) {
        numChildrenElement.sendKeys(numChild);
    }

    public void setAgeChildrenElement(String ageChild) {
        ageChildrenElement.sendKeys(ageChild);
    }

    public void datePickerCheckin(int day) {
        WebElement dayCheckin = calender.get(0);
        WebElement daySelected = dayCheckin.findElement(By.cssSelector("button[data-day='" + day + "']"));
        daySelected.click();
    }


    public CheapTicketHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


}

