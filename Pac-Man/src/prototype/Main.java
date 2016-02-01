package prototype;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		Application.launch(Main.class, args);
	}

	public void start(Stage primaryStage) {
		Maze m;
		try {
			m = new Maze(new File(getParameters().getRaw().get(0)));
			primaryStage.setTitle("Pac-Man");
	        Group root = new Group();
	        Scene scene = new Scene(root, 300, 250, Color.BLACK);
	        root.getChildren().add(m);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (FileNotFoundException e) {
			System.out.print("Fichier introuvable.");
		} catch (MapFormatException e) {
			System.out.print("Fichier incorrect.");
		}
    }

}
