package App;


import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Board extends JPanel implements MouseListener {
    private int x, y;

    public Board() {
        addMouseListener(this);
        setBackground(Color.white);
        setLocation(0, 0);
        setSize(500, 400);
        setBorder(new BevelBorder(1));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        new Circle(x, y);
        repaint();
        System.out.println("Size: " + Array2D.getList().size());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawLines(g2d);
        drawOvals(g2d);
        repaint();
    }

    private void drawOvals(Graphics2D g2d) {
        for (Circle circle : Array2D.getList()) {
            g2d.setColor(Color.BLACK);
            g2d.setStroke(new BasicStroke(1));
            g2d.drawOval(circle.getX() - circle.getSize() / 2, circle.getY() - circle.getSize() / 2, circle.getSize(), circle.getSize());
            g2d.drawString(("" + Array2D.getList().indexOf(circle)), circle.getX() - 5, circle.getY() + 5);
        }
    }

    private void drawLines(Graphics2D g2d) {
        for (Circle circle : Array2D.getList()) {
            if (circle.hasConnection()) {
                for (Circle connection : circle.getConnections()) {
                    int x = (circle.getX() + connection.getX()) / 2;
                    int x1 = (x + connection.getX()) / 2;
                    int y = (circle.getY() + connection.getY()) / 2;
                    int y1 = (y + connection.getY()) / 2;
                    g2d.setColor(Color.red);
                    g2d.setStroke(new BasicStroke(3));
                    g2d.drawLine(connection.getX(), connection.getY(), x1, y1);

                    g2d.setColor(Color.BLUE);
                    g2d.setStroke(new BasicStroke(1));
                    g2d.drawLine(circle.getX(), circle.getY(), connection.getX(), connection.getY());
                }
            }
        }
    }
}