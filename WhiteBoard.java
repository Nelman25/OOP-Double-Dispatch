import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class WhiteBoard extends JPanel implements MouseListener {
    private ArrayList<Line> lines = new ArrayList<>();
    private Color currentColor = Color.BLACK;
    public WhiteBoard() {
        setBounds(240,200,940,590);
        setBackground(Color.white);
        addMouseListener(this);
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
    }
    @Override
    public void mouseExited(MouseEvent e) {
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
}