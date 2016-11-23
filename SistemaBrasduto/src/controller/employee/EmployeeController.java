/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.employee;

import static controller.product.ProductController.phImg;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import model.City;
import model.CityState;
import model.Country;
import model.Dep;
import model.EmpStatus;
import model.Employee;
import model.Gen;
import model.MaritalStatus;
import model.SchLevel;
import modelDAO.CityDAO;
import modelDAO.CityStateDAO;
import modelDAO.CountryDAO;
import modelDAO.DepDAO;
import modelDAO.EmpDAO;
import static modelDAO.EmpDAO.isUniqCodeStatus;
import modelDAO.EmpStatusDAO;
import modelDAO.GenDAO;
import modelDAO.MaritalStatusDAO;
import modelDAO.SchLevelDAO;
import service.Campo;

/**
 *
 * @author valterFranco <unicuritibaads>
 */
public class EmployeeController implements Initializable {

    private File file;
    private BufferedImage bufferedImage;
    private String imagePath;
    private Image image;
    private Blob blobImage;

    @FXML
    private TabPane tabPane;
    @FXML
    private Tab empPage;
    @FXML
    private Tab empPage2;
    @FXML
    private TableView<Employee> tblViewEmp;
    @FXML
    private TextField txtDescCurso;
    @FXML
    private TextField txtMat;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtFix;

    @FXML
    private ComboBox<MaritalStatus> marStaCombo;

    @FXML
    private ComboBox<Gen> genCombo;

    @FXML
    private DatePicker birthDate;

    @FXML
    private TextField txtCel;

    @FXML
    private TextField txtSub;

    @FXML
    private TextField txtCep;

    @FXML
    private TextField txtAdress;

    @FXML
    private ComboBox<City> cityCombo;

    @FXML
    private ComboBox<CityState> stateCombo;

    @FXML
    private ComboBox<Country> countryCombo;

    @FXML
    private TextField txtEmail;

    @FXML
    private ComboBox<SchLevel> schLevCombo;

    @FXML
    private ImageView empImage;

    @FXML
    private TextField txtRg;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtCp;

    @FXML
    private TextField txtPis;

    @FXML
    private TextField txtCnh;

    @FXML
    private TextField txtCt;

    @FXML
    private TextField txtPosition;

    @FXML
    private TextField txtSalary;

    @FXML
    private ComboBox<EmpStatus> empStaCombo;

    @FXML
    private ComboBox<Dep> empDepCombo;

    @FXML
    private DatePicker admDate;

    @FXML
    private DatePicker fireDate;

    @FXML
    private TextField empFilterField;

    @FXML
    private TableColumn<Employee, String> clmnempCode;
    @FXML
    private TableColumn<Employee, String> clmnempName;

    private ObservableList<Employee> listaEmp;
    private ObservableList<Gen> listaGen;
    private ObservableList<MaritalStatus> listaMarSta;
    private ObservableList<EmpStatus> listaEmpSta;
    private ObservableList<Dep> listaEmpDep;
    private ObservableList<SchLevel> listaSchLev;
    private ObservableList<City> listaCity;
    private ObservableList<CityState> listaCtState;
    private ObservableList<Country> listaCountry;

    @FXML
    void DeleteEmpOnClicked(ActionEvent event) {
        int resultado = tblViewEmp.getSelectionModel().getSelectedItem().getEmpId();
        database.ControleDAO.getBanco().getEmpDAO().DeleteItem(resultado);

        Alert dialog = new Alert(AlertType.WARNING);
        dialog.setTitle("Aviso");
        dialog.setContentText("Você deseja realmente excluir o item selecionado?");
        dialog.showAndWait();
        listaEmp.remove(tblViewEmp.getSelectionModel().getSelectedIndex());

        Alert msg = new Alert(AlertType.INFORMATION);
        msg.setTitle("Registro eliminado");
        msg.setContentText("O item foi excluido com sucesso!");
        msg.setHeaderText("Resultado:");
        msg.show();
    }

    @FXML
    void DeleteEmpOnClicked2(ActionEvent event) {
        DeleteEmpOnClicked(event);
    }

