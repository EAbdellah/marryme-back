package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@NoArgsConstructor @Setter @Getter @ToString
public class User  {

    private Long userID;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    private Role role;//ROLE_USER{ read, edit }, ROLE_ADMIN {delete}
    private boolean isActive;
    private boolean isNotLocked;
    private String[] authorities;
    private List<Reservation> reservations;
    private String profileImageUrl;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;



}
