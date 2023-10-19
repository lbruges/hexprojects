package galaxy.hexagonal.arch.inventory.adapter.in.rest.util;

public class Constants {
    public static class Routes {
        public static final String INVENTORY_PATH = "/product";
        public static final String INVENTORY_VEHICLE_PATH = "/vehicle";
        public static final String INVENTORY_MODEL_PATH = "/model";
        public static final String CATALOG_PATH = "/catalog";
        public static final String FREEZE_PATH = "/freeze";
        public static final String FREEZE_ID_PATH = "/{freezeCode}";
        public static final String RENTAL_PATH = "/rental";
    }

    public static class Errors {
        public static final String INVENTORY_EXCEPTION = "Inventory Exception";
        public static final String APPLICATION_EXCEPTION = "Application Exception";
    }
}
