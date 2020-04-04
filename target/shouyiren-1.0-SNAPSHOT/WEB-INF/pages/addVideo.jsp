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
            margin: 100px 350px 70px;
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
            border: 1px solid #FFFFFF;
            text-align: center;
            padding: 8px;
        }

        .fl-table td {
            border: 1px solid #FFFFFF;
            border-right: 1px solid #f8f8f8;
            font-size: 12px;
        }

        .fl-table thead th {
            border: 1px solid #FFFFFF;
            width:50%;
            color: #000000;
            background: rgba(89, 96, 86, 0.19);
        }


        .fl-table thead th:nth-child(odd) {
            border: 1px solid #FFFFFF;
            color: #000000;
            background: rgba(89, 96, 86, 0.19);
        }

        .fl-table tr:nth-child(even) {
            border: 1px solid #FFFFFF;
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
                border-bottom: 1px solid #FFFFFF;
            }
            .fl-table thead th {
                text-align: left;
                border-bottom: 1px solid #FFFFFF;

            }
            .fl-table tbody tr {
                display: table-cell;
                border-bottom: 1px solid #FFFFFF;
            }
            .fl-table tbody tr:nth-child(odd) {
                background: none;
                border-bottom: 1px solid #FFFFFF;
            }
            .fl-table tr:nth-child(even) {
                background: transparent;
                border-bottom: 1px solid #FFFFFF;
            }
            .fl-table tr td:nth-child(odd) {
                background: #F8F8F8;
                border-right: 1px solid #FFFFFF;
            }
            .fl-table tr td:nth-child(even) {
                border-right: 1px solid #FFFFFF;
            }
            .fl-table tbody td {
                display: block;
                text-align: center;
            }
        }
    </style>
</head>
<body>

<div class="table-wrapper">
    <h3>请在下面填表填写视频信息</h3><br>
<%--    //后面那段话必须加--%>
    <form  action="admin/addVideo"  method="post" enctype="multipart/form-data">
        <table class="fl-table">
            <thead>
            <tr>
                <th>视频名称</th>
                <th> <input type="text" name="name" placeholder="请输入视频名称"></th>
            </tr>
            </thead>
            <thead>
            <tr>
                <th>视频类别</th>
                <th> <input type="text" name="categories" placeholder="请输入视频类别"></th>
            </tr>
            </thead>
            <thead>
            <tr>
                <th>视频图片</th>
                <th> <input type="file" name="headImg"></th>
            </tr>
            </thead>
            <thead>
            <tr>
                <th>视频细节</th>
                <th> <input type="text" name="detail" placeholder="请输入视频细节"></th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <th></th>
                <th>
                    <button><input class="myinput" type="submit" value="添加&nbsp;&nbsp;&nbsp;&nbsp;" /></button>
                    <button><input class="myinput" type="Reset" value="重置&nbsp;&nbsp;&nbsp;&nbsp;"/></button>
                </th>
            </tr>
            </tbody>
        </table>
    </form>
</div>
</body>
</html>