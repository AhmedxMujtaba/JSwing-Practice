package TicCross;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class TicCross implements ActionListener {

      JFrame frame = new JFrame ("Tic Cross");

        private int scorePlayerOne = 0;
        private int scorePlayerTwo = 0;
        private int playerTurn = 2;
        private boolean gameOver;
        private int currentArraySymbol;
        private int[][] intArray = new int[3][3];
        private JFormattedTextField playerOne;
        private JFormattedTextField playerTwo;
        private JLabel scoreOne;
        private JLabel scoreTwo;
        private JButton symbolOne;
        private JButton symbolTwo;
        String currentSymbol;
        private JButton zeroZero;
        private JButton zeroOne;
        private JButton zeroTwo;
        private JButton oneZero;
        private JButton oneOne;
        private JButton oneTwo;
        private JButton twoZero;
        private JButton twoOne;
        private JButton twoTwo;
        private JLabel heading;
        private JButton newGame;
        private JLabel displayWinner;

    public TicCross() {
        initializeScreen();
        addComponents();
        addActionEvent();
    }

        public void initializeScreen(){
            frame.setSize (new Dimension (480, 450));
            frame.getContentPane().setBackground(Color.white);
            frame.setLocationRelativeTo(null);
            frame.setLayout (null);
            frame.setVisible (true);
            frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        }
        public void addComponents(){

            playerOne = new JFormattedTextField ("Player1");
            playerTwo = new JFormattedTextField ("Player2");
            scoreOne = new JLabel (String.valueOf(scorePlayerOne));
            scoreTwo = new JLabel (String.valueOf(scorePlayerTwo));
            symbolOne = new JButton ("X");
            symbolTwo = new JButton ("O");
            zeroZero = new JButton ("");
            zeroOne = new JButton ("");
            zeroTwo = new JButton ("");
            oneZero = new JButton ("");
            oneOne = new JButton ("");
            oneTwo = new JButton ("");
            twoZero = new JButton ("");
            twoOne = new JButton ("");
            twoTwo = new JButton ("");
            heading = new JLabel ("Tic-Cross");
            newGame = new JButton("New Game");
            displayWinner = new JLabel("winner");

            //add components
            frame.add (playerOne);
            frame.add (playerTwo);
            frame.add (scoreOne);
            frame.add (scoreTwo);
            frame.add (symbolOne);
            frame.add (symbolTwo);
            frame.add (zeroZero);
            frame.add (zeroOne);
            frame.add (zeroTwo);
            frame.add (oneZero);
            frame.add (oneOne);
            frame.add (oneTwo);
            frame.add (twoZero);
            frame.add (twoOne);
            frame.add (twoTwo);
            frame.add (heading);
            frame.add (newGame);
            frame.add (displayWinner);

            Component[] components = frame.getComponents();
            for (Component component : components) {
                component.setVisible(true);
            }

            //set newGame button visible false since it will be only visible if the game ends
            newGame.setVisible(false);
            displayWinner.setVisible(false);

            //set component bounds (only needed by Absolute Positioning)
            playerOne.setBounds (60, 30, 100, 40);
            playerTwo.setBounds (320, 30, 100, 40);
            scoreOne.setBounds (190, 85, 35, 25);
            scoreTwo.setBounds (265, 85, 35, 25);
            symbolOne.setBounds (85, 80, 45, 40);
            symbolTwo.setBounds (345, 80, 45, 40);
            zeroZero.setBounds (150, 180, 60, 60);
            zeroOne.setBounds (210, 180, 60, 60);
            zeroTwo.setBounds (270, 180, 60, 60);
            oneZero.setBounds (150, 240, 60, 60);
            oneOne.setBounds (210, 240, 60, 60);
            oneTwo.setBounds (270, 240, 60, 60);
            twoZero.setBounds (150, 300, 60, 60);
            twoOne.setBounds (210, 300, 60, 60);
            twoTwo.setBounds (270, 300, 60, 60);
            heading.setBounds (210, 10, 100, 25);
            newGame.setBounds (195, 370, 100, 25);
            displayWinner.setBounds (200, 140, 100, 25);

            //make the boxes white
            zeroZero.setBackground(Color.white);
            zeroZero.setFont(new Font("Arial",Font.BOLD,30));
            zeroZero.setFocusable(false);
            zeroZero.setBorder(new LineBorder(Color.BLACK,2));

            zeroOne.setBackground(Color.white);
            zeroOne.setFont(new Font("Arial",Font.BOLD,30));
            zeroOne.setFocusable(false);
            zeroOne.setBorder(new LineBorder(Color.BLACK,2));

            zeroTwo.setBackground(Color.white);
            zeroTwo.setFont(new Font("Arial",Font.BOLD,30));
            zeroTwo.setFocusable(false);
            zeroTwo.setBorder(new LineBorder(Color.BLACK,2));

            oneZero.setBackground(Color.white);
            oneZero.setFont(new Font("Arial",Font.BOLD,30));
            oneZero.setFocusable(false);
            oneZero.setBorder(new LineBorder(Color.BLACK,2));

            oneOne.setBackground(Color.white);
            oneOne.setFont(new Font("Arial",Font.BOLD,30));
            oneOne.setFocusable(false);
            oneOne.setBorder(new LineBorder(Color.BLACK,2));

            oneTwo.setBackground(Color.white);
            oneTwo.setFont(new Font("Arial",Font.BOLD,30));
            oneTwo.setFocusable(false);
            oneTwo.setBorder(new LineBorder(Color.BLACK,2));

            twoZero.setBackground(Color.white);
            twoZero.setFont(new Font("Arial",Font.BOLD,30));
            twoZero.setFocusable(false);
            twoZero.setBorder(new LineBorder(Color.BLACK,2));

            twoOne.setBackground(Color.white);
            twoOne.setFont(new Font("Arial",Font.BOLD,30));
            twoOne.setFocusable(false);
            twoOne.setBorder(new LineBorder(Color.BLACK,2));

            twoTwo.setBackground(Color.white);
            twoTwo.setFont(new Font("Arial",Font.BOLD,30));
            twoTwo.setFocusable(false);
            twoTwo.setBorder(new LineBorder(Color.BLACK,2));

            //add text field for player names
            playerOne.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Clear the text field when it gains focus
                    if (playerOne.getText().equals("Player1")) {
                        playerOne.setText("");
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    // Restore the default text if the text field is empty
                    if (playerOne.getText().isEmpty()) {
                        playerOne.setText("Player1");
                    }
                }
            });
            playerTwo.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Clear the text field when it gains focus
                    if (playerTwo.getText().equals("Player2")) {
                        playerTwo.setText("");
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    // Restore the default text if the text field is empty
                    if (playerTwo.getText().isEmpty()) {
                        playerTwo.setText("Player2");
                    }
                }
            });

            //increase score size
            scoreOne.setFont(new Font("Arial", Font.BOLD, 25));
            scoreTwo.setFont(new Font("Arial", Font.BOLD, 25));

            displayWinner.setFont(new Font("Arial", Font.BOLD, 10));


        }


        public static void main (String[] args) {
            new TicCross();
        }
        public void addActionEvent(){
            symbolOne.addActionListener(this);
            symbolTwo.addActionListener(this);
            zeroZero.addActionListener(this);
            zeroOne.addActionListener(this);
            zeroTwo.addActionListener(this);
            oneZero.addActionListener(this);
            oneOne.addActionListener(this);
            oneTwo.addActionListener(this);
            twoZero.addActionListener(this);
            twoOne.addActionListener(this);
            twoTwo.addActionListener(this);
            newGame.addActionListener(this);
        }

    public void getIntArray() {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                System.out.print(intArray[i][j]);
            }
        }
        System.out.println("\n");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        //set player symbol
        if (playerTurn % 2 == 0){
            currentSymbol = symbolOne.getText();
            currentArraySymbol = 1;
        }
        else{
            currentSymbol = symbolTwo.getText();
            currentArraySymbol = 2;

        }

        if (source == newGame){
            intArray = new int[3][3];
            playerTurn = 2;
            clearButtons();
            gameOver = false;
            newGame.setVisible(false);
            displayWinner.setVisible(false);
            displayWinner.setBounds (200, 140, 100, 25);
            displayWinner.setFont(new Font("Arial", Font.BOLD, 10));

        }
        else if (source == zeroZero) {
            zeroZero.setText(currentSymbol);
            zeroZero.setEnabled(false);
            intArray[0][0] = currentArraySymbol;
            playerTurn++;
            checkWinner();
        }
        else if (source == zeroOne) {
            zeroOne.setText(currentSymbol);
            zeroOne.setEnabled(false);
            intArray[0][1] = currentArraySymbol;
            playerTurn++;
            checkWinner();
        }
        else if (source == zeroTwo) {
            zeroTwo.setText(currentSymbol);
            zeroTwo.setEnabled(false);
            intArray[0][2] = currentArraySymbol;
            playerTurn++;
            checkWinner();
        }
        else if (source == oneZero) {
            oneZero.setText(currentSymbol);
            oneZero.setEnabled(false);
            intArray[1][0] = currentArraySymbol;
            playerTurn++;
            checkWinner();
        }
        else if (source == oneOne) {
            oneOne.setText(currentSymbol);
            oneOne.setEnabled(false);
            intArray[1][1] = currentArraySymbol;
            playerTurn++;
            checkWinner();
        }
        else if (source == oneTwo) {
            oneTwo.setText(currentSymbol);
            oneTwo.setEnabled(false);
            intArray[1][2] = currentArraySymbol;
            playerTurn++;
            checkWinner();
        }
        else if (source == twoZero) {
            twoZero.setText(currentSymbol);
            twoZero.setEnabled(false);
            intArray[2][0] = currentArraySymbol;
            playerTurn++;
            checkWinner();
        }
        else if (source == twoOne) {
            twoOne.setText(currentSymbol);
            twoOne.setEnabled(false);
            intArray[2][1] = currentArraySymbol;
            playerTurn++;
            checkWinner();
        }
        else if (source == twoTwo) {
            twoTwo.setText(currentSymbol);
            twoTwo.setEnabled(false);
            intArray[2][2] = currentArraySymbol;
            playerTurn++;
            checkWinner();
        }
        getIntArray();
        checkDraw();
    }
    public void checkWinner(){
        if (intArray[0][0] == 1 && intArray[1][0] == 1 && intArray[2][0] == 1 )
        {
            playerOneWins();
        }
        else if (intArray[0][0] == 2 && intArray[1][0] == 2 && intArray[2][0] == 2) {
            playerTwoWins();
        }

        if (intArray[0][1] == 1 && intArray[1][1] == 1 && intArray[2][1] == 1 )
        {
            playerOneWins();
        }
        else if (intArray[0][1] == 2 && intArray[1][1] == 2 && intArray[2][1] == 2) {
            playerTwoWins();
        }

        if (intArray[0][2] == 1 && intArray[1][2] == 1 && intArray[2][2] == 1 )
        {
            playerOneWins();
        }
        else if (intArray[0][2] == 2 && intArray[1][2] == 2 && intArray[2][2] == 2) {
            playerTwoWins();
        }
        //............................................................................

        if (intArray[0][0] == 1 && intArray[0][1] == 1 && intArray[0][2] == 1 )
        {
            playerOneWins();
        }
        else if (intArray[0][0] == 2 && intArray[0][1] == 2 && intArray[0][2] == 2) {
            playerTwoWins();
        }

        if (intArray[1][0] == 1 && intArray[1][1] == 1 && intArray[1][2] == 1 )
        {
            playerOneWins();
        }
        else if (intArray[1][0] == 2 && intArray[1][1] == 2 && intArray[1][2] == 2) {
            playerTwoWins();
        }

        if (intArray[2][0] == 1 && intArray[2][1] == 1 && intArray[2][2] == 1 )
        {
            playerOneWins();
        }
        else if (intArray[2][0] == 2 && intArray[2][1] == 2 && intArray[2][2] == 2) {
            playerTwoWins();
        }
        //............................................................................
        if (intArray[0][0] == 1 && intArray[1][1] == 1 && intArray[2][2] == 1 )
        {
            playerOneWins();
        }
        else if (intArray[0][0] == 2 && intArray[1][1] == 2 && intArray[2][2] == 2) {
            playerTwoWins();
        }

        if (intArray[2][0] == 1 && intArray[1][1] == 1 && intArray[0][2] == 1 )
        {
            playerOneWins();
        }
        else if (intArray[2][0] == 2 && intArray[1][1] == 2 && intArray[0][2] == 2) {
            playerTwoWins();
        }
    }

    private void playerOneWins() {
        displayWinner.setText(playerOne.getText() + " Wins!");
        displayWinner.setVisible(true);
        scorePlayerOne++;
        scoreOne.setText(String.valueOf(scorePlayerOne));
        disableButtons();
        newGame.setVisible(true);
        gameOver = true;
    }
    private void playerTwoWins() {
        displayWinner.setText(playerTwo.getText() + " Wins!");
        displayWinner.setVisible(true);
        scorePlayerTwo++;
        scoreTwo.setText(String.valueOf(scorePlayerTwo));
        disableButtons();
        newGame.setVisible(true);
        gameOver = true;
    }
    private void checkDraw(){
        boolean isFull = true;
        for (int i = 0; i < intArray.length; i++) {
            for (int j = 0; j < intArray.length; j++) {
                if (intArray[i][j] == 0){
                    isFull = false;
                }
            }
        }
        if (!gameOver && isFull)
        {
            draw();
        }
    }
    private void draw() {
        displayWinner.setFont(new Font("Arial", Font.BOLD, 15));
        displayWinner.setBounds (220, 140, 100, 25);
        displayWinner.setText("Draw");
        displayWinner.setVisible(true);
        disableButtons();
        newGame.setVisible(true);
    }

    private void disableButtons() {
        zeroZero.setEnabled(false);
        zeroOne.setEnabled(false);
        zeroTwo.setEnabled(false);
        oneZero.setEnabled(false);
        oneOne.setEnabled(false);
        oneTwo.setEnabled(false);
        twoZero.setEnabled(false);
        twoOne.setEnabled(false);
        twoTwo.setEnabled(false);
    }

    private void clearButtons(){
            zeroZero.setEnabled(true);
            zeroZero.setText("");
            zeroOne.setEnabled(true);
            zeroOne.setText("");
            zeroTwo.setEnabled(true);
            zeroTwo.setText("");
            oneZero.setEnabled(true);
            oneZero.setText("");
            oneOne.setEnabled(true);
            oneOne.setText("");
            oneTwo.setEnabled(true);
            oneTwo.setText("");
            twoZero.setEnabled(true);
            twoZero.setText("");
            twoOne.setEnabled(true);
            twoOne.setText("");
            twoTwo.setEnabled(true);
            twoTwo.setText("");
    }
}
