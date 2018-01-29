/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.employee.action;

import com.tpcs.admin.hrmgt.vo.LeaveManagementVO;
import com.tpcs.admin.hrmgt.vo.ResultVO;
import com.tpcs.admin.taskmgt.dao.impl.LeaveManagementDaoImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;

/**
 *
 * @author ALOK
 */
public class LeaveManagementAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String APPLY_LEAVE = "applyLeave";


    /**
     * This is the Struts Action method specified in struts-config file using the parameter attribute
     * ( <action parameter="customMethod" .../> )
     */
    public ActionForward applyLeave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;

        HttpSession session = request.getSession(true);
        Integer associateId = (Integer) session.getAttribute("userid");
        if(null != associateId){
        String leaveType = (String) dynaActionForm.getString("leaveType");
        String startDate = (String) dynaActionForm.get("startDate");
        String endDate = (String) dynaActionForm.get("endDate");
        String leaveDuration = (String) dynaActionForm.get("leaveDuration");
        String dayNum = (String) dynaActionForm.get("daysNum");
        String reasonOfLeave = (String) dynaActionForm.get("reasonOfLeave");

        LeaveManagementVO  leaveManagementVO = new LeaveManagementVO();
        leaveManagementVO.setAssociateId(associateId.intValue());
        leaveManagementVO.setLeaveType(leaveType);
        leaveManagementVO.setStartDate(startDate);
        leaveManagementVO.setEndDate(endDate);
        leaveManagementVO.setLeaveDuration(leaveDuration);
        leaveManagementVO.setDayNum(dayNum);
        leaveManagementVO.setReasonOfLeave(reasonOfLeave);
        LeaveManagementDaoImpl leaveManagementDaoImpl = new LeaveManagementDaoImpl();
        ResultVO resultVO = leaveManagementDaoImpl.storeLeave(leaveManagementVO); 
        
        request.setAttribute("message", resultVO.getMessage());        
        }else{
            request.setAttribute("message", " Leave Submit Unsuccessful.");
        }
        return mapping.findForward(APPLY_LEAVE);
    }
}
