<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="soft.pojo.User" %>
<%@ page import="java.util.Vector" %>
<%@ page import="soft.pojo.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>Title</title>
    <style>
        *{
            box-sizing: border-box;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
        }
        body{
            font-family: Helvetica;
            -webkit-font-smoothing: antialiased;
            background: #FFFFFF;
        }
        a:link,a:visited{
            text-decoration:none;
        }
        h2{
            text-align: center;
            font-size: 18px;
            text-transform: uppercase;
            letter-spacing: 1px;
            color: white;
            padding: 30px 0;
        }

        /* Table Styles */

        .table-wrapper{
            margin: 10px 70px 70px;
            box-shadow: 0px 35px 50px rgba( 0, 0, 0, 0.2 );
        }

        .fl-table {
            border-radius: 5px;
            font-size: 12px;
            font-weight: normal;
            border: none;
            border-collapse: collapse;
            width: 100%;
            max-width: 100%;
            white-space: nowrap;
            background-color: white;
        }

        .fl-table td, .fl-table th {
            text-align: center;
            padding: 8px;
        }

        .fl-table td {
            border-right: 1px solid #f8f8f8;
            font-size: 12px;
        }

        .fl-table thead th {
            color: #ffffff;
            background: #4FC3A1;
        }


        .fl-table thead th:nth-child(odd) {
            color: #ffffff;
            background: #324960;
        }

        .fl-table tr:nth-child(even) {
            background: #F8F8F8;
        }

        /* Responsive */

        @media (max-width: 767px) {
            .fl-table {
                display: block;
                width: 100%;
            }
            .table-wrapper:before{
                content: "Scroll horizontally >";
                display: block;
                text-align: right;
                font-size: 11px;
                color: white;
                padding: 0 0 10px;
            }
            .fl-table thead, .fl-table tbody, .fl-table thead th {
                display: block;
            }
            .fl-table thead th:last-child{
                border-bottom: none;
            }
            .fl-table thead {
                float: left;
            }
            .fl-table tbody {
                width: auto;
                position: relative;
                overflow-x: auto;
            }
            .fl-table td, .fl-table th {
                padding: 20px .625em .625em .625em;
                height: 60px;
                vertical-align: middle;
                box-sizing: border-box;
                overflow-x: hidden;
                overflow-y: auto;
                width: 120px;
                font-size: 13px;
                text-overflow: ellipsis;
            }
            .fl-table thead th {
                text-align: left;
                border-bottom: 1px solid #f7f7f9;
            }
            .fl-table tbody tr {
                display: table-cell;
            }
            .fl-table tbody tr:nth-child(odd) {
                background: none;
            }
            .fl-table tr:nth-child(even) {
                background: transparent;
            }
            .fl-table tr td:nth-child(odd) {
                background: #F8F8F8;
                border-right: 1px solid #E6E4E4;
            }
            .fl-table tr td:nth-child(even) {
                border-right: 1px solid #E6E4E4;
            }
            .fl-table tbody td {
                display: block;
                text-align: center;
            }
        }
    </style>
</head>
<body>
<h3>查询所有用户信息如下：</h3>

<div class="table-wrapper">
    <table class="fl-table">
        <thead>
    <tr height=50px; onmouseover="this.style.backgroundColor='#D7FFF0';"onmouseout="this.style.backgroundColor='#FFFFFF';">
        <th>编号</th>
        <th>用户编号</th>
        <th>姓名</th>
        <th>头像</th>
        <th>内容</th>
        <th>发布时间</th>

        <th></th>
    </tr>
        </thead>
    <%
        List<Comment> v =(List<Comment>)request.getAttribute("allComment");
        Iterator<Comment> it = v.iterator();
        int count=0;
        Comment bean;
        while(it.hasNext())
        {

            bean = it.next();
                count++;
    %>
        <tbody>
    <tr onmouseover="this.style.backgroundColor='#D7FFF0';"onmouseout="this.style.backgroundColor='#FFFFFF';" >
        <td width=100px><%=bean.getId()%></td>
        <td width=100px><%=bean.getPid()%></td>
        <td width=100px><%=bean.getName()%></td>
        <td width=100px><%=bean.getHeadportrait()%></td>
        <td width=100px><%=bean.getContent()%></td>
        <td width=100px><%=bean.getSendtime()%></td>
        <td style="width:30%">
<%--           <a href="admin/goToUpdateComment?name=<%=bean.getId()%>">&nbsp;&nbsp;&nbsp;修改&nbsp;&nbsp;&nbsp;&nbsp;</a>--%>
            <a href="admin/deleteComment?id=<%=bean.getId()%>"
             onclick="return confirm('你确定要删除该记录吗？')">删除</a>
        </td>
    </tr>
        </tbody>
    <%
        }
    %>
</table>
</div>
</body>
</html>
