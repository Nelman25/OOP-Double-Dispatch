
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener {
    Shape circle = new Circle();
    Shape square = new Square();
    Tool pen = new Pen();
    static Pen p;

    WhiteBoard whiteBoard;

    JFrame frame = new JFrame("Simple Whiteboard");
    static String[] shapesOptions = {"Default", "Circle" ,"Square"};
    String[] toolsOptions = {"Pen","Brush"};
    static JComboBox shapes = new JComboBox(shapesOptions);
    static JLabel text = new JLabel("Using pen on ______");
    ImageIcon logoImage = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\appLogo.png");
    JLabel title = new JLabel("Shape Canvas");

    ImageIcon CIRCLE = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\circle (2).png");
    ImageIcon SQUARE = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\square.png");

    MainFrame(){

        whiteBoard = new WhiteBoard();
        p = new Pen();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(whiteBoard);
        frame.getContentPane().setBackground(new Color(237, 235, 235));
        frame.setLayout(null);
        frame.setSize(1250, 900);

        whiteBoard.setBorder(BorderFactory.createLineBorder(Color.black,5));

        title.setBounds(30,50,400,50);
        title.setFont(new Font("Poppins", Font.BOLD, 35));
        title.setIconTextGap(20);
        title.setIcon(logoImage);

        shapes.setBounds(15,250,150,40);
        shapes.setFont(new Font("Poppins", Font.BOLD, 20));
        shapes.addActionListener(this);

        text.setBounds(550,150,350,35);
        text.setFont(new Font("Poppins", Font.BOLD, 30));
        text.setOpaque(true);
        text.setVisible(true);

        frame.setResizable(false);
        frame.add(shapes);
        frame.add(title);
        frame.add(text);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==shapes) {

            if(shapes.getSelectedItem().equals("Default")){
                text.setText("Using pen on ______");
                whiteBoard.Imagelabel.setIcon(null);
            }

            else if(shapes.getSelectedItem().equals("Circle")){
                circle.drawWith(pen);
                whiteBoard.Imagelabel.setIcon(CIRCLE);

            }
            else if(shapes.getSelectedItem().equals("Square")){
                square.drawWith(pen);
                whiteBoard.Imagelabel.setIcon(SQUARE);
            }
        }
    }
}