package controller;

import exceptions.CommandException;
import model.FactoryTerminal;

public interface Command
{
    void execute(FactoryTerminal factoryTerminal, Long... arguments) throws CommandException;
}
