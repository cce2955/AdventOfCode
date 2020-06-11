package orbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.lang.Object;
import javax.swing.tree.TreeNode;
import javax.xml.soap.Node;

public class Orbit {
/*COM)B
B)C
C)D
D)E
E)F
B)G
G)H
D)I
E)J
J)K
K)L*/
	public String[] test = {"COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L"};
	private int num;
	//Could've used a hash map but too late
	//The first treemap monitors how many planets are orbiting around the Key
	
	TreeMap<String, Integer> orbitTreeMap = new TreeMap<>();
	TreeMap<String,String> orbitPairMap = new TreeMap<>();
	public void findOrbit(String[] input) {
		ArrayList<String> Orbitee = new ArrayList<>();
		ArrayList<String> Orbiter = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		
		
		
		for (int i = 0; i < input.length; i++) {
			sb.append(input[i]);
			//Create arrayList of planets to be orbited around
			Orbitee.add(sb.substring(0, sb.indexOf(")")));
			//Create Arraylist of planets that are orbiting
			Orbiter.add(sb.substring(sb.indexOf(")") + 1, sb.length()));
			sb.delete(0, sb.length());
	
			//init orbit counter
			orbitPairMap.put(Orbitee.get(i), Orbiter.get(i));
		}
		
        
        
		for(String plt : orbitPairMap.keySet()) {
			if (orbitPairMap.containsKey(plt)){
				try {
					orbitTreeMap.put(plt, orbitTreeMap.get(plt) + 1);
				} catch (NullPointerException e) {
					orbitTreeMap.put(plt, 0);
				}
				
	         }
			 
			System.out.println("planet " + plt + " orbits " + orbitPairMap.get(plt));
		}
		System.out.println(orbitPairMap.size());
			
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
