package RPGGame;

import javax.swing.Icon;

public class BadGuy extends Character {
	private String deathMessage = "You've beaten me.";
	private boolean weakened = false;
	private Icon icon; //badguy icon
	
	public BadGuy(String name, int maxhealth, int strength, int money, Icon icon){
		//overridden constructor, set your own parameters
		this.setMaxhealth(maxhealth);
		this.setCurhealth(maxhealth);
		this.setStrength(strength);
		this.setMoney(money);
		this.setName(name);
		this.setIcon(icon);
	}

	
	public String getDeathMsg() {
		return deathMessage;
	}

	public void setDeathMsg(String deathMsg) {
		this.deathMessage = deathMsg;
	}
	
	//@Override
	public int attack(){
		int a = super.attack();
		if (this.isWeakened() == true){
			a = a /2;
		}
		//commence other if statements as needed :(
		
		return a;
	}


	public boolean isWeakened() {
		return weakened;
	}


	public void setWeakened(boolean weakened) {
		this.weakened = weakened;
	}


	public Icon getIcon() {
		return icon;
	}


	public void setIcon(Icon icon) {
		this.icon = icon;
	}
	
}
