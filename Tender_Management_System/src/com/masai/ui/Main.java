package com.masai.UI;

import java.util.Scanner;

public class Main {
	
	static void Vendor(Scanner sc) {
		System.out.println("Welcome Vendor");
		
	}

	static void Administrator(Scanner sc) {
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-***-");
		System.out.println("Welcome Administrator");
		
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		
		do {
			System.out.println("1. Administrator");
			System.out.println("2. Vendor");
			
			choice=sc.nextInt();
			switch(choice) {
				case 1:
					Administrator(sc);
					break;
					
				case 2:
					Vendor(sc);
					break;
					
				default:
					System.out.println("Please Select Correct Option");
			}
		}
		while(choice!=0);
		sc.close();
	}



}
