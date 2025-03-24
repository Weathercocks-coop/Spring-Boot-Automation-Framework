package com.auto.framework.interfaces;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.auto.framework.actions.UIElements;

public interface IUIElements {

	WebDriver getWebDriver();

	UIElements sendKeys(By by, String keysToSend);

	UIElements click(By by);

	void openURL(String url);

	UIElements searchAndClickByText(By by, String textForSearch);

	UIElements clickNestedMenus(By by, String tagName, List<String> menuList);

	UIElements searchAndClickTableByText(By by, String textForSearch, String value);

	String findElementsbyIndex(By by, int index);

	UIElements searchAndClickRelativeLeftElement(By toLeftoOfBy, By withBy, String textForSearch);

	UIElements clickRelativeLeftElement(By toLeftoOfBy, By withBy);

	String getTitle();

	String getText(By by);


}
