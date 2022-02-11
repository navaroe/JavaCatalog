package objects;

import java.util.ArrayList;

public class Category {
	int categoryId;
	String categoryName;
	PositionHandler positionHandler = new PositionHandler();
	ArrayList<Position> positionList = new ArrayList<Position>();

	public Category(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public PositionHandler accessPositionHandler() {
		return(this.positionHandler);
	}
	
	public int countCategoryPages() {
		int pagesCounter = 0;
		if (positionList.size() > 0) {
			if (positionList.size() > 10) {				
				if (positionList.size() % 10 == 0 ) {
					pagesCounter = positionList.size() / 10;
				} else {
					pagesCounter = positionList.size() / 10 + 1;
				}
			} else {
				pagesCounter = 1;
			}
		}
		return pagesCounter;
	}
	public void showPositionPage(int pageNumber) {
		CategoryPageBuilder builder = new CategoryPageBuilder(positionList);
		builder.showPage(pageNumber);
	}
	
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
	
	public void positionAdd(Position position) {
		positionList.add(position);}
	
	public void positionRemove(Position position) {
		positionList.remove(position);}
	
	public boolean categoryNotEmpty() {
		if (positionList.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
	
}
