
package vidmot;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Dæmi sem sýnir valmyndir
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class ValmyndirController {

    @FXML
    private AnchorPane fxAnchorPane;
    @FXML
    private TextField fxTexti; // textasvið í glugganum
    @FXML
    private Label fxValid; // sýnir hvað er valið

    // hér er fxAnchorMenu skilgreint í .fxml skránni með <fx:define> því <ContextMenu> er ekki eiginleiki
    // á AnchorPane
    @FXML
    private ContextMenu fxAnchorMenu; // context menu fyrir AnchorPane



    /***
     * Atburðahandler fyrir close valmyndarstakið. 
     * Hættir í forritinu 
     * @param event atburður ónotað
     */
    @FXML
    private void onClose(ActionEvent event) {
        Platform.exit();    // losar alla resourca og hættir
    }

    /**
     * Dummy handler fyrir translate aðgerðina í context menu
     *
     * @param actionEvent ónotað
     */
    public void onTranslate(ActionEvent actionEvent) {
        fxValid.setText("Translate handler " + fxTexti.getText());
    }

    /**
     * Dummy handler fyrir translate aðgerðina í context menu
     *
     * @param actionEvent ónotað
     */
    public void onComplete(ActionEvent actionEvent) {
        fxValid.setText("Complete handler " + fxTexti.getText());
    }

    /**
     * Opnar context menu á AnchorPane
     *
     * @param event
     */
    public void onContextAnchor(ContextMenuEvent event) {
        fxAnchorMenu.show((Node) event.getSource(), event.getScreenX(), event.getScreenY());
    }

    /**
     * Opnar contextmenu sem er tengdur við textasviðið þegar hægri smellt er í Anchor
     * pane
     *
     * @param contextMenuEvent ónotað
     **/
    public void onContext(ContextMenuEvent contextMenuEvent) {
        fxTexti.getContextMenu().show(fxTexti, Side.BOTTOM, 0, 0);
        fxValid.setText("Context handler");
    }

    /**
     * Birta context menu á textasvið þegar action atburður verður á fxTexti
     *
     * @param event
     */
    public void onEnter(ActionEvent event) {
        ContextMenu samhengi = fxTexti.getContextMenu(); // g.r.f. að menu sé skilgreint á TextField ið
        if (samhengi == null) {
            return;
        }
        samhengi.show(fxTexti, Side.BOTTOM, 0, 0); // birtum menuinn
    }

    /**
     * Handler fyrir Hjálp í context menu á AnchorPane
     * @param event
     */
    public void onHelpContext(ActionEvent event) {
        fxValid.setText("Help context");
    }

    /**
     * Handler fyrir cascading valmyndarstak
     *
     * @param actionEvent ónotað
     */
    public void onCascading(ActionEvent actionEvent) {
        fxValid.setText("Cascading");
    }

    /**
     * Handler fyrir about valmyndarstak
     *
     * @param actionEvent ónotað
     */
    public void onAbout(ActionEvent actionEvent) {
        fxValid.setText("About");
    }

    /**
     * Handler fyrir delete valmyndarstak
     *
     * @param actionEvent ónotað
     */
    public void onDelete(ActionEvent actionEvent) {
        fxValid.setText("Delete");
    }


    /**
     * handler fyrir new valmyndarstakið. Opnar Alert glugga
     *
     * @param actionEvent ónotað
     */
    public void onNew(ActionEvent actionEvent) {
        Alert a = new Alert(Alert.AlertType.INFORMATION,
                "einhver skilaboð", ButtonType.OK);
        a.setTitle("New");
        a.setHeaderText("Hausinn");
        a.showAndWait();
    }
}
