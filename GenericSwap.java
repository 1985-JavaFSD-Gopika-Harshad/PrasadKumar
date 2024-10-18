package com.prasad;

public class GenericSwap {
	
	public static <T> void swapArray(T[] a) {
		for(int i=0;i<a.length;i++) {
			T temp;
			if(i==0) {
				temp=a[i];
				a[i]=a[a.length-1];
				a[a.length-1]=temp;
			}
		}
		
	}

	// swaping.. first and last element in a array
	public static void main(String[] args) {
		String[] str= {"Apple","Ball","Cat","Dog","Egg"};
		System.out.println("Before swap....");
		for(String ele:str) {
			System.out.println(ele);
		}		
		
		swapArray(str);
		System.out.println("After swap....");

		for(String ele:str) {
			System.out.println(ele);
		}
	}

}
