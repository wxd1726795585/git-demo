package com.example.bean;

import lombok.ToString;

import java.util.Date;
@ToString
public class CooperativEevaluation   {
    private String id;

    private String cooperatorName;

    private String industryCategory;

    private String businessCoverageProvinces;

    private Integer companyEmployees;

    private String incomeScaleBegin;

    private String incomeScaleEnd;

    private String companyWebSite;

    private String freelanceJobs;

    private String sceneDesc;

    private String invoiceContent;

    private String workerPlace;

    private Integer monthIncomeRange;

    private String numberOfFreelancers;

    private String totalMonthlyPayment;

    private String expenseReleaseCycle;

    private Boolean proofOfAuthenticity;

    private String evaluationSheetUrl;

    private Date createTime;

    private String creator;

    private Date updateTime;

    private String updator;

    public CooperativEevaluation(String id, String cooperatorName, String industryCategory, String businessCoverageProvinces, Integer companyEmployees, String incomeScaleBegin, String incomeScaleEnd, String companyWebSite, String freelanceJobs, String sceneDesc, String invoiceContent, String workerPlace, Integer monthIncomeRange, String numberOfFreelancers, String totalMonthlyPayment, String expenseReleaseCycle, Boolean proofOfAuthenticity, String evaluationSheetUrl, Date createTime, String creator, Date updateTime, String updator) {
        this.id = id;
        this.cooperatorName = cooperatorName;
        this.industryCategory = industryCategory;
        this.businessCoverageProvinces = businessCoverageProvinces;
        this.companyEmployees = companyEmployees;
        this.incomeScaleBegin = incomeScaleBegin;
        this.incomeScaleEnd = incomeScaleEnd;
        this.companyWebSite = companyWebSite;
        this.freelanceJobs = freelanceJobs;
        this.sceneDesc = sceneDesc;
        this.invoiceContent = invoiceContent;
        this.workerPlace = workerPlace;
        this.monthIncomeRange = monthIncomeRange;
        this.numberOfFreelancers = numberOfFreelancers;
        this.totalMonthlyPayment = totalMonthlyPayment;
        this.expenseReleaseCycle = expenseReleaseCycle;
        this.proofOfAuthenticity = proofOfAuthenticity;
        this.evaluationSheetUrl = evaluationSheetUrl;
        this.createTime = createTime;
        this.creator = creator;
        this.updateTime = updateTime;
        this.updator = updator;
    }

    public CooperativEevaluation() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCooperatorName() {
        return cooperatorName;
    }

    public void setCooperatorName(String cooperatorName) {
        this.cooperatorName = cooperatorName == null ? null : cooperatorName.trim();
    }

    public String getIndustryCategory() {
        return industryCategory;
    }

    public void setIndustryCategory(String industryCategory) {
        this.industryCategory = industryCategory == null ? null : industryCategory.trim();
    }

    public String getBusinessCoverageProvinces() {
        return businessCoverageProvinces;
    }

    public void setBusinessCoverageProvinces(String businessCoverageProvinces) {
        this.businessCoverageProvinces = businessCoverageProvinces == null ? null : businessCoverageProvinces.trim();
    }

    public Integer getCompanyEmployees() {
        return companyEmployees;
    }

    public void setCompanyEmployees(Integer companyEmployees) {
        this.companyEmployees = companyEmployees;
    }

    public String getIncomeScaleBegin() {
        return incomeScaleBegin;
    }

    public void setIncomeScaleBegin(String incomeScaleBegin) {
        this.incomeScaleBegin = incomeScaleBegin == null ? null : incomeScaleBegin.trim();
    }

    public String getIncomeScaleEnd() {
        return incomeScaleEnd;
    }

    public void setIncomeScaleEnd(String incomeScaleEnd) {
        this.incomeScaleEnd = incomeScaleEnd == null ? null : incomeScaleEnd.trim();
    }

    public String getCompanyWebSite() {
        return companyWebSite;
    }

    public void setCompanyWebSite(String companyWebSite) {
        this.companyWebSite = companyWebSite == null ? null : companyWebSite.trim();
    }

    public String getFreelanceJobs() {
        return freelanceJobs;
    }

    public void setFreelanceJobs(String freelanceJobs) {
        this.freelanceJobs = freelanceJobs == null ? null : freelanceJobs.trim();
    }

    public String getSceneDesc() {
        return sceneDesc;
    }

    public void setSceneDesc(String sceneDesc) {
        this.sceneDesc = sceneDesc == null ? null : sceneDesc.trim();
    }

    public String getInvoiceContent() {
        return invoiceContent;
    }

    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent == null ? null : invoiceContent.trim();
    }

    public String getWorkerPlace() {
        return workerPlace;
    }

    public void setWorkerPlace(String workerPlace) {
        this.workerPlace = workerPlace == null ? null : workerPlace.trim();
    }

    public Integer getMonthIncomeRange() {
        return monthIncomeRange;
    }

    public void setMonthIncomeRange(Integer monthIncomeRange) {
        this.monthIncomeRange = monthIncomeRange;
    }

    public String getNumberOfFreelancers() {
        return numberOfFreelancers;
    }

    public void setNumberOfFreelancers(String numberOfFreelancers) {
        this.numberOfFreelancers = numberOfFreelancers == null ? null : numberOfFreelancers.trim();
    }

    public String getTotalMonthlyPayment() {
        return totalMonthlyPayment;
    }

    public void setTotalMonthlyPayment(String totalMonthlyPayment) {
        this.totalMonthlyPayment = totalMonthlyPayment == null ? null : totalMonthlyPayment.trim();
    }

    public String getExpenseReleaseCycle() {
        return expenseReleaseCycle;
    }

    public void setExpenseReleaseCycle(String expenseReleaseCycle) {
        this.expenseReleaseCycle = expenseReleaseCycle == null ? null : expenseReleaseCycle.trim();
    }

    public Boolean getProofOfAuthenticity() {
        return proofOfAuthenticity;
    }

    public void setProofOfAuthenticity(Boolean proofOfAuthenticity) {
        this.proofOfAuthenticity = proofOfAuthenticity;
    }

    public String getEvaluationSheetUrl() {
        return evaluationSheetUrl;
    }

    public void setEvaluationSheetUrl(String evaluationSheetUrl) {
        this.evaluationSheetUrl = evaluationSheetUrl == null ? null : evaluationSheetUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator == null ? null : updator.trim();
    }
}