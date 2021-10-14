<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>厝動HomeGym 後台系統</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  
</head>
<body>

    <section class="member_Backend">
        <div class="container-fluid">
            <div class="row">
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
                      <a href="./courseList.html" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">課程管理</a>
                      <a href="./MemberBackend.html" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">會員管理</a>
                      <a href="#" class="rounded-3 list-group-item list-group-item-action mb-3 p-4 fs-5 text-center">後台權限管理</a>
                    </div>
                    <a href="#" class="rounded-0 list-group-item list-group-item-action mb-3 fs-5 text-center mt-auto border-end-0 mb-5">登出</a>
                  </div>
                </div>

                <div class="col-10 p-0">
                  <!-- 導覽列 -->
                  <nav class="navbar border-bottom shadow-sm">
                    <div class="container d-flex  justify-content-end ">
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
                          <span class="ms-3">課程資料</span>
                        </div>
                        <div class="nav-link text-dark">
                          <i class="fa fa-angle-right" aria-hidden="true"></i>
                          <span class="ms-3 fw-bold">已審核課程</span>
                        </div>
                    </div>
                  </nav>

                  <div class="container ">
                    <div class="mb-5">
                        <ul class="nav nav-tabs border-0 border-bottom">
                            <li  class="nav-item ">
                                <a class="nav-link active fw-bold" href="./courseList.html">課程列表</a>
                            </li >
                            <li class="nav nav-tabs border-0">
                                <a class="nav-link text-dark" href="<c:url value='./notcheckList.jsp' />">尚未審核</a>
                            </li>
                        </ul>
                        <!-- 查詢列 -->
                        <div class="row row-cols-3 border-0 px-2 py-3">

                            <div class="col mb-4">
                                <div class="d-flex">
                                  <div class="col-auto">
                                    <label for="inputMemberId" class="col-form-label me-2">審核狀態</label>
                                  </div>
                                  <select class="form-select me-3" aria-label="Default select example">
                                    <option selected>全部</option>
                                    <option value="1">通過</option>
                                    <option value="2">未通過</option>
                                  </select>                                 
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="d-flex">
                                  <div class="col-auto">
                                    <label for="inputMemberId" class="col-form-label me-2">課程分類</label>
                                  </div>
                                  <select class="form-select ms-3" aria-label="Default select example">
                                    <option selected>全部</option>
                                    <option value="1">上半身</option>
                                    <option value="2">下半身</option>
                                    <option value="3">Three</option>
                                  </select>                              
                                </div>
                            </div>
                            <div class="col mb-4">
                                <div class="d-flex">
                                  <div class="col-auto">
                                    <label for="inputMemberId" class="col-form-label me-2">課程分類</label>
                                  </div>
                                  <input class="form-control me-2" id="inputMemberPhone" type="text" placeholder="Search" aria-label="Search">
                                                        
                                  <div class="col-auto">
                                    <button class="btn btn-outline-primary" type="submit">查詢<i class="bi bi-search ms-2"></i> </button>
                                  </div>
                                </div>
                            </div>
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
                          	<tr class="align-middle">
                                <th scope="row ">tabata爆汗核心健身</th>
                                <td>class01</td>
                                <td>上半身</td>
                                <td>Brian</td>
                                <td>1000</td>
                                <td>2021/07/09</td>
                                <td>通過</td>
                                <td>
                                  <a href="./checkedCourseDetail.html" class="btn btn-outline-dark">
                                    <span>查看</span>
                                  </a>
                                </td>
                              </tr>
                            </tbody>
                        </table>
                    </div>
            
                    <nav class="d-flex justify-content-center mt-3 mb-3">
                          <ul class="pagination">
                            <li class="page-item">
                              <a class="page-link" href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                              </a>
                            </li>
                            <li class="page-item active"><a class="page-link" href="#">1</a></li>
                            <li class="page-item"><a class="page-link" href="#">2</a></li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                              <a class="page-link" href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                              </a>
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
