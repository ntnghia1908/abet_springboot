package cseiu.abet.controller;

import cseiu.abet.model.ClassSession;
import cseiu.abet.model.Course;
import cseiu.abet.model.Instructor;
import cseiu.abet.model.Result;
import cseiu.abet.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@Controller
@RequestMapping("/classSession")
public class ClassSessionController {
    public final String templateDir = "classSession/";
    public final String defaultUrl = "classSession/index";

    private final ClassSessionService classSessionService;
    private final ResultService resultService;
    private final CourseService courseService;
    private final InstructorService instructorService;
    private final UtilityService utilityService;


    public ClassSessionController(ClassSessionService classSessionService, ResultService resultService, CourseService courseService, InstructorService instructorService, UtilityService utilityService) {
        this.classSessionService = classSessionService;
        this.resultService = resultService;
        this.courseService = courseService;
        this.instructorService = instructorService;
        this.utilityService = utilityService;
    }

    @GetMapping("/all")
    public String getAllClassess(Model model) {
        List<ClassSession> classSessionList = classSessionService.getAllClasses();
        model.addAttribute("classSessionList", classSessionList);
        return "admin/class-list";
    }

    @GetMapping("/view/{id}")
    public String showDetailClassPage(@PathVariable(name = "id") int id, Model model) {
        ClassSession classSession = classSessionService.getClassById(id);
        List<Result> resultList = resultService.getResultByClass(id);
        model.addAttribute("classSession", classSession);
        model.addAttribute("resultList", resultList);
        return "/admin/class-detail";
    }

    @RequestMapping("/add")
    public String showAddClassPage(Model model) {
        ClassSession classSession = new ClassSession();
        List<Course> courseList = courseService.getAllCourse();
        List<String> courseName = new ArrayList<>();
        for (Course c : courseList) {
            courseName.add(c.getName());
        }
        List<Instructor> instructorList = instructorService.findAllInstructor();
        model.addAttribute("instructorList", instructorList);
        model.addAttribute("classSession", classSession);
        model.addAttribute("courseList", courseList);
        model.addAttribute("courseNames", courseName);
        return "admin/class-edit";
    }

    @RequestMapping("/edit/{class_id}")
    public String showUpdateClassPage(@PathVariable("class_id") int class_id, Model model) {
        ClassSession classSession = classSessionService.getClassById(class_id);
        List<Course> courseList = courseService.getAllCourse();
        List<String> courseName = new ArrayList<>();
        for (Course c : courseList) {
            courseName.add(c.getName());
        }
        List<Instructor> instructorList = instructorService.findAllInstructor();
        model.addAttribute("instructorList", instructorList);
        model.addAttribute("classSession", classSession);
        model.addAttribute("courseList", courseList);
        model.addAttribute("courseNames", courseName);

        return "admin/class-edit";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveClass(@ModelAttribute("classSession") ClassSession classSession, Model model) {
        classSessionService.addClassSession(classSession);
        return "redirect:/classSession/all";
    }

    @RequestMapping("update/{class_id}")
    public String updateClass(@ModelAttribute("classSession") ClassSession classSession,
                              @PathVariable(name="class_id") int class_id){
        classSession.setId(class_id);
        classSessionService.updateClassSession(classSession);
        return "redirect:/classSession/view/"+class_id;
    }

    @RequestMapping("/delete/{id}")
    public String deleteClass(@PathVariable(name = "id") int id) {
        ClassSession classSession = classSessionService.getClassById(id);
        classSessionService.deleteClass(classSession);
        return "redirect:/classSession/all";
    }

    @RequestMapping(value="/saveAuto", method = RequestMethod.POST)
    public String saveClassAutomatic (@RequestParam("file") MultipartFile file) throws IOException {
        for (List classInfor:utilityService.readClassFromExcelFile(file.getInputStream()) ){
            ClassSession classSession = new ClassSession();

            String instructorName = (String) ((Hashtable<?, ?>) classInfor.get(0)).get("instructor");
            int instructorId = instructorService.searchInstructorIdByName(instructorName);
            classSession.setInstructorId(new Instructor(instructorId));

            String courseId = (String) ((Hashtable<?, ?>) classInfor.get(1)).get("course");
            classSession.setCourse(new Course(courseId));

            int groupTheory= ((Hashtable<String, Integer>) classInfor.get(2)).get("groupTheory");
            classSession.setGroupTheory(groupTheory);

            int semester =   ((Hashtable<String, Integer>) classInfor.get(3)).get("semester");
            classSession.setSemester(semester);

            String year = (String) ((Hashtable<?, ?>) classInfor.get(4)).get("academicYear");
            classSession.setAcademicYear(year);

            classSessionService.addClassSession(classSession);
        }
        return "redirect:/classSession/all";
    }



}


