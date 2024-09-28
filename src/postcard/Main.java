package postcard;

import postcard.controller.Controller;
import postcard.view.Window;
import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        Window window = new Window();
        Controller controller = new Controller(window);
        controller.bindViewToListener();
        SwingUtilities.invokeLater(() -> window.setVisible(true));
    }
}
