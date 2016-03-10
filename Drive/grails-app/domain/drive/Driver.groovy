package drive

class Driver{
	
	String gender
	Date dateOfBirth
	String country
	Integer year
	
    static constraints = {
		gender()
		dateOfBirth()
		country()
		year()
    }
}
