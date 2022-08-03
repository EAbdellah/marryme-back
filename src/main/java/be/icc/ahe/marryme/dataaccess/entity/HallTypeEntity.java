package be.icc.ahe.marryme.dataaccess.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public enum HallTypeEntity  {

    BATEAU,
    SALLE,
    RESTAURANT,
    PLEIN_AIR,
    ;

    private static final List<HallTypeEntity> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static HallTypeEntity RandomHallType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}
