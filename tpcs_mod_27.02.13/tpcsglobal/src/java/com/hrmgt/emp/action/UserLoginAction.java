package com.hrmgt.emp.action;

import com.hrmgt.emp.formbean.UserLoginFormBean;
import com.tpcs.admin.hrmgt.model.UserLoginModel;
import com.tpcs.admin.hrmgt.vo.AttendanceReportVO;
import com.tpcs.admin.hrmgt.vo.EmployeeProfileVO;
import com.tpcs.admin.hrmgt.vo.ResultVO;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class UserLoginAction extends org.apache.struts.actions.MappingDispatchAction {

    /* forward name="success" path="" */
    //private static final String SUCCESS = "success";
    private static final String OFFICEIN = "officein";
    private static final String POSTIN = "postin";
    private static final String CLOSE = "close";
    private static final String POSTCLOSE = "postclose";
    private static final String USERENTRY = "userentry";
    private static final String POSTUSERENTRY = "postuserentry";
    private static final String VIEWDATA = "viewdata";
    private static final String OFFICE_ATTENDANCE_REPORT="office-attendance-report";

    public ActionForward officein(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println(" I am office in");

        return mapping.findForward(OFFICEIN);
    }

    public ActionForward postin(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserLoginModel userLoginModel = new UserLoginModel();       
       HttpSession session = request.getSession(true);
       Integer resourceId = (Integer) session.getAttribute("userid");
        
        //   userLoginVO.setJoiningdate(userLoginFormBean.getJoiningdate());
        ResultVO resultVO = userLoginModel.postTime(resourceId.intValue());
             //EmailService emailService = new EmailService();
        //emailService.emailSend();

        String message = resultVO.getMessage();

        request.setAttribute("message", message);


        return mapping.findForward(POSTIN);
    }

    public ActionForward close(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
System.out.println(" I am office in");


        return mapping.findForward(CLOSE);
    }

    public ActionForward postclose(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //UserLoginFormBean userLoginFormBean=(UserLoginFormBean)form;

        UserLoginModel userLoginModel = new UserLoginModel();
        HttpSession session = request.getSession(true);
       Integer empId = (Integer) session.getAttribute("userid");
       
        ResultVO resultVO = userLoginModel.closeTime(empId.intValue());
        
        //EmailService emailService = new EmailService();
        //emailService.emailSend();

        String message = resultVO.getMessage();

        request.setAttribute("message", message);


        return mapping.findForward(POSTCLOSE);
    }

    public ActionForward userentry(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        return mapping.findForward(USERENTRY);
    }

    public ActionForward postuserentry(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserLoginFormBean userLoginFormBean = (UserLoginFormBean) form;
        UserLoginModel userLoginModel = new UserLoginModel();

        EmployeeProfileVO employeeProfileVO = new EmployeeProfileVO();
        employeeProfileVO.setUserid(userLoginFormBean.getUserid());
        employeeProfileVO.setPassword(userLoginFormBean.getPassword());
        employeeProfileVO.setName(userLoginFormBean.getName());
        employeeProfileVO.setJoiningDate(userLoginFormBean.getJoiningdate());
        employeeProfileVO.setDateOfBirth(userLoginFormBean.getDateofbirth());
        employeeProfileVO.setDesignation(userLoginFormBean.getDesignation());
        employeeProfileVO.setHigherQualification(userLoginFormBean.getHigherqualification());
        //userLoginVO.setYearofpassout(userLoginFormBean.getYearofpassout());
        employeeProfileVO.setSpecilization(userLoginFormBean.getSpecilization());
        employeeProfileVO.setAddress(userLoginFormBean.getEmpaddress());
        employeeProfileVO.setZipCode(userLoginFormBean.getEmpzipcode());
        employeeProfileVO.setContactNumber(userLoginFormBean.getEmpcontactnumber());
        employeeProfileVO.setEmailId(userLoginFormBean.getEmpemailid());
        if (employeeProfileVO == null) {
            System.out.println("no data found");

        }

        userLoginModel.userentry(employeeProfileVO);

        return mapping.findForward(POSTUSERENTRY);
    }

    public ActionForward viewdata(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //UserLoginFormBean userLoginFormBean = (UserLoginFormBean)form;
        UserLoginModel userLoginModel = new UserLoginModel();
        String userid = "";
        String name = "";

      /*  try {
            List<EmployeeProfileVO> listoflogindata = userLoginModel.viewLoginData(userid, name);
            request.setAttribute("message", listoflogindata);
        } catch (Exception exception) {
            System.out.println("exception" + exception);
        }*/

        return mapping.findForward(VIEWDATA);
    }
    
    public ActionForward officeAttendanceReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //UserLoginFormBean userLoginFormBean=(UserLoginFormBean)form;

        UserLoginModel userLoginModel = new UserLoginModel();
        HttpSession session = request.getSession(true);
       Integer empId = (Integer) session.getAttribute("userid");
       
       List<AttendanceReportVO> listOfAttendanceReport = userLoginModel.officeAttendanceReport(empId.intValue());
        
        DynaActionForm dynaActionForm = (DynaActionForm)form;
        dynaActionForm.set("listOfAttendanceReport",listOfAttendanceReport );
      


        return mapping.findForward(OFFICE_ATTENDANCE_REPORT);
    }
    
}
