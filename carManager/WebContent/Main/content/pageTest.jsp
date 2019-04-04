<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page import="cn.lvb.bao.violationData" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ page import="cn.lvb.bao.userData" %>
<%@ page import="cn.lvb.bao.adminUser" %>
<%@ page import="cn.lk.bean.call_violationDataDB" %>   
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="content_right">
                        <br />
                        <br />

                        <div class="btwz">
                            人员列表
                        </div>
                        <br>
                        <form name="form1" action="Staff_InfoServlet" method="post">
                            <table cellspacing="1" class="table">
                                <tr class="table_header">
                                    <td valign="middle" align="left">
                                        姓名
                                    </td>
                                    <td valign="middle" align="left">
                                        性别
                                    </td>
                                    <td valign="middle" align="left">
                                        入职时间
                                    </td>
                                    <td valign="middle" align="left">
                                        职位
                                    </td>
                                    <td valign="middle" align="left">
                                        详细信息
                                    </td>
                                    <td valign="middle" align="left">
                                    </td>
                                </tr>
                                <c:forEach items="${list}" var="list">
                                <tr class="row2" onMouseOver="this.className='row1'"
                                    onMouseOut="this.className='row2'">
                                    <td valign="middle" align="left">
                                        ${list.getVioID()}
                                    </td>
                                    <td valign="middle" align="left">
                                        ${list.sex}
                                    </td>
                                    <td valign="middle" align="left">
                                        ${list.hiredate}
                                    </td>
                                    <td valign="middle" align="left">
                                        ${list.position}
                                    </td>
                                    <td valign="middle" align="left">
                                        <input type="radio" name="choose"  value="${list.id}"/>
                                    </td>
                                    <td valign="middle" align="left">
                                        <input type="checkbox" name="empId" value="${list.id}">
                                    </td>
                                </tr>
                                </c:forEach>
                            </table>
                        </form>
                        <p align="right">
                            <input type="button" class="button" value="添加人员"
                                onclick="location='createStaff.jsp'" />
                            <input type="button" class="button" value="详细信息"
                                onClick="    document.forms[0].submit();" />
                            <input type="button" Class="button" value=" 删  除 "
                                onClick="go()" />
                        </p>
                        ${Nochoose}

                        <p class="paging">
                            <a href="/carManager/Vio_ListServlet?page=${paging.indexpage-1}">&lt;&lt; 首页 </a>
                            <a href="/carManager/Vio_ListServlet?page=${paging.page-1 }">    &lt; 上一页 </a>
                            <strong>第${paging.page+1}页/共${paging.pagenumber}页</strong>
                            <a href="/carManager/Vio_ListServlet?page=${paging.page+1}">下一页 &gt;</a>
                            <a href="/carManager/Vio_ListServlet?page=${paging.pagenumber-1}">末页 &gt;&gt;</a>
                        </p>
                        <br />
                        <br />
                    </div>
                </div>
            </div>
</body>
</html>