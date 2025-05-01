package Pages;


import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReachMbHome extends BaseTest {

//Instance variable	
				public WebDriver driver;
				public WebDriverWait wait;
//xpath declaration section 		
		@FindBy(xpath="(//div[@class='mbB2cPS__close'])")
		private WebElement grid;
		@FindBy(xpath="(//div[@class='custGrid-contact__pop-up--close'])")
		private WebElement grid1;
		@FindBy(xpath="(//div[@class='custGrid-contact__pop-up--close'])")
		private WebElement skipIapprove;
		@FindBy(xpath="(//a[@data-testid='header-logo-link' and contains(@href, 'https://www.magicbricks.com')])")
		private WebElement mb;
		@FindBy(xpath="(//div[@class='onmodal__cross'])")
		private WebElement closeOnmodel;
		@FindBy(xpath="((//a[@class='mb-header__sub__tabs__link js-menu-link' and text()='Sell'])[1])")
		private WebElement sellTab;
		@FindBy(xpath="((//a[@href='https://www.magicbricks.com/advertise-with-us'])[1])")
		private WebElement adPackage;
	
		
		
		
	
		public ReachMbHome(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
//methods of classes		
		public void closeGrid() {
	        try {
	            if (grid.isDisplayed()) {
	                grid.click();
	            } else {
	                skipIapprove.click();	
	            }
	        } catch (NoSuchElementException e) {
	            System.out.println("Grid element not found, skipping.");
	           
	        }
	    }

	    public void closeGrid1() {
	        try {
	            if (grid1.isDisplayed()) {
	                grid1.click();
	            }
	        } catch (NoSuchElementException e) {
	            System.out.println("Grid1 element not found, skipping.");
	            
	            
	        }
	    }
	    

		public void clickMb() {
			wait.until(ExpectedConditions.elementToBeClickable(mb)).click();
	}
		public void closePoupMbHome() {
			wait.until(ExpectedConditions.elementToBeClickable(closeOnmodel)).click();
	}
			public void clickSellTab() {
				wait.until(ExpectedConditions.elementToBeClickable(sellTab)).click();
			}
			public void clickAdPackage() {
				wait.until(ExpectedConditions.visibilityOf(adPackage));
				wait.until(ExpectedConditions.elementToBeClickable(adPackage)).click();
//To Handle new Window 
				SwitchOnTab();
	      		
	}
}

