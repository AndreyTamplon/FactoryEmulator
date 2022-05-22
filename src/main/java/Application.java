import common.Configuration;
import controller.BasicController;
import controller.Controller;
import exceptions.ConfigurationException;
import model.FactoryTerminal;
import model.employees.EmployeesTerminal;
import model.employees.Supplier;
import model.employees.unions.AccessorySuppliersUnion;
import model.employees.unions.DealersUnion;
import model.employees.unions.WorkersUnion;
import model.product_factory.AccessoriesCreator;
import model.product_factory.BodyCreator;
import model.product_factory.CarCreator;
import model.product_factory.EngineCreator;
import model.product_factory.products.Body;
import model.product_factory.products.Engine;
import model.storage_facilities.StorageTerminal;
import threadpool.Task;
import threadpool.ThreadPool;
import view.MainFrame;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Application
{
    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args)
    {
        try
        {
            LogManager.getLogManager().readConfiguration(Application.class.getResourceAsStream("logger.properties"));
        }
        catch (NullPointerException | IOException e)
        {
            logger.log(Level.SEVERE, "Couldn't configure logger", e);
            return;
        }
        Configuration configuration;
        try
        {
            configuration = new Configuration("/FactoryConfiguration.properties");
        }
        catch (ConfigurationException e)
        {
            logger.log(Level.SEVERE, "Couldn't open configuration file", e);
            return;
        }
        StorageTerminal storageTerminal = new StorageTerminal(
                configuration.getBodyStorageSize(),
                configuration.getAccessoryStorageSize(),
                configuration.getCarStorageSize(),
                configuration.getEngineStorageSize()
        );
        CarCreator carCreator = new CarCreator();
        AccessoriesCreator accessoriesCreator = new AccessoriesCreator();
        BodyCreator bodyCreator = new BodyCreator();
        EngineCreator engineCreator = new EngineCreator();
        AccessorySuppliersUnion accessorySuppliersUnion = new AccessorySuppliersUnion(
                configuration.getNumberOfAccessorySuppliers(),
                1000,
                storageTerminal,
                accessoriesCreator
        );
        DealersUnion dealersUnion = new DealersUnion(
                configuration.getNumberOfDealers(),
                1000,
                storageTerminal,
                configuration.isLoggingEnabled()
        );
        WorkersUnion workersUnion = new WorkersUnion(configuration.getNumberOfWorkers(), storageTerminal, carCreator);
        Supplier<Body> bodySupplier = new Supplier<>(
                "Body supplier",
                1000,
                storageTerminal.getBodyStorage(),
                bodyCreator
        );
        Supplier<Engine> engineSupplier = new Supplier<>(
                "Engine supplier",
                1000,
                storageTerminal.getEngineStorage(),
                engineCreator
        );

        EmployeesTerminal employeesTerminal = new EmployeesTerminal(
                accessorySuppliersUnion,
                dealersUnion,
                workersUnion,
                bodySupplier,
                engineSupplier
        );
        FactoryTerminal factoryTerminal = new FactoryTerminal(storageTerminal, employeesTerminal);
        Controller controller;
        try
        {
            controller = new BasicController("/ControllerConfiguration.properties", factoryTerminal);
        }
        catch (ConfigurationException e)
        {
            e.printStackTrace();
            return;
        }

        MainFrame mainFrame = new MainFrame(factoryTerminal, controller);
        mainFrame.setVisible(true);

        ThreadPool threadPool = new ThreadPool(employeesTerminal.getNumberOfEmployees());
        for (Task employee : employeesTerminal.getEmployees())
        {
            threadPool.addTask(employee);
        }
    }
}
