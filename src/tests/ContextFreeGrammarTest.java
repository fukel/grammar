package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import grammar.ContextFreeGrammar;
import grammar.Grammar;
import grammar.Rule;

public class ContextFreeGrammarTest {

	HashSet<String> terminals;
	HashSet<String> nonterminals;
	Rule rule1;
	Rule rule2;
	Rule rule3;
	HashSet<Rule> rules1;
	HashSet<Rule> rules2;
	String startsymbol;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		terminals = new HashSet<String>(Arrays.asList("a","b"));		//Set of terminals
		nonterminals = new HashSet<String>(Arrays.asList("A","B"));
		
		rule1 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("a","A","b")));
		rule2 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("b","A")));
		//legitime rules, test1
		rule3 = new Rule(new ArrayList<String>(Arrays.asList("A","B")), new ArrayList<String>(Arrays.asList("a","B","A","a")));
		//rule3 has 2 symbols on left side, test2
		rules1= new HashSet<Rule>(Arrays.asList(rule1,rule2));	//test1
		rules2= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3));	//test2
		
		startsymbol="A";
	}

	@Test
	public void test1() {
		try {
			Grammar g = new ContextFreeGrammar(terminals, nonterminals, rules1, startsymbol);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Unexepected exception");
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		try {
			Grammar g = new ContextFreeGrammar(terminals, nonterminals, rules2, startsymbol);
			fail("Expected exception:Left side of rule has to be just one nonterminal");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

}
