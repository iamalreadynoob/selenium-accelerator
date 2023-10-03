package seleniumToolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoggerIn
{
    private final WebDriver driver;
    private final By usernameElement, passwordElement;
    private final String usernameInput, passwordInput;

    public LoggerIn(WebDriver driver, By usernameElement, By passwordElement, String usernameInput, String passwordInput)
    {
        this.driver = driver;
        this.usernameElement = usernameElement;
        this.passwordElement = passwordElement;
        this.usernameInput = usernameInput;
        this.passwordInput = passwordInput;
    }

    public void action()
    {

    }

}
