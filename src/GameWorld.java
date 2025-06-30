import java.util.Vector;

public class GameWorld {
	static Player player;
	static Vector<PlayerBullet> playerBullets;
	public static Vector<Explosion> effects = new Vector<Explosion>();
	static Vector<Enemy> enemies;
	static boolean enterPressed;
	static int stage;
	static long score;
	static int playerLife;
	static int EnemyBaseLife;
	public static final int INVINCIBLE_TIME = 60; // 無敵時間（フレーム単位、約2秒）
	public static int invincibleTimer = 0; // 無敵時間の残りフレーム
}
