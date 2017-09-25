package com.epam.driver;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

public class SelDriver {
    private static SelendroidLauncher selendroidServer = null;
    private static WebDriver driver = null;

    public static WebDriver getDriver() throws Exception {
        if(driver == null){
            if (selendroidServer != null) {
                selendroidServer.stopSelendroid();
            }
            SelendroidConfiguration config = new SelendroidConfiguration();

            selendroidServer = new SelendroidLauncher(config);
            selendroidServer.launchSelendroid();

            DesiredCapabilities caps = SelendroidCapabilities.android();

            driver = new SelendroidDriver(caps);

        }

        return driver;
    }

    public static void setUrl(String startURL) throws Exception {
        getDriver().get(startURL);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }


    public static void stopSelendroidServer() {
        if (driver != null) {
            driver.quit();
        }
        if (selendroidServer != null) {
            selendroidServer.stopSelendroid();
        }
    }
}
