<%@ tag body-content="scriptless" isELIgnored="false" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri='/WEB-INF/tags/ryc.tld' prefix='ryc'%>
<%@ taglib tagdir="/WEB-INF/tags/ryctag/" prefix="ryctag"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ attribute name="title" required="true" type="java.lang.String"%>
<%@ attribute name="list" required="true" type="java.util.List"%>
<%@ attribute name="number" required="true" type="java.lang.String"%>
<%@ attribute name="content" required="true" type="java.lang.String"%>
<%@ attribute name="content2" required="true" type="java.lang.String"%>
<%@ attribute name="bouteille" required="true" type="java.lang.String"%>

	<tr>
		<td>${title}</td>
		<td><input name="${content2}" value="${bouteille}"/>
			<select name="${content}" onchange="displaycontent${number}(this);">
				<c:forEach items="${list}" var="lst">
					<option value="${lst}">${lst}</option>
				</c:forEach>			
			</select>
		</td>
	</tr>