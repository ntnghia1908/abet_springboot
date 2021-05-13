package cseiu.abet.rest_controller;
import cseiu.abet.model.Result;
import cseiu.abet.services.ResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.Response;
import java.util.List;

@Controller
@RequestMapping("/result")
public class ResultControllerRest {
    private final ResultService resultService;

    public ResultControllerRest(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/getByClass/{class_id}")
    public ResponseEntity<List<Result>> getResultByClass(@PathVariable int class_id){
        List<Result> resultLists = resultService.getResultByClass(class_id);
        return new ResponseEntity<>(resultLists, HttpStatus.OK);
    }

    @GetMapping("/{student_id}/{class_id}")
    public ResponseEntity<List<Result>> getResultByStudentAndClass(@PathVariable String student_id,
                                                                   @PathVariable int class_id){
        List<Result> resultList = resultService.getResultByStudentAndClass(student_id, class_id);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @GetMapping("/getByStudent/{student_id}")
    public ResponseEntity<List<Result>> getResultByStudent (@PathVariable String student_id){
        List<Result> resultList = resultService.getResultByStudent(student_id);
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

}
