package org.meanturtle.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collect {
	public static List<String> myList = new ArrayList<String>();
	public static void main(String [] args) throws SecurityException, NoSuchFieldException {
		myList.add("Hello");
		System.out.println(Collect.class.getDeclaredField("myList").getDeclaringClass());
		Iterator it = myList.iterator();
		System.out.println(it.next().getClass());
		/*for(int i=0;i< myList.getClass().getDeclaredMethods().length;i++) {
			Method [] methods = myList.getClass().getDeclaredMethods();
			System.out.println(methods[i].getDeclaringClass().getTypeParameters()[1]);
		}*/
		System.out.println(Collect.class.getDeclaredField("myList").getGenericType());
	}
	
}
