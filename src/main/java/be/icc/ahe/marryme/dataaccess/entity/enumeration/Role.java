package be.icc.ahe.marryme.dataaccess.entity.enumeration;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Role {
    ADMIN,
    PRESTATAIRE,
    CLIENT;

    private static final List<Role> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Role RandomRole()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
