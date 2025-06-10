
public class Character {
	double x, y, vx, vy;

	public Character(double x, double y, double vx, double vy) {
		//コンストラクタ
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}

	public void move() {
		//moveメソッド
		x += vx;
		y += vy;
	}

	public void draw(MyFrame f) {
		//drawメソッド
		//draw:標準では単純な四角形が描かれる
		f.setColor(0, 0, 0);
		f.fillRect(x, y, vy, vx);
		//P186 - リスト10.8
	}
}
