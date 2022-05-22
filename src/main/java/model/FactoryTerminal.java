package model;

import model.employees.EmployeesTerminal;
import model.storage_facilities.StorageTerminal;

public class FactoryTerminal
{
    private final StorageTerminal storageTerminal;
    private final EmployeesTerminal employeesTerminal;

    public FactoryTerminal(StorageTerminal storageTerminal, EmployeesTerminal employeesTerminal)
    {
        this.storageTerminal = storageTerminal;
        this.employeesTerminal = employeesTerminal;
    }

    public StorageTerminal getStorageTerminal()
    {
        return storageTerminal;
    }

    public EmployeesTerminal getEmployeesTerminal()
    {
        return employeesTerminal;
    }
}
