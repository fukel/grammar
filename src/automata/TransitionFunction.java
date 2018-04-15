package automata;

import java.util.Arrays;
import java.util.HashSet;

public class TransitionFunction {
	
	private HashSet<String> rowHeaders;
	private HashSet<String> columnHeaders;
	private String[][] table;
	
	/**
	 * @param table has to have following format: positions [1][n] have to be input symbols of automaton, 
	 * positions [m][1] have to be states of automaton, position [0][0] is "-". If there is nondeterministic step in automaton, states have to
	 * be separated with sign "#".
	 * 
	 */
	public TransitionFunction(String[][] table) {
		super();
		this.table = table;
	}

	/**
	 * @param rowHeaders represents States of finite automata
	 * @param columnHeaders represents input symbols of finite automata
	 * this constructor creates table without data, just with row and column headers
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
			table[pom1][pom2]=table[pom1][pom2]+"#"+data;	//"#" represent separator, otherwise we should implement 3D array
		}
	}
	public void showTable() {
		   for (String[] row : table){
			    System.out.println(Arrays.toString(row));
			   }

	}
	public String get(String currentState, String inputSymbol) {
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
		return table[pom1][pom2];
		
	}
	
	/**
	 * @return the rowHeaders
	 */
	public HashSet<String> getRowHeaders() {
		return rowHeaders;
	}
	/**
	 * @param rowHeaders the rowHeaders to set
	 */
	public void setRowHeaders(HashSet<String> rowHeaders) {
		this.rowHeaders = rowHeaders;
	}
	/**
	 * @return the columnHeaders
	 */
	public HashSet<String> getColumnHeaders() {
		return columnHeaders;
	}
	/**
	 * @param columnHeaders the columnHeaders to set
	 */
	public void setColumnHeaders(HashSet<String> columnHeaders) {
		this.columnHeaders = columnHeaders;
	}
	/**
	 * @return the table
	 */
	public String[][] getTable() {
		return table;
	}
	/**
	 * @param table the table to set
	 */
	public void setTable(String[][] table) {
		this.table = table;
	}
	
	

}
