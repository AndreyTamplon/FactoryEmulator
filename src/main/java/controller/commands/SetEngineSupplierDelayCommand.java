package controller.commands;

import controller.Command;
import exceptions.CommandException;
import exceptions.InvalidArguments;
import model.FactoryTerminal;

public class SetEngineSupplierDelayCommand implements Command
{
    @Override
    public void execute(FactoryTerminal factoryTerminal, Long... arguments) throws CommandException
    {
        if (arguments == null)
        {
            throw new InvalidArguments("Too few arguments");
        }
        else
        {
            factoryTerminal.getEmployeesTerminal().setEngineSupplierDelay(arguments[0]);
        }
    }
}
