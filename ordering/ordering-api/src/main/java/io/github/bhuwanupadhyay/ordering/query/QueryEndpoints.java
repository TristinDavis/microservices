package io.github.bhuwanupadhyay.ordering.query;


import io.github.bhuwanupadhyay.ordering.EndpointResponse;
import io.github.bhuwanupadhyay.ordering.query.gen.tables.records.OmsOrderRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.github.bhuwanupadhyay.ordering.query.gen.tables.OmsOrder.OMS_ORDER;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(QueryEndpoints.ORDERS)
@RequiredArgsConstructor
public class QueryEndpoints {

    public static final String ORDERS = "/orders";
    private final DSLContext dsl;

    @GetMapping
    public EndpointResponse<List<OrderView>> listOrders() {
        Result<OmsOrderRecord> records = dsl.selectFrom(OMS_ORDER).fetch();
        return new EndpointResponse<>(toViews(records));
    }

    private List<OrderView> toViews(Result<OmsOrderRecord> records) {
        return records.stream().map(OrderView::new).collect(toList());
    }

}
