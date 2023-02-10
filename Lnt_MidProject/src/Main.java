import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	Scanner sc = new Scanner(System.in);
	ArrayList<Vehicle> newList = new ArrayList<>();
	int choose = -1;
	int pick =0;
	
	public void menu() {
		System.out.println("1. Input");
		System.out.println("2. View");
		System.out.println("3. Exit");
		System.out.print(">> ");
	}
	
	public void input() {
		String type = "";
		String brand = ""; 
		String name = "";
		String license = "";
		int topSpeed = 0;
		int gasCap = 0;
		int wheel = 0;
		String tipe = "";
		int entSys = 0;
		int helm = 0;
		
		do {
			System.out.print("Input type [Car | Motorcycle]: ");
			type = sc.nextLine();
		} while (!(type.equals("Car")||type.equals("Motorcycle")));
		
		do {
			System.out.print("Input brand [>=5]: ");
			brand = sc.nextLine();
		} while (brand.length()<5);
		
		do {
			System.out.print("Input name [>=5]: ");
			name = sc.nextLine();
		} while (name.length()<5);
		
		do {
			System.out.print("Input license: ");
			license = sc.nextLine();
		} while (!(license.contains(" ")&&license.contains(" ")));
		
		do {
			System.out.print("Input top speed [100 <= topSpeed <= 250]: ");
			topSpeed = sc.nextInt();
			sc.nextLine();
		} while (topSpeed<100||topSpeed>250);
		
		do {
			System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
			gasCap = sc.nextInt();
			sc.nextLine();
		} while (gasCap<30||gasCap>60);
		
		if (type.equals("Car")) {
			do {
				System.out.print("Input wheel [4 <= wheel <= 6]: ");
				wheel = sc.nextInt();
				sc.nextLine();
			} while (wheel<4||wheel>6);
			
			do {
				System.out.print("Input type [SUV | Supercar | Minivan]: ");
				tipe = sc.nextLine();
			} while (!(tipe.equals("SUV")||tipe.equals("Supercar")||tipe.equals("Minivan")));
			
			do {
				System.out.print("Input entertainment system amount [>=1]: ");
				entSys = sc.nextInt();
			} while (entSys<1);
		}
		
		if (type.equals("Motorcycle")) {
			do {
				System.out.print("Input wheel [2 <= wheel <= 3]: ");
				wheel = sc.nextInt();
				sc.nextLine();
			} while (wheel<2||wheel>3);
			
			do {
				System.out.print("Input type [Automatic | Manual]: ");
				tipe = sc.nextLine();
			} while (!(tipe.equals("Automatic")||tipe.equals("Manual")));
			
			do {
				System.out.print("Input helm amount [>=1]: ");
				helm = sc.nextInt();
				sc.nextLine();
			} while (helm<1);
		}
		
		if (type.equals("Car")) {
			Car  newCar = new Car(type, brand, name, license, topSpeed, gasCap, wheel, tipe, entSys);
			newList.add(newCar);
		}else {
			Motorcycle newMotor = new Motorcycle(type, brand, name, license, topSpeed, gasCap, wheel, tipe, helm);
			newList.add(newMotor);
		}
		System.out.println();
	}
	
	public void view() {
		if (newList.isEmpty()) {
			System.out.println("|-----|---------------|---------------|");
			System.out.printf("|%-5s|%-15s|%-15s|\n", "No", "Type", "Name");
			System.out.println("|-----|---------------|---------------|");
			System.out.printf("|%-5s|%-15s|%-15s|\n", " ", " ", " ");
			System.out.println("|-----|---------------|---------------|");
		}else {
			int ctr = 1;
			System.out.println("|-----|---------------|---------------|");
			System.out.printf("|%-5s|%-15s|%-15s|\n", "No", "Type", "Name");
			System.out.println("|-----|---------------|---------------|");
			for (Vehicle a : newList) {
				System.out.printf("|%-5s|%-15s|%-15s|\n", ctr, a.type, a.name);
				System.out.println("|-----|---------------|---------------|");
				ctr++;
			}
			
			do {
				System.out.print("Pick a vehicle number to test drive [Enter '0' to exit]: ");
				pick = sc.nextInt();
				
				if (pick == 0) {
					break;
				}else {
					System.out.println("Brand : " + newList.get(pick-1).brand);
					System.out.println("Name : " + newList.get(pick-1).name);
					System.out.println("License Plate : " + newList.get(pick-1).license);
					System.out.println("Type : " + newList.get(pick-1).tipe);
					System.out.println("Gas Capacity : " + newList.get(pick-1).gasCap);
					System.out.println("Top Speed : " + newList.get(pick-1).topSpeed);
					System.out.println("Wheel(s) : " + newList.get(pick-1).wheel);
					if (newList.get(pick-1).type.equals("Car")) {
						System.out.println("Entertainment System : " + newList.get(pick-1).entSys);
					}else {
						System.out.println("Helm(s) : " + newList.get(pick-1).helm);
					}
					
					carSelling();
					int price;
					System.out.print("Input price: ");
					price = sc.nextInt();
					sc.nextLine();
					System.out.println("Price : " + price);
				}
			} while (pick>newList.size());
			System.out.println();
			
		}
	}
	
	public void carSelling() {
		if (newList.get(pick-1).type.equals("Car")) {
			System.out.println("Turning on entertainment system...");
			if (newList.get(pick-1).tipe.equals("Supercar")) {
				System.out.println("Boosting!");
			}
		}else {
			System.out.println(newList.get(pick-1).name + " is standing!");
		}
	}
	
	public Main(){
		do {
			menu();
			choose = sc.nextInt();
			sc.nextLine();
			System.out.println();
			
			switch (choose) {
			case 1:
				input();
				break;
				
			case 2:
				view();
				break;

			case 3:
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
		} while (choose!=3);
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
