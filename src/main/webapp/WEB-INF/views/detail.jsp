<!DOCTYPE html>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>秒杀商品详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default ">
        <div class="panel-handling text-center"><h2>${seckill.name}</h2></div>
        <div class="panel-body">
            <h2 class="text-danger">
                <span class="glyphicon glyphicon-time"></span>
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
        </div>
    </div>
</div>

<div id="killMobileModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>秒杀电话：
                </h3>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killMobile" id="killMobile" placeholder="请填写手机号..."
                               class="form-control">
                    </div>
                </div>
            </div>

            <div class="modal-footer">
                <span id="killMobileMessage" class="glyphicon"></span>
                <button type="button" id="killMobileBtn" class="btn btn-success">
                    <span class="glyphicon glyphicon-phone"></span>
                    提交
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>

<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<%--<script src="http://cdn.bootcss.com/jquery-countdown/2.0.1/jquery.countdown.min.js"></script>--%>
<%--<script src="http://libs.cncdn.cn/jquery-countdown/2.0.0/jquery.countdown.min.js"></script>--%>
<script src="/demo/statics/seckill.js" type="text/javascript"></script>

<script type="text/javascript">
    $(function () {
        seckill.detail.init({
            seckillId:${seckill.seckillId},
            startTime:${seckill.startTime.time},
            endTime:${seckill.endTime.time}
        });
    });

</script>