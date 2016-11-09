/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.item;

import database.ConexaoBanco;
import database.ControleDAO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import model.Item;
import model.Matter;
import model.Sector;
import model.Supplier;
import modelDAO.ItemDAO;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class ItemController implements Initializable {

    private File file;
    private BufferedImage bufferedImage;
    private String imagePath;
    private Image image;
    private Blob blobImage;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtLocal;

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
    public ImageView itemImg;

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
    private TableColumn<Item, String> clmnMatter;
    @FXML
    private TableColumn<Item, String> clmnSector;
    @FXML
    private TableColumn<Item, String> clmnSupplier;
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

    @FXML
    private ComboBox<Matter> matCombo;
    @FXML
    private ComboBox<Sector> secCombo;
    @FXML
    private ComboBox<Supplier> supCombo;

    private ObservableList<Item> listaItem;
    private ObservableList<Matter> listaMat;
    private ObservableList<Sector> listaSec;
    private ObservableList<Supplier> listaSup;

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
        item.setItemName(txtName.getText());
        item.setItemLocal(txtLocal.getText());
        item.setMatter(matCombo.getSelectionModel().getSelectedItem());
        item.setSector(secCombo.getSelectionModel().getSelectedItem());
        item.setSupplier(supCombo.getSelectionModel().getSelectedItem());
        item.setItemDim(txtDim.getText());
        item.setItemQtt(Integer.parseInt(txtQtt.getText()));
        item.setItemQttDay(Integer.parseInt(txtQttDay.getText()));
        item.setItemWei(txtWei.getText());
        item.setItemPrice(txtPrice.getText());
        item.setItemDate(Date.valueOf(datePic.getValue()));
        item.imagePath = imagePath;
        ControleDAO.getBanco().getItemDAO().SaveInput(ConexaoBanco.instancia().getConnection(), item);

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
        item.setItemName(txtName.getText());
        item.setItemLocal(txtLocal.getText());
        item.setMatter(matCombo.getSelectionModel().getSelectedItem());
        item.setSector(secCombo.getSelectionModel().getSelectedItem());
        item.setSupplier(supCombo.getSelectionModel().getSelectedItem());
        item.setItemDim(txtDim.getText());
        item.setItemQtt(Integer.parseInt(txtQtt.getText()));
        item.setItemQttDay(Integer.parseInt(txtQttDay.getText()));
        item.setItemWei(txtWei.getText());
        item.setItemPrice(txtPrice.getText());
        item.setItemDate(Date.valueOf(datePic.getValue()));
        item.imagePath = imagePath;

        int resultado = tblViewItem.getSelectionModel().getSelectedItem().getItemId();
        database.ControleDAO.getBanco().getItemDAO().UpdateItem(database.ConexaoBanco.instancia().getConnection(), item, resultado);

        listaItem.set(tblViewItem.getSelectionModel().getSelectedIndex(), item);

        Alert msg = new Alert(AlertType.INFORMATION);
        msg.setTitle("Registro atualizado");
        msg.setContentText("O item foi atualizado com sucesso");
        msg.setHeaderText("Resultado:");
        msg.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConexaoBanco.instancia();
        listaItem = FXCollections.observableArrayList();
        ItemDAO.FillItemInfo(ConexaoBanco.instancia().getConnection(), listaItem);
        tblViewItem.setItems(listaItem);

        clmnitemCode.setCellValueFactory(new PropertyValueFactory<>("itemCode"));
        clmnitemName.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        clmnitemLocal.setCellValueFactory(new PropertyValueFactory<>("itemLocal"));
        clmnMatter.setCellValueFactory(new PropertyValueFactory<>("matter"));
        clmnSector.setCellValueFactory(new PropertyValueFactory<>("sector"));
        clmnSupplier.setCellValueFactory(new PropertyValueFactory<>("supplier"));
        clmnitemPrice.setCellValueFactory(new PropertyValueFactory<>("itemPrice"));
        clmnitemQtd.setCellValueFactory(new PropertyValueFactory<>("itemQtt"));
        clmnitemQtdDay.setCellValueFactory(new PropertyValueFactory<>("itemQttDay"));
        clmnitemWeight.setCellValueFactory(new PropertyValueFactory<>("itemWei"));
        clmnitemDim.setCellValueFactory(new PropertyValueFactory<>("itemDim"));
        clmnitemDate.setCellValueFactory(new PropertyValueFactory<>("itemDate"));
       
//        listaMat = FXCollections.observableArrayList();
//        MatterDAO.FillMatInfo(ConexaoBanco.instancia().getConnection(), listaMat);
//        matCombo.setItems(listaMat);
//        listaSec = FXCollections.observableArrayList();
//        SectorDAO.FillSecInfo(ConexaoBanco.instancia().getConnection(), listaSec);
//        secCombo.setItems(listaSec);
//        listaSup = FXCollections.observableArrayList();
//        SupplierDAO.FillBoxSupInfo(ConexaoBanco.instancia().getConnection(), listaSup);
//        supCombo.setItems(listaSup);

        ManEvents();
    }

    public void CleanFields() {
        txtCode.setText(null);
        txtDim.setText(null);
        txtLocal.setText(null);
        matCombo.setValue(null);
        secCombo.setValue(null);
        supCombo.setValue(null);
        txtName.setText(null);
        txtPrice.setText(null);
        txtQtt.setText(null);
        txtQttDay.setText(null);
        txtWei.setText(null);
        datePic.setValue(null);
      

//        btnGuardar.setDisable(false);
//        btnEliminar.setDisable(true);
//        btnActualizar.setDisable(true);
    }

