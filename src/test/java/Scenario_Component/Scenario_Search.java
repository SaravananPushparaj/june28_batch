package Scenario_Component;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Component.Base_Class;
import PageObject_Component.PageObject_Search;

public class Scenario_Search extends Base_Class {
	
	static Logger log= Logger.getLogger(Scenario_Search.class);
	SoftAssert sAssert= new SoftAssert();
	
	@Test(dataProvider="dp_InValidSearch" , dataProviderClass=DataProvider_Component.DataProvider_Search.class, groups={"smoke"})
	public void test_InvalidSearch(String TC_ID, String Order, String Search_item, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase " +TC_ID);
		
		Start_Server();
		Init_app();
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		
		Explicit_wait(BS_Pob.Search_txtbox, 25);
		BS_Pob.Click_Search_txtbox();
		
		Explicit_wait(BS_Pob.Searchview_txtbox,25);
		BS_Pob.Enter_Search_txtbox(Search_item);
		
		
		Explicit_wait(BS_Pob.Invalid_msg,25);
		String Actual_Result = BS_Pob.getInvalid_msg();
		
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
	
	
	@Test(dataProvider="dp_ValidSearch" , dataProviderClass=DataProvider_Component.DataProvider_Search.class , groups="regression")
	public void test_ValidSearch(String TC_ID, String Order, String Search_item, String Exp_Result) throws IOException, InterruptedException
	{
		log.info("Executing the Testcase " +TC_ID);
		
		Start_Server();
		Init_app();
		
		PageObject_Search BS_Pob= new PageObject_Search(driver);
		
		Explicit_wait(BS_Pob.Search_txtbox, 25);
		BS_Pob.Click_Search_txtbox();
		
		Explicit_wait(BS_Pob.Searchview_txtbox,25);
		BS_Pob.Enter_Search_txtbox(Search_item);
		
		
		Explicit_wait(BS_Pob.Valid_msg,25);
		
		String Output = BS_Pob.getValid_msg();
		System.out.println(Output);
		String Actual_Result = Output.replace(" products", "");
		
		//System.out.println(Exp_Result);
		if(Actual_Result.equals(Exp_Result))
		{
			log.info("Passed as Actual message is "+Actual_Result + "  Expected message is  "+Exp_Result);
			
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
