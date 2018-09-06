<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String rPath = request.getContextPath();
%>
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand active" >
                    <a href="/">
                    	ICT ERP
                    </a>
                </li>
                <li>
                    <a href="<%=rPath%>/member/memberList">사원관리</a>
                </li>
                <li>
                    <a href="<%=rPath%>/level/levelList">사원레벨관리</a>
                </li>
                <li>
                    <a onclick="getHtml('<%=rPath%>/depart/departList')" href="#">부서관리</a>
                </li>
                <li>
                    <a href="#">이력서</a>
                </li>
                <li>
                    <a href="#">Git</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </div>
<script>
function getHtml(url){
	$.ajax(
	{
		url:url,
		success:function(html){
			$('#page-content-wrapper').html(html);
		}
	}		
);
}
</script>