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
						System.out.println("� �������� " + catalog.countCatalogPages() + " �������");
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
				            		System.out.println("����� ��������� ��� ��������� � �������");
				            	} else {
				            		catalog.categoryAdd(categoryHandler.categorySelect(categoryId));
				            	}
				            } else {
				            	System.out.println("����� ��������� �� ����������");
				            }
				            
				        }
				        catch (NumberFormatException error){
				        	System.out.println("������ � ����� ���� ���������");
				        }						
						break;
					case ("remove"):
						try{
				            categoryId = Integer.valueOf(commandList[2]);
				            if (categoryHandler.categoryExist(categoryId)) {
				            	if (catalog.categoryExist(categoryId)) {
				            		catalog.categoryRemove(categoryHandler.categorySelect(categoryId));
				            		
				            	} else {
				            		System.out.println("����� ��������� ����������� � ��������");
				            	}
				            } else {
				            	System.out.println("����� ��������� �� ����������");
				            }				            
				        }
				        catch (NumberFormatException error){
				            System.out.println("������ � ����� ���� ���������");
				        }
						break;					
					default:
						System.out.println("������� �����������");
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
				            		System.out.println("� �������� " + categoryHandler.categorySelect(categoryId).countCategoryPages() + " �������");
				            	} else {
				            		System.out.println("��������� �����");
				            	}					            
				            } else {
				            	System.out.println("��������� � ����� ID �� ����������");
				            }				            
				        }
				        catch (NumberFormatException error){
				        	System.out.println("������ � ����� ���� ���������");
				        }						
						break;
					case ("show"):
						switch(commandList[2]) {
							case ("all"):
								categoryHandler.categoryFullList();
								break;
							case ("page"):	
								if (commandList.length < 5) {
									System.out.println("������� �����������");
								} else {
									try{
										categoryId = Integer.parseInt(commandList[3]);									
										int pageNumber = Integer.parseInt(commandList[4]);
										if (categoryHandler.categoryExist(categoryId)) {
							            	if (categoryHandler.categorySelect(categoryId).categoryNotEmpty()) {						            		
							            		categoryHandler.categorySelect(categoryId).showPositionPage(pageNumber);						            		
							            	} else {
							            		System.out.println("��������� �����");
							            	}					            
							            } else {
							            	System.out.println("��������� � ����� ID �� ����������");
							            }
									}
								    catch (NumberFormatException error){
							        	System.out.println("������ � ����� ���� ���������");
								    }		
								}
								break;
							}
							
				        
						break;
					case ("create"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryId < 0) {
				            	System.out.println("ID ��������� �� ����� ���� �������������");
				            } else {
				            	if (commandList[3].length()>255) {
				            		System.out.println("��������� ����� �������� ���������");
				            	} else {
				            		categoryHandler.categoryCreate(categoryId, commandList[3]);
						            System.out.println("��������� " + commandList[3] + " �������");
				            	}
				            }				            
				        }
				        catch (NumberFormatException error){
				        	System.out.println("������ � ����� ���� ���������");
				        }
						break;
					case ("rename"):
						Category renamedCategory;
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryHandler.categoryExist(categoryId)) {
					            renamedCategory = categoryHandler.categorySelect(categoryId);
					            renamedCategory.setCategoryName(commandList[3]);
					            System.out.println("��������� " + categoryId + " ������ ���������� " + commandList[3]);
				            } else {
				            	if (categoryId < 0) {
					            	System.out.println("ID ��������� �� ����� ���� �������������");
					            } else {
					            	if (commandList[3].length()>255) {
					            		System.out.println("��������� ����� �������� ���������");
					            	} else {
					            		categoryHandler.categoryCreate(categoryId, commandList[3]);
							            System.out.println("��������� " + commandList[3] + " �������");
					            	}
					            }
				            }
				        }
				        catch (NumberFormatException error){
				            System.out.println("������ � ����� ���� ���������");
				        }
						break;
					case ("add"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryHandler.categorySelect(categoryId).accessPositionHandler().positionExist(commandList[3])) {
					            if (categoryHandler.categorySelect(categoryId).positionExist("commandList[3]")) {
					            	System.out.println("������� ��� ��������� � ���������");
					            } else {
						            if (!categoryHandler.categorySelect(categoryId).categoryNotEmpty()) {
						            	catalog.categoryAdd(categoryHandler.categorySelect(categoryId));
						            }
						            categoryHandler.categorySelect(categoryId).positionAdd(categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]));	
					            }
				            } else {
				            	System.out.println("������� � ��������� ������������� �� ����������");
				            }
				        }
				        catch (NumberFormatException error){
				        	System.out.println("������ � ����� ���� ���������");
				        }
						break;
					case ("remove"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryHandler.categorySelect(categoryId).accessPositionHandler().positionExist(commandList[3])) {
				            	if (categoryHandler.categorySelect(categoryId).positionExist("commandList[3]")) {
						            categoryHandler.categorySelect(categoryId).positionRemove(categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]));
						            if (!categoryHandler.categorySelect(categoryId).categoryNotEmpty()) {
						            	catalog.categoryRemove(categoryHandler.categorySelect(categoryId));
						            } else {
						            	System.out.println("��������� ������� ��� � ������ ���������");
						            }
				            	}
				            } else {
				            	System.out.println("������� � ��������� ������������� �� ����������");
				            }
				        }
				        catch (NumberFormatException error){
				        	System.out.println("������ � ����� ���� ���������");
				        }
						break;
					default:
						System.out.println("������� �����������");
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
				            	System.out.println("������� � ����� ��������� ��� ����������"); }
				            else {
				            	if (commandList[3].length() > 255) {
					            	System.out.println("��������� ����� �������� �������");
				            	} else {						            
						            categoryHandler.categorySelect(categoryId).accessPositionHandler().positionCreate(commandList[3], positionUnitNumber, positionPrice, positionQuantity);	
						            System.out.println("������� " + commandList[3] + " ��������� � ��������� " + categoryHandler.categorySelect(categoryId).getCategoryName());
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
				        	System.out.println("������ � �����");
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
									System.out.println("������� � ����� ��������� �����������");
								}
							}
				        }
				        catch (NumberFormatException error){
				            System.out.println("������ � ����� ���� ���������");
				        }					
						break;
					case ("price"):
						try{
				            categoryId = Integer.parseInt(commandList[2]);
				            if (categoryHandler.categorySelect(categoryId).accessPositionHandler().positionExist(commandList[3])) {
				            	float newPositionPrice = Float.parseFloat(commandList[4]);
				            	if (newPositionPrice >= 0) {
				            		categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).setPositionPrice(newPositionPrice);
				            	} else {
				            		System.out.println("����� ���� �����������");
				            	}
				            } else {
				            	System.out.println("������� � ����� ��������� �����������");
				            }
				        }
				        catch (NumberFormatException error){
				            System.out.println("������ � ����� ���� ���������");
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
				            		System.out.println("���������� ������� " + categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).getPositionName() + " ��������� �� " + String.valueOf(selectedPositionQuantity + addedAmount));
				            	} else {
				            		System.out.println("����������� ���������� ������ ���� ������������� �����");
				            	}
				            	
				            } else {
				            	System.out.println("������� � ����� ��������� �����������");
				            }
				        }
				        catch (NumberFormatException error){
				            System.out.println("������ � �����");
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
				            			System.out.println("���������� ������� " + categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]).getPositionName() + " ��������� �� " + String.valueOf(selectedPositionQuantity - subtractedAmount));
				            			if (selectedPositionQuantity - subtractedAmount == 0) {
						            		categoryHandler.categorySelect(categoryId).positionRemove(categoryHandler.categorySelect(categoryId).accessPositionHandler().positionSelect(commandList[3]));
						            		if (!categoryHandler.categorySelect(categoryId).categoryNotEmpty()) {
						            			catalog.categoryRemove(categoryHandler.categorySelect(categoryId));
						            		}				            		
						            	}
				            		} else {
				            			System.out.println("������ ��������� ���������� ������� �� ������, ��� �������");
				            		}
				            	} else {
				            		System.out.println("���������� ���������� ������ ���� ������������� �����");
				            	}				            	
				            } else {
				            	System.out.println("������� � ����� ��������� �����������");
				            }
				        }
				        catch (NumberFormatException error){
				            System.out.println("������ � �����");
				        }
						break;
					default:
						System.out.println("������� �����������");
						break;
				}
				break;
			default:
				System.out.println("������� �����������");
				break;
			}	
	}
}
