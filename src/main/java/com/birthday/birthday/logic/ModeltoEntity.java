package com.birthday.birthday.logic;

public class ModeltoEntity {
    public static BirthdayEntity convertModeltoEntity(BirthdayModel birthdayModel) {
        BirthdayEntity birthdayEntity = new BirthdayEntity();
        birthdayEntity.setBirthDayName(birthdayModel.getBirthDayName());
        birthdayEntity.setBirthDate(birthdayModel.getBirthDate());
        birthdayEntity.setUserName(birthdayModel.getUserName());
        return birthdayEntity;
    }
}
