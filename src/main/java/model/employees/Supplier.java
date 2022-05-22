package model.employees;

import model.product_factory.ProductCreator;
import model.product_factory.products.Product;
import model.storage_facilities.Storage;
import threadpool.Task;

public class Supplier<P extends Product> implements Task
{
    private final String name;
    private final Storage<P> storage;
    private final ProductCreator<P> productCreator;
    private long delay;

    public Supplier(String name, long delay, Storage<P> storage, ProductCreator<P> productCreator)
    {
        this.name = name;
        this.delay = delay;
        this.storage = storage;
        this.productCreator = productCreator;
    }

    public long getDelay()
    {
        return delay;
    }

    public void setDelay(long newDelay)
    {
        delay = newDelay;
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
            try
            {
                Thread.sleep(delay);
                storage.put(productCreator.createProduct());
            }
            catch (InterruptedException e)
            {
                break;
            }
        }
    }
}
