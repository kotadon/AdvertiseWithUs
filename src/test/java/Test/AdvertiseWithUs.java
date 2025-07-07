package Test;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import Pages.ReachMbHome;
import Pages.AdPackage;
import Pages.BaseTest;
import Pages.LoginPage;
import Pages.PaymentGateway;
import Pages.RequestCallback;
import Pages.TestListener;
import Pages.MorePackages;

@Listeners(TestListener.class)

public class AdvertiseWithUs extends BaseTest {

	private static final Logger log = LogManager.getLogger(AdvertiseWithUs.class); // Logger instance

	ReachMbHome reachMbHome;
	AdPackage adPackage;
	PaymentGateway paymentGateway;
	RequestCallback requestCallback;
	LoginPage loginPage;
	MorePackages morePackages;
	WebDriverWait wait;

	@BeforeClass
	public void setUpBrowser() throws Exception {
		 try {
			 	log.info("✅ Browser setup Started.");
		        setup();
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		        initializePages();
		        login();
		        log.info("✅ Browser setup completed and pages initialized.");
		    } catch (Exception e) {
		        log.error("❌ Error during setup: {}", e.getMessage());
		        throw e;
		    }
		}

	@BeforeMethod
	private void initializePages() {
		loginPage = new LoginPage(driver);
		reachMbHome = new ReachMbHome(driver);
		adPackage = new AdPackage(driver);
		paymentGateway = new PaymentGateway(driver);
		requestCallback = new RequestCallback(driver);
		morePackages = new MorePackages(driver);
		log.info("✅ All page objects initialized.");
	}

	@Test(priority = 1, description="Verified- Sell Residential B2C end-to-end Flow and SendRequest Flow") 
	public void testSellResidentialAdFlow() {
		try {
			executeAdAndPayment("Sell", "Residential");
			log.info("✅ Sell - Residential ad flow completed.");
		} catch (Exception e) {
			log.error("❌ Sell - Residential ad flow failed.", e);
			throw new RuntimeException(e); 
		}
	}

	@Test(priority = 2, description="Verified- Sell Commercial B2C end-to-end Flow and SendRequest Flow")
	public void testSellCommercialAdFlow() {
		try {
			executeAdAndPayment1("Sell", "Commercial");
			log.info("✅ Sell - Commercial ad flow completed.");
			 
		} catch (Exception e) {
			log.error("❌ Sell - Commercial ad flow failed.", e);
			throw new RuntimeException(e);
		}
	}

	@Test(priority = 3, description="Verified- Rent Residential B2C end-to-end Flow and SendRequest Flow")
	public void testRentResidentialAdFlow() {
		try {
			executeAdAndPayment1("Rent", "Residential");
			log.info("✅ Rent - Residential ad flow completed.");
		} catch (Exception e) {
			log.error("❌ Rent - Residential ad flow failed.", e);
			throw new RuntimeException(e);
		}
	}

	@Test(priority = 4, description="Verified- Rent Commercial B2C end-to-end Flow and SendRequest Flow")
	public void testRentCommercialAdFlow() {
		try {
			executeAdAndPayment1("Rent", "Commercial");
			log.info("✅ Rent - Commercial ad flow completed.");
		} catch (Exception e) {
			log.error("❌ Rent - Commercial ad flow failed.", e);
			throw new RuntimeException(e);
		}
	}

	public void login() throws InterruptedException {
		log.info("🚀 Starting login process with user: {}", config.getProperty("userName"));
		loginPage.selectAgent_Builder();
		loginPage.enterEmailOrMobile(config.getProperty("userName"));
		loginPage.clickOnNextButton();
		loginPage.captchaError();
		loginPage.enterPassword(config.getProperty("pass"));
		loginPage.clickLoginButton();
		log.info("✅ User {} successfully logged in.", config.getProperty("userName"));
	}

	@AfterTest
	public void teardown() {
	    try {
	        if (driver != null) {
	            driver.quit();
	            log.info("✅ Browser closed successfully.");
	        }
	    } catch (Exception e) {
	        log.error("❌ Error while closing the browser: " + e.getMessage());
	    }
	}

