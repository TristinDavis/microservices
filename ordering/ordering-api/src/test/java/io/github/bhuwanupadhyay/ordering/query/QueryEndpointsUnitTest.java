package io.github.bhuwanupadhyay.ordering.query;

import io.github.bhuwanupadhyay.ordering.EndpointResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class QueryEndpointsUnitTest {

    private static final int ZERO = 0;
    private QueryEndpoints queryEndpoints;

    @BeforeEach
    void setUp() {
        queryEndpoints = new QueryEndpoints();
    }

    @Test
    void canReturnNullSafeListOrders() {
        EndpointResponse<List<OrderView>> response = queryEndpoints.listOrders();
        assertNotNull(response);
        assertThat(response.getBody()).isNotNull().hasSize(ZERO);
    }

    @Test
    void canReturnAutomaticallyGeneratedAt() {
        EndpointResponse<List<OrderView>> response = queryEndpoints.listOrders();
        assertNotNull(response.getGeneratedAt());
    }

}