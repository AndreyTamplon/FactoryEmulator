package model.employees.unions;

import model.employees.Dealer;
import model.storage_facilities.StorageTerminal;

import java.util.ArrayList;
import java.util.List;

public class DealersUnion
{
    private final ArrayList<Dealer> dealersUnion;

    public DealersUnion(int numberOfDealers, long delay, StorageTerminal storageTerminal, boolean loggingEnabled)
    {
        dealersUnion = new ArrayList<>();
        inviteDealers(numberOfDealers, delay, storageTerminal, loggingEnabled);
    }

    private void inviteDealers(int numberOfDealers, long delay, StorageTerminal storageTerminal, boolean loggingEnabled)
    {
        for (int i = 0; i < numberOfDealers; ++i)
        {
            dealersUnion.add(new Dealer("Dealer " + i, delay, storageTerminal, loggingEnabled));
        }
    }

    public void setDelay(long newDelay)
    {
        for (Dealer dealer : dealersUnion)
        {
            dealer.setDelay(newDelay);
        }
    }


    public List<Dealer> getDealersUnion()
    {
        return dealersUnion;
    }
}
