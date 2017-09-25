package com.epam.pageobj.com.epam;

import com.epam.driver.SelDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPO {
    public LoginPO() {
        try {
            PageFactory.initElements(SelDriver.getDriver(), this);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FindBy(name = "identifier")
    private WebElement loginInput;

    @FindBy(id = "identifierNext")
    private WebElement identifierNextButton;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(id = "passwordNext")
    private WebElement buttonNext;

    @FindBy(id = "og_a")
    private WebElement menu;



    public void typeLoginAndSubmit(String login) {
        loginInput.sendKeys(login);
        identifierNextButton.click();

    }

    public void typePasswordAndSubmit(String password) {
        passwordInput.sendKeys(password);
        buttonNext.click();

    }
    public boolean getMenuLocator() throws Exception{
        WebDriverWait wait = new WebDriverWait(SelDriver.getDriver(), 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("og_a")));
       return  element.isDisplayed();

    }
}
