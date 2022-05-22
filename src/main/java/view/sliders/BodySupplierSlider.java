package view.sliders;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class BodySupplierSlider extends JPanel
{
    JSlider slider;
    JLabel label;

    public BodySupplierSlider(Controller controller)
    {
        setBackground(Color.WHITE);
        slider = new JSlider(0, 2000, 1000);
        slider.setMajorTickSpacing(1);
        slider.setBackground(Color.WHITE);
        slider.setPaintTicks(true);
        label = new JLabel("Body supplier" + " delay: " + slider.getValue() + " milliseconds");
        slider.addChangeListener(e ->
        {
            controller.processCommand("SetBodySupplierDelayCommand", (long) slider.getValue());
            label.setText("Body supplier" + " delay: " + slider.getValue() + " milliseconds");
        });
        add(label);
        add(slider);
    }
}
