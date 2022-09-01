module br.com.br {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.br to javafx.fxml;
    exports br.com.br;
}
