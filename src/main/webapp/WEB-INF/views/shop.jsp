<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Shop</title>
</head>
<body>
<h3>Welcome ${user.name}</h3>
<c:choose>
    <c:when test="${sessionScope.loggedInUser == null}">
        <p>You entered as guest!</p>
        <br/>
    </c:when>
    <c:otherwise>
        You entered as ${sessionScope.loggedInUser.name}
        <form action="logoff">
            <button type="submit">Log off</button>
        </form>
        <br />
    </c:otherwise>
</c:choose>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Add</th>
    </tr>
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td><a href="user/addToBucket?item_id=${item.id}">Add</a></td>
        </tr>
    </c:forEach>
</table>
<br>
<a href="user/bucket">Show user's bucket</a>
<br>
<a href="user/showAllOrders">Show user's orders</a>
</body>
</html>
