package vn.edu.iuh.fit.wwwduongtuankietck.frontend.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.wwwduongtuankietck.backend.services.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService service;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/candidate")
    public String getCandidate(Model model){
        model.addAttribute("candidates", service.getAllCandidate());
        return "candidate/index";
    }

    @GetMapping("/candidate/detail/{id}")
    public String getCandidateDetail(Model model, @PathVariable long id){
        model.addAttribute("candidates", service.getCandidateById(id));
        return "candidate/detail";
    }

    @GetMapping("/candidate/report1")
    public String getReport(Model model){
        model.addAttribute("showTable", false);
        return "candidate/report1";
    }

    @PostMapping("/candidate/report1")
    public String postReport1(Model model, @RequestParam("company") String company){
        model.addAttribute("showTable", true);
        model.addAttribute("candidates", service.getCandidateReport(company));
        System.out.println("Company : "+company);
        return "candidate/report1";
    }

    @GetMapping("/candidate/report2")
    public String getReport2(Model model){
        model.addAttribute("candidates", service.findCandidateThan5Exp());
        return "candidate/report2";
    }
}
