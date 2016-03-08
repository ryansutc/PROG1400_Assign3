package RPGGame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.*;

public class GUI{

	private Game game;
	private JFrame frame;
	//panels incl. welcome, generic (battle), rules/credits, stuff
	private JPanel pnlWelcome; 
	private JPanel pnlGeneric; 
	private JPanel pnlRules;
	private JPanel pnlStuff;
	
	//pnlGeneric (battle screen) form items
	private JLabel lblTitle;
	private JLabel lblLevelScore;
		
	private JLabel lblBobHealth;
	private JLabel lblBobStrength;
	private JLabel lblBobMoney;
	
	private JLabel lblBadguyImage;
	private JLabel lblBadguyHealth;
	private JLabel lblBadguyStrength;
	private JLabel lblBadguyMoney;
	private JLabel lblBadguy;
	private JTextArea jepDialog;
	private JScrollPane scrollPane;
	private JLabel lblLevelUp;
	
	private JButton btnFlee;
	private JButton btnAttack;
	private JButton btnNextLevel;
	private JButton btnBattleOver;
	private JButton btnReturnToWelcome;
	private JButton btnUseStuff;
	private JButton btnBuyStuff;
	private JButton btnGameDone;
	
	//pnlRules (rules/credits) form items
	private JButton btnReturn;
	private JEditorPane jepRulesCreditsText; //text panel
	
	//pnlStuff (buy stuff/use stuff) form items
	
	private JComboBox cboStuff;
	private JTextArea editorPane;
	
	private JLabel lblItem;
	private JLabel lblAlreadyUsed;
	
	//pnlStuff (use stuff/getstuff scenes)
	private JButton btnUseItem;
	private JButton btnBuyItem;
	private JLabel lblMoney;

