package prototype;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PacMan extends Parent {

	private ImageView sprite;

	public PacMan(Maze m) {
		Image img = new Image(PacMan.class.getResourceAsStream("Pac-Man.png"));
		sprite = new ImageView(img);
		sprite.setFitWidth(Main.TILE_SIZE);
		sprite.setPreserveRatio(true);
		sprite.setSmooth(true);
		sprite.setCache(true);
		sprite.setLayoutX(Main.TILE_SIZE * m.getSpawnTileX());
		sprite.setLayoutY(Main.TILE_SIZE * m.getSpawnTileY());
		this.getChildren().add(sprite);
	}

	public void move(double dx , double dy) {
		if (dx == 0 && dy == 0)
			return;
		double x = sprite.getLayoutX() + dx;
		double y = sprite.getLayoutY() + dy;
		sprite.relocate(x, y);
	}

	public ImageView getSprite() {
		return sprite;
	}

}
