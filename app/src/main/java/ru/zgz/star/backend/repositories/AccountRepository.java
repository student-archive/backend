package ru.zgz.star.backend.repositories;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.zgz.star.backend.models.Account;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(path = "accounts")
public interface AccountRepository extends PagingAndSortingRepository<Account, UUID> {
  List<Account> findByUsername(@Param("name") String username);
}
