package com.sanjay.beans;

import org.springframework.stereotype.Component;

@Component
public class Book {
    private String bookName;
    private String domain;

    Book(){
        this.setBookName("Alice in the Wonderland.");
        this.setDomain("Fiction");
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

}
