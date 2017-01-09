package App;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class IndexField1 extends JComboBox implements MouseListener {
    public IndexField1() {
        addMouseListener(this);
        setBackground(Color.lightGray);
        setLocation(0, 400);
        setSize(150, 25);
        setBorder(new BevelBorder(1));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        addList();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void addList() {
        removeAllItems();
        for (int i = 0; i < Array2D.getList().size(); i++) {
            addItem(i);
            repaint();
        }
    }
}
