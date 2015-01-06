import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MainFrame extends Application {
	private HBox root;
	private WebView content;
	private FigurePane figure;

	@Override
	public void start(Stage primaryStage) {
		final NavigationMap navigation = new NavigationMap(this, 0.2 * GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDisplayMode().getWidth());

		figure = new FigurePane();

		content = new WebView();
		content.setContextMenuEnabled(false);

		BorderPane contentPane = new BorderPane();
		contentPane.setPadding(new Insets(100, 50, 250, 50));
		contentPane.setCenter(content);

		root = new HBox(navigation, contentPane, figure);
		HBox.setHgrow(navigation, Priority.NEVER);
		HBox.setHgrow(contentPane, Priority.ALWAYS);
		HBox.setHgrow(figure, Priority.NEVER);

		onEntranceSelected();

		primaryStage.setTitle("Ooperan taika");
		primaryStage.setScene(new Scene(root));
		primaryStage.sizeToScene();
		primaryStage.setMinWidth(1000);
		primaryStage.setMinHeight(700);
		primaryStage.show();
	}

	void onEntranceSelected() {
		setBackgroundImage("/resources/images/oopperatalo_1.jpg");
		setContent("/resources/entrance.html");
		figure.setFigureImage("/resources/images/kissa.png");
		figure.setBubbleText("Minä olen Oopperan kissa. Tervetuloa esittelykierrokselle oopperan ihmelliseen maailmaan!");
	}

	void onLoftSelected() {
		setBackgroundImage("/resources/images/etiketti_1.jpg", "/resources/images/curtain.png");
		setContent("/resources/loft.html");
		figure.setFigureImage("/resources/images/operalaulaja.png");
		figure.setBubbleText("Oopperaan ja balettiin saa pukeutua hienoihin pukuihin - se on osa oopperan tunnelmaa!");
	}

	void onFloorSelected() {
		setBackgroundImage("/resources/images/lapsille_1.jpg", "/resources/images/curtain.png");
		setContent("/resources/floor.html");
		figure.setFigureImage("/resources/images/kissa.png");
		figure.setBubbleText("Kansallisooppera järjestää jatkuvasti hauskaa viihdykettä lapsille - ja myös aikuisille!");
	}

	void onOrchestraSelected() {
		setBackgroundImage("/resources/images/baletti_2.jpg", "/resources/images/curtain.png");
		setContent("/resources/orchestra.html");
		figure.setFigureImage("/resources/images/balettitanssija.png");
		figure.setBubbleText("Kurinalaisuus on osa balettia");
	}

	void onStageSelected() {
		setBackgroundImage("/resources/images/opera_2.jpg", "/resources/images/curtain.png");
		setContent("/resources/stage.html");
		figure.setFigureImage("/resources/images/operalaulaja.png");
		figure.setBubbleText("Tiesitkö, että oopperoita ei lauleta suomeksi? Figaron Häät on laulettu italiaksi! Oopperat on teksitetty suomeksi, ruotsiksi ja englanniksi.");
	}

	void onBackstageSelected() {
		setBackgroundImage("/resources/images/dokumentti_1.jpg", "/resources/images/curtain.png");
		setContent("/resources/backstage.html");
		figure.setFigureImage("/resources/images/kettu.png");
		figure.setBubbleText("Baletin suunnittelu vaatii paljon aikaa, sillä tanssin koreografiat ovat usein todella monimutkaisia!");
	}

	void onWardrobeSelected() {
		setBackgroundImage("/resources/images/historia_1.jpg", "/resources/images/curtain.png");
		setContent("/resources/wardrobe.html");
		figure.setFigureImage("/resources/images/balettitanssija.png");
		figure.setBubbleText("Aino Acktén ja Edvard Fazer perustivat oopperan.");
	}

	private void setBackground(Background background) {
		root.setBackground(background);
	}

	private void setBackgroundImage(String... URI) {
		ArrayList<BackgroundImage> images = new ArrayList<>();

		for (String u : URI) {
			images.add(new BackgroundImage(new Image(getClass().getResource(u).toExternalForm()), BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false,
							true, true)));
		}

		setBackground(new Background(images.toArray(new BackgroundImage[images.size()])));
	}

	private void setContent(String url) {
		content.getEngine().load(getClass().getResource(url).toExternalForm());
	}

	public static void main(String[] args) {
		launch(args);
	}
}