/**
 * Copyright 2018 Promontory Interfinancial Network, LLC
 */
package fhw;

import javax.annotation.Priority;
import javax.interceptor.*;

@Interceptor
//@Transactional(Transactional.TxType.REQUIRES_NEW)
@Priority(Interceptor.Priority.APPLICATION)  
@PINTransactional
public class PINTransactionalInterceptor
{
    
    public PINTransactionalInterceptor()
    {
        System.out.println("TransactionalInterceptor constructed");
    }
    
    @AroundInvoke
    public Object handleTransactionBoudary(InvocationContext context) 
         throws Exception
    {
        System.out.println("handleTransactionBoudary called!");
        return context.proceed();
    } 
}