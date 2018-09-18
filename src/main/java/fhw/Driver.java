package fhw;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

public class Driver
{
    public static void main(String args[])
    {        
        SeContainerInitializer initializer = SeContainerInitializer.newInstance();
        
        try (SeContainer container = initializer
//                .disableDiscovery()
                .addPackages(true,Package.getPackage("fhw"))
                .enableInterceptors(fhw.PINTransactionalInterceptor.class)
                .initialize())
        {
            
            System.out.println("fhw.Driver.main()");
            
        }                                
    }             
}