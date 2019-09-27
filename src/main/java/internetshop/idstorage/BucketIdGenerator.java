package internetshop.idstorage;

public class BucketIdGenerator {
    private static long idValue = 0;

    public static long generateId() {
        return idValue++;
    }
}
