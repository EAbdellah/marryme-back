package be.icc.ahe.marryme.dataaccess.entity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum MusiqueType {
    DJ,
    CLassique,
    Band;

    private static final List<MusiqueType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static MusiqueType musiqueType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
