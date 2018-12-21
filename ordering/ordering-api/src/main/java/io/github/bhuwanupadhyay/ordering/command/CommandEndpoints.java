package io.github.bhuwanupadhyay.ordering.command;

import io.github.bhuwanupadhyay.ordering.CommandBus;
import io.github.bhuwanupadhyay.ordering.contract.EndpointResponse;
import io.github.bhuwanupadhyay.ordering.contract.ICommandEndpoints;
import io.github.bhuwanupadhyay.ordering.contract.IEndpoints;
import io.github.bhuwanupadhyay.ordering.contract.gen.OrderRequest;
import io.github.bhuwanupadhyay.ordering.contract.gen.OrderView;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(IEndpoints.BASE_URI)
public class CommandEndpoints implements ICommandEndpoints {

    private final CommandBus bus;

    @Override
    public EndpointResponse<OrderView> placeOrder(OrderRequest orderRequest) {
        bus.move(new OrderPlaceCommand());
        return new EndpointResponse<>(OrderView.newBuilder()
                .build());
    }

}
