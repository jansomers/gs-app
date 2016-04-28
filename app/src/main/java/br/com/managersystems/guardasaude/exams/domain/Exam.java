package br.com.managersystems.guardasaude.exams.domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Exam implements Parcelable {

    private int id;
    private String identification;
    private String serviceName;
    private String patient;
    private String executionDate;
    private String status;
    private String reportingPhysicianName;
    private String reportingPhysicianProID;
    private String referringPhysicianName;
    private String referringPhysicianProID;
    private String reportLink;
    private List<Object> images = new ArrayList<Object>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public Exam() {
    }

    public Exam(int id, String identification, String serviceName, String patient, String executionDate, String status, String reportingPhysicianName, String reportingPhysicianProID, String referringPhysicianName, String referringPhysicianProID, String reportLink, List<Object> images, Map<String, Object> additionalProperties) {
        this.id = id;
        this.identification = identification;
        this.serviceName = serviceName;
        this.patient = patient;
        this.executionDate = executionDate;
        this.status = status;
        this.reportingPhysicianName = reportingPhysicianName;
        this.reportingPhysicianProID = reportingPhysicianProID;
        this.referringPhysicianName = referringPhysicianName;
        this.referringPhysicianProID = referringPhysicianProID;
        this.reportLink = reportLink;
        this.images = images;
        this.additionalProperties = additionalProperties;
    }

    public Exam(Parcel in) {
        this.id = in.readInt();
        this.identification = in.readString();
        this.serviceName = in.readString();
        this.patient = in.readString();
        this.executionDate = in.readString();
        this.status = in.readString();
        this.reportingPhysicianName = in.readString();
        this.reportingPhysicianProID = in.readString();
        this.referringPhysicianName = in.readString();
        this.referringPhysicianProID = in.readString();
        this.reportLink = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }

    public String getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getReportingPhysicianName() {
        return reportingPhysicianName;
    }

    public void setReportingPhysicianName(String reportingPhysicianName) {
        this.reportingPhysicianName = reportingPhysicianName;
    }

    public String getReportingPhysicianProID() {
        return reportingPhysicianProID;
    }

    public void setReportingPhysicianProID(String reportingPhysicianProID) {
        this.reportingPhysicianProID = reportingPhysicianProID;
    }


    public String getReferringPhysicianName() {
        return referringPhysicianName;
    }


    public void setReferringPhysicianName(String referringPhysicianName) {
        this.referringPhysicianName = referringPhysicianName;
    }

    public String getReferringPhysicianProID() {
        return referringPhysicianProID;
    }

    public void setReferringPhysicianProID(String referringPhysicianProID) {
        this.referringPhysicianProID = referringPhysicianProID;
    }

    public String getReportLink() {
        return reportLink;
    }


    public void setReportLink(String reportLink) {
        this.reportLink = reportLink;
    }


    public List<Object> getImages() {
        return images;
    }

    public void setImages(List<Object> images) {
        this.images = images;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.identification);
        dest.writeString(this.serviceName);
        dest.writeString(this.patient);
        dest.writeString(this.executionDate);
        dest.writeString(this.status);
        dest.writeString(this.reportingPhysicianName);
        dest.writeString(this.reportingPhysicianProID);
        dest.writeString(this.referringPhysicianName);
        dest.writeString(this.referringPhysicianProID);
        dest.writeString(this.reportLink);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Exam createFromParcel(Parcel in) {
            return new Exam(in);
        }

        public Exam[] newArray(int size) {
            return new Exam[size];
        }
    };
}
