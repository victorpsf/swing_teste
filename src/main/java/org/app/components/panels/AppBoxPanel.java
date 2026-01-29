package org.app.components.panels;

import java.util.UUID;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.app.models.enumerables.EBoxLayout;
import org.app.models.enumerables.EComponentType;
import org.app.models.interfaces.IComponent;

public class AppBoxPanel extends AppPanelBehavior implements IComponent {
    @Override
    public UUID getId() { return this.id; }
    @Override
    public EComponentType getType() { return EComponentType.PANEL; }
    @Override
    public void addChildren(IComponent children) {
        this.jpanel.add(children.getOriginalElement());
        this.childrens.add(children);
    }

    public AppBoxPanel(EBoxLayout boxLayout) {
        this.id = UUID.randomUUID();
        this.jpanel = new JPanel();
        this.jpanel.setLayout(new BoxLayout(jpanel, boxLayout.getId()));
    }

    public AppBoxPanel() {
        this(EBoxLayout.LINE_AXIS);
    }
}