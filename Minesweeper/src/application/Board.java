package application;
import java.util.concurrent.ThreadLocalRandom;
public class Board {

	public static void main(String[] args) {
		
	}
	cell[][] cellArray= new cell[10][10];
	cell test = new cell();
	public void setup(){
		cell cellArray[][]={};
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	cellArray[i][j]=test;
            }}
		for(int i =0;i<10;i++) {
			int x,y;
			x=ThreadLocalRandom.current().nextInt(0, 10 + 1);
			y=ThreadLocalRandom.current().nextInt(0, 10 + 1);
			if(cellArray[x][y].isMine()==true) {
				i--;
			}else {
				cellArray[x][y].setMine(true);
			}
		}
	}
	
	public void reveal(int i, int j) {
		//recursive
		if (cellArray[i][j].isCovered()==true){
			cellArray[i][j].uncover();
		}
		// changes what needs to be changed cellArray[i][j].returnV();
		if(cellArray[i][j].returnV()==" ") {
			reveal(i+1,j+1);
			reveal(i+1,j);
			reveal(i+1,j-1);
			reveal(i,j+1);
			reveal(i,j-1);
			reveal(i-1,j+1);
			reveal(i-1,j);
			reveal(i-1,j-1);
		}
		
	}
		
	public String mark(int i, int j) {
		if(cellArray[i][j].getMark()==true){
			cellArray[i][j].setMark(false);
			return "x";
		} else{
			cellArray[i][j].setMark(true);
			return "?";
		}
	}
	
	public void unmask() {
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	cellArray[i][j].returnV();
            	
            }
		}
	}
	
	public boolean checkWin(){
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            if(cellArray[i][j].isMine()==true || cellArray[i][j].isCovered()==true){
            }else{
            	return false;
            }}
         }
         return true;
	}
}
