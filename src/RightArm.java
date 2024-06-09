import java.awt.*;
import java.awt.geom.Rectangle2D;

public class RightArm extends BodyPart {
    private Rectangle2D slot;

    public RightArm(int x, int y) {
        super(new Rectangle2D.Double(x, y, 80, 40), Color.CYAN);
        slot = new Rectangle2D.Double(300, 250, 80, 40);
    }

    @Override
    public Rectangle2D getSlot() {
        return slot;
    }
}
