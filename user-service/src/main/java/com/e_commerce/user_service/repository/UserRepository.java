package com.e_commerce.user_service.repository;

import com.e_commerce.user_service.entity.User;
import com.microservice.shared_library.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends BaseRepository<User, UUID> {
    @Override
    @Query(
            "select x from #{#entityName} x where x.deleted = false and (cast(x.id as string) like :search or x.email like :search)"
    )
    Page<User> findContaining(Pageable pageable, String search);

    Optional<User> findByEmail(String email);
}