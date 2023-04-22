package rastgelekisiuret;

import java.util.Random;

/**
 * @author Ahmet Kerem Burak
 * @since	Aralık, 2022
 * <p>
 * İçerisinde kişi sınıfından beklenen TC Numarası, Telefon, IMEI, İsim, Soyisim ve Yaş bilgilerinin
 * bir numunesini ve bunları döndürecek metodları barındırır. Kişi oluşturmak için kullanılır.    
 * </p>
 *
 */
public class Person {
	IdNo id = new IdNo();
	Telephone tel = new Telephone();
	IMEINo imei = new IMEINo();
	String name;
	String surname;
	String age;

	public Person() {
		this.name = nameGenerator();
		this.surname = surnameGenerator();
		this.age = ageGenerator();
	}
	private String ageGenerator() {
		Random r = new Random();
		int yas = r.nextInt(101);
		age = String.valueOf(yas);
		return age;
	}

	private String nameGenerator() {
		String[] names = {"JALE", "ALİ", "MAHMUT", "MANSUR", "KÜRŞAD", "GAMZE", "MİRAÇ", "YÜCEL", "KUBİLAY", 
		                   "HAYATİ", "BEDRİYE", "MÜGE", "BİRSEN", "SERDAL", "BÜNYAMİN", "ÖZGÜR", "FERDİ", 
		                   "REYHAN", "İLHAN", "GÜLŞAH", "NALAN", "SEMİH", "ERGÜN", "FATİH", "ŞENAY", "SERKAN", "EMRE",
		                   "IRAZCA", "HATİCE", "BARIŞ", "REZAN", "FATİH", "FUAT", "GÖKHAN", "ORHAN", "MEHMET", "EVREN", "OKTAY", "HARUN",
		                   "YAVUZ", "PINAR", "MEHMET", "UMUT", "MESUDE", "HÜSEYİN", "CAHİT", "HAŞİM", "ONUR", "EYYUP", "SABRİ", "MUSTAFA",
		                   "MUSTAFA", "UFUK", "AHMET", "ALİ", "MEDİHA", "HASAN", "KAMİL", "NEBİ", "ÖZCAN", "NAGİHAN", "CEREN", "SERKAN",
		                   "HASAN", "YUSUF", "KENAN", "ÇETİN", "TARKAN", "MERAL", "LEMAN", "ERGÜN", "KENAN", "AHMET", "URAL", "YAHYA",
		                   "BENGÜ", "FATİH", "NAZMİ", "DİLEK", "MEHMET", "TUFAN", "AKIN", "MEHMET", "TURGAY", "YILMAZ", "GÜLDEHEN",
		                   "GÖKMEN", "BÜLENT", "EROL", "BAHRİ", "ÖZEN", "ÖZLEM", "SELMA", "TUĞSEM", "TESLİME", "NAZLI", "GÜLÇİN", "İSMAİL",
		                   "MURAT", "EBRU", "TÜMAY", "AHMET", "EBRU", "HÜSEYİN", "YAVUZ", "BAŞAK", "AYŞEGÜL", "EVRİM", "YASER", "ÜLKÜ",
		                   "ÖZHAN", "UFUK", "AKSEL", "FULYA", "BURCU", "TAYLAN", "YILMAZ", "ZEYNEP", "BAYRAM", "GÜLAY", "RABİA", "SEVDA",
		                   "SERHAT", "ENGİN", "ASLI", "TUBA", "BARIŞ", "SEVGİ", "KALENDER", "HALİL", "BİLGE", "FERDA"};
		Random r = new Random();
		int i = r.nextInt(names.length);
		name = names[i];
		return name;
	}
	
	private String surnameGenerator() {
		String[] surnames = {"ŞEN", "KANDEMİR", "ÇEVİK", "ERKURAN", "TÜTEN", "ÖZTÜRK", "YÜZBAŞIOĞLU", "VURAL", "YÜCEL",
				"SÖNMEZ", "ERTEKİN", "DEDE", "UYANIK", "ASLAN", "AKBULUT", "ORHON", "UZ", "YAVUZ", "ERDEM", "KULAÇ", "KAYA",
				"SELVİ", "AKPINAR", "ABACIOĞLU", "ÇAY", "IŞIK", "ÖZER", "ÖZDEMİR", "ÖZTÜRK", "TAHTACI", "BÜYÜKCAM",
				"KULAKSIZ", "AKSEL", "EROĞLU", "KARAKUM", "DAL", "ÖCAL", "AYHAN", "YİĞİT", "YARBİL", "CANACANKATAN",
				"GÜMÜŞAY", "MURAT", "HALHALLI", "ULUÖZ", "ŞEYHANLI", "ÇALIŞKANTÜRK", "YILMAZ", "SARAÇOĞLU", "SEZER",
				"DOĞAN", "DEMİR", "KAYAYURT", "SÜRÜM", "YAVAŞİ", "TURGUT", "ŞEN", "TANRIKULU", "BARBAROS", "ALDİNÇ", "TEKİN",
				"GÜLŞAN", "KÜFECİLER", "ALMACIOĞLU", "ÇİLDİR", "TÜRKDOĞAN", "KAYA", "ÖNER", "ŞELİMAN", "YAMAN", "ATİK", "YİĞİT",
				"GİRAY","YALÇINKAYA", "KILIÇ", "ŞENTÜRK", "KARABAĞ", "DEĞİRMENCİ", "BODUROĞLU", "YILDIZ", "GÜLER",
				"ERASLAN", "ÜZER", "PİŞİRGEN", "ADANIR", "KOÇ", "KORKMAZ", "YENİDOĞAN", "AYDOĞAN", "ACARBULUT", "ERGE",
				"ERDOĞAN", "ÖĞÜT", "AYDIN", "KUŞKU", "KUCUR", "TÜLÜBAŞ", "PEKTAŞ", "KAYACAN", "GÜLEN", "DOĞAN", "AYDIN",
				"BADILLIOĞLU", "GÜLEN", "AKKÜÇÜK", "CANDAN", "TEMEL", "YENİGÜN", "YILDIRIM", "BEDER", "AKINCI", "ÖZDEMİR",
				"ONUK", "AYDOĞAN", "YILMAZ", "AKCAN", "ATASOY", "SARAÇOĞLU", "ÇEKİÇ", "CÖMERT", "TOPAL", "KARAHAN", "ŞAHİN"};
		Random r = new Random();
		int i = r.nextInt(surnames.length);
		surname = surnames[i];
		return surname;
	}
	
	public String getIdNo() {
		return id.getIdNo();
	}
	
	public String getTelNo() {
		return tel.getTelephone();
	}
	
	public String getImeiNo() {
		return imei.getIMEI();
	}
	
	public String getName() {
		return name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public String getAge() {
		return age;
	}
}
