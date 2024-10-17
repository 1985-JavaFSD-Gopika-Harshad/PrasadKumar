package com.prasad;

import java.util.HashMap;

public class Student {
	public static void main(String[] args) {
		HashMap<String,Integer> grades=new HashMap<>();
		grades.put("Prasad01",99);
		grades.put("Sai002",58);
		grades.put("Mani003",89);
		grades.put("Pavan004", 69);
		grades.put("Babu005", 87);
		
		System.out.println("all students with grades :"+ grades);

		
		System.out.println("grade of student  : Prasad01 ="+grades.get("Prasad01"));
		
		grades.put("Prasad01",75);
		
		grades.remove("Babu005");
		
		System.out.println("all students with grades :"+ grades);

	}
}
