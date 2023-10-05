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

    public LoggerIn action()
    {
        Basics basics = new Basics(driver);

        if (basics.isExist(usernameElement) && basics.isExist(passwordElement))
        {
            WebElement usernamePrompt = driver.findElement(usernameElement);
            WebElement passwordPrompt = driver.findElement(passwordElement);

            usernamePrompt.sendKeys(usernameInput);
            passwordPrompt.sendKeys(passwordInput);
        }

        return this;
    }

    public void click(By location)
    {
        Basics basics = new Basics(driver);

        if (basics.isExist(location))
        {
            new Wait(driver).stop(1);
            WebElement element = driver.findElement(location);
            element.click();
        }
    }

}
