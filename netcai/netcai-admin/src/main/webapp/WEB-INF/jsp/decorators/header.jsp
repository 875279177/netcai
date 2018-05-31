<%@ page contentType="text/html;charset=UTF-8"%>  
<header class="main-header">
   <a href="/admin/index" class="logo">
     <span class="logo-lg"><b>网菜网运营管理</b></span>
   </a>
   <nav class="navbar navbar-static-top">
     <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
       <span class="sr-only"></span>
     </a>

     <div class="navbar-custom-menu">
       <ul class="nav navbar-nav">
	       <li class="active">
		        <a href="/admin/reported/list">报备消息
		            <span class="badge">${count}</span>
		        </a>
	    	</li>
         <li class="dropdown user user-menu">
           <a href="/admin/logout">
             <img src="/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
             <span class="hidden-xs">退出</span>
           </a>
         </li>
       </ul>
     </div>
   </nav>
</header>