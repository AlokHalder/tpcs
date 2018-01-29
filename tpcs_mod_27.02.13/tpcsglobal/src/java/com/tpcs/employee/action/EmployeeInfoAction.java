/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpcs.employee.action;

import com.tpcs.admin.taskmgt.dao.impl.LovServicesDaoImpl;
import com.tpcs.admin.taskmgt.vo.ListOfValuesVO;
import com.tpcs.admin.taskmgt.vo.StatusReportVO;
import com.tpcs.employee.formbean.EmployeeActionFormBean;
import com.tpcs.employeeinfo.dao.impl.EmployeeInformationServicesDaoImpl;
import com.tpcs.employeeinfo.vo.EmployeeInfoVO;
import com.tpcs.employeeinfo.vo.ResultVO;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.actions.MappingDispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.validator.DynaValidatorActionForm;
import org.apache.struts.validator.DynaValidatorForm;

/**
 *
 * @author Administrator
 */
public class EmployeeInfoAction extends MappingDispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String SEARCH_BY_NAME = "searchbyname";
    private final static String FAILURE = "failure";
    private final static String INSERT_EMP_ACTION = "insertEmpAction";
    private final static String INSERT_USER_PROF_ACTION = "insertUserProfAction";
    private final static String INSER_USER_PERS_ACTION = "insertUserPersAction";
    private final static String INSER_USER_EDU_ACTION = "insertUserEduAction";
    private final static String INSERT_USER_OFFI_DET_ACTION = "insertUserOffiDetAction";
    private final static String PASSWORD_MANAGE_ACTION = "passwordManageAction";
    private final static String VIEW_EMPLOYEE_EMAILS = "viewEmployeeEmails";
    private final static String FAILURE_STATUS = "failureStatus";

    /**
     * This is the Struts Action method specified in struts-config file using
     * the parameter attribute ( <action parameter="customMethod" .../> )
     */
    public ActionForward storeEmpRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;

        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();


        String name = employeeActionFormBean.getName();
        String address = employeeActionFormBean.getAddress();
        String dateofbirth = employeeActionFormBean.getDateofbirth();
        String maritalstatus = employeeActionFormBean.getMaritalstatus();
        String dateofjoining = employeeActionFormBean.getDateofjoining();
        String grade = employeeActionFormBean.getGrade();
        String deputedlocation = employeeActionFormBean.getDeputedlocation();
        String employeetype = employeeActionFormBean.getEmployeetype();
        String gender = employeeActionFormBean.getGender();
        String nationality = employeeActionFormBean.getNationality();
        String designation = employeeActionFormBean.getDesignation();
        String employmentstatus = employeeActionFormBean.getEmploymentstatus();
        String emailid = employeeActionFormBean.getEmailid();
        String city = employeeActionFormBean.getCity();
        String pin = employeeActionFormBean.getPin();
        String phone = employeeActionFormBean.getPhone();

        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();

        employeeInfoVO.setName(name);
        employeeInfoVO.setAddress(address);
        employeeInfoVO.setDateofbirth(dateofbirth);
        employeeInfoVO.setMaritalstatus(maritalstatus);
        employeeInfoVO.setDateofjoining(dateofjoining);
        employeeInfoVO.setGrade(grade);
        employeeInfoVO.setDeputedlocation(deputedlocation);
        employeeInfoVO.setEmployeetype(employeetype);
        employeeInfoVO.setGender(gender);
        employeeInfoVO.setNationality(nationality);
        employeeInfoVO.setDesignation(designation);
        employeeInfoVO.setEmploymentstatus(employmentstatus);
        employeeInfoVO.setEmailid(emailid);
        employeeInfoVO.setCity(city);
        employeeInfoVO.setPin(pin);
        employeeInfoVO.setPhone(phone);
        ResultVO resultVO = employeeInformationServicesDaoImpl.storeEmployeeInfo(employeeInfoVO);
        System.out.println(" Message :  " + resultVO.getMessage());
        request.setAttribute("message", resultVO.getMessage());
        //setting the employee_id
        request.setAttribute("Employee_id", resultVO.getEmployeeId());

        return mapping.findForward(SUCCESS);
    }

    public ActionForward viewEmpRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        System.out.println("employeeActionFormBean.getData()aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+employeeActionFormBean.getData());
        if (null != employeeActionFormBean.getData()) {
            String data = employeeActionFormBean.getData();
            Pattern pattern = Pattern.compile("[a-zA-Z]");
            Matcher matcher = pattern.matcher(data);
            if (matcher.find()) {
                String name = employeeActionFormBean.getData();
                System.out.println("naaaaaaaaaaaaaaaaaaaaaaaaaam" + name);
                List<EmployeeInfoVO> listOfEmployee = employeeInformationServicesDaoImpl.viewEmployeeInfoByName(name);
                employeeActionFormBean.setListOfEmployee(listOfEmployee);
                return mapping.findForward(SEARCH_BY_NAME);


            } else {
                String employeeId = null;
                employeeId = employeeActionFormBean.getData();
                System.out.println("emplooooooooooooooooooooooooooyee iddddddddd" + employeeActionFormBean.getEmployeeId());
                EmployeeInfoVO employeeInfoVO = employeeInformationServicesDaoImpl.populateEmployeeInfo(employeeId);
                employeeActionFormBean.setEmployeeId(employeeInfoVO.getEmployeeId());
                employeeActionFormBean.setAddress(employeeInfoVO.getAddress());
                employeeActionFormBean.setCity(employeeInfoVO.getCity());
                employeeActionFormBean.setPin(employeeInfoVO.getPin());
                employeeActionFormBean.setPhone(employeeInfoVO.getPhone());
                employeeActionFormBean.setName(employeeInfoVO.getName());
                employeeActionFormBean.setDesignation(employeeInfoVO.getDesignation());
                employeeActionFormBean.setEmailid(employeeInfoVO.getEmailid());
                employeeActionFormBean.setSupervisorId(employeeInfoVO.getSupervisorId());
                employeeActionFormBean.setSupervisorName(employeeInfoVO.getSupervisorName());
                employeeActionFormBean.setParentIouName(employeeInfoVO.getParentIouName());
                employeeActionFormBean.setSubIouName(employeeInfoVO.getSubIouName());
                employeeActionFormBean.setDateofjoining(employeeInfoVO.getDateofjoining());
                employeeActionFormBean.setProfileStatus(employeeInfoVO.getProfileStatus());
                employeeActionFormBean.setBaselocation(employeeInfoVO.getBaselocation());
                employeeActionFormBean.setDeputedlocation(employeeInfoVO.getDeputedlocation());
                employeeActionFormBean.setEmployeetype(employeeInfoVO.getEmployeetype());



                return mapping.findForward(SUCCESS);
            }
        } else {
            request.setAttribute("message_failure", "Please Enter The Data ");
            return mapping.findForward(FAILURE);
        }


    }

    public ActionForward myProfileRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();

        int employeeId;

        HttpSession session = request.getSession(true);
        employeeId = (Integer) session.getAttribute("userid");

        EmployeeInfoVO employeeInfoVO = employeeInformationServicesDaoImpl.populateMyEmployeeInfo(employeeId);
        employeeActionFormBean.setEmployeeId(employeeInfoVO.getEmployeeId());
        employeeActionFormBean.setAddress(employeeInfoVO.getAddress());
        employeeActionFormBean.setCity(employeeInfoVO.getCity());
        employeeActionFormBean.setPin(employeeInfoVO.getPin());
        employeeActionFormBean.setPhone(employeeInfoVO.getPhone());
        employeeActionFormBean.setName(employeeInfoVO.getName());
        employeeActionFormBean.setDesignation(employeeInfoVO.getDesignation());
        employeeActionFormBean.setEmailid(employeeInfoVO.getEmailid());
        employeeActionFormBean.setSupervisorId(employeeInfoVO.getSupervisorId());
        employeeActionFormBean.setSupervisorName(employeeInfoVO.getSupervisorName());
        employeeActionFormBean.setParentIouName(employeeInfoVO.getParentIouName());
        employeeActionFormBean.setSubIouName(employeeInfoVO.getSubIouName());
        employeeActionFormBean.setDateofjoining(employeeInfoVO.getDateofjoining());
        employeeActionFormBean.setProfileStatus(employeeInfoVO.getProfileStatus());
        employeeActionFormBean.setBaselocation(employeeInfoVO.getBaselocation());
        employeeActionFormBean.setDeputedlocation(employeeInfoVO.getDeputedlocation());
        employeeActionFormBean.setEmployeetype(employeeInfoVO.getEmployeetype());


        return mapping.findForward(SUCCESS);
    }

    public ActionForward viewAllEmpRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        List<EmployeeInfoVO> listOfEmployee = employeeInformationServicesDaoImpl.viewAllEmployeeInfo();

        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        employeeActionFormBean.setListOfEmployee(listOfEmployee);
        return mapping.findForward(SUCCESS);
    }

    public ActionForward deleteEmpRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();

        String employeeId = null;

        if (null != request.getParameter("employeeId")) {
            employeeId = request.getParameter("employeeId");
        }
        if (null != employeeActionFormBean.getEmployeeId()) {
            employeeId = employeeActionFormBean.getEmployeeId();
        }
        if (null != employeeId) {
            ResultVO resultVO = employeeInformationServicesDaoImpl.deleteEmployeeInfo(employeeId);



            List<EmployeeInfoVO> listOfEmployee = employeeInformationServicesDaoImpl.viewAllEmployeeInfo();
            employeeActionFormBean.setListOfEmployee(listOfEmployee);

            request.setAttribute("message", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }

    public ActionForward modifyEmpInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();

        String employeeId = null;

        if (null != request.getParameter("employeeId")) {
            employeeId = request.getParameter("employeeId");
        }
        if (null != employeeActionFormBean.getEmployeeId()) {
            employeeId = employeeActionFormBean.getEmployeeId();
        }
        if (null != employeeId) {
            EmployeeInfoVO employeeInfoVO = employeeInformationServicesDaoImpl.populateEmployeeInfo(employeeId);
            employeeActionFormBean.setEmployeeId(employeeInfoVO.getEmployeeId());
            employeeActionFormBean.setAddress(employeeInfoVO.getAddress());
            employeeActionFormBean.setCity(employeeInfoVO.getCity());
            employeeActionFormBean.setPin(employeeInfoVO.getPin());
            employeeActionFormBean.setName(employeeInfoVO.getName());
            employeeActionFormBean.setPhone(employeeInfoVO.getPhone());
        }
        return mapping.findForward(SUCCESS);
    }

    public ActionForward modifyEmployeeRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        String employeeId = employeeActionFormBean.getEmployeeId();
        String name = employeeActionFormBean.getName();
        String address = employeeActionFormBean.getAddress();
        String city = employeeActionFormBean.getCity();
        String pin = employeeActionFormBean.getPin();
        String phone = employeeActionFormBean.getPhone();

        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setEmployeeId(employeeId);
        employeeInfoVO.setName(name);
        employeeInfoVO.setAddress(address);
        employeeInfoVO.setCity(city);
        employeeInfoVO.setPin(pin);
        employeeInfoVO.setPhone(phone);

        employeeInfoVO = employeeInformationServicesDaoImpl.modifyEmployeeInfo(employeeInfoVO);
        List<EmployeeInfoVO> listOfEmployee = employeeInformationServicesDaoImpl.viewAllEmployeeInfo();

        employeeActionFormBean.setListOfEmployee(listOfEmployee);


        return mapping.findForward(SUCCESS);
    }

    public ActionForward storeCallRecord(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;

        String callingperson = employeeActionFormBean.getCallingperson();
        String phoneno = employeeActionFormBean.getPhoneno();
        String callingpurpose = employeeActionFormBean.getCallingpurpose();
        String followuplevel = employeeActionFormBean.getFollowuplevel();
        String status = employeeActionFormBean.getStatus();

        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();

        employeeInfoVO.setCallingperson(callingperson);
        employeeInfoVO.setPhoneno(phoneno);
        employeeInfoVO.setCallingpurpose(callingpurpose);
        employeeInfoVO.setFollowuplevel(followuplevel);
        employeeInfoVO.setStatus(status);

        //  ResultVO resultVO = employeeInformationServicesDaoImpl.storeCallInfo(employeeInfoVO);
        //  System.out.println(" Message :  " + resultVO.getMessage());
        //  request.setAttribute("message", resultVO.getMessage());
        return mapping.findForward(SUCCESS);
    }

    public ActionForward insertEmpAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LovServicesDaoImpl lovServicesDaoImpl = new LovServicesDaoImpl();
        List<ListOfValuesVO> listOfLocationProfile = lovServicesDaoImpl.populateLocationList();
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        dynaActionForm.set("listOfLocationProfile", listOfLocationProfile);
        List<ListOfValuesVO> listOfGradeProfile = lovServicesDaoImpl.populateGradeList();
        dynaActionForm.set("listOfGradeProfile", listOfGradeProfile);

        List<ListOfValuesVO> listOfDesignation = lovServicesDaoImpl.populateDesignationList();
        dynaActionForm.set("listOfDesignation", listOfDesignation);
        return mapping.findForward(INSERT_EMP_ACTION);
    }

    public ActionForward insertUserProfAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        String userrole = (String) session.getAttribute("userrole");
        if (userrole.equalsIgnoreCase("HR Manager")) {

            LovServicesDaoImpl lovServicesDaoImpl = new LovServicesDaoImpl();
            DynaActionForm dynaActionForm = (DynaActionForm) form;
            List<ListOfValuesVO> listOfDesignation = lovServicesDaoImpl.populateDesignationList();
            dynaActionForm.set("listOfDesignation", listOfDesignation);
            return mapping.findForward(INSERT_USER_PROF_ACTION);
        } else {
            return mapping.findForward(FAILURE);
        }
    }

    public ActionForward insertUserPersAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LovServicesDaoImpl lovServicesDaoImpl = new LovServicesDaoImpl();
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        List<ListOfValuesVO> listOfLocation = lovServicesDaoImpl.populateLocationList();
        dynaActionForm.set("listOfLocation", listOfLocation);
        List<ListOfValuesVO> listOfCountry = lovServicesDaoImpl.populateCountryList();
        dynaActionForm.set("listOfCountry", listOfCountry);
        return mapping.findForward(INSER_USER_PERS_ACTION);
    }

    public ActionForward insertUserProfileAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        String employeeid = employeeActionFormBean.getEmployeeId();
        String name = employeeActionFormBean.getName();
        String password = employeeActionFormBean.getPassword();
        String designation = employeeActionFormBean.getDesignation();
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setEmployeeId(employeeid);
        employeeInfoVO.setName(name);
        employeeInfoVO.setPassword(password);
        employeeInfoVO.setDesignation(designation);
        ResultVO resultVO = employeeInformationServicesDaoImpl.insertUserProfileAction(employeeInfoVO);
        if (resultVO.isIsflag()) {

            request.setAttribute("Employee_id", employeeid);
            session.setAttribute("newuser", employeeid);
            System.out.println("Employee_iddddddddd" + resultVO.getEmployeeId());

            return mapping.findForward(SUCCESS);
        } else {
            request.setAttribute("message_userprof", resultVO.getMessage());
            return mapping.findForward(FAILURE);
        }

    }

    public ActionForward insertUserPersonalAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();

        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        String address = employeeActionFormBean.getAddress();
        String dateofbirth = employeeActionFormBean.getDateofbirth();
        String phone = employeeActionFormBean.getPhone();
        String altphone = employeeActionFormBean.getAltphone();
        String maritalstatus = employeeActionFormBean.getMaritalstatus();
        String locationId = employeeActionFormBean.getLocation_id();
        String countryId = employeeActionFormBean.getCountry_id();
        String gender = employeeActionFormBean.getGender();
        String nationality = employeeActionFormBean.getNationality();
        String emailid = employeeActionFormBean.getEmailid();
        String pin = employeeActionFormBean.getPin();

        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();

        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        String employeeId = (String) session.getAttribute("newuser");
        employeeInfoVO.setEmployeeId(employeeId);
        employeeInfoVO.setAddress(address);
        employeeInfoVO.setDateofbirth(dateofbirth);
        employeeInfoVO.setPhone(phone);
        employeeInfoVO.setAltphone(altphone);
        employeeInfoVO.setMaritalstatus(maritalstatus);
        employeeInfoVO.setLocation_id(locationId);
        employeeInfoVO.setCountry_id(countryId);
        employeeInfoVO.setGender(gender);
        employeeInfoVO.setNationality(nationality);
        employeeInfoVO.setEmailid(emailid);
        employeeInfoVO.setPin(pin);


        ResultVO resultVO = employeeInformationServicesDaoImpl.insertUserPersonalService(employeeInfoVO);
        if (resultVO.isIsflag()) {
            request.setAttribute("messge_personal", "data inserted");
            //System.out.println("Employee_iddddddddd"+resultVO.getEmployeeId());
        }
        return mapping.findForward(SUCCESS);

    }

    public ActionForward empGreivance(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        HttpSession session = request.getSession(true);

        int resourceId = (Integer) session.getAttribute("userid");
        String grievance = employeeActionFormBean.getGrievance();
    

        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setUserid(resourceId);
        employeeInfoVO.setGrievance(grievance);
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        //   userLoginVO.setJoiningdate(userLoginFormBean.getJoiningdate());
        ResultVO resultVO = employeeInformationServicesDaoImpl.postGrievance(employeeInfoVO);
        //EmailService emailService = new EmailService();
        //emailService.emailSend();

        String message = resultVO.getMessage();

        request.setAttribute("storegrievance", message);


        return mapping.findForward(SUCCESS);
    }

    public ActionForward insertUserEduAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LovServicesDaoImpl lovServicesDaoImpl = new LovServicesDaoImpl();
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        List<ListOfValuesVO> listOfUgQualification = lovServicesDaoImpl.populateTpcsUgQualification();
        dynaActionForm.set("listOfUgQualification", listOfUgQualification);
        List<ListOfValuesVO> listOfUgSpecialization = lovServicesDaoImpl.populateTpcsUgSpecialization();
        dynaActionForm.set("listOfUgSpecialization", listOfUgSpecialization);
        List<ListOfValuesVO> listOfUgUniversity = lovServicesDaoImpl.populateTpcsUgUniversity();
        dynaActionForm.set("listOfUgUniversity", listOfUgUniversity);
        List<ListOfValuesVO> listOfPgQualification = lovServicesDaoImpl.populateTpcsPgQualification();
        dynaActionForm.set("listOfPgQualification", listOfPgQualification);
        List<ListOfValuesVO> listOfPgSpecialization = lovServicesDaoImpl.populateTpcsPgSpecialization();
        dynaActionForm.set("listOfPgSpecialization", listOfPgSpecialization);
        List<ListOfValuesVO> listOfPgUniversity = lovServicesDaoImpl.populateTpcsPgUniversity();
        dynaActionForm.set("listOfPgUniversity", listOfPgUniversity);
        return mapping.findForward(INSER_USER_EDU_ACTION);
    }

    public ActionForward insertUserEducationalAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        String employee_id = (String) session.getAttribute("newuser");


        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        String ug_qualification = employeeActionFormBean.getUg_qualification();
        String ug_specialization = employeeActionFormBean.getUg_specialization();
        String ug_passout = employeeActionFormBean.getUg_passout();
        String ug_university = employeeActionFormBean.getUg_university();

        String pg_qualification = employeeActionFormBean.getPg_qualification();
        String pg_specialization = employeeActionFormBean.getPg_specialization();
        String pg_passout = employeeActionFormBean.getPg_passout();
        String pg_university = employeeActionFormBean.getPg_university();
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setEmployeeId(employee_id);
        employeeInfoVO.setUg_qualification(ug_qualification);
        employeeInfoVO.setUg_specialization(ug_specialization);
        employeeInfoVO.setUg_passout(ug_passout);
        employeeInfoVO.setUg_university(ug_university);
        employeeInfoVO.setPg_qualification(pg_qualification);
        employeeInfoVO.setPg_specialization(pg_specialization);
        employeeInfoVO.setPg_passout(pg_passout);
        employeeInfoVO.setPg_university(pg_university);
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        ResultVO resultVO = employeeInformationServicesDaoImpl.insertUserEduService(employeeInfoVO);
        if (resultVO.isIsflag()) {
            request.setAttribute("messge_education", "data inserted");

        }
        return mapping.findForward(SUCCESS);
    }

    public ActionForward insertUserPastProfAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        String employee_id = (String) session.getAttribute("newuser");


        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;

        String[] employmentname = employeeActionFormBean.getEmploymentname();
        String[] empduration = employeeActionFormBean.getEmpduration();
        String[] pastdatejoining = employeeActionFormBean.getPastdatejoining();
        String[] dateofrealise = employeeActionFormBean.getDateofrealise();
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setEmployeeId(employee_id);
        employeeInfoVO.setEmploymentname(employmentname);
        employeeInfoVO.setEmpduration(empduration);
        employeeInfoVO.setPastdatejoining(pastdatejoining);
        employeeInfoVO.setDateofrealise(dateofrealise);
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        ResultVO resultVO = employeeInformationServicesDaoImpl.insertUserProfService(employeeInfoVO);
        if (resultVO.isIsflag()) {
            request.setAttribute("messge_professional", "data inserted");

        }
        return mapping.findForward(SUCCESS);
    }

    public ActionForward insertUserOffiDetAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LovServicesDaoImpl lovServicesDaoImpl = new LovServicesDaoImpl();
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        List<ListOfValuesVO> listOfLocationId = lovServicesDaoImpl.populateTpcsLocationId();
        dynaActionForm.set("listOfLocationId", listOfLocationId);
        List<ListOfValuesVO> listOfSupervisoryId = lovServicesDaoImpl.populateUserProfileList();
        dynaActionForm.set("listOfSupervisoryId", listOfSupervisoryId);
        List<ListOfValuesVO> listOfParentIouId = lovServicesDaoImpl.populateParentIouList();
        dynaActionForm.set("listOfParentIouId", listOfParentIouId);
        List<ListOfValuesVO> listOfSubIouId = lovServicesDaoImpl.populateUserProfileList();
        dynaActionForm.set("listOfSubIouId", listOfSubIouId);
        List<ListOfValuesVO> listOfGradeId = lovServicesDaoImpl.populateTpcsGradeId();
        dynaActionForm.set("listOfGradeId", listOfGradeId);
        return mapping.findForward(INSERT_USER_OFFI_DET_ACTION);
    }

    public ActionForward insertUserOffiAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        String employee_id = (String) session.getAttribute("newuser");


        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        String dateofjoining = employeeActionFormBean.getDateofjoining();
        String status = employeeActionFormBean.getStatus();
        String employeetype = employeeActionFormBean.getEmployeetype();
        String grade = employeeActionFormBean.getGrade();
        String deputedlocation = employeeActionFormBean.getDeputedlocation();
        String baselocation = employeeActionFormBean.getBaselocation();
        String supervisorId = employeeActionFormBean.getSupervisorId();
        String parentIouId = employeeActionFormBean.getParentIouId();
        String subIouId = employeeActionFormBean.getSubIouId();
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setDateofjoining(dateofjoining);
        employeeInfoVO.setStatus(status);
        employeeInfoVO.setEmployeetype(employeetype);
        employeeInfoVO.setGrade(grade);
        employeeInfoVO.setDeputedlocation(deputedlocation);
        employeeInfoVO.setBaselocation(baselocation);
        employeeInfoVO.setSupervisorId(supervisorId);
        employeeInfoVO.setParentIouId(parentIouId);
        employeeInfoVO.setSubIouId(subIouId);
        employeeInfoVO.setEmployeeId(employee_id);

        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        ResultVO resultVO = employeeInformationServicesDaoImpl.insertUserOffiService(employeeInfoVO);
        if (resultVO.isIsflag()) {
            request.setAttribute("messge_office", "data inserted");

        }
        return mapping.findForward(SUCCESS);
    }

    public ActionForward insertEmpFinanAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        String employee_id = (String) session.getAttribute("newuser");


        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        String pannumber = employeeActionFormBean.getPannumber();
        String primarybankacc = employeeActionFormBean.getPrimarybankacc();
        String secondarybankacc = employeeActionFormBean.getSecondarybankacc();

        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setPannumber(pannumber);
        employeeInfoVO.setPrimarybankacc(primarybankacc);
        employeeInfoVO.setSecondarybankacc(secondarybankacc);
        employeeInfoVO.setEmployeeId(employee_id);

        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        ResultVO resultVO = employeeInformationServicesDaoImpl.insertUserFinanService(employeeInfoVO);
        if (resultVO.isIsflag()) {
            employeeActionFormBean.setEmployeeId(employee_id);

        }
        return mapping.findForward(SUCCESS);
    }

    public ActionForward passwordManageAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();

        HttpSession session = request.getSession(true);
        int userid = (Integer) session.getAttribute("userid");
        String curpass = employeeActionFormBean.getCurpass();
        String newpass = employeeActionFormBean.getNewpass();
        String retypepass = employeeActionFormBean.getRetypepass();
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setUserid(userid);
        employeeInfoVO.setCurpass(curpass);
        employeeInfoVO.setNewpass(newpass);
        employeeInfoVO.setRetypepass(retypepass);
        ResultVO resultVO = employeeInformationServicesDaoImpl.passwordManageService(employeeInfoVO);
        request.setAttribute("message_password", resultVO.getMessage());
        return mapping.findForward(PASSWORD_MANAGE_ACTION);
    }

    public ActionForward viewEmployeesEmailIds(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DynaActionForm dynaActionForm = (DynaActionForm) form;

        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        StringBuilder employeeEmailIds = employeeInformationServicesDaoImpl.viewEmployeeEmailIds();
        dynaActionForm.set("employeeEmailIds", employeeEmailIds);

        return mapping.findForward(VIEW_EMPLOYEE_EMAILS);
    }

    public ActionForward indivitualEmployeeInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        HttpSession session = request.getSession(true);
        int userid = (Integer) session.getAttribute("userid");
        EmployeeInfoVO employeeInfoVO = employeeInformationServicesDaoImpl.viewEmployeeAccountInfo(userid);
        employeeActionFormBean.setPannumber(employeeInfoVO.getPannumber());
        employeeActionFormBean.setPrimarybankacc(employeeInfoVO.getPrimarybankacc());
        employeeActionFormBean.setSecondarybankacc(employeeInfoVO.getSecondarybankacc());
        return mapping.findForward(SUCCESS);

    }

    public ActionForward updateEmployeeInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        HttpSession session = request.getSession(true);
        int userid = (Integer) session.getAttribute("userid");
        String pannumber = employeeActionFormBean.getPannumber();
        String primAccDetails = employeeActionFormBean.getPrimarybankacc();
        String seconAccDetails = employeeActionFormBean.getSecondarybankacc();
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setPannumber(pannumber);
        employeeInfoVO.setPrimarybankacc(primAccDetails);
        employeeInfoVO.setSecondarybankacc(seconAccDetails);
        employeeInfoVO.setUserid(userid);

        ResultVO resultVO = employeeInformationServicesDaoImpl.UpdateEmployeeAccountInfo(employeeInfoVO);
        if (resultVO.isIsflag()) {
            request.setAttribute("messge_finance", resultVO.getMessage());

        } else {
            request.setAttribute("messge_finance", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);

    }

    public ActionForward individualalEmpPersDet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        HttpSession session = request.getSession(true);
        int userid = (Integer) session.getAttribute("userid");
        EmployeeInfoVO employeeInfoVO = employeeInformationServicesDaoImpl.viewEmpPersDet(userid);
        employeeActionFormBean.setAddress(employeeInfoVO.getAddress());
        employeeActionFormBean.setLocation_id(employeeInfoVO.getLocation_id());
        employeeActionFormBean.setPin(employeeInfoVO.getPin());
        employeeActionFormBean.setPhone(employeeInfoVO.getPhone());
        employeeActionFormBean.setAltphone(employeeInfoVO.getAltphone());
        employeeActionFormBean.setMaritalstatus(employeeInfoVO.getMaritalstatus());
        employeeActionFormBean.setCountry_id(employeeInfoVO.getCountry_id());
        employeeActionFormBean.setEmailid(employeeInfoVO.getEmailid());
        employeeActionFormBean.setDateofbirth(employeeInfoVO.getDateofbirth());
        employeeActionFormBean.setGender(employeeInfoVO.getGender());
        return mapping.findForward(SUCCESS);

    }

    public ActionForward updateEmployeePersDet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        HttpSession session = request.getSession(true);
        int userid = (Integer) session.getAttribute("userid");
        String address = employeeActionFormBean.getAddress();
        String location_id = employeeActionFormBean.getLocation_id();
        String pin = employeeActionFormBean.getPin();
        String phone = employeeActionFormBean.getPhone();
        String altnumber = employeeActionFormBean.getAltphone();
        String maritalstatus = employeeActionFormBean.getMaritalstatus();
        String country_id = employeeActionFormBean.getCountry_id();
        String email_id = employeeActionFormBean.getEmailid();
        String dateofbirth = employeeActionFormBean.getDateofbirth();
        String gender = employeeActionFormBean.getGender();
        System.out.println("userid" + userid + "address" + address + "location_id" + location_id + "pin" + pin + "phone" + phone + "altnumber" + altnumber + "maritalstatus" + maritalstatus + "country_id" + country_id + "email_id" + email_id + "Date Of Birth" + dateofbirth + "gender" + gender);

        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setAddress(address);
        employeeInfoVO.setLocation_id(location_id);
        employeeInfoVO.setPin(pin);
        employeeInfoVO.setPhone(phone);
        employeeInfoVO.setAltphone(altnumber);
        employeeInfoVO.setMaritalstatus(maritalstatus);
        employeeInfoVO.setCountry_id(country_id);
        employeeInfoVO.setEmailid(email_id);
        employeeInfoVO.setUserid(userid);
        employeeInfoVO.setDateofbirth(dateofbirth);
        employeeInfoVO.setGender(gender);

        ResultVO resultVO = employeeInformationServicesDaoImpl.UpdateEmployeePersInfo(employeeInfoVO);
        if (resultVO.isIsflag()) {
            request.setAttribute("messge_personal", resultVO.getMessage());

        } else {
            request.setAttribute("messge_personal", resultVO.getMessage());
        }
        return mapping.findForward(SUCCESS);
    }

    public ActionForward individualalEmpEduDet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        HttpSession session = request.getSession(true);
        int userid = (Integer) session.getAttribute("userid");
        EmployeeInfoVO employeeInfoVO = employeeInformationServicesDaoImpl.viewEmpEduDet(userid);
        employeeActionFormBean.setUg_qualification(employeeInfoVO.getUg_qualification());
        employeeActionFormBean.setUg_specialization(employeeInfoVO.getUg_specialization());
        employeeActionFormBean.setUg_passout(employeeInfoVO.getUg_passout());
        employeeActionFormBean.setUg_university(employeeInfoVO.getUg_university());
        employeeActionFormBean.setPg_qualification(employeeInfoVO.getPg_qualification());
        employeeActionFormBean.setPg_specialization(employeeInfoVO.getPg_specialization());
        employeeActionFormBean.setPg_passout(employeeInfoVO.getPg_passout());
        employeeActionFormBean.setPg_university(employeeInfoVO.getPg_university());

        return mapping.findForward(SUCCESS);

    }

    public ActionForward updateEmployeeEduDet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        int userid = (Integer) session.getAttribute("userid");


        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        String ug_qualification = employeeActionFormBean.getUg_qualification();
        String ug_specialization = employeeActionFormBean.getUg_specialization();
        String ug_passout = employeeActionFormBean.getUg_passout();
        String ug_university = employeeActionFormBean.getUg_university();

        String pg_qualification = employeeActionFormBean.getPg_qualification();
        String pg_specialization = employeeActionFormBean.getPg_specialization();
        String pg_passout = employeeActionFormBean.getPg_passout();
        String pg_university = employeeActionFormBean.getPg_university();
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setUserid(userid);
        employeeInfoVO.setUg_qualification(ug_qualification);
        employeeInfoVO.setUg_specialization(ug_specialization);
        employeeInfoVO.setUg_passout(ug_passout);
        employeeInfoVO.setUg_university(ug_university);
        employeeInfoVO.setPg_qualification(pg_qualification);
        employeeInfoVO.setPg_specialization(pg_specialization);
        employeeInfoVO.setPg_passout(pg_passout);
        employeeInfoVO.setPg_university(pg_university);
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        ResultVO resultVO = employeeInformationServicesDaoImpl.updateEmpEduService(employeeInfoVO);
        if (resultVO.isIsflag()) {
            request.setAttribute("messge_education", "Data Update Successfully");

        } else {
            request.setAttribute("messge_education", "Data Not Update Successfully");
        }
        return mapping.findForward(SUCCESS);
    }

    public ActionForward individualalEmpOfficeDet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        HttpSession session = request.getSession(true);
        int userid = (Integer) session.getAttribute("userid");
        EmployeeInfoVO employeeInfoVO = employeeInformationServicesDaoImpl.viewEmpOffDet(userid);
        employeeActionFormBean.setDateofjoining(employeeInfoVO.getDateofjoining());

        employeeActionFormBean.setStatus(employeeInfoVO.getStatus());
        employeeActionFormBean.setGrade(employeeInfoVO.getGrade());
        employeeActionFormBean.setEmployeetype(employeeInfoVO.getEmployeetype());
        employeeActionFormBean.setDeputedlocation(employeeInfoVO.getDeputedlocation());
        employeeActionFormBean.setBaselocation(employeeInfoVO.getBaselocation());
        employeeActionFormBean.setSupervisorId(employeeInfoVO.getSupervisorId());
        employeeActionFormBean.setParentIouId(employeeInfoVO.getParentIouId());
        employeeActionFormBean.setSubIouId(employeeInfoVO.getSubIouId());
        return mapping.findForward(SUCCESS);

    }

    public ActionForward updateEmployeeOffDet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        int userid = (Integer) session.getAttribute("userid");


        EmployeeActionFormBean employeeActionFormBean = (EmployeeActionFormBean) form;
        String dateofjoining = employeeActionFormBean.getDateofjoining();
        String status = employeeActionFormBean.getStatus();
        String employeetype = employeeActionFormBean.getEmployeetype();
        String grade = employeeActionFormBean.getGrade();
        String deputedlocation = employeeActionFormBean.getDeputedlocation();
        String baselocation = employeeActionFormBean.getBaselocation();
        String supervisorId = employeeActionFormBean.getSupervisorId();
        String parentIouId = employeeActionFormBean.getParentIouId();
        String subIouId = employeeActionFormBean.getSubIouId();
        EmployeeInfoVO employeeInfoVO = new EmployeeInfoVO();
        employeeInfoVO.setDateofjoining(dateofjoining);
        employeeInfoVO.setStatus(status);
        employeeInfoVO.setEmployeetype(employeetype);
        employeeInfoVO.setGrade(grade);
        employeeInfoVO.setDeputedlocation(deputedlocation);
        employeeInfoVO.setBaselocation(baselocation);
        employeeInfoVO.setSupervisorId(supervisorId);
        employeeInfoVO.setParentIouId(parentIouId);
        employeeInfoVO.setSubIouId(subIouId);
        employeeInfoVO.setUserid(userid);

        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        ResultVO resultVO = employeeInformationServicesDaoImpl.updateEmpOffiService(employeeInfoVO);
        if (resultVO.isIsflag()) {
            request.setAttribute("messge_office", "Data Update Succesfully");

        }
        return mapping.findForward(SUCCESS);
    }

    public ActionForward viewStatusReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
        String date = dynaValidatorForm.getString("dateofstatusreport");
        String employeeId = dynaValidatorForm.getString("employeeId");

        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        List<StatusReportVO> list = employeeInformationServicesDaoImpl.viewEmpStatusReport(date, employeeId);
        int length = list.size();
        if (length > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("dateOfStatusOfemployee", date);
            session.setAttribute("empIdOfStatus", Integer.parseInt(employeeId));
            dynaValidatorForm.set("listStatusReport", list);
            return mapping.findForward(SUCCESS);
        } else {
            request.setAttribute("failureStatus", "You Enter the Wrong Date");
            return mapping.findForward(FAILURE_STATUS);
        }
    }

    public ActionForward activeStatusReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
        int status = (Integer)dynaValidatorForm.get("status");
        HttpSession session = request.getSession();
        String date=(String)session.getAttribute("dateOfStatusOfemployee");
        int resourceId=(Integer)session.getAttribute("empIdOfStatus");
        StatusReportVO statusReportVO=new StatusReportVO();
        statusReportVO.setResourceId(resourceId);
        statusReportVO.setStatusReportId(status);
        statusReportVO.setDate(date);
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        List<StatusReportVO> list = employeeInformationServicesDaoImpl.activateEmpStatusReport(statusReportVO);
        int length = list.size();
        if (length > 0) {

            dynaValidatorForm.set("listStatusReport", list);
            return mapping.findForward(SUCCESS);
        } else {
            request.setAttribute("failureStatus", "There Has No Data");
            return mapping.findForward(FAILURE_STATUS);
        }
    }
    

    public ActionForward viewMyStatusReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
        String date = dynaValidatorForm.getString("dateofstatusreport");
        HttpSession session = request.getSession();
        int userid = (Integer) session.getAttribute("userid");

        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        List<StatusReportVO> list = employeeInformationServicesDaoImpl.viewMyStatusReport(date, userid);
        int length = list.size();
        if (length > 0) {
            dynaValidatorForm.set("listStatusReport", list);
            return mapping.findForward(SUCCESS);
        } else {
            request.setAttribute("failureStatus", "You Enter the Wrong Date");
            return mapping.findForward(FAILURE_STATUS);
        }
    }
     public ActionForward rejectStatusReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaValidatorForm dynaValidatorForm = (DynaValidatorForm) form;
        int status = (Integer)dynaValidatorForm.get("status");
        HttpSession session = request.getSession();
        String date=(String)session.getAttribute("dateOfStatusOfemployee");
        int resourceId=(Integer)session.getAttribute("empIdOfStatus");
        StatusReportVO statusReportVO=new StatusReportVO();
        statusReportVO.setResourceId(resourceId);
        statusReportVO.setStatusReportId(status);
        statusReportVO.setDate(date);
        EmployeeInformationServicesDaoImpl employeeInformationServicesDaoImpl = new EmployeeInformationServicesDaoImpl();
        List<StatusReportVO> list = employeeInformationServicesDaoImpl.rejectEmpStatusReport(statusReportVO);
        int length = list.size();
        if (length > 0) {

            dynaValidatorForm.set("listStatusReport", list);
            return mapping.findForward(SUCCESS);
        } else {
            request.setAttribute("failureStatus", "There Has No Data");
            return mapping.findForward(FAILURE_STATUS);
        }
    }
    

 

    public ActionForward viewListOfManagementDashboard(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DynaActionForm dynaActionForm = (DynaActionForm) form;
        HttpSession session = request.getSession();
        String userrole = (String) session.getAttribute("userrole");
        if (userrole.equalsIgnoreCase("HR Manager")) {
            LovServicesDaoImpl lovServicesDaoImpl = new LovServicesDaoImpl();
            List<ListOfValuesVO> listOfEmployeeId = lovServicesDaoImpl.populateUserProfileList();
            dynaActionForm.set("listOfUserProfile", listOfEmployeeId);
            return mapping.findForward(SUCCESS);
        } else {
            return mapping.findForward(FAILURE);
        }
    }

    public ActionForward hrManageDashboard(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        String userrole = (String) session.getAttribute("userrole");
        if (userrole.equalsIgnoreCase("HR Manager")) {


            return mapping.findForward(SUCCESS);
        } else {
            return mapping.findForward(FAILURE);
        }
    }
}
