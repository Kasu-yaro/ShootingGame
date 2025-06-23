
public class Enemy extends Character {
	int life = 2 * (GameWorld.stage * 3 / 2);
	int score = 10 * (GameWorld.stage * 3 / 2);

	public Enemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);

	}

}
