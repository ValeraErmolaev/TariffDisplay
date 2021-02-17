package com.example.demo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@ManagedBean(name="pollView")
@ViewScoped
public class PollView implements Serializable {

    private int number;

    public void increment() {
        number++;
    }

    public int getNumber() {
        return number;
    }
}