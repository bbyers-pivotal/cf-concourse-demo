package com.example

import org.springframework.data.repository.CrudRepository

public interface AttendeeRepository extends CrudRepository<Attendee, Long> {
    Attendee findById(String id)
}
