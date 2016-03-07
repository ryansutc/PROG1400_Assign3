package RPGGame;

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Game {

	private int score = 0;
	private int level = 1;
	public String curscene = "other";
	public String prevscene = "other";
	
	private String itemList[][]; //items with names, descriptions, costs
	public String winMsgList[]; //win messages for each level
	private String battleMsgList[] = new String[4]; //battle messages for each battle level screen
	private String lossMsg; //generic loss message
	private String gameoverMsg; //generic game over message
	private String attackMsg;
	
	private String welcomeMsg; //welcome screen message
	private String rulesMsg; //rules screen message
	private String creditMsg; //credits screen message
	public String[][] badguyList = new String[4][4];
	private Icon badguyIcons[] = {new ImageIcon(getClass().getResource("/img/eviltaxidriver.png")), 
			new ImageIcon(getClass().getResource("/img/evilsoccermom.png")),
			new ImageIcon(getClass().getResource("/img/rabiddog.png")),
			new ImageIcon(getClass().getResource("/img/bikethief.png"))};
    
	GUI gui;
	public Bob bob = new Bob(); //game has a main character
	public BadGuy badguy; //game has a badguy
	
	//MAIN-----------------
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game game = new Game();
					
					
					
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Game() {
		
		
		winMsgList = new String[4];
		
		winMsgList[0] = "You’ve done a good job defeating an enemy getting in your way of your first delivery. You’re next job is going to be harder though. Get yourself ready.";
		winMsgList[1] = "You’ve conquered another enemy and completed another job. You’re on a roll but there’s more work to be done. The next job comes with greater risk but higher reward.";
		winMsgList[2] = "You’ve done well. The boss is almost thinking about giving you a raise. But there’s one more task to complete and bad guy to conquer. Get ready.";
		winMsgList[3] = "You’ve really proved yourself! The boss is has promoted you to senior bike courier. You can call it a week and go home and enjoy the weekend. You’ve still got [money] in your pocket and thus have earned a total of [points]. Good game!";
		
		setLossMsg("You fled like a coward but saved your own life. You health is once again full but your wallet is a bit lighter. Unfortunately those packages aren’t gonna deliver themselves. Get ready to go at it again and prove your worth!");
		setGameoverMsg("You’re too beat up to continue in this line of work. Time to retire. Oh well, I hear they’re hiring for the graveyard shift over at McDonalds. Game Over.");
		setWelcomeMsg("You are Bob the Bike Courier, the new bike courier on the block. You need to battle adverseraries who are preventing you from doing your job making deliveries and travelling up and down the cities concrete jungle.");
		
		setBadGuyList();
		
		//setBobItems(); //create items and assign to bob character (see method below)
		
		gui = new GUI(this);
	}
	
		
	private void setBadGuyList(){
		//name, curhealth, strength, money, icon
		badguyList[0][0] = "Evil Taxi Driver";
		badguyList[0][1] = "20";
		badguyList[0][2] = "1";
		badguyList[0][3] = "30";
		
		badguyList[1][0] = "Evil Soccer Mom";
		badguyList[1][1] = "25";
		badguyList[1][2] = "2";
		badguyList[1][3] = "20";
		
		badguyList[2][0] = "Rabid Dog";
		badguyList[2][1] = "50";
		badguyList[2][2] = "3";
		badguyList[2][3] = "30";
		
		badguyList[3][0] = "Bicycle Thief";
		badguyList[3][1] = "35";
		badguyList[3][2] = "4";
		badguyList[3][3] = "50";
				
	}
	/*setLevel does a lot of things:
	 * - updates the level
	 * - also calls methods to update bob's stats
	 * - also updates game score
	 * - returns a msg about the level change
	 */
	public String setLevel(int level){
		String msg = "";
		if (level == 1){
			bob.setMoney(20);
		}
		else {
			bob.setMoney(bob.getMoney()+ badguy.getMoney());
		}
		
		bob.setStrength(level);
		this.level = level;
		if (level != 1){
			msg = "<html>Strength: +1 <br/>Money: +" + badguy.getMoney() +
					"<br/>";
		}
		setBadGuy(level - 1);
		//update score, level, health, etc.
		if (level != 1){
			this.updateScore();
			if ((badguy.getCurhealth() - 5) > bob.getMaxhealth()){
				msg = msg + "Health is now: " + (badguy.getCurhealth()-5) + "</html>";
			}
			else {msg = msg + "</html>";}
			
			bob.setCurhealth(badguy.getCurhealth()-5);
			bob.setMaxhealth(badguy.getMaxhealth()-5); //when level changes match bob's curhealth & maxhealth to badguy.
		}
		else {
			bob.setCurhealth(20);
		}
		
		//reset all items to available
		for (Item i : bob.items){
			i.setUsed(false);
		}
		
		
		return msg;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	//autoupdates score on level change
	private void updateScore(){
		int score = this.getScore() + 100 +
				this.bob.getCurhealth() + 
				(this.bob.getMoney() * 2);
		this.setScore(score);
	}
    
	//at end of game, converts your money to score
	public int getFinalScore() {
		return getScore() + bob.getMoney();
	}
	
	public String getLossMsg() {
		return lossMsg;
	}

	public void setLossMsg(String lossMsg) {
		this.lossMsg = lossMsg;
	}

	public String getGameoverMsg() {
		return gameoverMsg;
	}

	public void setGameoverMsg(String gameoverMsg) {
		this.gameoverMsg = gameoverMsg;
	}
	//returns a string with a battle message.
	public String[] getBattleMsgList() {
		//level 1: Evil Taxi Driver
		this.battleMsgList[0] = "Oh no! You are attacked by a crazy taxi driver. You aren't gonna let this guy push you off the road are you? \n Battle or Flee?";
		//level 2: Pyscho Soccer Mom
		this.battleMsgList[1] = "What the what? You are attacked and pushed off the road by a crazy soccer mom in an SUV. You gotta take her on or you’ll never make your delivery. \n Battle or Flee?";
		//Level 3: Rabid Dog
		this.battleMsgList[2] = "Jeez Louise! Somebodies pyscho dog gets loose and starts to attack your ankles. You gotta show this dog who’s the really alpha if you wanna make this delivery. \n Battle or Flee?";
		//Level 4: Bicycle Thief
		this.battleMsgList[3] = " Holy Moly! You’ve encountered the most evil of all bike courier villans. A bicycle thief is trying to snag your ride. You gotta lay down the law if you wanna get this job done. \n Battle or Flee?";
		
		return battleMsgList;
	}

	public int getLevel() {
		return level;
	}

	public String getWelcomeMsg() {
		return welcomeMsg;
	}

	public void setWelcomeMsg(String welcomeMsg) {
		this.welcomeMsg = welcomeMsg;
	}

	public BadGuy getBadGuy(){
		return this.badguy;
	}
	
	//load the new bad guy for the level based on the array
	public void setBadGuy(int level){
		badguy = new BadGuy(badguyList[level][0], 
				Integer.parseInt(badguyList[level][1]), 
				Integer.parseInt(badguyList[level][2]),
				Integer.parseInt(badguyList[level][3]),
				badguyIcons[level]);
		if (level == 3){
			badguy.setDeathMsg(badguy.getName() + " says, 'Arg. How could this be my end?'");
		}
		if (level == 2){
			badguy.setDeathMsg(badguy.getName() + " says, You've beaten me. Err, I mean, woof woof.");
		}
	}

	public String getAttackMsg(String attacker, String attacked, int hitval) {
		String attackMsg = attacker + " hits " + attacked + " and scores " + hitval + " points";
		return attackMsg;
	}

	public void setAttackMsg(String attackMsg) {
		this.attackMsg = attackMsg;
	}


	
	
}
