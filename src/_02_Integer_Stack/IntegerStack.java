package _02_Integer_Stack;

public class IntegerStack {
	//1. create a private array of integers
	private int[] cool;
	//2. complete the constructor by initializing the member array
	//   to a new array of length 0. This prevents null pointer exceptions.
	public IntegerStack() {
		cool = new int[0];
	}
	
	//3. Complete the steps in the push method.
	public void push(int v) {
		//A. create a new array that is one element larger than the member array
		int[] first = new int[cool.length+1];
		//B. set the last element of the new array equal to the integer passed into the method
		first[first.length-1]=v;
		//C. iterate through the member array and copy all the elements into the new array
		for(int i = 0;i<first.length-1;i++) {
			first[i]=cool[i];
		}
		//D. set the member array equal to the new array.
		cool = first;
	}
	
	//4. Complete the steps in the pop method.
	public int pop() {
		//A. create an integer variable and initialize it to the
		//   last element of the member array.
		int pop = cool[cool.length-1];
		//B. create a new array that is one element smaller than the member array
		int[] seccond = new int[cool.length-1];
		//C. iterate through the new array and copy every element from the
		//   member array to the new array
		for(int i = 0;i<seccond.length;i++) {
			seccond[i]=cool[i];
		}
		//D. set the member array equal to the new array
		cool = seccond;
		for(int i = 0;i<cool.length-1;i++) {
		System.out.println(cool[i]);
		}
		//E. return the variable you created in step A
		return pop;
	}
	
	//5. Complete the clear method to set the
	//   member array to a new array of length 0
	public void clear() {
		int[] nothing = new int[0];
		cool = nothing;
	}
	
	//6. Complete the size method to return 
	//   the length of the member array
	public int size() {
		return cool.length;
	}
}
