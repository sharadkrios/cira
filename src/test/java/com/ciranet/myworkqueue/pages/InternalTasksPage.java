package com.ciranet.myworkqueue.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.ciranet.basepage.BasePage;
import com.ciranet.utilities.LoggerManager;

public class InternalTasksPage extends BasePage
{
	public InternalTasksPage(WebDriver driver) 
	{
		super(driver);
		LoggerManager.debug("======== Initializing the Configurations Page Objects ======== ");
	}
	
	// Initialising of object
	@FindBy(xpath = "//span[normalize-space()='My Work Queue']")
	WebElement myWorkQueueMenu;

	@FindBy(xpath = "//span[normalize-space()='Internal Tasks']")
	WebElement internalTaskmenu;
	
	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-ban fa-flip-horizontal']")
	WebElement resetLayout;

	@FindBy(xpath = "//i[@class='fas fa-star fa-stack-1x dx-theme-accent-as-text-color']")
	WebElement columnChooser;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-close']")
	WebElement closeColChooser;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-minus-square']")
	WebElement collapseIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon far fa-plus-square']")
	WebElement expandIcon;

	@FindBy(xpath = "//div//i[@class='dx-icon cc-icon fas fa-external-link-alt']")
	WebElement fullScreenIcon;

	@FindBy(xpath = "//i[@class='dx-icon cc-icon fas fa-external-link-alt fa-rotate-180']")
	WebElement normalScreenIcon;

	@FindBy(xpath = "//div[@class='cc-owner-search-component-container']//input")
	WebElement ownerSearchBox;

	@FindBy(xpath = "//i[@class='dx-icon dx-icon-menu']")
	WebElement toolbarMenu;

	@FindBy(xpath = "//ul[contains(@class,'dx-treeview-node-container dx-treeview-node-container-opened')]//li//div//span[contains(text(),'My Work Queue')]")
	WebElement menuMyWorkQueue;

	@FindBy(xpath = "//div[@class='header-text']//span[normalize-space()='Internal Tasks']")
	WebElement menuInternalTasks;

	@FindBy(xpath ="//a[@class='fas fa-question-circle']")
	WebElement helpInternalTask;

	@FindBy(xpath = "//span[normalize-space()='Email Settings']")
	WebElement emailButton;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement emailCancel;

	@FindBy(xpath = "//input[@role='combobox'][1]")
	WebElement activeFilterDropdown;

	@FindBy(xpath = "//div[contains(text(),'All Tasks')]")
	WebElement activeFilterValue;

	@FindBy(xpath = "//div[contains(text(),'All Tasks')]")
	WebElement allTasks;

	@FindBy(xpath = "//div[@id='dx-fee9dffb-a871-56f7-5a65-bd42080d012b']//div[@class='dx-button-content']")
	WebElement actionButton;

	@FindBy(xpath = "//div[contains(text(),'Edit')]")
	WebElement editRecord;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement editCancelAction;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement editSaveAction;

	@FindBy(xpath = "//span[normalize-space()='Refresh']")
	WebElement refreshButton;

	@FindBy(xpath = "//div[@class='dx-datagrid-content']//table//tbody//td[@colspan='27']")
	WebElement actionVisibility;

	@FindBy(xpath = "dx-loadindicator-icon")
	WebElement loaderIcon;

	public void internalTaskPageLanding() 
	{
		clickElement(myWorkQueueMenu);
		clickElement(internalTaskmenu);
		waitForInvisibility(loaderIcon);
	}

	public boolean columnChooserClick() 
	{
		waitForInvisibility(loaderIcon);
		clickElement(resetLayout);
		clickElementJS(columnChooser);
		clickElement(closeColChooser);
		System.out.println("Column Chooser closed");
		return true;
	}
	
	public boolean expandCollapseClick() 
	{
		waitForInvisibility(loaderIcon);
		clickElementJS(expandIcon);
		waitForInvisibility(loaderIcon);
		System.out.println("Clicked on Expand icon");
		if(closeColChooser.equals(closeColChooser)) 
		{
			System.out.println("Expand icon is working");
		}
		else 
		{
			System.out.println("Expand icon is not working");
		}
		waitForInvisibility(loaderIcon);
		clickElementJS(collapseIcon);
		waitForInvisibility(loaderIcon);
		System.out.println("Clicked on Collapse icon");
		return true;
	}

	public boolean toolbarFullScreen() 
	{
		waitForInvisibility(loaderIcon);
		clickElementJS(fullScreenIcon);
		waitForInvisibility(loaderIcon);
		if(normalScreenIcon.isDisplayed())
		{
			System.out.println("FullScreen icon button clicked");
			return true;
		}
		else
		{
			System.out.println("FullScreen icon button not clicked");
			return false;
		}
		
	}

	public boolean toolBarNormalScreen() 
	{
		waitForInvisibility(loaderIcon);
		waitForElementToBeClickable(normalScreenIcon);
		clickElementJS(normalScreenIcon);
		waitForInvisibility(loaderIcon);
		if(fullScreenIcon.isDisplayed())
		{
			System.out.println("NormalScreen icon button clicked");
		}
		else
		{
			System.out.println("NormalScreen icon button not clicked");
		}
		return true;
	}
	
	public void emailSetting() 
	{
		waitForElementToBeVisible(emailButton);
		clickElement(emailButton);
		waitForInvisibility(loaderIcon);
		
		String emailSettingPopup = driver.getWindowHandle();
		driver.switchTo().window(emailSettingPopup);
		
		waitForElementToBeVisible(emailCancel);
		clickElement(emailCancel);
		waitForInvisibility(loaderIcon);
	}

	public boolean refreshClick() 
	{
		waitForInvisibility(loaderIcon);
		waitForElementToBeVisible(refreshButton);
		clickElement(refreshButton);
		waitForInvisibility(loaderIcon);
		return true;
	}

	public boolean activeFilterSelection() 
	{
		waitForInvisibility(loaderIcon);
		clickElement(activeFilterDropdown);
		waitForInvisibility(loaderIcon);
		waitForElementToBeVisible(allTasks);
		clickElement(allTasks);
		waitForInvisibility(loaderIcon);
		return true;
	}

	public void verifyCancelInEditRecord() throws AWTException 
	{
		clickElement(activeFilterDropdown);
		waitForInvisibility(loaderIcon);
		clickElement(allTasks);
		waitForInvisibility(loaderIcon);
		clickElement(expandIcon);
		waitForInvisibility(loaderIcon);
		waitForElementToBeVisible(actionButton);
		clickElement(actionButton);
		waitForInvisibility(loaderIcon);
		clickElement(editRecord);
		waitForInvisibility(loaderIcon);
		
		String editRecordPopup = driver.getWindowHandle();
		driver.switchTo().window(editRecordPopup);
		wait.until(ExpectedConditions.elementToBeClickable(editCancelAction));
		System.out.println("Cancel Edit Record Functionality Status : " + editCancelAction.isEnabled());
		waitForElementToBeVisible(editCancelAction);
		clickElement(editCancelAction);
	}

	public void helpInternalTask() 
	{
		waitForElementToBeVisible(helpInternalTask);
		clickElement(helpInternalTask);
		waitForInvisibility(loaderIcon);
		waitForElementToBeVisible(helpInternalTask);
		clickElement(helpInternalTask);
		waitForInvisibility(loaderIcon);
		waitForElementToBeVisible(helpInternalTask);
		clickElement(helpInternalTask);
		waitForInvisibility(loaderIcon);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
		driver.switchTo().window(tabs2.get(0));
	}
}