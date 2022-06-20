<%-- 
    Document   : index
    Created on : May 23, 2022, 6:46:44 PM
    Author     : cuong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi Tiết Sản Phẩm</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <style>
            a {
                text-decoration: none;
            }
            .khung-trang {
                width: 1170px;
                margin: 0 auto;
            }
            .san-pham {
                display: flex;
                justify-content: start;
                gap: 20px;
            }
            .anh {
                width: 40%;
                height: 500px;
                object-fit: cover;
            }
            .mo-ta {
                text-align: left;
                color: #000;
            }
            .ten {
                font-size: 32px;
                font-weight: 700;
                text-transform: capitalize;
            }
            .gia {
                color: #024E82;
                font-size: 24px;
                font-weight: 500;
            }
            .mo-ta-sp {
                font-size: 16px;
                font-weight: 500;
                padding-bottom: 50px;
            }
            .them-vao-gio {
                background: #F2994A;
                color: #fff;
                padding: 15px 35px;
            }
            .them-vao-gio:hover {
                color: #fff;
            }
            
            .dau-trang {
                display: flex;
                justify-content: space-between;
                align-content: center;
                align-items: center;
                padding: 10px 0;
            }

            .menu {
                flex: 1;
                padding-left: 20px;
                font-size: 18px;
            }
        </style>
    </head>
    <body>
        <div id="chi-tiet-sp">
            <div class="khung-trang">
                <div class="dau-trang">
                    <a href="/btl-web"><img src="https://hgshop.asia/wp-content/uploads/2022/06/Logo-web.png" class="logo-web" /></a>

                    <div class="menu">
                        <a href="/btl-web">Trang chủ</a>
                        <a href="danh-sach-san-pham">Sản phẩm</a>
                    </div>

                    <div class="tien-ich">
                        <a href="gio-hang"><i class="fa-solid fa-cart-shopping"></i></a>
                    </div>
                </div>
            </div>

            <div class="khung-trang">
                <div class="san-pham">

                </div>
            </div>
        </div>
    </body>

    <script type="text/javascript">
        let item = <%=request.getAttribute("sanpham")%>;

        $(document).ready(() => {
            $(".san-pham").append(
                    `
                    <img class="anh" src=` + item.anh + ` />
                    <div class="mo-ta">
                        <div class="ten">` + item.ten + `</div>
                        <div class="gia">$` + item.gia + `</div>
                        <div class="mo-ta-sp">` + item.mota + `</div>
                            <a class="them-vao-gio" href="cap-nhat-gio-hang?ma=` + item.ma + `">Thêm vào giỏ hàng</a>
                    </div>
                `
                    );
        })
    </script>
</html>
