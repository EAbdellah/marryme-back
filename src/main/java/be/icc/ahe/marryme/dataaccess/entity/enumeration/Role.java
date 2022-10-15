package be.icc.ahe.marryme.dataaccess.entity.enumeration;

//import org.springframework.security.core.GrantedAuthority;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import static be.icc.ahe.marryme.constant.Authority.*;


public enum Role  {

    ROLE_USER(USER_AUTHORITIES),
    ROLE_PRESTATAIRE(MANAGER_PRESTATAIRE),
    ROLE_PRESTATAIRE_ADMIN(MANAGER_PRESTATAIRE_ADMIN),
    ROLE_ADMIN(ADMIN_AUTHORITIES);


    private String[] authorities;

    Role(String... authorities) {
        this.authorities = authorities;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    private static final List<Role> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));

    private static final int SIZE = VALUES.size();

    private static final Random RANDOM = new Random();

    public static Role RandomRole()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }


}
