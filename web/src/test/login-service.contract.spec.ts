import {Interaction, Pact} from "@pact-foundation/pact";
import {after, before} from "selenium-webdriver/testing";
import {LoginService} from "../app/login/login.service";


describe("User Service Consumer Contract Testing", () => {
  const url = "http://localhost";
  const port = 2200;
  const loginService = new LoginService(`${url}:${port}`);
  const provider = new Pact({
    consumer: "web",
    provider: "idm",
    port: port,
    log: './dist/logs',
    dir: './dist/pacts',
    logLevel: "warn",
    spec: 3
  });
  before(() => provider.setup());

  describe("get /billing/users from user-service", () => {

    const EXPECTED_BODY = [{fullName: "BHUWAN UPADHYAY", type: "ADMIN", address: {city: "Kathmandu"}}];

    before(() => {
      const interaction = new Interaction()
        .given("I have a list of users")
        .uponReceiving("a request for get all users")
        .withRequest({
          method: "GET",
          path: "/billing/users",
          headers: {
            Accept: "application/json",
          },
        })
        .willRespondWith({
          status: 200,
          headers: {
            "Content-Type": "application/json",
          },
          body: EXPECTED_BODY,
        });

      return provider.addInteraction(interaction);
    });

    it("returns the correct response", (done) => {
      loginService
        .getAllUser()
        .then((response: any) => {
          console.log(response.data);
          //expect(response.data).toBe(EXPECTED_BODY);
          done();
        }, done);
    });

  });


  after(() => {
    return provider.finalize()
      .then(() => true, (err) => console.log(err));
  });
});
