package com.prasad;


public class FindMaxWithGenerics<T> {
	public static <T extends Comparable<T>> T findMax(T[] array) {
		T max=array[0];
		for(T element:array) {
			if(element.compareTo(max)>0) {
				max=element;
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Integer[] array= {34,52,67,18,29,7};
		System.out.println("Max Value: "+findMax(array));
		String[] strArray = {"apple", "orange", "banana"};
        System.out.println("Max Value: "+findMax(strArray));
        
        Box<Integer> intBox=new Box<>();
        intBox.displayTypeAndValue(799);
        Box<String> strBox=new Box<>();
        strBox.displayTypeAndValue("Hello Prasad");
	}
}

class Box<T>{
	public void displayTypeAndValue(T obj) {
		System.out.println("Value: "+obj);
		System.out.println("Type: "+obj.getClass().getName());
	}
}