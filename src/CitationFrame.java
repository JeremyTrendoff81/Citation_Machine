import javax.swing.*;
import java.awt.*;

/**
 * The Citation Frame Class. Creates the JFrame for the view.
 * @author Jeremy Trendoff - 101160306
 */
public class CitationFrame extends JFrame implements CitationView {

    /**
     * The rows in the gird layout.
     */
    private static final int ROWS = 4;

    /**
     * Columns in the grid layout.
     */
    private static final int COLS = 2;

    /**
     * Width of the JFrame.
     */
    private static final int WIDTH = 325;

    /**
     * Height of the JFrame.
     */
    private static final int HEIGHT = 400;

    /**
     * Labels for the JFrame.
     */
    private JLabel firstNameLabel, lastNameLabel;

    /**
     * Text fields for the JFrame.
     */
    private JTextField firstNameField, lastNameField;

    /**
     * RadioButtons for the JFrame.
     */
    private JRadioButton IEEERadioButton, ACMRadioButton;

    /**
     * Text area for the JFrame.
     */
    private JTextArea citationArea;

    /**
     * Format button for the JFrame.
     */
    private JButton formatButton;

    /**
     * RadioButton Group.
     */
    private ButtonGroup radioButtonGroup;

    /**
     * Constructor. Initializes the Title of the frame.
     * @param title String, the title of the frame.
     */
    public CitationFrame(String title) {
        super(title);

        this.setLayout(new GridLayout(ROWS, COLS));

        CitationModel model = new CitationModel();
        model.addView(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);

        firstNameLabel = new JLabel("First Name");
        this.add(firstNameLabel);

        firstNameField = new JTextField();
        firstNameField.addActionListener(new CitationController(model, Actions.SET_FIRST_NAME));
        this.add(firstNameField);

        lastNameLabel = new JLabel("Last Name");
        this.add(lastNameLabel);

        lastNameField = new JTextField();
        lastNameField.addActionListener(new CitationController(model, Actions.SET_LAST_NAME));
        this.add(lastNameField);

        radioButtonGroup = new ButtonGroup();

        IEEERadioButton = new JRadioButton("IEEE");
        IEEERadioButton.addActionListener(new CitationController(model, Actions.IEEE_SELECT));
        this.add(IEEERadioButton);
        radioButtonGroup.add(IEEERadioButton);

        ACMRadioButton = new JRadioButton("ACM");
        ACMRadioButton.addActionListener(new CitationController(model, Actions.ACM_SELECT));
        this.add(ACMRadioButton);
        radioButtonGroup.add(ACMRadioButton);

        citationArea = new JTextArea();
        citationArea.setEditable(false);
        this.add(citationArea);

        formatButton = new JButton("Format Citation");
        formatButton.addActionListener(new CitationController(model, Actions.FORMAT));
        this.add(formatButton);

        this.setVisible(true);
    }

    /**
     * Handle a new citation created.
     * @param ce CitationEvent, the event triggered by the model.
     */
    @Override
    public void handleNewCitationCreated(CitationEvent ce) {
        citationArea.setText("");
        citationArea.insert(ce.getCitation(), 0);
        this.repaint();
    }

    /**
     * Handle a radio button press.
     * @param ce CitationEvent, the event triggered by the model.
     */
    @Override
    public void handleRadioButtonPress(CitationEvent ce) {
        radioButtonGroup.clearSelection();

        if (ce.getModel().isIEEESelected()) {
            radioButtonGroup.setSelected(IEEERadioButton.getModel(), true);
        } else if (ce.getModel().isACMSelected()) {
            radioButtonGroup.setSelected(ACMRadioButton.getModel(), true);
        }

        this.repaint();
    }

    /**
     * The main method. Runs the program.
     */
    public static void main(String[] args) {
        new CitationFrame("Jeremy's Citation Machine");
    }
}
