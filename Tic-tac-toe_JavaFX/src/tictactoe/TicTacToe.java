package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.geometry.Pos;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

/**
 * 
 * @author Erik
 *
 *	A simple game to learn more JavaFX
 *
 */

public class TicTacToe extends GridPane { // TODO: see if TilePane is simpler in this case (probably is. won't have to setConstraints for every point in the grid)
	
	private List<Tile> tiles;

	public TicTacToe() {
		
		this.tiles = new ArrayList<Tile>();
		this.setAlignment(Pos.TOP_LEFT);
		this.setGridLinesVisible(true);
		setConstraints();
		makeAndAddTiles();
		
		this.setOnMouseClicked( event -> {
			if(Tile.isPlayersTurn){
				
			} else {
				if(Tile.markCounter != 9){
					computerPlay();	
				}
				
			}
			if(event.getButton() == MouseButton.SECONDARY){
				// reset
				resetGame();
				System.out.println("Game reset");
			}
		});

	}
	
	private void setConstraints(){
		
		// set column/ row width constraints
		ColumnConstraints everyColumnConstraint = new ColumnConstraints(200);
		RowConstraints everyRowConstraint = new RowConstraints(200);

		this.setGridLinesVisible(true);

		// set constrains for columns and rows
		for(int index = 0; index < 3; index++){
			this.getRowConstraints().add(index, everyRowConstraint);
			this.getColumnConstraints().add(index, everyColumnConstraint); // row is just used as a number here.
		}
	}
	
	private void makeAndAddTiles(){
		for(int row = 0; row < 3; row++){
			for(int column = 0; column < 3; column++){
				Tile tile = new Tile();
				this.add(tile, column, row);
				// add them to a list too
				tiles.add(tile);
				
			}
		}
	}
	
	
	private void computerPlay(){
		Random randGen = new Random();
		while(true){
			int index = randGen.nextInt(tiles.size()); // one random tile
			Tile tileToPlay = tiles.get(index);
			System.out.println(index);
			// play if it's not already played
			if(!tileToPlay.isMarked()){
				System.out.println("Marking tile!");
				tileToPlay.markMe();
				break;
			}
		}
	}
	
	private void resetGame(){
		for(Tile tile : tiles){
			tile.setMark("");
			tile.setIsMarked(false);
		}
		Tile.isPlayersTurn = true;
		Tile.markCounter = 0;
	}
	
	
	//TODO: implement a gameWonCheck()  + check out the animation thing that was in the tutorial
	
	

}
