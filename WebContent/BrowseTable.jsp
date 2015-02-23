<!-- BrowseTable.jsp -->
<%@ page import = "com.dayle.model.User" %>
<jsp:useBean id = "dBBeanId" scope = "session" 
  class = "com.dayle.util.DbUtil">
</jsp:useBean>
<%@ page import = "java.sql.*" %>
<html>
  <head>
    <title>BrowseTable</title>
  </head>
  <body>

  <% String userId = request.getParameter("userId");
     String usgType = request.getParameter("usgType");
     
     // ResultSet rsColumns = dBBeanId.getConnection().getMetaData().getColumns(null, null, user, null);
  %>
  <table border = "1">
    

    <% Statement statement = dBBeanId.getConnection().createStatement();
       ResultSet rs = statement.executeQuery(
         "select * from User where user_id=" +userId+ ", usg_type=" +usgType);

       // Get column count
       int columnCount = rs.getMetaData().getColumnCount();

       // Store rows to rowData
       while (rs.next()) {
         out.println("<tr>");
         for (int i = 0; i < columnCount; i++) { %>
           <td><%= rs.getObject(i + 1) %></td>
     <%  }
         out.println("</tr>");
       } %>
  </table>
  </body>
</html> 
