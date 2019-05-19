import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheapTicketSearchPage {

    private WebDriver driver;


    public CheapTicketSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "section-header-main")
    private WebElement titleResultSearchElement;
    @FindBy(how = How.CSS, using = ".flex-area-primary .hotel-info .neighborhood")
    private WebElement cityElement;
    @FindBy(how = How.ID, using = "inpHotelNameMirror")
    private WebElement nameHotelElement;
    @FindBy(how = How.ID, using = "hotelNameGoBtn")
    private WebElement filterHotelBtn;
    @FindBy(how = How.ID, using = "aria-option-0")
    private WebElement firstSearchElement;

    //WebElement dayCheckin =calender.get(0);
    //dayCheckin.findElement(By.cssSelector("button[data-day=`20`]"));

    public WebElement getTitleResultSearchElement() {
        return titleResultSearchElement;
    }

    public WebElement getCityElement() {
        return cityElement;
    }

    public WebElement getNameHotelElement() {
        return nameHotelElement;
    }

    public WebElement getFilterHotelBtn() {
        return filterHotelBtn;
    }

    public WebElement getNameHotelResultElement() {
        return nameHotelResultElement;
    }

    @FindBy(how = How.CSS, using = ".flex-card .flex-link-wrap .flex-content .flex-area-primary .hotel-info .hotelTitle .hotelName")
    private WebElement nameHotelResultElement;


    public void setNameHotelElement(String name) {
        nameHotelElement.sendKeys(name);
    }

    public void clickFilterHotel() {
        filterHotelBtn.click();
    }

    public void clickFirstSearch() {
        firstSearchElement.click();
    }


}
