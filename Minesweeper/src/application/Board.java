package application;

public class Board {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	cell test = new cell();
	 
	public void setup(){
		cell cellArray[][]={};
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	cellArray[i][j]=test;
            }}
	}
	/*
	public String reveal(int i, int j) {
		//recursive
		if (cellArray[i][j].isCovered()==true){
			cellArray[i][j].uncover();
		}
		String out=cellArray[i][j].returnV();
		return out;
	}
		
	public String mark(int i, int j) {
		if(cellArray[i][j].getMark()==true){
			cellArray[i][j].setMark()==false;
			return "x";
		} else{
			cellArray[i][j].setMark(a)==true;
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
	
	public void checkwin(){
		for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            if(cellArray[i][j].isMine()==true || cellArray[i][j].isCovered()==true){
            }else{
            	return false;
            }}
         }
         return true;
	}
*/}
