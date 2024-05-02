import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WhiteBoard extends JPanel implements MouseListener, MouseMotionListener, ActionListener {

    static final int UNIT_SIZE = 3;
    static final int WIDTH = 940;
    static final int HEIGHT = 590;

    private Color[][] colors;
    private JButton resetButton;

    WhiteBoard(){
        this.setBounds(240,200,WIDTH,HEIGHT);
        this.setBackground(Color.white);
        this.setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        colors = new Color[HEIGHT / UNIT_SIZE][WIDTH / UNIT_SIZE];
        for(int i = 0; i < colors.length; i++) {
            for(int j = 0; j< colors[i].length;j++) {
                colors[i][j] = Color.WHITE;
            }
        }
        resetButton = new JButton("Clear");
        resetButton.addActionListener(this);
        resetButton.setBounds(10,10,100,30);
        resetButton.setFocusable(false);
        this.add(resetButton);
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
                g.fillRect(j * UNIT_SIZE, i * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // Reset all colors to white
        for(int i = 0; i < colors.length; i++) {
            for(int j = 0; j< colors[i].length;j++) {
                colors[i][j] = Color.WHITE;
            }
        }
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        int row = e.getY() / UNIT_SIZE;
        int col = e.getX() / UNIT_SIZE;

        if (isValid(row, col)){
            colors[row][col] = Color.black;
            repaint();
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        int row = e.getY() / UNIT_SIZE;
        int col = e.getX() / UNIT_SIZE;

        if (isValid(row, col)){
            colors[row][col] = Color.black;
            repaint();
        }
    }
    @Override
    public void mouseMoved(MouseEvent e) {

    }
    private boolean isValid(int row, int col) {
        return row >= 0 && row < colors.length && col >= 0 && col < colors[0].length;

    }
}
