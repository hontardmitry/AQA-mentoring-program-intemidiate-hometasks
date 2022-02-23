package com.epam.dhontar.aqamp.entity;

public class Author {
    private int id;
    private int idBook;
    private String firstName;
    private String lastName;

    private Author(AuthorBuilder builder) {
        this.id = builder.id;
        this.idBook = builder.idBook;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public Author() {
    }

    public int getId() {
        return id;
    }

    public static class AuthorBuilder {
        private int id;
        private int idBook;
        private String firstName;
        private String lastName;

        public AuthorBuilder(int id, int idBook) {
            this.id = id;
            this.idBook = idBook;
        }

        public AuthorBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AuthorBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Author build() {
            return new Author(this);
        }
    }

    public int getIdBook() {
        return idBook;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
