package com.epam.testlogin;


import com.epam.bo.LoginBO;
import com.epam.driver.SelDriver;
import com.epam.models.User;
import com.epam.pageobj.com.epam.LoginPO;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;


public class TestLogin {
    public final String startUrl = "https://accounts.google.com/AccountChooser/identifier?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AddSession";
    private SelendroidLauncher selendroidServer = null;
    private WebDriver driver = null;


    @Test
    public void testLogin() throws Exception {
        SelDriver.setUrl(startUrl);
        User user = new User("olegvovkanych@gmail.com","sittervovkanych" );
        LoginBO bo = new LoginBO();
         bo.login(user);
        Assert.assertTrue(bo.getMenuLocator());



    }

        @After
    public void after(){
    SelDriver.stopSelendroidServer();
    }

}