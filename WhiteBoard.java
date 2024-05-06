import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WhiteBoard extends JPanel implements MouseListener, MouseMotionListener, ActionListener, ChangeListener{

    static final int UNIT_SIZE = 3;
    static final int WIDTH = 940;
    static final int HEIGHT = 590;

    JSlider pensize;
    JLabel sizelabel, Imagelabel;

    private Color[][] colors;
    private JButton resetButton, red, blue, green, yellow, erase, black;
    private Color designatedColor = Color.black;
    int row;
    int col;
    private int FillArea = 5;

    WhiteBoard(){
        this.setBounds(240,200,WIDTH,HEIGHT);
        this.setBackground(Color.white);
        this.setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        // Colors the gridlines into white
        colors = new Color[HEIGHT / UNIT_SIZE][WIDTH / UNIT_SIZE];
        for(int i = 0; i < colors.length; i++) {
            for(int j = 0; j< colors[i].length;j++) {
                colors[i][j] = Color.WHITE;
            }
        }

        pensize = new JSlider(0,100,5);
        pensize.setBounds(150, 10, 350,40);
        pensize.setPaintTrack(true);
        pensize.setMajorTickSpacing(5);
        pensize.setPaintLabels(true);
        pensize.setFont(new Font("Poppins", Font.PLAIN, 10));
        pensize.setBackground(Color.white);
        pensize.setOpaque(true);
        pensize.addChangeListener(this);
        this.add(pensize);

        sizelabel = new JLabel("Size: "+ pensize.getValue());
        sizelabel.setFont(new Font("Poppins", Font.ITALIC, 20));
        sizelabel.setBounds(520, 10, 100, 20);
        this.add(sizelabel);

        Imagelabel = new JLabel();
        Imagelabel.setBounds(200, 50,500, 500);
        this.add(Imagelabel);

        resetButton = new JButton("Clear");
        resetButton.addActionListener(this);
        resetButton.setBounds(10,10,100,30);
        resetButton.setFocusable(false);
        this.add(resetButton);

        red = new JButton();
        red.addActionListener(this);
        red.setBounds(700, 10, 15, 15);
        red.setBackground(Color.red);
        this.add(red);

        blue = new JButton();
        blue.addActionListener(this);
        blue.setBounds(720, 10, 15, 15);
        blue.setBackground(Color.blue);
        this.add(blue);

        green = new JButton();
        green.addActionListener(this);
        green.setBounds(740, 10, 15, 15);
        green.setBackground(Color.green);
        this.add(green);

        yellow = new JButton();
        yellow.addActionListener(this);
        yellow.setBounds(760, 10, 15, 15);
        yellow.setBackground(Color.yellow);
        this.add(yellow);

        erase = new JButton();
        erase.addActionListener(this);
        erase.setBounds(780, 10, 15, 15);
        erase.setBackground(Color.white);
        this.add(erase);

        black = new JButton();
        black.addActionListener(this);
        black.setBounds(800, 10, 15, 15);
        black.setBackground(Color.black);
        this.add(black);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        //GridLines
        for(int i = 0; i<HEIGHT/UNIT_SIZE; i++ ) {
            g.setColor(Color.LIGHT_GRAY);
            g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, HEIGHT);
            g.drawLine(0, i*UNIT_SIZE, WIDTH, i*UNIT_SIZE);
        }
        for (int i = 0; i < colors.length; i++) {
            for (int j = 0; j < colors[i].length; j++) {
                g.setColor(colors[i][j]);
                g.fillRect(j * UNIT_SIZE, i * UNIT_SIZE, UNIT_SIZE*2, UNIT_SIZE*2);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Reset all colors to white
        if(e.getSource() == resetButton)
            for(int i = 0; i < colors.length; i++) {
                for(int j = 0; j< colors[i].length;j++) {
                    colors[i][j] = Color.WHITE;
                }
            }
        if(e.getSource() == red) {
            designatedColor = Color.red;
        }
        if(e.getSource() == blue) {
            designatedColor = Color.blue;
        }
        if(e.getSource() == green) {
            designatedColor = Color.green;
        }
        if(e.getSource() == yellow) {
            designatedColor = Color.yellow;
        }
        if(e.getSource() == erase) {
            designatedColor = Color.white;
        }
        if(e.getSource() == black) {
            designatedColor = Color.black;
        }
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mousePressed(MouseEvent e) {
        fillArea(e.getY(),e.getX());
        repaint();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
    @Override
    public void mouseDragged(MouseEvent e) {
        fillArea(e.getY(),e.getX());
        repaint();
    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
    private void fillArea(int x, int y) {
        row = x / UNIT_SIZE;
        col = y / UNIT_SIZE;

        for(int i = row - FillArea; i< row + FillArea; i++) {
            for(int j = col - FillArea; j< col + FillArea; j++) {
                if(isValid(i,j)) {
                    colors[i][j] = designatedColor;
                }
            }
        }
    }
    private boolean isValid(int row, int col) {
        return row >= 0 && row < colors.length && col >= 0 && col < colors[0].length;

    }
    @Override
    public void stateChanged(ChangeEvent e) {
        sizelabel.setText("Size: "+ pensize.getValue());

        FillArea = pensize.getValue();
    }
}