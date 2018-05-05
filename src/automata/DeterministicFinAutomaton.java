package automata;

import java.util.ArrayList;
import java.util.HashSet;

public class DeterministicFinAutomaton {
	private HashSet<String> states;
	private HashSet<String> inputSymbols;
	private String initialState;
	private ArrayList<ArrayList<String>> transitionFunction;
	private HashSet<String> acceptingStates;
	private String epsilon = "epsilon";
	
	/**
	 * @param states
	 * @param inputSymbols
	 * @param initialState
	 * @param transitionFunction
	 * @param acceptingStates
	 */
	public DeterministicFinAutomaton(HashSet<String> states, HashSet<String> inputSymbols, String initialState,
			ArrayList<ArrayList<String>> transitionFunction, HashSet<String> acceptingStates) {
		super();
		this.states = states;
		this.inputSymbols = inputSymbols;
		this.initialState = initialState;
		this.transitionFunction = transitionFunction;
		this.acceptingStates = acceptingStates;
	}
	public DeterministicFinAutomaton(NondeterministicFinAutomaton n) {
		
	}

	
	
	/**
	 * @return the states
	 */
	public HashSet<String> getStates() {
		return states;
	}
	/**
	 * @param states the states to set
	 */
	public void setStates(HashSet<String> states) {
		this.states = states;
	}
	/**
	 * @return the inputSymbols
	 */
	public HashSet<String> getInputSymbols() {
		return inputSymbols;
	}
	/**
	 * @param inputSymbols the inputSymbols to set
	 */
	public void setInputSymbols(HashSet<String> inputSymbols) {
		this.inputSymbols = inputSymbols;
	}
	/**
	 * @return the initialState
	 */
	public String getInitialState() {
		return initialState;
	}
	/**
	 * @param initialState the initialState to set
	 */
	public void setInitialState(String initialState) {
		this.initialState = initialState;
	}
	/**
	 * @return the transitionFunction
	 */
	public ArrayList<ArrayList<String>> getTransitionFunction() {
		return transitionFunction;
	}
	/**
	 * @param transitionFunction the transitionFunction to set
	 */
	public void setTransitionFunction(ArrayList<ArrayList<String>> transitionFunction) {
		this.transitionFunction = transitionFunction;
	}
	/**
	 * @return the acceptingStates
	 */
	public HashSet<String> getAcceptingStates() {
		return acceptingStates;
	}
	/**
	 * @param acceptingStates the acceptingStates to set
	 */
	public void setAcceptingStates(HashSet<String> acceptingStates) {
		this.acceptingStates = acceptingStates;
	}
	

}
