package Pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentGateway extends BaseTest {
	public WebDriverWait wait;
	@FindBy(xpath="//span[@class='mb-pay__order-id--value']")
	private WebElement orderId;
	@FindBy(xpath="//div[@class='mb-pay__add-ons--package']")
	private WebElement packageNamePGI;
	@FindBy(xpath="//span[@class='mb-pay__heading__total--value']")
	private WebElement price;
	@FindBy(xpath="//a[@data-tab='slide_wallets']")
	private WebElement wallet;
	@FindBy(xpath="//body/div[@id='choosePayment']/div[1]/div[1]/section[1]/div[2]/div[2]/div[3]/a[1]")
	private WebElement cont;
	@FindBy(xpath="//button[@class='ptm-go-back-btn']")
	private WebElement paytmBack;
	
	@FindBy(xpath="//button[contains(text(), 'Okay, Got it')]")
	private WebElement gotIt;
	
	@FindBy(xpath="//button[@class='ptm-custom-btn ptm-pref-btn ptm-inv ptm-feedback-btn']")
	private WebElement skip;
	@FindBy(xpath="//div[@class='ord-msg-head']")
	private WebElement fail;
	@FindBy(xpath="//div[@class='ord-msg-bpara']")
	private WebElement process;
	@FindBy(xpath="//a[text()='Try Again']")
	private WebElement tAgain;
	@FindBy(xpath="//a[@class='mb-header__main__logo__link']")
	private WebElement mbHeader;
	public PaymentGateway(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	public void getOrderId() {
        try {
            String packageName = packageNamePGI.getText();
            String orderID = orderId.getText();
            String totalPrice = price.getText();
            System.out.println("Package Name on payment gateway is Found: '" 
            		+ packageName + "'\nOrder id on gateway is Found: " 
            		+ orderID + "\nTotal Price on payment gateway is Found: " 
            		+ totalPrice);
        } catch (NoSuchElementException e) {
            System.out.println("Order ID not found.");
            
        }
    }
	public void selectGateway() {
		wait.until(ExpectedConditions.elementToBeClickable(wallet)).click();
	}
	public void clickContinue() {
		wait.until(ExpectedConditions.elementToBeClickable(cont)).click();
	}
	public void okayGotIt() {
		wait.until(ExpectedConditions.elementToBeClickable(gotIt)).click();
	}
	public void backPaytm() {
		wait.until(ExpectedConditions.visibilityOf(paytmBack));
		wait.until(ExpectedConditions.elementToBeClickable(paytmBack)).click();
	}
	public void skipPayment() {
		wait.until(ExpectedConditions.visibilityOf(skip));
		wait.until(ExpectedConditions.elementToBeClickable(skip)).click();
	}
	public void paymentScreen() {
		System.out.println("Gateway Status: "+ fail.getText());
	}
	public void paymentMessage() {
		System.out.println("Gateway Message: "+ process.getText());
	}
	public void tryAgain() {
		wait.until(ExpectedConditions.elementToBeClickable(tAgain)).click();
	}
	public void reachMbHome() {
		wait.until(ExpectedConditions.elementToBeClickable(mbHeader)).click();
	}
	
	
	
}
