package galaxy.hexagonal.arch.inventory.adapter.out.mongo.util;

import java.util.UUID;

public class IdGenerator {

    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}