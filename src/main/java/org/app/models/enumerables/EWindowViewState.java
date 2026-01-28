package org.app.models.enumerables;

public enum EWindowViewState {
    ICONIFIED(1),
    NORMAL(2),
    MAXIMIZED(3);

    private Integer id;

    EWindowViewState(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public boolean is(EWindowViewState vEnum) {
        return this.id.equals(vEnum);
    }
}
