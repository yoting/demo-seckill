<!DOCTYPE html>
<%@include file="common/tag.jsp" %>
<html>
<head>
    <title>秒杀列表</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="common/head.jsp" %>
</head>
<body>
<div class="container">
    <div class="panel panel-default ">
        <div class="panel-handling text-center"><h2>秒杀列表</h2></div>
        <div class="panel-body">
            <table class="table table-hover">
                <tr>
                    <th>商品名称</th>
                    <th>库存</th>
                    <th>开始时间</th>
                    <th>结束时间</th>
                    <th>详情</th>
                </tr>
                <c:forEach var="item" items="${list}">
                    <tr>
                        <td>${item.name}</td>
                        <td>${item.number}</td>
                        <td><fmt:formatDate value="${item.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><fmt:formatDate value="${item.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><a class="btn btn-info" href="/seckill/seckill/${item.seckillId}/detail">去看看</a></td>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </div>
</div>
</body>
</html>
