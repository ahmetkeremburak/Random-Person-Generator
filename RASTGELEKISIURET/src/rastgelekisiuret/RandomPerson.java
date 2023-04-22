package rastgelekisiuret;

/**
 * @author Ahmet Kerem Burak
 * @since	Aralık, 2022
 * <p>
 * generatePerson metodu ile içinde yeni bir rastgele kişi nesnesi oluşturur.
 * Bu nesnenin bilgilerini bir String nesnesinde depolar ve ödevde istenen formatta
 * döndürür.  
 * </p>
 *
 */
public class RandomPerson {
	
	public String generatePerson(){

		Person person = new Person();
		String personString = person.getIdNo() + " " + person.getName() 
		+ " " + person.getSurname() + " " + person.getAge() + " " + person.getTelNo() 
		+ " (" + person.getImeiNo() + ")";
		return personString;
	}
	
}
