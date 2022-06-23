package view;

import java.awt.FlowLayout;

import javax.swing.JPanel;

public class Piatto extends JPanel {
    public Piatto() {
        FlowLayout flowLayout = new FlowLayout();
        setLayout(flowLayout);
        flowLayout.setVgap(150);
        flowLayout.setHgap(20);
    }

}
