package prototype;

import javafx.animation.AnimationTimer;

public class CharacterAnimation extends AnimationTimer {

	private DirectionChange dc;
	private PacMan pm;

	public CharacterAnimation(DirectionChange dc, PacMan pm) {
		this.dc = dc;
		this.pm = pm;
	}

	public void handle(long now) {
		int x = 0, y = 0;
		if(dc.getDirection() == 1)
			y -= 1;
		if(dc.getDirection() == 2)
			y += 1;
		if(dc.getDirection() == 3)
			x -= 1;
		if(dc.getDirection() == 4)
			x += 1;
		pm.move(x, y);
	}

}
