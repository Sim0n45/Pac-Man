package prototype;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Maze extends Parent {

	private final int HEIGHT = 36, WIDTH = 28;
	private boolean[][] board = new boolean[HEIGHT][WIDTH];

	public Maze(File f) throws MapFormatException, FileNotFoundException {
		Scanner sc = new Scanner(f);
		for(int i = 0; i < HEIGHT; i++) {
			String str;
			if(sc.hasNextLine()) {
				str = sc.nextLine();
				if(str.length() != WIDTH) {
					sc.close();
					throw new MapFormatException();
				}
			} else {
				sc.close();
				throw new MapFormatException();
			}
			for(int j = 0; j < WIDTH; j++) {
				char c = str.charAt(j);
				board[i][j] = (c == '0');
			}
		}
		sc.close();
		Image img = new Image(Maze.class.getResourceAsStream("Wall.jpg"));
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(board[i][j]) {
					ImageView iv = new ImageView();
			        iv.setImage(img);
			        iv.setFitWidth(Main.TILE_SIZE);
			        iv.setPreserveRatio(true);
			        iv.setSmooth(true);
			        iv.setCache(true);
			        iv.setX(Main.TILE_SIZE * j);
			        iv.setY(Main.TILE_SIZE * i);
					this.getChildren().add(iv);
				}
			}
        }
	}

	public String toString() {
		String str = "";
		for(int i = 0; i < HEIGHT; i++) {
			for(int j = 0; j < WIDTH; j++) {
				if(board[i][j])
					str += "0";
				else
					str += " ";
			}
			str += "\n";
		}
		return str;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public boolean[][] getBoard() {
		return board;
	}

}
