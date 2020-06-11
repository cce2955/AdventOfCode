package intCode;

import java.util.ArrayList;

public class OpCode {
	
	private ArrayList<Integer> opCodeArr = new ArrayList<>();
	
	private enum intCodeState{
		ADDITION, MULTIPLY, EXIT, IGNORE;
	}
	
	intCodeState iCState;
	int[] intArr = {/*1,0,0,3*/1,22,54,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,13,19,1,10,19,23,
			2,9,23,27,1,6,27,31,1,10,31,35,1,35,10,39,1,9,39,43,1,6,43,
			47,1,10,47,51,1,6,51,55,2,13,55,59,1,6,59,63,1,10,63,67,2,67,
			9,71,1,71,5,75,1,13,75,79,2,79,13,83,1,83,9,87,2,10,87,91,2,
			91,6,95,2,13,95,99,1,10,99,103,2,9,103,107,1,107,5,111,2,9,111,
			115,1,5,115,119,1,9,119,123,2,123,6,127,1,5,127,131,1,10,
			131,135,1,135,6,139,1,139,5,143,1,143,9,147,1,5,147,151,1,151,
			13,155,1,5,155,159,1,2,159,163,1,163,6,0,99,2,0,14,0
	};
	
	private boolean quit;
	

	
	public ArrayList<Integer> runOpProgram() {
		setQuit(false);
		for (int i = 0; i < getOpCodeArr().size(); i++) {
			if(i % 4 == 0) {
				setiCState(getOpCodeArr().get(i));
			}
			switch (getiCState()) {
			case ADDITION:
				//Set whatever position returns at the fouth index
				//by adding whatever is produced from the second and third index
				getOpCodeArr().set(getOpCodeArr().get(i+3), 
						add(getOpCodeArr().get(getOpCodeArr().get(i+1)), 
								getOpCodeArr().get(getOpCodeArr().get(i+2))));

				setiCState(0);//Set it back to ignore
				break;
			case MULTIPLY:
				getOpCodeArr().set(getOpCodeArr().get(i+3), 
						mul(getOpCodeArr().get(getOpCodeArr().get(i+1)), 
								getOpCodeArr().get(getOpCodeArr().get(i+2))));
				
				setiCState(0);//Set it back to ignore
				break;
			case EXIT:
				setQuit(true);
				break;
			case IGNORE:
				break;
			default:
				System.out.println("Reproduce and report");
			}
			if(isQuit()) {
				break;
			}
		}
		return getOpCodeArr();
		
	}
	public ArrayList<Integer> getOpCodeArr() {
		return opCodeArr;
	}

	public void setOpCodeArr(int[] arr)  {
		for (int i = 0; i < arr.length; i++) {
			this.opCodeArr.add(arr[i]);
		}
		
	}
	
	public intCodeState getiCState() {
		return iCState;
	}
	private int add (int num, int num2) {
		return num + num2;
	}
	private int mul (int num, int num2) {
		return num * num2;
	}
	public boolean isQuit() {
		return quit;
	}

	public void setQuit(boolean quit) {
		this.quit = quit;
	}

	public void setiCState(int num) {
		switch(num) {
		case 1:
			this.iCState = intCodeState.ADDITION;
			break;
		case 2:
			this.iCState = intCodeState.MULTIPLY;
			break;
		case 99:
			this.iCState = intCodeState.EXIT;
			break;
		default:
			this.iCState = intCodeState.IGNORE;
		}
		
	}

	
}
