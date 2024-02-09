package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataProvideres {
	
	@DataProvider(name="data")
	public String[][] getAllData() throws IOException
	{
		String pathString=System.getProperty("user.dir")+"//testData//testdata.xlsx";
		XLUtility xlUtility=new XLUtility(pathString);
		
		int rownum=xlUtility.getRowCount("Sheet1");
		int colcount=xlUtility.getCellCount("Sheet1", 1);
		
		String apiData[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				apiData[i-1][j]=xlUtility.getCellData("Sheet1",i, j);
			}
		}
		
		return apiData;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		String pathString=System.getProperty("user.dir")+"//testData//testdata.xlsx";
		XLUtility xlUtility=new XLUtility(pathString);
		
		int rownum=xlUtility.getRowCount("Sheet1");
		
		String apiData[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{
			apiData[i-1]=xlUtility.getCellData("Sheet1", i, 1);
		}
				
		return apiData;
	}

}
