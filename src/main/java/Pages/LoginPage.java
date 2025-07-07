package Pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

 WebDriver driver;
 WebDriverWait wait;


    @FindBy(xpath="//label[text()='Agent/Builder']")
    private WebElement agent_Builder;
    
    @FindBy(xpath="//input[@id='emailOrMobile']")
    private WebElement emailOrMobile;
    
    @FindBy(xpath="//button[@id='btnStep1']")
    private WebElement nextButton;
    
    @FindBy(xpath="//input[@id='password']")
    private WebElement password;
    
    @FindBy(xpath="//button[@id='btnLogin']")
    private WebElement loginButton;
    
    @FindBy(xpath="//div[@id='captchaCodeSignIn']")
    private WebElement clickCaptcha;
    
    @FindBy(xpath="//div[@id='commentCaptchaErrSignIn']")
    private WebElement captchaError;
    
    @FindBy(xpath="//button[text()='Continue']")
    private WebElement continueButton;
    
    @FindBy(xpath="(//a[text()='Sign Up'])[2]")
    private WebElement signUp;
    
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
    }
    
    public void selectAgent_Builder() {
        wait.until(ExpectedConditions.elementToBeClickable(agent_Builder)).click();
    }
   
    public void enterEmailOrMobile(String userName) {
        emailOrMobile.sendKeys(userName);

    }
    
    public void captchaError() throws InterruptedException {
           
            
        while (captchaError.isDisplayed()) {
             clickCaptcha.click();
             Thread.sleep(8000);
                nextButton.click();
                
            }
        }
    
    public void clickOnNextButton() {
        nextButton.click();
    }
    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }
    
    public void clickLoginButton() {
        loginButton.click();
    }
    
    public void clickOnContinueButton() {
        continueButton.click();
    }
    
    public void clickOnSignUp() {
        signUp.click();
        
                           }
    }