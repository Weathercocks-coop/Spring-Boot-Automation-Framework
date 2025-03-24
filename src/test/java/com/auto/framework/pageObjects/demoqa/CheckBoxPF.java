package com.auto.framework.pageObjects.demoqa;

import static com.auto.framework.constants.Constants.CHECKBOX_PAGE;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import com.auto.framework.pageObjects.common.BasePage;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CheckBoxPF extends BasePage {

	private final By level1Menu = By.xpath("//*[@id='tree-node']/ol/li/span/label/span[3]");
	private final By level2Menu = By.xpath("//*[@id='tree-node']/ol/li/ol/li/span/label/span[3]");
	private final By level3Menu = By.xpath("//*[@id='tree-node']/ol/li/ol/li/ol/li/span/label/span[3]");
	private final By level4Menu = By.xpath("//*[@id='tree-node']/ol/li/ol/li/ol/li/ol/li/span/label/span[3]");
	private final By expandButtonRL = By.xpath("//button[@title='Toggle']");
	private final By successMsg = By.className("text-success");

	public CheckBoxPF openCheckBoxPage() {
		masterDriver.elements.openURL(myProperties.getDemoUrl() + CHECKBOX_PAGE);
		return this;
	}

	@Step("Expand Level 1 Menu")
	public CheckBoxPF expandLevel1Menu() {
		masterDriver.elements.clickRelativeLeftElement(level1Menu, expandButtonRL);
		return this;
	}

	@Step("Expand Level 2 Menu")
	public CheckBoxPF expandLevel2Menu(String textForSearch) {
		masterDriver.elements.searchAndClickRelativeLeftElement(level2Menu, expandButtonRL, textForSearch);
		return this;
	}

	@Step("Expand Level 3 Menu")
	public CheckBoxPF expandLevel3Menu(String textForSearch) {
		masterDriver.elements.searchAndClickRelativeLeftElement(level3Menu, expandButtonRL, textForSearch);
		return this;
	}

	@Step("Select Level 4 Option")
	public CheckBoxPF clickLevel4Option(String textForSearch) {
		masterDriver.elements.searchAndClickByText(level4Menu, textForSearch);
		return this;
	}

	public String getConfirmationMessage() {
		return masterDriver.elements().getText(successMsg);
	}

}
