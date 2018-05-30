package automata;

import java.util.HashSet;

import grammar.RegularGrammar;
import grammar.Rule;

public class NondeterministicFinAutomaton {

	private HashSet<String> states;
	private HashSet<String> inputSymbols;
	private String initialState;
	private TransitionFunction transitionFunction;
	private HashSet<String> acceptingStates;
	private String epsilon = "epsilon";
	private String qf = "q";
		/**
	 * @param states
	 * @param inputSymbols
	 * @param initialState
	 * @param transitionFunction
	 * @param acceptingStates
	 */
	public NondeterministicFinAutomaton(HashSet<String> states, HashSet<String> inputSymbols, String initialState,
			TransitionFunction transitionFunction, HashSet<String> acceptingStates) {
		super();
		this.states = states;
		this.inputSymbols = inputSymbols;
		this.initialState = initialState;
		this.transitionFunction = transitionFunction;
		this.acceptingStates = acceptingStates;
	}
	
	public NondeterministicFinAutomaton(RegularGrammar g) throws Exception {
		this.states=g.getNonterminals();
		this.states.add(qf);
		this.inputSymbols=g.getTerminals();
		

		
		//if there is an epsilon in right side of the rules, adds epsilon to inputSymbols
		int pom=0;
		for (Rule r : g.getRules()) {
			if(r.getRightSide().get(0).equals("epsilon")) {
				pom++;
			}
		}
		if(pom>0) {
			this.inputSymbols.add("epsilon");
		}
		
		/*System.out.println("NFA inputsymbols after: ");
		for(String s:this.inputSymbols) {
			System.out.print(s+",");
		}
		System.out.print("\n");*/
		
		
		this.initialState=g.getStartsymbol();
		this.acceptingStates = new HashSet<String>();
		if(g.getStartrule().getRightSide().equals("epsilon")) {
			this.acceptingStates.add(g.getStartsymbol());
		}
		this.acceptingStates.add(qf);

		this.transitionFunction = new TransitionFunction(this.states, this.inputSymbols);
		for (Rule r : g.getRules()) {
			if(r.getRightSide().size()==1) {
				this.transitionFunction.add(r.getLeftSide().get(0), r.getRightSide().get(0), qf);
			}
			else if(r.getRightSide().size()==2) {
				this.transitionFunction.add(r.getLeftSide().get(0), r.getRightSide().get(0), r.getRightSide().get(1));
			}
			else {
				throw new Exception("Grammar is not regular");
			}
			
		}
		//this.transitionFunction.showTable();

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
		public TransitionFunction getTransitionFunction() {
			return transitionFunction;
		}
		/**
		 * @param transitionFunction the transitionFunction to set
		 */
		public void setTransitionFunction(TransitionFunction transitionFunction) {
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
