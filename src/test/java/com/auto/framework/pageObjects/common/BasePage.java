package com.auto.framework.pageObjects.common;

import static java.util.Objects.nonNull;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auto.framework.actions.ActionsBaseClass;
import com.auto.framework.actions.MasterDriver;

import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
// @Scope("driverscope")
public class BasePage extends ActionsBaseClass {

    @Autowired
	protected MasterDriver masterDriver;

	public void teardownDriver() {
		log.info("Taking Screenshots");
		attachScreenShot();
		log.info("Closing Browsers");
		if (nonNull(masterDriver)) {
			 masterDriver.getDriver().close();
		}
	}


	@Attachment(value = "Screen shot", type = "image/png", fileExtension = ".png")
	public byte[] attachScreenShot() {
		try {
			return ((TakesScreenshot) applicationContext.getBean(WebDriver.class)).getScreenshotAs(OutputType.BYTES);
		} catch (WebDriverException e) {
			log.error("Selenium screenshot capture failed: {}", e.getMessage());
		}
		return new byte[0];
	}

}
