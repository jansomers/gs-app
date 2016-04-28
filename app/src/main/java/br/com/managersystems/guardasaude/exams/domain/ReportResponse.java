package br.com.managersystems.guardasaude.exams.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jan on 27/04/2016.
 */
public class ReportResponse {
    private String result;
    private String code;
    private String description;
    private String username;
    private String examIdentification;
    private String reportContent;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The result
     */
    public String getResult() {
        return result;
    }

    /**
     *
     * @param result
     * The result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     *
     * @return
     * The code
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @param code
     * The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The username
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     * The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     * The examIdentification
     */
    public String getExamIdentification() {
        return examIdentification;
    }

    /**
     *
     * @param examIdentification
     * The examIdentification
     */
    public void setExamIdentification(String examIdentification) {
        this.examIdentification = examIdentification;
    }

    /**
     *
     * @return
     * The reportContent
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     *
     * @param reportContent
     * The reportContent
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
