import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Operation Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Show welcome screen first
        WelcomeScreen welcomeScreen = new WelcomeScreen(frame);
        frame.add(welcomeScreen);
        frame.setVisible(true);
    }
}
