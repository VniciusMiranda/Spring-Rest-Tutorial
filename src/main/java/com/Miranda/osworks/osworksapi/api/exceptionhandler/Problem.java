package com.Miranda.osworks.osworksapi.api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.List;


/*
* Represents the message that will be given for the user of the API
* if some exception happen
* */
public class Problem {

     private Integer status;
    private LocalDateTime localDateTime;
    private String title;
    private List<Field> fields;

    public static class Field {
        private String name;
        private String message;

        public Field(String name, String message){
            this.message = message;
            this.name = name;
        }

    }


    public Problem(Integer status, LocalDateTime localDateTime, String title,
                   List<Field> fields) {

        this.status = status;
        this.localDateTime = localDateTime;
        this.title = title;
        this.fields = fields;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}