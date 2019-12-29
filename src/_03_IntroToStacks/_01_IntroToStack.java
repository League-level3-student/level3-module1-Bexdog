package _03_IntroToStacks;

import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class _01_IntroToStack {
	public static void main(String[] args) {
		//1. Create a Stack of Doubles
		//   Don't forget to import the Stack class
		Stack<Double> numbers = new Stack<Double>();
		//2. Use a loop to push 100 random doubles between 0 and 100 to the Stack.
		Double randy = new Random().nextDouble()*100;
		for(int i = 0;i<100; i++) {
			numbers.push(randy);
			randy = new Random().nextDouble()*100;
		}
		//3. Ask the user to enter in two numbers between 0 and 100, inclusive. 
		String Input1 = JOptionPane.showInputDialog("enter a number between 0 and 100, inclusive");
		String Input2 = JOptionPane.showInputDialog("enter another number between 0 and 100, inclusive");
		int input1 = Integer.parseInt(Input1);
		int input2 = Integer.parseInt(Input2);
		//4. Pop all the elements off of the Stack. Every time a double is popped that is
		//   between the two numbers entered by the user, print it to the screen.
		for(int i = 0;i<numbers.size(); i++) {
			double popped = numbers.pop();
			if((input1<popped&&popped<input2)||(input2<popped&&popped<input1)) {
				JOptionPane.showMessageDialog(null,popped);
			}
		}
		
		//   EXAMPLE:
		//   NUM 1: 65
		//   NUM 2: 75
		
		//   Popping elements off stack...
		//   Elements between 65 and 75:
		//   66.66876846
		//   74.51651681
		//   70.05110654
		//   69.21350456
		//   71.54506465
		//   66.47984807
		//   74.12121224
	}
}
