var seckill =
    {
        URL: {
            nowTime: function () {
                return '/demo/seckill/time/now';
            },
            querySeckillInfo: function (seckillId) {
                return '/demo/seckill/' + seckillId + '/info'
            },
            doingSeckill: function (seckillId, md5) {
                return '/demo/seckill/' + seckillId + '/' + md5+'/doing';
            }

        },


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

        //倒计时秒杀
        countdownTime: function (seckillId, nowTime, startTime, endTime) {
            var seckillBox = $("#seckill-box");
            if (nowTime > endTime) {
                seckillBox.html('秒杀结束了，下次要早点哦！');
            } else if (nowTime < startTime) {
                var killTime = new Date(startTime + 1000);
                seckillBox.countdown(killTime, function (event) {
                    var format = event.strftime('秒杀倒计时：%D天 %H时 %M分 %S秒');
                    seckillBox.html(format);
                }).on('finish.countdown', function (seckillId, node) {
                    //处理秒杀
                    seckill.handelSeckill(seckillId, seckillBox);
                });
            } else {
                //处理秒杀
                seckill.handelSeckill(seckillId, seckillBox);
            }
        },

        //处理秒杀
        handelSeckill: function (seckillId, node) {
            //开启秒杀按钮
            node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">秒杀</button>');

            //获取秒杀地址
            $.post(seckill.URL.querySeckillInfo(seckillId), {}, function (result) {
                if (result && result['state']) {
                    var info = result['data'];
                    if (info['opened']) {
                        var md5 = info['md5'];
                        var killUrl = seckill.URL.doingSeckill(seckillId, md5);
                        console.log("killurl" + killUrl);
                        alert(killUrl);

                        //按钮绑定秒杀事件
                        $("#killBtn").one('click', function () {
                            $(this).addClass('disabled');
                            //执行秒杀
                            $.post(killUrl, {}, function (result) {
                                if (result && result['state']) {
                                    var killedResult = result['data'];
                                    var killedState = killedResult['killedState'];
                                    var killedStateInfo = killedResult['killedStateInfo'];
                                    node.html('<span class="label label-success">' + killedStateInfo + '</span>')
                                }else{
                                    var errorInfo = result['error'];
                                    node.html('<span class="label label-success">' + errorInfo + '</span>');
                                }
                            });
                        });
                        node.show();
                    } else {
                        var now = info['nowTime'];
                        var start = info['startTime'];
                        var end = info['endTime'];

                        seckill.countdownTime(seckillId, now, start, end);
                    }
                } else {
                    console.log('result' + result);
                }
            });
        },

        //列表页面js
        list: {
            init: function () {
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

                //计时器交互
                $.get(seckill.URL.nowTime(), {}, function (result) {
                    if (result && result['state']) {
                        var nowTime = result['data'];
                        seckill.countdownTime(seckillId, nowTime, startTime, endTime);
                    } else {
                        console.log('result:' + result);
                    }
                })
            }
        }
    };
var abc = {};

            