package com.swz.restmvc.dao;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
@Getter
@Setter
public class Task {
    private String id;
    private String content;
    private String createTime;

    public Task() {
    }

    public Task(String id, String content, Date createTime) {
        this.id = id;
        this.content = content;
        this.createTime = new SimpleDateFormat("yyyy-MM-dd hh").format(createTime);
    }
}
