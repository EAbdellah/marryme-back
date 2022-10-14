package be.icc.ahe.marryme.model.mapper;

import be.icc.ahe.marryme.dataaccess.entity.UserEntity;
import be.icc.ahe.marryme.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-03T17:16:26+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 11.0.8 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity modelToEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setMdp( user.getMdp() );
        userEntity.setRole( user.getRole() );
        userEntity.setActive( user.isActive() );
        userEntity.setNonLocked( user.isNonLocked() );

        return userEntity;
    }

    @Override
    public User entityToModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setMdp( userEntity.getMdp() );
        user.setRole( userEntity.getRole() );
        user.setActive( userEntity.isActive() );
        user.setNonLocked( userEntity.isNonLocked() );

        return user;
    }
}
