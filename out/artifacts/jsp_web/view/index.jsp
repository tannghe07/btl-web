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
        <title>Trang chủ</title>
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
            .anh-bn {
                background-image: url("https://hgshop.asia/wp-content/uploads/2022/05/slide2-copy.webp");
                background-size: cover;
                width: 100%;
                height: 400px;
                display: flex;
                justify-content: center;
                align-items: center;
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

            .tinh-nang {
                display: flex;
                flex-wrap: wrap;
                gap: 20px;
                justify-content: space-between;
                padding: 30px 0;
            }

            .uu-dai {
                display: flex;
                justify-content: space-between;
                gap: 50px;
                padding: 50px 0;
            }

            .uu-dai-1 {
                background: #000;
                padding: 100px 80px;
                color: #fff;
                text-align: center;
            }

            .ten-ud {
                font-size: 30px;
                font-weight: 600;
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
                    <a href=""><img src="https://hgshop.asia/wp-content/uploads/2022/06/Logo-web.png" class="logo-web" /></a>

                    <div class="menu">
                        <a href="">Trang chủ</a>
                        <a href="danh-sach-san-pham">Sản phẩm</a>
                    </div>

                    <div class="tien-ich">
                        <a href="gio-hang"><i class="fa-solid fa-cart-shopping"></i></a>
                    </div>
                </div>
            </div>

            <div class="anh-bn">
                <div class="khung-trang">
                    <div class="td-mota-sanpham">Cửa hàng đang có chương trình giảm giá và có nhiều ưu đãi</div>
                    
                </div>
            </div>
            <div class="khung-trang">
                <div class="tieu-de-mota">
                    <div class="td-mota-sanpham">Sản phẩm mới</div>
                </div>
                <div class="san-pham-moi">
                </div>

                <div class="tinh-nang">
                    <img class="tn-1" src="https://hgshop.asia/wp-content/uploads/2022/05/1.png" />
                    <img class="tn-2" src="https://hgshop.asia/wp-content/uploads/2022/05/2.png" />
                    <img class="tn-3" src="https://hgshop.asia/wp-content/uploads/2022/05/3.png" />
                    <img class="tn-4" src="https://hgshop.asia/wp-content/uploads/2022/05/4.png" />
                </div>

            </div>
            <div class="uu-dai">
                <div class="uu-dai-1">
                    <div class="ten-ud">Đảm bảo</div>
                    <div class="mo-ta-ud">
                        Một nền tảng duy nhất cho mọi nhu cầu đồ điện tử của bạn, đơn giản. Mua hàng an tâm.
                    </div>
                </div>

                <div class="uu-dai-1">
                    <div class="ten-ud">Mua 2 tặng 1</div>
                    <div class="mo-ta-ud">
                        Giảm giá cuối mùa. Mua 2 sản phẩm bất kỳ mà bạn chọn và nhận 1 sản phẩm miễn phí
                    </div>
                </div>
            </div>

            <div class="khung-trang">
                <div class="ds-san-pham">
                    <div class="tieu-de-mota">
                        <div class="td-mota-sanpham" id="phan-muc-danh-sach-sp">Danh sách sản phẩm</div>
                    </div>
                    <div class="ds-sanpham-con">
                    </div>
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
            data.slice(0, 4).map(item => {
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

            data.map(item => {
                $('.ds-sanpham-con').append(`
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
