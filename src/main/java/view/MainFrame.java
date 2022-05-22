package view;

import controller.Controller;
import model.FactoryTerminal;
import view.sliders.Sliders;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private final FactoryTerminal factoryTerminal;
    private final Controller controller;

    public MainFrame(FactoryTerminal factoryTerminal, Controller controller)
    {
        this.factoryTerminal = factoryTerminal;
        this.controller = controller;
        initializeUI();
    }

    private void initializeUI()
    {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setFocusable(true);
        setResizable(false);
        add(new FactoryInfoPanel(factoryTerminal.getStorageTerminal(), new Rectangle(0, 0, 600, 300)));
        add(new Sliders(controller, new Rectangle(0, 0, 600, 300)));
    }
}
