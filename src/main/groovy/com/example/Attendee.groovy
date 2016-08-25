package com.example

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Attendee {

    @Id
    @GeneratedValue
    String id

    String name
}
