package model;

import java.util.ArrayList;

public class Item {

	private int itemId;
	private String itemName;
	private int itemPrice;
	private String itemDesc;
	private boolean hasVariant;
	private boolean hasXS;
	private boolean hasS;
	private boolean hasM;
	private boolean hasL;
	private boolean hasXL;
	private ArrayList<String> variants;

	public Item(int itemId, String itemName, int itemPrice, String itemDesc, boolean hasVariant, boolean hasXS,
			boolean hasS, boolean hasM, boolean hasL, boolean hasXL) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemDesc = itemDesc;
		this.hasVariant = hasVariant;
		this.hasXS = hasXS;
		this.hasS = hasS;
		this.hasM = hasM;
		this.hasL = hasL;
		this.hasXL = hasXL;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public boolean isHasVariant() {
		return hasVariant;
	}

	public void setHasVariant(boolean hasVariant) {
		this.hasVariant = hasVariant;
	}

	public boolean isHasXS() {
		return hasXS;
	}

	public void setHasXS(boolean hasXS) {
		this.hasXS = hasXS;
	}

	public boolean isHasS() {
		return hasS;
	}

	public void setHasS(boolean hasS) {
		this.hasS = hasS;
	}

	public boolean isHasM() {
		return hasM;
	}

	public void setHasM(boolean hasM) {
		this.hasM = hasM;
	}

	public boolean isHasL() {
		return hasL;
	}

	public void setHasL(boolean hasL) {
		this.hasL = hasL;
	}

	public boolean isHasXL() {
		return hasXL;
	}

	public void setHasXL(boolean hasXL) {
		this.hasXL = hasXL;
	}

	public ArrayList<String> getVariants() {
		return variants;
	}

	public void setVariants(ArrayList<String> variants) {
		this.variants = variants;
	}

	public ArrayList<String> checkForVariants() {

		ArrayList<String> variants = new ArrayList<String>();

		if (hasVariant == true) {
			if (hasXS == true) {
				variants.add("XS");
			}

			if (hasS == true) {
				variants.add("S");
			}

			if (hasM == true) {
				variants.add("M");
			}

			if (hasL == true) {
				variants.add("L");
			}

			if (hasXL == true) {
				variants.add("XL");
			}
		}
		return variants;
	}

}
