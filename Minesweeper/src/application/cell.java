package application;

public class cell {

	private boolean mine;
    private boolean mark;
    private boolean flag;
    private boolean cover;
    private boolean checked;
    
    private int rowPosition;
    private int columnPosition;

    private int value;

    /*
    public cell(int x, int y, boolean mine) {
    	
    	this.rowPosition = x;
    	this.columnPosition = y;
        this.cover = true;
        this.mark  = false;
        this.mine  = mine;
        this.value = 0;
    }
    */
    
    
    public cell() {
        this.cover = true;
        this.mark  = false;
        this.mine  = false;
        this.flag = false;
        this.value = 0;
    }
    
    
    public int getRowPosition() {
    	return rowPosition;
    }
    
    public int getColumnPosition() {
    	return columnPosition;
    }

    public int getValue() {
        return this.value;
    }

    public void uncover() {
        this.cover = false;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    public boolean isEmpty() {
        return this.value == 0;
    }

    public boolean isMine() {
        return this.mine;
    }
    
    public boolean isFlag() {
    	return this.flag;
    }
    
    public void setFlag(boolean f) {
    	this.flag = f;
    }

    public void setMine(boolean b) {
        this.mine = b;
    }

    public boolean getMark() {
        return this.mark;
    }

    public boolean isCovered() {
        return this.cover;
    }
    
    

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isCoveredMine() {
        return this.cover && this.mine;
    }

    public void checked() {
        this.checked = true;
    }

    public void clearChecked() {
        this.checked = false;
    }

    public void setAroundMines(int count) {
        this.value = count;
    }

    public int getAroundMines() {
        return this.value;
    }
    
    public String returnV(){
    	if (isMine() == true) {
    		return "B";
    	}
    	else if (isFlag() == true) {
    		return "F";
    	}
    	else if (getAroundMines() == 0) {
    		return " ";
    	}
    	else {
    		return Integer.toString(getAroundMines());
    	}
    }
}