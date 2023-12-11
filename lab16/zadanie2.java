package lab16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class zadanie2 extends JFrame {
    private JTextArea textArea;
    private JMenu colorMenu;
    private JMenu fontMenu;

    public zadanie2() {
        setTitle("Text Editor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        add(new JScrollPane(textArea));

        colorMenu = new JMenu("Цвет");
        JMenuItem blueItem = new JMenuItem("Синий");
        blueItem.addActionListener(new ColorActionListener(Color.BLUE));
        colorMenu.add(blueItem);
        JMenuItem redItem = new JMenuItem("Красный");
        redItem.addActionListener(new ColorActionListener(Color.RED));
        colorMenu.add(redItem);
        JMenuItem blackItem = new JMenuItem("Черный");
        blackItem.addActionListener(new ColorActionListener(Color.BLACK));
        colorMenu.add(blackItem);

        fontMenu = new JMenu("Шрифт");
        JMenuItem timesNewRomanItem = new JMenuItem("Times New Roman");
        timesNewRomanItem.addActionListener(new FontActionListener("Times New Roman"));
        fontMenu.add(timesNewRomanItem);
        JMenuItem msSansSerifItem = new JMenuItem("MS Sans Serif");
        msSansSerifItem.addActionListener(new FontActionListener("MS Sans Serif"));
        fontMenu.add(msSansSerifItem);
        JMenuItem courierNewItem = new JMenuItem("Courier New");
        courierNewItem.addActionListener(new FontActionListener("Courier New"));
        fontMenu.add(courierNewItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(colorMenu);
        menuBar.add(fontMenu);
        setJMenuBar(menuBar);
    }

    private class ColorActionListener implements ActionListener {
        private Color color;

        public ColorActionListener(Color color) {
            this.color = color;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setForeground(color);
        }
    }

    private class FontActionListener implements ActionListener {
        private String fontName;

        public FontActionListener(String fontName) {
            this.fontName = fontName;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setFont(new Font(fontName, Font.PLAIN, 12));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new zadanie2().setVisible(true);
            }
        });
    }
}

