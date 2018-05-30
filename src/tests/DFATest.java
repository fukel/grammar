package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import automata.DeterministicFinAutomaton;
import automata.NondeterministicFinAutomaton;
import automata.TransitionFunction;
import grammar.Grammar;
import grammar.RegularGrammar;
import grammar.Rule;

public class DFATest {
	HashSet<String> terminals3;
	HashSet<String> nonterminals3;
	Rule rule19;
	Rule rule20;
	Rule rule21;
	Rule rule22;
	Rule rule23;
	
	HashSet<String> states, inputSymbols,acceptingStates,states2, inputSymbols2,acceptingStates2;
	String initialState,initialState2;
	TransitionFunction tf,tf2;
	
	
	HashSet<Rule> rules3;
	String startsymbol3;
	RegularGrammar g3;
	NondeterministicFinAutomaton n3,n4,n2;

	@Before
	public void setUp() throws Exception {
		
		terminals3 = new HashSet<String>(Arrays.asList("a","b","c"));		//Set of terminals
		nonterminals3 = new HashSet<String>(Arrays.asList("S","A"));
		
		rule19 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("a","S")));
		rule20 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("b","A")));
		rule21 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("epsilon")));
		rule22 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("c","A")));

		rules3= new HashSet<Rule>(Arrays.asList(rule19,rule20,rule21,rule22));
		
		startsymbol3 = "S";
		
		g3 = new RegularGrammar(terminals3, nonterminals3, rules3, startsymbol3);
		n3 = new NondeterministicFinAutomaton((RegularGrammar) g3);
		
		/*transition function of n3
		 	[-, epsilon, a, b, c]
			[A, q, -, -, A]
			[q, -, -, -, -]
			[S, -, S, A, -]
		 * 
		 */
		
		
		states = new HashSet<String>();
		inputSymbols = new HashSet<String>();
		acceptingStates = new HashSet<String>();
		states.add("A");
		states.add("C");
		states.add("E");
		states.add("q");
		states.add("F");
		acceptingStates.add("q");
		acceptingStates.add("A");
		inputSymbols.add("a");
		inputSymbols.add("b");
		inputSymbols.add("epsilon");
		
		tf = new TransitionFunction(states,inputSymbols);
		tf.add("A", "a", "C#E");
		tf.add("A", "epsilon", "E");
		tf.add("C", "b", "E");
		tf.add("C", "epsilon","F");
		tf.add("E", "a", "q");
		tf.add("F", "a", "C");
		
		initialState=new String("A");
		
		n4=new NondeterministicFinAutomaton(states, inputSymbols, initialState, tf, acceptingStates);
		
		/*transition function of n4
	 	[-, epsilon, a, b]
		[A, E, C#E, -]
		[q, -, -, -]
		[C, F, -, E]
		[E, -, q, -]
		[F, -, C, -]
	 * 
	 */
		states2 = new HashSet<String>();
		inputSymbols2 = new HashSet<String>();
		acceptingStates2 = new HashSet<String>();
		states2.add("q0");
		states2.add("q1");
		states2.add("q2");
		states2.add("q3");
		states2.add("qf");
		acceptingStates2.add("qf");
		inputSymbols2.add("0");
		inputSymbols2.add("1");
		inputSymbols2.add("epsilon");
		tf2 = new TransitionFunction(states2,inputSymbols2);
		tf2.add("q0", "0", "q0#q1");
		tf2.add("q0", "1", "q0#q2");
		tf2.add("q1", "0", "q1#q3");
		tf2.add("q1", "1", "q1");
		tf2.add("q2", "0", "q2");
		tf2.add("q2", "1", "q2#qf");
		tf2.add("q3", "0", "q3");
		tf2.add("q3", "epsilon", "qf");
		
		initialState2=new String("q0");
		n2=new NondeterministicFinAutomaton(states2, inputSymbols2, initialState2, tf2, acceptingStates2);

		

		
		
	}

	@Test
	public void test() {
		try {
			DeterministicFinAutomaton d4 = new DeterministicFinAutomaton( n4);
			d4.showDFA();
			/*
			 Transition Function of d4:
			 Format: [State] : {inputSymbol=[resultState]}
			 
				[E] : {a=[q]}
				[A, E] : {a=[q, C, E, F]}
				[C, F] : {a=[C, F], b=[E]}
				[q, C, F] : {a=[C, F], b=[E]}
				[q, C, E, F] : {a=[q, C, F], b=[E]}
				
			 */
			
			
			
			DeterministicFinAutomaton d3 = new DeterministicFinAutomaton(n3);
			

			
			d3.showDFA();
			
			
			/*
			 Transition Function of d3:
			 Format: [State] : {inputSymbol=[resultState]}
			 
				[A, q] : {c=[A, q]}
				[S] : {a=[S], b=[A, q]}
			 */
			
			DeterministicFinAutomaton d5 = new DeterministicFinAutomaton( g3);
			d5.showDFA();
			
			/*
			HashSet<String> set = new HashSet<String>();
			set.add("S");
			HashMap<String, HashSet<String>> pom = d3.getTransitionFunction().get(set);
			System.out.println(pom);
			System.out.println(pom.get("a"));*/
			
			DeterministicFinAutomaton d2 = new DeterministicFinAutomaton( n2);
			
			d2.showDFA();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexpected exception");
			
		}	}

}
