package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAddressPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='user-info']//span")
    private WebElement nameUser;

    @FindBy(name = "alias")
    private WebElement aliasElement;

    @FindBy(name = "company")
    private WebElement companyElement;

    @FindBy(name = "vat_number")
    private WebElement vatNumberElement;

    @FindBy(name = "address1")
    private WebElement address1Element;

    @FindBy(name = "address2")
    private WebElement address2Element;

    @FindBy(name = "postcode")
    private WebElement postcodeElement;

    @FindBy(name = "city")
    private WebElement cityElement;

    @FindBy(name = "id_country")
    private WebElement countryElement;

    @FindBy(name = "phone")
    private WebElement phoneElement;

    @FindBy(xpath = "//*[@id='content']//button")
    private WebElement saveButton;

    public NewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getNameUser(){
        return nameUser.getText();
    }

    public void setAliasElement(String alias) {
        aliasElement.sendKeys(alias);
    }

    public void setCompanyElement(String company) {
      companyElement.sendKeys(company);
    }

    public void setVatNumberElement(String vatNumber) {
        vatNumberElement.sendKeys(vatNumber);
    }

    public void setAddress1Element(String address1) {
        address1Element.sendKeys(address1);
    }

    public void setAddress2Element(String address2) {
        address2Element.sendKeys(address2);
    }

    public void setPostcodeElement(String postcode) {
        postcodeElement.sendKeys(postcode);
    }

    public void setCityElement(String city) {
        cityElement.sendKeys(city);
    }

    public void setCountryElement(String country){
        Select selectCountry = new Select(countryElement);
        selectCountry.selectByVisibleText(country);
    }

    public void setPhoneElement(String phone) {
        phoneElement.sendKeys(phone);
    }

    public void saveAddress(){
        saveButton.click();
    }
}
