import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The CitationModel Class. Responsible for the business logic of the citation machine.
 * @author Jeremy Trendoff - 101160306
 */
public class CitationModel {

    /**
     * The first name for the citation.
     */
    private String firstName;

    /**
     * The last name for the citation.
     */
    private String lastName;

    /**
     * true if the IEEE option is selected. false otherwise.
     */
    private boolean IEEESelected;

    /**
     * true if the ACM option is selected. false otherwise.
     */
    private boolean ACMSelected;

    /**
     * The resulting citation created from the model.
     */
    private String resultingCitation;

    /**
     * A List of views for the model to interact with.
     */
    private List<CitationView> views;

    /**
     * Constructor. Initializes all attributes to empty or false states.
     */
    public CitationModel() {
        this.firstName = "";
        this.lastName = "";
        this.IEEESelected = false;
        this.ACMSelected = false;
        this.views = new ArrayList<>();
    }

    /**
     * Set the first name.
     * @param firstName String, the new first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set the last name.
     * @param lastName String, the new last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the first name.
     * @return String, the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the last name.
     * @return String, the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get if IEEE option is selected.
     * @return boolean, true if selected, false otherwise.
     */
    public boolean isIEEESelected() {
        return IEEESelected;
    }

    /**
     * Get if ACM option is selected.
     * @return boolean, true if selected, false otherwise.
     */
    public boolean isACMSelected() {
        return ACMSelected;
    }

    /**
     * Set IEEE option.
     */
    public void setIEEESelected() {
        this.IEEESelected = true;
        this.ACMSelected = false;

        CitationEvent ce = new CitationEvent(this);

        for (CitationView view : views) {
            view.handleRadioButtonPress(ce);
        }
    }

    /**
     * Set ACM option.
     */
    public void setACMSelected() {
        this.ACMSelected = true;
        this.IEEESelected = false;

        CitationEvent ce = new CitationEvent(this);

        for (CitationView view : views) {
            view.handleRadioButtonPress(ce);
        }
    }

    /**
     * Add a view to the model.
     * @param view CitationView, the view to add.
     */
    public void addView(CitationView view) {
        views.add(view);
    }

    /**
     * Remove a view to the model.
     * @param view CitationView, the view to remove.
     */
    public void removeView(CitationView view) {
        views.remove(view);
    }

    /**
     * Get the resulting citation.
     * @return String, the resulting citation.
     */
    public String getResultingCitation() {
        return resultingCitation;
    }

    /**
     * Validate name inputs from the user.
     * @return boolean, true if text fields have been entered, false otherwise.
     */
    private boolean validateInputsFromView() {
        return !Objects.equals(firstName, "") && !Objects.equals(lastName, "");
    }

    /**
     * Generate a citation.
     */
    private void generateCitation() {
        if (validateInputsFromView()) {
            if (IEEESelected) {
                resultingCitation = firstName.charAt(0) + ". " + lastName;
            } else if (ACMSelected) {
                resultingCitation = firstName + " " + lastName + ".";
            } else {
                resultingCitation = "Select a Mode.";
            }
        } else {
            resultingCitation = "Please Fill the Text Fields \nand Click Enter in Each!";
        }
    }

    /**
     * Update the view with the new citation.
     */
    public void updateView() {
        generateCitation();

        CitationEvent ce = new CitationEvent(this);

        for (CitationView view : views) {
            view.handleNewCitationCreated(ce);
        }
    }
}
