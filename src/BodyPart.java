import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class BodyPart {
    private Shape shape;
    private Color color;
    private boolean placed;
    private BufferedImage image;

    public BodyPart(Shape shape, Color color) {
        this.shape = shape;
        this.color = color;
        this.placed = false;
    }

    public Shape getShape() {
        return shape;
    }

    public Color getColor() {
        return color;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }

    public void setPosition(int x, int y) {
        Rectangle2D bounds = shape.getBounds2D();
        double width = bounds.getWidth();
        double height = bounds.getHeight();
        shape = new Rectangle2D.Double(x, y, width, height);
    }

    public abstract Rectangle2D getSlot();

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}