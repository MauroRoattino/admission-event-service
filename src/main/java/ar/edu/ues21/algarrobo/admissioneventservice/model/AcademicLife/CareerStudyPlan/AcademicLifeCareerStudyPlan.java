package ar.edu.ues21.algarrobo.admissioneventservice.model.AcademicLife.CareerStudyPlan;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.StudyPlan;

public class AcademicLifeCareerStudyPlan {

    private AcademicLifeCareer career;

    private StudyPlan studyPlan;

    private AcademicLifeStudyClass studyClass;

    private Integer enabled;

    public AcademicLifeCareer getCareer() {
        return career;
    }

    public void setCareer(AcademicLifeCareer career) {
        this.career = career;
    }

    public StudyPlan getStudyPlan() {
        return studyPlan;
    }

    public void setStudyPlan(StudyPlan studyPlan) {
        this.studyPlan = studyPlan;
    }

    public AcademicLifeStudyClass getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(AcademicLifeStudyClass studyClass) {
        this.studyClass = studyClass;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }
}
