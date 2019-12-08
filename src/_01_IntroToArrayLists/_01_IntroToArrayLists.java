package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
String[] cool= {"hello", "glob","yo moma","hi","me"};
		//2. Add five Strings to your list
		
		//3. Print all the Strings using a standard for-loop
		for(int i = 0; i<cool.length;i++) {
			System.out.println(cool[i]);
		}
		
		//4. Print all the Strings using a for-each loop
		for(String s:cool) {
			System.out.println(s);
		}			
		//5. Print only the even numbered elements in the list.
		for(int i = 0; i<cool.length;i+=2) {
			System.out.println(cool[i]);
		}
		//6. Print all the Strings in reverse order.
		for(int i = cool.length-1; i>=0;i--) {
			System.out.println(cool[i]);
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for(String s:cool) {
			if(s.contains("e")) {
			System.out.println(s);
			}
		}
	}
}
