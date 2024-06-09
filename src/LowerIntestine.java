import java.awt.*;
import java.awt.geom.Rectangle2D;

public class LowerIntestine extends BodyPart {
    private Rectangle2D slot;

    public LowerIntestine(int x, int y) {
        super(new Rectangle2D.Double(x, y, 40, 100), Color.ORANGE);
        slot = new Rectangle2D.Double(320, 400, 40, 100);
    }

    @Override
    public Rectangle2D getSlot() {
        return slot;
    }
}
