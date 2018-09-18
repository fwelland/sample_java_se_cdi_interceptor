# sample_java_se_cdi_interceptor
Sample JAVA SE Program with an interceptor.  Borne out of https://stackoverflow.com/questions/52248208/cdi-interceptors-and-jersey-jax-rs


What this does: 
* very simple CDI console app
* boots CDI via newish CDI2 style SE bootup API
* has simple 'service' that is injected
* has a interceptor annotation around a service method



Not quite sure what is in play here there are a couple of odd things I maybe  am not expecting: 

* had to enableInterceptors() explicitly
* beans.xml seem in place, but not clear WeldSE is picking up on it. 
* put a typo in the beans.xml interceptors tags and WELD isn't complaing?
* maybe running from gradle is NOT correctly making a BDU (and just running from 'classes') as w/o addPackage(); Weld complains: no bean archives found


I run via: 

./gradlew run

