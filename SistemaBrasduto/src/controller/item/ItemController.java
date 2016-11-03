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
//        database.ConexaoBanco.instancia();
//        int resultado = tblViewItem.getSelectionModel().getSelectedItem().eliminarRegistro(database.ConexaoBanco.instancia().getConnection());
//        
//
//        if (resultado == 1) {
//            listaAlumnos.remove(tblViewAlumnos.getSelectionModel().getSelectedIndex());
//            //JDK 8u>40
//            Alert mensaje = new Alert(AlertType.INFORMATION);
//            mensaje.setTitle("Registro eliminado");
//            mensaje.setContentText("El registro ha sido eliminado exitosamente");
//            mensaje.setHeaderText("Resultado:");
//            mensaje.show();
    }

    @FXML
    void btnNewOnClicked(ActionEvent event) {

    }

    @FXML
    void btnSaveOnClicked(ActionEvent event) {
        Item item = new Item();
//        String nome = txtNome.getText();
//        String funcao = txtFuncao.getText();
//        String cidade = txtCidade.getText();
//        String estado = txtEstado.getText();
//        String pais = txtPais.getText();
//        String descricao = txtDescricao.getText();

        item.setItemCode(Integer.parseInt(txtCode.getText()));
        item.setItemQtd(Integer.parseInt(txtQtt.getText()));
        item.setItemQtdDay(Integer.parseInt(txtQttDay.getText()));
        item.setItemName(txtName.getText());
        item.setItemLocal(txtLocal.getText());
        item.setItemMatter(txtMat.getText());
        item.setItemPrice(txtPrice.getText());
        item.setItemWeight(txtWei.getText());
        item.setItemDim(txtDim.getText());
//        String data = datePic.getValue();
//        item.setItemDate(Tempo.(datePic.getValue(),"dd-MM-yyyy"));
                
        System.out.println(item.getItemCode());
        System.out.println(item.getItemName());
        System.out.println(item.getItemDim());
        System.out.println(item.getItemLocal());
        System.out.println(item.getItemMatter());
        System.out.println(item.getItemWeight());
        System.out.println(item.getItemQtdDay());
        System.out.println(item.getItemPrice());
        System.out.println(item.getItemQtd());
        database.ControleDAO.getBanco().getItemDAO().SaveInput(item);
      
            listaItem.add(item);
           
            Alert msg = new Alert(AlertType.INFORMATION);
            msg.setTitle("Tabela de Itens");
            msg.setContentText("O Insumo foi adcionado com sucesso!");
            msg.setHeaderText("Resultado:");
            msg.show();
        
    }

    @FXML
    void btnUpdateOnClicked(ActionEvent event) {
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

    }
}
