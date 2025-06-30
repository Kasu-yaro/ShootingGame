
public class EaseIn extends Enemy {
	public EaseIn(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);

		life = 1;
		score = 500 * (GameWorld.stage * 3 / 2);
	}

	public void move() {
		super.move();
		// 加速度をvyに加え、加速度も少しずつ増加させる
		vy += GameWorld.stage * 0.001 + vy * 0.01;

	}

	public void draw(MyFrame f) {
		f.setColor(256, 64, 64);
		f.fillRect(x, y - 30, 30, 10);

		f.setColor(256, 64, 64);
		f.fillRect(x + 10, y - 20, 10, 20);

	}
}
