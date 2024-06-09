import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Brain extends BodyPart {
    private Rectangle2D slot;

    public Brain(int x, int y) {
        super(new Rectangle2D.Double(x, y, 50, 50), Color.RED);
        slot = new Rectangle2D.Double(275, 75, 50, 50);
    }

    @Override
    public Rectangle2D getSlot() {
        return slot;
    }
}