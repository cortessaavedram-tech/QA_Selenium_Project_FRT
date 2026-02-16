package steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.*;
import pages.BasePage;
import pages.PaginaPrincipal;
import pages.PaginaAcceder;

public class FreeRangeSteps{
    
    PaginaPrincipal landingPage = new PaginaPrincipal();
    BasePage basePage = new BasePage();
    PaginaAcceder accederPage = new PaginaAcceder();

    
    @Given("The user navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }

    @Given("the user is on Acceder Section")
    public void iGoToAcceder(){
        landingPage.clickOnAcceder();
    }

    @When("^The user clicks on the section (.*)$")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @When("the user enters an incorrect email")
    public void enterInvalidEmail() {
        accederPage.enterIncorrectEmail();
    }

    @And("the user clicks on Inicio de sesion button")
    public void clickLogin(){
        accederPage.clickInicioSesion();
    }

   @And("the user waits to {string} message to appear")
   public void waitForMessage(String message){
        accederPage.waitForRobotMessage();
    }

    @Then("^The (.*) corresponds to (.*)$")
    public void theSectionCorrespondsToUrl(String sectionName, String expectedUrl) {
        String actualUrl = basePage.getCurrentPageUrl();
        assertTrue(actualUrl.contains(expectedUrl));
    }
    
    @Then("the message: {string}, must appear")
    public void verifyValidationMessage(String expectedMessage){
        String actualMessage = accederPage.getEmailValidationMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


}
