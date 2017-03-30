/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import database.ControleDAO;
import database.DbConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Income;
import model.Monthfat;
import modelDAO.IncomeDAO;
import modelDAO.MonthDAO;

/**
 *
 * @author valterFranco<unicuritiba/ads>
 */
public class IncomeController implements Initializable {
    
    public boolean chartisloaded = false;
    private ObservableList<PieChart.Data> data;
    private ObservableList<Monthfat> listaMon;
    
    private ObservableList<Income> listaInc;
    @FXML
    private LineChart<Integer, Double> lineChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private NumberAxis xAxis;
    
    @FXML
    private TableView<Income> tblViewInc;
    
    @FXML
    private ComboBox<Monthfat> monthCombo;
    
    @FXML
    private TableColumn<Income, String> clmnincMonth;
    @FXML
    private TableColumn<Income, String> clmnincAmount;
    @FXML
    private TableColumn<Income, String> clmnincAmountGoal;
    @FXML
    private TableColumn<Income, String> clmnincSaleQtt;
    @FXML
    private TableColumn<Income, String> clmnincSaleQttGoal;
    @FXML
    private Button delBtn;
    @FXML
    private TextField txtInc;
    @FXML
    private Button newBtn;
    @FXML
    private TextField txtIncGoal;
    
    @FXML
    private TextField txtSell;
    
    @FXML
    private TextField txtSellGoal;
    
    @FXML
    private Button btnRecordEx;
    
    @FXML
    private PieChart myPieChart;
    
    @FXML
    private TableView<?> tableHistory;
    @FXML
    private Button btnViewChart;
    @FXML
    private Button upBtn;
    
    ObservableList<XYChart.Series<Integer, Double>> chartData = FXCollections.observableArrayList();
    
    Series<Integer, Double> series = new Series<>();
    Series<Integer, Double> series2 = new Series<>();
    
    @FXML
    void btnSaveIncOnClicked(ActionEvent event) {
        Income inc = new Income();
        inc.setMonthfat(monthCombo.getSelectionModel().getSelectedItem());
        inc.setIncAmount(Double.valueOf(txtInc.getText()));
        inc.setIncAmountGoal(Double.valueOf(txtIncGoal.getText()));
        inc.setIncSaleQtt(Integer.valueOf(txtSellGoal.getText()));
        inc.setIncSaleQttGoal(Integer.valueOf(txtSellGoal.getText()));
        
        ControleDAO.getBanco().getIncomeDAO().SaveIncInput(DbConnection.instancia().getConnection(), inc);
        buildPieChart();
        //Line Graph
        HistoryTableView();
    }
    
    @FXML
    void viewChart(ActionEvent event) {
        buildPieChart();
        lineChart();
        
    }
    
    @FXML
    void upBtnOnClicked(ActionEvent event) {
        
        Income inc = new Income();
        inc.setMonthfat(monthCombo.getSelectionModel().getSelectedItem());
        inc.setIncAmount(Double.valueOf(txtInc.getText()));
        inc.setIncAmountGoal(Double.valueOf(txtIncGoal.getText()));
        inc.setIncSaleQtt(Integer.valueOf(txtSellGoal.getText()));
        inc.setIncSaleQttGoal(Integer.valueOf(txtSellGoal.getText()));
        
        int resultado = tblViewInc.getSelectionModel().getSelectedItem().getIncId();
        database.ControleDAO.getBanco().getIncomeDAO().UpdateInc(database.DbConnection.instancia().getConnection(), inc, resultado);
        
        listaInc.set(tblViewInc.getSelectionModel().getSelectedIndex(), inc);
        CleanFields();
        Alert msg = new Alert(AlertType.INFORMATION);
        msg.setTitle("Registro atualizado");
        msg.setContentText("O registro foi atualizado com sucesso");
        msg.setHeaderText("Resultado:");
        msg.show();
    }
    
