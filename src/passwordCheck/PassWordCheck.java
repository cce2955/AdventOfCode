package passwordCheck;

import java.util.ArrayList;

public class PassWordCheck {
	private int passWordMin, passWordMax;
	private boolean pass;
	private ArrayList<Integer> passArr = new ArrayList<>();
	public ArrayList<Integer> integerToArray(int num){
		ArrayList<Integer> store = new ArrayList<>();		
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		if(sb.length() < 6 || sb.length() > 6) {
			System.out.println("Not a valid input, 6 characters only");
			return null;
		}
		for(int i = 0; i < sb.length(); i++) {
			store.add(Integer.valueOf(String.valueOf((sb.charAt(i)))));
			// :/.......
		}
		
		return store;
	}
	
	public boolean parsePassWord (int input) {
		setPassArr(integerToArray(input));
		
		for (int i = 1; i < getPassArr().size(); i++) {
			for (int x = 1; x < getPassArr().size(); x++) {
				if(getPassArr().get(x) < getPassArr().get(x - 1)) {
					return false;
				}		
			}
			if(getPassArr().get(i).equals(getPassArr().get(i - 1))) {
				return true;
			}
		}
		return false;
	}
	public int getPassWordMin() {
		return passWordMin;
	}

	public void setPassWordMin(int passWordMin) {
		this.passWordMin = passWordMin;
	}

	public int getPassWordMax() {
		return passWordMax;
	}

	public void setPassWordMax(int passWordMax) {
		this.passWordMax = passWordMax;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}

	public ArrayList<Integer> getPassArr() {
		return passArr;
	}

	public void setPassArr(ArrayList<Integer> passArr) {
		this.passArr = passArr;
	}
	
	
}
