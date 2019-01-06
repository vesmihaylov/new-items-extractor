import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;

public class Main {
    // Setting the character encoding to UTF-8
    public static String buttonTitle = "Покажи изтеклите продукти";
    ByteBuffer byteBuffer4 = StandardCharsets.UTF_8.encode(buttonTitle);
    public static String textAreaTitle = "Премахнатите продукти са: ";
    ByteBuffer byteBuffer5 = StandardCharsets.UTF_8.encode(textAreaTitle);
    public static JTextArea textarea = new JTextArea(textAreaTitle);
    public static JButton button = new JButton(buttonTitle);
    public static JTextField textfield = new JTextField();
    public static JTextField textfield2 = new JTextField();

    public static void main(String[] args) {
        // Creating the JFrame window
        createWindow();
        // The logic behind finding and outputing the missing values from the list
        ArrayList<String> deletedproducts = new ArrayList<>();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deletedproducts.clear(); // Clears the list every time the button is clicked so it doesn't fill up the text area
                String pricelist1 = textfield.getText();
                List<String> list1 = Arrays.asList(pricelist1.split(","));
                String pricelist2 = textfield2.getText();
                List<String> list2 = Arrays.asList(pricelist2.split(","));
                for (int i = 0; i < list1.size(); i++) {
                    if (list2.contains(list1.get(i))) {
                        continue;
                    } else {
                        deletedproducts.add(list1.get(i));
                    }
                }
                textarea.setText(textAreaTitle + "\n" + Arrays.toString(deletedproducts.toArray()));
            }
        });
    }

    public static void createWindow(){
        // Setting the character encoding to UTF-8
        String frameTitle = "Проверка на изтекли продукти";
        ByteBuffer byteBuffer1 = StandardCharsets.UTF_8.encode(frameTitle);
        JFrame frame = new JFrame(frameTitle);
        String labelOneTitle = "Въведете SKU-та от старата ценова листа разделени с запетая: ";
        ByteBuffer byteBuffer2 = StandardCharsets.UTF_8.encode(labelOneTitle);
        JLabel label1 = new JLabel(labelOneTitle);
        String labelTwoTitle = "Въведете SKU-та от новата ценова листа разделени с запетая: ";
        ByteBuffer byteBuffer3 = StandardCharsets.UTF_8.encode(labelTwoTitle);
        JLabel label2 = new JLabel(labelTwoTitle);
        // Frame settings
        frame.getContentPane().setBackground(Color.white);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setForeground(new java.awt.Color(29, 132, 187));
        frame.setLayout(null); // Using no layout managers
        textarea.setLineWrap(true);
        textarea.setEditable(false);
        textarea.setForeground(new java.awt.Color(29, 132, 187));
        textarea.setBounds(35, 10, 600, 160);
        label1.setForeground(new java.awt.Color(29, 132, 187));
        label1.setBounds(35, 460, 390, 50);
        label2.setForeground(new java.awt.Color(29, 132, 187));
        label2.setBounds(35, 515, 390, 50);
        textfield.setBounds(35, 500, 600, 30);
        textfield2.setBounds(35, 555, 600, 30);
        Font buttonFont = new Font("Open-Sans", Font.PLAIN, 12);
        button.setBounds(230, 600, 200, 30);
        button.setBackground(new Color(29, 132, 187));
        button.setForeground(Color.white);
        button.setFont(buttonFont);
        frame.add(button);
        frame.add(textfield);
        frame.add(textfield2);
        frame.add(label1);
        frame.add(label2);
        frame.add(textarea);
        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        }
    }
