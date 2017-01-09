package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Application extends JFrame {
    public static final int WIDTH = 500;
    public static final int TEXT_AREA_HEIGHT = 100;
    public static final int HEIGHT = 400 + TEXT_AREA_HEIGHT;
    public static IndexField1 indexField1 = new IndexField1();
    public static IndexField2 indexField2 = new IndexField2();
    public static OutputTextArea outputTextArea = new OutputTextArea();

    public Application() throws HeadlessException {

        initUI();

    }

    public void initUI() {

        setLayout(null);

        add(new AddConnectionButton());
        add(new AddCalculateButton());
        add(indexField1);
        add(indexField2);
        add(outputTextArea);
        add(new Board());

        setResizable(false);
        setSize(WIDTH, HEIGHT);
//        pack();
        setLocationRelativeTo(null);
        setTitle("Graph");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        repaint();
    }
}
