package seleniumToolkit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Basics
{

    private final WebDriver driver;

    public Basics(WebDriver driver) {this.driver = driver;}

    public boolean isExist(By location)
    {
        boolean flag = false;

        List<WebElement> elements = driver.findElements(location);
        if (elements.size() > 0) flag = true;

        return flag;
    }

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

    public boolean isEmpty(By location, int from, int to)
    {
        boolean flag = false;

        return flag;
    }

    public boolean isIt()
    {
        boolean flag = false;

        return flag;
    }

}
