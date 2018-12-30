flydb:
	./gradlew clean flywaymigrate
jooq:
	./gradlew generateOrderingJooqSchemaSource
proto:
	./gradlew generateProto
clean:
	./gradlew clean
unit:
	$(MAKE) clean && \
	$(MAKE) jooq && \
	$(MAKE) proto && \
	./gradlew test
ui:
	cd web && \
	ng serve --open
gen-ui:
	ng new web --prefix oms && \
	cd web && \
	ng add @angular/material
infra:
	docker-compose rm && docker-compose up