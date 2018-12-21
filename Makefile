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
