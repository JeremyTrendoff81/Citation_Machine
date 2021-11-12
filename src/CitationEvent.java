import java.util.EventObject;

/**
 * The CitationEvent Class. Provides a data type for an event created byu the model.
 * @author Jeremy Trendoff - 101160306
 */
public class CitationEvent extends EventObject {

    /**
     * The model class.
     */
    private final CitationModel model;

    /**
     * Constructor. Initalized the model and event source.
     * @param model CitationModel, the model.
     */
    public CitationEvent(CitationModel model) {
        super(model);
        this.model = model;
    }

    /**
     * Get the model class.
     * @return CitationModel, the model.
     */
    public CitationModel getModel() {
        return model;
    }

    /**
     * Get the resulting citation.
     * @return String, the resulting citation.
     */
    public String getCitation() {
        return model.getResultingCitation();
    }
}
