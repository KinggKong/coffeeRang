<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 10/9/2024
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HomePage</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <div>
<%--            th1: selected_line có --%>
        <c:if test="${selected_line == ''}">
            <select onchange="line_change()" id="selected_line" name="selected_line">
                <option value="0" selected>--select--</option>
                <c:forEach var="item" items="${list_line}">
                    <option value="${item}"><c:out value="${item}"></c:out></option>
                </c:forEach>
            </select>
        </c:if>
        <c:if test="${selected_line != ''}">
            <select onchange="line_change()" id="selected_line" name="selected_line">
                <option value="0" >--select--</option>
                <c:forEach var="item" items="${list_line}">
                    <c:if test="${item == selected_line}">
                        <option value="${item}" selected><c:out value="${item}"></c:out></option>
                    </c:if>
                    <option value="${item}"><c:out value="${item}"></c:out></option>
                </c:forEach>
            </select>
        </c:if>


            <input type="text" name="input_search_code" id="input_search_code">
            <input type="text" name="input_search_name" id="input_search_name">

            <a href="#">Tìm kiến</a>
        </div>
        <tr>
            <th>Mã</th>
            <th>Tên</th>
            <th>Line</th>

        </tr>
        <c:forEach var="product" items="${list_product}">
            <tr>
                <td><c:out value="${product.product_code}" /></td>
                <td><c:out value="${product.product_name}" /></td>
                <td><c:out value="${product.product_line}" /></td>
<%--                <td>--%>
<%--                    <a href="/edit?id=<c:out value='${book.id}' />">Edit</a>--%>
<%--                    &nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--                    <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>--%>
<%--                </td>--%>
            </tr>
        </c:forEach>
    </table>
</div>
<script !src="">
    function line_change(){
      //tạo ra cái j đó để call về
        let line_select = $("#selected_line").val()
        let input_search_code = $("#input_search_code").val();
        let input_search_name = $("#input_search_name").val();
    // $.ajax({
    //     method: "GET",
    //     url: "/CoffeeRang_war_exploded/ServletSearchByLine?selected_line="+line_select,
    // })
        let url = ""
        if (input_search_code !=''){
            url +="&input_search_code="+input_search_code
        }
        if (input_search_name !=""){
            url +="&input_search_name="+input_search_name
        }
        if (url !=""){
            window.location.href = "/CoffeeRang_war_exploded/ServletSearchByLine?selected_line="+line_select+url;
        }else {
            window.location.href = "/CoffeeRang_war_exploded/ServletSearchByLine?selected_line="+line_select
        }



    }
</script>
</body>
</html>
