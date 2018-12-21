package io.github.bhuwanupadhyay.idm.contract;

public interface ICommandEndpoints extends IEndpoints {

    EndpointResponse<Void> registerUser(Object registerRequest);

    EndpointResponse<Void> loginUser(Object loginRequest);

    EndpointResponse<Void> signInByGoogle(Object googleSignInRequest);


}
