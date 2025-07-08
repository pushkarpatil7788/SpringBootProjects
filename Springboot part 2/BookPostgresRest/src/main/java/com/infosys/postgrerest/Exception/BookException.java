package com.infosys.postgrerest.Exception;

public class BookException extends RuntimeException {

  public BookException() {
    super("Book not found.");
  }

  public BookException(Long id) {
    super(id + " → Can't find book with this ID");
  }
}
