package weightConverter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class WeightConv extends JFrame {

    JButton b;
    JTextArea a2;
    JTextField a1;
    JCheckBox kg1, kg2, pound1, pound2, ounce1, ounce2;

    public WeightConv() {
        setTitle("Weight Converter");

        JLabel l = new JLabel("WEIGHT CONVERTER");
        l.setBounds(120, 0, 180, 20);
        add(l);

        JLabel l2 = new JLabel("INPUT UNIT");
        l2.setBounds(56, 65, 100, 10);
        add(l2);

        JLabel l3 = new JLabel("OUTPUT UNIT");
        l3.setBounds(230, 65, 100, 10);
        add(l3);

        b = new JButton("Convert");
        b.setBounds(120, 260, 100, 50);

        a1 = new JTextField();
        a1.setBounds(120, 20, 100, 30);

        a2 = new JTextArea();
        a2.setBounds(120, 310, 100, 40);

        kg1 = new JCheckBox("KG");
        kg1.setBounds(50, 110, 140, 20);

        kg2 = new JCheckBox("KG");
        kg2.setBounds(230, 110, 140, 20);

        pound1 = new JCheckBox("Pounds");
        pound1.setBounds(50, 160, 100, 20);

        pound2 = new JCheckBox("Pounds");
        pound2.setBounds(230, 160, 100, 20);

        ounce1 = new JCheckBox("Ounce");
        ounce1.setBounds(50, 210, 100, 20);

        ounce2 = new JCheckBox("Ounce");
        ounce2.setBounds(230, 210, 100, 20);

        add(b);
        add(a1);
        add(a2);
        add(kg1); add(kg2);
        add(pound1); add(pound2);
        add(ounce1); add(ounce2);

        b.addActionListener(new Handler());

        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class Handler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s = a1.getText();
            double d;

            try {
                d = Double.parseDouble(s);
            } catch (NumberFormatException ex) {
                a2.setText("Invalid input!");
                return;
            }

            // Conversion logic
            if (kg1.isSelected()) {
                if (kg2.isSelected()) a2.setText(s);
                else if (pound2.isSelected()) a2.setText(String.format("%.2f", d * 2.205));
                else if (ounce2.isSelected()) a2.setText(String.format("%.2f", d * 35.274));
            } else if (pound1.isSelected()) {
                if (kg2.isSelected()) a2.setText(String.format("%.2f", d / 2.205));
                else if (pound2.isSelected()) a2.setText(s);
                else if (ounce2.isSelected()) a2.setText(String.format("%.2f", d / 0.0625));
            } else if (ounce1.isSelected()) {
                if (kg2.isSelected()) a2.setText(String.format("%.2f", d / 35.274));
                else if (pound2.isSelected()) a2.setText(String.format("%.2f", d * 0.0625));
                else if (ounce2.isSelected()) a2.setText(s);
            } else {
                a2.setText("Select input & output units");
            }
        }
    }

    public static void main(String[] args) {
        new WeightConv();
    }
}
