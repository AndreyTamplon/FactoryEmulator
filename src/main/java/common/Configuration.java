package common;

import exceptions.ConfigurationException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration
{
    private final Properties properties;

    public Configuration(String configurationFileName) throws ConfigurationException
    {
        properties = new Properties();
        try (InputStream inputStream = Configuration.class.getResourceAsStream(configurationFileName))
        {
            properties.load(inputStream);
        }
        catch (NullPointerException | IOException e)
        {
            throw new ConfigurationException("Failed to load configuration file");
        }
    }

    public Properties getProperties()
    {
        return properties;
    }

    public int getBodyStorageSize()
    {
        return Integer.parseInt(properties.getProperty("BodyStorageSize"));
    }

    public int getCarStorageSize()
    {
        return Integer.parseInt(properties.getProperty("CarStorageSize"));
    }

    public int getAccessoryStorageSize()
    {
        return Integer.parseInt(properties.getProperty("AccessoryStorageSize"));
    }

    public int getEngineStorageSize()
    {
        return Integer.parseInt(properties.getProperty("EngineStorageSize"));
    }

    public int getNumberOfAccessorySuppliers()
    {
        return Integer.parseInt(properties.getProperty("AccessorySuppliers"));
    }

    public int getNumberOfWorkers()
    {
        return Integer.parseInt(properties.getProperty("Workers"));
    }

    public int getNumberOfDealers()
    {
        return Integer.parseInt(properties.getProperty("Dealers"));
    }

    public boolean isLoggingEnabled()
    {
        return Boolean.parseBoolean(properties.getProperty("Log"));
    }
}