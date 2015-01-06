import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class NavigationMap extends BorderPane {
	private interface ShapeAction {
		void selected();
	}

	private final ImageView imageView = new ImageView();
	private final ArrayList<Shape> shapes = new ArrayList<>();

	private Shape selectedItem = null;

	public NavigationMap(final MainFrame mainFrame, double width) {
		final double scale = width / 962;

		imageView.setImage(new Image(getClass().getResource("/resources/images/opera_kartta_hotspots.png").toExternalForm(), width, Double.MAX_VALUE,
				true, true));
		imageView.setSmooth(true);
		imageView.setCache(true);

		shapes.add(setShapeProperties(createEntranceShape(scale), new ShapeAction() {
			@Override
			public void selected() {
				mainFrame.onEntranceSelected();
			}
		}));

		shapes.add(setShapeProperties(createLoftShape(scale), new ShapeAction() {
			@Override
			public void selected() {
				mainFrame.onLoftSelected();
			}
		}));

		shapes.add(setShapeProperties(createFloorShape(scale), new ShapeAction() {
			@Override
			public void selected() {
				mainFrame.onFloorSelected();
			}
		}));

		shapes.add(setShapeProperties(createOrchestraShape(scale), new ShapeAction() {
			@Override
			public void selected() {
				mainFrame.onOrchestraSelected();
			}
		}));

		shapes.add(setShapeProperties(createStageShape(scale), new ShapeAction() {
			@Override
			public void selected() {
				mainFrame.onStageSelected();
			}
		}));

		shapes.add(setShapeProperties(createBackstageShape(scale), new ShapeAction() {
			@Override
			public void selected() {
				mainFrame.onBackstageSelected();
			}
		}));

		shapes.add(setShapeProperties(createWardrobeShape(scale), new ShapeAction() {
			@Override
			public void selected() {
				mainFrame.onWardrobeSelected();
			}
		}));

		final AnchorPane anchorPane = new AnchorPane(imageView);
		for (Shape s : shapes) {
			anchorPane.getChildren().add(s);
		}

		final BorderPane backgroundPane = new BorderPane(anchorPane);
		backgroundPane.setPadding(new Insets(10));
		backgroundPane.setBackground(new Background(new BackgroundFill(new Color(1, 1, 1, 0.8), new CornerRadii(10), new Insets(2))));
		backgroundPane.setBorder(new Border(new BorderStroke(new Color(0.3, 0.3, 0.3, 0.4), BorderStrokeStyle.SOLID, new CornerRadii(10),
				new BorderWidths(2))));

		super.setTop(backgroundPane);
	}

	private Shape createEntranceShape(double scale) {
		double points[] = { 265, 655, 432, 94 };

		for (int i = 0; i < points.length; ++i) {
			points[i] *= scale;
		}

		return new Rectangle(points[0], points[1], points[2], points[3]);
	}

	private Shape createLoftShape(double scale) {
		double points[] = { 265, 651, 695, 651, 713, 637, 731, 618, 746, 599, 760, 581, 772, 565, 785, 542, 795, 517, 806, 490, 813, 463, 818, 437,
				821, 411, 821, 387, 821, 363, 818, 338, 814, 311, 807, 287, 800, 266, 795, 252, 785, 233, 773, 211, 764, 196, 759, 188, 751, 181,
				749, 189, 750, 208, 749, 227, 749, 249, 749, 268, 749, 288, 749, 302, 748, 312, 746, 329, 743, 358, 739, 380, 730, 409, 718, 436,
				703, 461, 685, 485, 664, 509, 642, 526, 623, 541, 593, 556, 563, 569, 531, 577, 482, 581, 444, 579, 417, 573, 385, 563, 345, 545,
				322, 529, 294, 505, 271, 479, 253, 453, 236, 422, 224, 391, 218, 366, 215, 341, 213, 330, 213, 318, 213, 306, 213, 293, 213, 182,
				208, 183, 203, 188, 198, 198, 190, 208, 184, 220, 176, 235, 170, 250, 163, 265, 157, 281, 152, 296, 148, 314, 143, 333, 141, 354,
				140, 376, 140, 398, 141, 420, 144, 444, 150, 469, 156, 493, 165, 518, 176, 541, 186, 560, 198, 578, 209, 594, 222, 609, 233, 622,
				248, 637 };

		for (int i = 0; i < points.length; ++i) {
			points[i] *= scale;
		}

		return new Polygon(points);
	}

	private Shape createFloorShape(double scale) {
		double points[] = { 335, 314, 217, 315, 216, 328, 218, 344, 221, 364, 227, 387, 231, 401, 238, 420, 246, 435, 255, 453, 266, 468, 282, 488,
				301, 508, 321, 525, 343, 541, 362, 551, 385, 561, 406, 567, 431, 574, 452, 576, 473, 578, 493, 577, 512, 576, 527, 574, 546, 570,
				563, 564, 579, 559, 592, 553, 606, 546, 620, 538, 633, 530, 646, 520, 659, 508, 671, 497, 681, 485, 691, 472, 702, 457, 712, 441,
				718, 428, 726, 412, 733, 390, 738, 372, 742, 352, 744, 331, 743, 313, 625, 313, 625, 395, 619, 400, 342, 400, 335, 394 };

		for (int i = 0; i < points.length; ++i) {
			points[i] *= scale;
		}

		return new Polygon(points);
	}

	private Shape createOrchestraShape(double scale) {
		double points[] = { 338, 314, 623, 314, 623, 397, 338, 397, 338, 314 };

		for (int i = 0; i < points.length; ++i) {
			points[i] *= scale;
		}

		return new Polygon(points);
	}

	private Shape createStageShape(double scale) {
		double points[] = { 216, 186, 529, 125 };

		for (int i = 0; i < points.length; ++i) {
			points[i] *= scale;
		}

		return new Rectangle(points[0], points[1], points[2], points[3]);
	}

	private Shape createBackstageShape(double scale) {
		double points[] = { 216, 94, 264, 92 };

		for (int i = 0; i < points.length; ++i) {
			points[i] *= scale;
		}

		return new Rectangle(points[0], points[1], points[2], points[3]);
	}

	private Shape createWardrobeShape(double scale) {
		double points[] = { 484, 94, 260, 92 };

		for (int i = 0; i < points.length; ++i) {
			points[i] *= scale;
		}

		return new Rectangle(points[0], points[1], points[2], points[3]);
	}

	private Shape setShapeProperties(final Shape shape, final ShapeAction action) {
		final Color normal = Color.TRANSPARENT;
		final Color hovered = new Color(0.8, 0, 0, 0.6);
		final Color selected = new Color(0.4, 0.4, 1, 0.5);

		shape.setFill(normal);

		shape.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (shape != selectedItem) {
					shape.setFill(hovered);
				}
			}
		});

		shape.setOnMouseExited(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (shape != selectedItem) {
					shape.setFill(normal);
				}
			}
		});

		shape.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if (shape != selectedItem) {
					if (selectedItem != null) {
						selectedItem.setFill(normal);
					}
					shape.setFill(selected);

					selectedItem = shape;
					action.selected();
				}
			}
		});

		return shape;
	}

}
