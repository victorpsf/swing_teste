package org.app.components.behavior;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.app.models.enumerables.EComponentType;
import org.app.models.enumerables.EWindowViewState;
import org.app.models.interfaces.IComponent;

public abstract class ComponentBehavior extends ComponentSimpleBehavior {
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
}
