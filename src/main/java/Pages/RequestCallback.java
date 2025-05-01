package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestCallback extends BaseTest{

	public WebDriver driver;
	@FindBy(xpath="(//input[@id='userName'])")
	private WebElement name;
	@FindBy(xpath="(//input[@id='phoneNumber'])")
	private WebElement mobile;
	@FindBy(xpath="(//input[@name='email'])")
	private WebElement email;
	@FindBy(xpath="(//input[@id='keyword'])")
	private WebElement city;
	@FindBy(xpath="(//textarea[@id='query'])")
	private WebElement query;
	@FindBy(xpath="(//label[@for='chk-TNC'])")
	private WebElement checkbox;
	@FindBy(xpath="(//input[@id='callBackSubmit'])")
	private WebElement callback;
	@FindBy(xpath="(//p[@class='thxHeading'])")
	private WebElement thankYouMessage;
	
	
	public RequestCallback(WebDriver driver){
		PageFactory.initElements(driver, this);
			this.driver=driver;
	}
	
	public void enterName(String Name) {
		name.sendKeys(Name);
	}
	public void enterMobile(String MobileNo) {
		 mobile.sendKeys(String.valueOf(MobileNo));
	}
	public void enterEmail(String EmailId) {
		email.sendKeys(EmailId);
	}
	public void enterCity(String cityName) {
		city.sendKeys(cityName);
	}
	public void enterQuery(String Query) {
		query.sendKeys(Query);
	}
	public void selectCheckbox() {
		checkbox.click();
	}
	public void submitCallback() {
		callback.click();
	}
	public void getThankYou() {
		 try {
			 System.out.println("Request callback form status....." + thankYouMessage.getText());
	        } catch (NoSuchElementException e) {
	        	System.out.println("Request is not submitting.");
	        }
		
}
}
