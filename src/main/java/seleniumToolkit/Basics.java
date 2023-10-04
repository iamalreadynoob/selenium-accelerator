package seleniumToolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

public class Basics
{

    private final WebDriver driver;
    private By savedLocation;

    public Basics(WebDriver driver)
    {
        this.driver = driver;
        savedLocation = null;
    }

    public Basics(WebDriver driver, By savedLocation)
    {
        this.driver = driver;
        this.savedLocation = savedLocation;
    }

    public void setSavedLocation(By savedLocation) {this.savedLocation = savedLocation;}
    public By getSavedLocation() {return savedLocation;}

    public boolean isExist(By location)
    {
        boolean flag = false;

        List<WebElement> elements = driver.findElements(location);
        if (elements.size() > 0) flag = true;

        return flag;
    }

    public boolean isExist() {return isExist(savedLocation);}

    public boolean isEmpty(By location)
    {
        boolean flag = false;

        if (isExist(location))
        {
            List<WebElement> elements = driver.findElements(location);
            for (WebElement element: elements)
                if (element.getText().isEmpty() || element.getText().isBlank())
                {
                    flag = true;
                    break;
                }
        }
        else flag = true;

        return flag;
    }
    public boolean isEmpty() {return isEmpty(savedLocation);}

    public boolean isEmpty(By location, int at)
    {
        boolean flag = false;

        if (isExist(location))
        {
            List<WebElement> elements = driver.findElements(location);

            if (at >= 0 && at < elements.size())
            {
                String text = elements.get(at).getText();
                if (text.isEmpty() || text.isBlank()) flag = true;
            }
            else flag = true;
        }
        else flag = true;

        return flag;
    }
    public boolean isEmpty(int at) {return isEmpty(savedLocation, at);}

    public boolean isEmpty(By location, int from, int to)
    {
        boolean flag = false;

        if (isExist(location) && from >= 0 && to > from)
        {
            List<WebElement> elements = driver.findElements(location);

            if (elements.size() >= to)
            {
                for (int i = from; i < to; i++)
                {
                    if (elements.get(i).getText().isEmpty() || elements.get(i).getText().isBlank())
                    {
                        flag = true;
                        break;
                    }
                }
            }
            else flag = true;
        }
        else flag = true;

        return flag;
    }
    public boolean isEmpty(int from, int to) {return isEmpty(savedLocation, from, to);}

    public boolean isIt(By location, String expected)
    {
        boolean flag = true;

        if (isExist(location))
        {
            List<WebElement> elements = driver.findElements(location);

            for (WebElement element: elements)
            {
                if (!element.getText().equals(expected))
                {
                    flag = false;
                    break;
                }
            }
        }
        else flag = false;

        return flag;
    }
    public boolean isIt(String expected) {return isIt(savedLocation, expected);}

    public boolean isIt(By location, String expected, int at)
    {
        boolean flag = true;

        if(isExist(location))
        {
            List<WebElement> elements = driver.findElements(location);

            if (at >= 0 && at < elements.size())
            {
                if (!elements.get(at).getText().equals(expected)) flag = false;
            }
            else flag = false;
        }
        else flag = false;


        return flag;
    }
    public boolean isIt(String expected, int at) {return isIt(savedLocation, expected, at);}

    public boolean isIt(By location, String expected, int from, int to)
    {
        boolean flag = true;

        if (isExist(location) && from >= 0 && from < to)
        {
            List<WebElement> elements = driver.findElements(location);

            if (to <= elements.size())
            {
                for (int i = from; i < to; i++)
                {
                    if (!elements.get(i).getText().equals(expected))
                    {
                        flag = false;
                        break;
                    }
                }
            }
            else flag = false;
        }
        else flag = false;

        return flag;
    }
    public boolean isIt(String expected, int from, int to) {return isIt(savedLocation, expected, from, to);}

    public void test(By location)
    {
        List<WebElement> elements = driver.findElements(location);
        for (int i = 0; i < elements.size(); i++)
            System.out.println("item " + (i+1) + ": " + elements.get(i).getText());
    }
    public void test() {test(savedLocation);}

    public int getSize(By location)
    {
        List<WebElement> elements = driver.findElements(location);
        return elements.size();
    }
    public int getSize() {return getSize(savedLocation);}

    public static FirefoxDriver init(String driverPath)
    {
        System.setProperty("webdriver.driver.geckodriver", driverPath);
        System.setProperty("intl.accept_languages", "en-US");

        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("intl.accept_languages", "en-US");

        return new FirefoxDriver(options);
    }

    public static FirefoxDriver init(String driverPath, String driverLang)
    {
        System.setProperty("webdriver.driver.geckodriver", driverPath);
        System.setProperty("intl.accept_languages", driverLang);

        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("intl.accept_languages", driverLang);

        return new FirefoxDriver(options);
    }

}
