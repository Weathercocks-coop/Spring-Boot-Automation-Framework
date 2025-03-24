package com.auto.framework.pageObjects.demoqa;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.auto.framework.constants.Constants.TEXTBOX_PAGE;
import com.auto.framework.pageObjects.common.BasePage;
import com.auto.framework.testdata.UserModal;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Component
@AllArgsConstructor
@Log4j2
public class TextBoxPF extends BasePage {

  private final By fullnameTF = By.id("userName");
  private final By emailTF = By.id("userEmail");
  private final By currentAddressTF = By.cssSelector("#currentAddress");
  private final By permanentAddressTF = By.xpath("//*[@id='permanentAddress']");
  private final By submitButton = By.cssSelector("#submit");

  private final By nameText = By.cssSelector("p#name");
  private final By emailText = By.cssSelector("p#email");
  private final By currAddText = By.cssSelector("p#currentAddress");
  private final By permAddText = By.cssSelector("p#permanentAddress");

  public TextBoxPF openTextBoxPage() {
    masterDriver.elements.openURL(myProperties.getDemoUrl() + TEXTBOX_PAGE);
    return this;
  }

  public TextBoxPF updateTextBoxes(UserModal userData) {
    enterFullname(userData.getFirstName());
    enterEmail(userData.getEmail());
    enterCurrentAddress(userData.getCurrAddress());
    enterPermanentAddress(userData.getPermAddress());
    submitForm();
    return this;
  }

  @Step("Enter Fullname")
  public TextBoxPF enterFullname(String fullname) {
    masterDriver.elements.sendKeys(fullnameTF, fullname);
    return this;
  }

  @Step("Enter Email")
  public TextBoxPF enterEmail(String email) {
    masterDriver.elements.sendKeys(emailTF, email);
    return this;
  }

  @Step("Enter Current Address")
  public TextBoxPF enterCurrentAddress(String currAddress) {
    masterDriver.elements.sendKeys(currentAddressTF, currAddress);
    return this;
  }

  @Step("Enter Permanent Address")
  public TextBoxPF enterPermanentAddress(String permAddress) {
    masterDriver.elements.sendKeys(permanentAddressTF, permAddress);
    return this;
  }

  @Step("Submit form")
  public TextBoxPF submitForm() {
    masterDriver.elements.click(submitButton);
    return this;
  }

  public UserModal getConfirmationMessage() {
    UserModal userModal =
        UserModal.builder()
            .firstName(masterDriver.elements().getText(nameText).split(":")[1])
            .email(masterDriver.elements().getText(emailText).split(":")[1])
            .currAddress(masterDriver.elements().getText(currAddText).split(":")[1])
            .permAddress(masterDriver.elements().getText(permAddText).split(":")[1])
            .build();
    log.info("Confirmation Data: {}", userModal);
    return userModal;
  }
}
