package be.icc.ahe.marryme.security;

import be.icc.ahe.marryme.model.Person;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Arrays.stream;

public class UserPrincipal implements UserDetails {

    private Person person;

    public UserPrincipal(Person person) {
        this.person = person;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<String> roles = new ArrayList<>();
        if(Objects.nonNull(person.getUser().getRole()))
            roles.add(person.getUser().getRole().name());
        return roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return person.getUser().getPassword();
    }

    @Override
    public String getUsername() {
        return person.getUser().getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return person.getUser().isNotLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return person.getUser().isActive();
    }
}
