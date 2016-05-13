package nl.pelssersconsultancy.repository.producer;


import nl.pelssersconsultancy.common.IBuilder;

public class DBCredential {

    protected String username;
    protected String password;

    public DBCredential(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder implements IBuilder {

        protected String username;
        protected String password;

        public Builder withUsername(String username) {
            this.username = username;
            return self();
        }

        public Builder withPassword(String password) {
            this.password = password;
            return self();
        }

        public DBCredential build() {
            return new DBCredential(this);
        }

        public Builder self() {
            return this;
        }
    }
}
