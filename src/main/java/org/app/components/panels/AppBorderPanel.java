package org.app.components.panels;

import java.awt.BorderLayout;
import java.util.UUID;

import javax.swing.JPanel;

import org.app.models.enumerables.EComponentType;
import org.app.models.interfaces.IComponent;

public class AppBorderPanel extends AppPanelBehavior implements IComponent {
    @Override
    public UUID getId() { return this.id; }
    @Override
    public EComponentType getType() { return EComponentType.PANEL; }
    @Override
    public void addChildren(IComponent children) {
        this.jpanel.add(children.getOriginalElement());
        this.childrens.add(children);
    }

    public AppBorderPanel() {
        this.id = UUID.randomUUID();
        this.jpanel = new JPanel(new BorderLayout());
    }
}
