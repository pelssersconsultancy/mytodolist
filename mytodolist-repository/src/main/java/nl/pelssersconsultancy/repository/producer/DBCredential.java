package nl.pelssersconsultancy.repository.producer;


public class DBCredential {

    protected String username;
    protected String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {

        private DBCredential dbCredential;

        public Builder() {
            this.dbCredential = new DBCredential();
        }

        public Builder(DBCredential dbCredential) {
            this.dbCredential.password = dbCredential.password;
            this.dbCredential.username = dbCredential.username;
        }

        public Builder withUsername(String username) {
            this.dbCredential.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.dbCredential.password = password;
            return this;
        }

        public DBCredential build() {
            return this.dbCredential;
        }
    }
}
