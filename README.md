# README #

### Drive - The Open Car Network ###

* The project idea is to create a form of “Social Network” that is focused on providing an easy way for users to extract their car data and then view their car data in the cloud whilst contributing to an anonymous data network that can be used for research purposes and many other uses. 

* The project involves monitoring 30+ car sensors and creating 2 applications – an Android mobile application used to extract data from the car over Bluetooth/ISO9141-2 and a web based telemetrics application responsible for graphing a driver’s car data as well as generating key statistics using pattern matching. 

* All cars built after 1996 will be supported in the project.

* Version 0.1

### Setup ###

* Database Configuration - The grails application uses a mongo database called 'Drive' for development, and 'DriveTest' for testing. Ensure this is set to 'Drive' for development purposes.

* Dependencies - All dependencies for the mobile application are handled by NPM and Ionic. Maven handles dependencies for the grails application.

* Grails Configuration - Uses version 2.4.4

* Mongo Configuration - Uses version 2.4.9

### Mobile App Structure ###

tom@Mint17 /media/sf_Semester_8/Project/open-car-network-mobile/www $ tree
.
* ├── css
* │   └── style.css
* ├── img
* ├── index.html
* ├── js
* │   ├── addVehiclesController.js
* │   ├── app.js
* │   ├── countryChooserController.js
* │   ├── dashboardController.js
* │   ├── dateOfBirthChooserController.js
* │   ├── followingController.js
* │   ├── genderChooserController.js
* │   ├── menuController.js
* │   ├── obdConnectionController.js
* │   ├── sensorQueryingController.js
* │   ├── services
* │   │   ├── BluetoothService.js
* │   │   └── StorageService.js
* │   ├── settingsController.js
* │   └── vehiclesController.js
* ├── lib
* │   ├── angular
* │   ├── angular-animate
* │   ├── angular-sanitize
* │   ├── angular-ui-router
* │   ├── ionic
* │   │   ├── bower.json
* │   │   ├── css
* │   │   │   ├── ionic.css
* │   │   │   ├── ionic.css.orig
* │   │   │   └── ionic.min.css
* │   │   ├── fonts
* │   │   ├── js
* │   │   │   ├── ionic-angular.js
* │   │   │   ├── ionic-angular.min.js
* │   │   │   ├── ionic.bundle.js
* │   │   │   ├── ionic.bundle.min.js
* │   │   │   ├── ionic.js
* │   │   │   ├── ionic.min.js
* │   │   │   └── ng-cordova.js
* │   │   ├── README.md
* │   │   └── scss
* │   └── ionic-datepicker
* │      
* └── templates
*     ├── addVehicleMake.html
*     ├── addVehicleModel.html
*     ├── addVehicleStyle.html
*     ├── addVehicleYear.html
*     ├── countryChooser.html
*     ├── dashboard.html
*     ├── dateOfBirthChooser.html
*     ├── finalVehicle.html
*     ├── following.html
*     ├── genderChooser.html
*     ├── menu.html
*     ├── obdConnection.html
*     ├── sensorQuerying.html
*     ├── settings.html
*     ├── setup.html
*     └── vehicles.html

 
### Deployment instructions ###

* To run the unsigned mobile app, enable installation of apps from unknown sources from your android settings menu.

* To run the grails web application, go to the drive directory and run the command below 
```
#!python
grails run-app
```

### Contact ###

* Tom Jackman - TomJackman@protonmail.com