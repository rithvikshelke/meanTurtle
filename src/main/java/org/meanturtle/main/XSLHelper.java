package org.meanturtle.main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Cell;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class XSLHelper {
	
	public ArrayList<String> setupHeaderList(Cell[] cells) throws BiffException,
			IOException {
		ArrayList<String> dataList = new ArrayList<String>();
		
		for (Cell cell : cells) {
			System.out.println(cell.getContents());
			dataList.add(cell.getContents());
		}
		return dataList;
	}

	public ArrayList<String> setupDataList(Cell[] cells) throws BiffException,
			IOException {
		ArrayList<String> dataList = new ArrayList<String>();
		for (Cell cell : cells) {
			dataList.add(cell.getContents());
		}
		return dataList;
	}
	
	public ArrayList<ArrayList<HashMap<String,String>>> getWorkSheetDetails(String workBookName) throws BiffException, IOException {
		XSLHelper helper = new XSLHelper();
		workBookName = "output.xls";
		Workbook workbook = Workbook.getWorkbook(new File(workBookName));
		System.out.println(workbook.getNumberOfSheets());
		ArrayList<ArrayList<HashMap<String, String>>> objectList = new ArrayList<ArrayList<HashMap<String,String>>>();
		ArrayList<HashMap<String, String>> sheetDataList;
		for(int i = 0; i<workbook.getNumberOfSheets();i++) {
			System.out.println(workbook.getSheet(i).getName());
			sheetDataList = new ArrayList<HashMap<String,String>>(); 
			ArrayList<ArrayList<String>> dataLists = new ArrayList<ArrayList<String>>();
			ArrayList<String> headerList = new ArrayList<String>();
			for(int j = 0;j<workbook.getSheet(i).getRows();j++) {
				System.out.println(workbook.getSheet(i).getRow(j));
				if(j==0) {
					headerList = helper.setupHeaderList(workbook.getSheet(i).getRow(j));
				} else {
					ArrayList<String> dataList = helper.setupDataList(workbook.getSheet(i).getRow(j));
					dataLists.add(dataList);
				}
			}
			sheetDataList=helper.returnListOfMaps(headerList, dataLists);
			//obj = sheetDataList.toArray();
			System.out.println(sheetDataList.size());
			objectList.add(sheetDataList);
		}
		return objectList;
	}
	
	public ArrayList<HashMap<String, String>> returnListOfMaps(
			ArrayList<String> headerList, ArrayList<ArrayList<String>> dataLists) {
		ArrayList<HashMap<String, String>> listOfMaps = new ArrayList<HashMap<String,String>>();
		for (ArrayList<String> data : dataLists) {
			HashMap<String, String> map = new HashMap<String, String>();
			int i = 0;
			for (String header : headerList) {
				map.put(header, data.get(i));
				i++;
			}
			listOfMaps.add(map);
		}
		System.out.println("Map Size: " + listOfMaps.size());
		return listOfMaps;
	}
}