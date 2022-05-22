package model.product_factory;

public class SerialNumberGenerator
{
    private long lastIssuedSerialNumber;

    public SerialNumberGenerator()
    {
        lastIssuedSerialNumber = 0;
    }

    public long getNewSerialNumber()
    {
        lastIssuedSerialNumber++;
        return lastIssuedSerialNumber;
    }
}
