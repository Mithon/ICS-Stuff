/**
 * A tic-tac-toe game on the 3x3 board
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TicTacToe_HC extends JFrame implements ActionListener
{

	private static final int BOARD_SIZE = 3;
	private String[][] board;

	private JButton squares[][];  
	private int turnCounter;
	private JButton newGameButton;
	private JLabel score;
	private int emptySquaresLeft;
	private String whoseTurn;
	private JCheckBox compMode;
	private Boolean comp = false;


	/** 
	 * Construct a TicTacToe game with a nice user interface
	 */ 
	public TicTacToe_HC()
	{       
		setUpInterface();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		board = new String[BOARD_SIZE][BOARD_SIZE];
		initializeBoard();
	}

	/*
	 * Helper method to set up the user interface
	 */
	private void setUpInterface()
	{
		// A large font for the buttons
		Font font = new Font(null, Font.BOLD, 32);

		setTitle("TicTacToe");
		setSize(400,400);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Get the content pane - 
		// all window components go there
		Container  contentPane = getContentPane();

		//Set the layout manager and background color
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.LIGHT_GRAY);

		// Create the button New Game and register it 
		// with the action listener 
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(this);

		JPanel topPanel = new JPanel();
		topPanel.add(newGameButton);

		compMode = new JCheckBox("computer");
		compMode.setSelected(false);
		topPanel.add(compMode);

		compMode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (((JCheckBox)compMode).isSelected()) {
					setCompMode();
					comp = true;
				}
				else
					comp = false;
			}
		});


		contentPane.add(topPanel,"North");

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(BOARD_SIZE,BOARD_SIZE));
		contentPane.add(centerPanel,"Center");

		score = new JLabel("X's turn", JLabel.CENTER);
		contentPane.add(score,"South");

		// create an array to hold references to 9 buttons
		squares = new JButton[BOARD_SIZE][BOARD_SIZE];   

		// Instantiate the buttons, store the references 
		// to them in the 2d array called squares,
		// register them with the listener, and add to panel 
		for (int i=0; i < BOARD_SIZE; i++)
		{
			for (int j=0; j < BOARD_SIZE; j++)
			{
				squares[i][j] = new JButton();
				squares[i][j].addActionListener(this);
				squares[i][j].setFont(font);
				centerPanel.add(squares[i][j]);
			}
		}
	}

	/*
	 * Helper method to initialize the board for a new game
	 */
	private void initializeBoard()
	{       
		for (int i=0; i < BOARD_SIZE; i++)
		{
			for (int j=0; j < BOARD_SIZE; j++)
			{
				board[i][j] = "";
				squares[i][j].setBackground(Color.CYAN);
				squares[i][j].setEnabled(true);
				squares[i][j].setText("");
			}
		}    
		emptySquaresLeft = BOARD_SIZE*BOARD_SIZE;
		whoseTurn = "X";
		score.setText(whoseTurn + "'s turn");
		if (((JCheckBox)compMode).isSelected())
			setCompMode();
		//newGameButton.setEnabled(false);
		turnCounter = 0;
	}

	/**
	 * This method will process all action events
	 * @param ActionEvent object
	 */
	public void actionPerformed(ActionEvent e)
	{

		JButton theButton = (JButton) e.getSource();
		// Is this a New Game button?
		if (theButton == newGameButton)
		{
			initializeBoard();
			return;  // exit the method here
		}


		// Which square was clicked?
		for (int i=0; i < BOARD_SIZE; i++ )
		{
			for (int j=0; j < BOARD_SIZE; j++)
			{               
				if (theButton == squares[i][j])
				{                    
					squares[i][j].setText(whoseTurn);
					turnCounter++;
					squares[i][j].setEnabled(false);
					emptySquaresLeft--;
					toggleTurn();

					board[i][j] = whoseTurn;
					lookForWinner();  

					return;
				}
			}
		}   
	}

	/*
	 * Helper method to switch to the other player
	 */
	private void toggleTurn()
	{
		if (whoseTurn.equals("X"))
		{
			whoseTurn = "O";
		}
		else
		{
			whoseTurn = "X";
		}
		if (((JCheckBox)compMode).isSelected()) {
			if (whoseTurn == "X")
				score.setText("Your turn");
			else
				score.setText("Computer's turn");
		}
		else
			score.setText(whoseTurn + "'s turn");
		if (comp == true)
			compTurn();
	}

	/*
	 *  Helper method called after every move to see 
	 *  if we have a winner. 
	 *  It checks every row, column and diagonal to find 
	 *  squares with the same label (other than blank)
	 *  @return "X", "O", or "" (for no winner)     
	 */
	private void lookForWinner()
	{
		String winner = "";
		String[][] current = new String[3][3];
		for (int i = 0; i < 3; i++)        {
			for (int x = 0; x < 3; x++)        {
				current[i][x]= squares[i][x].getText();
			}
		}
		for (int z = 0; z < 3; z++)        {
			int horizontal = 0, vertical = 0, diag1 = 0, diag2 = 0;
			for (int i = 0; i < 3; i++)        {
				if (current[z][i].equals(current[z][0]) && !(current[z][0].equals("")))
					horizontal++;
				if (current[i][z].equals(current[0][z]) && !(current[0][z].equals("")))
					vertical++;
				if (current[i][i].equals(current[0][z]) && !(current[0][z].equals("")))
					diag1++;
				if (current[i][2-i].equals(current[2][z]) && !(current[2][z].equals("")))
					diag2++;
				if (diag2 == 3 || horizontal == 3 || vertical == 3 || diag1 == 3)
					winner = whoseTurn;
			}
		}


		if (winner.equals(""))
		{
			if (emptySquaresLeft == 0)
			{
				endTheGame();
				score.setText("It's a tie!");
			}
		}
		else
		{
			endTheGame();
			if (comp == true) {
				if (winner == "X")
					score.setText("You won!");
				else
					score.setText("The computer won!");
			}
			else
				score.setText(winner + " won!");
		}
	}

	/*
	 * Helper method to disable squares and enable New Game button
	 */
	private void endTheGame()
	{
		for (int i=0; i<BOARD_SIZE; i++)
		{
			for (int j=0; j<BOARD_SIZE; j++)
			{
				squares[i][j].setEnabled(false);
			}
		}
		newGameButton.setEnabled(true);
	}


	public static void main(String[] args)
	{
		TicTacToe_HC game = new TicTacToe_HC();
		game.setVisible(true);
	}

	public void setCompMode() {
		score.setText("Your turn");
	}

	public void compTurn() {
		String[][] current = new String[3][3];
		for (int i = 0; i < 3; i++)        {
			for (int x = 0; x < 3; x++)        {
				current[i][x]= squares[i][x].getText();
			}
		}

		//the first move is what decides the game
		boolean middleSpot = false, cornerSpot = false, edgeSpot = false;
		int xCord = 0, yCord = 0;
		if (turnCounter == 1)        {
			for (int y = 0; y < 3; y++)        {
				for (int x = 0; x < 3; x++)        {
					if (current [y][x].equals("X")) {
						if ((y == 0 || y == 2) && (x == 0 || x == 2))
							cornerSpot = true;
						if ((y == 0 || y == 2) && x == 1)	{
							edgeSpot = true;
							xCord = x;
							yCord = y;
						}
						if (y == 1 && (x == 0 || x == 2)) {
							edgeSpot = true;
							xCord = x;
							yCord = y;
						}
						if (y == 1 && x == 1)
							middleSpot = true;
					}
				}
			}
		}
		if (middleSpot == true && whoseTurn.equals("O")) {
			compTakeSpot(0,0);
		}
		if (cornerSpot == true && whoseTurn.equals("O")) {
			compTakeSpot(1,1);
		}
		if (edgeSpot == true && whoseTurn.equals("O"))	{
			if (yCord == 1)
				compTakeSpot(0, xCord);
			else {
				compTakeSpot(yCord, xCord-1);
			}
		}
		boolean[][] compSpots = lookForSpot(current, "O", "X");
		boolean[][] playerSpots = lookForSpot(current, "X", "O");
		for (int y = 0; y < 3; y++)        {
			for (int x = 0; x < 3; x++)        {
				if (compSpots[y][x] == true && whoseTurn.equals("O"))
					compTakeSpot(y, x);
				if (playerSpots[y][x] == true && whoseTurn.equals("O"))
					compTakeSpot(y, x);
			}
		}
	}

	public boolean[][] lookForSpot(String[][] current, String letter, String bad) {
		int[] row = new int[3];
		int[] column = new int[3];
		int[] diag = new int[2];
		boolean[][] possibleSpots = {{false, false, false}, {false, false, false}, {false, false, false}};
		//I want this method to see if there are any possible areas to win, and if so to take them.
		for (int z = 0; z < 3; z++)        {
			for (int i = 0; i < 3; i++)        {
				if (current[z][i].equals(letter))
					row[z]++;
				if (current[z][i].equals(bad))
					row[z]--;
				if (current[i][z].equals(letter))
					column[z]++;
				if (current[i][z].equals(bad))
					column[z]--;
				if (current[i][i].equals(letter))
					diag[0]++;
				if (current[i][i].equals(bad))
					diag[0]--;
				if (current[i][2-i].equals(letter))
					diag[1]++;
				if (current[i][2-i].equals(bad))
					diag[1]--;
			}
		}
		for (int z = 0; z < 3; z++)        {
			for (int i = 0; i < 3; i++)        {
				if (row[z] == 2)	{
					if (!(current[z][i].equals(letter)) && !(current[z][i].equals(bad))) {
						possibleSpots[z][i] = true;
					}
				}
				if (column[z] == 2)	{
					if (!(current[i][z].equals(letter)) && !(current[i][z].equals(bad))) {
						possibleSpots[i][z] = true;
					}
				}
				if (z < 3) {
					if (diag[0] == 2)	{
						if (!(current[i][i].equals(letter)) && !(current[i][i].equals(bad))) {
							possibleSpots[i][i] = true;
						}
					}
					if (diag[0] == 2)	{
						if (!(current[i][2-i].equals(letter)) && !(current[i][2-i].equals(bad))) {
							possibleSpots[i][2-i] = true;
						}
					}
				}
			}
		}

		if (letter.equals("O"))	{
			for (int z = 0; z < 3; z++)        {
				for (int i = 0; i < 3; i++)        {
					System.out.print(possibleSpots[z][i] + "  ");
				}
				System.out.println();
			}
		}

		return possibleSpots;
	}

	public void compTakeSpot (int x, int y) {
		squares[x][y].setText(whoseTurn);
		board[x][y] = whoseTurn;
		turnCounter++;
		squares[x][y].setEnabled(false);
		emptySquaresLeft--;
		lookForWinner();
		toggleTurn();
	}

}
