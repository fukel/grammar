package automata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Set;

public class DeterministicFinAutomaton {
	private ArrayList<HashSet<String>> states;
	private HashSet<String> inputSymbols;
	private HashSet<String> initialState;
	private HashMap<HashSet<String>,HashMap<String,HashSet<String>>> transitionFunction;
	private ArrayList<HashSet<String>> acceptingStates;
	private String epsilon = "epsilon";
	


	public DeterministicFinAutomaton(NondeterministicFinAutomaton n) {
		this.inputSymbols=n.getInputSymbols();
		//System.out.println("TEST1 "+String.valueOf(n.getTransitionFunction().getColumnHeaders()));
		//removes epsilon from input symbols of DKA
		/*if(this.inputSymbols.contains("epsilon")) {
			this.inputSymbols.remove("epsilon");
			
		}*/
		//System.out.println("TEST2 "+String.valueOf(n.getTransitionFunction().getColumnHeaders()));
		
		System.out.println("DFA InputSymbols:");
		for(String s : this.inputSymbols) {
			System.out.print(s+",");
		}
		System.out.print("\n");
		
		//adds closure of initial state of NFA to initial state of DKA
		HashSet<String> pom = new HashSet<String>();
		pom.add(n.getInitialState());
		this.initialState=closure(pom,n.getTransitionFunction());
		
		System.out.println("Closure of initial state:");
		for(String s : this.initialState) {
			System.out.print(s+",");
		}
		System.out.print("\n");
		
		//adds result to states of DKA
		this.states= new ArrayList<HashSet<String>>();
		this.states.add(initialState);
		
		//initialize of transition function
		this.transitionFunction= new HashMap<HashSet<String>,HashMap<String,HashSet<String>>>();
		
		//for all states of DKA
		
		for(int i = 0;i<this.states.size();i++) {	//this.states.size
			System.out.println("iteracia "+String.valueOf(i));
			
			//gets state of DKA
			HashSet<String> state = states.get(i);
			
			System.out.print("actual state:");
			for(String s : state) {
				System.out.print(s+",");
			}
			System.out.print("\n");
			HashMap<String, HashSet<String>> pomocna = new HashMap<String, HashSet<String>>();
			

			
			//finds result state of state at input symbol
			for(String is : this.inputSymbols) {
				//help variables
				ArrayList<String> pomAL;
				HashSet<String> pomresult= new HashSet<String>();
				HashSet<String> result= new HashSet<String>();
				System.out.println("actual input symbol "+is);
				if(!is.equals("epsilon")) {
					for(String stInNKA :state) {
						pomAL=n.getTransitionFunction().getAL(stInNKA, is);
						System.out.println("stInNKA "+stInNKA + " input symbol "+ is);
						System.out.print("pomAL:");
						for(String s:pomAL) {
							System.out.print(s+",");
						}
						System.out.print("\n");
						//wont add "-" to the result
						for (String s : pomAL) {
							if(!s.equals("-")) {
								pomresult.add(s);
							}
						}
						System.out.println("pomresult ");
						
						for(String s : pomresult) {
							result.add(s);
							System.out.print(s+",");
						}
						System.out.print("\n");
						//closure of all states in NKA
						pomresult = closure(result,n.getTransitionFunction());
						
						System.out.println("closure of pomresult ");
					
						for(String s : pomresult) {
							result.add(s);
							System.out.print(s+",");
						}
						System.out.print("\n");
						
					}
				
					System.out.println("result ");
					for(String s :result) {
						System.out.print(s+",");
					}
					System.out.print("\n");
					
					if(result.size()>0) {
						//if states doesnt contain result adds result to states of DKA
						if(!states.contains(result)) {
							states.add(result);
						}
						
						//adds result to the transition function of DKA
						
						pomocna.put(is, result);
						
						System.out.println("Adding to hashmap of state: "+state+" at input symbol "+is);
						for(String s :result) {
							System.out.print(s+",");
						}
						System.out.print("\n");
						
					}
				}
			}
			if(!pomocna.isEmpty()) {
				this.transitionFunction.put(state, pomocna);
				System.out.println("----zaciatok TF . get "+state+" ---");
				System.out.println(this.transitionFunction.get(state));
				System.out.println("----koniec TF . get ---");
			}
		}
		//finds accepting states in set of states
		this.acceptingStates = new ArrayList<HashSet<String>>();
		for (int i=0;i<this.states.size();i++) {
			for(String s:n.getAcceptingStates()) {
				if(this.states.get(i).contains(s)) {
					if(!this.acceptingStates.contains(this.states.get(i))) {
						this.acceptingStates.add(this.states.get(i));
					}
				}
			
				
		}
		}
		
	}
	
