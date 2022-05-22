package model.product_factory;

import model.product_factory.products.Body;
import model.product_factory.products.Product;

public class BodyCreator extends ProductCreator<Body>
{
    public BodyCreator()
    {
        super(new SerialNumberGenerator());
    }

    @Override
    public Body createProduct(Product... products)
    {
        return new Body(serialNumberGenerator.getNewSerialNumber());
    }
}
