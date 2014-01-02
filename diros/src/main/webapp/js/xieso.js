var web_domain='http://www.myjy.com';
var slt ={
    check:function(id, obj)
    {
        var state = obj.checked;
        var more = document.getElementById(id).getElementsByTagName("input");
        for (i = 0; i < more.length; i++) {
            more[i].checked = state;
        }
    },
    all:function(id){
        var more = document.getElementById(id).getElementsByTagName("input");
        for (i = 0; i < more.length; i++) {
            more[i].checked = true;
        }
    },
    none:function(id){
        var more = document.getElementById(id).getElementsByTagName("input");
        for (i = 0; i < more.length; i++) {
            more[i].checked = false;
        }
    }
}

function show_active(typename,uid){
    $("#active_content").html("<div style='text-align:center;margin-top:10px;'><img src='../images/loading.gif' align='absmiddle'> 加载中...</div>");
    $("#yin_act").attr("class","m_title out");
    $("#all_act").attr("class","m_title out");
    $("#kankan_act").attr("class","m_title out");
    $("#my_shuoshuo_act").attr("class","out");
    $("#ta_shuoshuo_act").attr("class","out");
    $("#hotthinking_act").attr("class","m_title out");
    $("#group_act").attr("class","m_title out");
    if(typename=='yin'){
        $("#yin_act").attr("class","m_title on");
        $("#active_content").load("active.php?act=home_feeling_discovery&uid="+uid);
    }else if(typename=='all' || typename=='myall'){
        $("#all_act").attr("class","m_title on");
        $("#active_content").load("active.php?act=home_friends&uid="+uid);
    }else if(typename=='kankan'){
        $("#kankan_act").attr("class","m_title on");
        $("#active_content").load("active.php?act=home_all&uid="+uid);
    }else if(typename=='hotthinking'){
        $("#hotthinking_act").attr("class","m_title on");
        $("#active_content").load("active.php?act=home_thinking&uid="+uid);
    }else if(typename=='group'){
        $("#group_act").attr("class","on");
        $("#active_content").load("active.php?act=home_group&uid="+uid);
    }else if(typename=='my_shuoshuo'){
        $("#my_shuoshuo_act").attr("class","on");
        $("#active_content").load(web_domain+"/thinking/thinking_show.php?atype=my_shuoshuo&uid="+uid);
    }else if(typename=='ta_shuoshuo'){
        $("#ta_shuoshuo_act").attr("class","on");
        $("#active_content").load(web_domain+"/thinking/thinking_show.php?atype=ta_shuoshuo&uid="+uid);
    }
}
function resizeImg(which,w) {

    var block = document.getElementById(which);
    var imgs = block.getElementsByTagName("img");
    for(var i = 0; i<imgs.length;i++){
        var ow = imgs[i].width;
        var oh = imgs[i].height;
        var hw = oh/ow;
        if(ow>w){
            imgs[i].width = w;
            imgs[i].height = w*hw;
        }
    }
}
//社区搜索类别更换
function change_stype(num){
    var s_num=$("#s_num").val();
    if(s_num=='1'){
        $("#s_num").val('2');
        if(num=='1'){
            $("#scbar_type").html("呢称");
        }else{
            $("#scbar_type").html("用户");
        }
    }else{
        $("#s_num").val('1');
        if(num=='1'){
            $("#scbar_type").html("标签");
        }else{
            $("#scbar_type").html("标题");
        }
    }
}
//随机会员
function load_member(){
    $("#people_list").load("rand_member.php");
}
//加/取消关注
function follow(type_value,uid,backid,backtype){
    $.post(web_domain+'/home/ajax.php',{
        ajcode:1025,
        type_value:type_value,
        uid:uid
    }, function(msg){
        if(msg=='ok'){
            if(type_value=='0'){
                if(backtype=='1'){
                    $("#"+backid).html("<a class=\"font-green\" href=\"#\" onclick=\"follow('1','"+uid+"','"+backid+"','1');return false;\" style=\"margin-right:10px\">关注Ta</a>");
                }else{
                    $("#"+backid).html("<a class=\"addFollow\" href=\"#\" onclick=\"follow('1','"+uid+"','"+backid+"');return false;\">+加入关注</a>");
                }
            }else{
                if(backtype=='1'){
                    $("#"+backid).html("<a href=\"#\" onclick=\"follow('0','"+uid+"','"+backid+"','1');return false;\">- 取消关注</a>");
                }else{
                    $("#"+backid).html("<a href=\"#\" onclick=\"follow('0','"+uid+"','"+backid+"');return false;\">- 取消关注</a>");
                }

            }
        }
    });
}
//显示承接人列表
function show_member(num){
    if(num=='1'){
        $("#show_member").css("display","none");
        $("#close_member").css("display","inline");
        $("#member_list").css("display","block");
    }else{
        $("#show_member").css("display","inline");
        $("#close_member").css("display","none");
        $("#member_list").css("display","none");
    }
}
//在光标处插入内容
function insertAtCursor(myField, myValue){
    //IE support
    if (document.selection)
    {
        myField.focus();
        sel = document.selection.createRange();
        sel.text = myValue;
        sel.select();
    }
    //MOZILLA/NETSCAPE support
    else if (myField.selectionStart || myField.selectionStart == '0')
    {
        var startPos = myField.selectionStart;
        var endPos = myField.selectionEnd;
        // save scrollTop before insert
        var restoreTop = myField.scrollTop;
        myField.value = myField.value.substring(0, startPos) + myValue + myField.value.substring(endPos,myField.value.length);
        if (restoreTop > 0)
        {
            // restore previous scrollTop
            myField.scrollTop = restoreTop;
        }
        myField.focus();
        myField.selectionStart = startPos + myValue.length;
        myField.selectionEnd = startPos + myValue.length;
    } else {
        myField.value += myValue;
        myField.focus();
    }
}
function MM_swapImgRestore() { //v3.0
    var i,x,a=document.MM_sr;
    for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++) x.src=x.oSrc;
}
function MM_preloadImages() { //v3.0
    var d=document;
    if(d.images){
        if(!d.MM_p) d.MM_p=new Array();
        var i,j=d.MM_p.length,a=MM_preloadImages.arguments;
        for(i=0; i<a.length; i++)
            if (a[i].indexOf("#")!=0){
                d.MM_p[j]=new Image;
                d.MM_p[j++].src=a[i];
            }
    }
}

