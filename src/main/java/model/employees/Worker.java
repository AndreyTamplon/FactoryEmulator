package model.employees;

import model.product_factory.CarCreator;
import model.product_factory.products.Accessory;
import model.product_factory.products.Body;
import model.product_factory.products.Car;
import model.product_factory.products.Engine;
import model.storage_facilities.StorageTerminal;
import threadpool.Task;


public class Worker implements Task
{
    private final String name;
    private final StorageTerminal storageTerminal;
    private final CarCreator carCreator;


    public Worker(String name, StorageTerminal storageTerminal, CarCreator carCreator)
    {
        this.name = name;
        this.storageTerminal = storageTerminal;
        this.carCreator = carCreator;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public void performWork()
    {
        while (true)
        {
            Body body = storageTerminal.getBodyStorage().retrieve();
            Engine engine = storageTerminal.getEngineStorage().retrieve();
            Accessory accessory = storageTerminal.getAccessoryStorage().retrieve();
            Car car = carCreator.createProduct(body, engine, accessory);
            storageTerminal.getCarStorage().put(car);
        }
    }
}
