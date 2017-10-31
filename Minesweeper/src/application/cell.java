package application;
import javafx.application.Application;
import javafx.stage.Stage;



public class cell extends Application{ 
		// TODO Auto-generated method stub
	private int field_id;
    private int posx;
    private int posy;

    private boolean is_revealed;        //If the field is Revealed
    private boolean is_flag;            //If the field is selected
    
    public Field( int x, int y, int field_id) {
        this.field_id = field_id;
        this.posx = x;
        this.posy = y;
        this.is_revealed = false;
        this.is_flag = false;

    }
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

		     }


