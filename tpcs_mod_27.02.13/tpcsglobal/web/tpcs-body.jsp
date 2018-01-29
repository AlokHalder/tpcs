<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@taglib  uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<div class="body_resize" style="-moz-border-radius: 5px;border-radius: 5px;">
    <div class="FBG">
        <div class="Recent">
            <img src="images/teac.jpg" alt="picture" width="67" height="67" class="fbgg" />
            <p class="fbgg"><span>Professional Teaching</span><br />
                We offers home and own residence tutors &amp; students.We are a pioneer in providing the best educational information resources...<br />
            </p>
            <p class="fbgg"><a style="float:right; padding-bottom:15px" href="http://www.ptutors.org" target="_blank" class="fbgg">Read More</a></p>
            <div class="bg"></div>

        </div>
        <div class="Recent"> <img src="images/job.jpg" alt="picture" width="67" height="67" class="fbgg" />
            <p class="fbgg"><span>Job Portal</span><br />
                We excel in providing employment services to the top hiring companies as well as to the jobseekers. We are the best headhunters...
            </p>
            <p class="fbgg"><a style="float:right; padding-bottom:15px" href="#" class="fbgg">Read More</a></p>
            <div class="bg"></div>

        </div>
        <div class="Recent"> <img src="images/www.jpg" alt="picture" width="67" height="67" class="fbgg" />
            <p class="fbgg"><span>Website Development &amp; Hosting</span><br />
                We meet all your web design &amp; hosting requirements to create a successful website. We help to enhance your brand identity so that your business grows.  </p>
            <p class="fbgg"><a style="float:right; padding-bottom:15px" href="#" class="fbgg">Read More</a></p>
            <div class="bg"></div>

        </div>
        <div class="clr"></div>
        <div class="clr"></div>
    </div>
    <div class="left">
        <h2>Welcome</h2>
        <img src="images/manasi.jpg" alt="picture" width="300" height="300" />
        <p><span>TPCS Global adds real value to your business pertaining to all your business requirements.</span></p>
        <p>Each and every business struggle a lot to cope up with new technologies and innovations and this enhances the need of a consultant. We are a Software Development company dealing with varied services like IT Services,Web Development,LIVE Projects Training,Summer Training,Software Development,Web Designing, SEO and SEM services. Our panel of IT consultants will take care of all your needs and specifications. We utilize our expertise to frame a business plan, generating productivity and handle intricate projects.  </p>
        <div class="bg"></div>
        <p><a href="#">More Information</a></p>
        <h2>Who We Are</h2>
        <p>Find the relevant businesses or people you are trying to contact</p>

        <p>At TPCS Global, we merge ideas and innovation into success. Whether you are a start-up business or a new one we offer an array of solutions according to your requirements. We apply our domain expertise to offer integrated service to assist you grow. We deliver the best services for education, job,health care, corporate training, software solutions etc. We apply our profound knowledge; utilize team strength to take care of the client requirements. Our solutions offered are blend of cost-effectiveness and excellence. </p>
        <div class="clr"></div>
    </div>
    <div class="right">
        <h2>Client Testimonials</h2>     
        <div id="news-container1">
            <%@include file="testimonial.jsp" %>
        </div>       
        <div class="bg"></div>        
        <h2>News &amp; Events</h2>
        <logic:iterate id="listOfNewsAndEvent" name="homeActionForm" property="listOfNewsAndEvent">
            <p class="data"> <bean:write name="listOfNewsAndEvent" property="date"/></p>
            <p><bean:write name="listOfNewsAndEvent" property="newsdetails"/></p>
        </logic:iterate>
       <%--
        <p class="data">1st |  April | 2012</p>
        <p>We launced own website of company <a href="http://www.tpcsglobal.com" class="data">more</a></p>
        <p class="data">10th | February | 2012</p>
        <p>Live project training on J2EE,.NET,PHP at new office location  <a href="http://www.technoschools.org" class="data">more</a></p>
        --%>
        <div class="bg"></div>
        <p><a href="more-news.do">More News</a></p>
    </div>
    <div class="clr"></div>
</div>
