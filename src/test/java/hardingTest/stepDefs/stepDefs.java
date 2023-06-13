package hardingTest.stepDefs;

import com.github.javafaker.Faker;
import hardingTest.PageObject.HardingPage;
import hardingTest.PageObject.MainPage;
import hardingTest.utilities.ConfigurationReader;
import hardingTest.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class stepDefs {
    HardingPage hardingPage = new HardingPage();
    MainPage MainPage = new MainPage();






    @Given("that I am looking at the company’s homepage")
    public void that_I_am_looking_at_the_company_s_homepage() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("hardingUrl"));
       // WebDriverWait wait = new WebDriverWait(Driver.getDriver, 3);
        Thread.sleep(3000);
        MainPage.cookieAcceptHarding.click();
    }

    @Given("searching for an {string} job")
    public void searching_for_an_job(String jobTitle) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(MainPage.careerButton).perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 7);
        wait.until(ExpectedConditions.visibilityOf(MainPage.landSideButton));
        MainPage.landSideButton.click();

        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), 7);
        wait1.until(ExpectedConditions.visibilityOf(MainPage.seeVacanciesBtn));
        MainPage.seeVacanciesBtn.click();

        WebDriverWait wait2 = new WebDriverWait(Driver.getDriver(), 7);
        wait2.until(ExpectedConditions.visibilityOf(MainPage.searchInputBox));
        MainPage.searchInputBox.sendKeys(jobTitle);

        MainPage.searchBtn.click();
    }

    @When("I click on the {string} button")
    public void i_click_on_the_button(String buttonWord) throws InterruptedException {
        MainPage.button(buttonWord).click();
        Thread.sleep(3000);
    }

    Faker faker = new Faker();


    @Then("I should be able to fill in the mandatory fields with the Basic data on the first page.")
    public void i_should_be_able_to_fill_in_the_mandatory_fields_with_the_Basic_data_on_the_first_page() throws InterruptedException {
        hardingPage.firstNameInputBox.sendKeys("Agnes");
        hardingPage.surNameInputBox.sendKeys("Nemeth");
        hardingPage.emailAddressBox.sendKeys(faker.internet().emailAddress());
        hardingPage.mobileInputBox.sendKeys("07777 111111");

        Thread.sleep(5000);

        String path = "/Users/ertugbatar/Desktop/Harding/denemecv.pdf";
        //String path = "/Users/ertugbatar/Desktop/denemecv.pdf";
        hardingPage.uploadBtn.sendKeys(path);
        hardingPage.townInputBox.sendKeys("Bristol");
        Thread.sleep(3000);
        hardingPage.nextBtn.click();
        Thread.sleep(3000);




    }

    @Then("I should get the {string} when submitting the application.")
    public void i_should_get_the_when_submitting_the_application(String string) throws InterruptedException {
        hardingPage.nextBtn.click();
        Thread.sleep(3000);

    }



    @Then("I should be able to fill in the mandatory fields with the {string} on the first page.")
    public void iShouldBeAbleToFillInTheMandatoryFieldsWithTheOnTheFirstPage(String testDate) throws InterruptedException {
        Driver.getDriver().get("https://careers.hardingretail.com/Forms/Application?formParameters=KizGpaAy2eWSChSK2ySS31%2FQ5LX98ERQAjFp7wKPPTDI3XdGKDIXaw%3D%3D&jobPostId=414311");
        WebElement testDateField = Driver.getDriver().findElement(By.id("testDateFieldId"));
        testDateField.clear();
        testDateField.sendKeys(testDate);
        Thread.sleep(3000);
        Driver.getDriver().quit();
    }
}