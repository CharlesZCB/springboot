<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" href="/js/jquery/2.0.0/jquery.min.js"></script>
    <script type="text/javascript" href="/js/bootstrap/3.3.6/bootstrap.js"></script>
    <link href="/css/bootstrap/3.3.6/bootstrap-theme.css" rel="stylesheet">
    <link href="/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
</head>

<body>
<!--数据遍历-->
<table class="table table-striped">
    <#list pageInfo.list! as lists>
    <!-- On rows -->
    <tr class="active">
        <td>姓名：${lists.name!}</td>
        <td>年龄：${lists.age!}</td>
        <td><a href="del?id=${lists.id!}">删除</a></td>
    </tr>
</#list>

</table>

<!--分页按钮-->
<nav aria-label="Page navigation">
    <ul class="pagination">

        <li>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>

        <li><a href="showall?pn=1">1</a></li>
        <li><a href="showall?pn=2">2</a></li>
        <li><a href="showall?pn=3">3</a></li>
        <li><a href="showall?pn=4">4</a></li>
        <li><a href="showall?pn=5">5</a></li>
        <li>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>
</nav>

<a href="/">增加人员</a><br>
<img src="/qq.jpg">
</body>
</html>
