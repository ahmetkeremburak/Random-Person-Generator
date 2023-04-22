package rastgelekisiuret;

import java.util.Random;


/**
 * @author Ahmet Kerem Burak
 * @since	Aralık, 2022
 * <p>
 * IMEI no 15 haneli bir numaradır. 15.hane bulunması için Luhn formülü kullanılır. Bu formülde ilk 14 numaradan
 * tek sırada olan rakamlar iki ile çarpılır ve sonucun rakamları kendi içinde toplanır. Daha sonra çıkan
 * bu sonuçlar çift sıradaki rakamlarla toplanır. Toplamın mod 10'u alınır ve "10"dan çıkarılır. Sonucun
 * tekrar mod 10'u alınır ve "Check Digit" adı verilen rakam bulunur. Bu rakam 14 hanenin sonuna 15.olarak eklenir.
 * 
 * Bu sınıf ilk 14 numarayı <code>Random</code> sınıfı ile rastgele oluşturur daha sonra Luhn formülüne
 * uygun olarak 15.haneyi hesaplar. Hesaplanan IMEI geri döndürülürken kontrol edilir ve formüle uygunsa
 * döndürülür.
 * </p>
 */
public class IMEINo{
	
	private int[] imei1 = new int[14];
	 
	
	private void payload() {
		Random random = new Random();
		for(int i = 0; i < 14; i++) {
			int r = random.nextInt(10);
			imei1[i] = r;
		}
	}
	
	private int computeCheckDigit() {
		payload();
		int sum = 0;
		int x = 0;
		
		for(int i = 0; i < 14; i++) {
			
			int digit;
			int digitsum = 0;
			
			if(i%2 == 0) {
				sum += imei1[i];
			}
			else {
				digit = imei1[i]*2;
				if(digit >= 10) {
					digitsum = (digit%10) + 1;
					sum += digitsum;
				}
				else {
					sum += digit;
				}
			}
		}
		x = (10 -(sum%10))%10;
		return x;
	}
	
	private int[] imeiGenerator() {

		int[] imei = new int[15];
		imei[14] = computeCheckDigit(); 
		
		for (int i = 0; i < imei1.length;i++) {
			imei[i] = imei1[i];
		}
		
		return imei;	
	}
	
	private boolean imeiValidate(int[] imei) {

		int givenCheckDigit = imei[14];
		int calculatedCheckDigit = 0;
		for(int i = 0; i < 14; i++) {
			
			int digit;
			int digitsum = 0;
			
			if(i%2 == 0) {
				calculatedCheckDigit += imei1[i];
			}
			else {
				digit = imei1[i]*2;
				if(digit >= 10) {
					digitsum = (digit%10) + 1;
					calculatedCheckDigit += digitsum;
				}
				else {
					calculatedCheckDigit += digit;
				}
			}
		}
		calculatedCheckDigit = (10 - (calculatedCheckDigit%10))%10;
		return calculatedCheckDigit == givenCheckDigit;
	}
	
	public String getIMEI() {
		int[] IMEIarr = imeiGenerator();
		StringBuilder IMEI = new StringBuilder();
		
		if(imeiValidate(IMEIarr) == true) {
			for(int i = 0; i < IMEIarr.length; i++) {
				IMEI.append(IMEIarr[i]); 
			}
			return IMEI.toString();
		}
		else {
			System.out.println("IMEI doğru hesaplanamadı.");
			return null;
		}
	}
}