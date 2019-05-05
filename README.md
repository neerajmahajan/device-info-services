#### device-info-services
* A set of services which provide device information through exposed REST endpoint.
* device-info-service exposes a REST endpoint which allows client of API to get information about device. Currently API returns timezone specific date and time based on device location.
* date-localizer-service exposes an OSGi service which takes deviceId as service argument and returns object of Response class containing localizedDate and deviceId.

#### Pre-requistes

* Java 8
* Maven 3
* Download and unzip https://developers.redhat.com/download-manager/file/fuse-karaf-7.2.0.fuse-720035-redhat-00001.zip

##### Building the source code.
* Run 'mvn clean install' in device-info-services folder of source code.

##### Installing bundles into karaf container through fetaure
* create directory test-data under fuse installation
  * Add timezone.csv to the test-data directory
  * The above directory name and filename are configurable and can be changed by changing properties in com.mycompany.date.localizer.service.cfg file stored under etc directory of fuse installation.
* Open fuse console by launching fuse executable in bin folder of fuse-karaf-7.2.0.fuse-720035-redhat-00001 installation.
* Run below commands on fuse console
 * feature:repo-add mvn:com.mycompany/device-services-features/1.0.0-SNAPSHOT/xml/features
 * features:install device-info-services
 
##### Testing the service

* Run http://localhost:8082/deviceinfo/0 in the browser or in postman app to test the API endpoint.
* Below is the sample resposne when deviceId is found in the csv file.
 ''' 
 {
  "deviceId" : "0",
  "localizedDate" : "16/04/2017 12:04 GMT +0000",
  "responseMessage" : "Successfully retrieved local time"
 }
 '''
 
 * Below is the sample response when deviceId is not found in the csv file.
 '''
 {
  "deviceId" : "100",
  "localizedDate" : null,
  "responseMessage" : "No matching record found with deviceId :100"
 }
 '''
