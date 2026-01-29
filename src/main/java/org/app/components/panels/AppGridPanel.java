package org.app.components.panels;

import java.awt.GridLayout;
import java.util.Optional;
import java.util.UUID;

import javax.swing.JPanel;

import org.app.models.enumerables.EComponentType;
import org.app.models.interfaces.IComponent;

public class AppGridPanel extends AppPanelBehavior implements IComponent {
    @Override
    public UUID getId() { return this.id; }
    @Override
    public EComponentType getType() { return EComponentType.PANEL; }
    @Override
    public void addChildren(IComponent children) {
        this.jpanel.add(children.getOriginalElement());
        this.childrens.add(children);
    }

    private AppGridPanel(
        final UUID id,
        final JPanel panel
    ) {
        this.id = id;
        this.jpanel = panel;
    }

    private AppGridPanel(
        final UUID id,
        final GridLayout gridLayout
    ) {
        this(
            id,
            new JPanel(gridLayout)
        );
    }

    public AppGridPanel(
        final int rows,
        final int cols,
        final int hgap,
        final int vgap
    ) {
        this(
            UUID.randomUUID(),
            new GridLayout(
                Optional.ofNullable(rows).orElse(1), 
                Optional.ofNullable(cols).orElse(0), 
                Optional.ofNullable(hgap).orElse(0), 
                Optional.ofNullable(vgap).orElse(0)
            )
        );
    }

    public AppGridPanel() {
        this(
            UUID.randomUUID(),
            new GridLayout()
        );
    }
}
