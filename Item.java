package RPGGame;

public class Item {
	private String name;
	private String description;
	private Integer cost;
	private String usedMsg;
	private boolean owned = false;
	private boolean used = false;
	
	public Item(){} //default constructor
	
	public Item(String name, String description, Integer cost, String usedMsg){
		this.name = name;
		this.description = description;
		this.cost = cost;
		this.usedMsg = usedMsg;
	}
	
	
	public String utilize(){
		this.used = true;
		return this.usedMsg;
	}
	
	//Getters and Setters
	public boolean isOwned() {
		return owned;
	}
	public void setOwned(boolean owned) {
		this.owned = owned;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
