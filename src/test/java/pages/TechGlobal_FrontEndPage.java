package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class TechGlobal_FrontEndPage extends TechGlobalBasePage {

    public TechGlobal_FrontEndPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[id^='card']")
    public List<WebElement> cards;

    public void getFrontEndTesting() {

         dropdown_button.click();
        dropdown_options.get(0).click();
    }


    public void clickOnCard(String cardText) {

        for (WebElement card : cards) {
            if (card.getText().equals(cardText)) {
                card.click();
                break;
            }
        }
    }

    public void clickOnCard(int index) {
        cards.get(index).click();
    }
}
