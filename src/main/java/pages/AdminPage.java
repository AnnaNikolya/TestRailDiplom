package pages;

import static com.codeborne.selenide.Selenide.$;

public class AdminPage extends BasePage {
    String ADMIN_TAB = "#navigation-admin";

    public void openAdminTab() {
        $(ADMIN_TAB).click();
    }
}
