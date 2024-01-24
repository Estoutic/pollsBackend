package com.estoutic.pollsbackend.services.exceptions.category;

public class CategoryDoesNotExistException extends  RuntimeException{

    public CategoryDoesNotExistException() {
        super("Category does not exist");
    }
}
