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

    public static WebDriver driver;
    public WebDriverWait wait;
    public static Properties config;


    public void setup() throws Exception {
        WebDriverManager.chromedriver().setup();
        loadConfig();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver.get(config.getProperty("url"));
    }

    public void ScrollToElement(WebElement String) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", String);
    }
    

    public void SwitchOnTab() {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowList.get(windowList.size() - 1));
    }

    public void ReloadPage()
    {
        driver.navigate().refresh();

    }
    
    static void loadConfig() throws Exception {
        FileInputStream file = new FileInputStream("src\\main\\resources\\config.properties");
        config = new Properties();
        config.load(file);
        file.close();
    }
    
    
    public String captureScreenshot(String testName) throws IOException {
    	try {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "C:\\Users\\Deepak.Kumar\\eclipse-workspace\\Bricks\\screenshots\\" + testName + "_" + timestamp + ".png";
        FileUtils.copyFile(screenshot, new File(filePath));
        System.out.println("📸 Screenshot saved: " + filePath);
        File destination = new File(filePath);
        FileUtils.copyFile(screenshot, destination);
        return filePath;
        } catch (Exception e) {
       	 System.out.printf("❌ Failed to take screenshot.", e);
    }
		return testName;

    }
    public void writeResultToExcel(String testName, String status) {
        String filePath = "C:\\Users\\Deepak.Kumar\\Documents\\Testresults.csv";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(testName).append(",").append(status).append("\n");
            writer.flush();
            System.out.println("📄 Test result saved: " + testName + " - " + status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
   

       
