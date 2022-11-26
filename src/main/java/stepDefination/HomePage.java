package stepDefination;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import keywords.Labels;
import keywords.WebActionLibrary;

public class HomePage {
	
	@Given("Open brower and navigate to home page")
	public void openBrowser() {
		WebActionLibrary.openBrowser(Labels.chBrowser, Labels.url);
	}
	
	@Then("Validate page title")
	public void validatePageTitle() {
		WebActionLibrary.validateTitle();
	}
	
	@And("Close all browser")
	public void closeBrowser() {
		WebActionLibrary.closeBrowser();
		
	}

}
