$(function(){
    $("#apply_button").click(function(){
        var group_id=$("#apply_button").attr('group_id');
        var join_reason=$("#join_reason").val();
        if(join_reason == ''){
            $("#apply_content").hide();
            $("#apply_msg").removeClass();
            $("#apply_msg").addClass('box_cue_yellow');
            $("#apply_msg").html("申请信息不能为空");
            $("#apply_msg").show();
            setTimeout('$("#apply_msg").hide()', 2000);
            $("#zhezhao").hide();
            return false;
        }

        $.ajax({
            type: "POST",
            url: web_domain+"/group/group.php",
            data: "act=apply&group_id="+group_id+"&join_reason="+join_reason,
            success: function(msg){
                $("#zhezhao").hide();
                if(msg==1){
                    $("#apply_content").hide();
                    $("#apply_msg").removeClass();
                    $("#apply_msg").addClass('box_cue_green');
                    $("#apply_msg").html('您的信息已经提交，小集体管理员将审核您的信息请耐心等待。');
                    $("#apply_msg").show();
                    setTimeout('window.location.reload()', 2000);
                }else{
                    $("#apply_content").hide();
                    $("#apply_msg").removeClass();
                    $("#apply_msg").addClass('box_cue_yellow');
                    $("#apply_msg").html(msg);
                    $("#apply_msg").show();
                    setTimeout('window.location.reload()', 2000);
                }
            }
        });
    });
    $("#quit").click(function(){
        var group_id=$("#group_id").val();
        $.ajax({
            type: "POST",
            url: web_domain+"/group/group.php",
            data: "act=quit&group_id="+group_id,
            success: function(msg){
                window.location.reload();
            }
        });
    });

    //添加回复信息
    $("#add_comment_submit").click(function(){
        var html='';
        var group_id=$("#group_id").val();
        var topic_id=$("#topic_id").val();
        var comment_content=$("#comment_content").val();
        var photoarray = $("#photoid").val();
        $("input[photo=true]").each(function(i){
            html= html + "&"+$(this).attr('name')+"="+$(this).val();
        });
        $.ajax({
            type: "POST",
            url: web_domain+"/group/comment.php",
            data: "group_id="+group_id+"&topic_id="+topic_id+"&comment_content="+comment_content+"&comment_content="+comment_content+"&photoarray="+photoarray+html,
            success: function(msg){
                $("#photolist").html('');
                $("#photolist").attr('num','0');
                $("#comment_list").html('<img style="margin-left: 400px;" src="'+web_domain+'/images/loading.gif"/>');
                $("#comment_list").load(web_domain+"/group/topic_comment.php?id="+topic_id);
            }
        });
        $("#comment_content").val("");
    });

    //发布主题
    $("#add_topic_submit").click(function(_event){
        var scrollHeight=document.documentElement.scrollTop-parseInt('60');
        document.getElementById('message').style.top =_event.clientY +scrollHeight+'px';
        document.getElementById('message').style.left = _event.clientX +'px';
        if($("#topic_title").val() == ''){
            $("#message").html("标题不能为空");
            $("#message").show();
            setTimeout(function(){
                $("#message").hide()
            },2000);
            return false;
        }

        if($("#topic_content").val() == ''){
            $("#message").html("内容不能为空");
            $("#message").show();
            setTimeout(function(){
                $("#message").hide()
            },2000);
            return false;
        }

        $("#topic_form").submit();
    });

    $("#reply").click(function(){
        if($("#reply_content").css("display")=='none'){
            $("#reply_content").show("slow");
        }else{
            $("#reply_content").hide("slow");
        }
    });
});

function zan(cid,bid,evt){
    var iHeight = parseInt(document.documentElement.scrollHeight);
    var _event = evt ? evt : evt.event;
    var divx;
    var divy;
    var scrollHeight=document.documentElement.scrollTop-parseInt('60');
    document.getElementById('op_result').style.top =_event.clientY +scrollHeight+'px';
    document.getElementById('op_result').style.left = _event.clientX +'px';
    var is_zan=$("#is_zan"+bid).val();
    $.post(web_domain+"/ajax.php",{
        ajcode:1038,
        is_source:'1',
        source_id:bid,
        source_id2:cid,
        type:19,
        is_zan:is_zan
    }, function(msg){
        var str_header=msg.substr(0,6);
        var zan_num=msg.substr(6,6);
        if(msg=='success'){
            $("#znum_"+bid).html('取消赞');
            $("#is_zan"+bid).val('0');
        }else if(str_header=='cancel'){
            var newnum=parseInt(zan_num);
            $("#znum_"+bid).html('赞('+newnum+')');
            $("#is_zan"+bid).val('1');
        }else{
            $("#op_result").attr("class","box_cue_yellow");
            $("#op_result").html(msg);
            $("#op_result").animate({
                opacity:'show'
            },'slow');
            setTimeout("$('#op_result').animate({opacity:'hide'},'slow');",2000);
        }
    });
}

function show_smile(which){
    $("#smile_content"+which).css("display","block");
    change_smile('default',which);
}

function change_smile(typename,which){
    $("#detail"+which).html("&nbsp;&nbsp;<img src='"+web_domain+"/images/loading.gif'>");
    $("#detail"+which).load(web_domain+"/home/smile_file.php?type="+typename+"&which="+which);
}

function reply(write_name){
    $('#comment_content').val($('#comment_content').val() + write_name + ' ');
}

function apply_close(){
    $("#zhezhao").hide();
    $("#apply_content").hide();
}

function apply_open(id){
    $("#apply_content").show();
    $("#zhezhao").show();
    $("#zhezhao").css("height",document.body.scrollHeight);
    $("#apply_button").attr('group_id',id);
}