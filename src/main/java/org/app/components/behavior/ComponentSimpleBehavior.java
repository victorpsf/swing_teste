package org.app.components.behavior;

import java.util.ArrayList;
import java.util.List;

import org.app.components.delegates.FormActionDelegate;
import org.app.models.enumerables.EActionType;

public class ComponentSimpleBehavior extends ComponentProperties {
    public ComponentSimpleBehavior addListener(EActionType type, FormActionDelegate delegate) {
        List<FormActionDelegate> callers = new ArrayList<>();

        if (this.listeners.containsKey(type))
            callers = this.listeners.get(type);

        callers.add(delegate);
        this.listeners.put(type, callers);

        return this;
    }

    protected List<FormActionDelegate> getActions(EActionType type) {
        List<FormActionDelegate> callers = new ArrayList<>();

        if (this.listeners.containsKey(type))
            callers = this.listeners.get(type);

        return callers;
    }
}
