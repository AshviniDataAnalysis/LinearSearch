package com.logic;
import java.util.*;

public class binarySearch {
	public static void main(String[] args)
	{
		Scanner a = new Scanner(System.in);
		int array[]= new int[30];
		int find, n;
		int first, last, mid;
		System.out.println("Enter the Array Size");
		n= a.nextInt();
		System.out.println("Enter the Array Element");
		for(int i=0; i<n; i++)
		{
			array[i]= a.nextInt();
		}
		System.out.println("Enter the element to be found in the Array");
		find= a.nextInt();
		first=0;
		last= n-1;
		 while( first<= last)
		 {
			 mid=(first+last)/2;

			 if(array[mid]<find)
			 {
				 first= mid+1;
			 }
			 else 
		     {
				 if(array[mid]==find)
		         {
					 System.out.println("Element found at:--"+ (mid+1));
					 break;
		         }
				 else
				 {
					 last= mid-1;
				 }
		     }
			 	
						 
		 }
		 
		
		
	}

}
