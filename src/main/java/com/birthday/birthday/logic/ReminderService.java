package com.birthday.birthday.logic;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReminderService {
    private final ReminderRepository reminderRepository;

    public void createReminder(BirthdayModel birthdayModel) {
        System.out.println("add");
        this.reminderRepository.save(ModeltoEntity.convertModeltoEntity(birthdayModel));
    }

    public List<BirthdayEntity> viewAllReminder() {
        System.out.println("viewall");
        return this.reminderRepository.findAll();
    }

    @Cacheable({"viewBirthday"})
    public BirthdayEntity viewReminder(String name) {
        System.out.println("view");
        return this.reminderRepository.findByUserName(name);
    }

}