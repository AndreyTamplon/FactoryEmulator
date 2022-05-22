package model.employees.unions;

import model.employees.Worker;
import model.product_factory.CarCreator;
import model.storage_facilities.StorageTerminal;

import java.util.ArrayList;
import java.util.List;

public class WorkersUnion
{
    private final ArrayList<Worker> workersUnion;

    public WorkersUnion(int numberOfWorkers,
                        StorageTerminal storageTerminal,
                        CarCreator carCreator)
    {
        workersUnion = new ArrayList<>();
        inviteWorkers(numberOfWorkers, storageTerminal, carCreator);
    }

    private void inviteWorkers(int numberOfWorkers,
                               StorageTerminal storageTerminal,
                               CarCreator carCreator)
    {
        for (int i = 0; i < numberOfWorkers; ++i)
        {
            workersUnion.add(new Worker("Worker " + i,
                    storageTerminal,
                    carCreator));
        }
    }

    public List<Worker> getWorkersUnion()
    {
        return workersUnion;
    }
}
