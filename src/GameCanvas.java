import core.GameObject;
import game.Background;
import game.Player;
import game.SquareSpawner;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameCanvas extends JPanel {

    Player player;
    BufferedImage backBuffered;
    Graphics2D graphics2D;
    public int positionX = 0;
    public int positionY = 0;

    public GameCanvas() {
        this.setSize(400, 600);
        this.setVisible(true);

        this.player = new Player();
        GameObject.add(new Background());
        GameObject.add(this.player);
        GameObject.add(new SquareSpawner());

        this.backBuffered = new BufferedImage(400, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics2D = (Graphics2D) this.backBuffered.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void render() {
        GameObject.renderAll(this.graphics2D);
        this.repaint();
    }

    public void run() {
        this.player.position.set(this.positionX, this.positionY);
        GameObject.runAll();
    }
}
