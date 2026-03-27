package com.airtribe.learntrack.service;
import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Student;

public class CourseService {

    private Course[] courses= new Course[5];
    private int count=0;

    public void addCourse(String courseName, String description, int durationInWeeks, boolean active){
        if(count<courses.length){
            Course c = new Course(courseName,description,durationInWeeks,active);
            courses[count] = c;
            count++;
            System.out.println("Course added successfully!");
        }else {
            System.out.println("Storage full!");
        }
    }

    public void removeCourse(String id){
        for(int i=0; i<count; i++){
            if(courses[i].getId().equals(id)){
                for(int j=i; j<count-1 ; j++){
                    courses[j] = courses[j+1];
                }
                courses[count-1] = null;
                count--;

                System.out.println("Course Removed with id:" + id);
                return;
            }
        }
    }

    public void listCourses(){
        for(int i=0;i<count;i++){
            System.out.println(courses[i].getId()+" "
                    +courses[i].getCourseName()+" "
                    +courses[i].getDescription()+" "
                    +courses[i].getDurationInWeeks()
            );
        }
    }

    public Course searchCourseById(String id){
        for(int i=0;i<count;i++){
            if(courses[i].getId().equals(id)){
                return courses[i];
            }
        }
        return null;
    }
}
