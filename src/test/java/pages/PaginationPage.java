package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PaginationPage extends TechGlobalBasePage{

    public PaginationPage() {
        super();
    }

    @FindBy(id = "main_heading")
    public WebElement headingText;

    @FindBy(id = "sub_heading")
    public WebElement subHeading;

    @FindBy(id = "content")
    public WebElement contentText;

    @FindBy(id = "previous")
    public WebElement previousButton;

    @FindBy(id = "next")
    public WebElement nextButton;

    @FindBy(css = "img[class='city_image']")
    public WebElement images;

    @FindBy(css = "div[class='Pagination_pagBodyData__up2c0'] p")
    public List<WebElement> cityInfo;
}
