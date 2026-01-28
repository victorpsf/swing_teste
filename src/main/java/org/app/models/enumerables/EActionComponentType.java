package org.app.models.enumerables;

public enum EActionComponentType {
    WINDOW(1),
    COMPONENT(2);

    private Integer id;

    EActionComponentType(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public boolean is (EActionComponentType vEnum) {
        return this.id.equals(vEnum.id);
    }
}
