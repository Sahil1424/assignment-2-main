package com.example.catinfo;

import javafx.util.StringConverter;

public class CatBreedStringConverter extends StringConverter<CatBreed> {
    @Override
    public String toString(CatBreed breed) {
        return breed != null ? breed.getName() : "";
    }

    @Override
    public CatBreed fromString(String string) {
        return null;
    }
}
