package view.sliders;

import controller.Controller;

import javax.swing.*;
import java.awt.*;

public class DealersSlider extends JPanel
{
    JSlider slider;
    JLabel label;

    public DealersSlider(Controller controller)
    {
        setBackground(Color.WHITE);
        slider = new JSlider(0, 2000, 1000);
        slider.setMajorTickSpacing(1);
        slider.setBackground(Color.WHITE);
        slider.setPaintTicks(true);
        label = new JLabel("Dealers" + " delay: " + slider.getValue() + " milliseconds");
        slider.addChangeListener(e ->
        {
            controller.processCommand("SetDealersDelayCommand", (long) slider.getValue());
            label.setText("Dealers supplier" + " delay: " + slider.getValue() + " milliseconds");
        });
        add(label);
        add(slider);
    }
}
