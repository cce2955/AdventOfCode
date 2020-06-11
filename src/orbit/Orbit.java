package orbit;

import java.util.HashMap;
import java.util.Map;

public class Orbit {

	public String[] test = {"COM)B", "B)C", "C)D", "D)E", "E)F", "B)G", "G)H", "D)I", "E)J", "J)K", "K)L"};
	
	private int num;
	

	public HashMap<String,String> graph = new HashMap<>();
	public void generatePlanets() {
		for(String line : test) graph.put(line.split("\\)")[1], line.split("\\)")[0]);
	}
	// Due to "indirect orbits" mattering, it's easiest
	// to just traverse from the individual nodes to the root
	// so the map will represent child -> parent relationships
	public int orbitCountRecur(Map<String,String> graph, String currNode, int oCount){
	    if(currNode.equals("COM")) {
	    	return oCount;
	    }else{
	    	oCount++;
	    	return orbitCountRecur(graph, graph.get(currNode), oCount++);
	    }
	    
	}

	// This will give you the direct and indirect orbit counts
	// for a single node. Iterate over all nodes (keyset of
	// graph) to determine full count
	public int orbitCount(Map<String,String> graph, String node){
	    return orbitCountRecur(graph, node, 0);
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	

}