package org.app.forms;

import org.app.components.forms.AppForm;
import org.app.factories.ComponentFactory;
import org.app.models.enumerables.EActionType;
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
        throw new RuntimeException("falha de teste");
        // this.form.show();
    }
}
