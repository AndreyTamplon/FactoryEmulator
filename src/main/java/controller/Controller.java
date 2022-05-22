package controller;

import exceptions.CommandException;
import exceptions.InvalidCommand;
import model.FactoryTerminal;

public abstract class Controller
{
    FactoryTerminal factoryTerminal;

    protected Controller(FactoryTerminal factoryTerminal)
    {
        this.factoryTerminal = factoryTerminal;
    }

    protected void executeCommand(String commandName, Long... arguments) throws CommandException
    {
        try
        {
            Command command = createCommand(commandName);
            command.execute(factoryTerminal, arguments);
        }
        catch (InvalidCommand e)
        {
            throw new CommandException("Couldn't create command");
        }
    }

    public abstract void processCommand(int keycode, Long... arguments);

    public abstract void processCommand(String commandName, Long... arguments);

    protected abstract Command createCommand(String commandName) throws InvalidCommand;

}