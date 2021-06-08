package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class YourAddressedPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='addresses-footer']//a")
    private WebElement createNewAddress;

    @FindBy(xpath = "//div[@class='user-info']//span")
    private WebElement nameUser;

    @FindBy(xpath = "//section[@id='content']//article/div[@class='address-body']")
    private List<WebElement> listAddress;


    public YourAddressedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getNameUser(){
        return nameUser.getText();
    }

    public void checkSavedAddress(String listaDanych){
        int listAddressSize = listAddress.size();
        String newAddress = listAddress.get(listAddressSize-1).getText();
        Assert.assertEquals(listaDanych, newAddress);

    }

    public void setCreateNewAddress(){

        createNewAddress.click();
    }
}
