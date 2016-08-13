package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Cart;


public class Scenario_Cart extends Base_Class {

	static Logger log= Logger.getLogger(Scenario_Search.class);
	SoftAssert sAssert= new SoftAssert();
	
	@Test(dataProvider="dp_AddCart" , dataProviderClass=DataProvider_Component.DataProvider_Cart.class)
	public void test_AddCart(String TC_ID, String Order, String Search_item,String Quantity, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase " +TC_ID);
		
		Start_Server();
		Init_app();
		
		PageObject_Cart BC_Pob= new PageObject_Cart(driver);
		
		Explicit_wait(BC_Pob.Search_txtbox, 25);
		BC_Pob.Click_Search_txtbox();
		
		Explicit_wait(BC_Pob.Searchview_txtbox,25);
		BC_Pob.Enter_Search_txtbox(Search_item);
		
		Explicit_wait(BC_Pob.Add_btn,25);
		BC_Pob.Click_Addbtn();
		
		Explicit_wait(BC_Pob.Cart_btn,25);
		BC_Pob.Click_Cartimg();
		
		Explicit_wait(BC_Pob.Product_msg,25);
		String Actual_Result = BC_Pob.getAddProduct();
		System.out.println(Actual_Result);
		
		System.out.println(Exp_Result);
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual message is "+Actual_Result + "  Expected message is  "+Exp_Result);
			snapshot1(TC_ID, Order);
			
		}
		else
		{
			log.info("Failed as Actual message is "+Actual_Result + "  Expected message is  "+Exp_Result);
			sAssert.fail("Failed as Actual message is "+Actual_Result + "  Expected message is  "+Exp_Result);
			snapshot1(TC_ID, Order);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
	}
	
	
	@Test(dataProvider="dp_DeleteCart" , dataProviderClass=DataProvider_Component.DataProvider_Cart.class)
	public void test_DeleteCart(String TC_ID, String Order, String Search_item,String Quantity, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase " +TC_ID);
		
		Start_Server();
		Init_app();
		
		PageObject_Cart BC_Pob= new PageObject_Cart(driver);
		
		Explicit_wait(BC_Pob.Search_txtbox, 25);
		BC_Pob.Click_Search_txtbox();
		
		Explicit_wait(BC_Pob.Searchview_txtbox,25);
		BC_Pob.Enter_Search_txtbox(Search_item);
		
		Explicit_wait(BC_Pob.Add_btn,25);
		BC_Pob.Click_Addbtn();
		
		Explicit_wait(BC_Pob.Cart_btn,25);
		BC_Pob.Click_Cartimg();
		
		Explicit_wait(BC_Pob.Delete_btn,25);
		BC_Pob.Click_deletebtn();
		
		Explicit_wait(BC_Pob.Delete_Cartmsg,25);
		String Actual_Result = BC_Pob.getDeletemsg();
		
		System.out.println(Exp_Result);
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual message is "+Actual_Result + "  Expected message is  "+Exp_Result);
			snapshot1(TC_ID, Order);
			
		}
		else
		{
			log.info("Failed as Actual message is "+Actual_Result + "  Expected message is  "+Exp_Result);
			sAssert.fail("Failed as Actual message is "+Actual_Result + "  Expected message is  "+Exp_Result);
			snapshot1(TC_ID, Order);
		}
		
		
		Stop_Server();
		sAssert.assertAll();
	}
}
