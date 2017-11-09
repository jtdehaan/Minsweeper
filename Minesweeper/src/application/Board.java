package application;
import java.util.concurrent.ThreadLocalRandom;
public class Board {

	public static void main(String[] args) {
		
	}
	boolean win=false;
	boolean loss =false;
	//returns win state
	public boolean win(){
		return win;
	}
	//returns loss state
	public boolean loss() {
		return loss;
	}
	
	//creates array
	cell[][] cellArray= new cell[10][10];
	//cell test = new cell();
	
	//sets up cellArray
	public void setup(){
		cell cellArray[][]={};
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	cellArray[i][j]= new cell();
            	//cellArray[i][j] = new cell(i, j, false);
            }}
		//creates  mines
		for(int i =0;i<10;i++) {
			int x,y;
			x=ThreadLocalRandom.current().nextInt(0, 9 + 1);
			y=ThreadLocalRandom.current().nextInt(0, 9 + 1);
			if(cellArray[x][y].isMine()==true) {
				i--;
			}else {
				cellArray[x][y].setMine(true);
				//set values of around mines +1
				cellArray[x+1][y+1].setAroundMines(cellArray[x+1][y+1].getAroundMines()+1);
				cellArray[x+1][y].setAroundMines(cellArray[x+1][y].getAroundMines()+1);
				cellArray[x][y+1].setAroundMines(cellArray[x][y+1].getAroundMines()+1);
				cellArray[x][y].setAroundMines(cellArray[x][y].getAroundMines()+1);
				cellArray[x][y-1].setAroundMines(cellArray[x][y-1].getAroundMines()+1);
				cellArray[x-1][y].setAroundMines(cellArray[x-1][y].getAroundMines()+1);
				cellArray[x-1][y-1].setAroundMines(cellArray[x-1][y-1].getAroundMines()+1);
				
			}
		}
	}
	
	//reveals the cell
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
		}else if(cellArray[i][j].returnV()=="B") {
			loss=true;
		}
		checkWin();
		
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
	
	public void checkWin(){
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            if(cellArray[i][j].isMine()==true || cellArray[i][j].isCovered()==false){
            }else{
            	win =false;
            }}
         }
         win =true;
	}
}
