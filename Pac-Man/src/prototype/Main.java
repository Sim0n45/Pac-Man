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

	public void start(Stage primaryStage) throws FileNotFoundException, MapFormatException {
		Maze m;
		m = new Maze(new File(getParameters().getRaw().get(0)));
		primaryStage.setTitle("Pac-Man");
	    Group root = new Group();
	    Scene scene = new Scene(root, 20 * m.getWIDTH(), 20 * m.getHEIGHT(), Color.BLACK);
	    root.getChildren().add(m);
	    primaryStage.setScene(scene);
	    primaryStage.show();
    }

}
