package lab12;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class zadanie2 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Изображение:");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            try {
                String imagePath = "C:/Users/Rexroth/Desktop/testpic.jpg";
                BufferedImage image = ImageIO.read(new File(imagePath));

                JLabel imageLabel = new JLabel(new ImageIcon(image));
                frame.add(imageLabel, BorderLayout.CENTER);

                frame.setVisible(true);
            } catch (Exception e) {
                System.err.println("Ошибка при загрузке изображения: " + e.getMessage());
            }
        });
    }
}
