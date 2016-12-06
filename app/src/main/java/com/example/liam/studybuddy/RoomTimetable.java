package com.example.liam.studybuddy;

/**
 * Created by Evan on 06/12/2016.
 */

public class RoomTimetable {
    public int id;
    public String day;
    public String course;
    public String room;
    public String time;

    public RoomTimetable() {

    }

    public RoomTimetable(int id, String day, String course, String room, String time) {
        this.id = id;
        this.day = day;
        this.course = course;
        this.room = room;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getDay() {
        return day;
    }

    public String getCourse() {
        return course;
    }

    public String getRoom() {
        return room;
    }

    public String getTime() {
        return time;
    }
}
