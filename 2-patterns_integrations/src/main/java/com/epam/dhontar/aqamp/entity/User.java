package com.epam.dhontar.aqamp.entity;

public class User {
    private int id;
    private String userName;
    private String password;

    private User(UserBuilder builder) {
        this.id = builder.id;
        this.userName = builder.userName;
        this.password = builder.password;
    }

    private User() {
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static class UserBuilder {

        private int id;
        private String userName;
        private String password;

        public UserBuilder(int id) {
            this.id = id;
        }

        public UserBuilder withName(String userName) {
            this.userName = userName;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
