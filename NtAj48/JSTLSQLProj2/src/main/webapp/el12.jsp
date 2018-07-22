<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Establish the connection -->
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver"
                   url="jdbc:oracle:thin:@localhost:1521:xe"
                   user="system" password="manager"/>

<!-- Execute SQL Query -->
<sql:query dataSource="${ds}" var="rs" sql="select * from student"/>

<!-- Process the result -->

<c:forEach var="st" items="${rs.rows}">
   ${st.sno} &nbsp; ${st.sname} &nbsp;${st.sadd} &nbsp; <br>
</c:forEach>


                   
                   














