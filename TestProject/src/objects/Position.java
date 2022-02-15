package objects;

public class Position {
	String positionName;
	String unit;
	float positionPrice;
	int positionQuantity;
	
	public Position(String positionName, int unitNumber, float positionPrice, int positionQuantity) {
		super();
		this.positionName = positionName;
		this.unit = Console.unitNamesList[unitNumber];
		this.positionPrice = positionPrice;
		this.positionQuantity = positionQuantity;
	}	
	public String getUnit() {
		return unit;
	}
	public void setUnit(int unitNumber) {			
		this.unit = Console.unitNamesList[unitNumber];
	}	
	public Position(String positionName) {
		super();
		this.positionName = positionName;
	}
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public float getPositionPrice() {
		return positionPrice;
	}
	public void setPositionPrice(float positionPrice) {
		this.positionPrice = positionPrice;
	}
	public int getPositionQuantity() {
		return positionQuantity;
	}
	public void setPositionQuantity(int positionQuantity) {
		this.positionQuantity = positionQuantity;
	}
	
	public void showPosition() {
		String formatedPrice = String.format("%.2f", this.positionPrice);
		System.out.println("Position: " + this.positionName + " Quantity: " + this.positionQuantity + " " + this.unit + " Price: " + formatedPrice);
	}
}
