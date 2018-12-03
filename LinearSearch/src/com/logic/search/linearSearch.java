package com.logic.search;
import java.util.*;
public class linearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner ob = new Scanner(System.in);
        int a[]= new int[10];
        int find,n;
            System.out.println("Enter the array size");
            n= ob.nextInt();
            System.out.println("Enter the array element");
            for(int i=0; i<n; i++)
            {
                a[i]= ob.nextInt();
            }
            System.out.println("Enter element to be found");
            find=ob.nextInt();
        for(int j=0; j<n; j++)
        {
            if(find==a[j])
            {
                System.out.println(find+": found at:--"+(j+1));
            }
            
        }

	}

}
