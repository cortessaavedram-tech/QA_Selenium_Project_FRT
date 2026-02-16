package pages;

public class PaginaPrincipal extends BasePage {

    private String sectionLink = "//a[normalize-space()='%s' and @href]"; 
    private String accederLink = "//a[normalize-space()='Acceder' and @href]"; 
    
    //Method to navigate to www.freerangetesters.com
    public void navigateToFreeRangeTesters(){
        navigateTo("https://www.freerangetesters.com");
    }
    
    public void clickOnSectionNavigationBar(String section) {
        // Replace sectionLink by the name
        String xpathSection = String.format(sectionLink, section);
        clickElement(xpathSection);
    }

    public void clickOnAcceder() {
        clickElement(accederLink);
    }

   
    
}
