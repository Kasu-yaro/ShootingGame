
public class Enemy extends Character {
	int life = 1 * (GameWorld.stage * 3 / 2);
	float score = 1000 * (GameWorld.stage * 3 / 2);

	public Enemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);

	}

}
