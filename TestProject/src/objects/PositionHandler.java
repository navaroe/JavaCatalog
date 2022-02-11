package objects;

import java.util.ArrayList;

public class PositionHandler {
	ArrayList<Position> positionList = new ArrayList<Position>(); 
	
	public boolean positionExist(String positionName) {
		boolean checker = false;
		for (int counter = 0; counter < positionList.size(); counter++) {
			if (positionList.get(counter).getPositionName().equals(positionName)) {
				checker = true;	
				break;
			}
		}
		return checker;
	}
	
	public void positionCreate(String positionName, int unitNumber, float positionPrice, int positionQuantity) {
		Position newPosition = new Position(positionName, unitNumber, positionPrice, positionQuantity);
		positionList.add(newPosition);
	}
	
	public Position positionSelect(String positionName) {
		Position selectedPosition = null;
		for (int counter = 0; counter < positionList.size(); counter++) {
			if (positionList.get(counter).getPositionName().equals(positionName)) {
				selectedPosition = positionList.get(counter);				
			}
		}
		return selectedPosition;		
	}
	
	public void positionFullList() {
		for (int counter = 0; counter < positionList.size(); counter++) {
			System.out.println(positionList.get(counter).getPositionName());
		}
	}
	
	public void positionSetPrice(String positionName, float newPrice) {
		
	}
}
