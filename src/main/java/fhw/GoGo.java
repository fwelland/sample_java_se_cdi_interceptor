package fhw;
import fhw.contracts.BadCodeException;
import fhw.contracts.HelloService;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.context.control.ActivateRequestContext;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
@ActivateRequestContext
public class GoGo
{        
    @Inject
    private HelloService service; 
     
    @PostConstruct
    private void postConstruct()
    {
        System.out.println("fhw.GoGo.postConstruct()");
    }
    
    public void init(@Observes @Initialized(ApplicationScoped.class) Object o)
    {
        System.out.println("fhw.GoGo.init(): " + o);
        go(); 
    }
    
    
    private void go()
    {
        System.out.println("fhw.GoGo.go()");
        try
        {
            String result = service.sayHello(12); 
            System.out.println(result);            
        }
        catch(BadCodeException bce)
        {
            bce.printStackTrace();
        }
    }    
}