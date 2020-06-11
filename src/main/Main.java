package main;

import java.io.IOException;
import java.util.ArrayList;

import intCode.ThermalEnvironmentSupervisionTerminal;
import manhattanDistance.ManhattanDistance;
import passwordCheck.PassWordCheck;

public class Main {
	public static void main(String[] args) throws IOException {
	ThermalEnvironmentSupervisionTerminal TEST = new ThermalEnvironmentSupervisionTerminal();
		System.out.println(TEST.execute(TEST.arr, 1));
		System.out.println(TEST.execute(TEST.arr, 5));
	
	}
}

