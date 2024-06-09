import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Arm extends BodyPart {
    private Rectangle2D slot;

    public Arm(int x, int y, boolean left) {
        super(new Rectangle2D.Double(x, y, 30, 80), Color.BLUE);
        if (left) {
            slot = new Rectangle2D.Double(150, 200, 30, 80); // Left arm
        } else {
            slot = new Rectangle2D.Double(420, 200, 30, 80); // Right arm
        }
    }

    @Override
    public Rectangle2D getSlot() {
        return slot;
    }
}