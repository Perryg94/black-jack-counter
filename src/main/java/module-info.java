module it.fresca.blackjackcounter {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    // Apre il pacchetto per il riflesso di Spring e JavaFX
    opens it.fresca.blackjackcounter to javafx.fxml;

    // Esporta il pacchetto per l'uso esterno
    exports it.fresca.blackjackcounter;
}