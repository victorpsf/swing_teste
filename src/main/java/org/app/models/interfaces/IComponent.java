package org.app.models.interfaces;

import org.app.models.enumerables.EComponentType;

import java.awt.Component;
import java.util.UUID;

public interface IComponent {
    UUID getId();
    EComponentType getType();
    Component getOriginalElement();
}
