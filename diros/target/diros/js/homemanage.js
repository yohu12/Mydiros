$(function(){

    //========================电影=============================================
    $("a[name=movie_delete]").live('click', function() {
        var id=$(this).attr('num');
        $("#com_"+id).load(web_domain+'/app/manage/movie_comment.php?act=delete&id='+id);
        $("#com_"+id).hide();
    });

    $("a[name=movie_digest]").live('click', function() {
        var id=$(this).attr('num');
        var  comment=$("#com_"+id);
        var _this=$(this);
        $.post(web_domain+'/app/manage/movie_comment.php?act=digest&id='+id, function(data){
            if(data == 1){
                if(comment.find('*[name=digest]').is(":hidden")){
                    comment.find('*[name=digest]').show();
                    _this.html('取消精');
                }else{
                    comment.find('*[name=digest]').hide();
                    _this.html('精');
                }
            }
        });
    });
    //========================电影=============================================
    //    思想回复 删
    $("a[name=thinking_comment_delete]").live('click', function() {
        var id=$(this).attr('num');
        $("#com_"+id).load(web_domain+'/app/manage/thinking_comment.php?act=delete&id='+id);
        $("#com_"+id).hide();
    });

    //    思想回复 提
    $("a[name=thinking_comment_up]").live('click', function() {
        var id=$(this).attr('num');
        var parentid=$(this).attr('parentid');
        $.post(web_domain+'/app/manage/thinking_comment.php?act=up&id='+id, function(data){
            if(data == 1){
                $.post(web_domain+'/thinking/ajax.php',{
                    ajcode:1002,
                    id:parentid
                },function(html){
                    $("#comment_list"+parentid).html(html);
                });
            }
        });
    });
    //思想回复 固
    $("a[name=thinking_comment_top]").live('click', function() {
        var id=$(this).attr('num');
        $.post(web_domain+'/app/manage/thinking_comment.php?act=top&id='+id, function(data){
            if(data == 1){
                window.location.reload();
            }
        });
    });

    //    思想 删
    $("a[name=thinking_delete]").live('click', function() {
        var id=$(this).attr('num');
        $("#ss_"+id).load(web_domain+'/app/manage/thinking.php?act=delete&id='+id);
        $("#ss_"+id).hide();
    });
    //    思想 提
    $("a[name=thinking_up]").live('click', function() {
        var id=$(this).attr('num');
        var _this=$(this);
        $.post(web_domain+'/app/manage/thinking.php?act=up&id='+id, function(data){
            if(data == 1){
                var content = _this.parents('.content').html();
                $("#active_content").prepend('<div id="ss_'+id+'" class="content clearfix">'+content+'</div>');
                _this.parents('.content').remove();
            }
        });
    });

    //思想 固
    $("a[name=thinking_top]").live('click', function() {
        var id=$(this).attr('num');
        var top=$(this).attr('top');

        var _this=$(this);
        $.post(web_domain+'/app/manage/thinking.php?act=top&id='+id, function(data){
            if(data == 1){
                if($('#'+top).is(":hidden")){
                    $('#'+top).show();
                    _this.html('取消固');
                }else{
                    $('#'+top).hide();
                    _this.html('固');
                }
                var content = _this.parents('.content').html();
                $("#active_content").prepend('<div id="ss_'+id+'" class="content clearfix">'+content+'</div>');
                _this.parents('.content').remove();
            }
        });
    });

    //思想 精
    $("a[name=thinking_digest]").live('click', function() {
        var id=$(this).attr('num');
        var digest=$(this).attr('digest');
        var _this=$(this);

        $.post(web_domain+'/app/manage/thinking.php?act=digest&id='+id, function(data){
            if(data == 1){
                if($('#'+digest).is(":hidden")){
                    $('#'+digest).show();
                    _this.html('取消精');
                }else{
                    $('#'+digest).hide();
                    _this.html('精');
                }
            }
        });
    });

    //==========================================================================
    //小组回复 删除
    $("a[name=group_comment_delete]").live('click', function() {
        var id=$(this).attr('num');
        $("#com_"+id).load(web_domain+'/app/manage/group_comment.php?act=delete&id='+id);
        $("#com_"+id).hide();
    });

    //小组回复 提
    $("a[name=group_comment_up]").live('click', function() {
        var id=$(this).attr('num');
        $.post(web_domain+'/app/manage/group_comment.php?act=up&id='+id, function(data){
            if(data == 1){
                var content= $('#com_'+id).html();
                $('#com_'+id).remove();
                $("#comment_list").prepend('<div id="com_'+id+'" class="content clearfix" style="border: 0;" name="commentlist" >'+content+'</div>');
            }
        });
    });

});


