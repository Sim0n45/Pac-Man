package prototype;


import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	public static final int TILE_SIZE = 20;

	public static void main(String[]args) {
		launch(args);
	}

	public void start(Stage stage) {
		try {
			Maze m = new Maze(new File(getParameters().getRaw().get(0)));
			PacMan pm = new PacMan(m);
			Group root = new Group();
			root.getChildren().add(m);
			root.getChildren().add(pm);
			Scene scene = new Scene(root, TILE_SIZE * m.getWIDTH(), TILE_SIZE * (m.getHEIGHT() + 5), Color.BLACK);
			stage.setScene(scene);
			stage.setTitle("Pac-Man");
			stage.show();
			DirectionChange dc = new DirectionChange();
			scene.setOnKeyPressed(dc);
			CharacterAnimation ca = new CharacterAnimation(dc, pm);
			ca.start();
		} catch (FileNotFoundException e) {
			System.out.print("Fichier labyrinthe introuvable.");
			System.exit(0);
		} catch (MapFormatException e) {
			System.out.print("Fichier labyrinthe incorrect.");
			System.exit(0);
		}
	}

}
