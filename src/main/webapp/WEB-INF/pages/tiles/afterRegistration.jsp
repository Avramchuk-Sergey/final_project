<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename= "by.htp.ex.localization.locale" var="loc"/>

<fmt:message bundle="${loc}" key="afterRegistration.completeMessage" var="complete_message" />
<fmt:message bundle="${loc}" key="afterRegistration.mainPageButton" var="main_page_button" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
    <form action="controller" method="post">
       <input type="hidden" name="command" value="go_to_base_page"/>
      <h1> ${complete_message} </h1>
      
       
       <input type="submit" value="${main_page_button}"><br/>
       
  </form>
</body>
</html>