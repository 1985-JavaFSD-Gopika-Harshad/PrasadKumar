package com.prasad;

import java.util.ArrayList;
import java.util.List;

public class MyMap<K,V> {
	private class Entry{
		private K key;
		private V value;
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
		private List<Entry> entries;
		
		public MyMap() {
			entries= new ArrayList<>();
		}
		
		public void put(K key,V value) {
			for(Entry entry:entries) {
				if(entry.key.equals(key))
				{
					entry.value=value;
					return;
				}
				
			}
			entries.add(new Entry(key,value));
		}
		public V get(K key) {
			for(Entry entry:entries) {
				if(entry.key.equals(key))
				{
					
					return entry.value;
				}
			}
			return null;
		}
		public boolean containsKey(K key) {
			for(Entry entry:entries) {
				if(entry.key.equals(key))
				{
					
					return true;
				}
			}
			return false;
		}
		
	
	public static void main(String[] args) {
		MyMap<String,String> empMap=new MyMap<>();
		
		empMap.put("e1","Prasad");
		empMap.put("e2", "Sai");
		System.out.println(empMap.get("e1"));
		System.out.println(empMap.containsKey("e2"));
		System.out.println(empMap.containsKey("e3"));

		
	}
	
}
