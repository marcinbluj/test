package App;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddConnectionButton extends JButton implements MouseListener {

    public AddConnectionButton(){
        super("Add");
        addMouseListener(this);
        setSize(90, 25);
        setLocation(155, 400);
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

        Array2D.getList().get(inputInt1).addConnections(Array2D.getList().get(inputInt2));
        Application.outputTextArea.setText(inputInt1+" -> "+inputInt2);
        System.out.println(Array2D.getList().get(inputInt1).getConnections());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
