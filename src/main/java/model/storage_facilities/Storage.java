package model.storage_facilities;

import common.Publisher;
import model.product_factory.products.Product;

import java.util.LinkedList;
import java.util.Queue;

public class Storage<P extends Product> extends Publisher
{
    private final Queue<P> products;
    private final long maximumProductQuantity;
    private long numberOfProductsProduced;

    public Storage(long maximumProductQuantity)
    {
        this.maximumProductQuantity = maximumProductQuantity;
        products = new LinkedList<>();
        numberOfProductsProduced = 0;
    }

    public long getNumberOfProductsProduced()
    {
        return numberOfProductsProduced;
    }

    public synchronized void put(P p)
    {
        while (true)
        {
            if (isFull())
            {
                try
                {
                    wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                break;
            }
        }
        products.add(p);
        numberOfProductsProduced++;
        notifySubscribers();
        notify();

    }

    public synchronized P retrieve()
    {
        while (true)
        {
            if (isEmpty())
            {
                try
                {
                    wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                break;
            }
        }
        P product = products.poll();
        notifySubscribers();
        notify();
        return product;
    }

    public long getCurrentWorkload()
    {
        return products.size();
    }

    public boolean isEmpty()
    {
        return products.isEmpty();
    }

    public boolean isFull()
    {
        return products.size() == maximumProductQuantity;
    }
}
