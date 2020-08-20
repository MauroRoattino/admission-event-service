package ar.edu.ues21.algarrobo.admissioneventservice.model.User.Career;

import ar.edu.ues21.algarrobo.admissioneventservice.model.Enrollment.StudyPlan;

public class CareerPlanId {
    private CareerStudyClass studyClass;
    private StudyPlan StudyPlanObject;

    public CareerStudyClass getStudyClass() {
        return studyClass;
    }

    public void setStudyClass(CareerStudyClass studyClass) {
        this.studyClass = studyClass;
    }

    public StudyPlan getStudyPlanObject() {
        return StudyPlanObject;
    }

    public void setStudyPlanObject(StudyPlan studyPlanObject) {
        StudyPlanObject = studyPlanObject;
    }
}
