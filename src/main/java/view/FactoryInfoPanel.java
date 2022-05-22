package view;

import common.Publisher;
import common.Subscriber;
import model.storage_facilities.StorageTerminal;

import javax.swing.*;
import java.awt.*;

public class FactoryInfoPanel extends JPanel implements Subscriber
{

    private static final Font FONT = new Font(Font.MONOSPACED, Font.BOLD, 16);
    private final StorageTerminal storageTerminal;

    public FactoryInfoPanel(StorageTerminal storageTerminal, Rectangle bounds)
    {
        setBounds(bounds);
        setBackground(Color.WHITE);
        this.storageTerminal = storageTerminal;
        storageTerminal.subscribe(this);
        repaint();
    }

    private void drawInfo(Graphics graphics)
    {
        graphics.setFont(FONT);
        graphics.setColor(new Color(0, 0, 0));
        graphics.drawString(String.format(
                "Body storage workload %d Bodies produced %d",
                storageTerminal.getBodyStorageWorkload(),
                storageTerminal.getNumberOfBodiesProduced()), 0, 50);
        graphics.drawString(String.format(
                "Engine storage workload %d Engines produced %d",
                storageTerminal.getEngineStorageWorkload(),
                storageTerminal.getNumberOfEnginesProduced()), 0, 70);
        graphics.drawString(String.format(
                "Accessory storage workload %d Accessories produced %d",
                storageTerminal.getAccessoryStorageWorkload(),
                storageTerminal.getNumberOfAccessoriesProduced()), 0, 90);
        graphics.drawString(String.format(
                "Cars storage workload %d Cars produced %d Cars sold %d",
                storageTerminal.getCarStorageWorkload(),
                storageTerminal.getNumberOfCarsProduced(),
                storageTerminal.getNumberOfCarsProduced() - storageTerminal.getCarStorageWorkload()), 0, 110);
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        drawInfo(graphics);
    }

    @Override
    public void update(Publisher model)
    {
        repaint();
    }
}
