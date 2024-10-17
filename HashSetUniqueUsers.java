package com.prasad;

import java.util.HashSet;

public class HashSetUniqueUsers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> userNames=new HashSet<>();
		
		//adding usernames..
		userNames.add("Prasad Kumar");
		userNames.add("Sai Kiran");
		userNames.add("Pavan Sai");
		userNames.add("Sai Kumar");
		userNames.add("Maniiii");
		userNames.add("Babulal");
		
		
		System.out.println(userNames);
		
		// .contains() method to check existing user 
		if(userNames.contains("Prasad Kumar")) {
			System.out.println("user Existed");
		}else {
			System.out.println("Not Existed");
		}
		
		// .remove() to remove user
		userNames.remove("Babulal");
		System.out.println("After Removing user :"+userNames);

	}

}
