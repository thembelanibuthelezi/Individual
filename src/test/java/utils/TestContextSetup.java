package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestContextSetup {

   public   static WebDriver driver;


   public  static String Cnum;
   public static String Hname;
   public  static String Exdate;

   public static String Exmonth;

   public static   String Exyear;

   public static String Cvv;
   public static  WebDriver getDriver(){
      if(driver == null){
         System.setProperty("web-driver.chrome.driver", "src/test/java/chromedriver_linux64/chromedriver");
         driver = new ChromeDriver();
      }
      driver.manage().window().maximize();
      return  driver;
   }

   public static void quitDriver(){
      if (driver != null){
         driver.quit();
         driver = null;
      }
   }






}
