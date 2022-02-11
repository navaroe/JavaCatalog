package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
	
	public static String[] unitNamesList = { "шт.", "уп.", "вес нетто в кг." };

	public static void main(String[] args) throws IOException {
		String command;
		Command decoder = new Command();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Console.help();
		while (true) {			
			command = reader.readLine();
			decoder.read(command);
		}
		// TODO Auto-generated method stub

	}
	
	public static void help() {
		System.out.println("Список команд:");
		System.out.println("help - вызов справочной подсистемы команд");
		System.out.println("catalog pages - количество страниц каталога");
		System.out.println("catalog page {номер страницы} - вывод страницы каталога");
		System.out.println("catalog add {ID категории} - ручное добавление категории в каталог");
		System.out.println("catalog remove {ID категории} - ручное удаление категории из каталога");
		System.out.println("category pages {ID категории} - количество страниц в выбранной категории");
		System.out.println("category show all - вывод всех существующих категорий");
		System.out.println("category show page {ID категории} {номер страницы} - вывод страницы содержащихся в категории позиций");
		System.out.println("category create {ID категории} {название категории} - создание категории");
		System.out.println("category rename {ID категории} {название категории} - переименование (может быть совмещено с созданием) категории");
		System.out.println("category add {ID категории} {название позиции} - ручное добавление позиции в категорию");
		System.out.println("category remove {ID категории} {название позиции} - ручное удаление позиции из категории");
		System.out.println("position create {ID категории} {название позиции} {номер единицы измерения} {стоимость} {количество} - создание позиции в указанной категории с указанными характеристиками");
		System.out.println("position show {ID категории} all - вывод всех существующих позиций в категории");
		System.out.println("position show {ID категории} {название позиции} - вывод характеристик позиции в указанной категории");
		System.out.println("position price {ID категории} {название позиции} {стоимость} - изменение цены позиции в указанной категории");
		System.out.println("position increase {ID категории} {название позиции} {количество} - увеличение количества позиции в указанной категории");
		System.out.println("position decrease {ID категории} {название позиции} {количество} - уменьшение количества позиции в указанной категории");
	}

}


