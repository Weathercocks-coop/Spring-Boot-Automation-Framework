package com.auto.framework;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.auto.framework.listeners.TestListener;
import com.auto.framework.pageObjects.common.BasePage;
import com.auto.framework.pageObjects.demoqa.ElementsPage;
import com.auto.framework.testdata.UserDataProvider;
import com.auto.framework.testdata.UserModal;


@SpringBootTest
@Listeners(TestListener.class)
public class ElementTests extends AbstractTestNGSpringContextTests {

  @Autowired private BasePage basePage;

  @Autowired public ElementsPage elementsPage;

  @Test(groups = "Sanity Test")
  public void sanityCheck() {
    elementsPage.openElementsPage();

    assertThat(elementsPage.getPageTitle(), is("DEMOQA"));
  }

  @Test(
      dependsOnGroups = "Sanity Test",
      dataProvider = "User Data",
      dataProviderClass = UserDataProvider.class)
  public void textBoxVal__TC001(UserModal userData) {
    // Opens browser page
    elementsPage.textBoxPF.openTextBoxPage();

    // Perform testing actions
    elementsPage
        .textBoxPF
        .enterFullname(userData.getFirstName())
        .enterEmail(userData.getEmail())
        .enterCurrentAddress(userData.getCurrAddress())
        .enterPermanentAddress(userData.getPermAddress())
        .submitForm();

    // Assert data points
    assertThat(
        elementsPage.textBoxPF.getConfirmationMessage().getFirstName(),
        is(userData.getFirstName()));
    assertThat(elementsPage.textBoxPF.getConfirmationMessage().getEmail(), is(userData.getEmail()));
    assertThat(
        elementsPage.textBoxPF.getConfirmationMessage().getCurrAddress(),
        is(userData.getCurrAddress()));
    assertThat(
        elementsPage.textBoxPF.getConfirmationMessage().getPermAddress(),
        is(userData.getPermAddress()));
  }

  //	@Test(dependsOnGroups = "Sanity Test")
  public void checkBoxVal__TC002() {
    elementsPage
        .checkBoxPF
        .openCheckBoxPage()
        .expandLevel1Menu()
        .expandLevel2Menu("Documents")
        .expandLevel3Menu("Workspace")
        .clickLevel4Option("Angular");

    assertThat(elementsPage.checkBoxPF.getConfirmationMessage(), is("angular"));
  }

  @Test(dependsOnGroups = "Sanity Test")
  public void RadioButtonVal__TC003() {
    elementsPage.radioButtonPF.openRadioButtonPage().clickRadioButton("Impressive");

    assertThat(elementsPage.radioButtonPF.getConfirmationMessage(), is("Impresive"));
  }

  @BeforeMethod
  @Override
  public void springTestContextPrepareTestInstance() throws Exception {
    super.springTestContextPrepareTestInstance();
  }

  @AfterMethod(alwaysRun = true)
  public void teardownDriver() {
    basePage.teardownDriver();
  }
}
