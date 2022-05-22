package model.employees.unions;

import model.employees.Supplier;
import model.product_factory.ProductCreator;
import model.product_factory.products.Accessory;
import model.storage_facilities.StorageTerminal;

import java.util.ArrayList;
import java.util.List;

public class AccessorySuppliersUnion
{
    private final ArrayList<Supplier<Accessory>> accessorySuppliersUnion;

    public AccessorySuppliersUnion(int numberOfAccessorySuppliers,
                                   long delay,
                                   StorageTerminal storageTerminal,
                                   ProductCreator<Accessory> accessoryCreator)
    {
        accessorySuppliersUnion = new ArrayList<>();
        inviteAccessorySuppliers(numberOfAccessorySuppliers, delay, storageTerminal, accessoryCreator);
    }

    private void inviteAccessorySuppliers(int numberOfAccessorySuppliers,
                                          long delay,
                                          StorageTerminal storageTerminal,
                                          ProductCreator<Accessory> accessoryCreator)
    {
        for (int i = 0; i < numberOfAccessorySuppliers; ++i)
        {
            accessorySuppliersUnion.add(new Supplier<>("accessorySupplier " + i, delay,
                    storageTerminal.getAccessoryStorage(), accessoryCreator));
        }
    }

    public void setDelay(long newDelay)
    {
        for (Supplier<Accessory> accessorySupplier : accessorySuppliersUnion)
        {
            accessorySupplier.setDelay(newDelay);
        }
    }

    public List<Supplier<Accessory>> getAccessorySuppliersUnion()
    {
        return accessorySuppliersUnion;
    }
}
