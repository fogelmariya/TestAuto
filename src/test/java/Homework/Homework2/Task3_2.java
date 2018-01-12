package Homework.Homework2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static java.lang.System.setProperty;

public class Task3_2 {

    @Test
    public void test(){
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        System.out.println(driver.getTitle());
        System.out.println(System.currentTimeMillis());
        driver.close();
        if(driver.toString().contains("null"))
        {  driver.quit(); }

    }
}
