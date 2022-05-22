package model.product_factory;

import model.product_factory.products.Product;

public abstract class ProductCreator<P extends Product>
{
    protected SerialNumberGenerator serialNumberGenerator;

    protected ProductCreator(SerialNumberGenerator serialNumberGenerator)
    {
        this.serialNumberGenerator = serialNumberGenerator;
    }

    public abstract P createProduct(Product... products);
}
