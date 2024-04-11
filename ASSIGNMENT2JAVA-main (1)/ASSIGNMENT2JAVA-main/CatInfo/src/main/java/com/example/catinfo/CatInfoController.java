package com.example.catinfo;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class CatInfoController {
    @FXML
    private ComboBox<CatBreed> catBreedsComboBox;

    @FXML
    private ImageView imageView;
    @FXML
    private Label nameLabel;
    @FXML
    private TextArea descriptionTextArea;

    private CatAPIService catAPIService;

    public CatInfoController() {
        catAPIService = new CatAPIService();
    }

    @FXML
    private void initialize() {
        // Fetch cat breeds and populate the ComboBox
        List<CatBreed> catBreeds = catAPIService.getBreeds();
        catBreedsComboBox.getItems().addAll(catBreeds);
        catBreedsComboBox.setConverter(new CatBreedStringConverter());

        // Set the default cat image when the application is loaded
        Image defaultCatImage = new Image("file:C:/Users/TSL/Desktop/CatInfo/target/classes/catimage.jpg");
        imageView.setImage(defaultCatImage);
    }

    @FXML
    private void fetchCatBreedInfo() {
        CatBreed selectedBreed = catBreedsComboBox.getValue();
        if (selectedBreed != null) {
            nameLabel.setText(selectedBreed.getName());
            descriptionTextArea.setText(selectedBreed.getDescription());

        }
    }
}
