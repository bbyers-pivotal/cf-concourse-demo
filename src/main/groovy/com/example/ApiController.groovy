package com.example

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class ApiController {

    private static Logger logger = LoggerFactory.getLogger(ApiController)

    AttendeeRepository attendeeRepository

    ApiController(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository
    }

    @RequestMapping(value = 'attendees', method = RequestMethod.POST)
    public addAttendee(@RequestBody AttendeeRequest body) {
        Attendee attendee = new Attendee(name: body.name)
        attendeeRepository.save(attendee)
        new ResponseEntity(HttpStatus.CREATED)
    }

    @RequestMapping(value = 'attendees', method = RequestMethod.GET)
    public listAttendees() {
        attendeeRepository.findAll()
    }
}
