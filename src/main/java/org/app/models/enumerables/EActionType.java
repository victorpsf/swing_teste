package org.app.models.enumerables;

public enum EActionType {
    RESIZE(1, EActionComponentType.COMPONENT),
    MOVE(2, EActionComponentType.COMPONENT),
    SHOW(3, EActionComponentType.COMPONENT),
    HIDDEN(4, EActionComponentType.COMPONENT),
    
    OPENED(1, EActionComponentType.WINDOW),
    CLOSING(2, EActionComponentType.WINDOW),
    CLOSED(3, EActionComponentType.WINDOW),
    MINIMIZED(4, EActionComponentType.WINDOW),
    RESTORE(5, EActionComponentType.WINDOW),
    ACTIVATED(6, EActionComponentType.WINDOW),
    DEACTIVATED(7, EActionComponentType.WINDOW);

    private final Integer id;
    private final EActionComponentType actionComponent;

    EActionType(
        Integer id,
        EActionComponentType actionComponent
    ) {
        this.id = id;
        this.actionComponent = actionComponent;
    }

    public Integer getId() {
        return this.id;
    }

    public EActionComponentType getActionComponent() {
        return this.actionComponent;
    }

    public boolean is(EActionType vEnum) {
        return (
            this.id.equals(vEnum.id) &&
            this.actionComponent.is(vEnum.actionComponent)
        );
    }
}
