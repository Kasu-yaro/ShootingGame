
public class EnemyBase extends Enemy {
	public EnemyBase(double x, double y, double vx, double vy) {
		super(x, y, vx, vy);
		life = 3 * (GameWorld.stage * 3 / 2);
		score = 10000 * (GameWorld.stage * 3 / 2);
	}

	public void move() {
		super.move();
		GameWorld.EnemyBaseLife = this.life;
		if (x > 700)
			vx = -GameWorld.stage;
		if (x < 100)
			vx = GameWorld.stage;
		if (Math.random() < 0.06 + (GameWorld.stage * 0.01)) {
			GameWorld.enemies.add(new StraightEnemy(Math.random() * 500, y, 0, 1 + 0.1 * GameWorld.stage));
		}
		if (Math.random() < 0.02 + (GameWorld.stage * 0.01)) {
			GameWorld.enemies.add(new RandomEnemy(x, y, 0, 0.1 * GameWorld.stage));
		}
		if (Math.random() < 0.6 + (GameWorld.stage * 0.05)) {
			GameWorld.enemies.add(new DropEnemy(x + Math.random() * 100, y, 0, 0.1 * GameWorld.stage));
		}
		if (Math.random() < 0.25 + (GameWorld.stage * 0.05)) {
			GameWorld.enemies.add(new EaseIn(x + Math.random() * 200, y, 0, 0.1 * GameWorld.stage));
		}
		if (Math.random() < 0.08 + (GameWorld.stage * 0.01)) {
			GameWorld.enemies.add(new CurveEnemy(x, y, 0, 3));
		}
	}

	public void draw(MyFrame f) {
		f.setColor(0, 128, 0);
		f.fillOval(x, y, 32, 32);
		f.setColor(200, 200, 200);
		f.fillOval(x - 16, y + 8, 64, 16);

	}
}
