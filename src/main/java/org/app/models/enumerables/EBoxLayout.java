package org.app.models.enumerables;

public enum EBoxLayout {
    X_AXIS(0),
    Y_AXIS(1),
    LINE_AXIS(2),
    PAGE_AXIS(3);

    private Integer id;

    EBoxLayout(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public boolean is(EBoxLayout vEnum) {
        return this.id.equals(vEnum.id);
    }
}
