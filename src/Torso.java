import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Torso extends BodyPart {
    private Rectangle2D slot;

    public Torso(int x, int y) {
        super(new Rectangle2D.Double(x, y, 60, 120), Color.YELLOW);
        slot = new Rectangle2D.Double(270, 175, 60, 120);
    }

    @Override
    public Rectangle2D getSlot() {
        return slot;
    }
}