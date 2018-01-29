package com.admin.taskmgt.action;

import com.hrmgt.emp.formbean.ContactUsForm;
import com.hrmgt.emp.formbean.RegTraineeActionForm;
import com.hrmgt.emp.formbean.UploadCvForm;
import com.tpcs.admin.hrmgt.vo.ContactNumberVO;
import com.tpcs.admin.hrmgt.vo.ContactVO;
import com.tpcs.admin.hrmgt.vo.IntervieweeVO;
import com.tpcs.admin.hrmgt.vo.RegTraineeVo;
import com.tpcs.admin.taskmgt.vo.SalaryVo;
import com.tpcs.admin.taskmgt.dao.impl.LovServicesDaoImpl;
import com.tpcs.admin.taskmgt.dao.impl.TaskAssignmentServicesDaoImpl;
import com.tpcs.admin.taskmgt.vo.FileUploadVo;
import com.tpcs.admin.taskmgt.vo.ListOfValuesVO;
import com.tpcs.admin.taskmgt.vo.NewsEventVO;
import com.tpcs.admin.taskmgt.vo.ResultVO;
import com.tpcs.admin.taskmgt.vo.StatusReportVO;
import com.tpcs.admin.taskmgt.vo.TaskAssignmentVO;
import com.tpcs.employee.formbean.EmployeeActionFormBean;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.upload.FormFile;
import org.apache.struts.validator.DynaValidatorForm;

/**
 *
 * @author ALOK
 */
