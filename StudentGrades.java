package com.prasad;

import java.util.LinkedHashMap;

public class StudentGrades {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap<String, Integer> grades=new LinkedHashMap<>();
		//adding details..
		
		grades.put("student01", 99);
		grades.put("student02", 98);
		grades.put("student03", 97);
		grades.put("student04",35);
		grades.put("student05", 96);
		grades.put("student06", 98);
		
		System.out.println(grades);
		
		for(String id:grades.keySet()) {
			System.out.println("Grade for "+id+" is : "+grades.get(id));
		}
		
		
	}

}
