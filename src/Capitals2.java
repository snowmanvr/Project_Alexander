import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class Capitals2 {

	JFrame frame;
	private JTextField textPlayer1;
	private JTextField textPlayer2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { // STARTING THE WINDOWS
			public void run() {
				try {
					Capitals2 window = new Capitals2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public Capitals2() {
		initialize();
	}

	@SuppressWarnings("unused")
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("Dialog", Font.PLAIN, 18));
		frame.getContentPane().setBackground(new Color(135, 206, 235)); // CREATING
																		// THE
																		// FRAME
		frame.getContentPane().setLayout(null);

		JLabel capitals = new JLabel("\u0421\u0442\u043E\u043B\u0438\u0446\u0438");
		capitals.setBounds(147, 10, 127, 36);
		capitals.setFont(new Font("Arial Black", Font.BOLD, 25)); // THE TITLE
		frame.getContentPane().add(capitals);

		JLabel lblPlayer = new JLabel("Играч 1 :");
		lblPlayer.setBounds(61, 73, 76, 36);
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblPlayer);

		JLabel lblPlayer_1 = new JLabel("Играч 2 :");
		lblPlayer_1.setBounds(61, 134, 76, 19);
		lblPlayer_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblPlayer_1);

		textPlayer1 = new JTextField();
		textPlayer1.setBounds(157, 78, 197, 30); // HERE YOU SET THE NAME OF
													// FIRST PLAYER
		frame.getContentPane().add(textPlayer1);
		textPlayer1.setColumns(10);

		textPlayer2 = new JTextField();
		textPlayer2.setBounds(157, 130, 197, 30); // HERE YOU SET THE NAME OF
													// SECOND PLAYER
		frame.getContentPane().add(textPlayer2);
		textPlayer2.setColumns(10);

		JButton startButton = new JButton("\u0421\u0442\u0430\u0440\u0442");
		startButton.setBounds(155, 200, 119, 30);
		startButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) { // ACTION OF "START"
															// BUTTON
				capitals.hide();
				lblPlayer.hide();
				lblPlayer_1.hide();
				textPlayer1.hide();
				textPlayer2.hide();
				startButton.hide();
				int firstPlayerPoints = 0;
				int secondPlayerPoinst = 0;
				int whichTurnIsNow = 1;
				startTheGame(firstPlayerPoints, secondPlayerPoinst, whichTurnIsNow);

			}

		});
		frame.getContentPane().add(startButton);

	}

	private void startTheGame(int firstPlayerPoints, int secondPlayerPoinst, int whichTurnIsNow) {

		String firstPlayerName = textPlayer1.getText();
		String secondPlayerName = textPlayer2.getText();
		Random rand = new Random();

		// int i = rand.nextInt(5) + 1;
		int i = 1;
		String answer1 = null, answer2 = null, answer3 = null, answer4 = null;
		String question = "Коя е столицата на ";
		int rightAnswer = 0;
		switch (i) {
		case (1):
			question = question + "Египет?";
			answer1 = "Кайро";
			answer2 = "Александрия";
			answer3 = "Египет";
			answer4 = "Йерусалим";
			rightAnswer = 1;
			break;

		}

		JLabel lblHereIsTheCurrentQuestion = new JLabel(question);
		lblHereIsTheCurrentQuestion.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHereIsTheCurrentQuestion.setBounds(71, 77, 334, 59);
		frame.getContentPane().add(lblHereIsTheCurrentQuestion);

		JLabel lblTurn = new JLabel("");
		if (whichTurnIsNow % 2 == 0) {
			lblTurn.setText("Сега е ред на " + secondPlayerName + ".");
		} else {
			lblTurn.setText("Сега е ред на " + firstPlayerName + ".");
		}
		lblTurn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTurn.setBounds(118, 49, 238, 36);
		frame.getContentPane().add(lblTurn);

		String firstPlayerPointsString = firstPlayerPoints + "";
		String secondPlayerPointsString = secondPlayerPoinst + "";

		JLabel lblHereIsPlayer1Name = new JLabel(firstPlayerName + " :" + firstPlayerPointsString);
		lblHereIsPlayer1Name.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHereIsPlayer1Name.setBounds(10, 11, 132, 42);
		frame.getContentPane().add(lblHereIsPlayer1Name);

		JLabel lblHereIsPlayer2Name = new JLabel(secondPlayerName + " :" + secondPlayerPointsString);
		lblHereIsPlayer2Name.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblHereIsPlayer2Name.setBounds(220, 25, 133, 14);
		frame.getContentPane().add(lblHereIsPlayer2Name);

		buttonsAndAnswer(answer1, answer2, answer3, answer4, rightAnswer, firstPlayerPoints, secondPlayerPoinst,
				whichTurnIsNow, lblHereIsPlayer1Name, lblHereIsPlayer2Name, lblTurn, lblHereIsTheCurrentQuestion);

		frame.setBackground(Color.LIGHT_GRAY);
		frame.setTitle("\u0421\u0442\u043E\u043B\u0438\u0446\u0438");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	private void buttonsAndAnswer(String answer1, String answer2, String answer3, String answer4, int rightAnswer,
			int firstPlayerPoints, int secondPlayerPoinst, int whichTurnIsNow, JLabel lblHereIsPlayer1Name,
			JLabel lblHereIsPlayer2Name, JLabel lblTurn,JLabel lblHereIsTheCurrentQuestion) {

		JButton btnAnswer1 = new JButton(answer1);
		btnAnswer1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (rightAnswer == 1) {
					if (whichTurnIsNow % 2 == 0) {
						lblHereIsPlayer1Name.hide();
						lblHereIsPlayer2Name.hide();
						lblHereIsTheCurrentQuestion.hide();
						startTheGame(firstPlayerPoints, secondPlayerPoinst + 1, whichTurnIsNow + 1);

					} else {
						lblHereIsPlayer1Name.hide();
						lblHereIsPlayer2Name.hide();
						lblHereIsTheCurrentQuestion.hide();
						startTheGame(firstPlayerPoints + 1, secondPlayerPoinst, whichTurnIsNow + 1);
					}
				} else {
					lblHereIsPlayer1Name.hide();
					lblHereIsPlayer2Name.hide();
					lblHereIsTheCurrentQuestion.hide();
					startTheGame(firstPlayerPoints, secondPlayerPoinst, whichTurnIsNow + 1);

				}

			}
		});
		btnAnswer1.setBounds(61, 150, 119, 36);
		frame.getContentPane().add(btnAnswer1);

		JButton btnAnswer2 = new JButton(answer2);
		btnAnswer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rightAnswer == 2) {
					if (whichTurnIsNow % 2 == 0) {
						lblHereIsPlayer1Name.hide();
						lblHereIsPlayer2Name.hide();
						lblTurn.hide();
						startTheGame(firstPlayerPoints, secondPlayerPoinst + 1, whichTurnIsNow + 1);

					} else {
						lblHereIsPlayer1Name.hide();
						lblHereIsPlayer2Name.hide();
						lblTurn.hide();
						startTheGame(firstPlayerPoints + 1, secondPlayerPoinst, whichTurnIsNow + 1);
					}
				} else {
					lblHereIsPlayer1Name.hide();
					lblHereIsPlayer2Name.hide();
					lblTurn.hide();
					startTheGame(firstPlayerPoints, secondPlayerPoinst, whichTurnIsNow + 1);

				}
			}
		});

		btnAnswer2.setBounds(261, 150, 119, 36);
		frame.getContentPane().add(btnAnswer2);

		JButton btnAnswer3 = new JButton(answer3);
		btnAnswer3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rightAnswer == 3) {
					if (whichTurnIsNow % 2 == 0) {
						lblHereIsPlayer1Name.hide();
						lblHereIsPlayer2Name.hide();
						startTheGame(firstPlayerPoints, secondPlayerPoinst + 1, whichTurnIsNow + 1);

					} else {
						lblHereIsPlayer1Name.hide();
						lblHereIsPlayer2Name.hide();
						startTheGame(firstPlayerPoints + 1, secondPlayerPoinst, whichTurnIsNow + 1);
					}
				} else {
					lblHereIsPlayer1Name.hide();
					lblHereIsPlayer2Name.hide();
					startTheGame(firstPlayerPoints, secondPlayerPoinst, whichTurnIsNow + 1);

				}
			}
		});

		btnAnswer3.setBounds(61, 215, 119, 36);
		frame.getContentPane().add(btnAnswer3);

		JButton btnAnswer4 = new JButton(answer4);
		btnAnswer4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rightAnswer == 4) {
					if (whichTurnIsNow % 2 == 0) {
						lblHereIsPlayer1Name.hide();
						lblHereIsPlayer2Name.hide();
						startTheGame(firstPlayerPoints, secondPlayerPoinst + 1, whichTurnIsNow + 1);

					} else {
						lblHereIsPlayer1Name.hide();
						lblHereIsPlayer2Name.hide();
						startTheGame(firstPlayerPoints + 1, secondPlayerPoinst, whichTurnIsNow + 1);
					}
				} else {
					lblHereIsPlayer1Name.hide();
					lblHereIsPlayer2Name.hide();
					startTheGame(firstPlayerPoints, secondPlayerPoinst, whichTurnIsNow + 1);

				}
			}
		});
		btnAnswer4.setBounds(261, 215, 119, 36);
		frame.getContentPane().add(btnAnswer4);

	}
	public static void hideButtons()
	{
		
	}
}
