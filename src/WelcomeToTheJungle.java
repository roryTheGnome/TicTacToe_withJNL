import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeToTheJungle extends JFrame implements ActionListener {
    private JTextField player1Field;
    private JTextField player2Field;
    private JButton startButton;

    public WelcomeToTheJungle() {
        setTitle("Tic Tac Toe - Start");
        setSize(300, 200);
        setLayout(new FlowLayout());

        JLabel player1Label = new JLabel("Enter Player 1 Name: ");
        player1Field = new JTextField(15);

        //drink water
        JLabel player2Label = new JLabel("Enter Player 2 Name: ");
        player2Field = new JTextField(15);

        startButton = new JButton("Start Game");
        startButton.addActionListener(this);

        add(player1Label);
        add(player1Field);
        add(player2Label);
        add(player2Field);
        add(startButton);

        //drink water
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    //drink water
    public void actionPerformed(ActionEvent e) {
        //to be honest i added this because i thought if i'll use this i wont have to add a function
        // with keyboard usage but then re-read the project description and changed my mind
        if (e.getSource() == startButton) {
            String player1Name = player1Field.getText();
            String player2Name = player2Field.getText();

            if (!player1Name.isEmpty() && !player2Name.isEmpty()) {
                new TicTacToe(player1Name, player2Name).resetGame();
                dispose();
            }
            else {
                JOptionPane.showMessageDialog(this, "Enter both player names.");
            }
        }
    }

}
