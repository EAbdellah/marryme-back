package be.icc.ahe.marryme.constant;

public class Authority {
    public static final String[] USER_AUTHORITIES = { "user:read" };
    public static final String[] MANAGER_PRESTATAIRE = { "user:read", "user:update" };
    public static final String[] MANAGER_PRESTATAIRE_ADMIN = { "user:read", "user:create", "user:update" };
    public static final String[] ADMIN_AUTHORITIES = { "user:read", "user:create", "user:update", "user:delete" };
}