function MM_findObj(n, d) { //v4.01
    var p,i,x;
    if(!d) d=document;
    if((p=n.indexOf("?"))>0&&parent.frames.length) {
        d=parent.frames[n.substring(p+1)].document;
        n=n.substring(0,p);
    }
    if(!(x=d[n])&&d.all) x=d.all[n];
    for (i=0;!x&&i<d.forms.length;i++) x=d.forms[i][n];
    for(i=0;!x&&d.layers&&i<d.layers.length;i++) x=MM_findObj(n,d.layers[i].document);
    if(!x && d.getElementById) x=d.getElementById(n);
    return x;
}

function MM_swapImage() { //v3.0
    var i,j=0,x,a=MM_swapImage.arguments;
    document.MM_sr=new Array;
    for(i=0;i<(a.length-2);i+=3)
        if ((x=MM_findObj(a[i]))!=null){
            document.MM_sr[j++]=x;
            if(!x.oSrc) x.oSrc=x.src;
            x.src=a[i+2];
        }
}
//首页滚动
function autosroll(id){
    var Mar = document.getElementById(id);
    var child_div=Mar.getElementsByTagName("li")
    var picH = 70;//移动高度
    var scrollstep=3;//移动步幅,越大越快
    var scrolltime=40;//移动频度(毫秒)越大越慢
    var stoptime=3000;//间断时间(毫秒)
    var tmpH = 0;
    Mar.innerHTML += Mar.innerHTML;
    function start(){
        if(tmpH < picH){
            tmpH += scrollstep;
            if(tmpH > picH )tmpH = picH ;
            Mar.scrollTop = tmpH;
            setTimeout(start,scrolltime);
        }else{
            tmpH = 0;
            Mar.appendChild(child_div[0]);
            Mar.scrollTop = 0;
            setTimeout(start,stoptime);
        }
    }
    onload=function(){
        setTimeout(start,stoptime)
    };

}
//登陆
function login_check(){
    var uname=$("#useremail").val();
    var upass=$("#userpass").val();
    var fromurl=$("#fromurl").val();
    if($("#remember_me").attr('checked')){
        var save_cookie='1';
    }
    if(uname=='' || upass==''){
        $("#login_tip").css("display","inline");
    }else{
        $.post(web_domain+'/ajax.php',{
            ajcode:1002,
            uname:uname,
            upass:upass,
            save_cookie:save_cookie
        },function(msg){
            if(msg=='error'){
                $("#login_tip").css("display","inline");
            }else if(msg=='ok' && fromurl==''){
                window.location.href=web_domain+"/home/";
            }else if(msg=='ok' && fromurl!=''){
                window.location.href=fromurl;
            }
        });
    }
}
//注册
function reg_check(fromurl){
    var user_name=$("#user_email").val();
    var user_pass=$("#user_pass").val();
    var write_name=$("#write_name").val();
    var fromurl=$("#fromurl").val();
    var m	=	new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/);
    if($("#remember_me").attr('checked')){
        var save_cookie='1';
    }
    if(user_name=='' || user_pass=='' || write_name==''){
        $("#login_tip2").css("display","inline");
    }else if(!(m.test(user_name))){
        $("#login_tip2").html('请输入有效的Email地址！');
        $("#login_tip2").show();
    }else{
        $.post(web_domain+'/ajax.php',{
            ajcode:1040,
            user_name:user_name,
            user_pass:user_pass,
            write_name:write_name
        },function(msg){
            if(msg!='ok'){
                $("#login_tip2").html(msg);
                $("#login_tip2").css("display","inline");
            }else if(msg=='ok' && fromurl==''){
                window.location.href="home/";
            }else if(msg=='ok' && fromurl!=''){
                window.location.href=fromurl;
            }
        });
    }
}

