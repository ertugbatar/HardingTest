package hardingTest.PageObject;

import hardingTest.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static hardingTest.utilities.Driver.getDriver;

public class HardingPage {
    public HardingPage() {


       PageFactory.initElements(getDriver(), this);
}

        @FindBy(xpath = "(//input[@class='form-control'])[1]")
        public WebElement firstNameInputBox;

        @FindBy(xpath = "(//input[@class='form-control'])[2]")
        public WebElement surNameInputBox;

        @FindBy(xpath = "(//input[@class='form-control'])[3]")
        public WebElement emailAddressBox;

        @FindBy(xpath = "(//input[@class='form-control'])[4]")
        public WebElement mobileInputBox;

        @FindBy(xpath = "(//input[@class='form-control'])[5]")
        public WebElement townInputBox;

        @FindBy (xpath = "(//input[@class='dz-hidden-input'])[1]")
        public WebElement uploadBtn;

        @FindBy (id ="btnCreateApplication")
        public WebElement nextBtn;
    }

