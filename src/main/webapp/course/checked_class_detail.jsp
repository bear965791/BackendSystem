<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <!-- 連接CSS樣式 -->
    <!-- 連接icon網站 -->
    <!-- 連接Bootstrap -->
    <link rel="stylesheet" href="./css/style1.css" />
    <link rel="stylesheet" href="./css/checking.css" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" integrity="sha512-5A8nwdMOWrSz20fDsjczgUidUBR8liPYU+WymTZP1lmY9G6Oc7HlZv156XqnsgNUzTyMefFTcsFH/tnJE/+xBg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css"rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>厝動HomeGym</title>
  </head>
  <body>
    <div class="d-flex">
        <div class="col-2 sidebar">
            <div class="logo-details">
            <i class="bx bxs-home"></i>
            <div class="logo_name">厝動後台系統</div>
            <i class="bx bx-menu" id="btn"></i>
            </div>
            <ul class="px-0">
            <li>
                <a href="#">
                <i class="bx bx-cart-alt"></i>
                <span class="links_name">訂單資料</span>
                </a>
                <span id="ak" class="tooltip">訂單資料</span>
            </li>
            <li>
                <a href="#">
                <i class="bx bx-user"></i>
                <span class="links_name">會員管理</span>
                </a>
                <span class="tooltip">會員管理</span>
            </li>
            <li>
                <a href="#">
                <i class="bx bx-video"></i>
                <span class="links_name">課程管理</span>
                </a>
                <span class="tooltip">課程管理</span>
            </li>
            <li>
                <a href="#">
                <i class="bx bx-phone-call"></i>
                <span class="links_name">客服回信</span>
                </a>
                <span class="tooltip">客服回信</span>
            </li>
            <li>
                <a href="#">
                <i class="bx bx-bar-chart-alt-2"></i>
                <span class="links_name">數據分析</span>
                </a>
                <span class="tooltip">數據分析</span>
            </li>
            <li>
                <a href="#">
                <i class="bx bx-cog"></i>
                <span class="links_name">權限設置</span>
                </a>
                <span class="tooltip">權限設置</span>
            </li>
            <li class="profile">
                <div class="profile-details">
                <img src="http://p1.ifengimg.com/fck/2019_21/0b8e9ed252afda2_w628_h588.png"alt="profileImg"/>
                <div class="name_job">
                    <div class="name">Test</div>
                    <div class="job">Manager</div>
                </div>
                </div>
                <i class="bx bx-log-out" id="log_out"></i>
            </li>
            </ul>
        </div>
        
        <div class="col-10  mb-4">
            <nav class="navbar">
                <div class="container d-flex  justify-content-end ">
                    <div class="navbar-brand d-flex py-0">
                        <img class="me-3" style="height: 80px;" src="./image/logo5.jpg" alt="">
                        <h2 class=" d-flex  align-items-center ">後台系統</h2>
                    </div>
                </div>
            </nav>
            <nav class="nav_second mb-2 "> 
                <div class="nav d-flex align-items-center border-bottom border-top">
                    <a href="#" class="nav-link">
                        <i class="bx bx-video"></i>
                        <span>課程管理</span>
                    </a>
                    <i class="fa fa-angle-right" aria-hidden="true"></i>
                    <a class="nav-link" href="./classList.html">課程列表</a>
                    <i class="fa fa-angle-right" aria-hidden="true"></i>
                    <span class="ms-3">課程詳情</span>
                </div>
            </nav>
            <div class="container">
                <div>
                    <h2>申請狀態</h2>
                    <div>
                        <ul class="">
                            <li>
                                <label class="col-sm-2 col-form-label-lg">申請教練:</label> 
                                <span>Brian</span>
                            </li>
                            <li>
                                <label class="col-sm-2 col-form-label-lg">申請狀態:</label> 
                                <span>已通過</span>
                            </li>
                            <li>
                                <label class="col-sm-2 col-form-label-lg">申請時間:</label> 
                                <span>2021/08/09</span>
                            </li>
                            <li>
                                <label class="col-sm-2 col-form-label-lg">審核時間:</label> 
                                <span>2021/08/11</span>
                            </li>
                        </ul>
                    </div>
                </div>

                <div>
                    <h2>課程詳情</h2>
                    <div class="mb-3 ms-4">
                        <video class="w-50" src="./video.mp4" controls></video>
                    </div>

                    <div>
                        <ul>
                            <li>
                                <label class="col-sm-2 col-form-label-lg">課程名稱:</label> 
                                <span>tabata爆汗核心健身</span>
                            </li>
                            <li>
                                <label class="col-sm-2 col-form-label-lg">器材需求:</label> 
                                <span>瑜珈墊</span>
                            </li>
                            <li>
                                <label class="col-sm-2 col-form-label-lg">課程適合哪些人:</label> 
                                <span>想學瑜伽的人</span>
                             </li>
                             <li>
                                <label class="col-sm-2 col-form-label-lg">課程分類:</label> 
                                <span>上半身</span>
                                <span>腿部</span>
                            </li>
                            <li>
                                <label class="col-sm-2 col-form-label-lg">價錢:</label> 
                                <sapn>NT$1000</sapn>
                            </li>
                            <li>
                                <label class="col-sm-2 col-form-label-lg">課程介紹:</label> 
                                <p>課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹課程介紹</p>
                            </li>
                        </ul>
                    </div>
                </div>
                
                <div class="d-flex justify-content-center ">
                    <a href="./classList.html" class="btn btn-outline-dark">
                        <span>回上一頁</span>
                      </a>
                </div>
            </div>
        </div>

    </div>

    <script src="https://code.jquery.com/jquery-3.6.0.slim.js"integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY="crossorigin="anonymous"></script>
    <script src="./js/backStage.js"></script>
  </body>
</html>

