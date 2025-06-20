import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;

public class TicTacToe extends JFrame implements ActionListener {

    public JButton[][] buttons = new JButton[4][4];

    public char currentPlayer;
    public String player1Name;
    public String player2Name;

    private int row = 0;
    private int colm = 0;


    public native boolean checkForWin(int x, int y, char player);
    public native boolean isDraw();
    public native void resetGame();

    public TicTacToe(String player1Name, String player2Name) {

        this.player1Name = player1Name;
        this.player2Name = player2Name;
        currentPlayer = 'X';

        setTitle("Tic Tak Toe"); //keep the joke
        setSize(500, 500);
        setLayout(new GridLayout(4, 4));

        //im not sure if we were spouesd to but adding buttons instead of drawing grids
        // was easier so i just add 4 buttons in each row 4 times
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 50));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);

                add(buttons[i][j]);
            }
        }

        buttons[row][colm].setBackground(Color.cyan);

        setupKeyBindings();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    } //drink water


    private void setupKeyBindings() {

        bindKey("UP", KeyStroke.getKeyStroke("UP"), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCursor(-1, 0);
            }
        });

        bindKey("DOWN", KeyStroke.getKeyStroke("DOWN"), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCursor(1, 0);
            }
        });

        bindKey("LEFT", KeyStroke.getKeyStroke("LEFT"), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCursor(0, -1);
            }
        });

        bindKey("RIGHT", KeyStroke.getKeyStroke("RIGHT"), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCursor(0, 1);
            }
        });

        bindKey("ENTER", KeyStroke.getKeyStroke("ENTER"), new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[row][colm].doClick();
            }
        });  //drimk water
    }


    private void bindKey(String name, KeyStroke keyStroke, Action action) {
        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, name);
        getRootPane().getActionMap().put(name, action);
    }

    private void moveCursor(int rowChange, int colChange) {
        buttons[row][colm].setBackground(null);

        row = (row + rowChange + 4) % 4;// %4 is for the player not going out of the board
        colm = (colm + colChange + 4) % 4;

        buttons[row][colm].setBackground(Color.cyan);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (!clickedButton.getText().equals("")) {
            return;
        }//upsi dupsi this place is not open to availblity

        clickedButton.setText(String.valueOf(currentPlayer));
        int x = -1, y = -1;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (buttons[i][j] == clickedButton) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        if (checkForWin(x, y, currentPlayer)) {
            JOptionPane.showMessageDialog(this, currentPlayer == 'X' ? player1Name + " wins!" : player2Name + " wins!");
            dispose();
            new WelcomeToTheJungle();
        } else if (isDraw()) {
            JOptionPane.showMessageDialog(this, "It's a draw!");
            dispose();
            new WelcomeToTheJungle();
        } else {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    }

