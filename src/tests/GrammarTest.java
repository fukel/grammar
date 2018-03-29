package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import grammar.Grammar;
import grammar.Rule;

public class GrammarTest {
	HashSet<String> terminals;
	HashSet<String> nonterminals; 	//set of nonterminals
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
	HashSet<Rule> rules2;
	HashSet<Rule> rules3;
	HashSet<Rule> rules4;
	HashSet<Rule> rules5;

	String startsymbol;
	String startsymbol2;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
		 terminals = new HashSet<String>(Arrays.asList("a","b"));		//Set of terminals
		 nonterminals = new HashSet<String>(Arrays.asList("A","B")); 	//set of nonterminals
		 rule1 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("a","A","b")));
		 rule2 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("B","A")));
		 rule3 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("b","A")));
		 rule4 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("a","B")));
		 rule5 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("epsilon")));	
		 rule6 = new Rule(new ArrayList<String>(Arrays.asList("a","B")), new ArrayList<String>(Arrays.asList("a","B","A","a")));
		 //legitime rules, test1
		 
		 rule7 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("D","A","b"))); 
		 //rule7 contains unspecified symbol "D", test 2 
		 
		 rule8 = new Rule(new ArrayList<String>(Arrays.asList("a")), new ArrayList<String>(Arrays.asList("a","A","b")));
		 //rule8 does not contain nonterminal on left side, test 3
		 
		 rule9 = new Rule(new ArrayList<String>(Arrays.asList("A","epsilon")), new ArrayList<String>(Arrays.asList("a","A","b")));
		 //rule9 contains epsilon on left side, test 5
		 
		 rules1= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3,rule4,rule5,rule6)); //test1
		 rules2= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3,rule4,rule5,rule6,rule7)); //test2
		 rules3= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3,rule4,rule5,rule6,rule8));	//test3
		 rules4= new HashSet<Rule>(Arrays.asList(rule3,rule4,rule5));							//test4, ruleset does not contain starting symbol of grammar
		 rules5= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3,rule4,rule5,rule6,rule9));	//test5



		startsymbol = "A";				//starting symbol of grammar
		startsymbol2 = "D";				//starting symbol not from symbols of grammar, test6

		
	}

	@Test
	public void test1() {
		try {
			Grammar g = new Grammar(terminals, nonterminals, rules1, startsymbol);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Unexepected exception");
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		try {
			Grammar g = new Grammar(terminals, nonterminals, rules2, startsymbol);
			fail("Expected exception:Rules have to be made only from terminal or nonterminal symbols");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test3() {
		try {
			Grammar g = new Grammar(terminals, nonterminals, rules3, startsymbol);
			fail("Expected exception:Left sides of Rules do not contain nonterminals");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test4() {
		try {
			Grammar g = new Grammar(terminals, nonterminals, rules4, startsymbol);
			fail("Expected exception:Left sides of Rules do not contain starting symbol of grammar");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test5() {
		try {
			Grammar g = new Grammar(terminals, nonterminals, rules5, startsymbol);
			fail("Expected exception:Rules have to be made only from terminal or nonterminal symbols");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test6() {
		try {
			Grammar g = new Grammar(terminals, nonterminals, rules1, startsymbol2);
			fail("Exepected exception:Left sides of Rules do not contain starting symbol of grammar");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

}
