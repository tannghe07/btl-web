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
        <title>Danh sách sản phẩm</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <style>
            body {
                margin: 0;
            }
            a {
                text-decoration: none;
            }
            .khung-trang {
                width: 80%;
                margin: 0 auto;
            }
            .san-pham-moi, .ds-sanpham-con {
                padding: 30px 0;
                display: flex;
                flex-wrap: wrap;
                width: 100%;
                justify-content: space-between;
            }
            .san-pham {
                display: flex;
                flex-direction: column;
                text-align: center;
            }
            .anh {
                object-fit: cover;
                width: 200px;
                height: 200px;
            }
            .ten {
                color: #1d1d1d;
                font-size: 18px;
                font-weight: 600;
            }
            .gia {
                color: #1d1d1d;
                font-size: 16px;
                font-weight: 500;
            }

            .tieu-de-mota {
                text-align: center;

            }
            .td-mota-sanpham {
                font-size: 30px;
                font-weight: 700;
            }
            .mo-ta-dai {
                font-size: 20px;
                font-weight: 500;
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
        <div id="trang-chu">
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
                <div class="tieu-de-mota">
                    <div class="td-mota-sanpham">Danh sách sản phẩm</div>
                </div>
                <div class="san-pham-moi">
                </div>

            </div>

            <div class="khung-trang">
                <div class="dau-trang">
                    <a href=""><img src="https://hgshop.asia/wp-content/uploads/2022/06/Logo-web.png" class="logo-web" /></a>

                    <div class="lien-he">
                        <div class="ket-noi">Về chúng tôi</div>
                        <div class="ket-noi">Kết nối</div>
                    </div>

                    <div class="mang-xa-hoi">
                        <i class="fa-brands fa-facebook"></i>
                        <i class="fa-brands fa-youtube"></i>
                    </div>
                </div>
            </div>
        </div>
    </body>

    <script type="text/javascript">
        let data = <%=request.getAttribute("danhsachSp")%>;
        $(document).ready(() => {
            data.map(item => {
                $('.san-pham-moi').append(`
                    <div class="san-pham">
                        <a href="san-pham?ma=` + item.ma + `">
                            <img class="anh" src=` + item.anh + ` />
                            <div class="ten">` + item.ten + `</div>
                            <div class="gia">$` + item.gia + `</div>
                        </a>
                    </div>
                `)
            });
        });
    </script>
</html>
