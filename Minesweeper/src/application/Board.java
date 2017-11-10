
package application;
import java.util.concurrent.ThreadLocalRandom;
public class Board {

	public static void main(String[] args) {
		
	}
	//booleans for won or losss state
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
	
	//creates arrays
	Cell[][] cellArray= new Cell[10][10];
	String[][] state = new String[10][10];
	
	//sets up cellArray
	public void setup(){
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	cellArray[i][j]= new Cell();
            	//cellArray[i][j] = new cell(i, j, false);
            	state[i][j]="x";
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
				//set values of the count around mines +1 depending on location
				if(x>0&&y>0&&x<9&y<9) {	
				cellArray[x+1][y+1].setAroundMines(cellArray[x+1][y+1].getAroundMines()+1);
				cellArray[x+1][y-1].setAroundMines(cellArray[x+1][y-1].getAroundMines()+1);
				cellArray[x+1][y].setAroundMines(cellArray[x+1][y].getAroundMines()+1);
				cellArray[x][y+1].setAroundMines(cellArray[x][y+1].getAroundMines()+1);
				cellArray[x][y-1].setAroundMines(cellArray[x][y-1].getAroundMines()+1);
				cellArray[x-1][y].setAroundMines(cellArray[x-1][y].getAroundMines()+1);
				cellArray[x-1][y+1].setAroundMines(cellArray[x-1][y+1].getAroundMines()+1);
				cellArray[x-1][y-1].setAroundMines(cellArray[x-1][y-1].getAroundMines()+1);
				} else if(x==0&&y==0) {
					cellArray[x+1][y+1].setAroundMines(cellArray[x+1][y+1].getAroundMines()+1);
					cellArray[x+1][y].setAroundMines(cellArray[x+1][y].getAroundMines()+1);
					cellArray[x][y+1].setAroundMines(cellArray[x][y+1].getAroundMines()+1);
				}else if(x==9&&y==0) {
					cellArray[x][y+1].setAroundMines(cellArray[x][y+1].getAroundMines()+1);
					cellArray[x-1][y].setAroundMines(cellArray[x-1][y].getAroundMines()+1);
					cellArray[x-1][y+1].setAroundMines(cellArray[x-1][y+1].getAroundMines()+1);
				}else if(x==9&&y==9) {
					cellArray[x][y-1].setAroundMines(cellArray[x][y-1].getAroundMines()+1);
					cellArray[x-1][y].setAroundMines(cellArray[x-1][y].getAroundMines()+1);
					cellArray[x-1][y-1].setAroundMines(cellArray[x-1][y-1].getAroundMines()+1);
				}else if(x==0&&y==9) {
					cellArray[x+1][y-1].setAroundMines(cellArray[x+1][y-1].getAroundMines()+1);
					cellArray[x+1][y].setAroundMines(cellArray[x+1][y].getAroundMines()+1);
					cellArray[x][y-1].setAroundMines(cellArray[x][y-1].getAroundMines()+1);
				}else if(x==0) {
					cellArray[x+1][y+1].setAroundMines(cellArray[x+1][y+1].getAroundMines()+1);
					cellArray[x+1][y-1].setAroundMines(cellArray[x+1][y-1].getAroundMines()+1);
					cellArray[x+1][y].setAroundMines(cellArray[x+1][y].getAroundMines()+1);
					cellArray[x][y+1].setAroundMines(cellArray[x][y+1].getAroundMines()+1);
					cellArray[x][y-1].setAroundMines(cellArray[x][y-1].getAroundMines()+1);
				}else if(y==0) {
					cellArray[x+1][y+1].setAroundMines(cellArray[x+1][y+1].getAroundMines()+1);
					cellArray[x+1][y].setAroundMines(cellArray[x+1][y].getAroundMines()+1);
					cellArray[x][y+1].setAroundMines(cellArray[x][y+1].getAroundMines()+1);
					cellArray[x-1][y].setAroundMines(cellArray[x-1][y].getAroundMines()+1);
					cellArray[x-1][y+1].setAroundMines(cellArray[x-1][y+1].getAroundMines()+1);
				}else if(x==9) {
					cellArray[x][y+1].setAroundMines(cellArray[x][y+1].getAroundMines()+1);
					cellArray[x][y-1].setAroundMines(cellArray[x][y-1].getAroundMines()+1);
					cellArray[x-1][y].setAroundMines(cellArray[x-1][y].getAroundMines()+1);
					cellArray[x-1][y+1].setAroundMines(cellArray[x-1][y+1].getAroundMines()+1);
					cellArray[x-1][y-1].setAroundMines(cellArray[x-1][y-1].getAroundMines()+1);
				}else if(y==9) {
					cellArray[x+1][y-1].setAroundMines(cellArray[x+1][y-1].getAroundMines()+1);
					cellArray[x+1][y].setAroundMines(cellArray[x+1][y].getAroundMines()+1);
					cellArray[x][y-1].setAroundMines(cellArray[x][y-1].getAroundMines()+1);
					cellArray[x-1][y].setAroundMines(cellArray[x-1][y].getAroundMines()+1);
					cellArray[x-1][y-1].setAroundMines(cellArray[x-1][y-1].getAroundMines()+1);
				}
			}
		}
	}
	
	//reveals the cell
	public void reveal(int i, int j) {
		//checks all surrounding cells if it is blank
		if(cellArray[i][j].isCovered()==true) {
		if(cellArray[i][j].returnV()==" ") {
			cellArray[i][j].uncover();
			if(i>0&&j>0&&i<9&&j<9) {	
			reveal(i+1,j+1);
			reveal(i+1,j);
			reveal(i+1,j-1);
			reveal(i,j+1);
			reveal(i,j-1);
			reveal(i-1,j+1);
			reveal(i-1,j);
			reveal(i-1,j-1);
			state[i][j]=cellArray[i][j].returnV();
			//no negatives
			} else if(i==0&&j==0) {
				reveal(i+1,j+1);
				reveal(i+1,j);
				reveal(i,j+1);	
				state[i][j]=cellArray[i][j].returnV();
				//no +i or -j
			}else if(i==9&&j==0) {
				reveal(i,j+1);
				reveal(i-1,j+1);
				reveal(i-1,j);
				state[i][j]=cellArray[i][j].returnV();
				//no +i or +j
			}else if(i==9&&j==9) {
				reveal(i,j-1);
				reveal(i-1,j);
				reveal(i-1,j-1);
				state[i][j]=cellArray[i][j].returnV();
				//no -i or +j
			}else if(i==0&&j==9) {
				reveal(i+1,j-1);
				reveal(i+1,j);
				reveal(i,j-1);
				state[i][j]=cellArray[i][j].returnV();
				//no -i
			}else if(i==0) {
				reveal(i+1,j+1);
				reveal(i+1,j);
				reveal(i+1,j-1);
				reveal(i,j+1);
				reveal(i,j-1);
				state[i][j]=cellArray[i][j].returnV();
				//no -j
			}else if(j==0) {
				reveal(i+1,j+1);
				reveal(i+1,j);
				reveal(i,j+1);
				reveal(i-1,j+1);
				reveal(i-1,j);
				state[i][j]=cellArray[i][j].returnV();
				//no +i
			}else if(i==9) {
				reveal(i,j+1);
				reveal(i,j-1);
				reveal(i-1,j+1);
				reveal(i-1,j);
				reveal(i-1,j-1);
				state[i][j]=cellArray[i][j].returnV();
				//no +j
			}else if(j==9) {
				reveal(i+1,j);
				reveal(i+1,j-1);
				reveal(i,j-1);
				reveal(i-1,j);
				reveal(i-1,j-1);
				state[i][j]=cellArray[i][j].returnV();
			}
		//if it is a bomb changes the values to reflect
		}else if(cellArray[i][j].returnV()=="B") {
			loss=true;
			state[i][j]=cellArray[i][j].returnV();
		//if it is just a count change the state to the count
		}else {
			state[i][j]=cellArray[i][j].returnV();
		}
		}
		checkWin();
	}
		//makrs the cell and chnages its state
	public void mark(int i, int j) {
		if(cellArray[i][j].getMark()==true){
			cellArray[i][j].setMark(false);
			state[i][j]= "y";
		}
		else{
			cellArray[i][j].setMark(true);
			state[i][j]="?";
		}
	}
	//reveals the entire board
	public void unmask() {
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	cellArray[i][j].returnV();
            	
            }
		}
	}
	//checks if the win state has been met and changes the values to reflect that
	public void checkWin(){
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	//cehcks if all are a mine or covered 
            if(cellArray[i][j].isMine()==true || cellArray[i][j].isCovered()==false){
            }else{
            	win =false;
            }}
         }
         win =true;
	}
}

