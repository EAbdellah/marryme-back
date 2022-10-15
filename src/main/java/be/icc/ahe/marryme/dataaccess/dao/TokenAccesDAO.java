package be.icc.ahe.marryme.dataaccess.dao;

import be.icc.ahe.marryme.dataaccess.entity.TraiteurEntity;
import be.icc.ahe.marryme.dataaccess.entity.VerificationTokenEntity;
import be.icc.ahe.marryme.dataaccess.repository.TraiteurRepo;
import be.icc.ahe.marryme.dataaccess.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenAccesDAO {

    private final VerificationTokenRepository tokenRepository;

    @Autowired
    public TokenAccesDAO(VerificationTokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    public VerificationTokenEntity save(VerificationTokenEntity tokenEntity){
        return tokenRepository.save(tokenEntity);
    }

    public VerificationTokenEntity findByToken(String token){
        return tokenRepository.findByToken(token);
    }
}
