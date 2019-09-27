package internetshop.idstorage;

public class RoleIdGenerator {
    private static long idValue = 0;

    public static long generateId() {
        return idValue++;
    }
}
