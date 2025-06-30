
public class StraightEnemy extends Enemy {

	public StraightEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life = 2;
		score = 350 * (GameWorld.stage * 3 / 2);
	}

	public void draw(MyFrame f) {
		f.setColor(0, 0, 0);
		f.fillRect(x + 8, y - 15, 14, 15);

		f.setColor(0, 0, 0);
		f.fillRect(x + 10, y, 10, 15);

	}
}
