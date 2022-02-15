package objects;

import java.util.ArrayList;

public class CatalogPageBuilder {
	ArrayList<Category> categoryList = new ArrayList<Category>();
	int categoryListLength;
	int pageLength = 10;

	public CatalogPageBuilder(ArrayList<Category> categoryList) {
		this.categoryList = categoryList;
		this.categoryListLength = categoryList.size();
	}
		
	public void showPage(int pageNumber) {
		int selectedPage = pageNumber - 1;
		int pagesQuantity = categoryListLength / pageLength;
		if (selectedPage > pagesQuantity) {
			System.out.println("Page not found");
		} else {
			if (categoryListLength > pageLength) {	
				System.out.println("ID\tCategory name");
				if (selectedPage == pagesQuantity) {
					for (int counter = 0; counter < categoryListLength - selectedPage * pageLength ; counter++)
						System.out.println(categoryList.get(counter + selectedPage * pageLength).getCategoryId() + " " + categoryList.get(counter + selectedPage * pageLength).getCategoryName());
				} else {
					for (int counter = 0; counter < pageLength ; counter++)				
						System.out.println(categoryList.get(counter + selectedPage * pageLength).getCategoryId() + " " + categoryList.get(counter + selectedPage * pageLength).getCategoryName());
				}					
			} else {
				System.out.println("ID\tCategory name");
				for (int counter = 0; counter < categoryListLength ; counter++)
					System.out.println(categoryList.get(counter).getCategoryId() + "\t" + categoryList.get(counter).getCategoryName());
			}
		}
	}	
}

