package com.epam.bo;

import com.epam.driver.SelDriver;
import com.epam.models.User;
import com.epam.pageobj.com.epam.LoginPO;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginBO {

    LoginPO loginPage = new LoginPO();
    public void login(User user) throws Exception {

        loginPage.typeLoginAndSubmit(user.getLogin());
        loginPage.typePasswordAndSubmit(user.getPassword());
    }
    public boolean getMenuLocator() throws  Exception{

      return  loginPage.getMenuLocator();

    }
}
