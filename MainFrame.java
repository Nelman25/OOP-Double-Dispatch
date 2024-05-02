import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame implements ActionListener {
    Shape circle = new Circle();
    Shape square = new Square();
    Tool pen = new Pen();

    Circle c = new Circle();
    Square s = new Square();
    Brush b = new Brush();
    static Pen p;

     JFrame frame = new JFrame("Simple Whiteboard");
     String[] shapesOptions = {"Circle","Square"};
     String[] toolsOptions = {"Pen","Brush"};
     JComboBox shapes = new JComboBox(shapesOptions);
     static JLabel text = new JLabel("Using pen on ______");
     ImageIcon logoImage = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\appLogo.png");
     JLabel title = new JLabel("Shape Canvas");

    MainFrame(){

        WhiteBoard whiteBoard = new WhiteBoard();
        p = new Pen();

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
        shapes.addActionListener(this);

        text.setBounds(550,150,350,35);
        text.setFont(new Font("Poppins", Font.BOLD, 30));
        text.setOpaque(true);
        text.setVisible(true);

        frame.add(shapes);
        frame.add(title);
        frame.add(text);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==shapes) {
            if(shapes.getSelectedItem().equals("Circle")){
                circle.drawWith(pen);
            }
            else if(shapes.getSelectedItem().equals("Square")){
                square.drawWith(pen);
            }
        }
    }
}