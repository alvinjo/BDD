import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage {

    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[1]/div/h1")
    WebElement menuHeader;

    @FindBy(xpath = "/html/body/div/div/div[1]/div/div[16]/div/a/span")
    WebElement checkoutButton;


    public void clickCheckout(){
        checkoutButton.click();
    }


}
