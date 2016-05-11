import javax.swing.*;
import java.awt.*;

/**
 * Created by Mate on 11/05/16.
 */
public class ImagePanel extends JPanel {
    public ImagePanel() {
        super();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    public void paintOnMe(int x, int y, Image image) {

        super.paintComponent(new Graphics g);
        getGraphics().drawImage(image, x, y, null);

    }
}
