package com.auto.framework.actions;

import com.auto.framework.interfaces.IJavaScriptActions;
import com.auto.framework.interfaces.IUIElements;
import com.auto.framework.interfaces.IExplicitWait;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MasterDriver extends ActionsBaseClass{

    @Autowired
    public IUIElements elements;

    @Autowired
    public IExplicitWait explicitWait;

    @Autowired
    public IJavaScriptActions javaScriptActions;

    @Autowired
    public UtilityClass utility;

    public IUIElements elements(){
        return this.elements;
    }

    public IExplicitWait explicitWait(){
        return this.explicitWait;
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public IJavaScriptActions javaScriptActions(){
        return this.javaScriptActions;
    }

    public UtilityClass utility(){
        return this.utility;
    }
}
