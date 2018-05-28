package FirstandFollow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import grammar.ContextFreeGrammar;
import grammar.Rule;

public class FirstAndFollowClass {

	public static HashSet<String> first(ContextFreeGrammar grammar, String symbol) {
		HashSet<String> first = new HashSet<String>();
 		
		if ( grammar.getTerminals().contains(symbol) ) {
			first.add(symbol); // ak je terminal tak first je symbol
		} else {
			for ( Rule r : grammar.getRules() ) {
				if ( r.getLeftSide().get(0) == symbol ) {
					if ( grammar.getTerminals().contains( r.getRightSide().get(0) ) ) //ak je terminal alebo e vlozime do first
						first.add( r.getRightSide().get(0) );
					else { // ak je neterminal, prehladavame pravu stranu pravidla
						
						for ( int i=0;i<r.getRightSide().size() ;i++ ) 
							{
									first.addAll( first(grammar, r.getRightSide().get(i)) );
									first.remove("e");
									if ( first(grammar, r.getRightSide().get(i)).contains("e") == false ) break;
							}	
					
						}
					}
				}
			}
	
		
		return first;
		
	}
	
	public static HashSet<String> Follow(ContextFreeGrammar grammar, String symbol) throws Exception {
		HashSet<String> follow = new HashSet<String>();
		HashSet<String> lv_f = new HashSet<String>();
		if (grammar.getTerminals().contains(symbol)) throw new Exception("Symbol musi byt z mnoziny neterminalov");
	
			do {
				lv_f.clear();
				lv_f.addAll(follow);
				
				for (Rule r:grammar.getRules()) {
					if (r.getRightSide().contains(symbol)) {
						for (int i=0;i<r.getRightSide().size();i++) {
							if (r.getRightSide().get(i) == symbol) {
								if ((i+1)<r.getRightSide().size()) {
									follow.addAll( first(grammar, r.getRightSide().get(i+1)) );
									follow.remove("e");
									if (first(grammar, r.getRightSide().get(i+1)).contains("e"))
										follow.addAll( Follow(grammar,r.getLeftSide().get(0)) );								
								} else if ((i+1) == r.getRightSide().size()) {
									if (first(grammar, r.getRightSide().get(i)).contains("e"))
										follow.addAll( Follow(grammar,r.getLeftSide().get(0)) );
								}
									
							}
						}
					}
				}
				
				
			} while (lv_f.size() != follow.size());
			
			if (grammar.getStartsymbol() == symbol)
				follow.add("e"); 
			
		
		return follow;
	}
}
