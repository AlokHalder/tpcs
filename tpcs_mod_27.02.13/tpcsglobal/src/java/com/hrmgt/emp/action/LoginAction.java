package com.hrmgt.emp.action;

import com.hrmgt.emp.formbean.LoginActionForm;
import com.tpcs.admin.hrmgt.model.UserLoginModel;
import com.tpcs.admin.hrmgt.vo.UserProfileVO;
import com.tpcs.employeeinfo.vo.EmployeeLoginVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

public class LoginAction extends MappingDispatchAction {

    private final static String SUCCESS = "success";
    private final static String FAILURE = "failure";
    /*
     * This method modyfied(userLogin)by
     * @TPCP_PL Chandan 109.(14.06.2013)
     */

    public ActionForward userLogin(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        LoginActionForm loginActionForm = (LoginActionForm) form;
        EmployeeLoginVO loginVO = new EmployeeLoginVO();
        loginVO.setEmploueeId(Integer.parseInt(loginActionForm.getUserid()));
        loginVO.setLoginPassword(loginActionForm.getPassword());
        UserLoginModel loginModel = new UserLoginModel();
        UserProfileVO userProfileVO = loginModel.userCredential(loginVO);
        if (userProfileVO.isUserFlag() == true) {
            HttpSession session = request.getSession();
            session.setAttribute("username", userProfileVO.getUserName());
            session.setAttribute("userid", userProfileVO.getUserId());
            session.setAttribute("passowrd", userProfileVO.getPassword());
            session.setAttribute("userrole", userProfileVO.getUserRoleName());
            return mapping.findForward(SUCCESS);
        } else {
            loginActionForm.setLoginMsg(userProfileVO.getMessage());
            return mapping.findForward(FAILURE);
        }
    }

    public ActionForward userLogout(
            ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        session.removeAttribute("userid");
        session.removeAttribute("passowrd");
        session.removeAttribute("userrole");
        session.invalidate();
        return mapping.findForward(SUCCESS);
    }
}
