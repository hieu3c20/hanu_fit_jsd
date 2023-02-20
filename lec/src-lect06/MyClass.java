package lect06;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * A JavaBean which notifies a View when its data changes.
 * This is achieved through the use of PropertyChangeListener.
 */
public class MyClass {

    private String label;

    public String getLabel() {
        return label;
    }

    private PropertyChangeSupport changes =
            new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener l) {
        changes.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        changes.removePropertyChangeListener(l);
    }

    public void setLabel(String newLabel) {
        String oldLabel = label;
        label = newLabel;
        changes.firePropertyChange("label", oldLabel, newLabel);
    }
}
