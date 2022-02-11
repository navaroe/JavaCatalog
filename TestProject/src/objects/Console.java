package objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {
	
	public static String[] unitNamesList = { "��.", "��.", "��� ����� � ��." };

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
		System.out.println("������ ������:");
		System.out.println("help - ����� ���������� ���������� ������");
		System.out.println("catalog pages - ���������� ������� ��������");
		System.out.println("catalog page {����� ��������} - ����� �������� ��������");
		System.out.println("catalog add {ID ���������} - ������ ���������� ��������� � �������");
		System.out.println("catalog remove {ID ���������} - ������ �������� ��������� �� ��������");
		System.out.println("category pages {ID ���������} - ���������� ������� � ��������� ���������");
		System.out.println("category show all - ����� ���� ������������ ���������");
		System.out.println("category show page {ID ���������} {����� ��������} - ����� �������� ������������ � ��������� �������");
		System.out.println("category create {ID ���������} {�������� ���������} - �������� ���������");
		System.out.println("category rename {ID ���������} {�������� ���������} - �������������� (����� ���� ��������� � ���������) ���������");
		System.out.println("category add {ID ���������} {�������� �������} - ������ ���������� ������� � ���������");
		System.out.println("category remove {ID ���������} {�������� �������} - ������ �������� ������� �� ���������");
		System.out.println("position create {ID ���������} {�������� �������} {����� ������� ���������} {���������} {����������} - �������� ������� � ��������� ��������� � ���������� ����������������");
		System.out.println("position show {ID ���������} all - ����� ���� ������������ ������� � ���������");
		System.out.println("position show {ID ���������} {�������� �������} - ����� ������������� ������� � ��������� ���������");
		System.out.println("position price {ID ���������} {�������� �������} {���������} - ��������� ���� ������� � ��������� ���������");
		System.out.println("position increase {ID ���������} {�������� �������} {����������} - ���������� ���������� ������� � ��������� ���������");
		System.out.println("position decrease {ID ���������} {�������� �������} {����������} - ���������� ���������� ������� � ��������� ���������");
	}

}


