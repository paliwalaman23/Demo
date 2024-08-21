package com.mindtree.pageObjects;

import com.mindtree.uistore.MUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class M {
    public WebDriver driver;

    public M(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getTshrt() {
        return driver.findElement(MUI.tshrt);
    }
    public WebElement getIconSearch(){
        return driver.findElement(MUI.iconSearch);
    }
    public WebElement getTxaSearch(){
        return driver.findElement(MUI.txaSearch);
    }
    public List<WebElement> getSpecificTshrt()
    { return driver.findElements(MUI.specificTshrt);
    }
    public WebElement getLabelTshrt(){
        return driver.findElement(MUI.labelTshrt);
    }
    public WebElement getChkBrand(){
        return  driver.findElement(MUI.chkBrand);
    }
}
