package jfxtras.labs.scene.control.triple;

import java.io.IOException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;

public class DefaultTripleEditTableSkin<T> extends SkinBase<TripleEditTable<T>>
{
	private ResourceBundle resources;
	
	@FXML protected TableView<Triple> table;
	@FXML protected TableColumn<Triple, String> dataColumn;
	@FXML protected TableColumn<Triple, String> nameColumn;
	@FXML protected TableColumn<Triple, Boolean> primaryColumn;
	@FXML private Button deleteButton;
//	static private String language = "en";
//	static private Locale myLocale = new Locale(language);
//	static private ResourceBundle defaultResources  = ResourceBundle.getBundle("jfxtras.labs.scene.control.triple.Bundle", myLocale);

	protected DefaultTripleEditTableSkin(TripleEditTable<T> control, ResourceBundle resources)
	{
		super(control);
		// setup component
		this.resources = resources;

		createNodes();
	}
	
	private void createNodes()
	{
		getChildren().clear();
		HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER_LEFT);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TripleTable.fxml"));
        loader.setController(this);
        loader.setRoot(hbox);
        loader.setResources(resources);
        try {
            loader.load();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
		getChildren().add(hbox);
		
		// COLUMN WIDTH - need to add up to 1
	    nameColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.425));
	    dataColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.43));
	    primaryColumn.prefWidthProperty().bind(table.widthProperty().multiply(0.14));
	    nameColumn.setMaxWidth(1f * Integer.MAX_VALUE * 42.5);
	    dataColumn.setMaxWidth(1f * Integer.MAX_VALUE * 43);
	    primaryColumn.setMaxWidth(1f * Integer.MAX_VALUE * 14);	
	    
	    System.out.println("columns:" + nameColumn.getWidth() + " " + dataColumn.getWidth() + " " + primaryColumn.getWidth());
	    System.out.println("pref columns:" + nameColumn.getPrefWidth() + " " + dataColumn.getPrefWidth() + " " + primaryColumn.getPrefWidth());
	}

//    private static void loadFxml(URL fxmlFile, Object root, ResourceBundle resources)
//    {
//        FXMLLoader loader = new FXMLLoader(fxmlFile);
//        loader.setController(this);
//        loader.setRoot(rootController);
//        loader.setResources(resources);
//        try {
//            loader.load();
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }
//    }
}
