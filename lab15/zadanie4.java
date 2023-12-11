package lab15;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;

public class zadanie4 extends JFrame {
    private final JTextField textField;
    private final JButton Button1;
    private final JButton Button2;
    private final JButton Button3;
    private final JButton Button4;
    private final JButton Button5;
    private final JButton Button6;
    private final JButton Button7;
    private final JButton Button8;
    private final JButton Button9;
    private final JButton Button0;
    private final JButton ButtonDel;
    private final JButton ButtonUmn;
    private final JButton ButtonPlu;
    private final JButton ButtonMin;
    private final JButton ButtonToch;
    private final JButton ButtonRav;
    private final JButton ButtonClear;

    private String a;

    JPanel contents = new JPanel(new FlowLayout(FlowLayout.CENTER));

    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("js");

    public void enableButtons() {
        ButtonDel.setEnabled(true);
        ButtonUmn.setEnabled(true);
        ButtonPlu.setEnabled(true);
        ButtonMin.setEnabled(true);
        ButtonToch.setEnabled(true);
        ButtonRav.setEnabled(true);
    }

    public void offButtons() {
        ButtonDel.setEnabled(false);
        ButtonUmn.setEnabled(false);
        ButtonPlu.setEnabled(false);
        ButtonMin.setEnabled(false);
        ButtonToch.setEnabled(false);
        ButtonRav.setEnabled(false);
    }

    public zadanie4() {
        setTitle("Calculator");
        setSize(350, 375);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        a = "";

        textField = new JTextField(25);
        contents.add(textField);
        setContentPane(contents);
        textField.setText(a);

        Button1 = new JButton("1");
        Button2 = new JButton("2");
        Button3 = new JButton("3");
        Button4 = new JButton("4");
        Button5 = new JButton("5");
        Button6 = new JButton("6");
        Button7 = new JButton("7");
        Button8 = new JButton("8");
        Button9 = new JButton("9");
        Button0 = new JButton("0");
        ButtonDel = new JButton("/");
        ButtonUmn = new JButton("*");
        ButtonPlu = new JButton("+");
        ButtonMin = new JButton("-");
        ButtonRav = new JButton("=");
        ButtonToch = new JButton(".");
        ButtonClear = new JButton("Clear");

        Button1.addActionListener(e -> {
            a = a + Button1.getText();
            textField.setText(a);
            enableButtons();
        });

        Button2.addActionListener(e -> {
            a = a + Button2.getText();
            textField.setText(a);
            enableButtons();
        });

        Button3.addActionListener(e -> {
            a = a + Button3.getText();
            textField.setText(a);
            enableButtons();
        });

        Button4.addActionListener(e -> {
            a = a + Button4.getText();
            textField.setText(a);
            enableButtons();
        });

        Button5.addActionListener(e -> {
            a = a + Button5.getText();
            textField.setText(a);
            enableButtons();
        });

        Button6.addActionListener(e -> {
            a = a + Button6.getText();
            textField.setText(a);
            enableButtons();
        });

        Button7.addActionListener(e -> {
            a = a + Button7.getText();
            textField.setText(a);
            enableButtons();
        });

        Button8.addActionListener(e -> {
            a = a + Button8.getText();
            textField.setText(a);
            enableButtons();
        });

        Button9.addActionListener(e -> {
            a = a + Button9.getText();
            textField.setText(a);
            enableButtons();
        });

        Button0.addActionListener(e -> {
            a = a + Button0.getText();
            textField.setText(a);
            enableButtons();
        });

        ButtonUmn.addActionListener(e -> {
            a = a + ButtonUmn.getText();
            textField.setText(a);
            ButtonUmn.setEnabled(false);
            offButtons();
        });

        ButtonDel.addActionListener(e -> {
            a = a + ButtonDel.getText();
            textField.setText(a);
            ButtonDel.setEnabled(false);
            offButtons();
        });

        ButtonPlu.addActionListener(e -> {
            a = a + ButtonPlu.getText();
            textField.setText(a);
            ButtonPlu.setEnabled(false);
            offButtons();
        });

        ButtonMin.addActionListener(e -> {
            a = a + ButtonMin.getText();
            textField.setText(a);
            ButtonMin.setEnabled(false);
            offButtons();
        });

        ButtonRav.addActionListener(e -> {
            String result;
            try {
                result = engine.eval(a).toString();
                textField.setText(result);
                a = result;
            } catch (ScriptException ex) {
                textField.setText("Ошибка");
                a = "";
            }
            enableButtons();
        });

        ButtonToch.addActionListener(e -> {
            a = a + ButtonToch.getText();
            textField.setText(a);
            ButtonToch.setEnabled(false);
            offButtons();
        });

        ButtonClear.addActionListener(e -> {
            textField.setText("");
            a = "";
            enableButtons();
        });

        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 24));
        container.add(Button7);
        container.add(Button8);
        container.add(Button9);
        container.add(ButtonDel);
        container.add(Button4);
        container.add(Button5);
        container.add(Button6);
        container.add(ButtonUmn);
        container.add(Button1);
        container.add(Button2);
        container.add(Button3);
        container.add(ButtonMin);
        container.add(Button0);
        container.add(ButtonToch);
        container.add(ButtonRav);
        container.add(ButtonPlu);
        container.add(ButtonClear);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new zadanie4().setVisible(true));
    }
}