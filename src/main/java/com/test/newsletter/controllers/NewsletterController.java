package com.test.newsletter.controllers;

import com.test.newsletter.converters.PersonalInformationDataToPersonalInformation;
import com.test.newsletter.converters.PersonalInfromationToPersonalInformationData;
import com.test.newsletter.data.PersonalInformationData;
import com.test.newsletter.services.PersonalInforamtionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class NewsletterController {

    private PersonalInforamtionService personalInforamtionService;
    private PersonalInformationDataToPersonalInformation personalInformationDataToPersonalInformation;
    private PersonalInfromationToPersonalInformationData personalInfromationToPersonalInformationData;

    public NewsletterController(PersonalInforamtionService personalInforamtionService, PersonalInformationDataToPersonalInformation personalInformationDataToPersonalInformation,
                                PersonalInfromationToPersonalInformationData personalInfromationToPersonalInformationData) {
        this.personalInforamtionService = personalInforamtionService;
        this.personalInformationDataToPersonalInformation = personalInformationDataToPersonalInformation;
        this.personalInfromationToPersonalInformationData = personalInfromationToPersonalInformationData;
    }

    @GetMapping("/newsletter")
    public String getNewsletterPersonalInformation(Model model) {
        model.addAttribute("personalInfo", personalInforamtionService.getAllPersonalInformations());
        return "newsletter/personalInfo";
    }

    @PostMapping("/save")
    public String setPersonalInfo(@Valid PersonalInformationData personalInfo, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "newsletter/personalInfoForm";
        }
        personalInforamtionService.savePersonalInformation(personalInformationDataToPersonalInformation.convert(personalInfo));
        return "redirect:/newsletter";
    }

    @GetMapping("/")
    public String personalInfoForm(Model model){
        model.addAttribute("personalInfo", new PersonalInformationData());
        return "newsletter/personalInfoForm";
    }
}
