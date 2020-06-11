package orbit;

import java.util.ArrayList;
import java.util.TreeMap;

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
			
			
		}
		
		for (int i = 0; i < Orbitee.size(); i++) {
			ArrayList<String> hold = new ArrayList<>();
			//Do a Reverse for loop, see if orbitee is in last index, skip if not
			//increment if so
			for (int x = i; x >= 0; x--) {
				hold.add(Orbitee.get(x));
				if(hold.contains(Orbitee.get(x))) {
					
					try{
						orbitTreeMap.put(Orbitee.get(x), orbitTreeMap.get(Orbitee.get(x)) + 1);
					}catch (NullPointerException e) {
						orbitTreeMap.put(Orbitee.get(x), 0);
					}
				}
				//System.out.println(Orbitee.get(x) + " " + Orbiter.get(x));
			}
			
			hold.clear();
			
		}
		System.out.println(orbitTreeMap);
		orbitTreeMap.forEach((key, value) ->{
			setNum(getNum() + value);
		});
		System.out.println(getNum());
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
