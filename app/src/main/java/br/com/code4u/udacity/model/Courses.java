package br.com.code4u.udacity.model;

import java.util.List;

/**
 * Created by felipepaiva on 10/11/16.
 */

public class Courses {

    private String title;

    private String subtitle;

    private List<Instructor> instructors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    @Override
    public String toString() {
        return "Curso : " + this.getTitle();
    }
}
