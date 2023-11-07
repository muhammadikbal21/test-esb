package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import object.LoginObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class LoginStep {

    WebDriver driver;

    LoginObject elementLogin = new LoginObject();


    @Given("User access to url orangehrm")
    public void userAccessToUrlOrangehrm() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    @And("User input valid username")
    public void userInputValidUsername() {
        driver.findElement(elementLogin.getUsernameField()).sendKeys("Admin");
    }

    @And("User input valid password")
    public void userInputValidPassword() {
        driver.findElement(elementLogin.getPasswordField()).sendKeys("admin123");
    }

    @When("User click login button")
    public void userClickLoginButton() {
        driver.findElement(elementLogin.getLoginBtn()).click();
    }

    @Then("User redirect to dashboard")
    public void userRedirectToDashboard() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @Then("User see dashboard page")
    public void userSeeDashboardPage() throws InterruptedException {
        String dashboardText = driver.findElement(elementLogin.getDashboardText()).getText();
        Assert.assertEquals(dashboardText, "Dashboard");

        Thread.sleep(3000); // delay 5 detik
        driver.close();
    }

    @When("User click account")
    public void userClickAccount() throws InterruptedException {
        driver.findElement(elementLogin.getAccountText()).click();
        Thread.sleep(3000);

        driver.findElement(elementLogin.getLogoutBtn()).click();
        Thread.sleep(3000);
    }

    @Then("User redirect to login page")
    public void userRedirectToLoginPage() throws InterruptedException {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(3000); // delay 5 detik
        driver.close();
    }
}
