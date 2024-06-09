import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    public Game() {
        setLayout(new BorderLayout());
        GameBoard gameBoard = new GameBoard();
        add(gameBoard, BorderLayout.CENTER);
    }
}
