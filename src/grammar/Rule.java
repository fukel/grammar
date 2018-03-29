package grammar;

import java.util.ArrayList;

public class Rule {
	private ArrayList<String> leftSide;
	private ArrayList<String> rightSide;
	
	/**
	 * @param leftSide
	 * @param rightSide
	 */
	public Rule(ArrayList<String> leftSide, ArrayList<String> rightSide) {
		super();
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}
	
	/**
	 * @return the leftSide
	 */
	public ArrayList<String> getLeftSide() {
		return leftSide;
	}
	/**
	 * @param leftSide the leftSide to set
	 */
	public void setLeftSide(ArrayList<String> leftSide) {
		this.leftSide = leftSide;
	}
	/**
	 * @return the symbols on the right side of the rule
	 */
	public ArrayList<String> getRightSide() {
		return rightSide;
	}
	/**
	 * @param rightSide the rightSide to set
	 */
	public void setRightSide(ArrayList<String> rightSide) {
		this.rightSide = rightSide;
	}
	
	

}