public class TaskAssignmentAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String HOME_PAGE = "homePage";
    private final static String TASK_ASSIGNMENT = "taskAssignment";
    private final static String ASSIGNED_TASK_LIST = "assignedtasklist";
    private final static String SUBMIT_STATUS_REPORT = "submitStatusReport";
    private final static String VIEW_STATUS_REPORT = "viewStatusReport";
    private final static String ASSIGN_TASK = "assigntask";
    private final static String VIEW_TASK = "viewtask";
    private final static String UPDATED_ASSIGN_TASK = "updateTaskAssignment";
    private final static String STORE_EMPLOYEE_GOAL_SHEET = "storeEmployeeGoalSheet";
    private final static String STORE_CONTACT_NO = "storeContactNo";
    private final static String STORE_INTERVIEW_CANDIDATE_INFO = "storeInterviewCandidateInfo";
    private final static String VIEW_INTERVIEWEE_INFO = "viewIntervieweeInfo";
    private final static String VIEW_CONTACT_DETAILS = "viewContactDetails";
    private final static String VIEW_INTERVIEWEE_EMAILS = "viewIntervieweeEmails";
    private final static String TO_UPDATE_INTERVIEWEE = "toUpdateInterviewee";
    private final static String SUBMIT_NEWS_REPORT = "submitNewsReport";
    private final static String STORE_ENQUIRY_FORM = "storeEnquiryForm";
    private final static String VIEW_ENQUIRY_REPORT = "viewEnquiryReport";
    private final static String STORE_CONTACT_USER = "storeContactUser";
    private final static String MORE_NEWS = "moreNews";
    private final static String PLAN_STATUS_REPORT = "planStatusReport";
    private final static String ENTRY_SALARY = "entrySalary";
    private final static String SALARY_SLIP = "salarySlip";
    private final static String SEARCH_SALARY_SLIP = "searchSalarySlip";
    private final static String STORE_REG_TRAINEE = "storeRegTrainee";
    private final static String FUTURE_TASK = "futureTask";
    private final static String VIEW_FUTURE_TASK = "viewFutureTask";
    private final static String DELETE_FUTURE_TASK = "deleteFutureTask";
    private final static String STORE_UPLOAD_CV = "storeUploadCv";
    private final static String DOWNLOAD_CURRICULAM_VITAE = "downloadCurriculamVitae";
    private final static String FAILURE = "failure";
    private final static String SUCCESS = "success";

    public ActionForward assignTask(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LovServicesDaoImpl lovServicesDaoImpl = new LovServicesDaoImpl();
        List<ListOfValuesVO> listOfUserProfile = lovServicesDaoImpl.populateUserProfileList();
        List<ListOfValuesVO> listOfTaskCategory = lovServicesDaoImpl.populateTaskCategoryList();
        List<ListOfValuesVO> listOfTask = lovServicesDaoImpl.populateTaskList();

        DynaActionForm dynaActionForm = (DynaActionForm) form;
        dynaActionForm.set("listOfUserProfile", listOfUserProfile);
        dynaActionForm.set("listOfTaskCategory", listOfTaskCategory);
        dynaActionForm.set("listOfTask", listOfTask);
        return mapping.findForward(ASSIGN_TASK);
    }

    public ActionForward futureTask(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession(true);
        Integer ResourceId = (Integer) session.getAttribute("userid");
        //Integer resourceId = (Integer) dynaActionForm.get("resourceId");
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        String tasktitle = employeeActionFormBean.getTasktitle();
        String taskdes = employeeActionFormBean.getTaskdes();
        String taskstartdate = employeeActionFormBean.getTaskstartdate();
        String taskcompdate = employeeActionFormBean.getTaskcompdate();
        String taskpriority = employeeActionFormBean.getTaskpriority();

        TaskAssignmentVO taskAssignmentVO = new TaskAssignmentVO();
        taskAssignmentVO.setTasktitle(tasktitle);
        taskAssignmentVO.setTaskdes(taskdes);
        taskAssignmentVO.setTaskstartdate(taskstartdate);
        taskAssignmentVO.setTaskcompdate(taskcompdate);
        taskAssignmentVO.setTaskpriority(taskpriority);
        taskAssignmentVO.setResourceId(ResourceId);
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.storeFutureTask(taskAssignmentVO);
        request.setAttribute("message", resultVO.getMessage());





        return mapping.findForward(FUTURE_TASK);
    }

    public ActionForward viewFutureTask(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm dynaActionForm = (DynaActionForm) form;

        HttpSession session = request.getSession(true);
        Integer resourceId = (Integer) session.getAttribute("userid");

        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        List<TaskAssignmentVO> listOfAssignedTaskList = taskAssignmentServicesDaoImpl.populateFutureTaskReports(resourceId);
        dynaActionForm.set("listOffutureTaskReport", listOfAssignedTaskList);


        return mapping.findForward(VIEW_FUTURE_TASK);
    }

    public ActionForward deleteFutureTask(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession(true);
        Integer resourceId = (Integer) session.getAttribute("userid");
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        int futuretaskid = (Integer) dynaActionForm.get("futureTaskId");
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.deleteFutureTask(futuretaskid, resourceId);
        request.setAttribute("message", resultVO.getMessage());
        dynaActionForm.set("listOffutureTaskReport", resultVO.getList());



        return mapping.findForward(DELETE_FUTURE_TASK);
    }

    public ActionForward salarySlip(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LovServicesDaoImpl lovServicesDaoImpl = new LovServicesDaoImpl();
        List<ListOfValuesVO> listOfUserProfile = lovServicesDaoImpl.populateUserProfileList();
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        dynaActionForm.set("listOfUserProfile", listOfUserProfile);
        return mapping.findForward(SALARY_SLIP);
    }

    public ActionForward taskAssignment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;

        HttpSession session = request.getSession(true);
        Integer assignedByResourceId = (Integer) session.getAttribute("userid");
        Integer resourceId = (Integer) dynaActionForm.get("resourceId");
        String taskCategoryId = (String) dynaActionForm.getString("taskCategoryId");
        String taskDescription = (String) dynaActionForm.get("taskDescription");
        String projectId = (String) dynaActionForm.get("projectId");
        String targetDate = (String) dynaActionForm.get("targetDate");
        String statusId = (String) dynaActionForm.get("statusId");

        TaskAssignmentVO taskAssignmentVO = new TaskAssignmentVO();
        taskAssignmentVO.setAssignedByResourceId(assignedByResourceId);
        taskAssignmentVO.setResourceId(resourceId);
        taskAssignmentVO.setProjectId(projectId);
        taskAssignmentVO.setTaskStatusId(statusId);
        taskAssignmentVO.setTaskTargetDate(targetDate);
        taskAssignmentVO.setTaskCategoryId(taskCategoryId);
        taskAssignmentVO.setTaskDescription(taskDescription);


        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.storeTaskAssignment(taskAssignmentVO);

        request.setAttribute("message", resultVO.getMessage());

        return mapping.findForward(TASK_ASSIGNMENT);
    }

    public ActionForward assignedtasklist(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        HttpSession session = request.getSession(true);
        Integer resourceId = (Integer) session.getAttribute("userid");
        System.out.println(" resourceId ----------------------->  " + resourceId);
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        if (resourceId > 0) {
            List<TaskAssignmentVO> listOfAssignedTask = taskAssignmentServicesDaoImpl.populateTaskAssignmentList(resourceId);
            System.out.println("listOfAssignedTask :  " + listOfAssignedTask.size());
            DynaActionForm dynaActionForm = (DynaActionForm) form;
            dynaActionForm.set("taskAssignmentList", listOfAssignedTask);

        }

        return mapping.findForward(ASSIGNED_TASK_LIST);
    }

    public ActionForward submitStatusReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;

        HttpSession session = request.getSession(true);
        Integer resourceId = (Integer) session.getAttribute("userid");
        String[] statusReport = (String[]) dynaActionForm.get("statusReport");
        String billableHours = (String) dynaActionForm.get("billableHours");
        String nonBillableHours = (String) dynaActionForm.get("nonBillableHours");
        for (int i = 0; i < statusReport.length; i++) {

            System.out.println("statusReport" + statusReport[i]);
        }
        StatusReportVO statusReportVO = new StatusReportVO();
        statusReportVO.setSubmitstatusreport(statusReport);
        statusReportVO.setResourceId(resourceId);
        statusReportVO.setBillableHours(billableHours);
        statusReportVO.setNonBillableHours(nonBillableHours);
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.storeStatusReport(statusReportVO);


        request.setAttribute("message", resultVO.getMessage());

        return mapping.findForward(SUBMIT_STATUS_REPORT);
    }

    public ActionForward populateAssignedtask(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String taskId = request.getParameter("taskId");

        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        TaskAssignmentVO taskAssignmentVO = taskAssignmentServicesDaoImpl.populateTaskAssignment(taskId);

        LovServicesDaoImpl lovServicesDaoImpl = new LovServicesDaoImpl();
        List<ListOfValuesVO> listOfTaskCategoryValues = lovServicesDaoImpl.populateTaskCategoryList();
        List<ListOfValuesVO> listOfTaskStatusValues = lovServicesDaoImpl.populateTaskStatusList();



        DynaActionForm dynaActionForm = (DynaActionForm) form;
        dynaActionForm.set("taskId", taskAssignmentVO.getTaskId());
        dynaActionForm.set("resourceId", taskAssignmentVO.getResourceId());
        dynaActionForm.set("categoryId", taskAssignmentVO.getCategoryId());
        dynaActionForm.set("taskDescription", taskAssignmentVO.getTaskDescription());
        dynaActionForm.set("statusId", taskAssignmentVO.getTaskStatusId());
        dynaActionForm.set("taskTargetDate", taskAssignmentVO.getTaskTargetDate());
        dynaActionForm.set("taskCategoryList", listOfTaskCategoryValues);
        dynaActionForm.set("taskStatusList", listOfTaskStatusValues);

        return mapping.findForward(VIEW_TASK);
    }

    public ActionForward updateTaskAssignment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;
        String taskId = (String) dynaActionForm.get("taskId");
        Integer resourceId = (Integer) dynaActionForm.get("resourceId");
        String taskCategoryId = (String) dynaActionForm.getString("taskCategoryId");
        String taskDescription = (String) dynaActionForm.get("taskDescription");
        String projectId = (String) dynaActionForm.get("projectId");
        String targetDate = (String) dynaActionForm.get("targetDate");
        String statusId = (String) dynaActionForm.get("statusId");

        /*
        TaskAssignmentVO taskAssignmentVO = new TaskAssignmentVO();
        taskAssignmentVO.setTaskId(taskId);
        taskAssignmentVO.setResourceId(resourceId);
        taskAssignmentVO.setProjectId(projectId);
        taskAssignmentVO.setTaskStatusId(statusId);
        taskAssignmentVO.setTaskTargetDate(targetDate);
        taskAssignmentVO.setCategoryId(taskCategoryId);
        taskAssignmentVO.setTaskDescription(taskDescription);
        
        
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        taskAssignmentServicesDaoImpl.updateTaskAssignment(taskAssignmentVO);
        
        //request.setAttribute("message", resultVO.getMessage());
        
        // TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        
         */

        return mapping.findForward(UPDATED_ASSIGN_TASK);
    }

    public ActionForward viewStatusReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;

        HttpSession session = request.getSession(true);
        Integer resourceId = (Integer) session.getAttribute("userid");

        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        List<StatusReportVO> listDailyStatusReports = taskAssignmentServicesDaoImpl.populateDailyStatusReports(resourceId);
        dynaActionForm.set("listOfDailyStatusReports", listDailyStatusReports);

        return mapping.findForward(VIEW_STATUS_REPORT);
    }

    public ActionForward storeEmployeeGoalSheet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;
        /*
        HttpSession session = request.getSession(true);
        Integer resourceId = (Integer) session.getAttribute("userid");        
        
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        List<StatusReportVO> listDailyStatusReports = taskAssignmentServicesDaoImpl.populateDailyStatusReports(resourceId);
        dynaActionForm.set("listOfDailyStatusReports",listDailyStatusReports );
         */
        return mapping.findForward(STORE_EMPLOYEE_GOAL_SHEET);
    }

    public ActionForward storeContactNumber(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;

        String name = (String) dynaActionForm.get("name");
        String category = (String) dynaActionForm.get("category");
        String contactNumber = (String) dynaActionForm.get("contactNumber");
        String nickName = (String) dynaActionForm.get("nickName");
        String alternateNumber = (String) dynaActionForm.get("alternateNumber");
        String alternateEmailId = (String) dynaActionForm.get("alternateEmailId");
        String emailId = (String) dynaActionForm.get("emailId");


        ContactNumberVO contactNumberVO = new ContactNumberVO();
        contactNumberVO.setName(name);
        contactNumberVO.setNickName(nickName);
        contactNumberVO.setCategory(category);
        contactNumberVO.setContactNumber(contactNumber);
        contactNumberVO.setAlternateNumber(alternateNumber);
        contactNumberVO.setAlternateEmailId(alternateEmailId);
        contactNumberVO.setEmailId(emailId);


        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.storeContactNumber(contactNumberVO);
        request.setAttribute("message", resultVO.getMessage());

        return mapping.findForward(STORE_CONTACT_NO);
    }

    public ActionForward viewContactDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        List<ContactNumberVO> listOfContactDetails = taskAssignmentServicesDaoImpl.viewContactDetails();
        dynaActionForm.set("listOfContactDetails", listOfContactDetails);
        return mapping.findForward(VIEW_CONTACT_DETAILS);
    }

    public ActionForward intervieweeInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.intervieweeUtils();
        dynaValidatorForm.set("listOfAcademicQualification", resultVO.getListOfQualification());
        dynaValidatorForm.set("listOfInstitute", resultVO.getListOfUniversity());
        dynaValidatorForm.set("listOfKeySkils", resultVO.getListOfKeySkills());
        dynaValidatorForm.set("listOfProfile", resultVO.getListOfProfile());
        return mapping.findForward("successs");
    }
    /*
     * This method modyfied by 
     * @TPCS_PL Chandan 109(16.06.2013)
     */

    public ActionForward storeInterviewCandidateInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
        String name = (String) dynaValidatorForm.get("name");
        String contactNo = (String) dynaValidatorForm.get("contactNo");
        String emailId = (String) dynaValidatorForm.get("emailId");
        String alternateEmailId = (String) dynaValidatorForm.get("alternateEmailId");
        String profileAppliedFor = (String) dynaValidatorForm.get("profileAppliedFor");
        String otherPofileAppliedFor = (String) dynaValidatorForm.get("otherPofileAppliedFor");
        String qualification = (String) dynaValidatorForm.get("qualification");
        String otherQualification = (String) dynaValidatorForm.get("otherQualification");
        String institutename = (String) dynaValidatorForm.get("instituteName");
        String otherInstituteName = (String) dynaValidatorForm.get("otherInstituteName");
        String passoutyr = (String) dynaValidatorForm.get("passoutyr");
        String intervieweeExperience = (String) dynaValidatorForm.get("intervieweeExperience");
        String keySkills[] = (String[]) dynaValidatorForm.get("keySkills");
        String extraKeySkills = (String) dynaValidatorForm.get("extraKeySkills");
        String interviewStatus = (String) dynaValidatorForm.get("interviewStatus");
        String interviewStatusDate = (String) dynaValidatorForm.get("interviewStatusDate");
        String receiveCvDate = (String) dynaValidatorForm.get("receiveCvDate");
        String remarks = (String) dynaValidatorForm.get("remarks");

        IntervieweeVO intervieweeVO = new IntervieweeVO();
        intervieweeVO.setName(name.trim());
        intervieweeVO.setContactNo(contactNo.trim());
        intervieweeVO.setEmailId(emailId.trim());
        intervieweeVO.setAlternateEmailId(alternateEmailId.trim());
        intervieweeVO.setInterviewexperience(intervieweeExperience.trim());
        intervieweeVO.setPassoutyr(passoutyr.trim());
        intervieweeVO.setInstitutename(institutename.trim());
        intervieweeVO.setOtherInstitutename(otherInstituteName.trim());
        intervieweeVO.setProfileApplied(profileAppliedFor.trim());
        intervieweeVO.setOtherPofileAppliedFor(otherPofileAppliedFor.trim());
        intervieweeVO.setQualification(qualification.trim());
        intervieweeVO.setOthersQualification(otherQualification.trim());
        intervieweeVO.setKeySkills(keySkills);
        intervieweeVO.setInterviewStatus(interviewStatus);
        intervieweeVO.setInterviewStatusDate(interviewStatusDate);
        intervieweeVO.setExtraKeySkills(extraKeySkills.trim());
        intervieweeVO.setReceiveCvDate(receiveCvDate);
        intervieweeVO.setRemarks(remarks);

        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.storeIntervieweeInfo(intervieweeVO);
        dynaValidatorForm.set("msg", resultVO.getMessage());
        resultVO = taskAssignmentServicesDaoImpl.intervieweeUtils();
        dynaValidatorForm.set("listOfAcademicQualification", resultVO.getListOfQualification());
        dynaValidatorForm.set("listOfInstitute", resultVO.getListOfUniversity());
        dynaValidatorForm.set("listOfKeySkils", resultVO.getListOfKeySkills());
        dynaValidatorForm.set("listOfProfile", resultVO.getListOfProfile());
        return mapping.findForward(STORE_INTERVIEW_CANDIDATE_INFO);
    }

    public ActionForward viewInterviewCandidateInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        List<IntervieweeVO> listOfInterViewee = taskAssignmentServicesDaoImpl.viewIntervieweeInfo();
        dynaActionForm.set("listOfInterViewee", listOfInterViewee);

        return mapping.findForward(VIEW_INTERVIEWEE_INFO);
    }

    public ActionForward viewIntervieweeEmailIds(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;

        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        StringBuilder intervieweeEmails = taskAssignmentServicesDaoImpl.viewIntervieweeEmailIds();
        dynaActionForm.set("intervieweeEmailIds", intervieweeEmails);

        return mapping.findForward(VIEW_INTERVIEWEE_EMAILS);
    }

    public ActionForward toUpdateInterviewee(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
        String emailId = request.getParameter("emailId").trim();

        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        IntervieweeVO intervieweeVO = taskAssignmentServicesDaoImpl.viewIndividualIntervieweeInfo(emailId);
        dynaValidatorForm.set("name", intervieweeVO.getName());
        dynaValidatorForm.set("contactNo", intervieweeVO.getContactNo());
        dynaValidatorForm.set("emailId", intervieweeVO.getEmailId());
        dynaValidatorForm.set("profileAppliedFor", intervieweeVO.getProfileAppliedFor());
        dynaValidatorForm.set("qualification", intervieweeVO.getQualification());
        dynaValidatorForm.set("keySkills", intervieweeVO.getKeySkills());
        dynaValidatorForm.set("interviewStatus", intervieweeVO.getInterviewStatus());
        dynaValidatorForm.set("callFollowUp", intervieweeVO.getCallFollowUp());
        dynaValidatorForm.set("remarks", intervieweeVO.getRemarks());
        dynaValidatorForm.set("passoutyr", intervieweeVO.getPassoutyr());
        dynaValidatorForm.set("institutename", intervieweeVO.getInstitutename());
        dynaValidatorForm.set("interviewexperience", intervieweeVO.getInterviewexperience());


        return mapping.findForward(TO_UPDATE_INTERVIEWEE);
    }

    public ActionForward updateIntervieweeInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;

        String name = (String) dynaValidatorForm.get("name");
        String contactNo = (String) dynaValidatorForm.get("contactNo");
        String emailId = (String) dynaValidatorForm.get("emailId");
        String profileAppliedFor = (String) dynaValidatorForm.get("profileAppliedFor");
        String qualification = (String) dynaValidatorForm.get("qualification");
        String keySkills[] = (String[]) dynaValidatorForm.get("keySkills");

        String interviewStatus = (String) dynaValidatorForm.get("interviewStatus");
        String callFollowUp = (String) dynaValidatorForm.get("callFollowUp");
        String remarks = (String) dynaValidatorForm.get("remarks");
        String institutename = (String) dynaValidatorForm.get("institutename");
        String passoutyr = (String) dynaValidatorForm.get("passoutyr");
        String interviewexperience = (String) dynaValidatorForm.get("interviewexperience");



        IntervieweeVO intervieweeVO = new IntervieweeVO();
        // intervieweeVO.setAlternateEmailId(emailId);
        intervieweeVO.setName(name);
        intervieweeVO.setPassoutyr(passoutyr);
        intervieweeVO.setInstitutename(institutename);
        intervieweeVO.setContactNo(contactNo);
        intervieweeVO.setEmailId(emailId);
        intervieweeVO.setProfileAppliedFor(profileAppliedFor);
        intervieweeVO.setQualification(qualification);
        intervieweeVO.setKeySkills(keySkills);
        intervieweeVO.setInterviewStatus(interviewStatus);
        intervieweeVO.setCallFollowUp(callFollowUp);
        intervieweeVO.setRemarks(remarks);
        intervieweeVO.setInterviewexperience(interviewexperience);

        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.updateIntervieweeInfo(intervieweeVO);
        request.setAttribute("message", resultVO.getMessage());

        intervieweeVO = taskAssignmentServicesDaoImpl.viewIndividualIntervieweeInfo(emailId);

        dynaValidatorForm.set("name", intervieweeVO.getName());
        dynaValidatorForm.set("contactNo", intervieweeVO.getContactNo());
        dynaValidatorForm.set("emailId", intervieweeVO.getEmailId());
        dynaValidatorForm.set("profileAppliedFor", intervieweeVO.getProfileAppliedFor());
        dynaValidatorForm.set("qualification", intervieweeVO.getQualification());
        dynaValidatorForm.set("keySkills", intervieweeVO.getKeySkills());
        dynaValidatorForm.set("interviewStatus", intervieweeVO.getInterviewStatus());
        dynaValidatorForm.set("callFollowUp", intervieweeVO.getCallFollowUp());
        dynaValidatorForm.set("remarks", intervieweeVO.getRemarks());

        return mapping.findForward(TO_UPDATE_INTERVIEWEE);
    }

    public ActionForward submitNewsReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;

        HttpSession session = request.getSession(true);
        Integer resourceId = (Integer) session.getAttribute("userid");
        String title = (String) dynaActionForm.get("title");
        String date = (String) dynaActionForm.get("date");
        String newsdetails = (String) dynaActionForm.get("newsdetails");

        NewsEventVO newsEventVO = new NewsEventVO();
        newsEventVO.setTitle(title);
        newsEventVO.setDate(date);
        newsEventVO.setNewsdetails(newsdetails);
        newsEventVO.setUserid(resourceId);
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.submitNewsEvent(newsEventVO);

        request.setAttribute("message", resultVO.getMessage());

        return mapping.findForward(SUBMIT_NEWS_REPORT);
    }

    public ActionForward populateLimitedNewsEvent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm dynaActionForm = (DynaActionForm) form;

        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        List<NewsEventVO> listOfNewsAndEvent = taskAssignmentServicesDaoImpl.populateLimitedNewsEvent();
        String interviewScheduleDate= taskAssignmentServicesDaoImpl.populateInterviewScheduleDate();
        dynaActionForm.set("listOfNewsAndEvent", listOfNewsAndEvent);
         dynaActionForm.set("interviewScheduleDate", interviewScheduleDate);
        return mapping.findForward(HOME_PAGE);
    }

    public ActionForward storeEnquiryForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;

        String name = (String) dynaActionForm.get("name");
        String contactNo = (String) dynaActionForm.get("contactNo");
        String altcontactNo = (String) dynaActionForm.get("altcontactNo");
        String emailId = (String) dynaActionForm.get("emailId");

        String qualification = (String) dynaActionForm.get("qualification");

        String remarks = (String) dynaActionForm.get("remarks");

        IntervieweeVO intervieweeVO = new IntervieweeVO();
        // intervieweeVO.setAlternateEmailId(emailId);
        intervieweeVO.setName(name);
        intervieweeVO.setContactNo(contactNo);

        intervieweeVO.setEmailId(emailId);

        intervieweeVO.setQualification(qualification);
        intervieweeVO.setAltcontactNo(altcontactNo);
        intervieweeVO.setRemarks(remarks);
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.storeEnquiryInfo(intervieweeVO);
        request.setAttribute("message", resultVO.getMessage());

        return mapping.findForward(STORE_ENQUIRY_FORM);
    }

    public ActionForward viewEnquiryReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;


        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        List<IntervieweeVO> listOfEnquiry = taskAssignmentServicesDaoImpl.viewEnquiryReport();
        dynaActionForm.set("listOfEnquiry", listOfEnquiry);

        return mapping.findForward(VIEW_ENQUIRY_REPORT);
    }

    public ActionForward storeContactUser(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ResultVO resultVO = new ResultVO();


        ContactUsForm contactUsForm = (ContactUsForm) form;


        String name = contactUsForm.getName();
        String email = contactUsForm.getEmail();
        String company = contactUsForm.getCompany();
        String subject = contactUsForm.getSubject();
        String msg = contactUsForm.getMessage();

        ContactVO contactVO = new ContactVO();

        contactVO.setNewname(name);
        contactVO.setNewemail(email);
        contactVO.setNewcompany(company);
        contactVO.setNewsubject(subject);
        contactVO.setNewmsg(msg);
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        resultVO = taskAssignmentServicesDaoImpl.storeContactUser(contactVO);

        request.setAttribute("resultvo", resultVO);

        return mapping.findForward(STORE_CONTACT_USER);
    }

    public ActionForward populateNewsEvent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        List<NewsEventVO> listOfNewsAndEvent = taskAssignmentServicesDaoImpl.populateNewsEvent();
        dynaActionForm.set("listOfNewsAndEvent", listOfNewsAndEvent);
        return mapping.findForward(MORE_NEWS);
    }

    public ActionForward planStatusReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        HttpSession session = request.getSession(true);
        Integer resourceId = (Integer) session.getAttribute("userid");
        String[] statusReport = (String[]) dynaActionForm.get("planstatusReport");
        for (int i = 0; i < statusReport.length; i++) {
            System.out.println("statusReport" + statusReport[i]);
        }
        StatusReportVO statusReportVO = new StatusReportVO();
        statusReportVO.setPlanStatusReport(statusReport);
        statusReportVO.setResourceId(resourceId);
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.storePlanStatusReport(statusReportVO);

        request.setAttribute("message", resultVO.getMessage());

        return mapping.findForward(PLAN_STATUS_REPORT);
    }

    public ActionForward entrySalary(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ResultVO resultVO = new ResultVO();


        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;



        int employeeId = Integer.parseInt(employeeActionFormBean.getEmployeeId());
        String salary = employeeActionFormBean.getSalary();
        String startingdate = employeeActionFormBean.getStartingdate();
        String endingdate = employeeActionFormBean.getEndingdate();
        String paymentdate = employeeActionFormBean.getPaymentdate();
        String paymenttype = employeeActionFormBean.getPaymenttype();


        SalaryVo salaryVo = new SalaryVo();

        salaryVo.setSalary(salary);
        salaryVo.setStartingdate(startingdate);
        salaryVo.setEndingdate(endingdate);
        salaryVo.setEmployeeId(employeeId);
        salaryVo.setPaymentdate(paymentdate);
        salaryVo.setPaymenttype(paymenttype);

        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        resultVO = taskAssignmentServicesDaoImpl.storeSalarySlip(salaryVo);
        System.out.println("message:" + resultVO.getMessage());
        request.setAttribute("storesalarysheet", resultVO.getMessage());

        return mapping.findForward(ENTRY_SALARY);
    }

    public ActionForward searchSalarySlip(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();

        int employeeId = Integer.parseInt(employeeActionFormBean.getEmployeeId());
        String month = employeeActionFormBean.getMonth();
        SalaryVo salaryVo = new SalaryVo();
        salaryVo.setEmployeeId(employeeId);
        salaryVo.setMonth(month);
        salaryVo = taskAssignmentServicesDaoImpl.populateSalaryInfo(salaryVo);
        if (salaryVo.isIsFlag()) {
            employeeActionFormBean.setName(salaryVo.getName());
            employeeActionFormBean.setSalary(salaryVo.getSalary());
            employeeActionFormBean.setStartingdate(salaryVo.getStartingdate());
            employeeActionFormBean.setEndingdate(salaryVo.getEndingdate());
            employeeActionFormBean.setPaymenttype(salaryVo.getPaymenttype());
            employeeActionFormBean.setPaymentdate(salaryVo.getPaymentdate());

        }
        return mapping.findForward(SEARCH_SALARY_SLIP);
    }

    public ActionForward storeRegTrainee(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ResultVO resultVO = new ResultVO();


        RegTraineeActionForm regTraineeActionForm = (RegTraineeActionForm) form;


        String name = regTraineeActionForm.getName();
        String email = regTraineeActionForm.getEmail();
        String altemail = regTraineeActionForm.getAltemail();
        String phno = regTraineeActionForm.getPhno();
        String altphno = regTraineeActionForm.getAltphno();
        String message = regTraineeActionForm.getMessage();


        RegTraineeVo regTraineeVo = new RegTraineeVo();

        regTraineeVo.setName(name);
        regTraineeVo.setEmail(email);
        regTraineeVo.setAltemail(altemail);
        regTraineeVo.setPhno(phno);
        regTraineeVo.setAltphno(altphno);
        regTraineeVo.setMessage(message);
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        resultVO = taskAssignmentServicesDaoImpl.storeTrainee(regTraineeVo);

        request.setAttribute("resultvo", resultVO);

        return mapping.findForward(STORE_REG_TRAINEE);
    }

    public ActionForward storeUploadCv(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        UploadCvForm uploadBean = (UploadCvForm) form;

        // PROCESS THE FORMFILE
        FormFile myFile = uploadBean.getTheFile();
        String name = uploadBean.getName();
        String email = uploadBean.getEmail();
        String phno = uploadBean.getPhno();
        String experience = uploadBean.getExperience();
        String technology = uploadBean.getTechnology();
        Date d = new Date();
        long date = d.getTime();
        String format = myFile.getContentType();
        System.out.println("File Formatttttt" + format);
        String fileName = email + date + myFile.getFileName();
        if (format.equals("application/msword") || format.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document") || format.equals("application/pdf")) {

            FileUploadVo fileUploadVo = new FileUploadVo();
            fileUploadVo.setFilename(fileName);
            fileUploadVo.setName(name);
            fileUploadVo.setEmail(email);
            fileUploadVo.setExperience(experience);
            fileUploadVo.setPhno(phno);
            fileUploadVo.setTechnology(technology);
            TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
            ResultVO resultVO = taskAssignmentServicesDaoImpl.storeUploadCv(fileUploadVo);
            if (resultVO.getMessage().equalsIgnoreCase("true")) {
                byte[] fileData = myFile.getFileData();
                String filePath = getServlet().getServletContext().getRealPath("/") + "UploadCv";
                File folder = new File(filePath);
                if (!folder.exists()) {
                    folder.mkdir();
                    System.out.println(folder.toString());
                }
                if (!fileName.equals("")) {
                    System.out.println("server path is" + filePath);
                }
                File f = new File(filePath, fileName);

                if (!f.exists()) {
                    FileOutputStream fos = new FileOutputStream(f);
                    fos.write(fileData);
                    fos.flush();
                    fos.close();

                }
                request.setAttribute("filemessage", "File Upload Successfully..We Will Contact With You shortly");
            } else {
                request.setAttribute("filemessage", "File Upload Not Successfully");
            }
        } else {
            request.setAttribute("filemessage", "File Must Be doc/docx/pdf File");
        }


        System.out.println("pathhhhhhhhhhhhhhhhhhhhhhhhh" + request.getAttribute("fileName"));




        return mapping.findForward(STORE_UPLOAD_CV);

    }

    public ActionForward downloadCurriculamVitae(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        String userrole = (String) session.getAttribute("userrole");
        if (userrole.equalsIgnoreCase("HR Manager")) {
            DynaActionForm dynaActionForm = (DynaActionForm) form;

            TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();



            List<FileUploadVo> fileUploadVos = taskAssignmentServicesDaoImpl.downloadCurriculamVitaeService();
            dynaActionForm.set("listOfCv", fileUploadVos);
            return mapping.findForward(DOWNLOAD_CURRICULAM_VITAE);


        } else {
            return mapping.findForward(FAILURE);
        }
        
    }

    

    public ActionForward scheduleInterview(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        String userrole = (String) session.getAttribute("userrole");
        if (userrole.equalsIgnoreCase("HR Manager")) {
            DynaActionForm dynaActionForm = (DynaActionForm) form;

            TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
            StringBuffer dayVal = new StringBuffer();
            Integer day = (Integer) dynaActionForm.get("day");

            if (day.equals(new Integer(1))) {
                dayVal.append("1st");
            } else if (day.equals(new Integer(2))) {
                dayVal.append("2nd");
            } else if (day.equals(new Integer(3))) {
                dayVal.append("3rd");
            } else {
                dayVal.append(day);
                dayVal.append("th");
            }


            String month = dynaActionForm.getString("month");
            String year = dynaActionForm.getString("year");

            dayVal.append(" ");
            dayVal.append(month);
            dayVal.append(",");
            dayVal.append(year);

            ResultVO resultVO = taskAssignmentServicesDaoImpl.scheduleInterview(dayVal.toString());
            
            dynaActionForm.set("message", resultVO.getMessage());
         
        }
        return mapping.findForward(SUCCESS);
    }
}