    @FXML
    void EditEmpOnClicked(ActionEvent event) {
        if(tblViewEmp.getSelectionModel().getSelectedItem()!=null){
        Employee emp = new Employee();
        emp.setEmpCode(txtMat.getText());
        emp.setEmpName(txtName.getText());
        emp.setGen(genCombo.getSelectionModel().getSelectedItem());
        emp.setEmpBirthDate(Date.valueOf(birthDate.getValue()));
        emp.setMaritalStatus(marStaCombo.getSelectionModel().getSelectedItem());
        emp.setEmpPhoneFix(txtFix.getText());
        emp.setEmpPhoneCel(txtCel.getText());
        emp.setEmpEmail(txtEmail.getText());
        emp.setEmpAdress(txtAdress.getText());
        emp.setEmpZipCode(txtCep.getText());
        emp.setEmpSub(txtSub.getText());
        emp.setCity(cityCombo.getSelectionModel().getSelectedItem());
        emp.setCityState(stateCombo.getSelectionModel().getSelectedItem());
        emp.setCountry(countryCombo.getSelectionModel().getSelectedItem());
        emp.setSchLevel(schLevCombo.getSelectionModel().getSelectedItem());
        emp.setEmpSchDesc(txtDescCurso.getText());
        emp.setEmpRg(txtRg.getText());
        emp.setEmpCpf(txtCpf.getText());
        emp.setEmpCp(txtCp.getText());
        emp.setEmpPis(txtPis.getText());
        emp.setEmpCnh(txtCnh.getText());
        emp.setEmpTrans(txtCt.getText());
        emp.setEmpStatus(empStaCombo.getSelectionModel().getSelectedItem());
        emp.setEmpDep(empDepCombo.getSelectionModel().getSelectedItem());
        emp.setEmpPosition(txtPosition.getText());
        emp.setEmpSalary(txtSalary.getText());
        emp.setAdmDate(Date.valueOf(admDate.getValue()));
        emp.setFireDate(Date.valueOf(fireDate.getValue()));
        emp.imagePath = imagePath;

        int resultado = tblViewEmp.getSelectionModel().getSelectedItem().getEmpId();
        if (database.ControleDAO.getBanco().getEmpDAO().UpdateEmp(database.ConexaoBanco.instancia().getConnection(), emp, resultado) != 0) {
            listaEmp.set(tblViewEmp.getSelectionModel().getSelectedIndex(), emp);

            Alert msg = new Alert(AlertType.INFORMATION);
            msg.setTitle("Funcionario atualizado");
            msg.setContentText("O Funcionario foi atualizado com sucesso");
            msg.setHeaderText("Resultado:");
            msg.show();
        } else {
            Alert msg = new Alert(AlertType.ERROR);
            msg.setTitle("Deu ruim!");
            msg.setContentText("Aconteceu um erro ao atualizar os dados no banco, contacte o suporte Técnico :(");
            msg.setHeaderText("Resultado:");
            msg.show();
        }}else{
            Alert msg = new Alert(AlertType.INFORMATION);
            msg.setTitle("Ajuda");
            msg.setHeaderText("Primeiro voce precisa selecionar um Funcionario na tabela :)");
            msg.show();
        }
    }

    @FXML
    void EditEmpOnClicked2(ActionEvent event) {
        EditEmpOnClicked(event);
    }

    @FXML
    void GoBackPage1(ActionEvent event) {
        tabPane.getSelectionModel().select(empPage);
    }

    @FXML
    void NewEmpOnClicked(ActionEvent event) {
        CleanFields();
    }

    @FXML
    void NewEmpOnClicked2(ActionEvent event) {
        CleanFields();
    }

    @FXML
    void NextPage(ActionEvent event) {
        tabPane.getSelectionModel().select(empPage2);
    }

