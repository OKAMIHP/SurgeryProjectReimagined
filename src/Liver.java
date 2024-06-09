import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Liver extends BodyPart {
    private Rectangle2D slot;

    public Liver(int x, int y) {
        super(new Rectangle2D.Double(x, y, 80, 40), Color.ORANGE);
        slot = new Rectangle2D.Double(270, 300, 80, 40);
    }

    @Override
    public Rectangle2D getSlot() {
        return slot;
    }
}

