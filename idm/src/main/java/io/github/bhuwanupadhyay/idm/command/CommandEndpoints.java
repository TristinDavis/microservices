package io.github.bhuwanupadhyay.idm.command;

import io.github.bhuwanupadhyay.idm.contract.EndpointResponse;
import io.github.bhuwanupadhyay.idm.contract.ICommandEndpoints;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.github.bhuwanupadhyay.idm.contract.IEndpoints.BASE_URI;

@RestController
@RequestMapping(BASE_URI)
public class CommandEndpoints implements ICommandEndpoints {

    @Override
    @PostMapping("/register")
    public EndpointResponse<Void> registerUser(Object registerRequest) {
        return new EndpointResponse<>(null);
    }

    @Override
    @PostMapping("/login")
    public EndpointResponse<Void> loginUser(Object loginRequest) {
        return new EndpointResponse<>(null);
    }

    @Override
    @PostMapping("/sign-in-google")
    public EndpointResponse<Void> signInByGoogle(Object googleSignInRequest) {
        return new EndpointResponse<>(null);
    }

}
