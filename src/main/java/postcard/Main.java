package postcard;

import postcard.controller.Controller;
import postcard.view.Window;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            var view = new Window();
            var controller = new Controller(view);
            view.subscribeToController(controller);
            view.setVisible(true);
        });
    }        
}
