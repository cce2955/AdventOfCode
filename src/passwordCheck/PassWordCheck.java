package passwordCheck;

import java.util.ArrayList;
import java.util.Arrays;

public class PassWordCheck {
	
	public boolean check (int n) {
		String str = n + "";
		
		//decreasing condition
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) < str.charAt(i - 1)) {
				return false;
				//If order isn't ascending leave
			}
		}
			 
				
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (int i = 0; i < str.length(); i++) {
			 count[str.charAt(i) - '0']++;
			 
		}
		for (int i = 0; i < 10; i++) {
			if (count[i] == 2) {
				return true;
			}
		}
		return false;

	}
}
	