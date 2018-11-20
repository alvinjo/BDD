import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeaPage {

    @FindBy(linkText = "Menu")
    WebElement menuButton;


    public void clickMenu(){
        menuButton.click();
    }


}