	private void executeAdAndPayment(String type, String category) {
		log.info("🚀 Executing {} - {} ad flow...", type, category);
		reachMbHome.closeGrid();
		reachMbHome.clickMb();
		reachMbHome.closePoupMbHome();
		reachMbHome.clickSellTab();
		reachMbHome.clickAdPackage();

		selectPropertyTypeAndCategory(type, category);
		submitRequestCallback();
		selectPackage(type, category);
		processPaymentFlow();
	}

	private void executeAdAndPayment1(String type, String category)  {
		log.info("🚀 Executing {} - {} ad flow...", type, category);
		reachMbHome.clickSellTab();
		reachMbHome.clickAdPackage();

		selectPropertyTypeAndCategory(type, category);
		submitRequestCallback();
		selectPackage(type, category);
		processPaymentFlow();
	}

	private void selectPropertyTypeAndCategory(String type, String category) {
		if (type.equalsIgnoreCase("Sell")) {
			adPackage.selectSell();
		} else {
			adPackage.selectRent();
		}

		if (category.equalsIgnoreCase("Residential")) {
			adPackage.selectResidential();
		} else {
			adPackage.selectCommercial();
		}
	}

	private void submitRequestCallback() {
		log.info("🚀 Submitting request callback...");
		requestCallback.enterName(config.getProperty("Name"));
		requestCallback.enterMobile(config.getProperty("MobileNo"));
		requestCallback.enterEmail(config.getProperty("EmailId"));
		requestCallback.enterCity(config.getProperty("cityName"));
		requestCallback.enterQuery(config.getProperty("Query"));

		scroll(200);
		requestCallback.selectCheckbox();
		requestCallback.submitCallback();
		requestCallback.getThankYou();
		scroll(-200);

		log.info("✅ Request callback submitted successfully.");
	}

	private void selectPackage(String type, String category) {
		log.info("🚀 Selecting {} package for {} category", type, category);

		if (type.equalsIgnoreCase("Sell") && category.equalsIgnoreCase("Residential")) {
			adPackage.srPackages();
		} else if (type.equalsIgnoreCase("Sell") && category.equalsIgnoreCase("Commercial")) {
			adPackage.scPackages();
		} else if (type.equalsIgnoreCase("Rent") && category.equalsIgnoreCase("Residential")) {
			adPackage.rrPackages();
		} else {
			adPackage.rcPackages();
		}

		scroll(1100);
		morePackages.specialPackage();
		morePackages.swipes();
		morePackages.specialPackage1();
		morePackages.swipes();
		morePackages.specialPackage2();

		scroll(400);
		morePackages.ValuePackages();
		scroll(-400);

		executeCategorySelection(type, category);

		submitRequestCallback();
		adPackage.getTitle();
		adPackage.getPackageName();
		adPackage.cartPage();
		adPackage.addOns();
		scroll(400);
		adPackage.addToCart();
		adPackage.goToCheckout();
		adPackage.proceedToPayment();
		log.info("✅ Package selection completed.");
	}

	private void executeCategorySelection(String type, String category) {
		switch (type.toLowerCase() + "-" + category.toLowerCase()) {
		case "sell-residential":
			adPackage.srGrid();
			break;
		case "sell-commercial":
			adPackage.scGrid();
			break;
		case "rent-residential":
			adPackage.rrGrid();
			break;
		case "rent-commercial":
			adPackage.rcGrid();
			break;
		default:
			log.error("Invalid property type/category combination.");
		}
	}

	private void processPaymentFlow() {
		log.info("🚀 Starting payment process...");
		processPayment();
		paymentGateway.tryAgain();
		processPayment();
		log.info("✅ Payment process completed.");
		paymentGateway.reachMbHome();
	}

	private void processPayment() {
		log.info("🚀 Processing payment...");
		paymentGateway.getOrderId();
		paymentGateway.selectGateway();
		paymentGateway.clickContinue();
		paymentGateway.backPaytm();
		paymentGateway.skipPayment();
		paymentGateway.paymentScreen();
		paymentGateway.paymentMessage();
		log.info("✅ Payment process executed successfully.");
	}

	private void scroll(int y) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + y + ");");
		log.info("Scrolled {} pixels.", y);
	}
}
