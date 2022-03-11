package ru.giv.star.api.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.giv.star.api.models.InviteCode;

public interface InviteCodeRepository extends JpaRepository<InviteCode, UUID> {}
