/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

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
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
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
import javafx.scene.control.ButtonType;
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
import model.Cat;
import model.Product;
import modelDAO.CatDAO;
import modelDAO.ProductDAO;
import static modelDAO.ProductDAO.isUniqCodProStatus;
import service.Campo;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class ProductController implements Initializable {

    private final BooleanProperty okToAdd = new SimpleBooleanProperty(true);
    String regex = "[0-9]+";
    private File file;
    private BufferedImage bufferedImage;
    private String imagePath;
    private Image image;
    private Blob blobImage;
    public static Image phImg = new Image("/image/pholder.png");

    private ObservableList<Cat> listaCat;
    private ObservableList<Product> listaPro;

    @FXML
    private TextField filterField;

    @FXML
    private ComboBox<Cat> catCombo;

    @FXML
    private TextField txtCode;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtCostPrice;

    @FXML
    private TextField txtWei;

    @FXML
    private DatePicker datePic;

    @FXML
    private TextField txtFin;

    @FXML
    private TextField txtDim;

    @FXML
    public ImageView itemImg;

    @FXML
    private TextField txtQtt;

    @FXML
    private TextField txtSellPrice;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private TableView<Product> tblViewPro;
    @FXML
    private TableColumn<Product, Number> clmnproMat;
    @FXML
    private TableColumn<Product, String> clmnproName;
    @FXML
    private TableColumn<Product, Cat> clmncategory;
    @FXML
    private TableColumn<Product, String> clmnproFin;
    @FXML
    private TableColumn<Product, Number> clmnproQtt;
    @FXML
    private TableColumn<Product, String> clmnproDim;
    @FXML
    private TableColumn<Product, String> clmnproWei;
    @FXML
    private TableColumn<Product, String> clmnproCostPrice;
    @FXML
    private TableColumn<Product, String> clmnproSellPrice;
    @FXML
    private TableColumn<Product, Date> clmnproData;

    @FXML
    void btnDeleteOnClicked(ActionEvent event) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Sistema Brasduto");
        alert.setHeaderText("Você deseja realmente excluir o produto selecionado?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            int resultado = tblViewPro.getSelectionModel().getSelectedItem().getProId();
            listaPro.remove(tblViewPro.getSelectionModel().getSelectedIndex());

            if (database.ControleDAO.getBanco().getProductDAO().DeleteItem(resultado) != 0) {
                Alert msg = new Alert(AlertType.INFORMATION);
                msg.setTitle("Registro eliminado");
                msg.setContentText("O Produto foi excluido com sucesso!");
                msg.setHeaderText("Resultado:");
                msg.show();
            } else {
                Alert msg = new Alert(Alert.AlertType.ERROR);
                msg.setTitle("Deu ruim");
                msg.setContentText("Não consegui estabelecer a conexao com o banco,contacte o técnico. :{");
                msg.setHeaderText("Resultado:");
                msg.show();
            }

        } else {
        }

    }

    @FXML
    void btnNewOnClicked(ActionEvent event) {
        CleanFields();
    }

    @FXML
    void btnSaveOnClicked(ActionEvent event) {
        Product pro = new Product();
        pro.setProMat(txtCode.getText());
        pro.setProName(txtName.getText());
        pro.setCategory(catCombo.getSelectionModel().getSelectedItem());
        pro.setProFin(txtFin.getText());
        if (txtQtt.getText().matches(regex)) {
            pro.setProQtt(txtQtt.getText());
            pro.setProDim(txtDim.getText());
            pro.setProWei(txtWei.getText());
            pro.setProCostPrice(txtCostPrice.getText());
            pro.setProSellPrice(txtSellPrice.getText());
            pro.setProData(Date.valueOf(datePic.getValue()));
            pro.imagePath = imagePath;

            ControleDAO.getBanco().getProductDAO().SaveProduct(DbConnection.instancia().getConnection(), pro);
            if (isUniqCodProStatus == true) {
                listaPro.add(pro);
                Alert msg = new Alert(AlertType.INFORMATION);
                msg.setTitle("Tabela de Produtos");
                msg.setContentText("O produto foi adicionado com sucesso!");
                msg.setHeaderText("Resultado:");
                msg.show();
                CleanFields();
            } else {
                Campo.fieldError(txtCode);
            }
        } else {
            Campo.fieldError(txtQtt);
            Alert msg = new Alert(AlertType.INFORMATION);
            msg.setTitle("Oh oh");
            msg.setContentText("O atributo quantidade deve conter apenas numeros :)");
            msg.setHeaderText("Quantidade:");
            msg.show();
        }
    }

    @FXML
    void btnUpdateOnClicked(ActionEvent event) {
        Product pro = new Product();
        pro.setProMat(txtCode.getText());
        pro.setProName(txtName.getText());
        pro.setCategory(catCombo.getSelectionModel().getSelectedItem());
        pro.setProFin(txtFin.getText());
        if (txtQtt.getText().matches(regex)) {
            pro.setProQtt(txtQtt.getText());
            pro.setProDim(txtDim.getText());
            pro.setProWei(txtWei.getText());
            pro.setProCostPrice(txtCostPrice.getText());
            pro.setProSellPrice(txtSellPrice.getText());
            pro.setProData(Date.valueOf(datePic.getValue()));
            pro.imagePath = imagePath;

            int resultado = tblViewPro.getSelectionModel().getSelectedItem().getProId();
            database.ControleDAO.getBanco().getProductDAO().UpdateProduct(database.DbConnection.instancia().getConnection(), pro, resultado);

            listaPro.set(tblViewPro.getSelectionModel().getSelectedIndex(), pro);

            Alert msg = new Alert(AlertType.INFORMATION);
            msg.setTitle("Registro atualizado");
            msg.setContentText("O Produto foi atualizado com sucesso");
            msg.setHeaderText("Resultado:");
            msg.show();
        } else {
            Campo.fieldError(txtQtt);
            Alert msg = new Alert(AlertType.INFORMATION);
            msg.setTitle("Oh oh");
            msg.setContentText("O atributo quantidade deve conter apenas numeros :)");
            msg.setHeaderText("Quantidade:");
            msg.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DbConnection.instancia();
        listaPro = FXCollections.observableArrayList();
        ProductDAO.FillProInfo(DbConnection.instancia().getConnection(), listaPro);
        tblViewPro.setItems(listaPro);

        clmnproMat.setCellValueFactory(new PropertyValueFactory<>("proMat"));
        clmnproName.setCellValueFactory(new PropertyValueFactory<>("proName"));
        clmncategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        clmnproFin.setCellValueFactory(new PropertyValueFactory<>("proFin"));
        clmnproQtt.setCellValueFactory(new PropertyValueFactory<>("proQtt"));
        clmnproDim.setCellValueFactory(new PropertyValueFactory<>("proDim"));
        clmnproWei.setCellValueFactory(new PropertyValueFactory<>("proWei"));
        clmnproCostPrice.setCellValueFactory(new PropertyValueFactory<>("proCostPrice"));
        clmnproSellPrice.setCellValueFactory(new PropertyValueFactory<>("proSellPrice"));
        clmnproData.setCellValueFactory(new PropertyValueFactory<>("proData"));

        listaCat = FXCollections.observableArrayList();
        CatDAO.FillCatInfo(DbConnection.instancia().getConnection(), listaCat);
        catCombo.setItems(listaCat);

        ManEvents();

        btnDelete.setDisable(true);
        btnUpdate.setDisable(true);

        FilteredList<Product> filteredData = new FilteredList<>(listaPro, i -> true);

        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(product -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();

                if (product.getProName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (product.getCategory().getCatName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else if (product.getProFin().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                }
                return false;
            });
        });
        SortedList<Product> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblViewPro.comparatorProperty());
        tblViewPro.setItems(sortedData);

        btnSave.disableProperty().bind(
                txtCode.textProperty().isEmpty().or(txtName.textProperty().isEmpty()).or(txtFin.textProperty().isEmpty()).or(txtDim.textProperty().isEmpty()).or(txtCostPrice.textProperty().isEmpty()).or(txtSellPrice.textProperty().isEmpty()).or(txtQtt.textProperty().isEmpty()).or(catCombo.valueProperty().isNull()).or(datePic.valueProperty().isNull()).or(okToAdd.not()));

