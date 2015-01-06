import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class FigurePane extends BorderPane {
	private TextArea bubble = new TextArea();
	private ImageView imageView = new ImageView();

	public FigurePane() {
		BorderPane bubblePane = new BorderPane();
		bubblePane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(10), Insets.EMPTY)));
		bubblePane.setPadding(new Insets(10));
		bubblePane.setCenter(bubble);

		bubble.setWrapText(true);
		bubble.setEditable(false);
		bubble.setFocusTraversable(false);
		bubble.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));

		BorderPane temp = new BorderPane();
		temp.setPadding(new Insets(40));
		temp.setBottom(bubblePane);

		super.setCenter(temp);
		super.setBottom(imageView);

		super.setMinWidth(300);
		super.setPrefWidth(300);
	}

	public void setFigureImage(String URI) {
		imageView.setImage(new Image(getClass().getResource(URI).toExternalForm(), 250, Double.MAX_VALUE, true, true));
	}

	public void setBubbleText(String message) {
		bubble.setText(message);
	}
}
