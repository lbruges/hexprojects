package galaxy.hexagonal.arch.inventory.adapter.out.mysql;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class Constants {
    public static final Pageable SINGLE_RESULT_PAGE = PageRequest.of(0, 1);
}
