package waits;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomConditions {
    public static ExpectedCondition<Boolean> jQueryAJAXCompleted(){
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return (Boolean) ((JavascriptExecutor)
                        webDriver).executeScript("return window.jQuery" +
                        "!=null && (jQuery.active === 0);");
            }
        };
    }

    public static ExpectedCondition<Boolean> changingURL(String url) {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return !driver.getCurrentUrl().equals(url);
            }
        };
    }
}
