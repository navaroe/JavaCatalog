package objects;

public class Command {
	Catalog catalog = new Catalog();
	CategoryHandler categoryHandler = new CategoryHandler();
	
	public void read(String command) {
		String[] commandList = command.split(" ");
		int categoryId;
		switch (commandList[0]) {
			case ("help"):
				Console.help();
				break;
			case ("catalog"):
				switch (commandList[1]) {
					case ("pages"):
						System.out.println("Catalog contains " + catalog.countCatalogPages() + " pages");
						break;
					case ("page"):
						int pageNumber = Integer.parseInt(commandList[2]);
						catalog.showCatalogPage(pageNumber);
						break;
					case ("add"):
						try{
				            categoryId = Integer.valueOf(commandList[2]);
				            if (categoryHandler.categoryExist(categoryId)) {
				            	if (catalog.categoryExist(categoryId)) {
				            		System.out.println("Selected category already added to catalog");
				            	} else {
				            		catalog.categoryAdd(categoryHandler.categorySelect(categoryId));
				            		System.out.println("Category " + categoryHandler.categorySelect(categoryId).getCategoryName() + " added to catalog");
				            	}
				            } else {
				            	System.out.println("Selected category does not exist");
				            }
				            
				        }
				        catch (NumberFormatException error){
				        	System.out.println("Input error");
				        }						
						break;
					case ("remove"):
						try{
				            categoryId = Integer.valueOf(commandList[2]);
				            if (categoryHandler.categoryExist(categoryId)) {
				            	if (catalog.categoryExist(categoryId)) {
				            		catalog.categoryRemove(categoryHandler.categorySelect(categoryId));
				            		System.out.println("Category " + categoryHandler.categorySelect(categoryId).getCategoryName() + " removed from catalog");
				            		
				            	} else {
				            		System.out.println("Selected category is not in the catalog");
				            	}
				            } else {
				            	System.out.println("Selected category does not exist");
				            }				            
				        }
				        catch (NumberFormatException error){
				            System.out.println("Input error");
				        }
						break;					
					default:
						System.out.println("Command incorrect");
						break;
					}
				break;
			case ("category"):
				switch (commandList[1]) {
					case ("pages"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryHandler.categoryExist(categoryId)) {
				            	if (categoryHandler.categorySelect(categoryId).categoryNotEmpty()) {
				            		System.out.println("Category " + categoryHandler.categorySelect(categoryId).getCategoryName() + " contains " + categoryHandler.categorySelect(categoryId).countCategoryPages() + " pages");
				            	} else {
				            		System.out.println("Category empty");
				            	}					            
				            } else {
				            	System.out.println("Selected category does not exist");
				            }				            
				        }
				        catch (NumberFormatException error){
				        	System.out.println("Input error");
				        }						
						break;
					case ("show"):
						switch(commandList[2]) {
							case ("all"):
								categoryHandler.categoryFullList();
								break;
							case ("page"):	
								if (commandList.length < 5) {
									System.out.println("Command incorrect");
								} else {
									try{
										categoryId = Integer.parseInt(commandList[3]);									
										int pageNumber = Integer.parseInt(commandList[4]);
										if (categoryHandler.categoryExist(categoryId)) {
							            	if (categoryHandler.categorySelect(categoryId).categoryNotEmpty()) {						            		
							            		categoryHandler.categorySelect(categoryId).showPositionPage(pageNumber);						            		
							            	} else {
							            		System.out.println("Category empty");
							            	}					            
							            } else {
							            	System.out.println("Selected category does not exist");
							            }
									}
								    catch (NumberFormatException error){
							        	System.out.println("Input error");
								    }		
								}
								break;
							}
							
				        
						break;
					case ("create"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryId < 0) {
				            	System.out.println("Category ID cannot be negative");
				            } else {
				            	if (commandList[3].length()>255) {
				            		System.out.println("Category name length exceeded");
				            	} else {
				            		categoryHandler.categoryCreate(categoryId, commandList[3]);
						            System.out.println("Category " + commandList[3] + " created");
				            	}
				            }				            
				        }
				        catch (NumberFormatException error){
				        	System.out.println("Input error");
				        }
						break;
					case ("rename"):
						Category renamedCategory;
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryHandler.categoryExist(categoryId)) {
					            renamedCategory = categoryHandler.categorySelect(categoryId);
					            if (commandList[3].length()>255) {
				            		System.out.println("Category name length exceeded");
				            	} else {
				            		renamedCategory.setCategoryName(commandList[3]);
				            		System.out.println("Category " + categoryId + " renamed to " + commandList[3]);
				            	}
				            } else {
				            	if (categoryId < 0) {
					            	System.out.println("Category ID cannot be negative");
					            } else {
					            	if (commandList[3].length()>255) {
					            		System.out.println("Category name length exceeded");
					            	} else {
					            		categoryHandler.categoryCreate(categoryId, commandList[3]);
							            System.out.println("Category " + commandList[3] + " created");
					            	}
					            }
				            }
				        }
				        catch (NumberFormatException error){
				            System.out.println("Input error");
				        }
						break;
					case ("add"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryHandler.categorySelect(categoryId).accessPositionHandler().positionExist(commandList[3])) {
					            if (categoryHandler.categorySelect(categoryId).positionExist("commandList[3]")) {
					            	System.out.println("Selected position alreaddy in a category");
					            } else {
						            if (!categoryHandler.categorySelect(categoryId).categoryNotEmpty()) {
						            	catalog.categoryAdd(categoryHandler.categorySelect(categoryId));
						            }
						            categoryHandler.categorySelect(categoryId).positionAdd(categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]));
						            System.out.println("Position " + commandList[3] + " added to category " + categoryHandler.categorySelect(categoryId).getCategoryName());
					            }
				            } else {
				            	System.out.println("Seleted position does not exist");
				            }
				        }
				        catch (NumberFormatException error){
				        	System.out.println("Input error");
				        }
						break;
					case ("remove"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryHandler.categorySelect(categoryId).accessPositionHandler().positionExist(commandList[3])) {
				            	if (categoryHandler.categorySelect(categoryId).positionExist("commandList[3]")) {
						            categoryHandler.categorySelect(categoryId).positionRemove(categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]));
						            System.out.println("Position " + commandList[3] + " removed from category " + categoryHandler.categorySelect(categoryId).getCategoryName());
						            if (!categoryHandler.categorySelect(categoryId).categoryNotEmpty()) {
						            	catalog.categoryRemove(categoryHandler.categorySelect(categoryId));
						            } else {
						            	System.out.println("Selected position is not in a category");
						            }
				            	}
				            } else {
				            	System.out.println("Seleted position does not exist");
				            }
				        }
				        catch (NumberFormatException error){
				        	System.out.println("Input error");
				        }
						break;
					default:
						System.out.println("Command incorrect");
						break;
				}
				break;
			case ("position"):
				switch (commandList[1]) {
					case ("create"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            int positionUnitNumber = Integer.parseInt(commandList[4]);
				            float positionPrice = Float.parseFloat(commandList[5]);
				            int positionQuantity = Integer.parseInt(commandList[6]);
				            if (categoryHandler.categorySelect(categoryId).accessPositionHandler().positionExist(commandList[3])) {
				            	System.out.println("Position with this name already exists"); }
				            else {
				            	if (commandList[3].length() > 255) {
					            	System.out.println("Position name length exceeded");
				            	} else {						            
						            categoryHandler.categorySelect(categoryId).accessPositionHandler().positionCreate(commandList[3], positionUnitNumber, positionPrice, positionQuantity);	
						            System.out.println("Position " + commandList[3] + " created in category " + categoryHandler.categorySelect(categoryId).getCategoryName());
						            if (positionQuantity > 0) {
							            if (!categoryHandler.categorySelect(categoryId).categoryNotEmpty()) {
							            	catalog.categoryAdd(categoryHandler.categorySelect(categoryId));					            	
							            }						            						            												            
							            categoryHandler.categorySelect(categoryId).positionAdd(categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]));							            
						            }
						        }					            
				            }
				        }
				        catch (NumberFormatException error){
				        	System.out.println("Input error");
				        }
						break;
					case ("show"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (commandList[3].equals("all")) {
								categoryHandler.categorySelect(categoryId).accessPositionHandler().positionFullList();;
							} else {
								if (categoryHandler.categorySelect(categoryId).accessPositionHandler().positionExist(commandList[3])) {
							        categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).showPosition();;							        	
								} else {
									System.out.println("Selected position does not exist");
								}
							}
				        }
				        catch (NumberFormatException error){
				            System.out.println("Input error");
				        }					
						break;
					case ("price"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryHandler.categorySelect(categoryId).accessPositionHandler().positionExist(commandList[3])) {
				            	float newPositionPrice = Float.parseFloat(commandList[4]);
				            	if (newPositionPrice >= 0) {
				            		categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).setPositionPrice(newPositionPrice);
				            		System.out.println("Set price " + commandList[4] + " to position " + categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).getPositionName());
				            	} else {
				            		System.out.println("New price incorrect");
				            	}
				            } else {
				            	System.out.println("Selected position does not exist");
				            }
				        }
				        catch (NumberFormatException error){
				            System.out.println("Input error");
				        }
						break;
					case ("increase"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryHandler.categorySelect(categoryId).accessPositionHandler().positionExist(commandList[3])) {
				            	int selectedPositionQuantity = categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).getPositionQuantity();
				            	int addedAmount = Integer.parseInt(commandList[4]);
				            	if (selectedPositionQuantity == 0) {
				            		if (!categoryHandler.categorySelect(categoryId).categoryNotEmpty()) {
				            			catalog.categoryAdd(categoryHandler.categorySelect(categoryId));
				            		}
				            		categoryHandler.categorySelect(categoryId).positionAdd(categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]));
				            	}
				            	if (addedAmount > 0) {
				            		categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).setPositionQuantity(selectedPositionQuantity + addedAmount);
				            		System.out.println("Position quantity " + categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).getPositionName() + " increased to " + String.valueOf(selectedPositionQuantity + addedAmount));
				            	} else {
				            		System.out.println("Added amount must be a positive integer");
				            	}
				            	
				            } else {
				            	System.out.println("Selected position does not exist");
				            }
				        }
				        catch (NumberFormatException error){
				            System.out.println("Input error");
				        }
						break;
					case ("decrease"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryHandler.categorySelect(categoryId).accessPositionHandler().positionExist(commandList[3])) {
				            	int selectedPositionQuantity = categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).getPositionQuantity();
				            	int subtractedAmount = Integer.parseInt(commandList[4]);				            	
				            	if (subtractedAmount > 0) {
				            		if (subtractedAmount <= selectedPositionQuantity) {
				            			categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).setPositionQuantity(selectedPositionQuantity - subtractedAmount);
				            			System.out.println("Position quantity " + categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).getPositionName() + " decreased to " + String.valueOf(selectedPositionQuantity - subtractedAmount));
				            			if (selectedPositionQuantity - subtractedAmount == 0) {
						            		categoryHandler.categorySelect(categoryId).positionRemove(categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]));
						            		if (!categoryHandler.categorySelect(categoryId).categoryNotEmpty()) {
						            			catalog.categoryRemove(categoryHandler.categorySelect(categoryId));
						            		}				            		
						            	}
				            		} else {
				            			System.out.println("You cannot reduce the number of positions by more than you have");
				            		}
				            	} else {
				            		System.out.println("Reduced amount must be a positive integer");
				            	}				            	
				            } else {
				            	System.out.println("Selected position does not exist");
				            }
				        }
				        catch (NumberFormatException error){
				            System.out.println("Input error");
				        }
						break;
					default:
						System.out.println("Command incorrect");
						break;
				}
				break;
			default:
				System.out.println("Command incorrect");
				break;
			}	
	}
}
