package com.admin.taskmgt.action;

import com.tpcs.admin.hrmgt.vo.IntervieweeVO;
import com.tpcs.admin.taskmgt.vo.ResultVO;
import com.tpcs.admin.taskmgt.dao.impl.TaskAssignmentServicesDaoImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.validator.DynaValidatorForm;

/**
 *
 * @author TPCS_PL Chandan 109
 */
public class TalentAcquisitionAction extends MappingDispatchAction {

    private final static String SUCCESS = "success";
    private HttpSession session = null;

    public ActionForward toCallFollowUp(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
        int intervieweeSlNo = (Integer) dynaValidatorForm.get("intervieweeSlNo");
        session = request.getSession();
        session.setAttribute("intervieweeSlNo", intervieweeSlNo);
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        IntervieweeVO intervieweeVO = taskAssignmentServicesDaoImpl.viewIndividualIntervieweeWorkFlowStatus(intervieweeSlNo);
        session.setAttribute("intervieweeDetails", intervieweeVO);
        dynaValidatorForm.set("intervieweeSlNo", intervieweeVO.getIntervieweeSlNo());
        dynaValidatorForm.set("name", intervieweeVO.getName());
        dynaValidatorForm.set("contactNo", intervieweeVO.getContactNo());
        dynaValidatorForm.set("emailId", intervieweeVO.getEmailId());
        dynaValidatorForm.set("alternateEmailId", intervieweeVO.getAlternateEmailId());
        dynaValidatorForm.set("profileAppliedFor", intervieweeVO.getProfileAppliedFor());
        dynaValidatorForm.set("qualification", intervieweeVO.getQualification());
        dynaValidatorForm.set("ohterKeySkills", intervieweeVO.getOhterKeySkills());
        dynaValidatorForm.set("interviewStatus", intervieweeVO.getInterviewStatus());
        dynaValidatorForm.set("receivedate", intervieweeVO.getReceiveDate());
        dynaValidatorForm.set("intervieweeExperience", intervieweeVO.getInterviewexperience());
        dynaValidatorForm.set("instituteName", intervieweeVO.getInterviewUniversity());
        dynaValidatorForm.set("passoutyr", intervieweeVO.getPassoutyr());
        dynaValidatorForm.set("interviewStatus", intervieweeVO.getInterviewStatus());
        dynaValidatorForm.set("interviewStatusDate", intervieweeVO.getInterviewStatusDate());
        dynaValidatorForm.set("listOfWorkFlow", intervieweeVO.getListOfWorkFlow());
        dynaValidatorForm.set("intervieweeStoreDate", intervieweeVO.getIntervieweeStoreDate());
        dynaValidatorForm.set("remarks", intervieweeVO.getRemarks());

        return mapping.findForward(SUCCESS);
    }

    public ActionForward toAddCallFollowUp(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
        // int intervieweeSlNo = (Integer) dynaValidatorForm.get("intervieweeSlNo");
        session = request.getSession();
        IntervieweeVO intervieweeVO = (IntervieweeVO) session.getAttribute("intervieweeDetails");
        dynaValidatorForm.set("intervieweeSlNo", intervieweeVO.getIntervieweeSlNo());
        dynaValidatorForm.set("name", intervieweeVO.getName());
        dynaValidatorForm.set("contactNo", intervieweeVO.getContactNo());
        dynaValidatorForm.set("emailId", intervieweeVO.getEmailId());
        dynaValidatorForm.set("alternateEmailId", intervieweeVO.getAlternateEmailId());
        dynaValidatorForm.set("profileAppliedFor", intervieweeVO.getProfileAppliedFor());
        dynaValidatorForm.set("qualification", intervieweeVO.getQualification());
        dynaValidatorForm.set("ohterKeySkills", intervieweeVO.getOhterKeySkills());
        dynaValidatorForm.set("interviewStatus", intervieweeVO.getInterviewStatus());
        dynaValidatorForm.set("receivedate", intervieweeVO.getReceiveDate());
        dynaValidatorForm.set("intervieweeExperience", intervieweeVO.getInterviewexperience());
        dynaValidatorForm.set("instituteName", intervieweeVO.getInterviewUniversity());
        dynaValidatorForm.set("passoutyr", intervieweeVO.getPassoutyr());
        dynaValidatorForm.set("interviewStatus", intervieweeVO.getInterviewStatus());
        dynaValidatorForm.set("interviewStatusDate", intervieweeVO.getInterviewStatusDate());
        dynaValidatorForm.set("intervieweeStoreDate", intervieweeVO.getIntervieweeStoreDate());
        dynaValidatorForm.set("listOfWorkFlow", intervieweeVO.getListOfWorkFlow());
        dynaValidatorForm.set("remarks", intervieweeVO.getRemarks());
        return mapping.findForward(SUCCESS);
    }

