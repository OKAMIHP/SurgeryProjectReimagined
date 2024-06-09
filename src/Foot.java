import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Foot extends BodyPart {
    private Rectangle2D slot;

    public Foot(int x, int y) {
        super(new Rectangle2D.Double(x, y, 60, 30), Color.BLUE);
        slot = new Rectangle2D.Double(200, 500, 60, 30);
    }

    @Override
    public Rectangle2D getSlot() {
        return slot;
    }
}
