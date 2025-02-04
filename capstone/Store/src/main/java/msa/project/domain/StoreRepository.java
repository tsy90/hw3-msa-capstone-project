package msa.project.domain;

import msa.project.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "stores", path = "stores")
public interface StoreRepository
    extends PagingAndSortingRepository<Store, String> {}
