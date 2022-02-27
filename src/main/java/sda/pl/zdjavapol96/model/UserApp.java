package sda.pl.zdjavapol96.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserApp implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;
    @NotNull
    @Column(unique = true, name = "username")
    private String username;
    @NotNull
    @Column(name = "password")
    private String password;
    @NotNull
    @Column(name = "firstname")
    private String firstName;
    @NotNull
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "locked")
    private boolean locked;
    @NotNull
    @Column(name = "role")
    private String roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        final String[] roleArr = roles.split(" ");
        for (String role : roleArr) {
            authorities.add(() -> role);
        }
        return authorities;
    }
    @Override
    public String getUsername(){
        return username;
    }
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    @Override
    public boolean isAccountNonLocked(){
        return !locked;
    }
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    @Override
    public boolean isEnabled(){
        return true;
    }
}



