package org.launchcode.controllers;

import org.launchcode.models.Job;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        // TODO #1 - get the Job with the given ID and pass it into the view
        model.addAttribute("sillyjob", jobData.findById(id));


        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        model.addAttribute("error","bee sky monkey up");
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.
        if(errors.hasErrors()) {
          model.addAttribute(jobForm);
          model.addAttribute("error","bee sky monkey down");
          return "new-job";
        }
        else {
          Job newjob = new Job();
          newjob.setName(jobForm.getName());
          //newjob.setEmployer(jobData.findById(jobForm.getEmployerId()).getEmployer());
          newjob.setEmployer(jobData.getEmployers().findById(jobForm.getEmployerId()));
          newjob.setLocation(jobForm.getLocation());
          newjob.setPositionType(jobForm.getPositiontype());
          newjob.setCoreCompetency(jobForm.getCorecompetency());
          JobData.getInstance().add(newjob);
          return "redirect:"+"?id="+newjob.getId();
        }
        /*
 ////////////////////////////ADD////////////////////////////////////////

  @RequestMapping(value = "add", method = RequestMethod.GET)
  public String displayAddCheeseForm(Model model) {
    model.addAttribute("title", "Add Cheese");
    model.addAttribute("cheese", new cheese());
    model.addAttribute("cheeseTypes", CheeseType.values());
    return "cheese/add";
  }


  @RequestMapping(value = "add", method = RequestMethod.POST)
  //public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDesc) {
  public String processAddCheeseForm(@ModelAttribute @Valid cheese newCheese, Errors errors, Model model) {

    if (errors.hasErrors()) {
      model.addAttribute("title", "Add Cheese");
      return "cheese/add";
    }

    //cheeses.put(cheeseName,cheeseDesc);
    //cheese newcheese = new cheese(cheeseName, cheeseDesc);
    CheeseData.add(newCheese);
    return "redirect:";
  }

  ////////////////////////REMOVE///////////////////////////////////
         */





    }
}
