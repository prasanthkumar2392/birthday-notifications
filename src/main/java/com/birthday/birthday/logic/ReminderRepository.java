package com.birthday.birthday.logic;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReminderRepository extends JpaRepository<BirthdayEntity, Long> {
    BirthdayEntity findByUserName(String var1);
}
