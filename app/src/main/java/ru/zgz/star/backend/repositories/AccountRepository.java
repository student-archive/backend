package ru.zgz.star.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.zgz.star.backend.models.Account;

import java.util.UUID;

public interface AccountRepository extends CrudRepository<Account, UUID> {

}
