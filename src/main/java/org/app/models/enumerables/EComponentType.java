package org.app.models.enumerables;

public enum EComponentType {
    FORM(1),
    PANEL(2);

    private Integer id;

    EComponentType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public boolean is(EComponentType vEnum) {
        return this.id.equals(vEnum.id);
    }
}
