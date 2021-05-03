package cseiu.abet.exception;

public class CourseNotFoundExpection extends  RuntimeException{
    public CourseNotFoundExpection(String msg) {
        super(msg);
    }
}