    @FXML
    void SaveEmpOnClicked(ActionEvent event) {
        Employee emp = new Employee();
        emp.setEmpCode(txtMat.getText());
        emp.setEmpName(txtName.getText());
        emp.setGen(genCombo.getSelectionModel().getSelectedItem());
        emp.setEmpBirthDate(Date.valueOf(birthDate.getValue()));
        emp.setMaritalStatus(marStaCombo.getSelectionModel().getSelectedItem());
        emp.setEmpPhoneFix(txtFix.getText());
        emp.setEmpPhoneCel(txtCel.getText());
        emp.setEmpEmail(txtEmail.getText());
        emp.setEmpAdress(txtAdress.getText());
        emp.setEmpZipCode(txtCep.getText());
        emp.setEmpSub(txtSub.getText());
        emp.setCity(cityCombo.getSelectionModel().getSelectedItem());
        emp.setCityState(stateCombo.getSelectionModel().getSelectedItem());
        emp.setCountry(countryCombo.getSelectionModel().getSelectedItem());
        emp.setSchLevel(schLevCombo.getSelectionModel().getSelectedItem());
        emp.setEmpSchDesc(txtDescCurso.getText());
        emp.setEmpRg(txtRg.getText());
        emp.setEmpCpf(txtCpf.getText());
        emp.setEmpCp(txtCp.getText());
        emp.setEmpPis(txtPis.getText());
        emp.setEmpCnh(txtCnh.getText());
        emp.setEmpTrans(txtCt.getText());
        emp.setEmpStatus(empStaCombo.getSelectionModel().getSelectedItem());
        emp.setEmpDep(empDepCombo.getSelectionModel().getSelectedItem());
        emp.setEmpPosition(txtPosition.getText());
        emp.setEmpSalary(txtSalary.getText());
        emp.setAdmDate(Date.valueOf(admDate.getValue()));
        emp.setFireDate(Date.valueOf(fireDate.getValue()));
        emp.imagePath = imagePath;

        ControleDAO.getBanco().getEmpDAO().SaveEmpInput(ConexaoBanco.instancia().getConnection(), emp);
        if (isUniqCodeStatus == true) {
            listaEmp.add(emp);

            Alert msg = new Alert(AlertType.INFORMATION);
            msg.setTitle("Tabela de Funcionarios");
            msg.setContentText("O Funcionario foi adicionado com sucesso!");
            msg.setHeaderText("Resultado:");
            msg.show();
            CleanFields();
        } else {
            Campo.fieldError(txtMat);
        }
    }

