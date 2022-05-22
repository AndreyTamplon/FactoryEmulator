package threadpool;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreadPool
{
    private final List<Task> taskQueue = new LinkedList<>();
    Set<PooledThread> availableThreads = new HashSet<>();

    public ThreadPool(int numberOfThreads)
    {
        for (int i = 0; i < numberOfThreads; i++)
        {
            availableThreads.add(new PooledThread("Performer " + i, taskQueue));
        }
        for (PooledThread availableThread : availableThreads)
        {
            availableThread.start();
        }
    }

    public void addTask(Task t)
    {
        synchronized (taskQueue)
        {
            taskQueue.add(t);
            taskQueue.notify();
        }
    }
}