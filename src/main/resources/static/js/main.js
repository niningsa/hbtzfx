// 手机号键盘输入
$("#userName").keyup(function () {
    if ($(this).val()) {
        $(".alert").addClass('hidden');
    }
});

// 手机号键盘输入
$("#tellnumber").keyup(function () {
    if (isPoneAvailable($(this).val())) {
        $(".alert").addClass('hidden');
    }
});

// 验证码键盘输入
$("#codes").keyup(function () {
    if ($(this).val()) {
        $(".alert").addClass('hidden');
    }
});

// 点击搜索按钮
$("#confSearch").click(function () {
    var desction = $.trim($("#desction").val());
    if (desction) {
        $("#myModal").modal("toggle");
    } else {
        alert("请输入搜索内容");
    }
});

// 保存事件
$("#save").click(function() {
    var searchType = $("#searchType").val();
    var desction = $.trim($("#desction").val());
    var userName = $.trim($("#userName").val());
    var tellnumber = $.trim($("#tellnumber").val());
    var codes = $.trim($("#codes").val());
    var err = $("#err");
    // $(".alert").removeClass('hidden');
    console.log(searchType+" "+desction+" "+userName+" "+tellnumber);

    if (!userName || !tellnumber) {
        $(".alert").removeClass('hidden');
        err.html("请将数据填写完成");
        return false;
    }
    if (!isPoneAvailable(tellnumber)) {
        $(".alert").removeClass('hidden');
        err.html("手机号码格式有误");
        return false;
    }

    $.ajax({
        url: "tel/validateCodes",
        type: "GET",
        data: "code="+codes,
        success: function (res) {
            console.log(res);
            if (res.code == 200) {
                $("#save").addClass("disabled");
                $("#save").attr("disabled", true);
                $.ajax({
                    url: "tel/saveTel",
                    type: "GET",
                    data: "searchType="+searchType+"&desction="+desction+"&userName="+userName+"&tellnumber="+tellnumber,
                    success: function (res) {
                        console.log(res);
                        if (res.code == 200) {
                            alert("信息已提交.客服将在48小时内与您联系");
                            $("#save").removeClass("disabled");
                            $("#save").attr("disabled", false);
                            $('#myModal').modal('hide');
                        }
                    }
                });
            } else {
                $(".alert").removeClass('hidden');
                err.html("验证码填写错误");
            }
        }
    });
});

// 模态框关闭时触发
$("#myModal").on("hidden", function () {
    console.log("模态框隐藏了");
    $("#desction").val("");
    $("#searchType").val("全站");
    $("#searchContent").val("");
    $("#userName").val("");
    $("#telnumber").val("");
});

// 是否是手机格式
function isPoneAvailable(str) {
    var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
    if (!myreg.test(str)) {
        return false;
    } else {
        return true;
    }
}

// 刷新图片
function changeImg() {
    var imgSrc = $("#imgObjs");
    var src = imgSrc.attr("src");
    imgSrc.attr("src", changeUrl(src));
}

//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳
function changeUrl(url) {
    var timestamp = (new Date()).valueOf();
    var index = url.indexOf("?",url);
    if (index > 0) {
        url = url.substring(index, url.indexOf(url, "?"));
    }
    if ((url.indexOf("&") >= 0)) {
        url = url + "×tamp=" + timestamp;
    } else {
        url = url + "?timestamp=" + timestamp;
    }
    return url;
}