    @FXML
    void SaveEmpOnClicked2(ActionEvent event) {
        SaveEmpOnClicked(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ConexaoBanco.instancia();
        listaEmp = FXCollections.observableArrayList();
        EmpDAO.FillEmpInfo(ConexaoBanco.instancia().getConnection(), listaEmp);

        if (listaEmp != null) {
            tblViewEmp.setItems(listaEmp);
            clmnempCode.setCellValueFactory(new PropertyValueFactory<>("empCode"));
            clmnempName.setCellValueFactory(new PropertyValueFactory<>("empName"));
        }

        listaGen = FXCollections.observableArrayList();
        GenDAO.FillGenInfo(ConexaoBanco.instancia().getConnection(), listaGen);
        genCombo.setItems(listaGen);

        listaMarSta = FXCollections.observableArrayList();
        MaritalStatusDAO.FillMarStatusInfo(ConexaoBanco.instancia().getConnection(), listaMarSta);
        marStaCombo.setItems(listaMarSta);

        listaEmpDep = FXCollections.observableArrayList();
        DepDAO.FillDepInfo(ConexaoBanco.instancia().getConnection(), listaEmpDep);
        empDepCombo.setItems(listaEmpDep);

        listaEmpSta = FXCollections.observableArrayList();
        EmpStatusDAO.FillEmpStatusInfo(ConexaoBanco.instancia().getConnection(), listaEmpSta);
        empStaCombo.setItems(listaEmpSta);

        listaSchLev = FXCollections.observableArrayList();
        SchLevelDAO.FillSchLevelInfo(ConexaoBanco.instancia().getConnection(), listaSchLev);
        schLevCombo.setItems(listaSchLev);

        listaCtState = FXCollections.observableArrayList();
        CityStateDAO.FillCtStateInfo(ConexaoBanco.instancia().getConnection(), listaCtState);
        stateCombo.setItems(listaCtState);

        listaCountry = FXCollections.observableArrayList();
        CountryDAO.FillCouInfo(ConexaoBanco.instancia().getConnection(), listaCountry);
        countryCombo.setItems(listaCountry);

        listaCity = FXCollections.observableArrayList();
        CityDAO.FillCityInfo(ConexaoBanco.instancia().getConnection(), listaCity);
        cityCombo.setItems(listaCity);

        ManEvents();

        FilteredList<Employee> filteredData = new FilteredList<>(listaEmp, i -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        empFilterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(employee -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (employee.getEmpName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (employee.getEmpCode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (employee.getEmpDep().getDepName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Employee> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        if (tblViewEmp != null) {
            sortedData.comparatorProperty().bind(tblViewEmp.comparatorProperty());

            // 5. Add sorted (and filtered) data to the table.
            tblViewEmp.setItems(sortedData);
        }
    }

    public void CleanFields() {
        txtName.setText(null);
        txtMat.setText(null);
        txtCel.setText(null);
        countryCombo.setValue(null);
        cityCombo.setValue(null);
        empDepCombo.setValue(null);
        empStaCombo.setValue(null);
        genCombo.setValue(null);
        stateCombo.setValue(null);
        marStaCombo.setValue(null);
        schLevCombo.setValue(null);
        txtName.setText(null);
        txtFix.setText(null);
        txtCnh.setText(null);
        txtCep.setText(null);
        txtDescCurso.setText(null);
        birthDate.setValue(null);
        txtPis.setText(null);
        txtEmail.setText(null);
        txtPosition.setText(null);
        txtSalary.setText(null);
        txtSub.setText(null);
        txtRg.setText(null);
        txtCpf.setText(null);
        txtCp.setText(null);
    }

    private void ManEvents() {
        if (tblViewEmp != null) {
            tblViewEmp.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Employee> arg0, Employee valorAnterior, Employee valorSelecionado) -> {
                if (valorSelecionado != null) {

                    try {
                        txtMat.setText(valorSelecionado.getEmpCode());
                        txtName.setText(valorSelecionado.getEmpName());
                        genCombo.setValue(valorSelecionado.getGen());
                        birthDate.setValue(valorSelecionado.getEmpBirthDate().toLocalDate());
                        marStaCombo.setValue(valorSelecionado.getMaritalStatus());
                        txtFix.setText(valorSelecionado.getEmpPhoneFix());
                        txtCel.setText(valorSelecionado.getEmpPhoneCel());
                        txtEmail.setText(valorSelecionado.getEmpEmail());
                        txtAdress.setText(valorSelecionado.getEmpAdress());
                        txtCep.setText(valorSelecionado.getEmpZipCode());
                        txtSub.setText(valorSelecionado.getEmpSub());
                        cityCombo.setValue(valorSelecionado.getCity());
                        stateCombo.setValue(valorSelecionado.getCityState());
                        countryCombo.setValue(valorSelecionado.getCountry());
                        schLevCombo.setValue(valorSelecionado.getSchLevel());
                        txtDescCurso.setText(valorSelecionado.getEmpSchDesc());
                        txtRg.setText(valorSelecionado.getEmpRg());
                        txtCpf.setText(valorSelecionado.getEmpCpf());
                        txtCp.setText(valorSelecionado.getEmpCp());
                        txtPis.setText(valorSelecionado.getEmpPis());
                        txtCnh.setText(valorSelecionado.getEmpCnh());
                        txtCt.setText(valorSelecionado.getEmpTrans());
                        empStaCombo.setValue(valorSelecionado.getEmpStatus());
                        empDepCombo.setValue(valorSelecionado.getEmpDep());
                        txtPosition.setText(valorSelecionado.getEmpPosition());
                        txtSalary.setText(valorSelecionado.getEmpSalary());
                        admDate.setValue(valorSelecionado.getAdmDate().toLocalDate());
                        fireDate.setValue(valorSelecionado.getFireDate().toLocalDate());
                        if (valorSelecionado.getEmpBlob() != null) {
                            Blob blob = valorSelecionado.getEmpBlob();
                            byte[] data = blob.getBytes(1, (int) blob.length());
                            bufferedImage = ImageIO.read(new ByteArrayInputStream(data));
                            image = SwingFXUtils.toFXImage(bufferedImage, null);
                            empImage.setImage(image);
                        } else {
                            empImage.setImage(phImg);
                        }

                    } catch (SQLException | IOException ex) {
                        Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
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
            empImage.setImage(image);
            imagePath = file.getAbsolutePath();
        }
    }
}
