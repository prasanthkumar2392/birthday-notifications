package com.birthday.birthday.logic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping({"/birthday"})
public class Controller {
    private final ReminderService reminderService;

    @PostMapping({"/create"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<BirthdayModel> addBirthday(@RequestBody BirthdayModel birthdayModel) {
        this.reminderService.createReminder(birthdayModel);
        birthdayModel.add(WebMvcLinkBuilder.linkTo(((Controller) WebMvcLinkBuilder.methodOn(Controller.class, new Object[0])).viewBirthday(birthdayModel.getUserName())).withSelfRel());
        birthdayModel.add(WebMvcLinkBuilder.linkTo(((Controller) WebMvcLinkBuilder.methodOn(Controller.class, new Object[0])).viewAllBirthday()).withRel("all_birthdays"));
        return ResponseEntity.ok(birthdayModel);
    }

    @GetMapping({"/viewall"})
    public List<BirthdayEntity> viewAllBirthday() {
        return this.reminderService.viewAllReminder();
    }

    @GetMapping({"/view"})
    public BirthdayEntity viewBirthday(@RequestParam String name) {
        return this.reminderService.viewReminder(name);
    }



}