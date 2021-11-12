import org.junit.Test;
import org.junit.jupiter.api.Assertions;

/**
 * CitationModelTest Class. Tests the CitationModel.
 * @author Jeremy Trendoff - 101160306
 */
class CitationModelTest {

    /**
     * The model.
     */
    private CitationModel model;

    /**
     * Test the resulting citation for IEEE and ACM modes.
     */
    @org.junit.jupiter.api.Test
    void testGetResultingCitation() {
        model = new CitationModel();

        // Test IEEE Citation.
        model.setFirstName("Jeremy");
        model.setLastName("Trendoff");
        model.setIEEESelected();
        model.updateView();

        Assertions.assertEquals("J. Trendoff", model.getResultingCitation());

        model = new CitationModel();

        // Test ACM Citation
        model.setFirstName("Jeremy");
        model.setLastName("Trendoff");
        model.setACMSelected();
        model.updateView();
        Assertions.assertEquals("Jeremy Trendoff.", model.getResultingCitation());
    }
}