function hiddinfo(id){
    $("#"+id).css("display","none");
}
//提取首页动态
function load_acvite(){
    $.post('ajax.php',{
        ajcode:1027
    },function(msg){
        $("#marqueecontent").html(msg);
    });
}
function show_fans(){
    $("#at").css("display","block");
    $("#fanslist").html("<div style='text-align:center;margin-top:10px;'><img src='../images/loading.gif' align='absmiddle'> 加载中...</div>");
    $.post(web_domain+'/home/ajax.php',{
        ajcode:1047
    }, function(data){
        var ajaxdata=eval('(' +data + ')');
        $("#fanslist").html(""+ajaxdata['licontent']+"");
    });

}
function close_fans(){
    $("#at").css("display","none");
    $("#fans_name").val('')
}

function checkfans(event,witch){
    if(event.keyCode!=13 & event.keyCode!=9 & event.keyCode!=38 & event.keyCode!=40){
        if (document.getElementById(witch).value.length>=2){
            $.post(web_domain+'/home/ajax.php',{
                ajcode:1047,
                fans_name:$("#"+witch).val()
            }, function(msg){
                $("#fanslist").html(msg);
            })
        }
    }
}
function show_upphoto(){
    $("#upphoto").css("display","block");

}
function close_upphoto(){
    $("#upphoto").css("display","none");
}
function show_upvideo(){
    $("#upvideo").css("display","block");

}
function close_upvideo(){
    $("#upvideo").css("display","none");
}
function playvideo(){
    var videohtml=$("#videohtml").val();
    $.post(web_domain+'/thinking/ajax.php',{
        ajcode:1005,
        videohtml:videohtml
    }, function(msg){
        if(msg=='error'){
            alert("播放代码不正确，请使用分享地址!");
        }else{
            $("#viewvideo").html(msg);
            $("#shuoshuo_video").val(msg);
            $("#delupvideo").css("display","block");
        }
    });
}
function copyToClipboard(selContent) {
    if(window.clipboardData) {
        window.clipboardData.clearData();
        window.clipboardData.setData("Text", selContent);
        alert("已复制到粘帖板！");
    } else if(navigator.userAgent.indexOf("Opera") != -1) {
        window.location = selContent;
    } else if (window.netscape) {
        try {
            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
        } catch (e) {
            alert("被浏览器拒绝！/n请在浏览器地址栏输入'about:config'并回车/n然后将'signed.applets.codebase_principal_support'设置为'true'");
        }
        var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
        if (!clip)
            return;
        var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
        if (!trans)
            return;
        trans.addDataFlavor('text/unicode');
        var str = new Object();
        var len = new Object();
        var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
        var copytext = selContent;
        str.data = copytext;
        trans.setTransferData("text/unicode",str,copytext.length*2);
        var clipid = Components.interfaces.nsIClipboard;
        if (!clip)
            return false;
        clip.setData(trans,null,clipid.kGlobalClipboard);
        alert("已复制到粘帖板！");
    }
}
function fav_all(id,type){
    var fav_value=$("#fav_value"+id).val();
    var fav_num=parseInt($("#fav_num"+id).html());
    if(fav_value=='1'){
        $("#fav_value"+id).val('0');
        $("#fav_act"+id).html('取消收藏');
        $("#fav_num"+id).html(fav_num+1);
    }else{
        $("#fav_value"+id).val('1');
        $("#fav_act"+id).html('收藏');
        $("#fav_num"+id).html(fav_num-1);
    }
    $.post(web_domain+'/ajax.php',{
        ajcode:1039,
        id:id,
        type:type,
        fav_value:fav_value
    },function(msg){

        });
}
function show_loginreg(type,fromurl){
    $("#zhezhao").show();
    $("#zhezhao").css("height",document.body.scrollHeight);
    $("#login_reg").load(web_domain+"/reg_window.php?fromurl="+fromurl+"&type="+type);

}
function cancel_input(){
    $("#login_reg").html("");
}
function left_regclick(){
    $.post(web_domain+'/ajax.php',{
        ajcode:1041
    },function(msg){

        });
}
function baodao(typenum){
    $.post(web_domain+'/ajax.php',{
        ajcode:1042,
        typenum:typenum
    },function(msg){
        if(msg=='success'){
            window.location.reload();
        }
    });
}
function dazhaohu(to_uid,dzh,evt){
    var iHeight = parseInt(document.documentElement.scrollHeight);
    var _event = evt ? evt : evt.event;
    var divx;
    var divy;
    var scrollHeight=document.documentElement.scrollTop-parseInt('60');
    document.getElementById('op_result').style.top =_event.clientY +scrollHeight+'px';
    document.getElementById('op_result').style.left = _event.clientX +'px';
    $.post(web_domain+'/home/ajax.php',{
        ajcode:1057,
        to_uid:to_uid,
        dzh:dzh
    }, function(msg){
        if(msg=='need_login'){
            $("#op_result").attr("class","box_cue_yellow");
            $("#op_result").html("登陆超时！");
            $("#op_result").animate({
                opacity:'show'
            },'slow');
        }else if(msg=='have_post'){
            $("#op_result").attr("class","box_cue_yellow");
            $("#op_result").html("您今天已经向Ta打过招呼！");
            $("#op_result").animate({
                opacity:'show'
            },'slow');
        }else{
            $("#op_result").attr("class","box_cue_green");
            $("#op_result").html("招呼发出了^_^");
            $("#op_result").animate({
                opacity:'show'
            },'slow');
        }
        setTimeout("$('#op_result').animate({opacity:'hide'},'slow');",2000);
    });
}
var childWindow;
function toQzoneLogin(){
    childWindow = window.open(web_domain+"/connect/qq/oauth/qq_login.php?u=3&c=65039546","TencentLogin","width=600,height=480,menubar=0,scrollbars=1, resizable=1,status=1,titlebar=0,toolbar=0,location=1");
}

