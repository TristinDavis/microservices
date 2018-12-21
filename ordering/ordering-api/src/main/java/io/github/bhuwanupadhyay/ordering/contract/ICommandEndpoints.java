package io.github.bhuwanupadhyay.ordering.contract;

import io.github.bhuwanupadhyay.ordering.contract.gen.OrderRequest;
import io.github.bhuwanupadhyay.ordering.contract.gen.OrderView;

public interface ICommandEndpoints {

    EndpointResponse<OrderView> placeOrder(OrderRequest orderRequest);

}
