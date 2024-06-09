import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Heart extends BodyPart {
    private Rectangle2D slot;

    public Heart(int x, int y) {
        super(new Rectangle2D.Double(x, y, 50, 50), Color.PINK);
        slot = new Rectangle2D.Double(275, 200, 50, 50);
    }

    @Override
    public Rectangle2D getSlot() {
        return slot;
    }
}
