package model.storage_facilities;

import common.Publisher;
import common.Subscriber;
import model.product_factory.products.Accessory;
import model.product_factory.products.Body;
import model.product_factory.products.Car;
import model.product_factory.products.Engine;

public class StorageTerminal extends Publisher implements Subscriber
{
    private final Storage<Body> bodyStorage;
    private final Storage<Accessory> accessoryStorage;
    private final Storage<Engine> engineStorage;
    private final Storage<Car> carStorage;

    public StorageTerminal(int bodyStorageSize, int accessoryStorageSize, int carStorageSize, int engineStorageSize)
    {
        bodyStorage = new Storage<>(bodyStorageSize);
        accessoryStorage = new Storage<>(accessoryStorageSize);
        engineStorage = new Storage<>(engineStorageSize);
        carStorage = new Storage<>(carStorageSize);
        bodyStorage.subscribe(this);
        accessoryStorage.subscribe(this);
        engineStorage.subscribe(this);
        carStorage.subscribe(this);
    }

    public Storage<Body> getBodyStorage()
    {
        return bodyStorage;
    }

    public Storage<Accessory> getAccessoryStorage()
    {
        return accessoryStorage;
    }

    public Storage<Engine> getEngineStorage()
    {
        return engineStorage;
    }

    public Storage<Car> getCarStorage()
    {
        return carStorage;
    }

    public long getBodyStorageWorkload()
    {
        return bodyStorage.getCurrentWorkload();
    }

    public long getAccessoryStorageWorkload()
    {
        return accessoryStorage.getCurrentWorkload();
    }

    public long getEngineStorageWorkload()
    {
        return engineStorage.getCurrentWorkload();
    }

    public long getCarStorageWorkload()
    {
        return carStorage.getCurrentWorkload();
    }

    public long getNumberOfBodiesProduced()
    {
        return bodyStorage.getNumberOfProductsProduced();
    }

    public long getNumberOfEnginesProduced()
    {
        return engineStorage.getNumberOfProductsProduced();
    }

    public long getNumberOfAccessoriesProduced()
    {
        return accessoryStorage.getNumberOfProductsProduced();
    }

    public long getNumberOfCarsProduced()
    {
        return carStorage.getNumberOfProductsProduced();
    }

    @Override
    public void update(Publisher model)
    {
        notifySubscribers();
    }
}
