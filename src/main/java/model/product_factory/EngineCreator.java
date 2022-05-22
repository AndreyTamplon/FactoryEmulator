package model.product_factory;

import model.product_factory.products.Engine;
import model.product_factory.products.Product;

public class EngineCreator extends ProductCreator<Engine>
{
    public EngineCreator()
    {
        super(new SerialNumberGenerator());
    }

    @Override
    public Engine createProduct(Product... products)
    {
        return new Engine(serialNumberGenerator.getNewSerialNumber());
    }
}
