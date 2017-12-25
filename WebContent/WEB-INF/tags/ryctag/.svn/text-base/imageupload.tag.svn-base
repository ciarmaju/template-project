<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<%@ attribute name="action" required="true"%>
<%@ attribute name="rename" required="true" type="java.lang.Boolean"%>
<%@ attribute name="id" type="java.lang.Long" required="false" %>

<p>(Attention l'image doit faire moins de 1.5 Mo)</p>
<form method="post" action="${action}fromurl" style="width:500px;">
    <fieldset>
        <legend>à partir d'un autre site web</legend>
        <label for="fileurl">URL: </label><input type="url" name="fileurl" required="required" style="width:495px;" /><br /> 
        <c:if test="${rename}">
            <label for="name">nom de l'image: </label>
            <input type="text" name="name" required="required" style="width:495px;" /><br /> 
        </c:if>
        <input type="hidden" name="id" value="${id}" /><input type="submit" value="Ajouter" style="float:right;" /><br />
    </fieldset>
</form>