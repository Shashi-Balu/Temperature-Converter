import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
import java.awt.Image;

class TemperatureConverter extends JFrame {
    private TemperatureConverter() {
        //Image
        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:/Users/Dell/Downloads/Coding for Courses/Java/TemperatureImage.jpg")));
        setLayout(new FlowLayout());

        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }
    public static void main(String[] rk) {

        TemperatureConverter temp = new TemperatureConverter();

        JLabel l = new JLabel("Temperature Converter");
        l.setFont(new Font("Serif Bold", Font.BOLD, 30));
        l.setForeground(Color.DARK_GRAY);
        l.setBounds(160, 30, 500, 100);
        temp.add(l);


        Font f = new Font("Sans Serif Bold", Font.BOLD, 20);

        JLabel labelTemp = new JLabel("Temperature"); temp.add(labelTemp);
        labelTemp.setFont(f); labelTemp.setForeground(Color.DARK_GRAY);
        JTextField textTemp = new JTextField(); temp.add(textTemp);
        textTemp.setFont(f); textTemp.setForeground(Color.DARK_GRAY);
        temp.add(labelTemp); labelTemp.setBounds(150, 120, 200, 30);
        temp.add(textTemp); textTemp.setBounds(300, 120, 200, 40);

        JLabel labelFrom = new JLabel("From"); temp.add(labelFrom);
        labelFrom.setFont(f); labelFrom.setForeground(Color.DARK_GRAY);
        String[] from = {"Select", "Celsius", "Fahrenheit", "Kelvin"};

        JComboBox <String> comboFrom = new JComboBox<>(from); temp.add(comboFrom);
        comboFrom.setFont(new Font("Sans Serif", 2, 18)); comboFrom.setForeground(Color.DARK_GRAY);
        temp.add(labelFrom); labelFrom.setBounds(150, 200, 200, 30);
        temp.add(comboFrom); comboFrom.setBounds(300, 200, 200, 40);
        
        JLabel labelTo = new JLabel("To"); temp.add(labelTo);
        labelTo.setFont(f); labelTo.setForeground(Color.DARK_GRAY);
        String[] to = {"Select" ,"Celsius", "Fahrenheit", "Kelvin"};

        JComboBox <String> comboTo = new JComboBox<>(to); temp.add(comboTo);
        comboTo.setFont(new Font("Sans Serif", 2, 18)); comboTo.setForeground(Color.DARK_GRAY);
        temp.add(labelTo); labelTo.setBounds(150, 280, 200, 30);
        temp.add(comboTo); comboTo.setBounds(300, 280, 200, 40);

        JLabel outTemp = new JLabel("Converted "); temp.add(outTemp);
        outTemp.setFont(f); outTemp.setForeground(Color.DARK_GRAY);
        JLabel textOut = new JLabel(); temp.add(textOut);
        textOut.setFont(f); textOut.setForeground(Color.DARK_GRAY);
        textOut.setBackground(Color.WHITE); textOut.setOpaque(true);
        temp.add(outTemp); outTemp.setBounds(150, 360, 200, 30);
        temp.add(textOut); textOut.setBounds(300, 360, 200, 40);

        JButton b1 = new JButton("Convert"); temp.add(b1);
        b1.setBounds(300, 440, 100, 40);

        b1.addActionListener(
            ae ->
            {
                String inputFrom = (String)comboFrom.getSelectedItem();
                String inputTo = (String)comboTo.getSelectedItem();

                double ftemp, ctemp, ktemp;  // To hold the temperatures

        // Create a DecimalFormat object to format numbers.
        DecimalFormat formatter = new DecimalFormat("0.0");
        
        if(textTemp.getText().trim().isEmpty()){ 
            JOptionPane.showMessageDialog(null, "Enter Temperature");
        }

        else if(inputFrom.equals("Select")){ 
            JOptionPane.showMessageDialog(null, "Enter Convert From");
        }
        
        else if (inputTo.equals("Select")){ 
            JOptionPane.showMessageDialog(null, "Enter Convert To");
        }

        //From Farhrenheit
        else if (inputFrom.equals("Fahrenheit")) {
            ftemp = Double.parseDouble(textTemp.getText());

            //Celsuis
            if(inputTo.equals("Celsius")) {
                ctemp = (5.0 / 9.0) * (ftemp - 32);
                textOut.setText(formatter.format(ctemp));
            }

            //Kelvin
            else if(inputTo.equals("Kelvin")) {
                ktemp = (ftemp - 32)*(5.0 / 9.0) + 273.15;
                textOut.setText(formatter.format(ktemp));
            }

            //Farhenheit
            else if(inputTo.equals("Fahrenheit")) {
                textOut.setText(formatter.format(ftemp));
            }
        }

        //From Kelvin
        else if (inputFrom.equals("Kelvin")) {
            ktemp = Double.parseDouble(textTemp.getText());

            //Celius
            if(inputTo.equals("Celsius")) {
                ctemp = ktemp - 273.15;
                textOut.setText(formatter.format(ctemp));
                }

            //Farhenheit
            else if (inputTo.equals("Fahrenheit")) {
                ftemp = (ktemp - 273.15)*(9.0 / 5.0) + 32;
                textOut.setText(formatter.format(ftemp));
            }

            //Kelvin
            else if(inputTo.equals("Kelvin")) {
                textOut.setText(formatter.format(ktemp));
            }
        }
        
        //From Celsius
        else if (inputFrom.equals("Celsius")) {
        ctemp = Double.parseDouble(textTemp.getText());

            //Kelvin
            if(inputTo.equals("Kelvin")) {
                ktemp = ctemp + 273.15;
                textOut.setText(formatter.format(ktemp));
                }
            
            // Farhrenheit
            else if (inputTo.equals("Fahrenheit")) {
                ftemp = ctemp*(9.0 / 5.0) + 32;
                textOut.setText(formatter.format(ftemp));
            }

            //Celsius
            else if(inputTo.equals("Celsius")) {
                textOut.setText(formatter.format(ctemp));
            }
        }

        
    
        });
        temp.setVisible(true);
    }
}