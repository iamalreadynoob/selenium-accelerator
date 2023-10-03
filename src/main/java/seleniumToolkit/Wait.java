package seleniumToolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait
{

    private final WebDriver driver;
    private int commonDuration;

    public Wait(WebDriver driver) {this.driver = driver;}

    public void setDefaultCommonDuration() {commonDuration = 60;}

    public void setCommonDuration(int commonDuration)
    {
        if (commonDuration > 0) this.commonDuration = commonDuration;
        else System.err.println("common duration is still SAME, it was NOT changed");
    }

    public int getCommonDuration() {return commonDuration;}

    public void till(By element)
    {
        Duration duration = Duration.ofSeconds(commonDuration);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void till(By element, int customDuration)
    {
        Duration duration = Duration.ofSeconds(customDuration);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void stop(int seconds)
    {
        try {Thread.sleep(seconds * 1000);}
        catch (Exception e) {e.printStackTrace();}
    }

}
