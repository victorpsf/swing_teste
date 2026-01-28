package org.app.models.interfaces;

import org.app.models.events.BaseActionData;

public interface IFormBehavior {
    void initializeComponent();
    void run();

    void windowOpened(BaseActionData action);
    void windowClosing(BaseActionData action);
    void windowClosed(BaseActionData action);
    void windowIconified(BaseActionData action);
    void windowDeiconified(BaseActionData action);
    void windowActivated(BaseActionData action);
    void windowDeactivated(BaseActionData action);
}
