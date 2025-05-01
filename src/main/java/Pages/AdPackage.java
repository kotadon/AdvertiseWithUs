package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AdPackage {
	private String gridPrice;
	@FindBy(xpath="(//label[@for='sell1'])")
	private WebElement sell;
	@FindBy(xpath="(//label[@for='rent1'])")
	private WebElement rent;
	
	@FindBy(xpath ="(//div[@class='divInner' and text()='Silver'])[4]")
	private WebElement silver;
	@FindBy(xpath= "(//div[@class='divInner' and text()='Silver Plus'])[4]")
	private WebElement silverPlus;
	@FindBy(xpath= "(//div[@class='divInner' and normalize-space()='Gold Plus'])[3]")
	private WebElement goldPlus;
	@FindBy(xpath= "(//div[@class='divInner' and text()[normalize-space()='Titanium Plus']])[4]")
	private WebElement titaniumPlus;
	@FindBy(xpath= "(//div[@class='divInner' and text()='Super Titanium'])[4]")
	private WebElement superTitanium;
	
	@FindBy(xpath ="(//div[@class='divInner' and text()='Silver'])[2]")
	private WebElement silver1;
	@FindBy(xpath= "(//div[@class='divInner' and text()='Silver Plus'])[2]")
	private WebElement silverPlus1;
	@FindBy(xpath= "(//div[@class='divInner' and normalize-space()='Gold Plus'])[2]")
	private WebElement goldPlus1;
	@FindBy(xpath= "(//div[@class='divInner' and text()[normalize-space()='Titanium Plus']])[2]")
	private WebElement titaniumPlus1;
	@FindBy(xpath= "(//div[@class='divInner' and text()='Super Titanium'])[2]")
	private WebElement superTitanium1;
	
	@FindBy(xpath ="(//div[@class='divInner' and text()='Silver'])[3]")
	private WebElement silver2;
	@FindBy(xpath= "(//div[@class='divInner' and text()='Silver Plus'])[3]")
	private WebElement silverPlus2;
	@FindBy(xpath= "(//div[@class='divInner' and text()[normalize-space()='Titanium Plus']])[3]")
	private WebElement titaniumPlus2;
	@FindBy(xpath= "(//div[@class='divInner' and text()='Super Titanium'])[3]")
	private WebElement superTitanium2;
	
	@FindBy(xpath ="(//div[@class='divInner' and text()='Silver'])[1]")
	private WebElement silver3;
	@FindBy(xpath= "(//div[@class='divInner' and text()='Silver Plus'])[1]")
	private WebElement silverPlus3;
	@FindBy(xpath= "(//div[@class='divInner' and text()[normalize-space()='Gold Plus']])[1]")
	private WebElement goldPlus3;
	@FindBy(xpath= "(//div[@class='divInner' and text()[normalize-space()='Titanium Plus']])[1]")
	private WebElement titaniumPlus3;
	@FindBy(xpath= "(//div[@class='divInner' and text()='Super Titanium'])[1]")
	private WebElement superTitanium3;
	
	
	
	@FindBy(xpath="(//label[input[@value='residential']])")
	private WebElement residential;
	@FindBy(xpath="(//label[input[@value='commercial']])")
	private WebElement commercial;
	
	@FindBy(xpath="(//a[contains(@href, 'packageGroup.html?Package=50242')])")
	private WebElement sellR;
	@FindBy(xpath="(//a[contains(@href, 'packageGroup.html?Package=50663')])")
	private WebElement sellC;
	@FindBy(xpath="(//a[contains(@href, 'packageGroup.html?Package=50665')])")
	private WebElement rentR;
	@FindBy(xpath="(//a[contains(@href, 'packageGroup.html?Package=50845')])")
	private WebElement rentC;
	
	@FindBy(xpath="//div[@class='pkg-restriction-widget__inner']")
	private WebElement title;
	@FindBy(xpath="//span[@id='_packagename']")
	private WebElement titleP;
	@FindBy(xpath="//div[@class='lisPriceOffer']")
	private WebElement titlePrice;
	@FindBy(xpath="//input[@id='selectedServicesAddOnId0']")
	private WebElement addPackage;
	@FindBy(xpath="//a[@class='addToCartBtn _addToCartBtn']")
	private WebElement addCart;
	@FindBy(xpath="//a[text()='GO TO CHECKOUT']")
	private WebElement checkout;
	@FindBy(xpath="//a[@class='b2c-cart__action--btn btn-red large _proceedtopayment']")
	private WebElement proceedPayment;
	@FindBy(xpath="(//div[@class='divInner pkgPriceText' and contains(text(), '₹')])[15]")
	private WebElement srGridPrice;
	@FindBy(xpath="(//div[@class='divInner pkgPriceText' and contains(text(), '₹')])[6]")
	private WebElement scGridPrice;
	@FindBy(xpath="(//div[@class='divInner pkgPriceText' and contains(text(), '₹')])[11]")
	private WebElement rrGridPrice;
	@FindBy(xpath="(//div[@class='divInner pkgPriceText' and contains(text(), '₹')])[1]")
	private WebElement rcGridPrice;
	
	
	public AdPackage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void selectSell() {
		
		sell.click();
	}
	public void selectRent() {
		
		rent.click();
	}
	public void selectResidential() {
		
		residential.click();
	}
	public void selectCommercial() {
		
		commercial.click();
	}
	public void srGrid() {
		
		 String gridPriceRaw = srGridPrice.getText().replaceAll("[^\\d.]", ""); 
		 gridPrice = gridPriceRaw;
		
		System.out.println("Silver Package Price on Grid incase of Sell-Residential : " + gridPrice);
	    
		sellR.click();
	}
	public void scGrid() {
		
		String gridPriceRaw = scGridPrice.getText().replaceAll("[^\\d.]", ""); 
		 gridPrice = gridPriceRaw;
		
		System.out.println("Silver Package Price on Grid incase of Sell-Commercial : " + gridPrice);
		sellC.click();
	}
	public void rrGrid() {
		String gridPriceRaw = rrGridPrice.getText().replaceAll("[^\\d.]", ""); 
		 gridPrice = gridPriceRaw;
		
		System.out.println("Silver Package Price on Grid incase of Rent-Residential : " + gridPrice);
		rentR.click();
	}
	public void rcGrid() {
		String gridPriceRaw = rcGridPrice.getText().replaceAll("[^\\d.]", ""); 
		 gridPrice = gridPriceRaw;
		
		System.out.println("Silver Package Price on Grid incase of Rent-Commercial : " + gridPrice);
		rentC.click();
	}
	
	public void srPackages() {
        System.out.println("Available Packages on Grid: ");
        System.out.println("1. " + silver.getText());
        System.out.println("2. " + silverPlus.getText());
        System.out.println("3. " + goldPlus.getText());
        System.out.println("4. " + titaniumPlus.getText());
        System.out.println("5. " + superTitanium.getText());
    }
	public void scPackages() {
        System.out.println("Available Packages on Grid: ");
        System.out.println("1. " + silver1.getText());
        System.out.println("2. " + silverPlus1.getText());
        System.out.println("3. " + goldPlus1.getText());
        System.out.println("4. " + titaniumPlus1.getText());
        System.out.println("5. " + superTitanium1.getText());
    }
	public void rrPackages() {
        System.out.println("Available Packages on Grid: ");
        System.out.println("1. " + silver2.getText());
        System.out.println("2. " + silverPlus2.getText());
        System.out.println("3. " + titaniumPlus2.getText());
        System.out.println("4. " + superTitanium2.getText());
    }
	public void rcPackages() {
        System.out.println("Available Packages on Grid: ");
        System.out.println("1. " + silver3.getText());
        System.out.println("2. " + silverPlus3.getText());
        System.out.println("3. " + goldPlus3.getText());
        System.out.println("4. " + titaniumPlus3.getText());
        System.out.println("5. " + superTitanium3.getText());
    }
	public void getTitle() {
		
		try {
			
			System.out.println("Package Title is Found on Cart Page: " + title.getText());
	        } catch (NoSuchElementException e) {
	        	System.out.println("Package Title is not Found on Cart Page.");
	        }
	}
	public void getPackageName() {
		
		try {
			System.out.println("Package Name is Found on Cart Page: " +titleP.getText());
	        } catch (NoSuchElementException e) {
	        	System.out.println("Package Name is not Found on Cart Page.");
	        }
	}
	public void cartPage () {
		
		try {
			
			String cartPriceRaw = titlePrice.getText().replaceAll("[^\\d.]", ""); 
			double cartPrice = Double.parseDouble(cartPriceRaw);
			double gridPriceDouble = Double.parseDouble(gridPrice);
		    Assert.assertEquals(gridPriceDouble, cartPrice, "Test Failed! Package is not found on Cart Page");
		    System.out.println("✅ Package Price is matching on Cart Page with Grid Price ");
			System.out.println("Package Price is on Cart Page: "+ cartPrice);
			
	        } catch (NoSuchElementException e) {
	        	System.out.println("Package Price is not Found on Cart Page.");
	        }
	}
	public void addOns() {
		addPackage.click();   
	}
	public void addToCart() {
		addCart.click();
	}
	public void goToCheckout() {
		checkout.click();
	}
	public void proceedToPayment() {
		proceedPayment.click();
	}
	
}
