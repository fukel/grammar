package grammar;

public class Rule {
	/**
	 * @param leftSide
	 * @param rightSide
	 */
	public Rule(String leftSide, String rightSide) {
		super();
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}
	String leftSide;
	String rightSide;
	/**
	 * @return the leftSide
	 */
	public String getLeftSide() {
		return leftSide;
	}
	/**
	 * @param leftSide the leftSide to set
	 */
	public void setLeftSide(String leftSide) {
		this.leftSide = leftSide;
	}
	/**
	 * @return the rightSide
	 */
	public String getRightSide() {
		return rightSide;
	}
	/**
	 * @param rightSide the rightSide to set
	 */
	public void setRightSide(String rightSide) {
		this.rightSide = rightSide;
	}
	
	

}
