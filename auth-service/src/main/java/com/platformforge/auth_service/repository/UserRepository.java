package com.platformforge.auth_service.repository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import com.platformforge.auth.jooq.tables.records.UsersRecord;

import java.util.Optional;

import static com.platformforge.auth.jooq.Tables.USERS;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final DSLContext dsl;

    public boolean existsByEmail(String email) {
        return dsl.fetchExists(
                dsl.selectFrom(USERS)
                        .where(USERS.EMAIL.eq(email))
        );
    }

    public void createUser(String email, String password, String role){
        dsl.insertInto(USERS)
                .columns(USERS.EMAIL,USERS.PASSWORD,USERS.ROLE)
                .values(email,password, role)
                .execute();
    }

    public Optional<UsersRecord> findByEmail(String email) {
        return dsl.selectFrom(USERS)
                .where(USERS.EMAIL.eq(email))
                .fetchOptional();
    }
}
