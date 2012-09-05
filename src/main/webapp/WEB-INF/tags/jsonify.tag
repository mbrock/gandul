<%@ tag import="org.codehaus.jackson.map.ObjectMapper" %>
<%@ attribute name="value" required="true" rtexprvalue="true" type="java.lang.Object" %>
<%= new ObjectMapper().writeValueAsString(value) %>