function closeChildWindow()
{
    childWindow.close();
}
/* end qq login */
function toSinawbLogin(){
    window.open(web_domain+"/connect/sina/index.php?u=3&c=65039546","SinawbLogin","width=600,height=480,menubar=0,scrollbars=1, resizable=1,status=1,titlebar=0,toolbar=0,location=1");
}
function toRenrenLogin(){
    window.open(web_domain+"/connect/renren/index.php?u=3&c=65039546","RenrenLogin","width=750,height=480,menubar=0,scrollbars=1, resizable=1,status=1,titlebar=0,toolbar=0,location=1");
}
//复制到粘贴板
function copyData(id) {

    var copyText = document.getElementById(id).value;
    window.clipboardData.setData("Text",copyText);

}
function stripscript(s)
{
    var pattern = new RegExp("[`~!@#$^&()=|{}':;',\\[\\].<>/”“")
    var rs = "";
    for (var i = 0; i < s.length; i++) {
        rs = rs+s.substr(i, 1).replace(pattern, '');
    }
    return rs;
}


function cookie(name){
    var cookieArray=document.cookie.split("; "); //得到分割的cookie名值对
    var cookie=new Object();
    for (var i=0;i<cookieArray.length;i++){
        var arr=cookieArray[i].split("=");       //将名和值分开
        if(arr[0]==name)return unescape(arr[1]); //如果是指定的cookie，则返回它的值
    }
    return "";

}



