var seckill =
    {
        URL: {},

        //校验手机号是否有效
        validatMobile: function (mobile) {
            if (mobile && mobile.length == 11 && !isNaN(mobile)) {
                alert(true);
                return true;
            } else {
                alert(false);
                return false;
            }
        },

        list:{
            init:function () {
                var jsessionid = $.cookie("JSESSIONID");
                alert(jsessionid);
            }
        },

        //详情页面js
        detail: {
            init: function (parame) {
                //手机号验证
                var killMobile = $.cookie("killMobile");
                var seckillId = parame["seckillId"];
                var startTime = parame["startTime"];
                var endTime = parame["endTime"];

                if (!seckill.validatMobile(killMobile)) {
                    //显示弹出层
                    var killMobileModal = $("#killMobileModal");
                    killMobileModal.modal({
                        show: true,//显示弹出层
                        backdrop: 'static',//禁止位置关闭
                        keyboard: false//关闭键盘事件
                    });
                }
                //提交电话按钮事件
                $("#killMobileBtn").click(function () {
                    var inputMobile = $("#killMobile").val();
                    if (seckill.validatMobile(inputMobile)) {
                        //写cookie
                        $.cookie('killMobile', inputMobile, {expires: 7, path: '/demo'});
                        //刷新页面
                        window.location.reload();
                    } else {
                        $("#killMobileMessage").hide().html('<label class="label label-danger">手机号错误！</label>').show(500);
                    }
                });
            }
        }
    };
var abc = {};

            