package senac.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import senac.models.Carro;

public class CarroController {

    @FXML
    private TextField txtMarca;

    @FXML
    private TextField txtModelo;

    @FXML
    private TextField txtAno;

    @FXML
    private TextField txtCor;

    @FXML
    private TextField txtPlaca;

    @FXML
    private TextField txtRenavan;

    @FXML
    private ListView<Carro> listCarros;

    private ObservableList<Carro> carros = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        listCarros.setItems(carros);
    }

    @FXML
    private void cadastrarCarro() {
        String marca = txtMarca.getText().trim();
        String modelo = txtModelo.getText().trim();
        String anoTexto = txtAno.getText().trim();
        String cor = txtCor.getText().trim();
        String placa = txtPlaca.getText().trim();
        String renavan = txtRenavan.getText().trim();

        if (marca.isEmpty() || modelo.isEmpty() || anoTexto.isEmpty() ||
            cor.isEmpty() || placa.isEmpty() || renavan.isEmpty()) {
            mostrarAlerta("Erro", "Preencha todos os campos!");
            return;
        }

        try {
            int ano = Integer.parseInt(anoTexto);
            Carro carro = new Carro(marca, modelo, ano, cor, placa, renavan);
            carros.add(carro);
            limparCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Erro", "Ano inválido! Digite um número inteiro.");
        }
    }

    private void limparCampos() {
        txtMarca.clear();
        txtModelo.clear();
        txtAno.clear();
        txtCor.clear();
        txtPlaca.clear();
        txtRenavan.clear();
    }

    private void mostrarAlerta(String titulo, String mensagem) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
