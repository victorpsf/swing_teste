package org.app.factories;

import org.app.components.forms.AppForm;
import org.app.components.panels.AppBoxPanel;
import org.app.components.panels.AppFlowPanel;
import org.app.components.styles.ComponentStyle;
import org.app.constants.Colors;
import org.app.models.enumerables.EActionType;
import org.app.models.enumerables.EBoxLayout;
import org.app.models.enumerables.EFlowLayoutAlign;

public class ComponentFactory {
    public static AppForm defaultForm(String title) {
        AppForm form = new AppForm();

        form.defineStyle(ComponentStyle.empty().colors( Colors.WHITE, Colors.GRAY_800 ))
            .setTitle(title)
            .addListener(EActionType.HIDDEN, (event) -> form.destroy());

        return form;
    }

    public static AppFlowPanel createFlowPanel(
        EFlowLayoutAlign align,
        int hgap, 
        int vgap
    ) {
        AppFlowPanel flowPanel = new AppFlowPanel(align, hgap, vgap);

        return flowPanel;
    }

    public static AppFlowPanel defaultFlowPanel() {
        return createFlowPanel(EFlowLayoutAlign.CENTER, 5, 5);
    }

    public static AppBoxPanel createBoxPanel(EBoxLayout boxLayout) {
        AppBoxPanel boxPanel = new AppBoxPanel(boxLayout);

        return boxPanel;
    }

    public static AppBoxPanel defaultBoxPanel() {
        return createBoxPanel(EBoxLayout.LINE_AXIS);
    }

    public static AppBoxPanel createBorderPanel() {
        AppBoxPanel boxPanel = new AppBoxPanel(boxLayout);

        return boxPanel;
    }

    public static AppBoxPanel defaultBoxPanel() {
        return createBoxPanel(EBoxLayout.LINE_AXIS);
    }
}
