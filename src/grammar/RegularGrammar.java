package grammar;

import java.util.HashSet;

public class RegularGrammar extends ContextFreeGrammar {

	public RegularGrammar(HashSet<String> terminals, HashSet<String> nonterminals, HashSet<Rule> rules,
			String startsymbol) throws Exception {
		super(terminals, nonterminals, rules, startsymbol);
		// TODO Auto-generated constructor stub
		for (Rule r: rules) {
			if(r.getRightSide().size()>2) {
				
				throw new Exception("Right sides of rules should be made only from 2 symbols");
			}
			else {
				if(r.getRightSide().size()==1) {
					if (nonterminals.contains(r.getRightSide().get(0))) {
						throw new Exception("First symbol of right side of rule should be terminal or epsilon");
					}
				}
				if(r.getRightSide().size()==2) {
					if (nonterminals.contains(r.getRightSide().get(0))) {
						throw new Exception("First symbol of right side of rule should be terminal or epsilon");
					}
					if(terminals.contains(r.getRightSide().get(1))||r.getRightSide().get(1).equals("epsilon")) {
						throw new Exception("Second symbol of right side of rule should be nonterminal");
					}
				}
			}
		}
	}

}
