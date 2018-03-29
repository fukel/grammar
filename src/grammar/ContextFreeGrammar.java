package grammar;

import java.util.HashSet;

public class ContextFreeGrammar extends Grammar {

	public ContextFreeGrammar(HashSet<String> terminals, HashSet<String> nonterminals, HashSet<Rule> rules,
			String startsymbol) throws Exception {
		super(terminals, nonterminals, rules, startsymbol);
		// TODO Auto-generated constructor stub
		int check=0;					//checks if left side of rule is just one symbol
		for(Rule r : rules) {
			
			if(r.getLeftSide().size()!=1) {	
				check=check+1;
			}
		}
		if(check>0) {
			throw new Exception("Left side of rule has to be just one nonterminal");
		}

	}

}
