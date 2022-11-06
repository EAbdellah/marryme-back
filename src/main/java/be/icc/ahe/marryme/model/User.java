package be.icc.ahe.marryme.model;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userID")
public class User  {

    private Long userID;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private String email;
    private Role role;//ROLE_USER{ read, edit }, ROLE_ADMIN {delete}
    private boolean isActive;
    private boolean isNotLocked;
    private String[] authorities;
//    @JsonManagedReference
    private List<Reservation> reservations;
    private String profileImageUrl;
    private Date lastLoginDate;
    private Date lastLoginDateDisplay;
    private Date joinDate;



}
