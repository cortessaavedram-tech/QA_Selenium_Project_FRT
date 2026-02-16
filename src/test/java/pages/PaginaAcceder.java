package pages;

//import org.openqa.selenium.support.FindBy;


public class PaginaAcceder extends BasePage {

    private String emailInput = "//input[@id='email']";
    private String loginButton = "//button[contains(., 'Inicio de sesión')]"; 

    public void enterIncorrectEmail(String email) {
    write(emailInput, email);
    }

    public void clickLogin() {
    clickElement(loginButton);
    }

    public String getEmailValidationMessage() {
    // Esto captura el mensaje  "Incluye un signo @..."
    return Find(emailInput).getDomProperty("validationMessage");
    }

}
