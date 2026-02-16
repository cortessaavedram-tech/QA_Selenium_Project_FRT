package pages;

public class PaginaAcceder extends BasePage {

    private String emailPlaceholder = "//input[@id='email']"; 
    private String inicioSesionButton = "//button[@type='submit']"; 
    private String idRobotMessage = "success-text";

    public void waitForRobotMessage() {
        waitForElement(idRobotMessage);
    }
    
    public void enterIncorrectEmail() {
    write(emailPlaceholder, "emailSinArroba.com");
    }

    public void clickInicioSesion() {
    clickElement(inicioSesionButton);
    }

    public String getEmailValidationMessage() {
    // Esto captura el mensaje  "Incluye un signo @..."
    return Find(emailPlaceholder).getDomProperty("validationMessage");
    }

}
