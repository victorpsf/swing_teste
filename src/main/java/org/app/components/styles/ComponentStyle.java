package org.app.components.styles;

import java.awt.*;

public class ComponentStyle {
    private Font font;
    private Color foregroundColor;
    private Color backgroundColor;

    public Font getFont() { return this.font; }
    public Color getForegroundColor() { return this.foregroundColor; }
    public Color getBackgroundColor() { return this.backgroundColor; }

    private ComponentStyle() { }

    public static ComponentStyle empty() {
        return new ComponentStyle();
    }

    public ComponentStyle colors(
        Color foregroundColor,
        Color backgroundColor
    ) {
        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        return this;
    }
}
