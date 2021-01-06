package model;

public class Clothing extends Item {
	
	private ClothingSizes size;

	public Clothing(int itemId, String itemName, int itemPrice, String itemDesc) {
		super(itemId, itemName, itemPrice, itemDesc);
	}

	public ClothingSizes getSize() {
		return size;
	}

	public void setSize(ClothingSizes size) {
		this.size = size;
	}
	
	

}
