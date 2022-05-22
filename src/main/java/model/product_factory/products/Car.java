package model.product_factory.products;

public class Car extends Product
{
    private final Product body;
    private final Product engine;
    private final Product accessory;

    public Car(long id, Product body, Product engine, Product accessory)
    {
        super(id);
        this.body = body;
        this.engine = engine;
        this.accessory = accessory;
    }

    public Product getBody()
    {
        return body;
    }

    public Product getEngine()
    {
        return engine;
    }

    public Product getAccessory()
    {
        return accessory;
    }
}
