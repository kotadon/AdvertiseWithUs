package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	private static final Logger log = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;
    public WebDriverWait wait;
    public static Properties config;


    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        loadConfig();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        log.info("✅ Browser launched and maximized");

        String url = config.getProperty("url");
        log.info("Navigating to URL: {}", url);
        driver.get(url);
    }

    public void ScrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        log.info("Scrolled to element: {}", element);
    }
    

    public void SwitchOnTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowList.get(windowList.size() - 1));
        log.info("Switched to new browser tab");
    }

    public void ReloadPage()
    {
        driver.navigate().refresh();
        log.info("Page reloaded");

    }
    
    static void loadConfig() throws Exception {
        FileInputStream file = new FileInputStream("src\\main\\resources\\config.properties");
        config = new Properties();
        config.load(file);
        file.close();
        log.info("✅ Config file loaded");
    }
    
    
    public String captureScreenshot(String testName) throws IOException {
    	try {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "C:\\Users\\Deepak.Kumar\\eclipse-workspace\\Bricks\\screenshots\\" + testName + "_" + timestamp + ".png";
        File destination = new File(filePath);
        FileUtils.copyFile(screenshot, destination);
        System.out.println("📸 Screenshot saved: " + filePath);
        return filePath;
        
    	} catch (IOException e) {
    		 log.error("❌ Failed to take screenshot: {}", e.getMessage(), e);
            throw e;  // Let the caller handle it
        } catch (Exception e) {
        	log.error("❌ Unexpected error during screenshot: {}", e.getMessage(), e);
        }

        return null;  // Return null if something failed
    }
    public void writeResultToExcel(String testName, String status) {
        String filePath = "C:\\Users\\Deepak.Kumar\\Documents\\Testresults.csv";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(testName).append(",").append(status).append("\n");
            writer.flush();
            log.info("📄 Test result saved: {} - {}", testName, status);
        } catch (IOException e) {
        	log.error("❌ Error writing result to CSV: {}", e.getMessage(), e);
        }
    }
    
}
   

       
