package com.paf.socialmedia.repository.authentication;


import com.paf.socialmedia.entity.authentication.ERole;
import com.paf.socialmedia.entity.authentication.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
