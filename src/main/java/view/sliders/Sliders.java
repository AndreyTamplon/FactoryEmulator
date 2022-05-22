package view.sliders;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class Sliders extends JPanel
{
    private final Controller controller;

    public Sliders(Controller controller, Rectangle bounds)
    {
        setBounds(bounds);
        setBackground(Color.WHITE);
        this.controller = controller;
        add(new BodySupplierSlider(controller));
        add(new EngineSupplierSlider(controller));
        add(new AccessorySuppliersSlider(controller));
        add(new DealersSlider(controller));
    }
}
