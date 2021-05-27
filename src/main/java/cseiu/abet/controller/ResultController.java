package cseiu.abet.controller;
import cseiu.abet.model.*;
import cseiu.abet.services.ClassCourseAssessmentService;
import cseiu.abet.services.GradingService;
import cseiu.abet.services.ResultService;
import cseiu.abet.services.UtilityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/result")
public class ResultController {
    private final ResultService resultService;
    private final UtilityService utilityService;
    private final ClassCourseAssessmentService classAssessmentCourseService;
    private final GradingService gradingService;

    public ResultController(ResultService resultService, UtilityService utilityService,
                            ClassCourseAssessmentService classAssessmentCourseService, GradingService gradingService) {
        this.resultService = resultService;
        this.utilityService = utilityService;
        this.classAssessmentCourseService = classAssessmentCourseService;
        this.gradingService = gradingService;
    }

    @GetMapping("/detailForStudent/{class_id}/{student_id}")
    public String showDetailResultOfStudentInSpecificClass(@PathVariable(name="class_id") int class_id,
                                                           @PathVariable(name="student_id") String student_id,
                                                           Model model){
        Result result = resultService.getResultByStudentAndClass(student_id, class_id);
        model.addAttribute("result", result);
        return "/admin/student-resultDetail";
    }

    @GetMapping("/deleteStudentInClass/{class_id}/{student_id}")
    public String deleteStudentFromClass (@PathVariable(name ="class_id") int class_id,
                                          @PathVariable(name="student_id") String student_id){
        resultService.deleteStudentInClass(student_id, class_id);
        return "redirect:/classSession/view/"+class_id;
    }

    @GetMapping("/assignCourse/{class_id}/{student_id}")
    public String assignCourseForStudent(@PathVariable("class_id") int class_id,
                                         @PathVariable("student_id") String student_id){
        Result result = new Result();
        result.setResultPK(new ResultPK(student_id,class_id));
        resultService.addStudentToClass(result);
        return "redirect:/student/view/"+student_id;
    }

    @RequestMapping(value ="/upload/{class_id}", method = RequestMethod.POST)
    public String saveStudentListForClass(@RequestParam("file") MultipartFile file,
                                          @PathVariable(name="class_id") int class_id) throws IOException {
        List<Result> resultList = utilityService.readStudentScoreFromExcelFile(file.getInputStream());
        for (Result result: resultList){
            result.setResultPK(new ResultPK(result.getStudent().getId(),class_id));
            resultService.addStudentToClass(result);
        }

        return "redirect:/classSession/view/"+class_id;
    }

    @RequestMapping(value ="/uploadScore/{class_id}", method = RequestMethod.POST)
    public String saveStudentScoreForClass(@RequestParam("file") MultipartFile file,
                                          @PathVariable(name="class_id") int class_id) throws IOException {
        List<Result> resultList = utilityService.readStudentScoreFromExcelFile(file.getInputStream());
        List<ClassAssessmentCourse> classAssessmentCourses = classAssessmentCourseService.getClassAssessmentCourseByClass(class_id);

        for (Result result: resultList){
            result.setResultPK(new ResultPK(result.getStudent().getId(),class_id));
            resultService.addStudentToClass(gradingService.calculateGPA(result,classAssessmentCourses));
        }
        return "redirect:/classSession/view/"+class_id;
    }




}
