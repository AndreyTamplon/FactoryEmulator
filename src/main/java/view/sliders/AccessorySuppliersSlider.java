package view.sliders;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class AccessorySuppliersSlider extends JPanel
{
    JSlider slider;
    JLabel label;

    public AccessorySuppliersSlider(Controller controller)
    {
        setBackground(Color.WHITE);
        slider = new JSlider(0, 2000, 1000);
        slider.setMajorTickSpacing(1);
        slider.setBackground(Color.WHITE);
        slider.setPaintTicks(true);
        label = new JLabel("Accessory suppliers" + " delay: " + slider.getValue() + " milliseconds");
        slider.addChangeListener(e ->
        {
            controller.processCommand("SetAccessorySuppliersDelayCommand", (long) slider.getValue());
            label.setText("Accessory suppliers" + " delay: " + slider.getValue() + " milliseconds");
        });
        label = new JLabel("Accessory suppliers" + " delay: " + slider.getValue() + " milliseconds");
        add(label);
        add(slider);
    }
}
