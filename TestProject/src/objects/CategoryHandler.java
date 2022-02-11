package objects;

import java.util.ArrayList;

public class CategoryHandler {
	ArrayList<Category> categoryList = new ArrayList<Category>(); 
	
	public void categoryCreate(int categoryId, String categoryName) {
		Category newCategory = new Category(categoryId, categoryName);
		categoryList.add(newCategory);
	}
	
	public Category categorySelect(int categoryId) {
		Category selectedCategory = null;
		for (int counter = 0; counter < categoryList.size(); counter++) {
			if (categoryList.get(counter).getCategoryId() == categoryId) {
				selectedCategory = categoryList.get(counter);
				break;
			}
		}
		if (selectedCategory == null) {
			System.out.println("Категория с данным ID не найдена");
		} 
		return selectedCategory;
	}
	
	public void categoryFullList() {
		for (int counter = 0; counter < categoryList.size(); counter++) {
			System.out.println(categoryList.get(counter).getCategoryId() + " " + categoryList.get(counter).getCategoryName());
		}
	}
	
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
