package grammar;

import java.util.HashSet;

public class Grammar {
	
	private HashSet<String> terminals;		//Set of terminals
	private HashSet<String> nonterminals;	//set of nonterminals
	private HashSet<Rule> rules;			//set of rules of grammar
	private String startsymbol;				//starting symbol of grammar
	private Rule startrule;					//rule that contains starting symbol of grammar
	private String epsilon = "epsilon";
	
	
	/**
	 * @param terminals
	 * @param nonterminals
	 * @param rules
	 * @param startsymbol
	 * @throws Exception 
	 */
	public Grammar(HashSet<String> terminals, HashSet<String> nonterminals, HashSet<Rule> rules, String startsymbol) throws Exception {
		super();
		this.terminals = terminals;
		this.nonterminals = nonterminals;
		this.startsymbol = startsymbol;
		
		int checknont=0;  
		int checkstart=0;
		int ok=0;
		
		for (Rule r: rules) {
			//checks if left side of all rules is made only from terminal or nonterminal symbols
			for (int i=0;i<r.getLeftSide().size();i++) {
				if(!terminals.contains(r.getLeftSide().get(i))&&!nonterminals.contains(r.getLeftSide().get(i))||r.getLeftSide().get(i).equals(epsilon)) {
					ok=ok+1;
				}
			}
			//checks if right side of all rules is made only from terminal or nonterminal symbols										
			for (int i=0;i<r.getRightSide().size();i++) {
				if(!terminals.contains(r.getRightSide().get(i))&&!nonterminals.contains(r.getRightSide().get(i))&&!r.getRightSide().get(i).equals(epsilon)) {
					ok=ok+1;
				}
			}
			//Checks if at least one left side of rules contains starting symbol of grammar
			for(int i=0;i<r.getLeftSide().size();i++) {		
				if(r.getLeftSide().get(i).equals(startsymbol)) {
					startrule=r;
					checkstart=checkstart+1;
				}
			}
			//Checks if all left sides of rules contains at least one nonterminal
			for(String s : this.nonterminals) {												
				for(int i=0;i<r.getLeftSide().size();i++) {
					if(r.getLeftSide().get(i).equals(s)) {
						checknont=checknont+1;
						
					}
				}
				
			}
		}
		

		if(checknont<rules.size()) {
			throw new Exception("Left sides of Rules do not contain nonterminals");
		}
		else if(checkstart==0){
			throw new Exception("Left sides of Rules do not contain starting symbol of grammar");
		}
		else if(ok>0) {
			throw new Exception("Rules have to be made only from terminal or nonterminal symbols");
		}
		else if(checkstart>0 && checknont>=rules.size()) {
			this.rules=rules;
		}
		else {
			throw new Exception("Unexpected error");
		}
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


	/**
	 * @return the startrule
	 */
	public Rule getStartrule() {
		return startrule;
	}


	/**
	 * @param startrule the startrule to set
	 */
	public void setStartrule(Rule startrule) {
		this.startrule = startrule;
	}


	
}
