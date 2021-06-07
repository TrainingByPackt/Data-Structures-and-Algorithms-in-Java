package com.packt.datastructuresandalg.lesson1.activity.octaltodecimal;

public class OctalToDecimal {
    public int convertToDecimal(String octal) {
        /*
		 * Given: 75532
		 * formula => 2*8^0 + 3*8^1
		 */
		// the result to be displayed
		int output = 0;
		// the length of the input string
		int len = octal.length();
		
		for(int i = len-1; i >= 0; i--) {
			// the value of the char in integer
			int num = Integer.parseInt(octal.valueOf(octal.charAt(i)));
			output += (num * (int) Math.pow(8, (len-1)-i));
		}
		return output;
    }
}
