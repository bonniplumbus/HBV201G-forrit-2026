
package is.vidmot;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * @author Ebba Þóra Hvannberg, Háskóli Íslands, ebba@hi.is
 * <p>
 * Sýnidæmi fyrir ComboBox. Mynd af dýri birtist þegar nafn þess er valið úr Comboboxi.
 * Einnig er sýnt hvernig gögn eru geymd í DefaultComboBoxModel
 */
public class DyrController {

    /**
     * Nöfnin á dýrunum. Notum þau líka fyrir myndirnar.
     * Er final því við breytum ekki fylkinu dyrHeiti
     * Er private því við viljum ekki að aðrir klasar hafi beint aðgang að breytunni
     */
    private static final String[] dyrHeiti = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
    private static final Map<String, Image> dyramyndir = new HashMap<String, Image>();

    @FXML
    private ImageView fxDyramynd; // mynd af dýri
    @FXML
    private ComboBox<String> fxDyr; // combobox af streng


    public void initialize() {
        // Frumstilla gögnin fyrir ComboBox
        frumstillaGogn();
        // búa til Images
        for(String heiti: dyrHeiti) {
            nyMynd(heiti);
        }
        // hlustum á breytingu á valinu og uppfærum myndina af dýrinu
        fxDyr.getSelectionModel().selectedItemProperty()
                .addListener((obs, gamla, nyja) -> {
            fxDyramynd.setImage(dyramyndir.get(nyja));
        });
    }

    /**
     * Frumstillir gögn fyrir ComboBoxið jDyr
     */
    private void frumstillaGogn() {
        ObservableList<String> dyraNofn =
                FXCollections.observableArrayList(dyrHeiti);
        // tengjum gögnin við viðmótshlutinn þannig að gögnin birtist í notendaviðmótinu
        fxDyr.setItems(dyraNofn);
    }

    /**
     * Býr til Image fyrir dýrið og setur í hakkatöflu
     *
     * @param name nafn á dýrinu
     */
    private void nyMynd(String name) {
        Image icon = buaTilMynd("myndir/" + name + ".gif");
        dyramyndir.put(name, icon);
    }

    /**
     * Býr til Mynd
     *
     * @param path slóðin með myndunum
     * @return skilar myndinni en null ef skráin fannst ekki
     * <p>
     * Þetta er dæmi um aðferð sem má vera static því hún meðhöndlar
     * ekki tilviksbreytur.
     */
    private static Image buaTilMynd(String path) {
        URL imgURL = DyrController.class.getResource(path);
        if (imgURL != null) {
            return new Image(imgURL.toString());
        } else {
            System.err.println("Fann ekki skrána " + path);
            return null;
        }
    }
}