function delCookie(name)//删除cookie
{
    document.cookie = name+"=;expires="+(new Date(0)).toGMTString();
}

//function delCookie(name)//删除cookie
//{
//    var exp = new Date();
//    exp.setTime(exp.getTime() - 1);
//    var cval=getCookie(name);
//    if(cval!=null) document.cookie= name + "="+cval+";expires="+exp.toGMTString();
//}

function getCookie(objName){//获取指定名称的cookie的值
    var arrStr = document.cookie.split("; ");
    for(var i = 0;i < arrStr.length;i ++){
        var temp = arrStr[i].split("=");
        if(temp[0] == objName) return unescape(temp[1]);
    }
}



function addCookie(objName,objValue,objHours){      //添加cookie
    var str = objName + "=" + escape(objValue);
    if(objHours > 0){                               //为时不设定过期时间，浏览器关闭时cookie自动消失
        var date = new Date();
        var ms = objHours*3600*1000;
        date.setTime(date.getTime() + ms);
        str += "; expires=" + date.toGMTString();
    }
    document.cookie = str;

}



function SetCookie(name,value)//两个参数，一个是cookie的名子，一个是值
{
    var Days = 30; //此 cookie 将被保存 30 天
    var exp = new Date();    //new Date("December 31, 9998");
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

function getCookie(name)//取cookies函数
{
    var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
    if(arr != null) return unescape(arr[2]);
    return null;
}

//如 @阿星 123 删除 @阿星 之后利用此函数判断是否为空
//函数功能 删除@name
function deleteAtName(str){
    var newstr1=str.replace(/(^\s*)|(\s*$)/g, "");
    var newstr2=newstr1.replace(/\@.*\s/,"");
    return newstr2;
}

//此函数需要 修改 问题是 如果内容中的..@.. @仍会被计算
//为以后扩展和修改本函数单独提出来
//函数功能 查找@name 数量
function counteAtName(str){
    var atName=str.split('@');
    return atName.length;
}

function hide_smile(){
    $("div[name=face_layer]").css("display","none");
}
function face_close(){
    $("div[name=tan_face]").css("display","none");
}
function at_close(){
    $("div[name=tan_at]").css("display","none");
}
function photo_close(){
    $("div[name=tan_photo]").css("display","none");
}
function video_close(){
    $("div[name=tan_video]").css("display","none");
}
//显示信息
//_event:event对象
//data:显示的信息
//cls:class 默认是 box_cue_yellow
function show_message(_event,data,cls){
    var scrollHeight=document.documentElement.scrollTop-parseInt('60');
    document.getElementById('message').style.top =_event.clientY +scrollHeight+'px';
    document.getElementById('message').style.left = _event.clientX +'px';
    $("#message").removeClass();
    $("#message").addClass(cls);
    $("#message").html(data);
    $("#message").animate({
        opacity:'show'
    },'slow');
    setTimeout("$('#message').animate({opacity:'hide'},'slow');",2000);
    return false;
}