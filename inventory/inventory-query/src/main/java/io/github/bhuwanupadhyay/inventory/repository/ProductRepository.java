package io.github.bhuwanupadhyay.inventory.repository;

import io.github.bhuwanupadhyay.inventory.domain.Product;
import io.swagger.annotations.Api;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Api(tags = "Product")
@RepositoryRestResource(collectionResourceRel = "products", path = "/inventory/products")
public interface ProductRepository extends ReadOnlyPagingAndSortingRepository<Product, String> {

}
