package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;

import dto.AddressDto;

//Dao(Data Access Object)
public class AddressDao {

	//데이터를  편집하는 클래스
	//composition
	private Scanner sc = new Scanner(System.in);
	
	final int COUNT = 100;
	
	
	// 주소를 저장할 100개의 instance
	private AddressDto addressBook[] = new AddressDto[COUNT];
	private int counter;
	
	public AddressDao() {
		counter=0;
	}
	
	public void insert() {
		System.out.println("데이터를 추가합니다.");
		
		System.out.print("이름 = ");
		String name = sc.next();
		
		System.out.print("나이 =");
		int age = sc.nextInt();
		
		System.out.print("전화번호 = ");
		String phone = sc.next();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("주소 = ");
		String address = "";
		try {
			address = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.print("메모 = ");
		String memo = "";
		try {
			memo = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		addressBook[counter] = new AddressDto(name, age, phone, address, memo);
		counter++;
		
	}
	
	public void delete() {	// 24 -> 0 "홍길동" -> "빈문자열"
		
		System.out.print("삭제할 이름을 입력하세요");
		String name = sc.next();
		//검색
//		int index = -1;
//		for (int i = 0; i < addressBook.length; i++) {
//			if(addressBook[i] != null) {
//				if(name.equals(addressBook[i].getName())){
//					index = i;
//					break;
//				}
//			}
//		}	
		int index = search(name);
		if(index == -1) {
			System.out.println("지인정보를 찾을 수 없습니다.");
		}
		else {
			//삭제
			addressBook[index].setName("");
			addressBook[index].setAge(0);
			addressBook[index].setPhone("");
			addressBook[index].setAddress("");
			addressBook[index].setMemo("");
			
			System.out.println("지인정보를 삭제했습니다.");
			
		}
	}
	
	public void select() {	//이름으로 검색
		System.out.print("이름을 검색하세요 = ");
		String name = sc.next();
		
//		for (int i = 0; i < addressBook.length; i++) {
//			if(addressBook[i] != null) {
//				if(addressBook[i].getName().contains(name)) {
//					System.out.println(addressBook[i].toString());
//				}
//			}
//		}
			
	}
	
	public void update() {	//전화번호 주소 메모만 
		
		System.out.print("삭제할 이름을 입력하세요");
		String name = sc.next();
		
		//검색
		int index = search(name);
		if(index == -1) {
			System.out.println("지인을 찾을 수 없습니다.");
			return;
		}
		//수정
		System.out.print(":전화번호 >> ");
		String phone = sc.next();
		
		System.out.print("주소 >>");
		String address = sc.next();
		
		System.out.print("메모 >>");
		String memo = sc.next();
		
		addressBook[index].setPhone(phone);
		addressBook[index].setAddress(address);
		addressBook[index].setMemo(memo);
		
		System.out.println("수정을 완료했습니다.");
		
	}
	
	public int search(String name) {
		
		int index = -1;
		for (int i = 0; i < addressBook.length; i++) {
			if(addressBook[i] != null) {
				if(name.equals(addressBook[i].getName())){
					index = i;
					break;
				}
			}
		}
		return index;
	}
	//확인
	public void allDataPrint() {
		for (int i = 0; i < addressBook.length; i++) {
			if(addressBook[i] != null) {
				System.out.println(addressBook[i].toString());
			}
			
		}
		
	}
}
