import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends JPanel {
    private List<BodyPart> bodyParts;
    private BodyPart selectedPart;
    private int lives = 3;
    private boolean operationFailed;
    private boolean gameWon = false;
    private static final int TOLERANCE = 20; // Tolerance for snapping
    private BufferedImage[] livesImages = new BufferedImage[4];
    private BufferedImage alarmImage;
    private BufferedImage tweezerImage;
    private BufferedImage[] stageImages = new BufferedImage[3];

    public GameBoard() {
        setLayout(null);  // Use null layout for absolute positioning
        bodyParts = new ArrayList<>();
        bodyParts.add(new Brain(600, 100));
        bodyParts.add(new Hand(600, 200));
        bodyParts.add(new Kidney(600, 300, true)); // Left kidney
        bodyParts.add(new Kidney(600, 300, false)); // Right kidney
        try {
            livesImages[0] = ImageIO.read(new File("../Images/0lives.png"));
            livesImages[1] = ImageIO.read(new File("../Images/1live.png"));
            livesImages[2] = ImageIO.read(new File("../Images/2lives.png"));
            livesImages[3] = ImageIO.read(new File("../Images/3lives.png"));
            alarmImage = ImageIO.read(new File("../Images/Alarm.png"));
            tweezerImage = ImageIO.read(new File("../Images/Tweezer.png"));
            stageImages[0] = ImageIO.read(new File("../Images/Stage1.png"));
            stageImages[1] = ImageIO.read(new File("../Images/Stage2.png"));
            stageImages[2] = ImageIO.read(new File("../Images/Stage3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (BodyPart part : bodyParts) {
                    if (part.getShape().contains(e.getPoint())) {
                        selectedPart = part;
                        break;
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (selectedPart != null) {
                    // Check if the part is placed near the correct slot
                    Rectangle2D slot = selectedPart.getSlot();
                    if (isNearSlot(selectedPart.getShape().getBounds2D(), slot)) {
                        // Center the part on the slot
                        double slotCenterX = slot.getCenterX() - selectedPart.getShape().getBounds2D().getWidth() / 2;
                        double slotCenterY = slot.getCenterY() - selectedPart.getShape().getBounds2D().getHeight() / 2;
                        selectedPart.setPosition((int) slotCenterX, (int) slotCenterY);
                        selectedPart.setPlaced(true);
                    } else {
                        lives--;
                        operationFailed = true;
                        if (lives == 0) {
                            JOptionPane.showMessageDialog(null, "Game Over!");
                        } else {
                            JOptionPane.showMessageDialog(null, "You touched the edge! Lives left: " + lives);
                        }
                    }
                    selectedPart = null;
                    repaint();
                    checkWinCondition();
                }
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                if (selectedPart != null) {
                    selectedPart.setPosition(e.getX(), e.getY());
                    repaint();
                }
            }
        });
    }

    private boolean isNearSlot(Rectangle2D partBounds, Rectangle2D slot) {
        double centerX = partBounds.getCenterX();
        double centerY = partBounds.getCenterY();
        double slotCenterX = slot.getCenterX();
        double slotCenterY = slot.getCenterY();
        return Math.abs(centerX - slotCenterX) <= TOLERANCE && Math.abs(centerY - slotCenterY) <= TOLERANCE;
    }

    private void checkWinCondition() {
        boolean allPlaced = true;
        for (BodyPart part : bodyParts) {
            if (!part.isPlaced()) {
                allPlaced = false;
                break;
            }
        }
        if (allPlaced) {
            gameWon = true;
            String message;
            if (lives == 3) {
                message = "Victory! Perfect operation!";
            } else if (lives == 2) {
                message = "Partial Victory! You did well!";
            } else if (lives == 1) {
                message = "Barely a Victory! You made it!";
            } else {
                message = "You placed all organs, but lost all your lives!";
            }
            JOptionPane.showMessageDialog(null, message);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw the stage background
        g2d.drawImage(stageImages[lives], 0, 0, getWidth(), getHeight(), null);

        for (BodyPart part : bodyParts) {
            g2d.setColor(part.getColor());
            // g2d.fill(part.getShape()); // Comment out for using images
            g2d.setColor(Color.BLACK);
            g2d.draw(part.getShape());

            // Draw slots
            g2d.setColor(Color.DARK_GRAY);
            g2d.draw(part.getSlot());

            // Draw images
            // Image img = part.getImage();
            // if (img != null) {
            //     g2d.drawImage(img, (int) part.getShape().getBounds2D().getX(),
            //                         (int) part.getShape().getBounds2D().getY(),
            //                         null);
            // }
        }

        // Draw lives counter
        g2d.drawImage(livesImages[lives], getWidth() - 150, 20, null);

        if (operationFailed) {
            g2d.drawImage(alarmImage, 300, 300, null);
            operationFailed = false;
        }

        // Set custom cursor
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                tweezerImage, new Point(0, 0), "tweezer"));

    }
}