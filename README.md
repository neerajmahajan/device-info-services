#### device-info-services
* A set of services which provide device information through exposed REST endpoint.
* 

#### Pre-requistes

* Java 8
* Maven 3
* https://developers.redhat.com/download-manager/file/fuse-karaf-7.2.0.fuse-720035-redhat-00001.zip

Open fuse console by launching fuse executable in bin folder of fuse-karaf-installation.

##### Installing bundles into karaf container through fetaure
feature:repo-add mvn:com.mycompany/device-services-features/1.0.0-SNAPSHOT/xml/features
features:install device-info-services
