/*
 * Paul McNeil
 * Sogeti Code Challenge
 */

import java.util.ArrayList;
import java.util.Arrays;

class AddUp {
	
    static void addUp(ArrayList<Integer> numbers, int target, ArrayList<Integer> temp, int set_size) {
       
    	int sum = 0;
    	
    	// used for overcounting 
    	if(temp.size() == set_size){
    		for(int i = 0; i < temp.size(); i++){
    			sum += temp.get(i);
    		}
    	}
/*    		
    	if( sum > numbers.size())
    		return;
*/    	
       if (sum == target){
    	   for(int i = 0; i < temp.size(); i++){
    		   if(i == temp.size()-1)
    			   System.out.println(temp.get(i));
    		   else
    			   System.out.print(temp.get(i) + ",");
    	   }
       }
            
       if (sum >= target){
    	   return;
       }
            
       for(int i = 0; i < numbers.size(); i++){
    	  // if(i == 0)	
    		   //System.out.println("in for loop");
             ArrayList<Integer> numbersLeft = new ArrayList<Integer>();
             int n = numbers.get(i);
             
             for(int j = i+1; j < numbers.size(); j++){
            	 numbersLeft.add(numbers.get(j));
             }
            	 
             ArrayList<Integer> tempArr = new ArrayList<Integer>(temp);
            
             tempArr.add(n);
            
             addUp(numbersLeft,target,tempArr, set_size);
       }
    }
    
    static void addUpAll(ArrayList<Integer> numbers, int target, int set_size) {
    	//System.out.println("in addUpAll");
        addUp(numbers, target, new ArrayList<Integer>(), set_size);

    }
    
    static void foo(int start, int end, int target, int set_size){
    	
    	int size = (end - start)+1;
    	Integer[] numbers = new Integer[size];
    	for(int i = 0; i < numbers.length; i++){
    		numbers[i] = i+1;
    	}
    	
    	addUpAll(new ArrayList<Integer>(Arrays.asList(numbers)),target, set_size);
    }
    
    public static void main(String args[]) {
    	
    	foo(1,25,30,2);
         
    }
}

