package internetshop.idstorage;

public class UserIdGenerator {
    private static long idValue = 0;

    public static long generateId() {
        return idValue++;
    }
}
