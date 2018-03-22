package grammar;

import java.util.HashSet;

public class Grammar {
	
	HashSet<String> terminals;
	HashSet<String> nonterminals;
	HashSet<Rule> rules;
	String startsymbol;
	
	
	/**
	 * @param terminals
	 * @param nonterminals
	 * @param rules
	 * @param startsymbol
	 */
	public Grammar(HashSet<String> terminals, HashSet<String> nonterminals, HashSet<Rule> rules, String startsymbol) {
		super();
		this.terminals = terminals;
		this.nonterminals = nonterminals;
		this.rules = rules;
		this.startsymbol = startsymbol;
	}


	/**
	 * @return the terminals
	 */
	public HashSet<String> getTerminals() {
		return terminals;
	}


	/**
	 * @param terminals the terminals to set
	 */
	public void setTerminals(HashSet<String> terminals) {
		this.terminals = terminals;
	}


	/**
	 * @return the nonterminals
	 */
	public HashSet<String> getNonterminals() {
		return nonterminals;
	}


	/**
	 * @param nonterminals the nonterminals to set
	 */
	public void setNonterminals(HashSet<String> nonterminals) {
		this.nonterminals = nonterminals;
	}


	/**
	 * @return the rules
	 */
	public HashSet<Rule> getRules() {
		return rules;
	}


	/**
	 * @param rules the rules to set
	 */
	public void setRules(HashSet<Rule> rules) {
		this.rules = rules;
	}


	/**
	 * @return the startsymbol
	 */
	public String getStartsymbol() {
		return startsymbol;
	}


	/**
	 * @param startsymbol the startsymbol to set
	 */
	public void setStartsymbol(String startsymbol) {
		this.startsymbol = startsymbol;
	}


	
}
