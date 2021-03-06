<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en"  style="overflow-x:hidden;">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>厝動HomeGym 後台系統</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
	<link rel='stylesheet' href="<c:url value='/course/css/form.css' />"  type='text/css' />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body  style="overflow-x:hidden;">
    <section class="member_Backend">
        <div class="container-fluid">
            <div class="row vh-100">
                <!-- 側邊欄 -->
                <div class="col-2 p-0">
                  <div class="sidebar bg-dark h-100 d-flex flex-column">
                    <div class="list-group-item border-dark mb-3 p-4 border-0 border-end border-5 text-center">
                      <figure class="text-center">
                        <blockquote class="blockquote">
                          <p>Jonas 您好</p>
                        </blockquote>
                        <figcaption class="blockquote-footer">
                          目前任職2年，經理
                        </figcaption>
                      </figure>                      
                    </div>
                    <div class="list-group rounded-0 p-4">
                      <a href="./OrderBackend.html" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">訂單管理</a>
                      <a href="<c:url value='/backStage/checkedCoursePage' />" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">課程管理</a>
                      <a href="<c:url value='/Member/MemberListPageServlet' />" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">會員管理</a>
                      <a href="./backendAdminister.html" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">後台權限管理</a>
                    </div>
                    <a href="#" class="rounded-0 list-group-item list-group-item-action mb-3 fs-5 text-center mt-auto border-end-0 mb-5">登出</a>
                  </div>
                </div>

   				<div class="col-10 p-0">
                  <!-- 導覽列 -->
                  <nav class="navbar border-bottom shadow-sm">
                    <div class="container-fluid d-flex  justify-content-end ">
                        <div class="navbar-brand d-flex py-0">
                            <img class="me-3" style="height: 80px;" src="<c:url value='/course/image/logo5.jpg' />" alt="">
                            <h2 class=" d-flex  align-items-center ">後台系統</h2>
                        </div>
                    </div>
                  </nav>

                  <!-- 次導覽列 -->
                  <nav class="nav_second mb-4 mt-3"> 
                    <div class="nav d-flex align-items-center border-bottom mb-4">
                        <div class="nav-link text-dark">
                            <i class="bx bx-video"></i>
                            <span>課程管理</span>
                        </div>
                        <div class="nav-link text-dark">
                          <i class="fa fa-angle-right" aria-hidden="true"></i>
                          <span class="ms-3 fw-bold">已審核課程</span>
                        </div>
                    </div>
                  </nav>

                  <div class="container-fluid p-0">
                    <div class="mb-5">
                        <ul class="nav nav-tabs border-0 border-bottom">
                   			<li  class="nav-item ">
                                <a class="nav-link active fw-bold " href="<c:url value='/backStage/checkedCoursePage'/>">已審核課程</a>
                            </li >
                            <li class="nav nav-tabs border-0">
                                <a class="nav-link text-dark" href="<c:url value='/backStage/notCheckCoursePage' />">未審核課程</a>
                            </li>
                        </ul>
                        <!-- 查詢列 -->
                        <div class="row row-cols-3 border-0 py-3 ps-4 pe-4">
                        <FORM class="col-6 d-flex" action="<c:url value='/Course/DoubleCategoryPage.do' />" method="GET"> 

                            <div class="col mb-4">
                                <div class="d-flex">
                                  <div class="col-auto">
                                    <label for="inputMemberId" class="col-form-label ">審核狀態</label>
                                  </div>
                                  <select class="form-select  ms-3 me-2" aria-label="Default select example" name="status">
                                    <option selected  value="2">全部</option>
                                    <option value="1">通過</option>
                                    <option value="0">未通過</option>
                                  </select>                                 
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="d-flex">
                                  <div class="col-auto">
                                    <label for="inputMemberId" class="col-form-label ms-2">課程分類</label>
                                  </div>
                                  <select class="form-select ms-3 me-2" aria-label="Default select example" name="partOfBody">
                                   <option value="0" >全部</option>
                                    <option value="全身">全身</option>
                                    <option value="背">背</option>
                                    <option value="二頭">二頭</option>
                                    <option value="胸">胸</option>
                                    <option value="核心">核心</option>
                                    <option value="腿">腿</option>
                                  </select>                              
                            	<input class="btn btn-outline-primary" type="submit" value='查詢'>
                                </div>
                            </div>
                            </FORM>
                              <FORM class="col-5" action="<c:url value='/Course/SearchPageServlet' />" method="GET"> 
                            	<div class="col mb-4">
	                            	<div class="d-flex">
	                                	<input class="form-control me-2" id="inputMemberPhone" type="text" placeholder="請輸入課程編號或名稱"  name="inputValue">                                                  
	                            	<div class="col-auto">
			                            <Input type='hidden' name='checked' value='1'>
			                            <Input class="btn btn-outline-primary" type="submit" value='查詢' >
	                                  </div>
	                                </div>
                            	</div>
                      		</FORM>
                        </div>
                        <!-- 表格 -->
                        <table class="table table-striped mb-0 text-center">
                            <thead>
                              <tr>
                                <th scope="col">課程名稱</th>
                                <th scope="col">課程編號</th>
                                <th scope="col">課程分類</th>
                                <th scope="col">教練</th>
                                <th scope="col">售價</th>
                                <th scope="col">審核時間</th>
                                <th scope="col">審核狀態</th>
                                <th scope="col"></th>
                              </tr>
                            </thead>
                            <tbody>
                              <!-- 表格項目 -->
                                 <c:forEach var="entry"  items="${pageBean.videoBean}" > 
		                              <!-- 表格項目動態新增 -->
		                              <tr class="align-middle">
		                                <th scope="row ">${entry.name}</th>
		                                <td>${entry.videoId}</td>
		                                <td>${entry.partOfBody}</td>
		                                <td>${entry.coach}</td>
		                                <td>${entry.price}</td>
		                                <td>${entry.checktime}</td>
		                                <td>
		                                <c:choose>
										  <c:when test="${entry.pass == 0}">不通過</c:when> 
										  <c:otherwise>通過</c:otherwise> 
										</c:choose> 
		                                </td>
		                                <td>
		                                  <a href="<c:url value='/course/CheckingVideoDetail.do?videoId=${entry.videoId}' />" class="btn btn-outline-dark">
		                                    <span>查看</span>
		                                  </a>
		                                </td>
		                              </tr>
		                         </c:forEach>
                            </tbody>
                        </table>
                    </div>
			         		<nav class="d-flex justify-content-center mt-3 mb-3">
                          <ul class="pagination">
                           <li class="page-item">
						        <c:if test="${pageBean.currentPage > 1}">
						        <c:choose>
						        	<c:when  test="${!empty param.partOfBody || !empty param.status}">
							          <a class="page-link" href="<c:url value='${servletPath}?status=${param.status}&partOfBody=${param.partOfBody}&pageNo=${pageBean.currentPage-1}' />" aria-label="Previous"> 
							          	<span aria-hidden="true">&laquo;</span>
							          </a>
						          </c:when>
						          <c:when  test="${!empty param.inputValue || !empty param.checked}">
							          <a class="page-link" href="<c:url value='${servletPath}?inputValue=${param.inputValue}&checked=${param.checked}&pageNo=${pageBean.currentPage-1}' />" aria-label="Previous"> 
							          	<span aria-hidden="true">&laquo;</span>
							          </a>
						          </c:when>
						        	<c:otherwise>
							          <a class="page-link" href="<c:url value='${servletPath}?pageNo=${pageBean.currentPage-1}' />" aria-label="Previous"> 
							          	<span aria-hidden="true">&laquo;</span>
							          </a>
						          	</c:otherwise>
						        </c:choose> 
						        
						         </c:if>
						         </li>
						       	<c:if test="${pageBean.totalPage > 1}">
						       		<c:forEach var="page"  begin="1" end="${pageBean.totalPage}" step="1" >                  
						        		<c:choose>
						        			<c:when  test="${!empty param.partOfBody || !empty param.status}">
						        				<li class="page-item">
						        				<a class="page-link" href="<c:url value='${servletPath}?status=${param.status}&partOfBody=${param.partOfBody}&partOfBody=${param.partOfBody}&pageNo=${page}'/>">${page}</a>
						        				</li>
						        			</c:when>
						        			<c:when  test="${!empty param.inputValue}">
						        				<li class="page-item">
						        				<a class="page-link" href="<c:url value='${servletPath}?inputValue=${param.inputValue}&checked=${param.checked}&pageNo=${page}'/>">${page}</a>
						        				</li>
						        			</c:when>
						        			<c:otherwise>
						        				<li class="page-item">
						        				<a class="page-link" href="<c:url value='${servletPath}?pageNo=${page}'/>">${page}</a>
						        				</li>
						        			</c:otherwise>
						        		</c:choose> 
						        	</c:forEach>
						     	</c:if>
						
						        <li class="page-item">
						         	<c:if test="${pageBean.currentPage != pageBean.totalPage && pageBean.totalPage != 0}">
						         	<c:choose>
						        		<c:when  test="${!empty param.partOfBody || !empty param.status}">
						         			<a class="page-link" href="<c:url value='${servletPath}?status=${param.status}&partOfBody=${param.partOfBody}&pageNo=${pageBean.currentPage+1}' />" aria-label="Next">
						         			<span aria-hidden="true">&raquo;</span>
						          			</a>
						          		</c:when>
						          		<c:when  test="${!empty param.inputValue}">
						         			<a class="page-link" href="<c:url value='${servletPath}?inputValue=${param.inputValue}&checked=${param.checked}&pageNo=${pageBean.currentPage+1}' />" aria-label="Next">
						         			<span aria-hidden="true">&raquo;</span>
						          			</a>
						          		</c:when>
						        		<c:otherwise>
						          			<a class="page-link" href="<c:url value='${servletPath}?pageNo=${pageBean.currentPage+1}' />" aria-label="Next">
						         			<span aria-hidden="true">&raquo;</span>
						          			</a>
						          		</c:otherwise>
						        	</c:choose> 
						         	</c:if>
						        </li>
                          </ul>
                    </nav>
                  </div>
                    
                </div>
            </div>
        </div>
    </section>


</body>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</html>