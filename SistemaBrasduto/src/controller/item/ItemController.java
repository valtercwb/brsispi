/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.item;

import database.ConexaoBanco;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import model.Item;
import modelDAO.ItemDAO;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class ItemController implements Initializable {

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtLocal;

    @FXML
    private TextField txtMat;

    @FXML
    private TextField txtWei;

    @FXML
    private TextField txtQtt;

    @FXML
    private TextField txtQttDay;

    @FXML
    private TextField txtPrice;

    @FXML
    private TextField txtDim;

    @FXML
    private DatePicker datePic;

    @FXML
    private ImageView itemImg;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;
    @FXML
    private TableView<Item> tblViewItem;
    @FXML
    private TableColumn<Item, Number> clmnitemCode;
    @FXML
    private TableColumn<Item, String> clmnitemName;
    @FXML
    private TableColumn<Item, String> clmnitemLocal;
    @FXML
    private TableColumn<Item, String> clmnitemMatter;
    @FXML
    private TableColumn<Item, String> clmnitemPrice;
    @FXML
    private TableColumn<Item, Number> clmnitemQtd;
    @FXML
    private TableColumn<Item, Number> clmnitemQtdDay;
    @FXML
    private TableColumn<Item, String> clmnitemWeight;
    @FXML
    private TableColumn<Item, String> clmnitemDim;
    @FXML
    private TableColumn<Item, Date> clmnitemDate;

    private ObservableList<Item> listaItem;

    @FXML
    void btnDeleteOnClicked(ActionEvent event) {
      
    int resultado = tblViewItem.getSelectionModel().getSelectedItem().getItemId();
        database.ControleDAO.getBanco().getItemDAO().DeleteItem(resultado);
  
//        Item item = tblViewItem.getSelectionModel().getSelectedItem();
//
//Alert dialog = new Alert(AlertType.WARNING);
//dialog.setTitle("Aviso");
//dialog.setContentText("Você deseja realmente excluir o item selecionado?");
        listaItem.remove(tblViewItem.getSelectionModel().getSelectedIndex());

                        Alert msg = new Alert(AlertType.INFORMATION);
			msg.setTitle("Registro eliminado");
			msg.setContentText("O item foi excluido com sucesso!");
			msg.setHeaderText("Resultado:");
			msg.show();

    }

    @FXML
    void btnNewOnClicked(ActionEvent event) {
    CleanFields();
    }

    @FXML
    void btnSaveOnClicked(ActionEvent event) {
        Item item = new Item();

        item.setItemCode(Integer.parseInt(txtCode.getText()));
        item.setItemQtd(Integer.parseInt(txtQtt.getText()));
        item.setItemQtdDay(Integer.parseInt(txtQttDay.getText()));
        item.setItemName(txtName.getText());
        item.setItemLocal(txtLocal.getText());
        item.setItemMatter(txtMat.getText());
        item.setItemPrice(txtPrice.getText());
        item.setItemWeight(txtWei.getText());
        item.setItemDim(txtDim.getText());
        item.setItemDate(Date.valueOf(datePic.getValue()));

        System.out.println(item.getItemCode());
        System.out.println(item.getItemName());

        database.ControleDAO.getBanco().getItemDAO().SaveInput(item);

        listaItem.add(item);

        Alert msg = new Alert(AlertType.INFORMATION);
        msg.setTitle("Tabela de Itens");
        msg.setContentText("O Insumo foi adicionado com sucesso!");
        msg.setHeaderText("Resultado:");
        msg.show();
        CleanFields();

    }

    @FXML
    void btnUpdateOnClicked(ActionEvent event) {
        
        Item item = new Item();
	item.setItemCode(Integer.parseInt(txtCode.getText()));
        item.setItemQtd(Integer.parseInt(txtQtt.getText()));
        item.setItemQtdDay(Integer.parseInt(txtQttDay.getText()));
        item.setItemName(txtName.getText());
        item.setItemLocal(txtLocal.getText());
        item.setItemMatter(txtMat.getText());
        item.setItemPrice(txtPrice.getText());
        item.setItemWeight(txtWei.getText());
        item.setItemDim(txtDim.getText());
        item.setItemDate(Date.valueOf(datePic.getValue()));
	int resultado = tblViewItem.getSelectionModel().getSelectedItem().getItemId();
        database.ControleDAO.getBanco().getItemDAO().UpdateItem(item ,resultado);
        
	listaItem.set(tblViewItem.getSelectionModel().getSelectedIndex(),item);
			
	Alert msg = new Alert(AlertType.INFORMATION);
	msg.setTitle("Registro atualizado");
	msg.setContentText("O item foi atualizado com sucesso");
	msg.setHeaderText("Resultado:");
	msg.show();
 		
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        database.ConexaoBanco.instancia();
        listaItem = FXCollections.observableArrayList();
        ItemDAO.FillItemInfo(ConexaoBanco.instancia().getConnection(), listaItem);
        tblViewItem.setItems(listaItem);

        clmnitemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        clmnitemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        clmnitemLocal.setCellValueFactory(new PropertyValueFactory<>("itemLocal"));
        clmnitemMatter.setCellValueFactory(new PropertyValueFactory<>("itemMatter"));
        clmnitemPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        clmnitemQtd.setCellValueFactory(new PropertyValueFactory<>("itemQtd"));
        clmnitemQtdDay.setCellValueFactory(new PropertyValueFactory<>("itemQtdDay"));
        clmnitemWeight.setCellValueFactory(new PropertyValueFactory<>("itemWeight"));
        clmnitemDim.setCellValueFactory(new PropertyValueFactory<>("itemDim"));
        clmnitemDate.setCellValueFactory(new PropertyValueFactory<>("itemDate"));
        ManEvents();
    }

   
    public void CleanFields() {
        txtCode.setText(null);
        txtDim.setText(null);
        txtLocal.setText(null);
        txtMat.setText(null);
        txtName.setText(null);
        txtPrice.setText(null);
        txtQtt.setText(null);
        txtQttDay.setText(null);
        txtWei.setText(null);

//        btnGuardar.setDisable(false);
//        btnEliminar.setDisable(true);
//        btnActualizar.setDisable(true);
    }
    public void DisableFields(){
//        txtCode.disableProperty();
//        txtDim.setText(null);
//        txtLocal.setText(null);
//        txtMat.setText(null);
//        txtName.setText(null);
//        txtPrice.setText(null);
//        txtQtt.setText(null);
//        txtQttDay.setText(null);
//        txtWei.setText(null);
    
    }
    
    public void ManEvents(){

       tblViewItem.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<Item>() {
					@Override
					public void changed(ObservableValue<? extends Item> arg0,
							Item valorAnterior, Item valorSelecionado) {
							if (valorSelecionado!=null){
                                                            txtCode.setText(String.valueOf(valorSelecionado.getItemCode()));
                                                            txtName.setText(valorSelecionado.getItemName());
                                                            txtLocal.setText(valorSelecionado.getItemLocal());
                                                            txtMat.setText(valorSelecionado.getItemMatter());
                                                            txtPrice.setText(valorSelecionado.getItemPrice());
                                                            txtWei.setText(valorSelecionado.getItemWeight());
                                                            txtDim.setText(valorSelecionado.getItemDim());
                                                            txtQtt.setText(String.valueOf(valorSelecionado.getItemQtd()));
                                                            txtQttDay.setText(String.valueOf(valorSelecionado.getItemQtdDay()));	
                                                            datePic.setValue(valorSelecionado.getItemDate().toLocalDate());
//								cmbCarrera.setValue(valorSeleccionado.getCarrera());
//								cmbCentroEstudio.setValue(valorSeleccionado.getCentroEstudio());
								btnUpdate.setDisable(false);
								btnDelete.setDisable(false);
								btnUpdate.setDisable(false);
							}
					}

				}
		);
}
}
