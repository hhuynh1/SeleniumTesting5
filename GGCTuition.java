/*
    Created by Henry
 */

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class GGCTuition {
        public WebDriver driver;
        public WebElement isResident;
        public WebElement notLivingOnCampus;
        public WebElement totalCost;
        public WebElement notResident;

        public Select creditsEarned;
        public Select creditsEnrolled;

        double inStateTuition;
        double outOfStateTuition;

        public GGCTuition() {

        }

        public  GGCTuition(WebElement isResident, WebElement notLivingOnCampus, WebElement totalCost,WebElement notResident, Select creditsEarned, Select creditsEnrolled) {
            this.isResident = isResident;
            this.notLivingOnCampus = notLivingOnCampus;
            this.totalCost = totalCost;
            this.notResident = notResident;
            this.creditsEarned = creditsEarned;
            this.creditsEnrolled = creditsEnrolled;
        }
        @Test
        public void GGCInstateTuition() throws Exception {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Software Development\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();

            // Stores URL into driver WebDriver object
            driver.get("http://www.ggc.edu/admissions/tuition-and-financial-aid-calculators/index.html#");

            // Creating WebElement objects based on the URL's registration form
            isResident = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[1]/fieldset/div/label[1]"));
            notLivingOnCampus = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[4]/fieldset/div/label[2]\n"));
            totalCost = driver.findElement(By.id("totalcost"));

            creditsEarned = new Select(driver.findElement(By.id("HOURSearned")));
            creditsEnrolled = new Select(driver.findElement(By.id("creditHOURS")));


            isResident.click(); // Selects "Yes"
            creditsEarned.selectByIndex(2); // Selects third index in the list; hours > 60
            creditsEnrolled.selectByIndex(0); // Selects the first index in the list; 15 hours
            notLivingOnCampus.click(); // Selects "No"

            // Parsing WebElement object of total cost into a int
            String cost = totalCost.getAttribute("value");
            String strCost = cost.substring(1);
            inStateTuition = Double.parseDouble(strCost);

            System.out.println(" ");
            System.out.println("Credits earned: " + creditsEarned.getFirstSelectedOption().getText());
            System.out.println("Credits desired to enroll: " + creditsEnrolled.getFirstSelectedOption().getText());
            System.out.println("Total cost per semester: " + totalCost.getAttribute("value"));
            System.out.println("Total cost for one year: $" + inStateTuition * 2);

    }
        @Test
        public void GGCOutOfStateTuition() throws Exception {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Software Development\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();

            // Stores URL into driver WebDriver object
            driver.get("http://www.ggc.edu/admissions/tuition-and-financial-aid-calculators/index.html#");

            notResident = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[1]/fieldset/div/label[2]"));
            notLivingOnCampus = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[4]/fieldset/div/label[2]\n"));
            totalCost = driver.findElement(By.id("totalcost"));

            creditsEarned = new Select(driver.findElement(By.id("HOURSearned")));
            creditsEnrolled = new Select(driver.findElement(By.id("creditHOURS")));

            notResident.click(); // Selects "Yes"
            creditsEarned.selectByIndex(2); // Selects third index in the list; hours > 60
            creditsEnrolled.selectByIndex(0); // Selects the first index in the list; 15 hours
            notLivingOnCampus.click(); // Selects "No"

            // Parsing WebElement object of total cost into a int
            String cost = totalCost.getAttribute("value");
            String strCost = cost.substring(1);
            outOfStateTuition = Double.parseDouble(strCost);

            System.out.println(" ");
            System.out.println("Credits earned: " + creditsEarned.getFirstSelectedOption().getText());
            System.out.println("Credits desired to enroll: " + creditsEnrolled.getFirstSelectedOption().getText());
            System.out.println("Total cost per semester: " + totalCost.getAttribute("value"));
            System.out.println("Total cost for one year: $" + outOfStateTuition * 2);

        }

        public double getInstateTuition() {
            return inStateTuition;
        }

        public  double getOutOfStateTuition() {
            return getOutOfStateTuition();
        }
}
