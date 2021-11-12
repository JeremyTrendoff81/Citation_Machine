/**
 * The CitationView interface. Provides the boilerplate for the CitationFrame actions.
 * @author Jeremy Trendoff - 101160306
 */
public interface CitationView {

    /**
     * Handle a new citation created.
     * @param ce CitationEvent, the event triggered by the model.
     */
    void handleNewCitationCreated(CitationEvent ce);

    /**
     * Handle a radio button press.
     * @param ce CitationEvent, the event triggered by the model.
     */
    void handleRadioButtonPress(CitationEvent ce);
}
