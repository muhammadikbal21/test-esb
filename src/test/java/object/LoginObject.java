package object;

import org.openqa.selenium.By;

public class LoginObject {

    By usernameField = By.name("username");
    public By getUsernameField() {
        return usernameField;
    }

    By passwordField = By.name("password");
    public By getPasswordField() {
        return passwordField;
    }

    By loginBtn = By.xpath("//button[@type='submit']");
    public By getLoginBtn() {
        return loginBtn;
    }

    By dashboardText = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6");
    public By getDashboardText() {
        return dashboardText;
    }

    By accountText = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span");
    public By getAccountText() {
        return accountText;
    }

    By logoutBtn = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a");
    public By getLogoutBtn() {
        return logoutBtn;
    }
}
