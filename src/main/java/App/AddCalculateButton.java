package App;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddCalculateButton extends JButton implements MouseListener {

    public AddCalculateButton(){
        super("Calc");
        addMouseListener(this);
        setSize(90, 25);
        setLocation(155, 430);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Integer inputInt1 = (Integer)Application.indexField1.getSelectedItem();
        Integer inputInt2 = (Integer)Application.indexField2.getSelectedItem();

        Graph calculate = new Graph(Array2D.getList().get(inputInt1),Array2D.getList().get(inputInt2));

        Application.outputTextArea.setText(calculate.shortestPathFormatted());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

