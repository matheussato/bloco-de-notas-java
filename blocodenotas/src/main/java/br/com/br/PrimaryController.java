package br.com.br;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;

public class PrimaryController {
    @FXML private TextArea textArea;


    public void salvar(){

        String texto = textArea.getText();

        FileChooser dialagoSalvar = new FileChooser();
        File file = dialagoSalvar.showSaveDialog(null);


       // String file = "C:\\Users\\logonrmlocal\\Desktop\\New folder\\texto.txt";

        try {
            PrintWriter out = new PrintWriter(file);
            out.write(texto);
            out.close();
        } catch (FileNotFoundException e) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setContentText("Arquivo não encontrado");
            alerta.show();
        }

        System.out.println("Salvar o arquivo-> " + texto); 
    }

    public void abrir(){
        
        FileChooser dialogoAbrir = new FileChooser();
        File file = dialogoAbrir.showOpenDialog(null);

        try {
            Path path = file.toPath();
            // Path path = Path.of("C:\\Users\\logonrmlocal\\Desktop\\New folder\\texto.txt");
            String texto;
            texto = Files.readString(path);
            textArea.setText(texto);
        } catch (IOException e) {
            Alert alerta = new Alert(AlertType.ERROR);
            alerta.setContentText("Erro ao abrir arquivo");
            alerta.show();
        }
    }
}