	//pnlGameWon Stuff
	JPanel pnlGameWon;
	JButton btnGameRestarted;
	JLabel lblFinalScore;

	
	/**
	 * Create the application.
	 */
	public GUI(Game game) {
		//call initialize to handle graphics stuff
		this.game = game;
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		this.frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(100, 100, 340, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bob the Bike Courier");			
		frame.getContentPane().setLayout(null);
		
		pnlGameWon = new JPanel();
		pnlGameWon.setBackground(Color.WHITE);
		pnlGameWon.setBounds(0, 0, 334, 472);
		frame.getContentPane().add(pnlGameWon);
		pnlGameWon.setLayout(null);
		pnlGameWon.setVisible(false);
		
		lblFinalScore = new JLabel("Final Score:");
		lblFinalScore.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFinalScore.setBounds(29, 130, 183, 45);
		pnlGameWon.add(lblFinalScore);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 frame.setVisible(false); //you can't see me!
				 frame.dispose(); //Destroy the JFrame object
			}
		});
		btnExit.setBounds(235, 438, 89, 23);
		pnlGameWon.add(btnExit);
		
		btnGameRestarted = new JButton("Restart Game");
		btnGameRestarted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game = new Game();
				
			}
		});
		btnGameRestarted.setBounds(10, 438, 89, 23);
		pnlGameWon.add(btnGameRestarted);
		
		JLabel lblGameWon = new JLabel();
		lblGameWon.setText("<html>Game <br/>\r\nWon!</html>");
		lblGameWon.setFont(new Font("Hobo Std", Font.PLAIN, 36));
		lblGameWon.setBounds(30, 11, 137, 123);
		pnlGameWon.add(lblGameWon);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/img/hipsterbiker.png")));
		lblNewLabel.setBounds(20, 0, 287, 472);
		pnlGameWon.add(lblNewLabel);
		
		//Initialize Generic Panel
		pnlGeneric = new JPanel();
		pnlGeneric.setBackground(Color.WHITE);
		pnlGeneric.setBounds(0, 0, 334, 472);
		frame.getContentPane().add(pnlGeneric);
		pnlGeneric.setLayout(null);
		
		lblTitle = new JLabel();
		lblTitle.setText("Generic");
		lblTitle.setFont(new Font("Hobo Std", Font.PLAIN, 36));
		lblTitle.setBounds(10, 22, 216, 46);
		lblTitle.setText("Generic"); //Welcome, Battle!, etc
		pnlGeneric.add(lblTitle);
		
		lblLevelScore = new JLabel();
		lblLevelScore.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLevelScore.setBounds(157, 7, 121, 14);
		pnlGeneric.add(lblLevelScore);
		
		//Bob Icon
		JLabel lblBobImage = new JLabel();
		lblBobImage.setIcon(new ImageIcon(GameFrame.class.getResource("/img/bobsm.png")));
		lblBobImage.setBounds(10, 88, 95, 89);
		pnlGeneric.add(lblBobImage);
		
		JLabel lblBob = new JLabel("Bob");
		lblBob.setBounds(10, 71, 46, 14);
		pnlGeneric.add(lblBob);
		
		lblBobHealth = new JLabel();
		lblBobHealth.setBounds(10, 184, 95, 14);
		pnlGeneric.add(lblBobHealth);
		
		lblBobStrength = new JLabel();
		lblBobStrength.setBounds(10, 198, 95, 14);
		pnlGeneric.add(lblBobStrength);
		
		lblBobMoney = new JLabel();
		lblBobMoney.setBounds(10, 211, 95, 14);
		pnlGeneric.add(lblBobMoney);
		
		//Bad Guy Stuff
		//Bad guy Icon
		lblBadguyImage = new JLabel();
		lblBadguyImage.setIcon(new ImageIcon(GameFrame.class.getResource("/img/bobsm.png")));
		lblBadguyImage.setBounds(187, 88, 91, 89);
		pnlGeneric.add(lblBadguyImage);
		
		lblBadguyHealth = new JLabel();
		lblBadguyHealth.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBadguyHealth.setBounds(188, 183, 95, 14);
		pnlGeneric.add(lblBadguyHealth);
		
		lblBadguyStrength = new JLabel();
		lblBadguyStrength.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBadguyStrength.setBounds(188, 197, 95, 14);
		pnlGeneric.add(lblBadguyStrength);
		
		lblBadguyMoney = new JLabel();
		lblBadguyMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBadguyMoney.setBounds(188, 210, 95, 14);
		lblBadguyMoney.setText("");
		pnlGeneric.add(lblBadguyMoney);
		
		lblBadguy = new JLabel();
		lblBadguy.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBadguy.setBounds(172, 71, 106, 14);
		pnlGeneric.add(lblBadguy);
		
		//lblLevelUp (only shown on win screens)
		lblLevelUp = new JLabel("Level Up!");
		lblLevelUp.setVerticalAlignment(SwingConstants.TOP);
		lblLevelUp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblLevelUp.setBounds(135, 88, 147, 110);
		pnlGeneric.add(lblLevelUp);
		
		//Main Text/Dialog Pane
		jepDialog = new JTextArea();
		jepDialog.setEditable(false);
		jepDialog.setText("Battle");
		jepDialog.setFont(new Font("Courier New", Font.PLAIN, 11));
		jepDialog.setBounds(10, 228, 252, 176);
		jepDialog.setWrapStyleWord(true);
		jepDialog.setLineWrap(true);
		pnlGeneric.add(jepDialog);
		
		scrollPane = new JScrollPane(jepDialog);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 228, 271, 176);
		pnlGeneric.add(scrollPane);
		
		//generic button items:
		btnFlee = new JButton("Flee");
		btnFlee.setBounds(10, 420, 81, 31);
		pnlGeneric.add(btnFlee);
		btnFlee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//call function to calculate flee loss
				game.bob.flee(); //resets bob's health, recalcs money..
				game.badguy.setCurhealth(game.badguy.getMaxhealth());
				loadScene("lose");
			}
		});
		
		btnUseStuff = new JButton("Use Stuff");
		btnUseStuff.setBounds(106, 420, 81, 31);
		pnlGeneric.add(btnUseStuff);
		btnUseStuff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//load pnlUseStuff and initialize control panel variables
				pnlGeneric.setVisible(false);
				pnlWelcome.setVisible(false);
				pnlRules.setVisible(false);
				pnlGameWon.setVisible(false);
				pnlStuff.setVisible(true);
				loadScene("use stuff");
				
			}
		});
		
		btnBuyStuff = new JButton("Buy Stuff");
		btnBuyStuff.setBounds(106, 420, 81, 31);
		pnlGeneric.add(btnBuyStuff);
		btnBuyStuff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//call function to calculate attack
				pnlGeneric.setVisible(false);
				pnlWelcome.setVisible(false);
				pnlRules.setVisible(false);
				pnlGameWon.setVisible(false);
				pnlStuff.setVisible(true);
				loadScene("buy stuff");
				
			}
		});
		
		btnAttack = new JButton("Attack");
		btnAttack.setBounds(197, 420, 81, 31);
		pnlGeneric.add(btnAttack);
		btnAttack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//call function to calculate attack
				int attack = game.bob.attack();
				
				game.badguy.setCurhealth((game.badguy.getCurhealth() - attack < 0) ? 0 : game.badguy.getCurhealth() - attack);
				jepDialog.setText(jepDialog.getText() + "\n" + game.getAttackMsg(game.bob.getName(), game.badguy.getName(), attack));
				
				attackResponse(); //private method to process badguy attack or death
				
			}
		});
		
		btnGameDone = new JButton("Game Done");
		btnGameDone.setBounds(197, 420, 81, 31);
		pnlGeneric.add(btnGameDone);
		btnGameDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Load game won panel
				pnlGeneric.setVisible(false);
				pnlStuff.setVisible(false);
				pnlWelcome.setVisible(false);
				pnlGameWon.setVisible(true);
				
				
			}
		});
		
		btnNextLevel = new JButton("Next Level");
		btnNextLevel.setBounds(197, 420, 81, 31);
		pnlGeneric.add(btnNextLevel);
		btnNextLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//call function to calculate flee loss
				
				loadScene("battle");
			}
		});
		
		btnBattleOver = new JButton("Continue");
		btnBattleOver.setBounds(197, 420, 81, 31);
		pnlGeneric.add(btnBattleOver);
		btnBattleOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//call function to calculate flee loss
				if (game.bob.getCurhealth() != 0){
					loadScene("win");
				}
				else if (game.bob.getCurhealth() == 0){
					loadScene("game over");
				}
				else {
					loadScene("lose");
				}
				
			}
		});
		pnlGeneric.setVisible(false);
		
		
		btnReturnToWelcome = new JButton("Return.");
		btnReturnToWelcome.setBounds(106, 420, 81, 31);
		pnlGeneric.add(btnReturnToWelcome);
		
		btnReturnToWelcome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		pnlRules.setVisible(false);
		pnlGeneric.setVisible(false);
		pnlGameWon.setVisible(false);
		pnlStuff.setVisible(false);
		pnlWelcome.setVisible(true);
		game = new Game();
			}
		});
		
		//Welcome Panel 
		pnlWelcome = new JPanel();
		pnlWelcome.setBackground(Color.WHITE);
		pnlWelcome.setBounds(0, 0, 334, 472);
		frame.getContentPane().add(pnlWelcome);
		pnlWelcome.setLayout(null);
		
		
		pnlWelcome.setVisible(true);
		JLabel lblTitle_1 = new JLabel();
		lblTitle_1.setFont(new Font("Hobo Std", Font.PLAIN, 36));
		lblTitle_1.setBounds(10, 22, 216, 46);
		lblTitle_1.setText("Welcome"); //Welcome, Battle!, etc
		pnlWelcome.add(lblTitle_1);
		
		//Bob Icon
		JLabel lblBobImage_1 = new JLabel();
		lblBobImage_1.setIcon(new ImageIcon(GameFrame.class.getResource("/img/bobsm.png")));
		lblBobImage_1.setBounds(10, 88, 95, 89);
		pnlWelcome.add(lblBobImage_1);
		
		//Main Text/Dialog Pane
		JTextArea txtDialog = new JTextArea();
		txtDialog.setFont(new Font("Courier New", Font.PLAIN, 11));
		txtDialog.setEditable(false);
		txtDialog.setText(game.getWelcomeMsg());
		txtDialog.setBounds(10, 228, 181, 223);
		txtDialog.setWrapStyleWord(true);
		txtDialog.setLineWrap(true);
		pnlWelcome.add(txtDialog);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(197, 420, 81, 31);
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlWelcome.setVisible(false);
				pnlRules.setVisible(false);
				pnlGameWon.setVisible(false);
				pnlGeneric.setVisible(true);
				
				game.setLevel(1);
				loadScene("battle");
				//pnlGeneric.getCompo
			}
		});
		
				pnlWelcome.add(btnStart);
				
				JButton btnCredits = new JButton("Credits");
				btnCredits.setBounds(197, 378, 81, 31);
				btnCredits.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pnlWelcome.setVisible(false);
						pnlGeneric.setVisible(false);
						pnlGameWon.setVisible(false);
						pnlStuff.setVisible(false);
						pnlRules.setVisible(true);
						loadScene("credits");
					}
				});
				pnlWelcome.add(btnCredits);
				
				JButton btnRules = new JButton("Rules");
				btnRules.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pnlWelcome.setVisible(false);
						pnlGeneric.setVisible(false);
						pnlStuff.setVisible(false);
						pnlGameWon.setVisible(false);
						pnlRules.setVisible(true);
						loadScene("rules");
					}
				});
				btnRules.setBounds(197, 336, 81, 31);
				pnlWelcome.add(btnRules);
		
		pnlRules = new JPanel();
		pnlRules.setBackground(Color.WHITE);
		pnlRules.setBounds(0, 0, 334, 472);
		frame.getContentPane().add(pnlRules);
		pnlRules.setLayout(null);
		
		JLabel lblRules = new JLabel();
		lblRules.setText("How to Play");
		lblRules.setFont(new Font("Hobo Std", Font.PLAIN, 36));
		lblRules.setBounds(10, 22, 216, 46);
		pnlRules.add(lblRules);
		
		jepRulesCreditsText = new JEditorPane();
		jepRulesCreditsText.setFocusable(false);
		jepRulesCreditsText.setEditable(false);
		jepRulesCreditsText.setText("autopopulate");
		jepRulesCreditsText.setBounds(10, 79, 314, 327);
		pnlRules.add(jepRulesCreditsText);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlWelcome.setVisible(true);
				pnlRules.setVisible(false);
				pnlGeneric.setVisible(false);
				pnlGameWon.setVisible(false);
				pnlStuff.setVisible(false);
			}
		});
		btnBack.setBounds(235, 438, 89, 23);
		pnlRules.add(btnBack);
		pnlRules.setVisible(false);
		

		//Initialize Stuff Panel
		pnlStuff = new JPanel();
		pnlStuff.setBackground(new Color(255, 255, 255));
		pnlStuff.setLayout(null);
		pnlStuff.setBounds(0, 0, 334, 472);
		frame.getContentPane().add(pnlStuff);
		
		JLabel lblStuff = new JLabel();
		lblStuff.setText("Stuff");
		lblStuff.setFont(new Font("Hobo Std", Font.PLAIN, 36));
		lblStuff.setBounds(10, 22, 216, 46);
		pnlStuff.add(lblStuff);
		
		JLabel lblBobsImage = new JLabel();
		lblBobsImage.setIcon(new ImageIcon(GUI.class.getResource("/img/bobsm.png")));
		lblBobsImage.setBounds(10, 88, 95, 89);
		pnlStuff.add(lblBobsImage);
		
		JLabel label_3 = new JLabel("Bob");
		label_3.setBounds(10, 71, 46, 14);
		pnlStuff.add(label_3);
		
		editorPane = new JTextArea();
		editorPane.setFont(new Font("Courier New", Font.PLAIN, 11));
		editorPane.setWrapStyleWord(true);
		editorPane.setLineWrap(true);
		//editorPane.setContentType("html");
		editorPane.setBackground(Color.LIGHT_GRAY);
		editorPane.setText("Is this it?");
		editorPane.setEditable(false);
		editorPane.setBounds(10, 267, 268, 137);
		pnlStuff.add(editorPane);
		
		btnReturn = new JButton("Return..");
		btnReturn.setBounds(106, 420, 81, 31);
		pnlStuff.add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlWelcome.setVisible(false);
				pnlRules.setVisible(false);
				pnlGameWon.setVisible(false);
				pnlStuff.setVisible(false);
				pnlGeneric.setVisible(true);
				loadScene(game.prevscene);

			}
		});
		
		btnBuyItem = new JButton("Buy Item");
		btnBuyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!game.bob.items[cboStuff.getSelectedIndex()].isOwned()){
					if (game.bob.getMoney() >= game.bob.items[cboStuff.getSelectedIndex()].getCost()){
						game.bob.items[cboStuff.getSelectedIndex()].setOwned(true);
						game.bob.setMoney(game.bob.getMoney()- game.bob.items[cboStuff.getSelectedIndex()].getCost());
						
						editorPane.setText("You've bought a " + cboStuff.getSelectedItem().toString());
						lblBobMoney.setText("Money: $"+game.bob.getMoney());
						lblMoney.setText("Money: $"+game.bob.getMoney());
						btnBuyItem.setEnabled(false);
						//loadScene("buy stuff");
					}
					//else {lblAlreadyUsed.setText("You can't afford this item");}
					
				}
			}
		});
		btnBuyItem.setBounds(197, 420, 81, 31);
		pnlStuff.add(btnBuyItem);
		
		//"Powerbar ($50)", "Bike Chain ($50)",	"Pepper Spray ($75)","Hockey Stick ($150)",	"Corrupt Police Officer ($100)"
		btnUseItem = new JButton("Use Item");
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//need an event here to implement attack with item
				String selItem = cboStuff.getSelectedItem().toString();
				
				pnlGameWon.setVisible(false);
				pnlStuff.setVisible(false);
				pnlWelcome.setVisible(false);
				pnlRules.setVisible(false);
				pnlRules.setVisible(false);
				pnlGeneric.setVisible(true);
				int attackval;
				Item thisItem;
				thisItem = game.bob.findItembyName(selItem);
				
				//need to call items for message, etc
				if (thisItem.getName().equals("Pepper Spray")) {
					game.badguy.setWeakened(true);
					jepDialog.setText(jepDialog.getText() + "\n" + game.bob.useitem(thisItem));
				}
				else if (thisItem.getName().equals("Powerbar")) {
					game.bob.setCurhealth(game.bob.getMaxhealth());
					jepDialog.setText(jepDialog.getText() + "\n" + game.bob.useitem(thisItem));
				}
				else if (thisItem.getName().equals("Bike Chain")) {
					attackval = game.bob.attack();
					game.badguy.setCurhealth(game.badguy.getCurhealth() - (attackval + 3));
					jepDialog.setText(jepDialog.getText() + "\n" + game.bob.useitem(thisItem) + attackval + " (+3) points");
				}
				else if (thisItem.getName().equals("Hockey Stick")) {
					attackval = game.bob.attack();
					game.badguy.setCurhealth(game.badguy.getCurhealth() - (attackval * 2));
					jepDialog.setText(jepDialog.getText() + "\n" + game.bob.useitem(thisItem) + attackval + " (x2) points!");
				}
				else if (thisItem.getName().equals("Corrupt Police Officer")) {
					if (game.bob.getMoney() >= 25){
						game.badguy.setCurhealth(0);
						jepDialog.setText(jepDialog.getText() + "\n" + game.bob.useitem(thisItem));
					}
					else {
						jepDialog.setText(jepDialog.getText() + "\n" + game.bob.useitem(thisItem) +
								"\n Unfortunately you don't have enough money and the cop ignores you!");
					}
					
					
				}
				//call function to calculate attack
				attackResponse();
				
				//loadScene("other"); //other as a parameter essentially means refresh the same panel/scene

			}
		});
		btnUseItem.setBounds(197, 420, 81, 31);
		pnlStuff.add(btnUseItem);
		
		cboStuff = new JComboBox();
		//add items

		cboStuff.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				checkItemState(game.curscene);
				
			}
		});
		
		System.out.println(cboStuff.getSelectedIndex());
		cboStuff.setToolTipText("Pick an Item");
		cboStuff.setBounds(10, 236, 268, 20);
		pnlStuff.add(cboStuff);
		
		lblItem = new JLabel("New label");
		lblItem.setIcon(new ImageIcon(GUI.class.getResource("/img/question.png")));
		
		lblItem.setBounds(157, 88, 121, 120);
		//imgIcon = new ImageIcon(getClass().getResource("/img/bikechain.png"));
		//lblItem.setIcon(imgIcons[0]);
		pnlStuff.add(lblItem);
		
		lblAlreadyUsed = new JLabel("This item is already used");
		lblAlreadyUsed.setForeground(Color.RED);
		lblAlreadyUsed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlreadyUsed.setBounds(10, 219, 268, 14);
		pnlStuff.add(lblAlreadyUsed);
		
		lblMoney = new JLabel();
		lblMoney.setText("Money: 50");
		lblMoney.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMoney.setBounds(10, 188, 95, 14);
		pnlStuff.add(lblMoney);
		pnlStuff.setVisible(false);
		loadWelcomePanel();
	    
	}
	
	private void loadWelcomePanel(){
	}
	
	private void loadScene(String scene){
		
		
		if (pnlGeneric.isVisible()){
			for (Component c : pnlGeneric.getComponents()) {
				c.setVisible(true);
				c.setEnabled(true);
			}
			lblLevelUp.setVisible(false); //default hides
			btnGameDone.setVisible(false); //default hides
		}
		//for item in panel, show all loop here
		if (!scene.equals("other")){
			lblTitle.setText(scene);
			if (!scene.equals(game.curscene)){
				game.prevscene = game.curscene;
				System.out.println("game prev scene: " + game.prevscene);
				game.curscene = scene;
				System.out.println("game cur scene: " + game.curscene);
			}
		}
		//loading scenes Rules or Credits for pnlRules
		if (scene.equals("rules")){
			jepRulesCreditsText.setText("DRAFT:\r\nYour goal is to win battles to complete jobs and make money. " +
					"You start each battle with full health. You attack the opponent which" +
					"reduces the opponent by a random value of 2-12 multiplied by the strength." +
					"After every time you attack they respond by attacking. Their attack on you is " +
					"calculated the same way. You continue fighting until one of you dies or you decide " +
					"to flee. If you die you lose the game. If you flee your health goes back to " +
					"full before you return to fight again but you lose money. If you run completely " +
					"out of money you also lose.\r\nIf you win you gain money and points and go to the" +
					"next level. You can use your health to buy things to help you in future battles. " +
					"Each thing that you own can be used once every battle. The trick is to buy things " +
					"so that you can win battles but also not to buy too many things so that if you have " +
					"to flee you don\u2019t go broke. \r\nBad guys don\u2019t flee by the way. " +
					"They fight to the death.\r\n");			
		}
		else if (scene.equals("credits")){
			jepRulesCreditsText.setText("Game created by RSutcliffe. Graphics stolen from the internet.\n" +
					"code viewable on GitHub here: https://github.com/ryansutc/PROG1400_Assign3");
		}
		
		//hide panel items to fit for screen
		else if (scene.equals("battle")){
			lblLevelUp.setVisible(false);
        	btnNextLevel.setVisible(false);
        	btnBuyStuff.setVisible(false);
        	btnReturnToWelcome.setVisible(false);
        	jepDialog.setText(game.getBattleMsgList()[game.getLevel() - 1]);
        	lblBadguyImage.setIcon(game.badguy.getIcon());
        	int badguyNum = game.getLevel() - 1;
        	
        	//lblBadguyImage.setIcon(arg0); //need to create a list of badguy images
		}	
		else if (scene.equals("battledone")){
			lblLevelUp.setVisible(false);
        	btnNextLevel.setVisible(false);
        	btnBuyStuff.setVisible(false);
        	btnReturnToWelcome.setVisible(false);
        	btnAttack.setVisible(false);
        	btnUseStuff.setEnabled(false);
        	btnFlee.setEnabled(false);
        }
		else if (scene.equals("buy stuff") || scene.equals("use stuff")){
			lblMoney.setText("Money: $" + game.bob.getMoney());
			
			if (scene.equals("buy stuff")){
				/*
				for (int i = 0, len = game.bob.items.length; i < len; i++){
					if (game.bob.items[i].isOwned() == false){
						cboStuff.addItem(game.bob.items[i].getName() + " ($" + game.bob.items[i].getCost() + ")");
					}		
				}
				cboStuff.setSelectedItem(0);*/
				cboStuff.removeAllItems();
				for (int i = 0, len = game.bob.items.length; i < len; i++){
					cboStuff.addItem(game.bob.items[i].getName() + " ($" + game.bob.items[i].getCost() + ")");
				}
			    cboStuff.setSelectedItem(0);
				btnUseItem.setVisible(false);
				btnBuyItem.setVisible(true);
				
			}
			else if (scene.equals("use stuff")) {
				cboStuff.removeAllItems();
				for (int i = 0, len = game.bob.items.length; i < len; i++){
					if (game.bob.items[i].isOwned()){
						cboStuff.addItem(game.bob.items[i].getName());
					}
				}
				if (cboStuff.getItemCount() != 0){
					cboStuff.setSelectedItem(0);
				}
				btnUseItem.setVisible(true);
				btnBuyItem.setVisible(false);
			}
			checkItemState(scene);
		}
		else if (scene.equals("win") || scene.equals("lose")){ //lose is flee
        	lblBadguyImage.setVisible(false);
        	lblBadguyHealth.setVisible(false);
        	lblBadguyMoney.setVisible(false);
        	lblBadguyStrength.setVisible(false);
        	lblBadguy.setVisible(false);
        	btnFlee.setVisible(false);
        	btnUseStuff.setVisible(false);
        	btnBuyStuff.setVisible(true);
        	btnAttack.setVisible(false); 
        	btnReturnToWelcome.setVisible(false);
            
        	if (scene.equals("win")){
        		jepDialog.setText(game.winMsgList[game.getLevel() - 2]);
        		
        		lblLevelUp.setVisible(true);

        	}
        	else {
        		jepDialog.setText(game.getLossMsg());
        		lblLevelUp.setText("Money: -$15");
        		lblLevelUp.setVisible(true);
        		
        		if (game.bob.getMoney() <= 15){
        			jepDialog.setText(jepDialog.getText() + 
        					"\nYou're almost broke. You can't afford to flee next time!");
        		}
        	}
		}
		
		else if (scene.equals("game over")){ 
        	lblBadguyImage.setVisible(false);
        	lblBadguyHealth.setVisible(false);
        	lblBadguyMoney.setVisible(false);
        	lblBadguyStrength.setVisible(false);
        	lblBadguy.setVisible(false);
        	btnFlee.setVisible(false);
        	btnUseStuff.setVisible(false);
        	btnAttack.setVisible(false);
        	btnNextLevel.setVisible(false);
        	btnBuyStuff.setVisible(false);
        	btnBattleOver.setVisible(false);
        	lblLevelUp.setVisible(false);
        	
        	//btnReturn.setVisible(true);
        	jepDialog.setText(game.getGameoverMsg());
        	        	
		}
		
		//things to do on generic panel regardless of scene
		if (pnlGeneric.isVisible()){
			lblBobHealth.setText("Health: " + game.bob.getCurhealth());
			lblBobStrength.setText("Strength: " + game.bob.getStrength());
			lblBobMoney.setText("Money: " + game.bob.getMoney());
			
			lblLevelScore.setText("Level: " + game.getLevel() + "    Score: " + game.getScore());
			lblFinalScore.setText("Final Score: " + game.getScore());
			lblBadguy.setText(game.badguy.getName());
	    	lblBadguyHealth.setText("Health: " + game.badguy.getCurhealth());
	    	lblBadguyStrength.setText("Strength: " + game.badguy.getStrength());
	    	lblBadguyMoney.setText("Money: " + game.badguy.getMoney());
	    	
	    	if (game.bob.getMoney() < 15){
	    		btnFlee.setEnabled(false);
	    	}
		}
	}
	
	//a private function to implement badguy response after being attacked. Also to deal with a player death.
	private void attackResponse(){ 
		
		if (game.badguy.getCurhealth() > 0){
			int attack = game.badguy.attack();
			jepDialog.setText(jepDialog.getText() + "\n" + game.getAttackMsg(game.badguy.getName(), game.bob.getName(), attack));
			game.bob.setCurhealth(game.bob.getCurhealth() - attack);
			if (game.bob.getCurhealth() < 1){
				loadScene("battledone");
				return;
			}
			
		}
		else {
			jepDialog.setText(jepDialog.getText() + "\n" + game.badguy.getDeathMsg());
			//loadScene("win");
			loadScene("battledone");
    		if (game.getLevel() < 4){ 
    			lblLevelUp.setText(game.setLevel(game.getLevel() + 1)); //changing level will update badguy automatically
    			return;
    		}
    		else {
    			jepDialog.setText(game.winMsgList[3]);
    			btnGameDone.setVisible(true);
    			//game.setLevel(level);
    			return;
    			//do something here to calculate final score!
    		}
		}
		loadScene("other"); //other as a parameter essentially means refresh the same panel/scene
	}
	//update items on selection change and form load for pnlStuff. Prevents item reuse.
	private void checkItemState(String scene){
		System.out.println(cboStuff.getSelectedIndex());
		if (cboStuff.getSelectedIndex() == -1){
			lblAlreadyUsed.setText("You don't own any items yet!");
			btnUseItem.setEnabled(false);
			editorPane.setText("Get yourself some money and buy some stuff first.");
			return;
		}
		lblItem.setIcon(game.bob.findItembyName(cboStuff.getSelectedItem().toString()).getIcon());
		//else let the default question mark show.
		
		//find matching item
		Item selItem = game.bob.findItembyName(cboStuff.getSelectedItem().toString());
		editorPane.setText(selItem.getDescription());
		if (scene.equals("use stuff")){
			if (selItem.isUsed() == true){
				btnUseItem.setEnabled(false);
				lblAlreadyUsed.setText("You already used this item.");
				lblAlreadyUsed.setVisible(true); 
			}
			else { 
				btnUseItem.setEnabled(true);
				lblAlreadyUsed.setVisible(false);
			}
		}
		else if (scene.equals("buy stuff")){
			if (selItem.isOwned() == true){
				lblAlreadyUsed.setText("You already own this");
				lblAlreadyUsed.setVisible(true);
				btnBuyItem.setEnabled(false);
			}
			else if (selItem.getCost() > game.bob.getMoney()){
				lblAlreadyUsed.setText("You can't afford this item");
				lblAlreadyUsed.setVisible(true);
				btnBuyItem.setEnabled(false);
			}
			else {
				btnBuyItem.setEnabled(true);
				lblAlreadyUsed.setVisible(false);
			}
		}
		
	}
}
