package org.app.components.panels;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.swing.JPanel;

import org.app.components.behavior.ComponentSimpleBehavior;
import org.app.components.styles.ComponentStyle;
import org.app.models.enumerables.EComponentType;
import org.app.models.enumerables.EWindowViewState;
import org.app.models.interfaces.IComponent;

public abstract class AppPanelBehavior extends ComponentSimpleBehavior {
    protected JPanel jpanel;
    public Component getOriginalElement() { return this.jpanel; }

    private EWindowViewState windowViewState = EWindowViewState.NORMAL;
    protected List<IComponent> childrens = new ArrayList<>();

    public List<IComponent> getChildrens() { return this.childrens; }

    public Optional<IComponent> getChildren(final EComponentType type) {
        return this.getChildrens()
            .stream()
            .filter(a-> a.getType().is(type))
            .findFirst();
    }

    public abstract void addChildren(IComponent children);

    public EWindowViewState getWindowViewState() { return this.windowViewState; }
    public void setWindowViewState(EWindowViewState windowViewState) { this.windowViewState = windowViewState; }
    
    public void setPreferredSize(Dimension dimension) {
        this.jpanel.setPreferredSize(dimension);
    }

    public void setMaximumSize(Dimension dimension) {
        this.jpanel.setMaximumSize(dimension);
    }

    public void setMinimumSize(Dimension dimension) {
        this.jpanel.setMinimumSize(dimension);
    }

    public void setPreferredSize(Integer width, Integer height) {
        this.setPreferredSize(
            new Dimension(
                width, 
                height
            )
        );
    }

    public void setMaximumSize(Integer width, Integer height) {
        this.setMaximumSize(
            new Dimension(
                width, 
                height
            )
        );
    }

    public void setMinimumSize(Integer width, Integer height) {
        this.setMinimumSize(
            new Dimension(
                width, 
                height
            )
        );
    }

    public void defineStyle(ComponentStyle style) {
        this.style = style;

        if (Objects.nonNull(style.getBackgroundColor()))
            this.jpanel.setBackground(style.getBackgroundColor());

        if (Objects.nonNull(style.getForegroundColor()))
            this.jpanel.setForeground(style.getForegroundColor());
    }
}
