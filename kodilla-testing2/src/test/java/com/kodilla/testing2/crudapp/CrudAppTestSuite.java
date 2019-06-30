package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;
import java.util.stream.Collectors;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://niokle.github.io/";
    private WebDriver webDriver;
    private Random random;

    @Before
    public void initTests() {
        webDriver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriver.get(BASE_URL);
        random = new Random();
    }

    @After
    public void cleanUpAfterTest() {
        webDriver.close();
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        Assert.assertTrue(checkTaskExistsInTrello(taskName));
        deleteTestTaskFromCrudApp(taskName);
    }

    private void deleteTestTaskFromCrudApp(String taskName) throws InterruptedException {
        webDriver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement buttonDeleteCard =
                            theForm.findElement(By.xpath(".//button[contains(., \"Delete\")]"));
                    buttonDeleteCard.click();
                });
        Thread.sleep(2000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver webDriverTrello = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        webDriverTrello.get(TRELLO_URL);

        webDriverTrello.findElement(By.id("user")).sendKeys("myszapl@gmail.com");
        webDriverTrello.findElement(By.id("password")).sendKeys("test123456@");
        webDriverTrello.findElement(By.id("login")).submit();

        Thread.sleep(2000);

        webDriverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHerf -> aHerf.findElements(By.xpath(".//div[@title=\"Kodilla Application\"]")).size() > 0)
                .forEach(aHerf -> aHerf.click());

        Thread.sleep(2000);

        result = webDriverTrello.findElements(By.xpath("//span")).stream()
                .filter(theSpan -> theSpan.getText().equals(taskName))
                .collect(Collectors.toList())
                .size() > 0;

        webDriverTrello.close();

        return result;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        webDriver.navigate().refresh();

        while (!webDriver.findElement(By.xpath("//select[1]")).isDisplayed());

        webDriver.findElements(By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                        .getText().contains(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
        handleAlert(webDriver);
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[contains(@action,\"createTask\")]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[contains(@action,\"createTask\")]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[contains(@action,\"createTask\")]/fieldset[3]/button";
        String taskName = "Task number " + random.nextInt(100000);
        String taskContent = taskName + " content";

        WebElement name = webDriver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = webDriver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = webDriver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);

        return taskName;
    }

    public static void handleAlert(WebDriver webDriver) {
        try {
            Alert alert = webDriver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException ex) {

        }
    }
}
