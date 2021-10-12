package cseiu.abet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cseiu.abet.model.*;
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
    private final ClassSessionService classSessionService;
    private final ResultService resultService;
    private final CourseService courseService;
    private final InstructorService instructorService;
    private final UtilityService utilityService;
    private final CourseAssessmentService courseAssessmentService;
    private final AssessmentToolService assessmentToolService;
    private final AbetService abetService;
    private final ClassAssessmentToolService classAssessmentToolService;
    private final ClassCourseAssessmentService classCourseAssessmentService;
    private final ClassSloCloService classSloCloService;
    private final LearningOutcomeService learningOutcomeService;


    public ClassSessionController(ClassSessionService classSessionService,
                                  ResultService resultService, CourseService courseService,
                                  InstructorService instructorService, UtilityService utilityService,
                                  CourseAssessmentService courseAssessmentService,
                                  AssessmentToolService assessmentToolService,
                                  AbetService abetService, ClassAssessmentToolService classAssessmentToolService,
                                  ClassCourseAssessmentService classCourseAssessmentService,
                                  ClassSloCloService classSloCloService, LearningOutcomeService learningOutcomeService) {
        this.classSessionService = classSessionService;
        this.resultService = resultService;
        this.courseService = courseService;
        this.instructorService = instructorService;
        this.utilityService = utilityService;
        this.courseAssessmentService = courseAssessmentService;
        this.assessmentToolService = assessmentToolService;
        this.abetService = abetService;
        this.classAssessmentToolService = classAssessmentToolService;
        this.classCourseAssessmentService = classCourseAssessmentService;
        this.classSloCloService = classSloCloService;
        this.learningOutcomeService = learningOutcomeService;
    }

    @GetMapping("/all")
    public String getAllClassess(Model model) {
        List<ClassSession> classSessionList = classSessionService.getAllClasses();
        model.addAttribute("classSessionList", classSessionList);
        return "admin/class-list";
    }

    @GetMapping("/view/{id}")
    public String showDetailClassPage(@PathVariable(name = "id") int id, Model model) throws JsonProcessingException {
        ClassSession classSession = classSessionService.getClassById(id);
        List<Result> resultList = resultService.getResultByClass(id);

        List<ClassAssessmentCourse> courseAssessmentList = classCourseAssessmentService.getClassAssessmentCourseByClassWithoutCombo(id);
        List<LearningOutcome> learningOutcomeList = learningOutcomeService.getLOByCourse(classSession.getCourse().getId());

        Hashtable<Integer, Hashtable> classAssessmentTool = new Hashtable<>();
        for (LearningOutcome lo : learningOutcomeList) {
            Hashtable<Integer, Float> item = new Hashtable<>();
            for (ClassAssessmentCourse ca : courseAssessmentList) {
                if (classAssessmentToolService.getClassAssessmentToolByAssessmentAndLO(id, ca.getAssessment().getId(), lo.getId()) != null) {
                    item.put(ca.getClassAssessmentCoursePK().getAssessmentId(), classAssessmentToolService.getClassAssessmentToolByAssessmentAndLO(id, ca.getAssessment().getId(), lo.getId()).getPercentage());
                } else {
                    item.put(ca.getClassAssessmentCoursePK().getAssessmentId(), 0F);
                }
            }
            classAssessmentTool.put(lo.getId(), item);
        }

        Hashtable<Integer, Hashtable> abetMapping = new Hashtable<>();
        for (LearningOutcome lo : learningOutcomeList) {
            Hashtable<Integer, Float> item = new Hashtable<>();
            for (int slo = 1; slo < 7; slo++) {
                if (classSloCloService.getAbetForSloCloInClass(id, lo.getId(), slo) != null) {
                    item.put(slo, classSloCloService.getAbetForSloCloInClass(id, lo.getId(), slo).getPercentage());
                } else {
                    item.put(slo, 0F);
                }
            }
            abetMapping.put(lo.getId(), item);
        }

        ObjectMapper objectMapper = new ObjectMapper();
//        model.addAttribute("jsonTest", objectMapper.writeValueAsString(learningOutcomeList));
        model.addAttribute("abet", abetMapping);
        model.addAttribute("loList", learningOutcomeList);
        model.addAttribute("courseAssessment", courseAssessmentList);
        model.addAttribute("classSession", classSession);
        model.addAttribute("resultList", resultList);
        model.addAttribute("classAssessmentTool", classAssessmentTool);

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
        if (classSessionService.getClassSessionWithFullInfor(classSession) == null) {
            classSessionService.addClassSession(classSession);

            // ADD COURSE ASSESSMENT TO NEW CLASS//
            List<CourseAssessment> courseAssessmentList = courseAssessmentService.getCourseAssessmentByCourseId(classSession.getCourse().getId());
            for (CourseAssessment ca : courseAssessmentList) {
                classCourseAssessmentService.addClassAssessmentFromCourse(ca, classSession.getId());
            }
            // ADD ASSESSMENT TOOL TO NEW CLASS//
            List<AssessmentTool> assessmentToolList = assessmentToolService.getAssessmentTootTableByCourse(classSession.getCourse().getId());
            for (AssessmentTool at : assessmentToolList) {
                classAssessmentToolService.addAssessmentToolToClassBasedOnCourse(at, classSession.getId());
            }

            //ADD ABET MAPPING//
            List<CloSlo> abetMapping = abetService.getAbetMappingTable(classSession.getCourse().getId());
            for (CloSlo cloSlo : abetMapping) {
                classSloCloService.addClassSloCloBasedOnCourse(cloSlo, classSession.getId());
            }
        }
        return "redirect:/classSession/all";
    }

    @RequestMapping("update/{class_id}")
    public String updateClass(@ModelAttribute("classSession") ClassSession classSession,
                              @PathVariable(name = "class_id") int class_id) {
        classSession.setId(class_id);
        classSessionService.updateClassSession(classSession);
        return "redirect:/classSession/view/" + class_id;
    }

    @RequestMapping("/delete/{id}")
    public String deleteClass(@PathVariable(name = "id") int id) {
        ClassSession classSession = classSessionService.getClassById(id);
        classSessionService.deleteClass(classSession);
        return "redirect:/classSession/all";
    }

    @RequestMapping(value = "/saveAuto", method = RequestMethod.POST)
    public String saveClassAutomatic(@RequestParam("file") MultipartFile file) throws IOException {
        for (List classInfor : utilityService.readClassFromExcelFile(file.getInputStream())) {
            ClassSession classSession = new ClassSession();
            try {
                String instructorName = (String) ((Hashtable<?, ?>) classInfor.get(0)).get("instructor");
                int instructorId = instructorService.searchInstructorIdByName(instructorName);
                classSession.setInstructorId(new Instructor(instructorId));

                String courseId = (String) ((Hashtable<?, ?>) classInfor.get(1)).get("course");
                classSession.setCourse(new Course(courseId));

                int groupTheory = ((Hashtable<String, Integer>) classInfor.get(2)).get("groupTheory");
                classSession.setGroupTheory(groupTheory);

                int semester = ((Hashtable<String, Integer>) classInfor.get(3)).get("semester");
                classSession.setSemester(semester);

                String year = (String) ((Hashtable<?, ?>) classInfor.get(4)).get("academicYear");
                classSession.setAcademicYear(year);

                if (classSessionService.getClassSessionWithFullInfor(classSession) == null) {
                    classSessionService.addClassSession(classSession);

                    // ADD COURSE ASSESSMENT TO NEW CLASS//
                    List<CourseAssessment> courseAssessmentList = courseAssessmentService.getCourseAssessmentByCourseId(classSession.getCourse().getId());
                    for (CourseAssessment ca : courseAssessmentList) {
                        classCourseAssessmentService.addClassAssessmentFromCourse(ca, classSession.getId());
                    }
                    // ADD ASSESSMENT TOOL TO NEW CLASS//
                    List<AssessmentTool> assessmentToolList = assessmentToolService.getAssessmentTootTableByCourse(classSession.getCourse().getId());
                    for (AssessmentTool at : assessmentToolList) {
                        classAssessmentToolService.addAssessmentToolToClassBasedOnCourse(at, classSession.getId());
                    }

                    //ADD ABET MAPPING//
                    List<CloSlo> abetMapping = abetService.getAbetMappingTable(classSession.getCourse().getId());
                    for (CloSlo cloSlo : abetMapping) {
                        classSloCloService.addClassSloCloBasedOnCourse(cloSlo, classSession.getId());
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return "redirect:/classSession/all";
    }
}


