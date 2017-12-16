package core;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {

    private static ArrayList<GameObject> list = new ArrayList<>();
    private static ArrayList<GameObject> newList = new ArrayList<>();

    public BufferedImage image;
    public Vector2D position;

    public GameObject() {
        this.position = new Vector2D();
    }

    public void run() {

    }

    public void render(Graphics2D graphics2D) {
        graphics2D.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);
    }

    public static void add(GameObject gameObject) {
        newList.add(gameObject);
    }

    public static void renderAll(Graphics2D graphics2D) {
        for (GameObject gameObject: list) {
            gameObject.render(graphics2D);
        }
    }

    public static void runAll() {
        for (GameObject gameObject: list) {
            gameObject.run();
        }
        list.addAll(newList);
        newList.clear();
    }
}
