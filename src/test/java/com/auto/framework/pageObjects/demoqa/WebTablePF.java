package com.auto.framework.pageObjects.demoqa;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import static com.auto.framework.constants.Constants.WEBTABLES_PAGE;
import com.auto.framework.pageObjects.common.BasePage;
import com.auto.framework.testdata.UserModal;

import io.qameta.allure.Step;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class WebTablePF extends BasePage {

  private final By addButton = By.cssSelector("#addNewRecordButton");
  private final By firstNameTextField = By.cssSelector("#firstName");
  private final By lastNameTextField = By.id("lastName");
  private final By emailTextField = By.xpath("//*[@id='userEmail']");
  private final By ageTextField = By.cssSelector("#age");
  private final By salaryTextField = By.id("salary");
  private final By departmentTextField = By.id("department");

  public void openWebTablesPage() {
    masterDriver.elements.openURL(myProperties.getDemoUrl() + WEBTABLES_PAGE);
  }

  @Step("Add User Data")
  public void addUserData(UserModal userData) {
    masterDriver.elements
        .click(addButton)
        .sendKeys(firstNameTextField, userData.getFirstName())
        .sendKeys(lastNameTextField, userData.getLastName())
        .sendKeys(emailTextField, userData.getEmail())
        .sendKeys(ageTextField, userData.getAge())
        .sendKeys(salaryTextField, userData.getSalary())
        .sendKeys(departmentTextField, userData.getDepartment());
  }

  //	public String getConfirmationMessage() {
  ////		return iElementVerification.getText(successMsg);
  //	}

}
