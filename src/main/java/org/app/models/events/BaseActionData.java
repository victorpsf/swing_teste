package org.app.models.events;

import java.awt.AWTEvent;

import org.app.models.enumerables.EActionType;

public class BaseActionData {
    private EActionType type;
    private AWTEvent originalEvent;
    private Object data;

    private BaseActionData(
        AWTEvent event,
        Object data
    ) {
        this.originalEvent = event;
        this.data = data;
    }

    public static BaseActionData create(
        final AWTEvent event,
        final Object data
    ) {
        return new BaseActionData(
            event,
            data
        );
    }
}
