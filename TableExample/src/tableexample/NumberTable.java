package tableexample;

public class NumberTable {

	private int[][] table = new int[5][5];
	
	public NumberTable(){
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				table[i][j]=0;
			}
		}
	}
	
	public int[][] getTable(){
		return table;
	}
	
	public boolean addNext(int val){
		for(int i=0; i <5; i++){
			for(int j=0; j<5; j++){
				if(table[i][j]==0){
					table[i][j] = val;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean setCell(int x, int y, int val){
		table[x][y] = val;
		return true;
	}
}
