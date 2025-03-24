package com.auto.framework.pageObjects.demoqa;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.auto.framework.constants.Constants.RADIOBUTTON_PAGE;
import com.auto.framework.pageObjects.common.BasePage;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RadioButtonPF extends BasePage {

	private final By radioButtons = By.xpath("//*[@class='custom-control custom-radio custom-control-inline']");
	private final By successMsg = By.className("text-success");

	public RadioButtonPF openRadioButtonPage() {
		masterDriver.elements.openURL(myProperties.getDemoUrl() + RADIOBUTTON_PAGE);
		return this;
	}

	@Step("Clicked on the Radio Button")
	public RadioButtonPF clickRadioButton(String text) {
		masterDriver.elements.searchAndClickByText(radioButtons, text);
		return this;
	}

	public String getConfirmationMessage() {
		return masterDriver.elements().getText(successMsg);
	}

}
