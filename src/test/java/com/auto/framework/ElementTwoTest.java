package com.auto.framework;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.auto.framework.pageObjects.demoqa.ElementsPage;
import com.auto.framework.testdata.UserDataProvider;
import com.auto.framework.testdata.UserModal;

@SpringBootTest
public class ElementTwoTest {

    @Autowired public ElementsPage elementsPage;
    static Boolean sanityPassed=false;

    static Stream<Arguments> provideUserData() {
        return new UserDataProvider().provideData();
    }

    @Test
    @Tag("Sanity test")
    @Order(0)
    public void sanityCheck() {
        elementsPage.openElementsPage();

        assert(elementsPage.getPageTitle().equals("DEMOQA"));
        sanityPassed = true;
    }

    @ParameterizedTest
    @MethodSource("provideUserData")
    public void textBoxVal__TC001(UserModal userData) {
        org.junit.jupiter.api.Assumptions.assumeTrue(sanityPassed,"Sanity unde e boss");
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
        assert (
                elementsPage.textBoxPF.getConfirmationMessage().getFirstName().equals(userData.getFirstName()));
        assert (elementsPage.textBoxPF.getConfirmationMessage().getEmail().equals(userData.getEmail()));
        assert (
                elementsPage.textBoxPF.getConfirmationMessage().getCurrAddress().equals(userData.getCurrAddress()));
        assert (
                elementsPage.textBoxPF.getConfirmationMessage().getPermAddress().equals(userData.getPermAddress()));
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

        assert (elementsPage.checkBoxPF.getConfirmationMessage().equals("angular"));
    }

    @Test()
    public void RadioButtonVal__TC003() {
        Assumptions.assumeTrue(sanityPassed,"Sanity unde e boss");

        elementsPage.radioButtonPF.openRadioButtonPage().clickRadioButton("Impressive");

        assert (elementsPage.radioButtonPF.getConfirmationMessage().equals("Impresive"));
    }

}
