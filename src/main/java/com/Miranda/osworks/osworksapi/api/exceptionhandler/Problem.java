package com.Miranda.osworks.osworksapi.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;


/*
* Represents the message that will be given for the user of the API
* if some exception happen
* */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Problem {

     private Integer status;
    private OffsetDateTime localDateTime;
    private String title;
    private List<Field> fields;

    public static class Field {
        private String name;
        private String message;

        public Field(String name, String message){
            this.message = message;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


    public Problem(Integer status, OffsetDateTime localDateTime, String title) {

        this.status = status;
        this.localDateTime = localDateTime;
        this.title = title;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public OffsetDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(OffsetDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
