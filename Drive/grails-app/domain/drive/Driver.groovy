package drive

class Driver{
	
	String gender
	Date dateOfBirth;
	String country
	
    static constraints = {
		gender()
		dateOfBirth()
		country()
    }
}
