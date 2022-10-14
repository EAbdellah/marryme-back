package be.icc.ahe.marryme.model.dto;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.Role;
import be.icc.ahe.marryme.model.Address;
import be.icc.ahe.marryme.model.Reservation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UserRegistrationFormDTO {

    public String firstName;
    public String lastName;
    public String country;
    public String city;
    public String postalCode;
    public String street;
    public String houseNumber;
    public String box;
    public String phone;
    public String email;
    public String password;
    public String contactPreference;
//    public PersonalInfo personalInfo;
//    public String contactPreference;
//    public Email email;
//    public LoginInfo loginInfo;


    public UserRegistrationFormDTO(String firstName, String lastName, String country, String city, String postalCode, String street, String houseNumber, String box, String phone, String email, String password, String contactPreference) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
        this.houseNumber = houseNumber;
        this.box = box;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.contactPreference = contactPreference;
    }

    @Override
    public String toString() {
        return "UserRegistrationFormDTO{" +
                " contactPreference='" + contactPreference + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", box='" + box + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
//
//    class Email{
//        public String email;
//        public String confirm;
//
//        @Override
//        public String toString() {
//            return "Email{" +
//                    "email='" + email + '\'' +
//                    ", confirm='" + confirm + '\'' +
//                    '}';
//        }
//    }
//
//     class LoginInfo{
//        public String password;
//        public String confirmPassword;
//
//         @Override
//         public String toString() {
//             return "LoginInfo{" +
//                     "password='" + password + '\'' +
//                     ", confirmPassword='" + confirmPassword + '\'' +
//                     '}';
//         }
//     }
//
//     class PersonalInfo{
//        public String firstName;
//        public String lastName;
//        public String country;
//        public String city;
//        public String postalCode;
//        public String street;
//        public String houseNumber;
//        public String box;
//        public String phone;
//
//         @Override
//         public String toString() {
//             return "PersonalInfo{" +
//                     "firstName='" + firstName + '\'' +
//                     ", lastName='" + lastName + '\'' +
//                     ", country='" + country + '\'' +
//                     ", city='" + city + '\'' +
//                     ", postalCode='" + postalCode + '\'' +
//                     ", street='" + street + '\'' +
//                     ", houseNumber='" + houseNumber + '\'' +
//                     ", box='" + box + '\'' +
//                     ", phone='" + phone + '\'' +
//                     '}';
//         }
//     }
//
