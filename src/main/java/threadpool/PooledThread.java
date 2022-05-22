package threadpool;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PooledThread extends Thread
{
    private static final Logger logger = Logger.getLogger(PooledThread.class.getName());
    private final List<Task> taskQueue;

    public PooledThread(String name, List<Task> taskQueue)
    {
        super(name);
        this.taskQueue = taskQueue;
    }

    @Override
    public void run()
    {
        Task toExecute;
        while (true)
        {
            synchronized (taskQueue)
            {
                if (taskQueue.isEmpty())
                {
                    try
                    {
                        taskQueue.wait();
                    }
                    catch (InterruptedException ex)
                    {
                        logger.log(Level.WARNING, String.format("Thread was interrupted: %s", getName()));
                    }
                    continue;
                }
                else
                {
                    toExecute = taskQueue.remove(0);
                }
            }
            try
            {
                toExecute.performWork();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}