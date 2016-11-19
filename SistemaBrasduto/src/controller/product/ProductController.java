/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

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
import model.Cat;
import model.Product;
import modelDAO.CatDAO;
import modelDAO.ProductDAO;


/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class ProductController implements Initializable {

    private File file;
    private BufferedImage bufferedImage;
    private String imagePath;
    private Image image;
    private Blob blobImage;
    public static  Image phImg = new Image("/image/pholder.png");
    
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

        int resultado = tblViewPro.getSelectionModel().getSelectedItem().getProId();
        database.ControleDAO.getBanco().getItemDAO().DeleteItem(resultado);
        
        listaPro.remove(tblViewPro.getSelectionModel().getSelectedIndex());

        Alert msg = new Alert(AlertType.INFORMATION);
        msg.setTitle("Registro eliminado");
        msg.setContentText("O Produto foi excluido com sucesso!");
        msg.setHeaderText("Resultado:");
        msg.show();

    }

    @FXML
    void btnNewOnClicked(ActionEvent event) {
        CleanFields();
    }

    @FXML
    void btnSaveOnClicked(ActionEvent event) {
        Product pro = new Product();
        pro.setProMat(Integer.parseInt(txtCode.getText()));
        pro.setProName(txtName.getText());
        pro.setCategory(catCombo.getSelectionModel().getSelectedItem());
        pro.setProFin(txtFin.getText());
        pro.setProQtt(Integer.parseInt(txtQtt.getText()));
        pro.setProDim(txtDim.getText());
        pro.setProWei(txtWei.getText());
        pro.setProCostPrice(txtCostPrice.getText());
        pro.setProSellPrice(txtSellPrice.getText());
        pro.setProData(Date.valueOf(datePic.getValue()));
        pro.imagePath = imagePath;
        
        ControleDAO.getBanco().getProductDAO().SaveProduct(ConexaoBanco.instancia().getConnection(), pro);

        listaPro.add(pro);

        Alert msg = new Alert(AlertType.INFORMATION);
        msg.setTitle("Tabela de Itens");
        msg.setContentText("O produto foi adicionado com sucesso!");
        msg.setHeaderText("Resultado:");
        msg.show();
        CleanFields();

    }

    @FXML
    void btnUpdateOnClicked(ActionEvent event) {

        Product pro = new Product();
        pro.setProMat(Integer.parseInt(txtCode.getText()));
        pro.setProName(txtName.getText());
        pro.setCategory(catCombo.getSelectionModel().getSelectedItem());
        pro.setProFin(txtFin.getText());
        pro.setProQtt(Integer.parseInt(txtQtt.getText()));
        pro.setProDim(txtDim.getText());
        pro.setProWei(txtWei.getText());
        pro.setProCostPrice(txtCostPrice.getText());
        pro.setProSellPrice(txtSellPrice.getText());
        pro.setProData(Date.valueOf(datePic.getValue()));
        pro.imagePath = imagePath;
       
        int resultado = tblViewPro.getSelectionModel().getSelectedItem().getProId();
        database.ControleDAO.getBanco().getProductDAO().UpdateProduct(database.ConexaoBanco.instancia().getConnection(), pro, resultado);

        listaPro.set(tblViewPro.getSelectionModel().getSelectedIndex(), pro);
       

        Alert msg = new Alert(AlertType.INFORMATION);
        msg.setTitle("Registro atualizado");
        msg.setContentText("O Produto foi atualizado com sucesso");
        msg.setHeaderText("Resultado:");
        msg.show();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ConexaoBanco.instancia();
        listaPro = FXCollections.observableArrayList();
        ProductDAO.FillProInfo(ConexaoBanco.instancia().getConnection(), listaPro);
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
        CatDAO.FillCatInfo(ConexaoBanco.instancia().getConnection(), listaCat);
        catCombo.setItems(listaCat);
        
        ManEvents();
        
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

//        btnGuardar.setDisable(false);
//        btnEliminar.setDisable(true);
//        btnActualizar.setDisable(true);
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
                    txtQtt.setText(String.valueOf(valorSelecionado.getProQtt()));
                    txtWei.setText(valorSelecionado.getProWei());
                    txtCostPrice.setText(valorSelecionado.getProCostPrice());
                    txtSellPrice.setText(valorSelecionado.getProSellPrice());
                    datePic.setValue(valorSelecionado.getProData().toLocalDate());
                    if (valorSelecionado.getProImage()!= null) {
                        Blob blob = valorSelecionado.getProImage();
                        byte[] data = blob.getBytes(1, (int) blob.length());
                        bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
                        image = SwingFXUtils.toFXImage(bufferedImage, null);
                    itemImg.setImage(image);
                    }else{itemImg.setImage(phImg);
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
