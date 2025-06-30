import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player extends Character implements KeyListener {

	public void draw(MyFrame f) {
		f.setColor(0, 128, 0);
		f.fillRect(x, y + 20, 30, 10);
		f.setColor(200, 200, 200);
		f.fillRect(x + 10, y, 10, 30);
	}

	public Player(double x, double y, double vx, double vy) {
		//characterクラスのコンストラクト呼び出し
		super(x, y, vx, vy);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			vx = 5;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			vx = -5;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			GameWorld.playerBullets.add(new PlayerBullet(x, y, 0, -20));
			GameWorld.playerBullets.add(new PlayerBullet(x, y, 3, -30));
			GameWorld.playerBullets.add(new PlayerBullet(x, y, -3, -30));

			GameWorld.playerBullets.add(new PlayerBullet(x, y, 5, -30));
			GameWorld.playerBullets.add(new PlayerBullet(x, y, -5, -30));

			GameWorld.playerBullets.add(new PlayerBullet(x, y, 10, -30));
			GameWorld.playerBullets.add(new PlayerBullet(x, y, -10, -30));

			GameWorld.playerBullets.add(new PlayerBullet(x, y, 15, -30));
			GameWorld.playerBullets.add(new PlayerBullet(x, y, -15, -30));

			GameWorld.playerBullets.add(new PlayerBullet(x, y, 30, -50));
			GameWorld.playerBullets.add(new PlayerBullet(x, y, -30, -50));

			System.out.println("弾の数=" + GameWorld.playerBullets.size());
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			System.out.println("Enterキーが押されました");
			GameWorld.enterPressed = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
			vx = 0;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
			vx = 0;
		}
	}
	//10-7終わり

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ

	}

	public void move() {
		super.move();
		if (x < 50)
			x = 50;
		if (x > 700)
			x = 700;
	}

}
