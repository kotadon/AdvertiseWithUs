package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MorePackages extends BaseTest {

	public WebDriver driver;
	public WebDriverWait wait;
	
	
	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	@FindBy(xpath="//div[contains(text(), 'Special Packages')]")
	private WebElement specialP;
	@FindBy(xpath="(//div[@class='specialPackagesText'])[1]")
	private WebElement pg;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[1]")
	private WebElement pgPrice;
	
	@FindBy(xpath="(//div[@class='specialPackagesText'])[2]")
	private WebElement luxury;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[2]")
	private WebElement luxuryPrice;
	
	@FindBy(xpath="(//div[@class='specialPackagesText'])[3]")
	private WebElement silver;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[3]")
	private WebElement silverPrice;
	
	@FindBy(xpath="(//div[@class='specialPackagesText'])[4]")
	private WebElement insta;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[4]")
	private WebElement instaPrice;
	
	@FindBy(xpath="(//div[@class='specialPackagesText'])[5]")
	private WebElement longTerm;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[5]")
	private WebElement longPrice;
	
	@FindBy(xpath="(//div[@class='specialPackagesText'])[6]")
	private WebElement online;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[6]")
	private WebElement onlinePrice;
	
	@FindBy(xpath="(//div[@class='specialPackagesText'])[7]")
	private WebElement instaSell;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[7]")
	private WebElement instaSellPrice;
	
	@FindBy(xpath="(//div[@class='specialPackagesText'])[8]")
	private WebElement longSell;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[8]")
	private WebElement longSellPrice;
	
	
	@FindBy(xpath="(//div[@class='swiper-button-next'])")
	private WebElement swiper;
	
	@FindBy(xpath="//div[contains(text(), 'Value Added Packages')]")
	private WebElement valueP;
	
	
	@FindBy(xpath="(//div[@class='valueAddedPkgCon'])[1]")
	private WebElement knowYour;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[9]")
	private WebElement knowYourPrice;
	@FindBy(xpath="(//div[@class='valueAddedPkgCon'])[2]")
	private WebElement prop;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[10]")
	private WebElement propPrice;
	@FindBy(xpath="(//div[@class='valueAddedPkgCon'])[3]")
	private WebElement legelService;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[11]")
	private WebElement legelServicePrice;
	@FindBy(xpath="(//div[@class='valueAddedPkgCon'])[4]")
	private WebElement propertyAstro;
	@FindBy(xpath="(//div[@class='valueAddedPkgPrice'])[12]")
	private WebElement propertyAstroPrice;
			
	public MorePackages(WebDriver driver){
		 this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
	}
	public void specialPackage() {
		String actualResult6 = specialP.getText();
        String expectedResult6 = "Special Packages";
        Assert.assertEquals(actualResult6, expectedResult6, "Test Failed! Special Packages section is not found");
        System.out.println("✅ Special Packages section is Found ");
        
		String actualResult = pg.getText();
		String actualResult1 = pgPrice.getText();
        String expectedResult = config.getProperty("pg.description");
        String expectedResult1 = config.getProperty("pg.price");
        Assert.assertEquals(actualResult, expectedResult, "Test Failed! PG Package is not found");
        System.out.println("✅ PG package is Found");
        Assert.assertEquals(actualResult1, expectedResult1, "Test Failed! PG Package Price is not Matching");
        System.out.println("✅ PG package Price is Matching and Price are: " + actualResult1);
        
        String actualResult2 = luxury.getText();
		String actualResult3 = luxuryPrice.getText();
        String expectedResult2 = config.getProperty("luxury.description");
        String expectedResult3 = config.getProperty("luxury.price");
        Assert.assertEquals(actualResult2, expectedResult2, "Test Failed! Luxury Listing Package is not found");
        System.out.println("✅ Luxury Listing package is Found");
        Assert.assertEquals(actualResult3, expectedResult3, "Test Failed! Luxury Listing Package Price is not Matching");
        System.out.println("✅ Luxury Listing package Price is Matching and Price are: " + actualResult3);
        
        String actualResult4 = silver.getText();
		String actualResult5 = silverPrice.getText();
		String expectedResult4 = config.getProperty("silver.discription");
        String expectedResult5 = config.getProperty("silver.price");
        Assert.assertEquals(actualResult4, expectedResult4, "Test Failed! Silver Mailer Combo Package is not found");
        System.out.println("✅ Silver Mailer Combo package is Found");
        Assert.assertEquals(actualResult5, expectedResult5, "Test Failed! Silver Mailer Combo Package Price is not Matching");
        System.out.println("✅ Silver Mailer Combo package Price is Matching and Price are: " +actualResult5);
           
}
	public void swipes() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(swiper)).click();
            System.out.println("✅ Swiped successfully.");
        } catch (Exception e) {
            System.out.println("❌ Failed to swipe. " + e.getMessage());
        }
	}
	
	 public void specialPackage1() {
		 wait.until(ExpectedConditions.visibilityOf(insta));
			String actualResult = insta.getText();
			String actualResult1 = instaPrice.getText();
	        String expectedResult = config.getProperty("insta.discription");
	        String expectedResult1 = config.getProperty("insta.price");
	        Assert.assertEquals(actualResult, expectedResult, "Test Failed! Insta Package is not found");
	        System.out.println("✅ Insta package is Found");
	        Assert.assertEquals(actualResult1, expectedResult1, "Test Failed! Insta Package Price is not Matching");
	        System.out.println("✅ Insta package Price is Matching and Price are: " +actualResult1);
	        
	        String actualResult2 = longTerm.getText();
			String actualResult3 = longPrice.getText();
	        String expectedResult2 = config.getProperty("long.discription");
	        String expectedResult3 = config.getProperty("long.price");
	        Assert.assertEquals(actualResult2, expectedResult2, "Test Failed! Long Term Sale Listing Package is not found");
	        System.out.println("✅ Long Term Sale Listing package is Found");
	        Assert.assertEquals(actualResult3, expectedResult3, "Test Failed! Long Term Sale Listing Package Price is not Matching");
	        System.out.println("✅ Long Term Sale Listing package Price is Matching and Price are: " +actualResult3);
	         
	        String actualResult4 = online.getText();
			String actualResult5 = onlinePrice.getText();
	        String expectedResult4 = config.getProperty("online.discription");
	        String expectedResult5 = config.getProperty("online.price");
	        Assert.assertEquals(actualResult4, expectedResult4, "Test Failed! Online-Offline Ad Combo Package is not found");
	        System.out.println("✅ Online-Offline Ad Combo package is Found");
	        Assert.assertEquals(actualResult5, expectedResult5, "Test Failed! Online-Offline Ad Combo Package Price is not Matching");
	        System.out.println("✅ Online-Offline Ad Combo package Price is Matching and Price are: " +actualResult5);
}
	 
	 public void specialPackage2() {
		 wait.until(ExpectedConditions.visibilityOf(instaSell));
			String actualResult = instaSell.getText();
			String actualResult1 = instaSellPrice.getText();
	        String expectedResult = config.getProperty("insta.discription");
	        String expectedResult1 =  config.getProperty("insta.price");
	        Assert.assertEquals(actualResult, expectedResult, "Test Failed! Insta Sell Package is not found");
	        System.out.println("✅ Insta Sell package is Found");
	        Assert.assertEquals(actualResult1, expectedResult1, "Test Failed! Insta Sell Package Price is not Matching");
	        System.out.println("✅ Insta Insta Sell Price is Matching and Price are: " +actualResult1);
	        
	        String actualResult2 = longSell.getText();
			String actualResult3 = longSellPrice.getText();
	        String expectedResult2 = config.getProperty("longsell.discription");
	        String expectedResult3 = config.getProperty("longsell.price");
	        Assert.assertEquals(actualResult2, expectedResult2, "Test Failed! Long Term Sale Listing Package is not found");
	        System.out.println("✅ Long Term Sale Listing package is Found");
	        Assert.assertEquals(actualResult3, expectedResult3, "Test Failed! Long Term Sale Listing Package Price is not Matching");
	        System.out.println("✅ Long Term Sale Listing package Price is Matching and Price are: " +actualResult3);
	 }
	 public void ValuePackages() {
		 String actualResult = valueP.getText();
	        String expectedResult = "Value Added Packages";
	        Assert.assertEquals(actualResult, expectedResult, "Test Failed! Value Added Packages section is not found");
	        System.out.println("✅ Value Added Packages section is Found");
	        
	        String actualResult1 = knowYour.getText();
			String actualResult2 = knowYourPrice.getText();
	        String expectedResult1 = config.getProperty("know.discription");
	        String expectedResult2 = config.getProperty("know.price");
	        Assert.assertEquals(actualResult1, expectedResult1, "Test Failed! Know Your Tenant Package is not found");
	        System.out.println("✅ Know Your Tenant package is Found");
	        Assert.assertEquals(actualResult2, expectedResult2, "Test Failed! Know Your Tenant Package Price is not Matching");
	        System.out.println("✅ Know Your Tenant package Price is Matching and Price are: " +actualResult2);
	        
	        String actualResult3 = prop.getText();
			String actualResult4 = propPrice.getText();
	        String expectedResult3 = config.getProperty("prop.discription");
	        String expectedResult4 = config.getProperty("prop.price");
	        Assert.assertEquals(actualResult3, expectedResult3, "Test Failed! Property Evaluation Package is not found");
	        System.out.println("✅ Property Evaluation package is Found");
	        Assert.assertEquals(actualResult4, expectedResult4, "Test Failed! Property Evaluation Price is not Matching");
	        System.out.println("✅ Property Evaluation package Price is Matching and Price are: " +actualResult4);
	        
	        String actualResult5 = legelService.getText();
			String actualResult6 = legelServicePrice.getText();
	        String expectedResult5 = config.getProperty("legal.discription");
	        String expectedResult6 = config.getProperty("legal.price");
	        Assert.assertEquals(actualResult5, expectedResult5, "Test Failed! Legal Services Package is not found");
	        System.out.println("✅ Legal Services package is Found");
	        Assert.assertEquals(actualResult6, expectedResult6, "Test Failed! Legal Services Package Price is not Matching");
	        System.out.println("✅ Legal Services package Price is Matching and Price are: " +actualResult6);
	        
	        String actualResult7 = propertyAstro.getText();
			String actualResult8 = propertyAstroPrice.getText();
	        String expectedResult7 = config.getProperty("property.discription");
	        String expectedResult8 = config.getProperty("property.price");
	        Assert.assertEquals(actualResult7, expectedResult7, "Test Failed! Property Astrology Package is not found");
	        System.out.println("✅ Property Astrology package is Found");
	        Assert.assertEquals(actualResult8, expectedResult8, "Test Failed! Property Astrology Package Price is not Matching");
	        System.out.println("✅ Property Astrology package Price is Matching and Price are: " +actualResult8);
	 }
}
