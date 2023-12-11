package lab5;

import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

public class Test extends JFrame
{
    Random rand = new Random();

    public void paint(Graphics g)
    {
        super.paint(g);
        Polygon p = new Polygon();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < rand.nextInt(3, 6); j++) {
                p.addPoint((i%5 + 1) * getSize().width/6 + rand.nextInt(-(getSize().width/12), getSize().width/12), (i%4 + 1) * getSize().height/5 + rand.nextInt(-(getSize().height/10), getSize().height/10));
            }
            g.drawPolygon(p);

            float r = rand.nextFloat();
            float a = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, a, b);

            g.setColor(randomColor);
            g.fillPolygon(p);
            p = new Polygon();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Размеры окна: ");
        int w = scanner.nextInt();
        int h = scanner.nextInt();
        new Test(w, h);
    }

    public Test(int w, int h)
    {
        super("Test");
        JFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(w, h);
        setVisible(true);
    }
}
