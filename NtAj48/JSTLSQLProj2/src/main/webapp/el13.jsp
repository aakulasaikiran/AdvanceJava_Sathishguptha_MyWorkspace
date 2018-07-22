<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Establish the connection -->
<sql:setDataSource var="ds" driver="oracle.jdbc.driver.OracleDriver"
                   url="jdbc:oracle:thin:@localhost:1521:xe"
                   user="system" password="manager"/>

<!-- Execute SQL Query -->

 <sql:update var="count" dataSource="${ds}" sql="insert into student values(?,?,?)">
 <sql:transaction dataSource="${ds}">
    <sql:param value="22321"/>
    <sql:param>raja</sql:param>
    <sql:param>hyd</sql:param>
    </sql:transaction>
 </sql:update>

   ${count} records are inserted.

                   
                   














