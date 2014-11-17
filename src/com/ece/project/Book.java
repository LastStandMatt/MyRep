package com.ece.project;


///-------------------------------------------------------Book class--------------------------------------------------------///
///--------------This class will be used to contain the name of an book and an url linked to one of their link--------------///

public class Book {
	
	private String name;
    private String link;
 
    // Constructor.
    public Book(String name, String link) {
        this.name = name;
        this.link = link;
    }
    
    // To get the name of the book.
    public String getName() {
        return name;
    }
    
    // To set the name of the book. It will not be used further.
    public void setName(String name) {
        this.name = name;
    }
    
    // To get the url of the link of the book.
    public String getLink() {
        return link;
    }
    
    // To set the url of the link of the book. It will not be used further.
    public void setLink(String link) {
        this.link = link;
    }
}
