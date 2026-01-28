package org.app.components.behavior;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.app.components.delegates.FormActionDelegate;
import org.app.components.styles.ComponentStyle;
import org.app.models.enumerables.EActionType;

public class ComponentProperties {
    protected UUID id;
    protected ComponentStyle style;
    protected Map<EActionType, List<FormActionDelegate>> listeners = new HashMap<>();
}
