<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>TPCS Global :tpcsglobal,freshers jobs in kolkata,Corporate Training,Educational Resources,LIVE Projects Training,Summer Training Kolkata,Summer Training kolkata 2013,Software Development, Web Designing,SEO and SEM services.</title>
        <meta name="description" content="tpcs,tpcsglobal,freshers jobs in kolkata,Corporate Training,LIVE Projects Training, Summer Training ,Software Development, Web Designing,SEO and SEM services." />
        <meta name="keywords" content="tpcs,tpcsglobal,freshers jobs in kolkata,Corporate Training,LIVE Projects Training, Summer Training ,Summer Training Kolkata,Software Development, Web Designing,SEO and SEM services." />
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <meta name="google-site-verification" content="google3dd5104a573560ae.html" />

        <link href="css/style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/easySlider1.5.js"></script>
        <script type="text/javascript">

            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-33184929-1']);
            _gaq.push(['_trackPageview']);

            (function() {
                var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
            })();

        </script>
        <SCRIPT LANGUAGE="JavaScript">
function popUp(URL) {
newWindow=window.open(URL,URL,'toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=0,width=1000,height=2000')
if (window.focus) {newwindow.focus()}
	return false;

//eval("page" + id + " = window.open(URL, '" + id + "', 'toolbar=0,scrollbars=1,location=0,statusbar=0,menubar=0,resizable=0,width=200,height=300');");
}
// End -->
</script>


        <script type="text/javascript" charset="utf-8">
            // <![CDATA[
            $(document).ready(function(){	
                $("#slider").easySlider({
                    controlsBefore:	'<p id="controls">',
                    controlsAfter:	'</p>',
                    auto: true, 
                    continuous: true
                });	
            });
            // ]]>
        </script>
        <style type="text/css">
            .gallery { width:850px; height:315px; margin:0 auto; padding:0; }
            #slider { margin:0; padding:20px 0px; list-style:none; }
            #slider ul,
            #slider li { margin:0; padding:0; list-style:none; }
            /* 
                define width and height of list item (slide)
                entire slider area will adjust according to the parameters provided here
            */
            #slider li { width:850px; height:350px; overflow:hidden; }
            p#controls { margin:0; padding:0; position:relative; }
            #prevBtn { display:block; margin:0; overflow:hidden; width:34px; height:34px; position:absolute; left:-50px; top:-180px; }
            #nextBtn { display:block; margin:0; overflow:hidden; width:34px; height:34px; position:absolute; left: 870px; top:-180px; }
            #prevBtn a { display:block; width:34px; height:34px; background:url(images/lt.png) no-repeat 0 0; }
            #nextBtn a { display:block; width:34px; height:34px; background:url(images/rt.png) no-repeat 0 0; }
            
        </style>

        <script type="text/javascript" src="demo_files/jquery.vticker-min.js"></script>
        <script type="text/javascript">
            $(function(){
                $('#news-container').vTicker({ 
                    speed: 500,
                    // pause: 3000,
                    pause: 8000,
                    animation: 'fade',
                    mousePause: true,
                    showItems: 3
                   
                });
                $('#news-container1').vTicker({
                    speed: 700,
                    // pause: 4000,
                    pause: 8000,
                    animation: 'fade',
                    mousePause: true,
                    showItems: 1
                     
                });
            });
        </script>
    </head>
    <body>
        
        <div class="main">
            <div class="wrap">
            <div class="header">
                <tiles:insert attribute="header" />
                <tiles:insert attribute="menu" />                
            </div>           
                <tiles:insert attribute="banner" /> 
             <div class="clr"></div>   
            <div class="body">
                
                <tiles:insert attribute="body" /> 
                
            </div>
            <div class="clr"></div> 
            <div class="footer">
               <tiles:insert attribute="footer" />    
            </div>
        </div>
            </div>
    </body>
</html>