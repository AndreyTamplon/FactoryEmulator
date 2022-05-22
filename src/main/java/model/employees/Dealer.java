package model.employees;

import model.product_factory.products.Car;
import model.storage_facilities.StorageTerminal;
import threadpool.Task;

import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dealer implements Task
{
    private static final Logger logger = Logger.getLogger(Dealer.class.getName());
    private final String name;
    private final StorageTerminal storageTerminal;
    private final boolean loggingEnabled;
    private long delay;

    public Dealer(String name, long delay, StorageTerminal storageTerminal, boolean loggingEnabled)
    {
        this.name = name;
        this.delay = delay;
        this.loggingEnabled = loggingEnabled;
        this.storageTerminal = storageTerminal;
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
                Car car = storageTerminal.getCarStorage().retrieve();
                if (loggingEnabled)
                {
                    logger.log(Level.INFO,
                            LocalDateTime.now() + " "
                                    + name + ": Auto"
                                    + car.getId() + " (Body: " + car.getBody().getId()
                                    + " Engine: " + car.getEngine().getId()
                                    + " Accessory: " + car.getAccessory().getId() + ")");
                }
            }
            catch (InterruptedException e)
            {
                break;
            }
        }
    }
}
