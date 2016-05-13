package nl.pelssersconsultancy.model.mongodb;


import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class User {

    @NotBlank
    protected String firstName;
    public static final String _firstName = "firstName";

    @NotBlank
    protected String lastName;
    public static final String _lastName = "lastName";

    @NotNull
    protected Date birthDay;
    public static final String _birthDay = "birthDay";

    @NotBlank
    protected String email;
    public static final String _email = "email";


    public User(Builder builder) {
        this.birthDay = builder.birthDay;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class Builder {
        private String firstName;
        private String lastName;
        private Date birthDay;
        private String email;

        public Builder fromUser(User user) {
            this.birthDay = user.birthDay;
            this.email = user.email;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            return this;
        }

        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withBirthDay(Date birthDay) {
            this.birthDay = birthDay;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }


}
