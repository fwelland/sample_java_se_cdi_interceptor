# sample_java_se_cdi_interceptor
Sample JAVA SE Program with an interceptor.  Borne out of https://stackoverflow.com/questions/52248208/cdi-interceptors-and-jersey-jax-rs


What this does: 
* very simple CDI console app
* boots CDI via newish CDI2 style SE bootup API
* has simple 'service' that is injected
* has a interceptor annotation around a service method


## Not quite sure what is in play here; there are some odd things I was not really expecting: 

* had to enableInterceptors() explicitly
* beans.xml seem in place, but not clear WeldSE is picking up on it. 
* put a typo in the beans.xml interceptors tags and WELD isn't complaining?
* maybe running from gradle is NOT correctly making a BDU (and just running from 'classes') as w/o addPackage(); Weld complains: no bean archives found


I run via: 
```
./gradlew run
```

## Some Discoveries After Some Tinkering

* So gradle 'application' or a custom run task WILL not have a proper bean archive, it will just use classes and resources in the build area. 
* Weld SE will treat this environment (classes with META-INF in classpath) as a synthetic BDU, and that will require manual stuff in the during container setup up (including enableInterceptor()). 
* Using an uberJar, and running via java -jar makes weld more 'comfortable' an the uberJar appears like a proper BDU to WELD and it properly sets up stuff via beans.xml
* Once in uberJar, Weld started barfing about typo in beans.xml -- yay!
* In the synthetic BDU mode, WELD was cavalier about CDI beans. It made a @Named, a CDI bean, when maybe it shouldn't. An addPackage() call duing CDI boot may have caused this; I don't know. At any rate, salient point is that @Named isn't a bean defining attribute. 


So now I run via: 
```
./gradlew clean build
java -jar build/libs/sample_java_se_cdi_interceptor-all.jar
```

This behaves well and matches my expectations.  Having said that, this work was 
born out of a Jersey/JavaSE/CDI issue and that project was using a different packaging
where a synthetic BDU was NOT in play (or I don't think it is).  Further in that
work, Jersey-CDI2-SE was booting weld and there was no explicit use of SeContainer
and there still seems to be an issue with interceptors there. 

