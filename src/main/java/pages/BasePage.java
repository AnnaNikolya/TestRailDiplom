package pages;

import constants.IConstants;
import static com.codeborne.selenide.Selenide.open;

public class BasePage implements IConstants {
    public void openPage(String url) {
        open(url);
    }
}