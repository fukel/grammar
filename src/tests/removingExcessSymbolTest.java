package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import grammar.ContextFreeGrammar;
import grammar.Grammar;
import grammar.Rule;
import removing.removingExcessSymbols;

public class removingExcessSymbolTest {

	HashSet<String> terminals;
	HashSet<String> nonterminals;
	Rule rule1;
	Rule rule2;
	Rule rule3;
	Rule rule4;
	Rule rule5;
	Rule rule6;
	Rule rule7;
	Rule rule8;
	Rule rule9;
	HashSet<Rule> rules1;
	
	HashSet<String> terminal;
	HashSet<String> nonterminal;
	Rule rul1;
	Rule rul2;
	Rule rul3;
	Rule rul4;
	Rule rul5;
	Rule rul6;
	Rule rul7;
	Rule rul8;
	Rule rul9;
	Rule rul10;
	HashSet<Rule> rules2;
	String startsymbo;

	String startsymbol;
	
	@Before
	public void setUp() throws Exception {
		terminals = new HashSet<String>(Arrays.asList("a","b","c","e"));//Set of terminals
		nonterminals = new HashSet<String>(Arrays.asList("S","B","C","D"));
		
		rule1 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("B","c")));//
		rule2 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("a","C","b")));//
		rule3 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("a","B","b")));//
		rule4 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("a","C","D","B")));//
		rule5 = new Rule(new ArrayList<String>(Arrays.asList("C")), new ArrayList<String>(Arrays.asList("C","b")));//
		rule6 = new Rule(new ArrayList<String>(Arrays.asList("C")), new ArrayList<String>(Arrays.asList("a","b")));//
		rule7 = new Rule(new ArrayList<String>(Arrays.asList("D")), new ArrayList<String>(Arrays.asList("D","C","a","B")));//
		rule8 = new Rule(new ArrayList<String>(Arrays.asList("D")), new ArrayList<String>(Arrays.asList("D","a","C","c")));//
		rule9 = new Rule(new ArrayList<String>(Arrays.asList("D")), new ArrayList<String>(Arrays.asList("e")));//

		rules1= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3,rule4,rule5,rule6,rule7,rule8,rule9));	
		
		startsymbol="S";
		
		terminal = new HashSet<String>(Arrays.asList("a","b","c","e"));//Set of terminals
		nonterminal = new HashSet<String>(Arrays.asList("S","B","C","D","E"));
		
		rul1 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("a","B","b")));
		rul2 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("a","C","b")));
		rul3 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("a","b")));
		rul4 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("C","b")));
		rul5 = new Rule(new ArrayList<String>(Arrays.asList("C")), new ArrayList<String>(Arrays.asList("a","C","b")));
		rul6 = new Rule(new ArrayList<String>(Arrays.asList("C")), new ArrayList<String>(Arrays.asList("a","S")));
		rul7 = new Rule(new ArrayList<String>(Arrays.asList("D")), new ArrayList<String>(Arrays.asList("c","S")));
		rul8 = new Rule(new ArrayList<String>(Arrays.asList("D")), new ArrayList<String>(Arrays.asList("a","E")));
		rul9 = new Rule(new ArrayList<String>(Arrays.asList("E")), new ArrayList<String>(Arrays.asList("a","b","D")));
		rul10 = new Rule(new ArrayList<String>(Arrays.asList("E")), new ArrayList<String>(Arrays.asList("e")));
		
		rules2= new HashSet<Rule>(Arrays.asList(rul1,rul2,rul3,rul4,rul5,rul6,rul7,rul8,rul9,rul10));	
		
		startsymbo="S";
	}
	@Test
	public void test1() {
		try {
			ContextFreeGrammar g = new ContextFreeGrammar(terminals, nonterminals, rules1, startsymbol);
			ContextFreeGrammar g1 = new ContextFreeGrammar(terminal, nonterminal, rules2, startsymbo);
			//removingExcessSymbols.vytvorenieMnoziny1(g1);
			//removingExcessSymbols.vytvorenieMnoziny2(g);
			//System.out.println(removingExcessSymbols.vytvorNt(g).toString());
			//System.out.println(removingExcessSymbols.vytvorVd(g).toString());
			ContextFreeGrammar g3 = removingExcessSymbols.redukovanaGramatika(g);
			ContextFreeGrammar g4 = removingExcessSymbols.redukovanaGramatika(g1);
			System.out.println("TERMINALS g3: "+g3.getTerminals().toString());
			System.out.println("NONTERMINALS g3: "+g3.getNonterminals().toString());
			
			System.out.println("TERMINALS g4: "+g4.getTerminals().toString());
			System.out.println("NONTERMINALS g4: "+g4.getNonterminals().toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Unexepected exception");
			
		}
	}

}