	private HashSet<String> closure (HashSet<String> states, TransitionFunction transitionFunction){
		ArrayList<String> pom = new ArrayList<String>();
		ArrayList<String> statesAL = new ArrayList<String>(states);
		ArrayList<String> pom2 = new ArrayList<String>();
		System.out.println("----zaciatok closure--- ");
		//if there is epsilon defined as input symbol
		if(transitionFunction.getColumnHeaders().contains("epsilon")){
			
			do {
				//stores initial set of states
				pom=statesAL;
				ListIterator<String> it = statesAL.listIterator();
				while(it.hasNext()) {
					String s = it.next();
					System.out.println("State "+s);
					//adds states, to which automaton can get on epsilon
					pom2=transitionFunction.getAL(s, "epsilon");
					for(int i=0;i<pom2.size();i++) {
						//state cant be "-"
						if(!pom2.get(i).equals("-")) {
							it.add(pom2.get(i));
							System.out.println("adding "+pom2.get(i));
						}
					}
				}
			}
			while(pom.size()!=statesAL.size());
		}
			
		System.out.println("----koniec closure--- ");
		states = new HashSet<String>(statesAL);
		return states;
		
	}
	
	public void showDFA() {
		System.out.println("---------showDFA------------");
		System.out.println("States of DFA:");
		for(int i = 0;i<states.size();i++) {
			for(String s : states.get(i)) {
				System.out.print(s + ",");
			}
			System.out.print("\n");
		}
		System.out.println("Transition Function:");
		for (Map.Entry<HashSet<String>,HashMap<String,HashSet<String>>> entry : transitionFunction.entrySet()) {
		    System.out.println(entry.getKey()+" : "+entry.getValue());
		}
	}

	

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
	 * @return the states
	 */
	public ArrayList<HashSet<String>> getStates() {
		return states;
	}

	/**
	 * @param states the states to set
	 */
	public void setStates(ArrayList<HashSet<String>> states) {
		this.states = states;
	}

	/**
	 * @return the initialState
	 */
	public HashSet<String> getInitialState() {
		return initialState;
	}

	/**
	 * @param initialState the initialState to set
	 */
	public void setInitialState(HashSet<String> initialState) {
		this.initialState = initialState;
	}

	/**
	 * @return the transitionFunction
	 */
	public HashMap<HashSet<String>, HashMap<String, HashSet<String>>> getTransitionFunction() {
		return transitionFunction;
	}

	/**
	 * @param transitionFunction the transitionFunction to set
	 */
	public void setTransitionFunction(HashMap<HashSet<String>, HashMap<String, HashSet<String>>> transitionFunction) {
		this.transitionFunction = transitionFunction;
	}

	/**
	 * @return the acceptingStates
	 */
	public ArrayList<HashSet<String>> getAcceptingStates() {
		return acceptingStates;
	}

	/**
	 * @param acceptingStates the acceptingStates to set
	 */
	public void setAcceptingStates(ArrayList<HashSet<String>> acceptingStates) {
		this.acceptingStates = acceptingStates;
	}

	/**
	 * @return the epsilon
	 */
	public String getEpsilon() {
		return epsilon;
	}

	/**
	 * @param epsilon the epsilon to set
	 */
	public void setEpsilon(String epsilon) {
		this.epsilon = epsilon;
	}
	




	

}
