package RPGGame;

import java.util.Random;

public abstract class Character {
	private String name;
	private int curhealth = 20;
	private int maxhealth = 20;
	private int strength = 1;
	private int money = 20;
	
	public Character(){
		//default constructor, explicitly stated
	}
		
	//the attack calculator / dice roll simulation
	public int attack(){
		Random rand = new Random();
		int die1 = rand.nextInt(6) + 1;
		int die2 = rand.nextInt(6) + 1;
		
		return die1 + die2;
	}

	//getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStrength() {
		return strength;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getMaxhealth() {
		return maxhealth;
	}
	public void setMaxhealth(int maxhealth) {
		this.maxhealth = maxhealth;
	}
	public int getCurhealth() {
		return curhealth;
	}
	//makes sure health cannot be negative
	public void setCurhealth(int curhealth) {
		if (curhealth > 0){
			this.curhealth = curhealth;
		}
		else {
			this.curhealth = 0;
		}
	}
	
}
