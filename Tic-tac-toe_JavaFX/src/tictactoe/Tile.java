package tictactoe;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * 
 * @author Erik
 *
 * Representing the building blocks (each square) of the game Tic-tac-toe
 *
 */

public class Tile extends StackPane {

	public static boolean isPlayersTurn = true; // directs who's turn it is
	public static int markCounter = 0;
	private Text mark; //
	private boolean isMarked = false; // is this tile marked or not
	
	
	public Tile() {
		this.setWidth(200);
		this.setHeight(200);
		this.mark = new Text("");
		mark.setFont(new Font("Arial", 160));
		this.getChildren().add(mark);
		
		this.setOnMouseClicked(mouseEvent -> onClick());
	}
	
	private void onClick(){
		if(isPlayersTurn && !isMarked){
			mark.setText("x");
			changeTurns();
			isMarked = true;
			markCounter++;
			
		}

		
	}
	
	public void changeTurns(){
		isPlayersTurn = !isPlayersTurn;
		System.out.println("changing turns to " + isPlayersTurn );
	}
	
	/**
	 * For computer "AI" to play only
	 */
	public void markMe(){
		mark.setText("o");
		isMarked = true;
		markCounter++;
		changeTurns();
	}
	
	public void setIsMarked(boolean isMarked){
		this.isMarked = isMarked;
	}
	
	public boolean isMarked(){
		return isMarked;
	}
	
	public void setMark(String mark){
		this.mark.setText(mark);
	}



}
