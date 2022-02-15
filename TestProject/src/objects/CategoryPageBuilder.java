package objects;

import java.util.ArrayList;

public class CategoryPageBuilder {
	ArrayList<Position> positionList = new ArrayList<Position>();
	int positionListLength;
	int pageLength = 10;

	public CategoryPageBuilder(ArrayList<Position> positionList) {
		this.positionList = positionList;
		this.positionListLength = positionList.size();
	}
		
	public void showPage(int pageNumber) {
		int selectedPage = pageNumber - 1;
		int pagesQuantity = positionListLength / pageLength;
		if (selectedPage > pagesQuantity) {
			System.out.println("Page not found");
		} else {
			if (positionListLength > pageLength) {	
				System.out.println("Category name Price Quantity");
				if (selectedPage == pagesQuantity) {
					for (int counter = 0; counter < positionListLength - selectedPage * pageLength ; counter++)
						System.out.println(positionList.get(counter + selectedPage * pageLength).getPositionName() + "\t" + positionList.get(counter + selectedPage * pageLength).getPositionPrice() + "\t" + positionList.get(counter + selectedPage * pageLength).getPositionQuantity());
				} else {
					for (int counter = 0; counter < pageLength ; counter++)				
						System.out.println(positionList.get(counter + selectedPage * pageLength).getPositionName() + "\t" + positionList.get(counter + selectedPage * pageLength).getPositionPrice() + "\t" + positionList.get(counter + selectedPage * pageLength).getPositionQuantity());
				}					
			} else {
				System.out.println("Category name Price Quantity");
				for (int counter = 0; counter < positionListLength ; counter++)
					System.out.println(positionList.get(counter).getPositionName() + "\t" + positionList.get(counter).getPositionPrice() + "\t" + positionList.get(counter).getPositionQuantity());
			}
		}
	}
}
