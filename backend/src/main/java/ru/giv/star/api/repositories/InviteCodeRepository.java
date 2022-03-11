package ru.giv.star.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.giv.star.api.models.InviteCode;

import java.util.UUID;

public interface InviteCodeRepository extends JpaRepository<InviteCode, UUID> {}
