package galaxy.hexagonal.arch.inventory.adapter.in.rest.model;

import galaxy.hexagonal.arch.domain.Period;

public record FreezeCommand(String sku, Period freezePeriod) {
}
