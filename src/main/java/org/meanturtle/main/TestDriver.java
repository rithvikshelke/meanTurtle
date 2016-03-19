package org.meanturtle.main;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/*

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.read.biff.BiffException;

public class TestDriver {

	public ArrayList<HashMap<String, Object>> setUpForTest() throws BiffException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String,Object>>();
		ArrayList<String> header = XSLHelper.setupHeaderList("output.xsl", 0, 0);
		ArrayList<Object> dataList = new ArrayList<Object>();
		for(int i=1; i<XSLHelper.getNumberOfRows();i++) {
			dataList = XSLHelper.setupDataList("output.xsl", 0, i);
			data.add(returnMapFromLists(header, dataList));
		}
		return data;
	}

	public static HashMap<String, Object> returnMapFromLists(
			ArrayList<String> headerList, ArrayList<Object> dataList) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		int i = 0;
		for (String header : headerList) {
			map.put(header, dataList.get(i));
			i++;
		}
		return map;
	}
}
*/

 @RunWith(Parameterized.class)  
 public class TestDriver {  
      
	 @Parameters(name= "Hello{index}")
     public static Collection<Object[]>
                                generateParams() {  
          List<Object[]> params =
                  new ArrayList<Object[]>();  
          for (int i = 1; i <= 4; i++) {  
               params.add(new Object[] {i});  
          }  
          return params;  
     }  
       
     public TestDriver(int param) {}  
    
	 
	 @BeforeClass
	 public static void setup() {
		 System.out.println("Setting stuff up before the class!!!" + generateParams().size());
	 }
	 
	 @AfterClass
	 public static void tearDown() {
		 System.out.println("Removing stuff after the class!!!" +  generateParams().size());
	 }
	 
	 @Before
	 public void setupTest() {
		 System.out.println("Before my test!!" + + generateParams().size());
	 }
	 
	 @After
	 public void tearDownTest() {
		 System.out.println("After my test!!" + + generateParams().size());
	 }   
      @Test  
      public void sometimesFail() {  
           System.out.println("Test Running.. .. .. ." + + generateParams().size());  
      }  
 }