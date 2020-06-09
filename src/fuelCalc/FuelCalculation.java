package fuelCalc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FuelCalculation {
	private int fuel;
	
	private int num;
	private ArrayList<Integer> totalFuel = new ArrayList<>();
	//--------
	//Just for the interest of this project
	public File file = new File("C:\\Users\\Christopher.everett\\Documents\\workspace-spring-tool-suite-4-4.6.2.RELEASE\\AdventOfCode\\src\\main\\FuelList.txt");
	//---------
	
	public int gatherFuelData(int num) {
			//A module of mass  is X, X/3 - 2 = Y
			//if Y > 0, repeat
			int sum = 0;
			setNum(num);
			while(getNum()/3 - 2 > 0) {
				setNum(getNum()/3 - 2);
				sum += getNum(); 
			}
			return sum;
	}
	public ArrayList<Integer> gatherFromSource(File file) throws NumberFormatException, IOException{
		//Call this method with the file to generate an array of values
		ArrayList<Integer> intArr = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st; 
		while ((st = br.readLine()) != null) {
		 // Integer.valueOf(st);
		    intArr.add(Integer.valueOf(st));
		  }
		setTotalFuel(intArr);
		return getTotalFuel(); 
		//Day 1 Answer should produce 5020494 or day 2? I'm not sure but it's done
	}
	public int getFuel() {
		return fuel;
	}
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public ArrayList<Integer> getTotalFuel() {
		return totalFuel;
	}
	public void setTotalFuel(ArrayList<Integer> totalFuel) {
		this.totalFuel = totalFuel;
	}
	
}