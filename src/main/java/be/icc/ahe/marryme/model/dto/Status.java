package be.icc.ahe.marryme.model.dto;

import be.icc.ahe.marryme.dataaccess.entity.enumeration.MusiqueType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Status {

    waiting,
    refused,
    accespted,
    payed;

    private static final List<Status> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Status statusType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
