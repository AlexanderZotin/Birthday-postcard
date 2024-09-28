package postcard.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Objects;

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

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if(visible) setLocationRelativeTo(null);
    }

    public void setPicture(Picture picture) {
        Objects.requireNonNull(picture, "Параметр picture не должен быть null!");
        if(this.picture != null) generalPanel.remove(this.picture);
        generalPanel.add("Center", picture);
        this.picture = picture;
    }

    public void removeButton() {
        generalPanel.remove(go);
    }

    public void addButtonToListener(ActionListener listener) {
        go.addActionListener(listener);
    }
}
