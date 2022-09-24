/*
Napisati program koji na sajtu:
http://automationpractice.com
dodaje najmanje 3 proizvoda u cart, nastavlja do cart-a, izbacuje jedan proizvod, a drugom povecava kolicinu za 1.

Sajt je malo usporen i bagovit, pa stavljajte malo vece wait-ere
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpbou\\IdeaProjects/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement article1 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/div[2]/a[1]/span"));
        article1.click();

        WebElement continueShopping = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span"));
        continueShopping.click();

        WebElement article2 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]/span"));
        article2.click();

        continueShopping.click();

        WebElement article3 = driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[1]/span"));
        article3.click();

        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
        checkout.click();

        WebElement moveToTrash = driver.findElement(By.xpath("//*[@id=\"1_1_0_0\"]/i"));
        moveToTrash.click();

        WebElement addOneMore = driver.findElement(By.xpath("//*[@id=\"cart_quantity_up_2_7_0_0\"]/span/i"));
        addOneMore.click();

        //ubacila sam Thread da bi videla da li je odradio radnje u korpi.
        // Nisam isla sa Explicit Waiter, jer ne cekam neku radnju, vec samo zadrzavam korpu.
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.close();
    }
}
