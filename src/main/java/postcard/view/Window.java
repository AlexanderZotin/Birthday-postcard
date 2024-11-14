package postcard.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import lombok.NonNull;
import postcard.controller.Controller;

public class Window extends JFrame {
    private final JPanel generalPanel = new JPanel(new BorderLayout());
    private Picture picture;
    private final JButton go = new JButton("Нажмите кнопку...");

    public Window() {
        generalPanel.add("South", go);
        setContentPane(generalPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setPreferredSize(new Dimension(600, 700));
        pack();
    }

    public void setPicture(@NonNull Picture picture) {
        if(this.picture != null) generalPanel.remove(this.picture);
        generalPanel.add("Center", picture);
        this.picture = picture;
    }

    public void subscribeToController(@NonNull Controller controller) {
        go.addActionListener(controller);
    }
    
    public void removeButton() {
        generalPanel.remove(go);
    }
    
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if(visible) setLocationRelativeTo(null);
    }
}
