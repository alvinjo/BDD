import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.After;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class teaSteps {

    WebDriver driver;
    String URL = "http://www.practiceselenium.com/menu.html";
    TeaPage homePage;
    MenuPage menuPage;
    CheckoutPage checkoutPage;

    teaTest runner = new teaTest();

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Given("^the correct web address$")
    public void the_correct_web_address(){
        driver.get(URL);
        homePage = PageFactory.initElements(driver, TeaPage.class);
        menuPage = PageFactory.initElements(driver, MenuPage.class);
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
    }

    @When("^I navigate to the 'Menu' page$")
    public void i_navigate_to_the_Menu_page(){
        homePage.clickMenu();
    }

    @Then("^I can browse a list of the available products\\.$")
    public void i_can_browse_a_list_of_the_available_products(){
        String expected = "Menu";

        runner.test = runner.report.startTest("Browse Available Products");
        if(menuPage.menuHeader.getText().equals(expected)){
            runner.test.log(LogStatus.PASS,"Verify browse available products");
        }else{
            runner.test.log(LogStatus.FAIL,"Verify browse available products");
        }

        Assert.assertEquals(expected, menuPage.menuHeader.getText());
    }

    @When("^I click the checkout button$")
    public void i_click_the_checkout_button(){
        menuPage.clickCheckout();
    }

    @Then("^I am taken to the checkout page$")
    public void i_am_taken_to_the_checkout_page(){
        String expected = "Pay with Credit Card or Log In";

        runner.test = runner.report.startTest("Checkout Button To Checkout Page");
        if(checkoutPage.checkoutHeader.getText().equals(expected)){
            runner.test.log(LogStatus.PASS,"Verify checkout button works");
        }else{
            runner.test.log(LogStatus.FAIL,"Verify checkout button works");
        }

        Assert.assertEquals(expected, checkoutPage.checkoutHeader.getText());
    }

    @After
    public void tearDown(){
        runner.report.endTest(runner.test);
        driver.quit();
    }

}
