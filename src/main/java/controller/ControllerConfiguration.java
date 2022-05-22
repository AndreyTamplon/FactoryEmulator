package controller;

import common.Configuration;
import exceptions.ConfigurationException;

import java.io.IOException;

public class ControllerConfiguration extends Configuration
{
    public ControllerConfiguration(String configurationFileName) throws ConfigurationException
    {
        super(configurationFileName);
    }

    public String getCommandClassPath(String commandName)
    {
        return getProperties().getProperty(commandName);
    }

    public String getCommandNameByKeyCode(int keyCode)
    {
        return getProperties().getProperty(Integer.toString(keyCode));
    }

    public void setConfiguration(String configurationFileName) throws IOException
    {
        getProperties().load(ControllerConfiguration.class.getResourceAsStream(configurationFileName));
    }
}