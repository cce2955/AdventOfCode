package main;

import java.io.IOException;
import java.util.ArrayList;

import manhattanDistance.ManhattanDistance;
import passwordCheck.PassWordCheck;

public class Main {
	public static void main(String[] args) throws IOException {
			PassWordCheck pass = new PassWordCheck();
			
			//278384-824795
			int truest = 0;
			int x = 278384;
			int y = 823000 ;
			while (x <= 824795) {
				if(pass.check(x)) {
					truest++;
					
				}
				x++;			
			}
			
			System.out.println(truest);
	}
}

