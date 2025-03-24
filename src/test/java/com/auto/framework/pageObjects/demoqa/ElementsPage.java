package com.auto.framework.pageObjects.demoqa;

import static com.auto.framework.constants.Constants.ELEMENTS_PAGE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto.framework.pageObjects.common.BasePage;

import io.qameta.allure.Step;

@Component
public class ElementsPage extends BasePage {

	@Autowired
	public TextBoxPF textBoxPF;

	@Autowired
	public CheckBoxPF checkBoxPF;

	@Autowired
	public RadioButtonPF radioButtonPF;

	@Autowired
	public WebTablePF webTablePF;

	@Step("Open webpage")
	public void openElementsPage() {
		masterDriver.elements.openURL(myProperties.getDemoUrl() + ELEMENTS_PAGE);
	}

	@Step("Verify Page Title")
	public String getPageTitle() {
		return masterDriver.elements().getTitle();
	}

}
