package main;

import java.util.Scanner;

import dao.AddressDao;

public class MainClass {

	public static void main(String[] args) {


		/*
		 	주소록
		 	ㅁmain
		 	메뉴
		 	1.추가(insert)	
		 	2.삭제(delete)	
		 	3.검색(select)	
		 	4.수정(update)
		 	
		 	Create
		 	Read
		 	Update
		 	Delete
		 	
		 	=====================
		 	Data Access Object
		 	
		 	AddressDao
		 	
		 	데이터를 다루는 class
		 	
		 	void insert()
		 	void delete()
		 	void select()
		 	void update()
		 	
		 	file
		 	========================
		 	
		 	Data Transfer Object
		 	
		 	AddressDto
		 	
		 	name
		 	age
		 	phone
		 	address
		 	memo
		 	
		 	========================
		 	
		 */
		
		Scanner sc = new Scanner(System.in);
		
		AddressDao dao = new AddressDao();

		
		while(true) {
			System.out.println("addtess book menu --------------------------------");
			System.out.println("1. 주소 추가");
			System.out.println("2. 주소 삭제");
			System.out.println("3. 주소 검색");
			System.out.println("4. 주소 수정");
			System.out.println("5. 주소 모두 출력");
			System.out.println("6. 종료");
			
			System.out.print("menu number >>");
			int menuNumber = sc.nextInt();
			
			switch(menuNumber)
			{
				case 1:
					dao.insert();
					break;
				case 2:
					dao.delete();
					break;
				case 3:
					dao.select();
					break;
				case 4:
					dao.update();
					break;
				case 5:
					dao.allDataPrint();
					break;
				case 6:
					break;
			}
			
			
		}
	}

}
