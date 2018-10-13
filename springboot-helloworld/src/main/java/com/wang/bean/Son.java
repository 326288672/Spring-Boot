package com.wang.bean;

public class Son {
    private String school;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Son{" +
                "school='" + school + '\'' +
                '}';
    }
}
