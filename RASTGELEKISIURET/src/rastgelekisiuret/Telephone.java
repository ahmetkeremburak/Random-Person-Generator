package rastgelekisiuret;

import java.util.Random;

/**
 * @author Ahmet Kerem Burak
 * @since	Aralık, 2022
 * <p>
 * Rastgele bir telefon numarası üretip döndürür. Telefon numaralarının ülkelere göre alan kodu vardır.
 * Fakat burada tüm numaralar Türkiye'den olacağı için Türkiye alan kodu olan +90 numaraların başına
 * konulmamıştır. Ödevdeki örnekte numaraların başındaki "0" olduğundan buradaki numaralar da 
 * o şekilde üretilmiştir. Türkiye Ulusal Numaralandırma Planına göre belirli mobil operatörlere ait
 * belirli alan kodları vardır. Sınıf içerisinde bu alan kodları bir <code> String Array</code> içerisinde
 * tutulur. Geri kalan kısmı müşteriye özel abone numarasıdır. Random sınıfı ile rastgele üretilir.  
 * </p>
 *
 */
public class Telephone {
String[] gsmDigits = {
		"0501", "0505", "0506","0507","0551","0552","0553","0554","0555","0559",
		"0516","0530","0531","0532","0533","0534","0535","0536","0537","0538","0539",
		"0561","0541","0542","0543","0544","0545","0546","0547","0548","0549",
		};

	private String customerDigits() {
		Random random = new Random();
		int customerDigits = random.nextInt(10000000);
	
		return String.valueOf(customerDigits);
	}
	
	public String getTelephone() {
		StringBuilder build = new StringBuilder();
		Random i = new Random();
		build.append(gsmDigits[i.nextInt(31)]).append(customerDigits());
		
		return build.toString();
	}
}
