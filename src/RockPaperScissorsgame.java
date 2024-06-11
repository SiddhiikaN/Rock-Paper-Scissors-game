import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class RockPaperScissorsgame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JButton rockButton, paperButton, scissorsButton;
    private JLabel playerLabel, computerLabel, resultLabel;
    private Random random;

    public RockPaperScissorsgame() {
        setTitle("Rock Paper Scissors");
        setSize(400, 250); // Increased frame size
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false); // Prevent resizing

        // Define pastel colors
        Color pastelBlue = new Color(153, 204, 255); // Light blue
        Color pastelGreen = new Color(153, 255, 204); // Mint green
        Color pastelPink = new Color(255, 153, 204); // Pink
        Color pastelYellow = new Color(255, 255, 153); // Light yellow
        Color pastelOrange = new Color(255, 204, 153); // Peach

        // Set background color
        getContentPane().setBackground(pastelYellow);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        // Set button colors
        rockButton.setBackground(pastelBlue);
        paperButton.setBackground(pastelGreen);
        scissorsButton.setBackground(pastelPink);

        // Make buttons smaller
        Dimension buttonSize = new Dimension(100, 50); // Increased button size
        rockButton.setPreferredSize(buttonSize);
        paperButton.setPreferredSize(buttonSize);
        scissorsButton.setPreferredSize(buttonSize);

        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);

        buttonPanel.add(rockButton);
        buttonPanel.add(paperButton);
        buttonPanel.add(scissorsButton);

        add(buttonPanel, BorderLayout.CENTER);

        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        playerLabel = new JLabel("Player: ");
        computerLabel = new JLabel("Computer: ");
        resultLabel = new JLabel("");
        infoPanel.add(playerLabel);
        infoPanel.add(computerLabel);
        infoPanel.add(resultLabel);
        add(infoPanel, BorderLayout.SOUTH);

        random = new Random();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] rps = {"r", "p", "s"};
        String computerMove = rps[random.nextInt(rps.length)];
        String playerMove = "";
        if (e.getSource() == rockButton) {
            playerMove = "r";
        } else if (e.getSource() == paperButton) {
            playerMove = "p";
        } else if (e.getSource() == scissorsButton) {
            playerMove = "s";
        }

        playerLabel.setText("Player: " + translateMove(playerMove));
        computerLabel.setText("Computer: " + translateMove(computerMove));

        if (playerMove.equals(computerMove)) {
            resultLabel.setText("😐 It's a tie!");
            resultLabel.setForeground(Color.BLACK);
        } else if ((playerMove.equals("r") && computerMove.equals("s")) ||
                   (playerMove.equals("s") && computerMove.equals("p")) ||
                   (playerMove.equals("p") && computerMove.equals("r"))) {
            resultLabel.setText("😃 You win!");
            resultLabel.setForeground(Color.BLUE);
        } else {
            resultLabel.setText("😔 You lose!");
            resultLabel.setForeground(Color.RED);
        }
    }

    private String translateMove(String move) {
        switch (move) {
            case "r":
                return "Rock";
            case "p":
                return "Paper";
            case "s":
                return "Scissors";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        new RockPaperScissorsgame();
    }
}
