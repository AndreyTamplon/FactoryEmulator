package model.product_factory;

import model.product_factory.products.Accessory;
import model.product_factory.products.Product;

public class AccessoriesCreator extends ProductCreator<Accessory>
{
    public AccessoriesCreator()
    {
        super(new SerialNumberGenerator());
    }

    @Override
    public Accessory createProduct(Product... products)
    {
        return new Accessory(serialNumberGenerator.getNewSerialNumber());
    }
}
