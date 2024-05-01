import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class MainFrame extends JPanel implements MouseListener {
    private ArrayList<Line> lines = new ArrayList<>();
    private Color currentColor = Color.BLACK;
    public MainFrame() {
        setBackground(Color.WHITE);
        addMouseListener(this);

        String shapes[] = {"Circle","Square"};
        String tools[] = {"Pen","Brush"};



        JComboBox comboBox = new JComboBox();
        JPanel drawingArea = new JPanel();

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);
        for (Line line : lines) {
            g.drawLine(line.startX, line.startY, line.endX, line.endY);
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // Not used in this example
    }
    @Override
    public void mousePressed(MouseEvent e) {
        lines.add(new Line(e.getX(), e.getY()));
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        lines.get(lines.size()- 1).setEndXY(e.getX(), e.getY());
        repaint();
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // Not used in this example
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // Not used in this example
    }
    private class Line {
        int startX, startY, endX, endY;
        public Line(int startX, int startY) {
            this.startX = startX;
            this.startY = startY;
        }
        public void setEndXY(int endX, int endY) {
            this.endX = endX;
            this.endY = endY;
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Whiteboard");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MainFrame());
        frame.setSize(500, 500);

        Shape circle = new Circle();
        Shape square = new Square();
        Tool pen = new Pen();
        Tool brush = new Brush();

        frame.setVisible(true);
    }
}