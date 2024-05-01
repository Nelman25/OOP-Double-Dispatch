import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {
    Shape circle = new Circle();
    Shape square = new Square();
    Tool pen = new Pen();
    Tool brush = new Brush();

    Circle c = new Circle();
    Square s = new Square();
    Pen p = new Pen();
    Brush b = new Brush();

    static JFrame frame = new JFrame("Simple Whiteboard");
    static String[] shapesOptions = {"Circle","Square"};
    static String[] toolsOptions = {"Pen","Brush"};
    static JComboBox shapes = new JComboBox(shapesOptions);
    static JComboBox tools = new JComboBox(toolsOptions);
    static JLabel text = new JLabel();
    static ImageIcon logoImage = new ImageIcon("C:\\Users\\Jonel Villaver\\Downloads\\appLogo.png");
    static JLabel title = new JLabel("Shape Canvas");

    public static void main(String[] args) {

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

        frame.add(shapes);
        frame.add(tools);
        frame.add(title);
        frame.add(text);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==shapes && e.getSource()==tools) {
            if (shapes.getSelectedItem().equals("Circle") && tools.getSelectedItem().equals("Pen")) {

            }
        }
    }
}
