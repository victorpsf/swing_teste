package org.app.factories;

import org.app.components.forms.AppForm;
import org.app.components.styles.ComponentStyle;
import org.app.constants.Colors;
import org.app.models.enumerables.EActionType;

public class ComponentFactory {
    public static AppForm defaultForm(String title) {
        AppForm form = new AppForm();

        form.defineStyle(ComponentStyle.empty().colors( Colors.WHITE, Colors.GRAY_800 ))
            .setTitle(title)
            .addListener(EActionType.HIDDEN, (event) -> form.destroy());

        return form;
    }
}
