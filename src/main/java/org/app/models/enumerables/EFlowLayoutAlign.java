package org.app.models.enumerables;

public enum EFlowLayoutAlign {
    LEFT(0),
    CENTER(1),
    RIGHT(2),
    LEADING(3),
    TRAILING(4);

    private Integer id;

    EFlowLayoutAlign(Integer id) {
        this.id = id;
    }

    public Integer getId() { return this.id; }
    public boolean is(EFlowLayoutAlign vEnum) { return this.id.equals(vEnum.id); }
}
