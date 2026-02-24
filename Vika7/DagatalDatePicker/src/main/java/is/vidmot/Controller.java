/******************************************************************************
 *  @author Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Lýsing  : Sýnidæmi fyrir DatePicker - dagatal
 *
 *****************************************************************************/
package is.vidmot;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Controller  {
    @FXML
    private Label fxSnidinnDagur;        // Sniðinn dagur - uppfærður með handler
    @FXML
    private Label fxDagurSjalfvirkt;     // Sniðinn dagur - uppfærður með binding
    @FXML
    private DatePicker fxDagatal;   // dagatal - hægt að velja dagsetningu

    private final static int ISLAND=108;

    // static formatter fyrir dagsetningu
    private static final DateTimeFormatter f = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy",
            Locale.forLanguageTag(Locale.getISOCountries()[ISLAND]));


    public void initialize() {
        fxDagatal.setValue(LocalDate.now());    // setjum núverandi dagsetningu í upphafi

        // setjum upp reglurnar
        fxSnidinnDagur.textProperty().bind(Bindings.createStringBinding(
                ()->  // hér byrjar lambda fallið (Callable), enginn parameter
                fxDagatal.getValue().format(f), // skilagildið
                fxDagatal.valueProperty() //  vaktbreytan
        ));
      }
}
