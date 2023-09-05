package Pages;

import Utilities.BaseDriver;
import Utilities.MyMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DialogContent extends MyMethods {

    public DialogContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(css = "[id='signin2']")
    public WebElement signUp;
    @FindBy(css = "[id='sign-username']")
    public WebElement username;

    @FindBy(css = "[id='sign-password']")
    public WebElement password;

    @FindBy(css = "[onclick='register()']")
    public WebElement signUpButton;

    @FindBy(css = "[id='login2']")
    public WebElement login;

    @FindBy(css = "[id='loginusername']")
    public WebElement loginUserName;

    @FindBy(css = "[id='loginpassword']")
    public WebElement loginPassword;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginButton;

    @FindBy(css = "[id='nameofuser']")
    public WebElement assertLogin;

    @FindBy(xpath = "//*[@class='price-container']")
    public WebElement productPrice;
    @FindBy(xpath = "//a[text()='Phones']")
    public WebElement phonesButton;

    @FindBy(linkText = "Samsung galaxy s6")
    public WebElement SamsungGalaxy;

    @FindBy(xpath = "//a[text()='Add to cart']")
    public WebElement addProduct;

    @FindBy(xpath = "//a[text()='Home ']")
    public WebElement Home;

    @FindBy(xpath = "//a[text()='Laptops']")
    public WebElement laptopsButton;

    @FindBy(linkText = "Sony vaio i5")
    public WebElement SonyVaio;

    @FindBy(xpath = "//a[text()='Monitors']")
    public WebElement monitorsButton;

    @FindBy(linkText = "Apple monitor 24")
    public WebElement AppleMonitor;

    @FindBy(xpath = "//a[text()='Cart']")
    public WebElement Cart;

    @FindBy(xpath = "(//a[text()='Delete'])[1]")
    public WebElement remove;

    @FindBy(css = "[class='panel panel-info']")
    public WebElement Total;

    @FindBy(css = "[id='next2']")
    public WebElement Next;
    @FindBy(linkText = "MacBook air")
    public WebElement MacBookAir;

    @FindBy(xpath = "//button[text()='Place Order']")
    public WebElement placeOrder;

    @FindBy(id = "totalp")
    public WebElement TotalPrice;

    @FindBy(xpath = "//tbody[@id=\"tbodyid\"]//tr[@class='success']//td[text()='360']")
    public List<WebElement> list;

    @FindBy(id = "name")
    public WebElement firstName;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "card")
    public WebElement card;

    @FindBy(id = "month")
    public WebElement month;

    @FindBy(id = "year")
    public WebElement year;

    @FindBy(xpath = "//button[text()='Purchase']")
    public WebElement purchaseButton;

    @FindBy(xpath = "//button[text()='OK']")
    public WebElement okeyButton;

    @FindBy(xpath = "(//div[@class='sweet-alert  showSweetAlert visible'] //p)[1]")
    public  WebElement id;
















}