    public ActionForward addCallFollowUp(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
        int intervieweeSlNo = (Integer) session.getAttribute("intervieweeSlNo");
        String emplouttRole = (String) session.getAttribute("userrole");
        String employeeName = (String) session.getAttribute("username");
        String employeeId = String.valueOf((Integer) session.getAttribute("userid"));
        IntervieweeVO intervieweeVO = new IntervieweeVO();
        intervieweeVO.setIntervieweeSlNo(intervieweeSlNo);
        intervieweeVO.setEmpId(employeeId);
        intervieweeVO.setEmpName(employeeName);
        intervieweeVO.setEmpRole(emplouttRole);
        intervieweeVO.setCallFollowUp(dynaValidatorForm.get("callFollowUp").toString());
        intervieweeVO.setRemarks(dynaValidatorForm.get("remarks").toString());
        intervieweeVO.setInterviewStatus(dynaValidatorForm.get("status").toString());
        TaskAssignmentServicesDaoImpl taskAssignmentServicesDaoImpl = new TaskAssignmentServicesDaoImpl();
        ResultVO resultVO = taskAssignmentServicesDaoImpl.addCallFollowUpOfInterview(intervieweeVO);
        dynaValidatorForm.set("msg", resultVO.getMessage());

        intervieweeVO = taskAssignmentServicesDaoImpl.viewIndividualIntervieweeWorkFlowStatus(intervieweeSlNo);
        dynaValidatorForm.set("intervieweeSlNo", intervieweeVO.getIntervieweeSlNo());
        dynaValidatorForm.set("name", intervieweeVO.getName());
        dynaValidatorForm.set("contactNo", intervieweeVO.getContactNo());
        dynaValidatorForm.set("emailId", intervieweeVO.getEmailId());
        dynaValidatorForm.set("alternateEmailId", intervieweeVO.getAlternateEmailId());
        dynaValidatorForm.set("profileAppliedFor", intervieweeVO.getProfileAppliedFor());
        dynaValidatorForm.set("qualification", intervieweeVO.getQualification());
        dynaValidatorForm.set("ohterKeySkills", intervieweeVO.getOhterKeySkills());
        dynaValidatorForm.set("interviewStatus", intervieweeVO.getInterviewStatus());
        dynaValidatorForm.set("receivedate", intervieweeVO.getReceiveDate());
        dynaValidatorForm.set("intervieweeExperience", intervieweeVO.getInterviewexperience());
        dynaValidatorForm.set("instituteName", intervieweeVO.getInterviewUniversity());
        dynaValidatorForm.set("passoutyr", intervieweeVO.getPassoutyr());
        dynaValidatorForm.set("interviewStatus", intervieweeVO.getInterviewStatus());
        dynaValidatorForm.set("interviewStatusDate", intervieweeVO.getInterviewStatusDate());
        dynaValidatorForm.set("intervieweeStoreDate", intervieweeVO.getIntervieweeStoreDate());
        dynaValidatorForm.set("remarks", intervieweeVO.getRemarks());
        dynaValidatorForm.set("listOfWorkFlow", intervieweeVO.getListOfWorkFlow());
        return mapping.findForward(SUCCESS);
    }
}
