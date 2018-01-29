function otherIns(){
    var ortherIns = document.getElementById("otherInstitution").value;
    if(ortherIns=="00"){
        document.getElementById('or').style.visibility="visible"
    } else{
        document.getElementById('or').style.visibility="collapse"
    }   
}
function otherInsSudule(){
    var insStatus = document.getElementById("insStatus").value;
    if(insStatus=="Interview Scheduled"){
        document.getElementById('insDate').style.visibility="visible"
    } else{
        document.getElementById('insDate').style.visibility="collapse"
    }  
}
function otherAcademi(){
    var insStatus = document.getElementById("ortherAca").value;
    if(insStatus=="00"){
        document.getElementById('insAca').style.visibility="visible"
    } else{
        document.getElementById('insAca').style.visibility="collapse"
    }   
}
function otherprofilOr(){
    var insStatus = document.getElementById("orProfile").value;
    if(insStatus=="00"){
        document.getElementById('profilOr').style.visibility="visible"
    } else{
        document.getElementById('profilOr').style.visibility="collapse"
    }   
}