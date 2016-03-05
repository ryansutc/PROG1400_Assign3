package RPGGame;

public class Bob extends Character {
	public Item[] items = new Item[5];

	public Bob(){
		//"Powerbar ($50)", "Bike Chain ($50)",	"Pepper Spray ($75)","Hockey Stick ($150)",	"Corrupt Police Officer ($100)"
		
		this.setName("Bob");
		setItems();
	}
	public String useitem(Item item){
		//TODO
	   return item.utilize();
	}
	
	private void setItems(){ //initial setup of items
		//items = new Item[4];
		String[][] itemList = new String[5][4];
		
		itemList[0][0] = "Bike Chain";
		itemList[0][1] = "A Bike Chain doesn't only keep your bike safe it is a deadly weapon. When used it will add 3 to your next attack";
		itemList[0][2] = "25";
		itemList[0][3] = "You use the bike chain and score a hit of ";
		
		itemList[1][0] = "Hockey Stick";
		itemList[1][1] = "A hockey stick will double your attack for the next attack.";
		itemList[1][2] = "50";
		itemList[1][3] = "You wield the hockey stick and score a hit of ";
		
		itemList[2][0] = "Pepper Spray";
		itemList[2][1] = "Pepper spray will reduce all subsequent attacks from opponent by 50%.";
		itemList[2][2] = "100";
		itemList[2][3] = "You use the pepper spray, blinding your enemy and reducing their subsequent attacks!";
		
		itemList[3][0] = "Corrupt Police Officer";
		itemList[3][1] = "Will beat opponent for you no matter what but will take another $50 from you every time you use him.";
		itemList[3][2] = "50";
		itemList[3][3] = "You bribe a corrupt cop and have him take care of your enemy for you for $50 bucks";
		
		itemList[4][0] = "Powerbar";
		itemList[4][1] = "Powerbar will revive your health to full";
		itemList[4][2] = "50";
		itemList[4][3] = "You mow down a powerbar and get yourself back to full health. Rad!";
		

		for (int x = 0, len =5; x<len; x++){
		
			items[x] = new Item(itemList[x][0], itemList[x][1],Integer.parseInt(itemList[x][2]), itemList[x][3]);
			
		}
		
	}

	public Item findItembyName(String name){
		if (name.indexOf("(") != -1){
			name = name.substring(0, name.indexOf("("));
		}
		name = name.replace(" ", "").toLowerCase();
		
		for (Item item : this.items){
			System.out.println(item.getName().replace(" ","").toLowerCase());
	        if (item.getName().replace(" ", "").toLowerCase().equals(name)){
	        	System.out.println("Found item: " + name); 
	        	return item;
	        }
		} 
		return null; //throw error

	}
}
