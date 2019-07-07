package org.launchcode.models.forms;

import org.launchcode.models.CoreCompetency;
import org.launchcode.models.Employer;
import org.launchcode.models.Location;
import org.launchcode.models.PositionType;
import org.launchcode.models.data.JobData;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;

/**
 * Created by LaunchCode
 */
public class JobForm {

    @NotNull
    @Size(min=1, message = "Name may not be empty")
    private String name;

    @NotNull
    private int employerId;

    /*
        TODO #3 - Included other fields needed to create a job,
        with correct validation attributes and display names.
        Don't forget to add getters and setters
     */
    /////////////////////////////////////////
    //probably need more validation than NotNull, get back to this.
    private Employer employer;
    private Location location;

    private CoreCompetency corecompetency;

    private PositionType positiontype;
    ///////////////////////////////////////////

    private ArrayList<Employer> employers;
    private ArrayList<Location> locations;
    private ArrayList<CoreCompetency> corecompetencies;
    private ArrayList<PositionType> positiontypes;

    public JobForm() {

        JobData jobData = JobData.getInstance();

        /*
            TODO #4 - populate the other ArrayList collections needed in the view
        */
        //////////not sure if i need findAll????///////////////////////////
      locations = jobData.getLocations().findAll();
      corecompetencies = jobData.getCoreCompetencies().findAll();
      positiontypes = jobData.getPositionTypes().findAll();
      /////////////////////////////////////////

        employers = jobData.getEmployers().findAll();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ////////////////this is part of #3?//////////////////////////////////
    public Employer getEmployer() { return employer; }
    public Location getLocation() { return location; }
    public CoreCompetency getCorecompetency() { return corecompetency; }
    public PositionType getPositiontype() { return positiontype; }

    public void setEmployer(Employer employer) { this.employer = employer; }
    public void setLocation(Location location) { this.location = location; }
    public void setCorecompetency(CoreCompetency corecompetency) { this.corecompetency = corecompetency; }
    public void setPositiontype(PositionType positiontype) { this.positiontype = positiontype; }
  /////////////////////////////////////////////////

    public int getEmployerId() {
        return employerId;
    }

    public void setEmployerId(int employerId) {
        this.employerId = employerId;
    }

    public ArrayList<Employer> getEmployers() {
        return employers;
    }

    public void setEmployers(ArrayList<Employer> employers) {
        this.employers = employers;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    /////////////////////////////CORECOMPETENCY//////////////////////////////////
    public ArrayList<CoreCompetency> getCoreCompetencies() {
        return corecompetencies;
    }

    public void setCoreCompetencies(ArrayList<CoreCompetency> coreCompetencies) {
        this.corecompetencies = coreCompetencies;
    }
    ///////////////////////////////////////////////////////////////////////////

    public ArrayList<PositionType> getPositionTypes() {
        return positiontypes;
    }

    public void setPositionTypes(ArrayList<PositionType> positionTypes) {
        this.positiontypes = positionTypes;
    }
}
