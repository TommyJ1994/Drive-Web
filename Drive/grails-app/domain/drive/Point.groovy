package drive

class Point {

	static belongsTo = [sensor: Sensor]
	String value
	Integer index
	
    static constraints = {
		value()
		index(nullable: false)		
    }
}
