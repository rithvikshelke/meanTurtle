package org.meanturtle.main;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public class Reflection {


	
	public static boolean set(Object object, HashMap<String, Object> fieldMap) {
	    Boolean status = false;
		Class<?> clazz = object.getClass();
		
		Field [] fields = clazz.getDeclaredFields();
		
	    for (Map.Entry<String, Object> entry : fieldMap.entrySet()) {
	    while (clazz != null) {
	    	try {
	    			Field field = clazz.getDeclaredField(entry.getKey());
	    			field.setAccessible(true);
	    			field.set(object, entry.getValue());
	    			status = true;
	    			break;
	    		} catch (NoSuchFieldException e) {
	    			clazz = clazz.getSuperclass();
	    		} catch (Exception e) {
	    			status = false;
	    			return status;
	    		}
	    	}
	    }
	    return status;
	}
	
	
	public static void setObject(Object object, String text) {
		Boolean status = false;
		Object currentObj=object;
		Class<?> clazz = currentObj.getClass();
		String[] array = text.split("\\.");
		if (array.length == 1) {
			HashMap<String, Object> fieldMap = new HashMap<String, Object>();
			fieldMap.put(text, 12);
			try {
				Field field = clazz.getDeclaredField(text);
				System.out.println(checkType(field));
				if(("Other").compareToIgnoreCase(checkType(field)) == 0)
				System.out.println(field.getType().toString());
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			status = set(object, fieldMap);
			System.out.println(status);
		} else {
		for(String str : array) {
			try {
				Field field = clazz.getDeclaredField(str);
				field.setAccessible(true);
				ParameterizedType type = (ParameterizedType) field.getGenericType();
				System.out.println(type.getRawType());
				if(field.getType().isPrimitive()) {
					System.out.println("Field: "+ field.getName());
					//TODO : set primitive type	
				} 
				//	else if(field.getType().isInstance(FlagType.class)) {
//					System.out.println("Field: "+ field.getName());
//					//TODO : set flag type
//				} 
				/*else if(){
					// recursive
					currentObj = field;
				}*/
				
			} catch (SecurityException e) {
			e.printStackTrace();
			} catch (NoSuchFieldException e) {
			e.printStackTrace();
			}
		}
		}
	}
	
	public static String checkType(Field field) {
		if(field.getType().toString().contains("FlagType")) {
			return "FlagType";
		} else if (field.getType().toString().contains("List")) {
			return "List";
		} else if(field.getType().toString().contains("Map")) {			
			return "Map";
		} else if(field.getType().toString().contains("Set")) {			
			return "Set";
		} else return "Other";
	}
	
	
	public void setFlagType(Field field) {
		
	}
	
	
	public static void printFileds(Object obj) {
	    Field[] fields = obj.getClass().getFields();
	    for (Field field : fields) {
	        field.setAccessible(true);
	    	System.out.println("Field Name = " + field.getName());
	    }
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SecurityException, NoSuchFieldException {
		String classname = "com.thomsonreuters.cpp.cps.common.messages.schema.UriType";
		Class<?> classHandle = Class.forName(classname.toString());
		Reflection reflect = new Reflection();
		Object myObject = classHandle.newInstance();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("contentPreparationServiceMessage.serviceRequest.requestInfo.compressionRequest.outputDir", "/etc");
		map.put("contentPreparationServiceMessage.serviceRequest.requestInfo.compressionRequest.compressionFormat", "ZIP");
		String text = "id";
		Field field = myObject.getClass().getDeclaredField(text);
		System.out.println(checkType(field));
		setObject(myObject, text);
		//setObject(myObject, text);
		//printFileds(myObject);
		//set(myObject,map);
		
	}
	
	
	public static boolean getInitObjectStatus(String classname, HashMap<String, Object> fieldMap) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> classHandle = Class.forName(classname.toString());
		Object classObject = classHandle.newInstance();
		return set(classObject, fieldMap);
	}
	
	public static Object getInitObject(String classname, HashMap<String, Object> fieldMap) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> classHandle = Class.forName(classname.toString());
		Object classObject = classHandle.newInstance();
		set(classObject, fieldMap);
		return classObject;
	}
}
