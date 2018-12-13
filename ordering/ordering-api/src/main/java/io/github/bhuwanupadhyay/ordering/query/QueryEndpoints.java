package io.github.bhuwanupadhyay.ordering.query;


import io.github.bhuwanupadhyay.ordering.EndpointResponse;
import io.github.bhuwanupadhyay.ordering.query.gen.tables.OmsOrder;
import io.github.bhuwanupadhyay.ordering.query.gen.tables.records.OmsOrderRecord;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(QueryEndpoints.ORDERS)
@RequiredArgsConstructor
public class QueryEndpoints {

    public static final String ORDERS = "/orders";
    private final DSLContext dsl;

    @GetMapping
    public EndpointResponse<List<OrderView>> listOrders() {
        dsl.select(OmsOrderRecord.class)
        return new EndpointResponse<>(Collections.emptyList());
    }


}
