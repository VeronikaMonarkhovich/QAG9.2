package config;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;


public class TestBase {
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);

    @BeforeAll
    public static void browserInitialConfiguration() {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);

            Configuration.browserCapabilities = capabilities;
            Configuration.startMaximized = true;
//            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";
            Configuration.remote = format("https://%s:%s@%s", credentials.login(), credentials.password(),credentials.url());
    }

    @AfterEach
    public void attach() {
        Attach.screenshotAs("Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
