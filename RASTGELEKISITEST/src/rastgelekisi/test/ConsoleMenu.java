package rastgelekisi.test;

import java.util.InputMismatchException;
import java.util.Scanner;

import rastgelekisiuret.RandomPerson;

/**
 * @author Ahmet Kerem Burak
 * @since Aralık, 2022
 *Çıkış koşulu olan bir sonsuz döngüyle ödeved istenilen menüyü konsola yazdırır.
 *Üretilecek rastgele kişi sayısı kadar kişi üretip ekrana yazar.
 *Çalışması için RASTGELEKISIURET kütüphanesi projenin path'ine dış kaynak olarak eklenmelidir.
 *Aksi takdirde proje çalışmayacaktır.
 */
public class ConsoleMenu {
	
	int loopStatus = 1;
	
	public void console() {
		while (loopStatus == 1) {
			int choice = 0;
			
			switch(menu(choice)) {
			case 1: {
				int many = howMany();
				generation(many);
				choice = 0;
				break;
			}
			case 2: {
				loopStatus = 0;
				System.out.println("Program tamamlandı.");
				break;
			}
			default:
				System.out.printf("Lütfen belirtilen numaralardan seçerek tekrar deneyin.\n");
				choice = 0;
			}
		}
	}

	private void generation(int howMany) {
		RandomPerson rando = new RandomPerson();
		System.out.println("----------------------------------------");
		while(howMany != 0) {
			System.out.println(rando.generatePerson());
			howMany--;
		}
	}

	private int howMany() {
		int choice = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("----------------------------------------");
		System.out.print("Kaç tane Rastgele Kişi üretilmeli: ");
		
		try {
			choice = in.nextInt();
		} catch (InputMismatchException e) {
			System.out.printf("Numara girmelisiniz.\n");
			choice = 0;
			return choice;
		}
		return choice;
	}

	private int menu(int choice) {
		Scanner in = new Scanner(System.in);
		System.out.println("----------------------------------------");
		System.out.println("1) Rastgele Kişi Üret");
		System.out.println("2) Çıkış");
		System.out.println("----------------------------------------");
		
		try {
			choice = in.nextInt();
		} catch (InputMismatchException e) {
			System.out.printf("Numara girmelisiniz.\n");
			choice = 0;
			return choice;
		}
		return choice;
	}
}
