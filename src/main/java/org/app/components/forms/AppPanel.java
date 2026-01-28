package org.app.components.forms;

import java.util.UUID;

import javax.swing.JFrame;

import org.app.components.behavior.ComponentBehavior;
import org.app.models.enumerables.EComponentType;
import org.app.models.interfaces.IComponent;

public class AppPanel extends ComponentBehavior implements IComponent {
    private JFrame jFrame;

    public String getTitle() { return this.jFrame.getTitle(); }
    public AppPanel setTitle(String title) {
        this.jFrame.setTitle(title);
        return this;
    }

    public AppPanel() {
        this.id = UUID.randomUUID();
        this.jFrame = new JFrame();
    }

    @Override
    public UUID getId() { return this.id; }

    @Override
    public EComponentType getType() { return EComponentType.PANEL; }
}