//        btnDelete.disableProperty().bind(
//                tblViewPro.getFocusModel().or(okToAdd.not()));
//        btnUpdate.disableProperty().bind(
//                tblViewPro.focusedProperty().not().or(okToAdd.not()));
        InvalidationListener listener = observable -> {
            if (!btnDelete.isDisabled()) {
                btnUpdate.setDisable(false);
            }
        };

        catCombo.valueProperty().addListener(listener);
    }

    public void CleanFields() {
        txtCode.setText(null);
        txtDim.setText(null);
        txtSellPrice.setText(null);
        catCombo.setValue(null);
        txtName.setText(null);
        txtCostPrice.setText(null);
        txtQtt.setText(null);
        txtFin.setText(null);
        txtWei.setText(null);
        datePic.setValue(null);
        itemImg.setImage(phImg);
        tblViewPro.getSelectionModel().clearSelection();
        btnUpdate.setDisable(true);
        btnDelete.setDisable(true);
        okToAdd.set(true);
    }

    public void ManEvents() {

        tblViewPro.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Product> arg0, Product valorAnterior, Product valorSelecionado) -> {
            if (valorSelecionado != null) {

                try {
                    txtCode.setText(String.valueOf(valorSelecionado.getProMat()));
                    txtName.setText(valorSelecionado.getProName());
                    catCombo.setValue(valorSelecionado.getCategory());
                    txtFin.setText(valorSelecionado.getProFin());
                    txtDim.setText(valorSelecionado.getProDim());
                    txtQtt.setText(valorSelecionado.getProQtt());
                    txtWei.setText(valorSelecionado.getProWei());
                    txtCostPrice.setText(valorSelecionado.getProCostPrice());
                    txtSellPrice.setText(valorSelecionado.getProSellPrice());
                    datePic.setValue(valorSelecionado.getProData().toLocalDate());
                    if (valorSelecionado.getProImage() != null) {
                        Blob blob = valorSelecionado.getProImage();
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
                    Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
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
