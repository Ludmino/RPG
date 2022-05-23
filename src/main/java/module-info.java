module isep.godefroyl.rpg {
    requires javafx.controls;
    requires javafx.fxml;


    opens isep.godefroyl.rpg to javafx.fxml;
    exports isep.godefroyl.rpg;
}