    @FXML
    void delBtnOnClicked(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sistema Brasduto");
        alert.setHeaderText("Você deseja excluir linha selecionada?");
        Optional<ButtonType> result = alert.showAndWait();
        
        if (result.get() == ButtonType.OK) {
            int resultado = tblViewInc.getSelectionModel().getSelectedItem().getIncId();
            listaInc.remove(tblViewInc.getSelectionModel().getSelectedIndex());
            if (database.ControleDAO.getBanco().getIncomeDAO().DeleteInc(resultado) != 0) {
                Alert msg = new Alert(Alert.AlertType.INFORMATION);
                msg.setTitle("Registro eliminado");
                msg.setContentText("O registro foi excluido com sucesso!");
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
    void newbtnOnCliked(ActionEvent event) {
        CleanFields();
        
    }
    
    public void reloadLineChart() {
        try {
            lineChart.setData(null);
            String getData = "SELECT A.inc_mes,B.mes_nome,A.inc_fat,A.inc_fatplan FROM income A INNER JOIN meses B ON (A.inc_mes = B.mes_cod)";
//            ObservableList<XYChart.Series<Integer, Double>> chartData = FXCollections.observableArrayList();

            Statement stm = database.DbConnection.instancia().getConnection().createStatement();
            ResultSet resultado = stm.executeQuery(getData);
            
            while (resultado.next()) {
                int mes = resultado.getInt(1);
                String mesNome = resultado.getString(2);
                Double fat = resultado.getDouble(3);
                Double fatplan = resultado.getDouble(4);
                series.getData().add(new XYChart.Data<>(mes, fat));
                series2.getData().add(new XYChart.Data<>(mes, fatplan));
            }
            chartData.add(series);
            chartData.add(series2);
            lineChart.getData().addAll(chartData);
        } catch (SQLException ex) {
            Logger.getLogger(IncomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void lineChart() {
        try {
            
            xAxis.setLabel("Meses");
            yAxis.setLabel("Faturamento");
            lineChart.setTitle("Faturamento Mensal");
            xAxis.setAutoRanging(false);
            xAxis.setLowerBound(1);
            xAxis.setUpperBound(12);
            xAxis.setTickUnit(1);

//            ObservableList<XYChart.Series<Integer, Double>> chartData = FXCollections.observableArrayList();
//            Series<Integer, Double> series = new Series<>();
//            Series<Integer, Double> series2 = new Series<>();
            series.setName("Faturamento Mensal");
            series2.setName("Faturamento Planejado");
            
            String getData = "SELECT A.inc_mes,B.mes_nome,A.inc_fat,A.inc_fatplan FROM income A INNER JOIN meses B ON (A.inc_mes = B.mes_cod)";
            
            Statement stm = database.DbConnection.instancia().getConnection().createStatement();
            ResultSet resultado = stm.executeQuery(getData);
            
            while (resultado.next()) {
                int mes = resultado.getInt(1);
                String mesNome = resultado.getString(2);
                Double fat = resultado.getDouble(3);
                Double fatplan = resultado.getDouble(4);
                series.getData().add(new XYChart.Data<>(mes, fat));
                series2.getData().add(new XYChart.Data<>(mes, fatplan));
            }
            
            chartData.add(series);
            chartData.add(series2);
            lineChart.getData().addAll(chartData);
            
        } catch (SQLException ex) {
            Logger.getLogger(IncomeController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void HistoryTableView() {
        DbConnection.instancia();
        listaInc = FXCollections.observableArrayList();
        IncomeDAO.FillIncInfo(DbConnection.instancia().getConnection(), listaInc);
        tblViewInc.setItems(listaInc);
        
        clmnincMonth.setCellValueFactory(new PropertyValueFactory<>("monthfat"));
        clmnincAmount.setCellValueFactory(new PropertyValueFactory<>("incAmount"));
        clmnincAmountGoal.setCellValueFactory(new PropertyValueFactory<>("incAmountGoal"));
        clmnincSaleQtt.setCellValueFactory(new PropertyValueFactory<>("incSaleQtt"));
        clmnincSaleQttGoal.setCellValueFactory(new PropertyValueFactory<>("incSaleQttGoal"));
        
    }
    
    private void buildPieChart() {
        try {
            DbConnection.instancia();
            data = FXCollections.observableArrayList();
            String getData = "SELECT A.inc_mes,B.mes_nome,A.inc_fat FROM income A INNER JOIN meses B ON (A.inc_mes = B.mes_cod)";
            ResultSet rs = DbConnection.instancia().getConnection().createStatement().executeQuery(getData);
            while (rs.next()) {
                String mesPie = String.valueOf(rs.getInt(1));
                String mesName = rs.getString(2);
                data.add(new PieChart.Data(mesName, rs.getDouble(3)));
            }
            myPieChart.setTitle("Faturamento por mes");
            myPieChart.setData(data);
            myPieChart.setLegendSide(Side.LEFT);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DbConnection.instancia();
        
        listaMon = FXCollections.observableArrayList();
        MonthDAO.FillMonInfo(DbConnection.instancia().getConnection(), listaMon);
        monthCombo.setItems(listaMon);
        
        buildPieChart();
        //Line Graph
        HistoryTableView();
        lineChart();
        ManEvents();
        
    }
    
    private void ManEvents() {
        if (tblViewInc != null) {
            tblViewInc.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Income> arg0, Income valorAnterior, Income valorSelecionado) -> {
                if (valorSelecionado != null) {
                    
                    monthCombo.setValue(valorSelecionado.getMonthfat());
                    txtInc.setText(String.valueOf(valorSelecionado.getIncAmount()));
                    txtIncGoal.setText(String.valueOf(valorSelecionado.getIncAmountGoal()));
                    txtSell.setText(String.valueOf(valorSelecionado.getIncSaleQtt()));
                    txtSellGoal.setText(String.valueOf(valorSelecionado.getIncSaleQttGoal()));
                    
                }
            });
        }
    }
    
    public void CleanFields() {
        txtInc.setText(null);
        txtIncGoal.setText(null);
        txtSell.setText(null);
        txtSellGoal.setText(null);
        monthCombo.setValue(null);
        tblViewInc.getSelectionModel().clearSelection();
        
    }
    
}
