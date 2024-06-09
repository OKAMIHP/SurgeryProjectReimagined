import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Hand extends BodyPart {
    private Rectangle2D slot;

    public Hand(int x, int y) {
        super(new Rectangle2D.Double(x, y, 40, 60), Color.YELLOW);
        slot = new Rectangle2D.Double(100, 250, 40, 60);
    }

    @Override
    public Rectangle2D getSlot() {
        return slot;
    }
}
