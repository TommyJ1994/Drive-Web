package drive

class Driver{
	
	int age
	Date dateOfBirth;
	String country
	
    static constraints = {
		age()
		dateOfBirth()
		country()
    }
}
