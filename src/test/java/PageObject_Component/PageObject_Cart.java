package PageObject_Component;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObject_Cart {
	
	public static AppiumDriver driver;
	
	@FindBy(id="com.bigbasket.mobileapp:id/action_search")
	public WebElement Search_txtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/searchView")
	public WebElement Searchview_txtbox;
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgAddToBasket")
	public WebElement Add_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/btnViewBasket")
	public WebElement Cart_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtProductDesc")
	public WebElement Product_msg;
	
	@FindBy(id="com.bigbasket.mobileapp:id/imgRemove")
	public WebElement Delete_btn;
	
	@FindBy(id="com.bigbasket.mobileapp:id/txtEmptyMsg1")
	public WebElement Delete_Cartmsg;
		
	public PageObject_Cart(AppiumDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	
	public void Click_Search_txtbox()
	{
		Search_txtbox.click();
	}
	
	
	public void Enter_Search_txtbox(String Value)
	{
		Searchview_txtbox.sendKeys(Value +"\n");
	}
	
	public void Click_Addbtn()
	{
		Add_btn.click();
	}
	
	public void Click_Cartimg()
	{
		Cart_btn.click();
	}
	
	public String getAddProduct()
	{
		return Product_msg.getText();
		
	}
	
	public void Click_deletebtn()
	{
		Delete_btn.click();
	}
	
	public String getDeletemsg()
	{
		return Delete_Cartmsg.getText();
		
	}
	
	
	

}
