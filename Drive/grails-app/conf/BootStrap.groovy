import drive.Driver

class BootStrap {

    def init = { servletContext ->
		
		new Driver(age:21, dateOfBirth: new Date(), country:"Ireland").save()
		new Driver(age:51, dateOfBirth: new Date(), country:"England").save()
    }
    def destroy = {
    }
}
