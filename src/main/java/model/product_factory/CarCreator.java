package model.product_factory;

import model.product_factory.products.*;

public class CarCreator extends ProductCreator<Car>
{
    public CarCreator()
    {
        super(new SerialNumberGenerator());
    }


    @Override
    public Car createProduct(Product... products)
    {
        Product engine = null;
        Product body = null;
        Product accessory = null;
        for (Product product : products)
        {
            if (product.getClass() == Engine.class)
            {
                engine = product;
            }
        }
        for (Product product : products)
        {
            if (product.getClass() == Body.class)
            {
                body = product;
            }
        }
        for (Product product : products)
        {
            if (product.getClass() == Accessory.class)
            {
                accessory = product;
            }
        }

        return new Car(serialNumberGenerator.getNewSerialNumber(), body, engine, accessory);
    }
}
