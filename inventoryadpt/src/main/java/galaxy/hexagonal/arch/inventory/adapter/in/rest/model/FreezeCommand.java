package galaxy.hexagonal.arch.inventory.adapter.in.rest.model;

public record FreezeCommand(String sku, int freezeDurationInMins) {
}
