package br.com.managersystems.guardasaude.examoverview.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Exam {

    private Integer id;
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

    /**
     *
     * @return
     * The id
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @param id
     * The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     * The identification
     */
    public String getIdentification() {
        return identification;
    }

    /**
     *
     * @param identification
     * The identification
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     *
     * @return
     * The serviceName
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     *
     * @param serviceName
     * The serviceName
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     *
     * @return
     * The patient
     */
    public String getPatient() {
        return patient;
    }

    /**
     *
     * @param patient
     * The patient
     */
    public void setPatient(String patient) {
        this.patient = patient;
    }

    /**
     *
     * @return
     * The executionDate
     */
    public String getExecutionDate() {
        return executionDate;
    }

    /**
     *
     * @param executionDate
     * The executionDate
     */
    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The reportingPhysicianName
     */
    public String getReportingPhysicianName() {
        return reportingPhysicianName;
    }

    /**
     *
     * @param reportingPhysicianName
     * The reportingPhysicianName
     */
    public void setReportingPhysicianName(String reportingPhysicianName) {
        this.reportingPhysicianName = reportingPhysicianName;
    }

    /**
     *
     * @return
     * The reportingPhysicianProID
     */
    public String getReportingPhysicianProID() {
        return reportingPhysicianProID;
    }

    /**
     *
     * @param reportingPhysicianProID
     * The reportingPhysicianProID
     */
    public void setReportingPhysicianProID(String reportingPhysicianProID) {
        this.reportingPhysicianProID = reportingPhysicianProID;
    }

    /**
     *
     * @return
     * The referringPhysicianName
     */
    public String getReferringPhysicianName() {
        return referringPhysicianName;
    }

    /**
     *
     * @param referringPhysicianName
     * The referringPhysicianName
     */
    public void setReferringPhysicianName(String referringPhysicianName) {
        this.referringPhysicianName = referringPhysicianName;
    }

    /**
     *
     * @return
     * The referringPhysicianProID
     */
    public String getReferringPhysicianProID() {
        return referringPhysicianProID;
    }

    /**
     *
     * @param referringPhysicianProID
     * The referringPhysicianProID
     */
    public void setReferringPhysicianProID(String referringPhysicianProID) {
        this.referringPhysicianProID = referringPhysicianProID;
    }

    /**
     *
     * @return
     * The reportLink
     */
    public String getReportLink() {
        return reportLink;
    }

    /**
     *
     * @param reportLink
     * The reportLink
     */
    public void setReportLink(String reportLink) {
        this.reportLink = reportLink;
    }

    /**
     *
     * @return
     * The images
     */
    public List<Object> getImages() {
        return images;
    }

    /**
     *
     * @param images
     * The images
     */
    public void setImages(List<Object> images) {
        this.images = images;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
