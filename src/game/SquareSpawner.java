package game;

import core.GameObject;
import java.util.Random;

public class SquareSpawner extends GameObject {

    private int countSquare = 0;

    public SquareSpawner() {
    }

    @Override
    public void run() {
        super.run();
        if (this.countSquare >= 50) {
            Random random = new Random();
            Square square = new Square();
            square.position.set(random.nextInt(400), 0.0f);
            square.velocity.set(0.0f, random.nextInt(4) + 1);
            this.countSquare = 0;
            GameObject.add(square);
        } else {
            this.countSquare += 1;
        }
    }
}
