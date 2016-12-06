package com.example.liam.studybuddy;

/**
 * Created by Evan on 06/12/2016.
 */

public class ExamTimetableInfo {
    public int id;
    public String time;
    public int year;
    public String subject;
    public String date;
    public String course;

    public ExamTimetableInfo() {

    }

    public ExamTimetableInfo(int id, String time, int year, String subject, String date, String course){
        this.id = id;
        this.time = time;
        this.year = year;
        this.subject = subject;
        this.date = date;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    public int getYear() {
        return year;
    }

    public String getSubject() {
        return subject;
    }

    public String getDate() {
        return date;
    }

    public String getCourse() {
        return course;
    }
}
