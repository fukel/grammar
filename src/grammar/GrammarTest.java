package grammar;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	
	HashSet<Rule> rules1;
	HashSet<Rule> rules2;
	HashSet<Rule> rules3;
	HashSet<Rule> rules4;



	String startsymbol;
	

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
		 rule5 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("a")));	
		 rule6 = new Rule(new ArrayList<String>(Arrays.asList("a","B")), new ArrayList<String>(Arrays.asList("a","B","A","a")));
		 rule7 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("D","A","b")));
		 rule8 = new Rule(new ArrayList<String>(Arrays.asList("a")), new ArrayList<String>(Arrays.asList("a","A","b")));
		
		 rules1= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3,rule4,rule5,rule6));
		 rules2= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3,rule4,rule5,rule6,rule7));
		 rules3= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3,rule4,rule5,rule6,rule8));
		 rules4= new HashSet<Rule>(Arrays.asList(rule3,rule4,rule5));



		startsymbol = "A";				//starting symbol of grammar
		

		
	}

	@Test
	public void test1() {
		try {
			Grammar g = new Grammar(terminals, nonterminals, rules1, startsymbol);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test2() {
		try {
			Grammar g = new Grammar(terminals, nonterminals, rules2, startsymbol);
			fail("Expected exception");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test3() {
		try {
			Grammar g = new Grammar(terminals, nonterminals, rules3, startsymbol);
			fail("Expected exception");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test4() {
		try {
			Grammar g = new Grammar(terminals, nonterminals, rules4, startsymbol);
			fail("Expected exception");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
