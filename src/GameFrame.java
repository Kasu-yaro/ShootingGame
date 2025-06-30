import java.util.Vector;

public class GameFrame extends MyFrame {
	public void run() {
		GameWorld.player = new Player(100, 300, 0, 0);
		addKeyListener(GameWorld.player);
		GameWorld.stage = 1;
		GameWorld.score = 0;
		while (true) {
			GameWorld.player.x = 100 * 4;
			GameWorld.player.y = 300 * 2;//
			GameWorld.playerLife = 5; // プレイヤーのHPを5に設定
			GameWorld.EnemyBaseLife = 0;
			GameWorld.invincibleTimer = 0; // 新しいステージ開始時に無敵タイマーをリセット
			GameWorld.playerBullets = new Vector<PlayerBullet>();
			GameWorld.enemies = new Vector<Enemy>();
			GameWorld.enemies.add(new EnemyBase(100, 50, GameWorld.stage, 0));
			GameWorld.enterPressed = false;
			while (true) {
				clear();
				repaint(); // 描画内容を画面に反映
				drawString("Stage = " + GameWorld.stage, 30, 50, 15);
				drawString("Scoer = " + GameWorld.score, 30, 80, 15);
				drawString("Life = " + GameWorld.playerLife, 30, 110, 15);
				drawString("BaseHP = " + GameWorld.EnemyBaseLife, 30, 140, 15);

				// 無敵状態の場合、プレイヤーを点滅させる
				if (GameWorld.invincibleTimer > 0) {
					if (GameWorld.invincibleTimer % 6 < 3) { // 6フレームごとに点滅
						GameWorld.player.draw(this);
					}
					GameWorld.invincibleTimer--; // 無敵タイマーを減らす
				} else {
					GameWorld.player.draw(this);
				}
				GameWorld.player.move();
				movePlayerBullets();
				moveEnemies();
				checkPlayerAndEnemies();//
				checkPlayerBulletsAndEnemies();
				// プレイヤーと敵の描画の後にエフェクトを描画
				for (int i = 0; i < GameWorld.effects.size(); ) {
					Explosion ex = GameWorld.effects.get(i);
					ex.draw(this);
					ex.move();
					if (ex.isDead()) {
						GameWorld.effects.remove(i);
					} else {
						i++;
					}
				}
				
				if (GameWorld.enemies.size() == 0) {//敵が全滅したか//
					setColor(0, 0, 0);
					drawString("クリア", 100, 200, 40);

					GameWorld.enemies.clear();

					if (GameWorld.enterPressed) {//Enterが押されたか
						GameWorld.stage++;
						break;
					}
				} else if (GameWorld.player.y < 0 || GameWorld.playerLife <= 0) {
					setColor(0, 0, 0);
					drawString("ゲームオーバー", 50, 200, 40);
					if (GameWorld.enterPressed) {//Enterが押されたか
						GameWorld.stage = 1;
						GameWorld.score = 0;
						GameWorld.playerLife = 5; // ゲームオーバー時にHPをリセット
						GameWorld.invincibleTimer = 0; //  ゲームオーバー時に無敵タイマーをリセット

						break;
					}
				}
				sleep(0.03);
			}
		}
	}

	public boolean checkHid(Character a, Character b) {
		if (Math.abs(a.x - b.x) <= 25 && Math.abs(a.y - b.y) <= 25) {
			return true;
		} else {
			return false;
		}
	}

	public void checkPlayerAndEnemies() {
		// 無敵時間中はダメージを受けないようにする
		if (GameWorld.invincibleTimer > 0) {
			return; // 無敵時間中は処理を中断
		}

		for (int i = 0; i < GameWorld.enemies.size(); i++) {
			Enemy e = GameWorld.enemies.get(i);
			if (checkHid(GameWorld.player, e)) {//衝突判定
				if (GameWorld.playerLife != 0) {
					GameWorld.playerLife--;
					GameWorld.invincibleTimer = GameWorld.INVINCIBLE_TIME; // ダメージを受けたら無敵時間を設定

				} else {

					System.out.println("FuckingGame");
					GameWorld.player.y = -4000;
					//12-1

				}
			}

		}

	}

	public void movePlayerBullets() {
		int i = 0;
		while (i < GameWorld.playerBullets.size()) {
			PlayerBullet b = GameWorld.playerBullets.get(i);
			b.draw(this);
			b.move();
			if (b.y < 0) {
				GameWorld.playerBullets.remove(i);
			} else {
				i++;

			}
		}
	}

	public void moveEnemies() {
		for (int i = 0; i < GameWorld.enemies.size(); i++) {
			Enemy e = GameWorld.enemies.get(i);
			e.draw(this);
			e.move();
		}
		int i = 0;
		while (i < GameWorld.enemies.size()) {
			Enemy e = GameWorld.enemies.get(i);
			if (e.y > 850) {
				GameWorld.enemies.remove(i);
			} else {
				i++;
			}
		}
	}

	public void checkPlayerBulletsAndEnemies() {
		int i = 0;
		while (i < GameWorld.playerBullets.size()) {
			//プレイヤー弾一つ一つについて、変数bに入れて繰り返し実行する
			PlayerBullet b = GameWorld.playerBullets.get(i);
			int j = 0;
			int hits = 0;
			while (j < GameWorld.enemies.size()) {
				Enemy e = GameWorld.enemies.get(j);
				//敵eとプレイヤー弾bが衝突していたら「あたり」と表示
				if (checkHid(e, b)) {//衝突判定
					System.out.println("あたり");
					GameWorld.score += 1;
					hits++;
					e.life--;
				}
				if (e.life <= 0) {
					GameWorld.effects.add(new Explosion(e.x, e.y));
					GameWorld.score += e.score;
					if (e instanceof EnemyBase) {
						GameWorld.enemies.clear(); // クリア判定として敵全削除
						break;
					} else {
						GameWorld.enemies.remove(j);
					}
				} else {
					j++;
				}
			}
			if (hits > 0) {
				GameWorld.playerBullets.remove(i);

			} else {
				i++;

			}
			//12-9

		}
	}

}
