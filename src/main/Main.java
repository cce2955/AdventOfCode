package main;

import java.io.IOException;
import java.util.ArrayList;

import manhattanDistance.ManhattanDistance;
import passwordCheck.PassWordCheck;

public class Main {
	public static void main(String[] args) throws IOException {
		PassWordCheck pass = new PassWordCheck();
		
		int x = 0;
		int start = 278384;
		while (start <= 824795 ) {
			if(pass.parsePassWord(start)) {
				x++;
			}
			start++;
		}
		System.out.println(x);
	}
}
