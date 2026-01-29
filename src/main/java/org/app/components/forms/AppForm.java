package org.app.components.forms;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Objects;
import java.util.UUID;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.app.components.behavior.ComponentBehavior;
import org.app.components.styles.ComponentStyle;
import org.app.models.enumerables.EActionType;
import org.app.models.enumerables.EComponentType;
import org.app.models.enumerables.EWindowViewState;
import org.app.models.events.BaseActionData;
import org.app.models.interfaces.IComponent;

public class AppForm extends ComponentBehavior implements IComponent {
    private JFrame jFrame;

    @Override
    public UUID getId() { return this.id; }
    @Override
    public EComponentType getType() { return EComponentType.FORM; }
    @Override
    public Component getOriginalElement() { return this.jFrame; }
    @Override
    public void addChildren(IComponent children) {
        this.jFrame.add(children.getOriginalElement());
        this.childrens.add(children);
    }

    public String getTitle() { return this.jFrame.getTitle(); }
    public AppForm setTitle(String title) {
        this.jFrame.setTitle(title);
        return this;
    }

    public AppForm() {
        this.id = UUID.randomUUID();
        this.jFrame = new JFrame();
    }

    public AppForm defineStyle(ComponentStyle style) {
        this.style = style;

        if (Objects.nonNull(style.getBackgroundColor()))
            this.jFrame.getContentPane().setBackground(style.getBackgroundColor());

        if (Objects.nonNull(style.getForegroundColor()))
            this.jFrame.getContentPane().setForeground(style.getForegroundColor());

        return this;
    }

    private AppForm prepare() {
        this.jFrame.setMinimumSize(new Dimension(640, 420));

        this.jFrame.addComponentListener(new ComponentListener() {
            @Override public void componentResized(ComponentEvent e) { getActions(EActionType.RESIZE).forEach((a) -> a.invoke(BaseActionData.create(e, null))); }
            @Override public void componentMoved(ComponentEvent e) { getActions(EActionType.MOVE).forEach((a) -> a.invoke(BaseActionData.create(e, null))); }
            @Override public void componentShown(ComponentEvent e) { getActions(EActionType.SHOW).forEach((a) -> a.invoke(BaseActionData.create(e, null))); }
            @Override public void componentHidden(ComponentEvent e) { getActions(EActionType.HIDDEN).forEach((a) -> a.invoke(BaseActionData.create(e, null))); }
        });

        this.jFrame.addWindowListener(new WindowListener() {
            @Override public void windowOpened(WindowEvent e) { getActions(EActionType.OPENED).forEach((a) -> a.invoke(BaseActionData.create(e, null))); }
            @Override public void windowClosing(WindowEvent e) { getActions(EActionType.CLOSING).forEach((a) -> a.invoke(BaseActionData.create(e, null)));  }
            @Override public void windowClosed(WindowEvent e) { getActions(EActionType.CLOSED).forEach((a) -> a.invoke(BaseActionData.create(e, null))); jFrame.dispose(); }
            @Override public void windowIconified(WindowEvent e) { getActions(EActionType.MINIMIZED).forEach((a) -> a.invoke(BaseActionData.create(e, null))); }
            @Override public void windowDeiconified(WindowEvent e) { getActions(EActionType.RESTORE).forEach((a) -> a.invoke(BaseActionData.create(e, null))); }
            @Override public void windowActivated(WindowEvent e) { getActions(EActionType.ACTIVATED).forEach((a) -> a.invoke(BaseActionData.create(e, null))); }
            @Override public void windowDeactivated(WindowEvent e) { getActions(EActionType.DEACTIVATED).forEach((a) -> a.invoke(BaseActionData.create(e, null))); }
        });

        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.jFrame.setLocationRelativeTo(null);

        return this;
    }

    private AppForm _changeWindowView(EWindowViewState state) {
        if (state.equals(EWindowViewState.MAXIMIZED))
            this.jFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.jFrame.setExtendedState(state.getId()); 
        this.setWindowViewState(state);
        return this;
    }

    public AppForm changeWindowView(EWindowViewState state) {
        switch (state) {
            case ICONIFIED, NORMAL, MAXIMIZED -> { return this._changeWindowView(state); }
        }

        return this;
    }

    public AppForm minimize() { return this.changeWindowView(EWindowViewState.ICONIFIED); }
    public AppForm restore()  { return this.changeWindowView(EWindowViewState.NORMAL); }
    public AppForm maximize() { return this.changeWindowView(EWindowViewState.MAXIMIZED); }

    public void show() {
        this.prepare();
        this.maximize();
        SwingUtilities.invokeLater(() -> {
            this.jFrame.setAlwaysOnTop(true);
            this.jFrame.setVisible(true);
        });
    }

    public void hide() {
        SwingUtilities.invokeLater(() -> this.jFrame.setVisible(false));
    }

    public void destroy() {
        SwingUtilities.invokeLater(() -> this.jFrame.dispose());
    }
}
