import javax.swing.*;
import java.awt.*;

public class SierpinskiTriangle extends JPanel {
    private int depth;

    public SierpinskiTriangle(int depth) {
        this.depth = depth;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawSierpinskiTriangle(g, depth, getWidth() / 2, 0, 400);
    }

    private void drawSierpinskiTriangle(Graphics g, int depth, int x, int y, int size) {
        if (depth == 0) {
            int[] xPoints = { x, x - size / 2, x + size / 2 };
            int[] yPoints = { y, y + size, y + size };
            g.setColor(Color.BLACK);
            g.fillPolygon(xPoints, yPoints, 3);
        } else {
            int halfSize = size / 2;
            drawSierpinskiTriangle(g, depth - 1, x, y, halfSize);
            drawSierpinskiTriangle(g, depth - 1, x - halfSize, y + size, halfSize);
            drawSierpinskiTriangle(g, depth - 1, x + halfSize, y + size, halfSize);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sierpinski Triangle");
        SierpinskiTriangle sierpinski = new SierpinskiTriangle(5);

        frame.add(sierpinski);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
