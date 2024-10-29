package com.prasad;

import java.util.Arrays;
import java.util.List;

public class WildCard<T> {
	public static Double sumOfList(List<? extends Number> list) {
		Double sum=0.0;
		for(Number val:list) {
			sum+=val.doubleValue();
		}
		
		return sum;
	}
	public static void main(String[] args) {
		List<Integer> intList=Arrays.asList(1,2,3,4,5,6);
		List<Double> doubList=List.of(9.8,8.7,7.6,6.5,5.4,4.3,3.2,2.1,1.0);
		
		System.out.println(sumOfList(intList));
		System.out.println(sumOfList(doubList));
		
	}

}
