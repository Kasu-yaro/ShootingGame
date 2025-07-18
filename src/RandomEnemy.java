
public class RandomEnemy extends Enemy {
	public RandomEnemy(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life = 2;
		score = 200 * (GameWorld.stage * 3 / 2);

	}

	public void move() {
		super.move();
		vx = Math.random() * 4 - 2;
	}

	public void draw(MyFrame f) {
		f.setColor(0, 128, 0);
		f.fillRect(x, y - 20, 10, 20);

		f.setColor(0, 128, 0);
		f.fillRect(x + 20, y - 20, 10, 20);

		f.setColor(0, 128, 0);
		f.fillRect(x + 10, y, 10, 10);

	}
}
