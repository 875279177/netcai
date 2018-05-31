<%@ page contentType="text/html;charset=UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<aside class="main-sidebar">
  <section class="sidebar">
    <div class="user-panel">
      <div class="pull-left image">
        <img src="/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
      </div>
      <div class="pull-left info">
        <p>${sessionScope.hw77_admin.name}</p>
      </div>
    </div>
    <ul class="sidebar-menu">
      <li class="header"></li>
      <c:forEach items="${sessionScope.hw77_admin.menuList}" var="menu"> 
	      <li class="treeview<c:if test="${sessionScope.oneMenuId==menu.menuId}"> active menu-open</c:if>">
	        <a href="#">
	          <i class="${menu.menuIcon}"></i><span>${menu.menuName}</span>
	          <span class="pull-right-container">
	            <i class="fa fa-angle-left pull-right"></i>
	          </span>
	        </a>
	        <c:forEach items="${menu.menuList}" var="second"> 
	         <ul class="treeview-menu">
	          <c:if test="${fn:length(second.menuList) == 0}">
	             <li <c:if test="${sessionScope.secondMenuId==second.menuId}">class="active"</c:if>>
	                <c:choose>  
					   <c:when test="${fn:indexOf(second.menuHref,'?')==-1}">   
					        <a href="${second.menuHref}?oneMenuId=${menu.menuId}&secondMenuId=${second.menuId}">
					   </c:when>  
					   <c:otherwise> 
					        <a href="${second.menuHref}&oneMenuId=${menu.menuId}&secondMenuId=${second.menuId}">
					   </c:otherwise>  
					</c:choose>  
	               <i class="fa fa-arrow-right"></i>${second.menuName}</a>
	             </li> 
	          </c:if>
	          <c:if test="${fn:length(second.menuList) > 0}">
	             <li <c:if test="${sessionScope.secondMenuId==second.menuId}">class="active"</c:if>>
	             <a href="#">
		            <i class="fa fa-arrow-right"></i><span>${second.menuName}</span>
		            <span class="pull-right-container">
		               <i class="fa fa-angle-left pull-right"></i>
		            </span>
		          </a>
	              <c:forEach items="${second.menuList}" var="three"> 
	                 <ul class="treeview-menu">
	                   <li <c:if test="${sessionScope.threeMenuId==three.menuId}">class="active"</c:if>>
		                  <c:choose>  
						  <c:when test="${fn:indexOf(three.menuHref,'?')==-1}">   
						       <a href="${three.menuHref}?oneMenuId=${menu.menuId}&secondMenuId=${second.menuId}&threeMenuId=${three.menuId}">
						  </c:when>  
						  <c:otherwise> 
						       <a href="${three.menuHref}&oneMenuId=${menu.menuId}&secondMenuId=${second.menuId}&threeMenuId=${three.menuId}">
						  </c:otherwise>  
						  </c:choose>
	                     <i class="fa fa-arrow-right"></i>${three.menuName}</a>
	                   </li>
	                 </ul>
	              </c:forEach>
	              </li>
	          </c:if>
	          </ul>
	        </c:forEach>
	      </li>
      </c:forEach>
    </ul>
  </section>
</aside>