//        private void setAllDisable(){
//        studentTFFname.setDisable(true);
//        studentTFLname.setDisable(true);
//        //studentTFID.setDisable(true);
//        studentTFEmail.setDisable(true);
//        studentTFPhone.setDisable(true);
//        studentTFGFname.setDisable(true);
//        studentTFGLname.setDisable(true);
//        studentTFAddress.setDisable(true);
//        studentTFPassword.setDisable(true);
//        studentTFPicChooser.setDisable(true);
//
//        studentSaveClick.setDisable(true);
//        studentCancelClick.setDisable(true);
//    }
    public void ManEvents() {

        tblViewItem.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Item> arg0, Item valorAnterior, Item valorSelecionado) -> {
            if (valorSelecionado != null) {

                try {
                    txtCode.setText(String.valueOf(valorSelecionado.getItemCode()));
                    txtName.setText(valorSelecionado.getItemName());
                    txtLocal.setText(valorSelecionado.getItemLocal());
                    matCombo.setValue(valorSelecionado.getMatter());
                    secCombo.setValue(valorSelecionado.getSector());
                    supCombo.setValue(valorSelecionado.getSupplier());
                    txtPrice.setText(valorSelecionado.getItemPrice());
                    txtWei.setText(valorSelecionado.getItemWei());
                    txtDim.setText(valorSelecionado.getItemDim());
                    txtQtt.setText(String.valueOf(valorSelecionado.getItemQtt()));
                    txtQttDay.setText(String.valueOf(valorSelecionado.getItemQttDay()));
                    datePic.setValue(valorSelecionado.getItemDate().toLocalDate());
                    if (valorSelecionado.getItemImage() != null) {
                        Blob blob = valorSelecionado.getItemImage();
                        byte[] data = blob.getBytes(1, (int) blob.length());
                        bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
                        image = SwingFXUtils.toFXImage(bufferedImage, null);
                    itemImg.setImage(image);
                    }else{valorSelecionado.image = new Image("/image/pholder.png");
                    }
                 
//                    
//                    itemImg.
//                itemImg.setImage(valorSelecionado.getItemImage());								
                    btnUpdate.setDisable(false);
                    btnDelete.setDisable(false);
                    btnUpdate.setDisable(false);
                } catch (SQLException | IOException ex) {
                    Logger.getLogger(ItemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    @FXML
    void attachImageOnAction(MouseEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG (Joint Photographic Group)", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG (Joint Photographic Experts Group)", "*.jpeg"),
                new FileChooser.ExtensionFilter("PNG (Portable Network Graphics)", "*.png")
        );
        fileChooser.setTitle("Escolha uma imagem");

        file = fileChooser.showOpenDialog(null);

        if (file != null) {
            System.out.println(file);
            bufferedImage = ImageIO.read(file);
            image = SwingFXUtils.toFXImage(bufferedImage, null);
            itemImg.setImage(image);
            imagePath = file.getAbsolutePath();
        }
    }
}