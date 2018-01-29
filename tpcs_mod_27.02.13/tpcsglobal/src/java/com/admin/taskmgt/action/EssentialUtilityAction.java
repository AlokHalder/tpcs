package com.admin.taskmgt.action;

import com.tpcs.admin.taskmgt.dao.impl.EssentialUtilityService;
import com.tpcs.admin.taskmgt.dao.impl.LovServicesDaoImpl;
import com.tpcs.admin.taskmgt.vo.JobpoolVO;
import com.tpcs.admin.taskmgt.vo.ListOfValuesVO;
import com.tpcs.admin.taskmgt.vo.ResultVO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.validator.DynaValidatorForm;

/**
 * @author TPCS_PL Chandan 109 
 * @author TPCS_SD Sameep 134.
 */
public class EssentialUtilityAction extends MappingDispatchAction {

    private final static String SUCCESS = "success";

    public ActionForward createNewJob(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm jobpoolActionForm = (DynaValidatorForm) form;
        String jobDescription = (String) jobpoolActionForm.get("jobDescription");
        String jobUrgency = (String) jobpoolActionForm.get("jobUrgency");
        JobpoolVO jobpoolVO = new JobpoolVO();
        HttpSession session = request.getSession();
        jobpoolVO.setEmpId(session.getAttribute("userid").toString());
        jobpoolVO.setJobStatus("P");
        jobpoolVO.setJobDescription(jobDescription);
        jobpoolVO.setJobUrgency(jobUrgency);
        EssentialUtilityService essentialUtilityService = new EssentialUtilityService();
        ResultVO resultVO = essentialUtilityService.addJob(jobpoolVO);
        jobpoolActionForm.set("message", resultVO.getMessage());
        return mapping.findForward(SUCCESS);
    }

    public ActionForward pendingJob(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm jobpoolActionForm = (DynaValidatorForm) form;
        EssentialUtilityService essentialUtilityService = new EssentialUtilityService();
        ResultVO resultVO = essentialUtilityService.ListOfJob();
        jobpoolActionForm.set("listOfJobs", resultVO.getJobList());
        return mapping.findForward(SUCCESS);
    }

    public ActionForward searchSingleJobDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm jobpoolActionForm = (DynaValidatorForm) form;
        JobpoolVO jobId = new JobpoolVO();
        jobId.setJobId(request.getParameter("jobId"));
        EssentialUtilityService essentialUtilityService = new EssentialUtilityService();
        JobpoolVO jobpoolVO = essentialUtilityService.jobSearch(jobId);
        jobpoolActionForm.set("jobId", jobpoolVO.getJobId());
        jobpoolActionForm.set("jobDescription", jobpoolVO.getJobDescription());
        jobpoolActionForm.set("empName", jobpoolVO.getEmpName());
        jobpoolActionForm.set("empId", jobpoolVO.getEmpId());
        jobpoolActionForm.set("jobCreationDate", jobpoolVO.getJobCreationDate());
        jobpoolActionForm.set("jobStatus", jobpoolVO.getJobStatus());
        jobpoolActionForm.set("jobUrgency", jobpoolVO.getJobUrgency());
        LovServicesDaoImpl lovServicesDaoImpl = new LovServicesDaoImpl();
        List<ListOfValuesVO> listOfUserProfile = lovServicesDaoImpl.populateUserProfileList();
        List<ListOfValuesVO> listOfTaskCategory = lovServicesDaoImpl.populateTaskCategoryList();
        List<ListOfValuesVO> listOfTask = lovServicesDaoImpl.populateTaskList();
        jobpoolActionForm.set("listOfUserProfile", listOfUserProfile);
        jobpoolActionForm.set("listOfTaskCategory", listOfTaskCategory);
        jobpoolActionForm.set("listOfTask", listOfTask);
        return mapping.findForward(SUCCESS);
    }

    public ActionForward jobAssignTo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm jobpoolActionForm = (DynaValidatorForm) form;
        HttpSession session = request.getSession(true);
        Integer assignedByResourceId = (Integer) session.getAttribute("userid");
        JobpoolVO jobpoolVO = new JobpoolVO();
        jobpoolVO.setAssignedByResourceId(assignedByResourceId);
        jobpoolVO.setEmpId((String) jobpoolActionForm.get("empId"));
        jobpoolVO.setJobId((String) jobpoolActionForm.get("jobId"));
        jobpoolVO.setJobDescription((String) jobpoolActionForm.get("jobDescription"));
        jobpoolVO.setJobUrgency((String) jobpoolActionForm.get("jobUrgency"));
        String taskCategoryId = (String) jobpoolActionForm.getString("taskCategoryId");
        String projectId = (String) jobpoolActionForm.get("projectId");
        String targetDate = (String) jobpoolActionForm.get("targetDate");
        String statusId = (String) jobpoolActionForm.get("statusId");
        jobpoolVO.setJobStatus("P");
        jobpoolVO.setProjectId(projectId);
        jobpoolVO.setTaskStatusId(statusId);
        jobpoolVO.setTaskTargetDate(targetDate);
        jobpoolVO.setTaskCategoryId(taskCategoryId);
        EssentialUtilityService essentialUtilityService = new EssentialUtilityService();
        ResultVO resultVO = essentialUtilityService.jobAssignTo(jobpoolVO);
        jobpoolActionForm.set("message", resultVO.getMessage());
        jobpoolActionForm.set("listOfJobs", essentialUtilityService.ListOfJob().getJobList());
        LovServicesDaoImpl lovServicesDaoImpl = new LovServicesDaoImpl();
        List<ListOfValuesVO> listOfUserProfile = lovServicesDaoImpl.populateUserProfileList();
        List<ListOfValuesVO> listOfTaskCategory = lovServicesDaoImpl.populateTaskCategoryList();
        List<ListOfValuesVO> listOfTask = lovServicesDaoImpl.populateTaskList();
        jobpoolActionForm.set("listOfUserProfile", listOfUserProfile);
        jobpoolActionForm.set("listOfTaskCategory", listOfTaskCategory);
        jobpoolActionForm.set("listOfTask", listOfTask);
        jobpoolActionForm.set("jobStatus", essentialUtilityService.jobSearch(jobpoolVO).getJobStatus());
        return mapping.findForward(SUCCESS);
    }

    public ActionForward jobAssignDetailsSearch(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm jobpoolActionForm = (DynaValidatorForm) form;
        JobpoolVO jobId = new JobpoolVO();
        jobId.setJobId(request.getParameter("jobId"));
        EssentialUtilityService essentialUtilityService = new EssentialUtilityService();
        JobpoolVO jobpoolVO = essentialUtilityService.searchAssingDetails(jobId);
        jobpoolActionForm.set("jobId", jobId.getJobId());
        jobpoolActionForm.set("empName", jobpoolVO.getEmpName());
        jobpoolActionForm.set("jobUrgency", jobpoolVO.getJobUrgency());
        jobpoolActionForm.set("jobCreationDate", jobpoolVO.getJobCreationDate());
        return mapping.findForward(SUCCESS);
    }
}
