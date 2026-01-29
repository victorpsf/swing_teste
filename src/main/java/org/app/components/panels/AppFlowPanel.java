package org.app.components.panels;

import java.awt.FlowLayout;
import java.util.Optional;
import java.util.UUID;

import javax.swing.JPanel;

import org.app.models.enumerables.EComponentType;
import org.app.models.enumerables.EFlowLayoutAlign;
import org.app.models.interfaces.IComponent;

public class AppFlowPanel extends AppPanelBehavior implements IComponent {
    @Override
    public UUID getId() { return this.id; }
    @Override
    public EComponentType getType() { return EComponentType.PANEL; }
    @Override
    public void addChildren(IComponent children) {
        this.jpanel.add(children.getOriginalElement());
        this.childrens.add(children);
    }

    private AppFlowPanel(
        UUID id,
        JPanel jPanel
    ) {
        this.id = id;
        this.jpanel = jPanel;
    }

    public AppFlowPanel(
        UUID id,
        FlowLayout flowLayout
    ) {
        this(
            id,
            new JPanel(flowLayout)
        );
    }

    public AppFlowPanel(
        EFlowLayoutAlign align,
        int hgap, 
        int vgap
    ) {
        this(
            UUID.randomUUID(),
            new FlowLayout(
                align.getId(), 
                Optional.ofNullable(hgap).orElse(5),
                Optional.ofNullable(vgap).orElse(5)
            )
        );
    }

    public AppFlowPanel() {
        this(
            EFlowLayoutAlign.CENTER,
            5,
            5
        );
    }
}
