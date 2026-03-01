
package is.teikning.vidmot;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.RED;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Sýnidæmi fyrir teikningu
 *
 * @author Ebba Þóra Hvannberg ebba@hi.is
 */
public class TeiknaController {

    public Rectangle fxSvartur;
    @FXML
    private Canvas fxMittCanvas;
    @FXML
    private Pane fxPane;

    public void initialize() {

        // Hér er teiknaður rauður ferningur á canvas hlutinn
        GraphicsContext gc = fxMittCanvas.getGraphicsContext2D();
        gc.setStroke(RED);
        gc.strokeRect(2, 2, 40, 40);

        // Hér er teiknaður fylltur blár ferningur
        // á Pane hlutinn (gluggi)
        // Má líka gera í .fxml skránni
        Rectangle blar = new Rectangle(100, 100, 40, 40);
        blar.setFill(BLUE);
        blar.setStroke(BLUE);
        // Bæta ferningnum við fxPane svo hann teiknist

        fxPane.getChildren().add(blar);
        // Setjum handler á ferningshlutinn þannig að við framkvæmum
        // setningar þegar við drögum músina
        blar.setOnMouseDragged(event -> {
            blar.setX(event.getX());
            blar.setY(event.getY());
        });

        // Breytum litnum á fxSvartur þegar fxSvartur og blar skarast - hlustum á x og y gildin
        ChangeListener<Number> changeListener = (obs, gamla, nyja) -> {
           fxSvartur.setFill(blar.getBoundsInParent().intersects(fxSvartur.getBoundsInParent()) ? Color.MAGENTA : Color.BLACK);
        };
        blar.xProperty().addListener (changeListener);
        blar.yProperty().addListener(changeListener);
    }
}


//      fxSvartur.xProperty().bindBidirectional(r.xProperty());
//      fxSvartur.yProperty().bindBidirectional(r.yProperty());