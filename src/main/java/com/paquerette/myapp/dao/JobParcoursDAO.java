package com.paquerette.myapp.dao;

import java.util.List;
import com.paquerette.myapp.model.Domaine;
import com.paquerette.myapp.model.Job;
import com.paquerette.myapp.model.JobParcours;

public interface JobParcoursDAO {

    public void addJobParcours(JobParcours p);
    public void updateJobParcours(JobParcours p);
    public List<JobParcours> listJobParcours();
    public void removeJobParcours(int job_id, int parcours_id);
    public JobParcours getJobParcoursById(int job_id, int parcours_id);
}
