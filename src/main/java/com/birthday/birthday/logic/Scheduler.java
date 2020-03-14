package com.birthday.birthday.logic;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Scheduler {
    private final ReminderService reminderService;
    @Value("${user.sim.account}")
    private String ACCOUNT_SID;
    @Value("${user.sim.token}")
    private String AUTH_TOKEN;

    @Value("${user.receiver.phone}")
    private String RECEIVER_PHONE;

    @Scheduled(cron = "*/10 * * * * *")
    public void scheduleTaskUsingCronExpression() {
        LocalDate date = LocalDate.now();
        String todayDate = date.format(DateTimeFormatter.ofPattern("dd-MM"));
        Twilio.init(this.ACCOUNT_SID, this.AUTH_TOKEN);
        List<String> list = (List)this.reminderService.viewAllReminder().stream().filter((s) -> {
            return s.getBirthDate().equalsIgnoreCase(todayDate) && s.getUserName().equalsIgnoreCase("Prasanth");
        }).map(BirthdayEntity::getBirthDayName).collect(Collectors.toList());
        list.forEach((s) -> {
            try{
                Message message = (Message)Message.creator(new PhoneNumber(RECEIVER_PHONE), new PhoneNumber("+15304196047"), s + " birthday today !! Wish him").create();
            }catch (Exception e){
                throw new PhoneNotConfiguredException(e);
            }
        });
    }
}