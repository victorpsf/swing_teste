package org.app.forms;

import javax.swing.JPanel;

import org.app.components.forms.AppForm;
import org.app.components.panels.AppBoxPanel;
import org.app.components.panels.AppFlowPanel;
import org.app.components.styles.ComponentStyle;
import org.app.constants.Colors;
import org.app.factories.ComponentFactory;
import org.app.models.enumerables.EActionType;
import org.app.models.enumerables.EBoxLayout;
import org.app.models.enumerables.EFlowLayoutAlign;
import org.app.models.events.BaseActionData;
import org.app.models.interfaces.IFormBehavior;

public class MainForm implements IFormBehavior {
    private final AppForm form;

    public MainForm() {
        this.form = ComponentFactory.defaultForm("Página Inicial");
    }

    @Override
    public void initializeComponent() {
        this.form.addListener(EActionType.OPENED, this::windowOpened);
        this.form.addListener(EActionType.CLOSING, this::windowClosing);
        this.form.addListener(EActionType.CLOSED, this::windowClosed);
        this.form.addListener(EActionType.MINIMIZED, this::windowIconified);
        this.form.addListener(EActionType.RESTORE, this::windowDeiconified);
        this.form.addListener(EActionType.ACTIVATED, this::windowActivated);
        this.form.addListener(EActionType.DEACTIVATED, this::windowDeactivated);

        AppFlowPanel panel  = ComponentFactory.createFlowPanel(EFlowLayoutAlign.CENTER, 5, 5);
        AppFlowPanel formPanel = ComponentFactory.createFlowPanel(EFlowLayoutAlign.CENTER, 5, 5);

        panel.setPreferredSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        panel.setMinimumSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        panel.setMaximumSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        panel.defineStyle(ComponentStyle.empty().colors(Colors.WHITE, Colors.GRAY_800));

        formPanel.setMinimumSize(600, 300);
        formPanel.setMaximumSize(600, 600);
        formPanel.defineStyle(ComponentStyle.empty().colors(Colors.BLACK, Colors.WHITE));

        panel.addChildren(formPanel);

        this.form.addChildren(panel);
    }

    @Override
    public void windowOpened(BaseActionData action) {
    }

    @Override
    public void windowClosing(BaseActionData action) {
    }

    @Override
    public void windowClosed(BaseActionData action) {
    }

    @Override
    public void windowIconified(BaseActionData action) {
    }

    @Override
    public void windowDeiconified(BaseActionData action) {
    }

    @Override
    public void windowActivated(BaseActionData action) {
    }

    @Override
    public void windowDeactivated(BaseActionData action) {
    }

    @Override
    public void run() {
        this.initializeComponent();
        this.form.show();
    }
}
