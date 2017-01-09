package App;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class OutputTextArea extends JTextArea {
    public OutputTextArea(){
        setBackground(Color.lightGray);
        setLocation(250, 400);
        setSize(250, 100);
        setBorder(new BevelBorder(2));
        setEditable(false);
        repaint();
    }
}