package application;

import model.Unit;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application {

	  //Creates the lists
	  
	  ObservableList<Unit> factionList = FXCollections.observableArrayList();
	  
	  ObservableList<Unit> warbandList = FXCollections.observableArrayList();
	  
	  // Puts some test data in the lists
	
	  public Main() {
		  
		  factionList.add(new Unit("Skelleton",5,4,9,4,1,6,9));
		  factionList.add(new Unit("Ghoul",6,4,010,4,1,6,7));
		  factionList.add(new Unit("Zombie",4,5,1,3,1,6,5));
		  factionList.add(new Unit("Wraith",4,5,19,3,1,6,5));
		  factionList.add(new Unit("Spectre",4,5,1,3,1,6,5));
		  
		  warbandList.add(new Unit("Sam the Skelly",5,4,0,4,1,6,9));
		  
	  }
	
	  @Override
	  public void start(Stage mainStage) {

		  mainStage.setTitle("Star-Struck City Warband Calculator");
		  BorderPane borderpane = new BorderPane();
		  Scene scene = new Scene(borderpane, 1000, 400);
		  
		  //Create the SplitPane
		  
		  SplitPane splitPane = new SplitPane();
		  splitPane.setPrefSize(800, 400);
		  

		
		  
		  //Creates the tables
		  
		  final TableView<Unit> table1 = new TableView<>(
				factionList
//				  FXCollections.observableArrayList(
//						new Unit("Skellies",5,4,9,4,1,6,9),
//						new Unit("Ghoulies",6,4,010,4,1,6,7),
//						new Unit("Zombies",4,5,1,3,1,6,5),
//						new Unit("Wraiths",4,5,19,3,1,6,5),
//						new Unit("Spectres",4,5,1,3,1,6,5)
//						)  
				  );
		  final TableView<Unit> table2 = new TableView<>(	  
				  warbandList
//				  FXCollections.observableArrayList(
//				  new Unit("Sam the Skelly",5,4,0,4,1,6,9),
//				  new Unit("Gustav the Ghoulie",5,4,5,4,1,6,9),
//				  new Unit("Zanders the Zombie",5,4,010,4,1,6,9),
//				  new Unit("Wally the Wraith",5,4,5,4,1,6,9),
//				  new Unit("Scott the Spectre",5,4,5,4,1,6,9)
//					)
	  );
		  //Defines the table columns
		  
		  //Columns for table 1
		  
		  TableColumn<Unit,String> unitNameCol = new TableColumn<>("Unit");
		  unitNameCol.setCellValueFactory(new PropertyValueFactory("unitName"));
		  unitNameCol.setMinWidth(100);
		  //unitNameCol.prefWidthProperty().bind(table1.widthProperty().divide(3));
		  TableColumn<Unit,Integer> speedCol = new TableColumn<>("Spd");
		  speedCol.setCellValueFactory(new PropertyValueFactory("speed"));
		  //speedCol.setPrefWidth(35.0);
		  //speedCol.setMaxWidth(100.0);
		  //speedCol.setResizable(false);
		  //speedCol.prefWidthProperty().bind(table1.widthProperty().divide(1));
		  TableColumn<Unit,Integer> meleeCol = new TableColumn<>("Me");
		  meleeCol.setCellValueFactory(new PropertyValueFactory("melee"));
		  //meleeCol.prefWidthProperty().bind(table1.widthProperty().divide(1));
		  TableColumn<Unit,Integer> rangedCol = new TableColumn<>("Ra");
		  rangedCol.setCellValueFactory(new PropertyValueFactory("ranged"));
		  //rangedCol.prefWidthProperty().bind(table1.widthProperty().divide(1));
		  TableColumn<Unit,Integer> defenseCol = new TableColumn<>("Def");
		  defenseCol.setCellValueFactory(new PropertyValueFactory("defense"));
		  //defenseCol.prefWidthProperty().bind(table1.widthProperty().divide(1));
		  TableColumn<Unit,Integer> attackCol = new TableColumn<>("Att");
		  attackCol.setCellValueFactory(new PropertyValueFactory("attack"));
		  //attackCol.prefWidthProperty().bind(table1.widthProperty().divide(1));
		  TableColumn<Unit,Integer> toughnessCol = new TableColumn<>("To");
		  toughnessCol.setCellValueFactory(new PropertyValueFactory("toughness"));
		  //toughnessCol.prefWidthProperty().bind(table1.widthProperty().divide(1));
		  TableColumn<Unit,Integer> costCol = new TableColumn<>("Cost");
		  costCol.setCellValueFactory(new PropertyValueFactory("cost"));
		  //costCol.prefWidthProperty().bind(table1.widthProperty().divide(1));
		  TableColumn<Unit, Boolean> actionCol = new TableColumn<>("Action");
		    actionCol.setSortable(false);
		    actionCol.setMinWidth(35);
		    //actionCol.prefWidthProperty().bind(table1.widthProperty().divide(1));
		    
		    //Columns for table 2
		    
			  TableColumn<Unit,String> unitNameCol2 = new TableColumn<>("Unit");
			  unitNameCol2.setCellValueFactory(new PropertyValueFactory("unitName"));
			  unitNameCol2.setMinWidth(100);
			  //unitNameCol2.isEditable();
			  TableColumn<Unit,Integer> speedCol2 = new TableColumn<>("Spd");
			  speedCol2.setCellValueFactory(new PropertyValueFactory("speed"));
			  TableColumn<Unit,Integer> meleeCol2 = new TableColumn<>("Me");
			  meleeCol2.setCellValueFactory(new PropertyValueFactory("melee"));
			  TableColumn<Unit,Integer> rangedCol2 = new TableColumn<>("Ra");
			  rangedCol2.setCellValueFactory(new PropertyValueFactory("ranged"));
			  TableColumn<Unit,Integer> defenseCol2 = new TableColumn<>("Def");
			  defenseCol2.setCellValueFactory(new PropertyValueFactory("defense"));
			  TableColumn<Unit,Integer> attackCol2 = new TableColumn<>("Att");
			  attackCol2.setCellValueFactory(new PropertyValueFactory("attack"));
			  TableColumn<Unit,Integer> toughnessCol2 = new TableColumn<>("To");
			  toughnessCol2.setCellValueFactory(new PropertyValueFactory("toughness"));
			  TableColumn<Unit,Integer> costCol2 = new TableColumn<>("Cost");
			  costCol2.setCellValueFactory(new PropertyValueFactory("cost"));
			  TableColumn<Unit, Boolean> actionCol2 = new TableColumn<>("Action");
			    actionCol2.setSortable(false);
			    actionCol2.setMinWidth(35);

		    // define a simple boolean cell value for the action column so that the column will only be shown for non-empty rows for table 1
		    actionCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Unit, Boolean>, ObservableValue<Boolean>>() {
		      @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Unit, Boolean> features) {
		        return new SimpleBooleanProperty(features.getValue() != null);
		      }
		    });

		    // create a cell value factory with an add button for each row in the table for table 1
		    actionCol.setCellFactory(new Callback<TableColumn<Unit, Boolean>, TableCell<Unit, Boolean>>() {
		      @Override public TableCell<Unit, Boolean> call(TableColumn<Unit, Boolean> unitBooleanTableColumn) {
		        return new AddUnitCell(mainStage, table1);
		      }
		    });
		    
		    // define a simple boolean cell value for the action column so that the column will only be shown for non-empty rows for table 2
		    actionCol2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Unit, Boolean>, ObservableValue<Boolean>>() {
		      @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Unit, Boolean> features) {
		        return new SimpleBooleanProperty(features.getValue() != null);
		      }
		    });

		    // create a cell value factory with an add button for each row in the table for table 2
		    actionCol2.setCellFactory(new Callback<TableColumn<Unit, Boolean>, TableCell<Unit, Boolean>>() {
		      @Override public TableCell<Unit, Boolean> call(TableColumn<Unit, Boolean> unitBooleanTableColumn) {
		        return new ViewUnitCell(mainStage, table1);
		      }
		    });
		    
		    
		    
		    
		    table1.getColumns().setAll(unitNameCol,speedCol,meleeCol,rangedCol,defenseCol,attackCol,toughnessCol,costCol,actionCol);
		    table1.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		    
		    table2.getColumns().setAll(unitNameCol2,speedCol2,meleeCol2,rangedCol2,defenseCol2,attackCol2,toughnessCol2,costCol2,actionCol2);
		    table2.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		    
		   // The menu bar in the top area  
	  	   
		   MenuBar menuBar = new MenuBar();
		  
		   menuBar.prefWidthProperty().bind(mainStage.widthProperty());
		   
		   Menu fileMenu = new Menu("_File");
		   fileMenu.setMnemonicParsing(true);
		   MenuItem newMenuItem = new MenuItem("New");
		   MenuItem exitMenuItem = new MenuItem("Exit");
		   exitMenuItem.setOnAction(actionevent -> Platform.exit());
		   fileMenu.getItems().addAll(newMenuItem, new SeparatorMenuItem(),exitMenuItem);
		   
		   Menu editMenu = new Menu("_Edit");
		   editMenu.setMnemonicParsing(true);
		   MenuItem copyMenuItem = new MenuItem("Copy");
		   //copyMenuItem.setMnemonicParsing(true);
		   //copyMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.C, KeyCombination.SHORTCUT_DOWN));
		   MenuItem selectAllMenuItem = new MenuItem("Select all");
		   MenuItem selectFontMenuItem = new MenuItem("Select font");
		   editMenu.getItems().addAll(copyMenuItem, selectAllMenuItem, new SeparatorMenuItem(),selectFontMenuItem);
		   
		   Menu aboutMenu = new Menu("_About");
		   aboutMenu.setMnemonicParsing(true);
		   MenuItem helpMenuItem = new MenuItem("Help");
		   MenuItem aboutMenuItem = new MenuItem("About");
		   aboutMenu.getItems().addAll(helpMenuItem, aboutMenuItem);
		   
		   menuBar.getMenus().addAll(fileMenu,editMenu,aboutMenu);
		   
		   Label summa = new Label("Summa av Warband");
		  
		   
		   // Puts the components onto the borderpane
		   
		   borderpane.setCenter(splitPane);
		   borderpane.setTop(menuBar);
		   borderpane.setBottom(summa);
		   splitPane.getItems().add(table1);
		   splitPane.getItems().add(table2);		   
		   
	      mainStage.setScene(scene);
	      mainStage.show();
	  }
	  
	  
	  private class ViewUnitCell extends TableCell<Unit, Boolean> {
		    // a button for viewing the stats of a unit.
		    final Button viewButton       = new Button("View");
		    // pads and centers the view button in the cell.
		    final StackPane paddedButton = new StackPane();
		    // records the y pos of the last button press so that the view unit dialog can be shown next to the cell.
		    final DoubleProperty buttonY = new SimpleDoubleProperty();
	  
		    /**
		     * ViewUnitCell constructor
		     * @param stage the stage in which the table is placed.
		     * @param table the table to which a unit can be viewed.
		     */
		    ViewUnitCell(final Stage stage, final TableView table) {
		      paddedButton.setPadding(new Insets(3));
		      paddedButton.getChildren().add(viewButton);
		      viewButton.setOnMousePressed(new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent mouseEvent) {
		          buttonY.set(mouseEvent.getScreenY());
		        }
		      });
		      viewButton.setOnAction(new EventHandler<ActionEvent>() {
		        @Override public void handle(ActionEvent actionEvent) {
		        	
		       
		        }
		      });
		    }

		    /** places a view button in the row only if the row is not empty. */
		    @Override protected void updateItem(Boolean item, boolean empty) {
		      super.updateItem(item, empty);
		      if (!empty) {
		        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
		        setGraphic(paddedButton);
		      } else {
		        setGraphic(null);
		      }
		    }
		  
	  }
	  
	  /** A table cell containing a button for adding a unit */
	  private class AddUnitCell extends TableCell<Unit, Boolean> {
	    // a button for adding a new Unit.
	    final Button addButton       = new Button("Add");
	    // pads and centers the add button in the cell.
	    final StackPane paddedButton = new StackPane();


	    /**
	     * AddUnitCell constructor
	     * @param stage the stage in which the table is placed.
	     * @param table the table to which a unit can be added.
	     */
	    AddUnitCell(final Stage stage, final TableView<Unit> table) {
	      paddedButton.setPadding(new Insets(3));
	      paddedButton.getChildren().add(addButton);

	      addButton.setOnAction(new EventHandler<ActionEvent>() {
	        @Override public void handle(ActionEvent actionEvent) {
	        	
	        
	        	//ObservableList<Unit> test = table.getFocusModel().getSelectedItems();
	        	//System.out.println(test.getUnitName());
	        	
	        	Unit selectedUnit = table.getSelectionModel().getSelectedItem();
	        	System.out.println(selectedUnit.getUnitName());
	        	warbandList.add(selectedUnit);
	        }
	      });
	    }

	    /** places an add button in the row only if the row is not empty. */
	    @Override protected void updateItem(Boolean item, boolean empty) {
	      super.updateItem(item, empty);
	      if (!empty) {
	        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
	        setGraphic(paddedButton);
	      } else {
	        setGraphic(null);
	      }
	    }
	  }
	  
	  
	  
	  public static void main(String[] args) {
		    launch(args);
		  }
}