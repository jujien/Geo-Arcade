package game;

import core.GameObject;
import core.Utils;

public class Player extends GameObject {

    private int count = 0;

    public Player() {
        this.image = Utils.loadImage("resources/player/straight.png");
    }

    private void shoot() {
        if (this.count >= 30) {
            Bullet bullet = new Bullet();
            bullet.position.set(this.position);
            bullet.velocity.set(0.0f, 5.0f);
            GameObject.add(bullet);
            this.count = 0;
        } else {
            this.count += 1;
        }
    }

    @Override
    public void run() {
        super.run();
        this.shoot();
    }
}
