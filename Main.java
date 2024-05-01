import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();
        Tool pen = new Pen();
        Tool brush = new Brush();
        JFrame frame = new JFrame("Simple Whiteboard");
        String shapesOptions[] = {"Circle","Square"};
        String toolsOptions[] = {"Pen","Brush"};
        JComboBox shapes = new JComboBox(shapesOptions);
        JComboBox tools = new JComboBox(toolsOptions);
        JTextArea text = new JTextArea();
        ImageIcon logoImage = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\appLogo.png");
        JLabel title = new JLabel("Shape Canvas");
        WhiteBoard whiteBoard = new WhiteBoard();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(whiteBoard);
        frame.getContentPane().setBackground(new Color(237, 235, 235));
        frame.setLayout(null);
        frame.setSize(1250, 900);

        whiteBoard.setBorder(BorderFactory.createLineBorder(new Color(122, 122, 122),5));

        title.setBounds(25,30,400,50);
        title.setFont(new Font("Poppins", Font.BOLD, 35));
        title.setIconTextGap(20);
        title.setIcon(logoImage);

        shapes.setBounds(15,250,150,40);
        shapes.setFont(new Font("Poppins", Font.BOLD, 20));

        tools.setBounds(15,300,150,40);
        tools.setFont(new Font("Poppins", Font.BOLD, 20));

        text.setBounds(550,150,350,35);
        text.setFont(new Font("Poppins", Font.BOLD, 20));
        text.setEditable(false);

        frame.add(shapes);
        frame.add(tools);
        frame.add(title);
        frame.add(text);
        frame.setVisible(true);



    }
}
