package automata;

import java.util.ArrayList;
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
	public TransitionFunction(String[][] table,HashSet<String> rowHeaders, HashSet<String> columnHeaders) {
		super();
		this.table = table;
		this.rowHeaders=rowHeaders;
		this.columnHeaders=columnHeaders;
	}

	/**
	 * @param rowHeaders represents States of finite automata
	 * @param columnHeaders represents input symbols of finite automata
	 * this constructor creates table without data, just with row and column headers
	 */
	public TransitionFunction(HashSet<String> rowHeaders, HashSet<String> columnHeaders) {
		this.rowHeaders = rowHeaders;
		this.columnHeaders = columnHeaders;


		this.table = new String[this.rowHeaders.size()+1][this.columnHeaders.size()+1];
		for (int a = 0;a<this.rowHeaders.size()+1;a++) {
			for (int b = 0;b<this.columnHeaders.size()+1;b++) {
				this.table[a][b]="-";
			}
		}
		int i = 1;
		for(String s :this.rowHeaders) {
			
			
			this.table[i][0]=s;
			i++;
		}
		int j = 1;
		for(String s :this.columnHeaders) {
			
			this.table[0][j]=s;
			j++;
		}

		/*System.out.print("TF Column headers after constructor ");
		for(String s : this.columnHeaders) {
			System.out.print(s+",");
		}
		System.out.print("\n");*/
		
	}
	public void add(String currentState, String inputSymbol, String data) throws Exception {
		
		if(!rowHeaders.contains(currentState)) {
			throw new Exception("current state is not present in the table");
		}
		else if(!columnHeaders.contains(inputSymbol)) {
			throw new Exception("input symbol is not present in the table");
		}
		else {
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
		  
	}
	public void showTable() {
		   for (String[] row : table){
			    System.out.println(Arrays.toString(row));
			   }


	}
	public String get(String currentState, String inputSymbol) throws Exception {
		if(!rowHeaders.contains(currentState)) {
			throw new Exception("current state is not present in the table");
		}
		else if(!columnHeaders.contains(inputSymbol)) {
			throw new Exception("input symbol is not present in the table");
		}
		else {
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
		
	}
	//returns array list of strings of cell in table, searches for indexes of separator and creates substrings, then adds them to array list
	public ArrayList<String> getAL(String currentState, String inputSymbol) throws Exception {
		if(!rowHeaders.contains(currentState)) {
			throw new Exception("current state is not present in the table");
		}
		else if(!columnHeaders.contains(inputSymbol)) {
			throw new Exception("input symbol is not present in the table");
		}
		else {
			int pom1 = 0;
			for (int i = 0;i<rowHeaders.size()+1;i++) {
				if(table[i][0].equals(currentState)) {
					pom1=i;
				}
			}
			
			/*System.out.print("Column headers pri getAL");
			for(String s : columnHeaders) {
				System.out.print(s+",");
			}
			System.out.print("\n");
			
			System.out.println("Column headers size "+String.valueOf(this.columnHeaders.size()));*/
			
			int pom2 = 0;
			for (int i = 0;i<columnHeaders.size()+1;i++) {
				
				if(table[0][i].equals(inputSymbol)) {
					pom2=i;
				}
			}
			
			ArrayList<String> ret= new ArrayList<String>();
			if(table[pom1][pom2].contains("#")) {
				String word=table[pom1][pom2];
				//word="B#qf#C#a#2ab#bac";
				String subword;
				int index=word.indexOf("#");
				ArrayList<Integer> indexes= new ArrayList<Integer>();
				while(index>=0) {
					if(index>=0) {
					indexes.add(index);
					index=word.indexOf("#", index+1);
					
					}
				}
				//substring between charat(0) and first index of separator
				subword=word.substring(word.indexOf(String.valueOf(word.charAt(0))), indexes.get(0));
				ret.add(subword);
				
				//System.out.println("subword:"+subword);
				
				//substring inside of word
				if(indexes.size()>1) {
					for(int i=0;i<indexes.size()-1;i++) {
						//System.out.println("sme tu i="+String.valueOf(i));
						
						subword=word.substring(indexes.get(i)+1, indexes.get(i+1));
						ret.add(subword);
						
						//System.out.println("subwordfor:"+subword);
						
					}
				}
				
				//substring at the end of word
				subword=word.substring(indexes.get(indexes.size()-1)+1, word.indexOf(String.valueOf(word.charAt(word.length()-1)))+1);
				ret.add(subword);
				
				//System.out.println("subword:"+subword);
				
				return ret;
			}
			//if string doesnt contain separator, returns value
			else {
				ret.add(table[pom1][pom2]);
				//System.out.println(String.valueOf(pom1)+" "+String.valueOf(pom2));
				return ret;
			}
		}
		
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
