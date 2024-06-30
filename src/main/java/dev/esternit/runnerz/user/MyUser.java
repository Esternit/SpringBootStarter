package dev.esternit.runnerz.user;

import dev.esternit.runnerz.run.Location;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;
import java.util.UUID;


public class MyUser {
        @Id
        UUID id;
        String username;
        String password;
        String role;
        @Version
        Integer version;


//        public MyUser(UUID id, String username, String password, String role) {
//                this.id = id;
//                this.username = username;
//                this.password = password;
//                this.role = role;
//        }

        public UUID getId() {
                return id;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        public void setId(UUID id) {
                this.id = id;
        }


        public String getUsername() {
                return username;
        }

        public String getPassword() {
                return password;
        }

        public String getRole() {
                return role;
        }

}
