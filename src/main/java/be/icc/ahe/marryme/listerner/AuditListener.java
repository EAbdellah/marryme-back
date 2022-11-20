package be.icc.ahe.marryme.listerner;

import be.icc.ahe.marryme.dataaccess.entity.SocieteEntity;

import javax.persistence.*;

public class AuditListener {


    @PostPersist
    private void beforeAnyOperation(Object object) {
        if (object.getClass()==SocieteEntity.class){
            SocieteEntity societeEntity=(SocieteEntity)object;
            System.out.println(societeEntity)   ;
        }
    }
}
