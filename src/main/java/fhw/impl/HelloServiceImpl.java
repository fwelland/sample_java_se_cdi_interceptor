package fhw.impl;
import fhw.PINTransactional;
import fhw.contracts.BadCodeException;
import fhw.contracts.HelloService;
import javax.enterprise.context.Dependent;


@Dependent
public class HelloServiceImpl
        implements HelloService
{
    @Override
    @PINTransactional
    public String sayHello(Integer code)
            throws BadCodeException
    {
        String message = "hello, the code you passed me was " + code; 
        return(message); 
    }
    
}
