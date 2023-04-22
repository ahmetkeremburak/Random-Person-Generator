package rastgelekisiuret;

import java.util.Random;

/**
 * @author Ahmet Kerem Burak
 * @since	Aralık, 2022
 * <p>
 * TC no oluşturan, doğruluğunu kontrol eden ve döndüren sınıftır. TC noları "0" ile başlayamaz.
 * Bu şart dışında ilk dokuz hanesi rastgeledir. 10.hane ilk dokuz hanedeki tek sıralı rakamların
 * toplamının 7 katından çift sıralı rakamların toplamının çıkarılıp mod10'unun alınmasıyla bulunur.
 * 11.hane ise ilk on hanenin toplamının mod10'u ile bulunur.  
 * </p>
 *
 */
public class IdNo {
	
	private int[] IdNo = new int[11];
	
	private void firstNine() {
		Random random = new Random();
		
		IdNo[0] = random.nextInt(1, 10);
		
		for(int i = 1; i < 9; i++) {
			IdNo[i] = random.nextInt(10);
		}
	}
	
	private void firstTen() {
		firstNine();
		int sumOdd = 0;
		int sumEven = 0;
		
		for(int i = 0; i < 9; i+=2) {
			sumOdd += IdNo[i]*7;
		}
		
		for(int i = 1; i < 9; i+=2) {
			sumEven += IdNo[i];
		}
		
		int tenth = (sumOdd - sumEven)%10;
		IdNo[9] = tenth; 
	}
	
	private void IdNoGenerator() {
		firstTen();
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += IdNo[i];
		}
		int eleventh = sum%10;
		
		IdNo[10] = eleventh;
	}
	
	private boolean idNoValidater() {
		int sumOdd = 0;
		int sumEven = 0;
		int sum = 0;
		
		for(int i = 0; i < 9; i+=2) {
			sumOdd += IdNo[i]*7;
			sum += IdNo[i];
		}
		
		for(int i = 1; i < 9; i+=2) {
			sumEven += IdNo[i];
			sum += IdNo[i];
		}
		
		int tenth = (sumOdd - sumEven)%10;
		sum += tenth;
		int eleventh = sum%10;
		
		return eleventh == IdNo[10];
	}
	
	public String getIdNo() {
		IdNoGenerator();
		StringBuilder IdNoBuilder = new StringBuilder();
		boolean validate = idNoValidater();
		
		if(validate == true) {
			for(int i = 0; i < IdNo.length; i++) {
				IdNoBuilder.append(IdNo[i]); 
			}
			return IdNoBuilder.toString();
		}
		else {
			System.out.println("TC No doğru hesaplanamadı.");
			return null;
		}
	}
}
