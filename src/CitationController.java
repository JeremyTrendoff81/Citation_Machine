import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The CitationController class. Controls the various event producing GUI elements.
 * @author Jeremy Trendoff - 101160306
 */
public class CitationController implements ActionListener {

    /**
     * The model class.
     */
    private CitationModel model;

    /**
     * The action to handle.
     */
    private Actions action;

    /**
     * Constructor. Initializes the model and action.
     *
     * @param model CitationModel, the model.
     * @param action Actions, the action to handle.
     */
    public CitationController(CitationModel model, Actions action) {
        this.model = model;
        this.action = action;
    }

    /**
     * Handle various actions based on the action.
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (action) {
            case SET_FIRST_NAME -> {
                if (e.getSource() instanceof JTextField)
                    model.setFirstName(((JTextField) e.getSource()).getText());
                model.updateView();
            }
            case SET_LAST_NAME -> {
                if (e.getSource() instanceof JTextField)
                    model.setLastName(((JTextField) e.getSource()).getText());
                model.updateView();
            }
            case IEEE_SELECT -> {
                model.setIEEESelected();
                model.updateView();
            }
            case ACM_SELECT -> {
                model.setACMSelected();
                model.updateView();
            }
            case FORMAT -> {
                model.updateView();
            }
        }
    }
}
