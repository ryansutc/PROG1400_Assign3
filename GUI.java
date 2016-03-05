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
	private JEditorPane jepDialog;
	private JScrollPane scrollPane;
	
	private JButton btnFlee;
	private JButton btnAttack;
	private JButton btnNextLevel;
	private JButton btnBattleOver;
	private JButton btnReturnToWelcome;
	private JButton btnUseStuff;
	private JButton btnBuyStuff;
	
	//pnlRules (rules/credits) form items
	private JButton btnReturn;
	
	//pnlStuff (buy stuff/use stuff) form items
	
	private JComboBox cboStuff;
	private JEditorPane editorPane;
	private String[] itemNames =  {"Powerbar ($50)", 
			"Bike Chain ($50)", 
			"Pepper Spray ($75)", 
			"Hockey Stick ($150)", 
			"Corrupt Police Officer ($100)"};
	private JLabel lblItem;
	private JLabel lblAlreadyUsed;
	private Icon[] imgIcons = {new ImageIcon(getClass().getResource("/img/powerbar.png")), 
			new ImageIcon(getClass().getResource("/img/bikechain.png")),
			new ImageIcon(getClass().getResource("/img/pepperspray.png")),
			new ImageIcon(getClass().getResource("/img/hockeystick.png")),
			new ImageIcon(getClass().getResource("/img/corruptpoliceofficer.png"))
	};
	
	//pnlStuff (use stuff/getstuff scenes)
	private JButton btnUseItem;

	

	
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
		
		//Initialize Generic Panel
		pnlGeneric = new JPanel();
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
		
		//Main Text/Dialog Pane
		jepDialog = new JEditorPane();
		jepDialog.setEditable(false);
		jepDialog.setText("Battle");
		jepDialog.setBounds(10, 228, 252, 176);
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
				loadScene("flee");
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
				pnlStuff.setVisible(true);
				
				checkItemState();
			}
		});
		
		btnBuyStuff = new JButton("Buy Stuff");
		btnBuyStuff.setBounds(106, 420, 81, 31);
		pnlGeneric.add(btnBuyStuff);
		
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
		
		btnNextLevel = new JButton("Next Level");
		btnNextLevel.setBounds(197, 420, 81, 31);
		pnlGeneric.add(btnNextLevel);
		btnNextLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//call function to calculate flee loss
				
				game.setLevel(game.getLevel() + 1); //changing level will update badguy automatically
				loadScene("battle");
			}
		});
		
		btnBattleOver = new JButton("Continue");
		btnBattleOver.setBounds(197, 420, 81, 31);
		pnlGeneric.add(btnBattleOver);
		btnBattleOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//call function to calculate flee loss
				if (game.badguy.getCurhealth() == 0){
					loadScene("win");
				}
				else if (game.bob.getCurhealth() == 0){
					loadScene("gameover");
				}
				else {
					loadScene("lose");
				}
				
			}
		});
		pnlGeneric.setVisible(false);
		
		btnReturnToWelcome = new JButton("Return");
		btnReturnToWelcome.setBounds(106, 420, 81, 31);
		pnlGeneric.add(btnReturnToWelcome);
		btnReturnToWelcome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlWelcome.setVisible(true);
				pnlRules.setVisible(false);
				pnlGeneric.setVisible(false);
				pnlStuff.setVisible(false);
			}
		});
		

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
		
		JLabel label_1 = new JLabel();
		label_1.setText((String) null);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(157, 7, 121, 14);
		pnlStuff.add(label_1);
		
		JLabel label_2 = new JLabel();
		label_2.setIcon(new ImageIcon(GUI.class.getResource("/img/bobsm.png")));
		label_2.setBounds(10, 88, 95, 89);
		pnlStuff.add(label_2);
		
		JLabel label_3 = new JLabel("Bob");
		label_3.setBounds(10, 71, 46, 14);
		pnlStuff.add(label_3);
		
		editorPane = new JEditorPane();
		editorPane.setContentType("html");
		editorPane.setBackground(Color.LIGHT_GRAY);
		editorPane.setText("Is this it?");
		editorPane.setEditable(false);
		editorPane.setBounds(10, 267, 268, 137);
		pnlStuff.add(editorPane);
		
		btnReturn = new JButton("Return");
		btnReturn.setBounds(106, 420, 81, 31);
		pnlStuff.add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlWelcome.setVisible(false);
				pnlRules.setVisible(false);
				pnlGeneric.setVisible(true);
				pnlStuff.setVisible(false);
			}
		});
		
		//"Powerbar ($50)", "Bike Chain ($50)",	"Pepper Spray ($75)","Hockey Stick ($150)",	"Corrupt Police Officer ($100)"
		btnUseItem = new JButton("Use Item");
		btnUseItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//need an event here to implement attack with item
				String selItem = cboStuff.getSelectedItem().toString();
				
				pnlGeneric.setVisible(true);
				pnlStuff.setVisible(false);
				pnlWelcome.setVisible(false);
				pnlRules.setVisible(false);
				
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
					game.badguy.setCurhealth(game.badguy.getCurhealth() - (attackval + 2));
					jepDialog.setText(jepDialog.getText() + "\n" + game.bob.useitem(thisItem) + attackval + " (+2) points");
				}
				else if (thisItem.getName().equals("Hockey Stick")) {
					attackval = game.bob.attack();
					game.badguy.setCurhealth(game.badguy.getCurhealth() - (attackval * 2));
					jepDialog.setText(jepDialog.getText() + "\n" + game.bob.useitem(thisItem) + attackval + " (x2) points!");
				}
				else if (thisItem.getName().equals("Corrupt Police Officer")) {
					game.badguy.setCurhealth(0);
					jepDialog.setText(jepDialog.getText() + "\n" + game.bob.useitem(thisItem));
				}
				//call function to calculate attack
				attackResponse();
				
				//loadScene("other"); //other as a parameter essentially means refresh the same panel/scene

			}
		});
		btnUseItem.setBounds(197, 420, 81, 31);
		pnlStuff.add(btnUseItem);
		
		cboStuff = new JComboBox();
		cboStuff.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				checkItemState();
				
			}
		});
		cboStuff.setModel(new DefaultComboBoxModel(itemNames));
		cboStuff.setToolTipText("Pick an Item");
		cboStuff.setBounds(10, 236, 268, 20);
		pnlStuff.add(cboStuff);
		
		lblItem = new JLabel("New label");
		
		lblItem.setBounds(157, 88, 121, 120);
		//imgIcon = new ImageIcon(getClass().getResource("/img/bikechain.png"));
		lblItem.setIcon(imgIcons[0]);
		pnlStuff.add(lblItem);
		
		lblAlreadyUsed = new JLabel("This item is already used");
		lblAlreadyUsed.setForeground(Color.RED);
		lblAlreadyUsed.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlreadyUsed.setBounds(142, 219, 136, 14);
		pnlStuff.add(lblAlreadyUsed);
		pnlStuff.setVisible(false);
		
		//Welcome Panel 
		pnlWelcome = new JPanel();
		pnlWelcome.setBounds(0, 0, 334, 472);
		frame.getContentPane().add(pnlWelcome);
		pnlWelcome.setLayout(null);
		loadWelcomePanel();
		
		pnlRules = new JPanel();
		pnlRules.setBounds(0, 0, 334, 472);
		frame.getContentPane().add(pnlRules);
		pnlRules.setLayout(null);
		
		JLabel lblRules = new JLabel();
		lblRules.setText("How to Play");
		lblRules.setFont(new Font("Hobo Std", Font.PLAIN, 36));
		lblRules.setBounds(10, 22, 216, 46);
		pnlRules.add(lblRules);
		
		JEditorPane dtrpnDraftYourGoal = new JEditorPane();
		dtrpnDraftYourGoal.setFocusable(false);
		dtrpnDraftYourGoal.setEditable(false);
		dtrpnDraftYourGoal.setText("DRAFT:\r\nYour goal is to win battles to complete jobs and make money. You start each battle with full health. You attack the opponent which reduces the opponent by a random value of 2-12 multiplied by the strength. After every time you attack they respond by attacking. Their attack on you is calculated the same way. You continue fighting until one of you dies or you decide to flee. If you die you lose the game. If you flee your health goes back to full before you return to fight again but you lose money. If you run completely out of money you also lose.\r\nIf you win you gain money and points and go to the next level. You can use your health to buy things to help you in future battles. Each thing that you own can be used once every battle. The trick is to buy things so that you can win battles but also not to buy too many things so that if you have to flee you don\u2019t go broke. \r\nBad guys don\u2019t flee by the way. They fight to the death.\r\n");
		dtrpnDraftYourGoal.setBounds(10, 79, 314, 327);
		pnlRules.add(dtrpnDraftYourGoal);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlWelcome.setVisible(true);
				pnlRules.setVisible(false);
				pnlGeneric.setVisible(false);
				pnlStuff.setVisible(false);
			}
		});
		btnBack.setBounds(235, 438, 89, 23);
		pnlRules.add(btnBack);
			
		
		pnlWelcome.setVisible(true);
		pnlRules.setVisible(false);
	}
	
	private void loadWelcomePanel(){
		JLabel lblTitle = new JLabel();
		lblTitle.setFont(new Font("Hobo Std", Font.PLAIN, 36));
		lblTitle.setBounds(10, 22, 216, 46);
		lblTitle.setText("Welcome"); //Welcome, Battle!, etc
		pnlWelcome.add(lblTitle);
		
		//Bob Icon
		JLabel lblBobImage = new JLabel();
		lblBobImage.setIcon(new ImageIcon(GameFrame.class.getResource("/img/bobsm.png")));
		lblBobImage.setBounds(10, 88, 95, 89);
		pnlWelcome.add(lblBobImage);
								
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
				game.setLevel(1);
				loadScene("battle");
				pnlGeneric.setVisible(true);
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
				pnlRules.setVisible(true);
			}
		});
		pnlWelcome.add(btnCredits);
		
		JButton btnRules = new JButton("Rules");
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pnlRules.setVisible(true);
				pnlWelcome.setVisible(false);
				pnlGeneric.setVisible(false);
				pnlStuff.setVisible(false);
			}
		});
		btnRules.setBounds(197, 336, 81, 31);
		pnlWelcome.add(btnRules);
	}
	
	private void loadScene(String scene){
		for (Component c : pnlGeneric.getComponents()) {
			c.setVisible(true);
			c.setEnabled(true);
		}
		//for item in panel, show all loop here
		if (!scene.equals("other")){
			lblTitle.setText(scene);
		}
		
		
		//hide panel items to fit for screen
		if (scene.equals("battle")){
        	btnNextLevel.setVisible(false);
        	btnBuyStuff.setVisible(false);
        	btnReturnToWelcome.setVisible(false);
        	jepDialog.setText(game.getBattleMsgList()[game.getLevel() - 1]);
        	
        	int badguyNum = game.getLevel() - 1;
        	//lblBadguyImage.setIcon(arg0); //need to create a list of badguy images
		}	
        if (scene.equals("battledone")){
        	btnNextLevel.setVisible(false);
        	btnBuyStuff.setVisible(false);
        	btnReturnToWelcome.setVisible(false);
        	btnAttack.setVisible(false);
        	btnUseStuff.setEnabled(false);
        	btnFlee.setEnabled(false);
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
        		jepDialog.setText(game.winMsgList[game.getLevel() - 1]);
        	}
        	else {
        		jepDialog.setText(game.getLossMsg());
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
        	//btnReturn.setVisible(true);
        	jepDialog.setText(game.getGameoverMsg());
        	        	
		}
		
		//things to do on generic panel regardless of scene
		lblBobHealth.setText("Health: " + game.bob.getCurhealth());
		lblBobStrength.setText("Strength: " + game.bob.getStrength());
		lblBobMoney.setText("Money: " + game.bob.getMoney());
		
		lblLevelScore.setText("Level: " + game.getLevel() + "    Score: " + game.getScore());
		
		lblBadguy.setText(game.badguy.getName());
    	lblBadguyHealth.setText("Health: " + game.badguy.getCurhealth());
    	lblBadguyStrength.setText("Strength: " + game.badguy.getStrength());
    	lblBadguyMoney.setText("Money: " + game.badguy.getMoney());
		
		
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
			return;
		}
		loadScene("other"); //other as a parameter essentially means refresh the same panel/scene
	}
	//update item on selection change and form load. Prevents item reuse.
	private void checkItemState(){
		lblItem.setIcon(imgIcons[cboStuff.getSelectedIndex()]);
				
		//find matching item
		Item selItem = game.bob.findItembyName(cboStuff.getSelectedItem().toString());
		editorPane.setText(selItem.getDescription());
		if (selItem.isUsed() == true){
			btnUseItem.setEnabled(false);
			lblAlreadyUsed.setVisible(true); 
		}
		else { 
			btnUseItem.setEnabled(true);
			lblAlreadyUsed.setVisible(false);
		}
	}
}
