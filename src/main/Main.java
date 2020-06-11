package main;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import orbit.Orbit;

public class Main {
	public static void main(String[] args) throws IOException {
		Orbit orbit = new Orbit();
		
		orbit.generatePlanets();
		// Since this is a tree traversal, recursion is your friend
		orbit.setNum(0);
		orbit.graph.forEach((key, value) ->{
			
			
			orbit.setNum(orbit.orbitCount(orbit.graph, key) + orbit.getNum());
		});
		
		System.out.println(orbit.getNum());
				
	}
	}
