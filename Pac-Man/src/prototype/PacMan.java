package prototype;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PacMan extends Parent {

	private ImageView sprite;

	public PacMan() {
		Image img = new Image(PacMan.class.getResourceAsStream("Pac-Man.png"));
		sprite = new ImageView(img);
		sprite.setFitWidth(Main.TILE_SIZE);
		sprite.setPreserveRatio(true);
		this.getChildren().add(sprite);
	}

	public void move(double dx , double dy) {
		if (dx == 0 && dy == 0)
			return;
		double cx = sprite.getBoundsInLocal().getWidth() / 2;
		double cy = sprite.getBoundsInLocal().getHeight() / 2;
		double x = cx + sprite.getLayoutX() + dx;
		double y = cy + sprite.getLayoutY() + dy;
		sprite.relocate(x - cx, y - cy);
	}

}
