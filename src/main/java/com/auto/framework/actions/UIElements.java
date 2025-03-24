package com.auto.framework.actions;

import static com.auto.framework.constants.Constants.UIELEMENT_ERROR_TEXT;

import static java.lang.String.format;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.stereotype.Component;

import com.auto.framework.interfaces.IUIElements;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class UIElements extends ActionsBaseClass implements IUIElements {

	@Override
	public UIElements click(By by) {
		utilityClass.scrollHelper(driver, webDriverWait, applicationContext, by);
		driver.findElement(by).click();
		log.debug("Clicked on Link..");
		return this;
	}

	@Override
	public UIElements sendKeys(By by, String keysToSend) {
		utilityClass.scrollHelper(driver, webDriverWait, applicationContext, by);
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(keysToSend);
		log.debug("Typed in text : {}", keysToSend);
		return this;
	}

	@Override
	public void openURL(String url) {
		log.info("Loading {}", url);
		driver.get(url);

	}

	@Override
	public UIElements clickNestedMenus(By by, String tagName, List<String> menuList) {

		utilityClass.scrollHelper(driver, webDriverWait, applicationContext, by);
		WebElement headerWebElement = driver.findElements(by).stream()
				.filter(element -> element.getText().toLowerCase().contains(menuList.get(0).toLowerCase())).findFirst()
				.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, menuList.get(0))));
		headerWebElement.click();
		log.debug("Found and clicked on Header Element with Text : {}", menuList.get(0));

		for (int i = 1; i < menuList.size(); i++) {
			String subMenuName = menuList.get(i);
			headerWebElement = headerWebElement.findElements(By.tagName(tagName)).stream()
					.filter(element -> element.getText().toLowerCase().contains(subMenuName.toLowerCase())).findFirst()
					.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, subMenuName)));
			headerWebElement.click();
			log.debug("Found and clicked on Sub Element with Text : {}", subMenuName);
		}
		return this;
	}

	@Override
	public String findElementsbyIndex(By by, int index) {
		utilityClass.scrollHelper(driver, webDriverWait, applicationContext, by);
		return driver.findElements(by).get(index).getText();
	}

	@Override
	public UIElements searchAndClickByText(By by, String textForSearch) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElements(by).stream()
				.filter(element -> element.getText().toLowerCase().contains(textForSearch.toLowerCase())).findFirst()
				.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, textForSearch))).click();

		log.debug("Found and clicked on Element with Text : {}", textForSearch);
		return this;
	}

	@Override
	public UIElements clickRelativeLeftElement(By toLeftoOfBy, By withBy) {
		utilityClass.scrollHelper(driver, webDriverWait, applicationContext, withBy);
		driver.findElement(RelativeLocator.with(withBy).toLeftOf(toLeftoOfBy)).click();
		log.debug("Clicked on Link..");
		return this;
	}

	@Override
	public UIElements searchAndClickRelativeLeftElement(By toLeftoOfBy, By withBy, String textForSearch) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(toLeftoOfBy));
		driver.findElement(RelativeLocator.with(withBy).toLeftOf(driver.findElements(toLeftoOfBy).stream()
				.filter(element -> element.getText().toLowerCase().contains(textForSearch.toLowerCase())).findFirst()
				.orElseThrow(
						() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, toLeftoOfBy, textForSearch)))))
				.click();
		return this;
	}

	@Override
	public UIElements searchAndClickTableByText(By by, String textForSearch, String value) {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
		WebElement webElement = driver.findElements(by).stream()
				.flatMap(row -> row.findElements(By.tagName("td")).stream())
				.filter(column -> column.getText().toLowerCase().contains(textForSearch.toLowerCase())).findFirst()
				.orElseThrow(() -> new NoSuchElementException(format(UIELEMENT_ERROR_TEXT, by, textForSearch)));
		driver.findElement(RelativeLocator.with(By.tagName("input")).toRightOf(webElement)).sendKeys(value);
		return this;
	}

	@Override
	public WebDriver getWebDriver() {
		return driver;
	}

	@Override
	public String getTitle() {
		String title = driver.getTitle();
		log.debug("Opened Page : {}", title);
		return title;
	}

	@Override
	public String getText(By by) {
		String text = driver.findElement(by).getText();
		log.debug("Text Value: {}", text);
		return text;
	}
}
