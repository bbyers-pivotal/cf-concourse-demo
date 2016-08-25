package com.example

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class AttendeeController {

    private static Logger logger = LoggerFactory.getLogger(AttendeeController)

    AttendeeRepository attendeeRepository

    AttendeeController(AttendeeRepository attendeeRepository) {
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

    @RequestMapping(value = 'attendees/{id}', method = RequestMethod.DELETE)
    public deleteAttendee(@PathVariable id) {
        attendeeRepository.delete(id)
        new ResponseEntity(HttpStatus.OK)
    }

    @RequestMapping(value = 'attendees/{id}', method = RequestMethod.PUT)
    public updateAttendee(@PathVariable String id, @RequestBody AttendeeRequest body) {
        Attendee attendee = attendeeRepository.findById(id)
        attendee.name = body.name
        attendeeRepository.save(attendee)
        new ResponseEntity(HttpStatus.OK)
    }
}
