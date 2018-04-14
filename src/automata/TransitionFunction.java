package automata;

import java.util.Arrays;
import java.util.HashSet;

public class TransitionFunction {
	HashSet<String> rowHeaders;
	HashSet<String> columnHeaders;
	String[][] table;
	
	/**
	 * @param rowHeaders represents States of finite automata
	 * @param columnHeaders represents input symbols of finite automata
	 */
	public TransitionFunction(HashSet<String> rowHeaders, HashSet<String> columnHeaders) {
		this.rowHeaders = rowHeaders;
		this.columnHeaders = columnHeaders;
		
		this.table = new String[rowHeaders.size()+1][columnHeaders.size()+1];
		for (int a = 0;a<rowHeaders.size()+1;a++) {
			for (int b = 0;b<columnHeaders.size()+1;b++) {
				this.table[a][b]="-";
			}
		}
		int i = 1;
		for(String s :rowHeaders) {
			
			
			this.table[i][0]=s;
			i++;
		}
		int j = 1;
		for(String s :columnHeaders) {
			
			this.table[0][j]=s;
			j++;
		}

		
		
	}
	public void add(String currentState, String inputSymbol, String data) {
		
		int pom1 = 0;
		for (int i = 0;i<rowHeaders.size()+1;i++) {
			if(table[i][0].equals(currentState)) {
				pom1=i;
			}
		}
		int pom2 = 0;
		for (int i = 0;i<columnHeaders.size()+1;i++) {
			if(table[0][i].equals(inputSymbol)) {
				pom2=i;
			}
		}

		if(table[pom1][pom2].equals("-")){
			table[pom1][pom2]=data;
		}
		else {
			table[pom1][pom2]=table[pom1][pom2]+"#"+data;
		}
	}
	public void showTable() {
		   for (String[] row : table){
			    System.out.println(Arrays.toString(row));
			   }

	}

	
	

}
