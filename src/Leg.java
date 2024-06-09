import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Leg extends BodyPart {
    private Rectangle2D slot;

    public Leg(int x, int y, boolean left) {
        super(new Rectangle2D.Double(x, y, 40, 100), Color.GREEN);
        if (left) {
            slot = new Rectangle2D.Double(200, 350, 40, 100); // Left leg
        } else {
            slot = new Rectangle2D.Double(360, 350, 40, 100); // Right leg
        }
    }

    @Override
    public Rectangle2D getSlot() {
        return slot;
    }
}