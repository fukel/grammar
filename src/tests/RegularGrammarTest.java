package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import automata.NondeterministicFinAutomaton;
import automata.TransitionFunction;
import grammar.Grammar;
import grammar.RegularGrammar;
import grammar.Rule;

public class RegularGrammarTest {
	HashSet<String> terminals;
	HashSet<String> nonterminals;
	
	Rule rule1;
	Rule rule2;
	Rule rule3;
	Rule rule4;
	Rule rule5;
	Rule rule6;
	
	HashSet<Rule> rules1;
	HashSet<Rule> rules2;
	HashSet<Rule> rules3;
	HashSet<Rule> rules4;
	HashSet<Rule> rules5;
	
	String startsymbol = "A";

	@Before
	public void setUp() throws Exception {
		terminals = new HashSet<String>(Arrays.asList("a","b"));		//Set of terminals
		nonterminals = new HashSet<String>(Arrays.asList("A","B"));
		
		rule1 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("a","B")));
		rule2 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("b")));
		
		rule3 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("b","A","b"))); //test2 contains 3 symbols
		
		rule4 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("B","a")));	//test3 right side starts with nonterminal
		
		rule5 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("B")));		//test4 right side starts with nonterminal(only one symbol|
		
		rule6 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("b","a")));	//test5 second symbol is nonterminal
		
		rules1= new HashSet<Rule>(Arrays.asList(rule1,rule2));	//test1
		rules2= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3));	//test2
		rules3= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule4));	//test3
		rules4= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule5));	//test4
		rules5= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule6));	//test5
		
		/*TransitionFunction f = new TransitionFunction(nonterminals,terminals);
		f.showTable();
		f.add("A", "a", "1");
		f.showTable();*/
		Grammar g = new RegularGrammar(terminals, nonterminals, rules1, startsymbol);
		
		//NondeterministicFinAutomaton a = new NondeterministicFinAutomaton((RegularGrammar) g);
	}

	@Test
	public void test1() {
		try {
			Grammar g = new RegularGrammar(terminals, nonterminals, rules1, startsymbol);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Unexpected exception");
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		try {
			Grammar g = new RegularGrammar(terminals, nonterminals, rules2, startsymbol);
			fail("Expected exception:Right sides of rules should be made only from 2 symbols");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}
	@Test
	public void test3() {
		try {
			Grammar g = new RegularGrammar(terminals, nonterminals, rules3, startsymbol);
			fail("Expected exception:First symbol of right side of rule should be terminal");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test4() {
		try {
			Grammar g = new RegularGrammar(terminals, nonterminals, rules4, startsymbol);
			fail("Expected exception:First symbol of right side of rule should be terminal");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test5() {
		try {
			Grammar g = new RegularGrammar(terminals, nonterminals, rules5, startsymbol);
			fail("Expected exception:Second symbol of right side of rule should be nonterminal");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
