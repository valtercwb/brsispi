/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.item;

import static controller.product.ProductController.phImg;
import database.ControleDAO;
import database.DbConnection;
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
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import static modelDAO.ItemDAO.isUniqItemCodStatus;
import modelDAO.MatterDAO;
import modelDAO.SectorDAO;
import modelDAO.SupplierDAO;
import service.Campo;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class ItemController implements Initializable {

    private final BooleanProperty okToAdd = new SimpleBooleanProperty(true);
    String regex = "[0-9]+";
    private File file;
    private BufferedImage bufferedImage;
    private String imagePath;
    private Image image;
    private Blob blobImage;

    @FXML
    private TextField filterField;
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

        Alert dialog = new Alert(AlertType.WARNING);
        dialog.setTitle("Aviso");
        dialog.setContentText("Você deseja realmente excluir o item selecionado?");
        dialog.showAndWait();
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
        item.setItemCode(txtCode.getText());
        item.setItemName(txtName.getText());
        item.setItemLocal(txtLocal.getText());
        item.setMatter(matCombo.getSelectionModel().getSelectedItem());
        item.setSector(secCombo.getSelectionModel().getSelectedItem());
        item.setSupplier(supCombo.getSelectionModel().getSelectedItem());
        item.setItemDim(txtDim.getText());
        if (txtQtt.getText().matches(regex) && txtQttDay.getText().matches(regex)) {
            item.setItemQtt(Integer.parseInt(txtQtt.getText()));
            item.setItemQttDay(Integer.parseInt(txtQttDay.getText()));
            item.setItemWei(txtWei.getText());
            item.setItemPrice(txtPrice.getText());
            item.setItemDate(Date.valueOf(datePic.getValue()));
            item.imagePath = imagePath;

            ControleDAO.getBanco().getItemDAO().SaveInput(DbConnection.instancia().getConnection(), item);
            if (isUniqItemCodStatus == true) {
                listaItem.add(item);

                Alert msg = new Alert(AlertType.INFORMATION);
                msg.setTitle("Tabela de Itens");
                msg.setContentText("O Insumo foi adicionado com sucesso!");
                msg.setHeaderText("Resultado:");
                msg.show();
                CleanFields();
            } else {
                Campo.fieldError(txtCode);
            }
        } else {
            Campo.fieldError(txtQtt);
            Campo.fieldError(txtQttDay);
            Alert msg = new Alert(AlertType.WARNING);
            msg.setTitle("Oh oh");
            msg.setContentText("Os campos de quantidade e uso diário devem conter apenas numeros)");
            msg.setHeaderText("Quantidade:");
            msg.show();
        }
    }

    @FXML
    void btnUpdateOnClicked(ActionEvent event) {

        Item item = new Item();
        item.setItemCode(txtCode.getText());
        item.setItemName(txtName.getText());
        item.setItemLocal(txtLocal.getText());
        item.setMatter(matCombo.getSelectionModel().getSelectedItem());
        item.setSector(secCombo.getSelectionModel().getSelectedItem());
        item.setSupplier(supCombo.getSelectionModel().getSelectedItem());
        item.setItemDim(txtDim.getText());
        if (txtQtt.getText().matches(regex) && txtQttDay.getText().matches(regex)) {
            item.setItemQtt(Integer.parseInt(txtQtt.getText()));
            item.setItemQttDay(Integer.parseInt(txtQttDay.getText()));
            item.setItemWei(txtWei.getText());
            item.setItemPrice(txtPrice.getText());
            item.setItemDate(Date.valueOf(datePic.getValue()));
            item.imagePath = imagePath;

            int resultado = tblViewItem.getSelectionModel().getSelectedItem().getItemId();

            if (database.ControleDAO.getBanco().getItemDAO().UpdateItem(database.DbConnection.instancia().getConnection(), item, resultado) != 0) {
                listaItem.set(tblViewItem.getSelectionModel().getSelectedIndex(), item);

                Alert msg = new Alert(AlertType.INFORMATION);
                msg.setTitle("Registro atualizado");
                msg.setContentText("O item foi atualizado com sucesso");
                msg.setHeaderText("Resultado:");
                msg.show();
            } else {

            }
        } else {
            Campo.fieldError(txtQtt);
            Campo.fieldError(txtQttDay);
            Alert msg = new Alert(AlertType.WARNING);
            msg.setTitle("Oh oh");
            msg.setContentText("Os campos de quantidade e uso diário devem conter apenas numeros");
            msg.setHeaderText("Quantidade:");
            msg.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DbConnection.instancia();
        listaItem = FXCollections.observableArrayList();
        ItemDAO.FillItemInfo(DbConnection.instancia().getConnection(), listaItem);
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

        listaMat = FXCollections.observableArrayList();
        MatterDAO.FillMatInfo(DbConnection.instancia().getConnection(), listaMat);
        matCombo.setItems(listaMat);
        listaSec = FXCollections.observableArrayList();
        SectorDAO.FillSecInfo(DbConnection.instancia().getConnection(), listaSec);
        secCombo.setItems(listaSec);
        listaSup = FXCollections.observableArrayList();
        SupplierDAO.FillBoxSupInfo(DbConnection.instancia().getConnection(), listaSup);
        supCombo.setItems(listaSup);

        ManEvents();

        FilteredList<Item> filteredData = new FilteredList<>(listaItem, i -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(item -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (item.getItemName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (item.getSector().getSecName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (item.getSupplier().getSupName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Item> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tblViewItem.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tblViewItem.setItems(sortedData);

        btnSave.disableProperty().bind(
                txtCode.textProperty().isEmpty().or(txtName.textProperty().isEmpty()).or(txtDim.textProperty().isEmpty()).or(txtLocal.textProperty().isEmpty()).or(txtQtt.textProperty().isEmpty()).or(txtQttDay.textProperty().isEmpty()).or(txtWei.textProperty().isEmpty()).or(matCombo.valueProperty().isNull()).or(supCombo.valueProperty().isNull()).or(secCombo.valueProperty().isNull()).or(datePic.valueProperty().isNull()).or(okToAdd.not()));

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

        tblViewItem.getSelectionModel().clearSelection();
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        okToAdd.set(true);
    }

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
                    } else {
                        itemImg.setImage(phImg);
                    }

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
                new FileChooser.ExtensionFilter("PNG (Portable Network Graphics)", "*.png"),
                new FileChooser.ExtensionFilter("JPG (Joint Photographic Group)", "*.jpg"),
                new FileChooser.ExtensionFilter("JPEG (Joint Photographic Experts Group)", "*.jpeg")
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
