package org.meanturtle.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import jxl.read.biff.BiffException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GenericTest {
	public static  ArrayList<ArrayList<HashMap<String, String>>> params =  new ArrayList<ArrayList<HashMap<String,String>>>();
	public static ArrayList<HashMap<String, String>> param = new ArrayList<HashMap<String,String>>();
	
	@Parameters
	public static Collection<Object[]> getMe() {
		XSLHelper helper = new  XSLHelper();
		try {
			params = helper.getWorkSheetDetails("output.xsl");
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		param = params.get(0);
		System.out.println(params.size());
		System.out.println(param.size());
		return Arrays.asList(new Object[][] { { param.get(0)}, {param.get(1)} });  
	}

	// @Parameters
	/*
	 * public static ArrayList<HashMap<String,Object>> getmyList() { TestDriver
	 * driver = new TestDriver();
	 * 
	 * try { list = driver.setUpForTest(); } catch (BiffException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (InstantiationException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (IllegalAccessException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return list; }
	 */

	public GenericTest(HashMap<String, String> data) {
		//super();
	}
	
	//@Test
	public void anotherTest() {
		System.out.println("Called me");
	}

	@Test
	public void genericTest() {

		System.out.println("Hello");
		//System.out.println(getMe().size());
		//for (int i = 0; i < getMe().size(); i++) {
			anotherTest();
		//}
		
		// assert list.isEmpty();
		// System.out.println(list.size());
		// Reflection.getInitObjectStatus("org.thomsonreuters.cpp.cps.testauto.Car",
		// getMap());
		// Reflection.getInitObjectStatus("org.thomsonreuters.cpp.cps.testauto.Car",
		// map);

	}

}
