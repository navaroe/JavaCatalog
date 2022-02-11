package objects;

import java.util.ArrayList;

public class Catalog {
	ArrayList<Category> categoryList = new ArrayList<Category>();
	
	public void showCatalogPage(int pageNumber) {
		CatalogPageBuilder builder = new CatalogPageBuilder(categoryList);
		builder.showPage(pageNumber);
	}
	
	public int countCatalogPages() {
		int pagesCounter = 0;
		if (categoryList.size() > 0) {
			if (categoryList.size() > 10) {				
				if (categoryList.size() % 10 == 0 ) {
					pagesCounter = categoryList.size() / 10;
				} else {
					pagesCounter = categoryList.size() / 10 + 1;
				}
			} else {
				pagesCounter = 1;
			}
		}
		return pagesCounter;
	}
	
	public void categoryAdd(Category category) {
		categoryList.add(category);}
	
	public void categoryRemove(Category category) {
		categoryList.remove(category);}
	
	public boolean categoryExist(int categoryId) {
		boolean checker = false;
		for (int counter = 0; counter < categoryList.size(); counter++) {
			if (categoryList.get(counter).getCategoryId() == categoryId) {
				checker = true;
				break;
			}
		}
		return checker;
	}

}
