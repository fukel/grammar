package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import automata.NondeterministicFinAutomaton;
import grammar.Grammar;
import grammar.RegularGrammar;
import grammar.Rule;

public class NFATest {
	HashSet<String> terminals;
	HashSet<String> nonterminals;
	
	HashSet<String> terminals2;
	HashSet<String> nonterminals2;
	
	Rule rule1;
	Rule rule2;
	Rule rule3;
	Rule rule4;
	Rule rule5;
	Rule rule6;
	
	Rule rule7;
	Rule rule8;
	Rule rule9;
	Rule rule10;
	Rule rule11;
	Rule rule12;
	Rule rule13;
	Rule rule14;
	Rule rule15;
	Rule rule16;
	Rule rule17;
	Rule rule18;
	
	HashSet<Rule> rules1;
	HashSet<Rule> rules2;
	HashSet<Rule> rules3;
	HashSet<Rule> rules4;
	HashSet<Rule> rules5;
	
	String startsymbol,startsymbol2;
	
	Grammar g,g2;

	@Before
	public void setUp() throws Exception {
		terminals = new HashSet<String>(Arrays.asList("e","l","s","n","d"));		//Set of terminals
		nonterminals = new HashSet<String>(Arrays.asList("S","A","B","C","D"));
			
		rule1 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("e","A")));
		rule2 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("l","B")));
		rule3 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("n","C")));
		rule4 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("s","D")));
		rule5 = new Rule(new ArrayList<String>(Arrays.asList("C")), new ArrayList<String>(Arrays.asList("d")));
		rule6 = new Rule(new ArrayList<String>(Arrays.asList("D")), new ArrayList<String>(Arrays.asList("e")));
		
		rules1= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3,rule4,rule5,rule6));	
		
		startsymbol = "A";
		
		g = new RegularGrammar(terminals, nonterminals, rules1, startsymbol);
		
		terminals2 = new HashSet<String>(Arrays.asList("+","-","0","1"));		//Set of terminals
		nonterminals2 = new HashSet<String>(Arrays.asList("S","A","B"));
		
		rule7 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("+","A")));
		rule8 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("-","A")));
		rule9 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("1","B")));
		rule10 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("0")));
		rule11 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("1")));
		rule12 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("1","B")));
		rule13 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("0")));
		rule14 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("1")));
		rule15 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("0","B")));
		rule16 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("1","B")));
		rule17 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("0")));
		rule18 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("1")));
		
		rules2= new HashSet<Rule>(Arrays.asList(rule7,rule8,rule9,rule10,rule11,rule12,rule13,rule14,rule15,rule16,rule17,rule18));
		
		
		startsymbol2 = "S";
		
		g2 = new RegularGrammar(terminals2, nonterminals2, rules2, startsymbol2);
	}

	@Test
	public void test() {
		try {
			NondeterministicFinAutomaton n = new NondeterministicFinAutomaton((RegularGrammar) g);
			NondeterministicFinAutomaton n2 = new NondeterministicFinAutomaton((RegularGrammar) g2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Unexpected exception");
			e.printStackTrace();
		}
	}

}
