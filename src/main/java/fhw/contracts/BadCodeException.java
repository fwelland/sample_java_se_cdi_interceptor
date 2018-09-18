package fhw.contracts;

public class BadCodeException
    extends Exception
{
    private static final long serialVersionUID = -7996855850542076267L;
    
    public BadCodeException(String msg)
    {
        super(msg);
    }
}
