public class Explosion {
	double x, y;
	int life; // エフェクトの残りフレーム数

	public Explosion(double x, double y) {
		this.x = x;
		this.y = y;
		this.life = 3; // 表示フレーム数
	}

	public void move() {
		life--;
	}

	public void draw(MyFrame f) {
		if (life > 0) {
			f.setColor(255, 128, 0); // オレンジ色
			f.fillOval(x - life, y - life, life * 10, life * 10); // 拡大する円
		}
	}

	public boolean isDead() {
		return life <= 0;
	}
}
