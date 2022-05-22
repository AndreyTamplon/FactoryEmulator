package model.employees;

import model.employees.unions.AccessorySuppliersUnion;
import model.employees.unions.DealersUnion;
import model.employees.unions.WorkersUnion;
import model.product_factory.products.Body;
import model.product_factory.products.Engine;
import threadpool.Task;

import java.util.ArrayList;
import java.util.List;

public class EmployeesTerminal
{
    private final AccessorySuppliersUnion accessorySuppliersUnion;
    private final DealersUnion dealersUnion;
    private final WorkersUnion workersUnion;
    private final Supplier<Body> bodySupplier;
    private final Supplier<Engine> engineSupplier;
    private ArrayList<Task> employees;

    public EmployeesTerminal(AccessorySuppliersUnion accessorySuppliersUnion,
                             DealersUnion dealersUnion,
                             WorkersUnion workersUnion,
                             Supplier<Body> bodySupplier,
                             Supplier<Engine> engineSupplier)
    {
        this.accessorySuppliersUnion = accessorySuppliersUnion;
        this.dealersUnion = dealersUnion;
        this.workersUnion = workersUnion;
        this.bodySupplier = bodySupplier;
        this.engineSupplier = engineSupplier;
        createEmployeesList();
    }

    private void createEmployeesList()
    {
        employees = new ArrayList<>();
        employees.add(bodySupplier);
        employees.add(engineSupplier);
        employees.addAll(accessorySuppliersUnion.getAccessorySuppliersUnion());
        employees.addAll(workersUnion.getWorkersUnion());
        employees.addAll(dealersUnion.getDealersUnion());
    }

    public void setAccessorySuppliersUnionDelay(long newDelay)
    {
        accessorySuppliersUnion.setDelay(newDelay);
    }

    public void setDealersUnionDelay(long newDelay)
    {
        dealersUnion.setDelay(newDelay);
    }

    public void setBodySupplierDelay(long newDelay)
    {
        bodySupplier.setDelay(newDelay);
    }

    public void setEngineSupplierDelay(long newDelay)
    {
        engineSupplier.setDelay(newDelay);
    }

    public List<Task> getEmployees()
    {
        return employees;
    }

    public int getNumberOfEmployees()
    {
        return employees.size();
    }
}
