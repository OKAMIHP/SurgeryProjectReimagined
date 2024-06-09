import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Kidney extends BodyPart {
    private Rectangle2D slot;

    public Kidney(int x, int y, boolean left) {
        super(new Rectangle2D.Double(x, y, 40, 60), Color.GREEN);
        if (left) {
            slot = new Rectangle2D.Double(200, 250, 40, 60); // Left kidney
        } else {
            slot = new Rectangle2D.Double(360, 250, 40, 60); // Right kidney
        }
    }

    @Override
    public Rectangle2D getSlot() {
        return slot;
    }
}
