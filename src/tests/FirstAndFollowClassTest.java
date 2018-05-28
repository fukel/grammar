package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import FirstandFollow.FirstAndFollowClass;
import grammar.ContextFreeGrammar;
import grammar.Rule;

public class FirstAndFollowClassTest {
	HashSet<String> terminals;
	HashSet<String> nonterminals;
	Rule rule1;
	Rule rule2;
	Rule rule3;
	Rule rule4;
	Rule rule5;
	Rule rule6;
	HashSet<Rule> rules;
	String startsymbol;
	
	@Before
	public void setUp() throws Exception {
		terminals = new HashSet<String>(Arrays.asList("a","b","(",")","+","e"));//Set of terminals
		nonterminals = new HashSet<String>(Arrays.asList("S","A","B"));
		
		rule1 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("A","(","S",")")));//
		rule2 = new Rule(new ArrayList<String>(Arrays.asList("S")), new ArrayList<String>(Arrays.asList("a","B")));//
		rule3 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("b")));//
		rule4 = new Rule(new ArrayList<String>(Arrays.asList("A")), new ArrayList<String>(Arrays.asList("e")));//
		rule5 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("+","S")));//
		rule6 = new Rule(new ArrayList<String>(Arrays.asList("B")), new ArrayList<String>(Arrays.asList("e")));//
		
		rules= new HashSet<Rule>(Arrays.asList(rule1,rule2,rule3,rule4,rule5,rule6));
		
		startsymbol="S";
	}

	@Test
	public void testFirst() {
		try {
			ContextFreeGrammar g = new ContextFreeGrammar(terminals, nonterminals, rules, startsymbol);
			
			
		/*	System.out.println( FirstAndFollowClass.first(g, "S").toString() );
			System.out.println( FirstAndFollowClass.first(g, "A").toString() );
			System.out.println( FirstAndFollowClass.first(g, "B").toString() );
			System.out.println( FirstAndFollowClass.first(g, "a").toString() );
			System.out.println( FirstAndFollowClass.first(g, "b").toString() );
			System.out.println( FirstAndFollowClass.first(g, "(").toString() );
			System.out.println( FirstAndFollowClass.first(g, ")").toString() );
			System.out.println( FirstAndFollowClass.first(g, "+").toString() ); */
			
			System.out.println( FirstAndFollowClass.Follow(g, "S").toString());
			System.out.println( FirstAndFollowClass.Follow(g, "A").toString());
			System.out.println( FirstAndFollowClass.Follow(g, "B").toString());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//fail("Not yet implemented");
	}

}
