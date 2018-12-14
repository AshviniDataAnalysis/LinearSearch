package com.logic;
import java.util.Iterator;

public class HashSet {
   public static void main(String args[]) {
      // HashSet declaration
      HashSet hset =   new HashSet();

      // Adding elements to the HashSet
      hset.add("Apple");
      hset.add("Mango");
      hset.add("Grapes");
      hset.add("Orange");
      hset.add("Fig");
      //Addition of duplicate elements
      hset.add("Apple");
      hset.add("Mango");
      //Addition of null values
      hset.add(null);
      hset.add(null);

      //Displaying HashSet elements
      System.out.println(hset);
      Iterator aq= hset.iterator();
      while(aq.hasNext())
      {
    	  System.out.println(aq.next());
      }
    }

private Iterator iterator() {
	// TODO Auto-generated method stub
	return null;
}

private void add(String string) {
	// TODO Auto-generated method stub
	
}
}