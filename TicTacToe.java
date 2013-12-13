/**
 * A tic-tac-toe game on the 3x3 board
 */
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener
{

	private static final int BOARD_SIZE = 3;
	private String[][] board;

	private JButton squares[][];     
	private JButton newGameButton;
	private JLabel score;
	private int emptySquaresLeft;
	private String whoseTurn;


	/** 
	 * Construct a TicTacToe game with a nice user interface
	 */ 
	public TicTacToe()
	{       
		setUpInterface();

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

		// Get the content pane - 
		// all window components go there
		Container  contentPane = getContentPane();

		//Set the layout manager and background color
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.CYAN);

		// Create the button New Game and register it 
		// with the action listener 
		newGameButton = new JButton("New Game");
		newGameButton.addActionListener(this);

		JPanel topPanel = new JPanel();
		topPanel.add(newGameButton);

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
				squares[i][j].setBackground(Color.YELLOW);
				squares[i][j].setEnabled(true);
				squares[i][j].setText("");
			}
		}    

		emptySquaresLeft = BOARD_SIZE*BOARD_SIZE;
		whoseTurn = "X";
		score.setText(whoseTurn + "'s turn");
		newGameButton.setEnabled(false);
	}

	/**
	 * This method will process all action events
	 * @param ActionEvent object
	 */
	public void actionPerformed(ActionEvent e)
	{

		JButton theButton = (JButton) e.getSource();
		String winner = "";

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
					squares[i][j].setEnabled(false);
					emptySquaresLeft--;

					board[i][j] = whoseTurn;
					winner = lookForWinner();  

					if (winner.equals(""))
					{
						if (emptySquaresLeft == 0)
						{
							endTheGame();
							score.setText("It's a tie!");
						}
						else
						{
							toggleTurn();
						}
					}
					else
					{
						endTheGame();
						score.setText(winner + " won!");
					} 
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
		score.setText(whoseTurn + "'s turn");
	}

	/*
	 *  Helper method called after every move to see 
	 *  if we have a winner. 
	 *  It checks every row, column and diagonal to find 
	 *  squares with the same label (other than blank)
	 *  @return "X", "O", or "" (for no winner)     
	 */
	private String lookForWinner()
	{
		String[][] current = new String[3][3];
		int counter = 0;
		String winner = "";
		for (int i = 0; i < 3; i++)	{
			for (int x = 0; x < 3; x++)	{
				current[i][x]= squares[i][x].getText();
				System.out.print(current[i][x]);
			}
			System.out.println("");
		}
		for (int z = 0; z < 3; z++)	{
			for (int i = 0; i < 3; i++)	{
				for (int x = 0; x < 3; x++)	{
					if (Arrays.asList(current[z][i]).contains(current[z][x]))
						counter++;
				}
				if (counter == 3)	{
					winner = current[z][i];
					break;
				}
			}
			if (counter == 3)
				break;
		}
		return winner;
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
		TicTacToe game = new TicTacToe();
		game.setVisible(true);
	}
}
