package org.app.components.delegates;

import org.app.models.events.BaseActionData;

@FunctionalInterface
public interface FormActionDelegate {
    void invoke(BaseActionData event);
}
