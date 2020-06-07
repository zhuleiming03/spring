<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<p>
    Web访问 <a href="<%=request.getContextPath()%>/index">click</a>
</p>

<ul>Rest访问
    <li>Json get url: http://localhost:8080/restful_base_war/rest/json</li>
    <li>Json post url: http://localhost:8080/restful_base_war/rest/json?userId=909</li>
    <li>xml get url: http://localhost:8080/restful_base_war/rest/xml</li>
</ul>

</body>
</html>
