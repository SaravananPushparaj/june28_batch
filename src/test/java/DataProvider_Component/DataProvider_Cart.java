package DataProvider_Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_Component.ExcelReadWrite;

public class DataProvider_Cart {
	
	@DataProvider(name="dp_AddCart")
	public static Iterator<String[]> getInvalidSearchdata() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("AddCart");
		return Obj.iterator();
		
		
	}
	
	@DataProvider(name="dp_DeleteCart")
	public static Iterator<String[]> getValidSearchdata() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("DeleteCart");		
		return Obj.iterator();
		
	}
	
	
	public static List<String[]> flagRowCount(String scriptname) throws IOException
	{
		ExcelReadWrite xl= new ExcelReadWrite("D:\\Test_BB_Project\\TestData\\Test_Data.xls");
		HSSFSheet Scenario_Cart = xl.Setsheet("Scenario_Cart");
		
		int RowCount = xl.getrowcount(Scenario_Cart);
		
		List<String[]> List_Cart= new ArrayList<String[]>();
		for(int i=1;i<=RowCount;i++)
		{
			
			String Execute_Flag = xl.Readvalue(Scenario_Cart, i, "Execute_Flag");			
			
			String Script_name = xl.Readvalue(Scenario_Cart, i, "Script_name");
			
			if((Execute_Flag.equals("Y"))&&(Script_name.equals(scriptname)))
			{
				String[] arr_cart= new String[5];
				
				arr_cart[0]=xl.Readvalue(Scenario_Cart, i, "TC_ID");
				arr_cart[1]=xl.Readvalue(Scenario_Cart, i, "Order");
				arr_cart[2]=xl.Readvalue(Scenario_Cart, i, "Search_Item");
				arr_cart[3]=xl.Readvalue(Scenario_Cart, i, "Quantity");
				arr_cart[4]=xl.Readvalue(Scenario_Cart, i, "Exp_Result");
				
				
				
				List_Cart.add(arr_cart);
				
			}
			
					
		}
		return List_Cart;
		
		
		
		
	}

}
