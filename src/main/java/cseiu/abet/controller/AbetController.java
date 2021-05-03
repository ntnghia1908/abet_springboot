package cseiu.abet.controller;

import cseiu.abet.model.CloSlo;
import cseiu.abet.services.AbetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/abet")
public class AbetController {
    private final AbetService abetService;

    public AbetController(AbetService abetService) {
        this.abetService = abetService;
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<List<CloSlo>> getAbetTableByCourse(@PathVariable("courseId") String courseId) {
        List<CloSlo> abetTable = abetService.getAbetMappingTable(courseId);
        return new ResponseEntity<>(abetTable, HttpStatus.OK);
    }
}
