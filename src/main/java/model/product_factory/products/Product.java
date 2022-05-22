package model.product_factory.products;

public abstract class Product
{
    private final long id;

    protected Product(long id)
    {
        this.id = id;
    }

    public long getId()
    {
        return id;
    }
}
