package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.util.Properties;

public class Base {

    public static Properties prop;

    public static WebDriver driver;

    private static final ThreadLocal<WebDriver> PAGE_DRIVER = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){

        Base.PAGE_DRIVER.set(driver);
    }

    public static WebDriver getDriver(){
        return PAGE_DRIVER.get();
    }

    public Base(){
        loadProperties();
    }

    /**
     *
     * @return the browser instance defined in the config.properties file
     */
    public static WebDriver getBrowser(){

        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("Chrome")){
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--headless=new");
            driver = WebDriverManager.chromedriver().capabilities(opt).create();
            setDriver(driver);

        } else if (browserName.equalsIgnoreCase("Firefox")){
            FirefoxOptions opt = new FirefoxOptions();
            driver = WebDriverManager.firefoxdriver().capabilities(opt).create();
            setDriver(driver);

        } else if (browserName.equalsIgnoreCase("Edge")){
            EdgeOptions opt = new EdgeOptions();
            driver = WebDriverManager.edgedriver().capabilities(opt).create();
            setDriver(driver);

        } else {
            // Keeping the legacy until we finish the test
            System.out.println("[i] Invalid browser name. Launching Chrome as default.");
            ChromeOptions opt = new ChromeOptions();
            opt.addArguments("--headless=new");
            driver = WebDriverManager.chromedriver().capabilities(opt).create();
            setDriver(driver);
        }

        return getDriver();

    }

    /**
     * Method to load the config.properties file
     */
    public void loadProperties(){

        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +
                    "\\src\\test\\java\\config\\config.properties");
            prop.load(fis);
        }catch(Exception e){
            System.out.println("[!] Exception occurred while loading the config file.");
        }

    }

    /**
     * Method to initiate the driver
     */
    @BeforeSuite
    public static synchronized void setUp(){
        driver = getBrowser();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));

        System.out.println("From BeforeSuite: " + driver);
    }

    /**
     * Garbage collector after finishing tasks
     *
     * @throws InterruptedException
     */
    @AfterSuite
    public static synchronized void cleanUp() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Driver in ThreadLocal: " + getDriver());
        getDriver().quit();
        System.out.println("Driver in ThreadLocal after quiting: " + getDriver());
    }

}
