package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.NewAddressPage;
import pages.SignInPage;
import pages.YourAddressedPage;

import java.util.concurrent.TimeUnit;

public class CreateNewAddressedSteps {
    WebDriver driver;
    SignInPage signInPage;
    YourAddressedPage yourAddressedPage;
    NewAddressPage newAddressPage;

    String listaDanychString;

    @Given("^Użytkownik jest zalogowany$")
    public void usersIsLogged(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication&back=my-account");
        signInPage = new SignInPage(driver);
        signInPage.signIn("dznjmhufehcahoslbj@niwghx.com", "qwe123");

    }

    @When("^Użytkownik jest na stronie (.*)$")
    public void goToAddressedPage(String page){
        driver.get(page);
    }

    @And("^kliknij na Create new address$")
    public void clickCreateNewAddress() {
        yourAddressedPage = new YourAddressedPage(driver);

//        listaDanychString = yourAddressedPage.getNameUser();
        yourAddressedPage.setCreateNewAddress();

    }

    @And("^w polu Alias wpisz (.*)$")
    public void setAlias(String alias) {
        newAddressPage = new NewAddressPage(driver);
        listaDanychString =  alias + "\n" + newAddressPage.getNameUser();
        newAddressPage.setAliasElement(alias);

    }

    @And("^w polu Company wpisz (.*)$")
    public void setCompany(String company) {
        newAddressPage.setCompanyElement(company);
        listaDanychString += "\n" + company;
    }

    @And("^w polu VAT number wpisz (.*)$")
    public void setVat(String vat) {
        newAddressPage.setVatNumberElement(vat);
        listaDanychString += "\n" + vat;
    }

    @And("^w polu Address wpisz (.*)$")
    public void setAddress1(String address1) {
        newAddressPage.setAddress1Element(address1);
        listaDanychString += "\n" + address1;
    }

    @And("^w polu Address Complement wpisz (.*)$")
    public void setAddress2(String address2) {
        newAddressPage.setAddress2Element(address2);
        listaDanychString += "\n" + address2;
    }

    @And("^w polu City wpisz (.*)$")
    public void setCity(String city) {
        newAddressPage.setCityElement(city);
        listaDanychString += "\n" + city;
    }

    @And("^w polu Zip/Postal Code wpisz (.*)$")
    public void setPostcode(String postcode) {
        newAddressPage.setPostcodeElement(postcode);
        listaDanychString += "\n" + postcode;
    }


    @And("^z listy Country wybiesz (.*)$")
    public void setCountry(String country) {
        newAddressPage.setCountryElement(country);
        listaDanychString += "\n" + country;
    }

    @And("^w polu Phone wpisz (.*)$")
    public void setPhone(String phone) {
        newAddressPage.setPhoneElement(phone);
        listaDanychString += "\n" + phone;
    }

    @And("^zapisz nowy adres$")
    public void saveNewAddress() {
        newAddressPage.saveAddress();
    }

    @And("^sprawdź poprawność zapisanego adresu$")
    public void checkSavingAddress() {
        yourAddressedPage.checkSavedAddress(listaDanychString);
    }

    @Then("^zamknij strone$")
    public void closePage() {
        driver.close();
    }
}
