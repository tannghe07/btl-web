<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Giỏ hàng</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <style>
            a {
                text-decoration: none;
            }
            a:hover {
                text-decoration: none;
                color: inherit;
            }
            
            .khung-trang {
                width: 1170px;
                margin: 0 auto;
            }
            .ds-san-pham {
                width: 80%;
            }
            .mo-ta {
                display: flex;
                justify-content: space-between;
                align-content: center;
                padding: 10px 0;
            }
            .tieu-de {
                color: #000;
                font-weight: 700;
                font-size: 20px;
            }
            .san-pham {
                width: 35%;
            }
            .thong-tin-sp {
                color: #555;
                font-weight: 500;
                font-size: 16px;
            }
            
            .tong-tien {
                padding: 80px 0;
            }
            
            .tien-sp {
                padding: 10px;
                border-bottom: 1px solid #E5E5E5;
                width: 80%;
                display: flex;
                justify-content: space-between;
                align-content: center;
            }
            
            .tien-thanh-toan {
                color: #000;
                font-size: 30px;
                font-weight: 700;
            }
            
            .don-hang {
                text-decoration: none;
                background: #D6763C;
                font-size: 24px;
                font-weight: 600;
                color: #fff;
                padding: 15px 20px;
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
        <div id="gio-hang">
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
                <div class="ds-san-pham">
                    <div class="mo-ta tieu-de">
                        <div class="san-pham">Sản phẩm</div>
                        <div class="gia">Giá</div>
                        <div class="so-luong">Số lượng</div>
                        <div class="tien">Tổng tiền</div>
                        <div class="xoa"></div>
                    </div>

                    <div class="san-pham-trong-gio">
                    </div>

                </div>
                <div class="tong-tien">
                    <div class="tien-thanh-toan">Tổng tiền dự tính</div>
                    <div class="bang-tien">
                        <div class="thanh-phan tien-sp">
                            <div class="tinh-tien-tam">Tổng tiền tạm tính</div>
                            <div class="tien so-tien"></div>
                        </div>
                        <div class="tien-ship tien-sp">
                            <div class="tinh-tien-tam">Phí giao hàng</div>
                            <div class="tien">Free</div>
                        </div>
                        <div class="thanh-tien tien-sp">
                            <div class="tinh-tien-tam">Tổng</div>
                            <div class="tien so-tien"></div>
                        </div>
                    </div>                    
                </div>
                
                <a href="don-hang" class="don-hang">Thông tin người nhận cho đơn hàng</a>
            </div>
        </div>
    </body>

    <script type="text/javascript">
        let data = <%=request.getAttribute("giohang")%>;
        $(document).ready(() => {
            data.map(item => {
                $(".san-pham-trong-gio").append(
                    `
                        <div class="mo-ta thong-tin-sp">
                            <div class="san-pham">` + item.ten + `</div>
                            <div class="gia">$` + item.gia + `</div>
                            <div class="so-luong">
                                <a href="sua-so-luong?hanhdong=2&ma=` + item.ma + `"><i class="fa-solid fa-minus"></i></a>
                                ` + item.soluong + `
                                <a href="sua-so-luong?hanhdong=1&ma=` + item.ma + `"><i class="fa-solid fa-plus"></i></a>
                            </div>
                            <div class="tien">$` + (item.gia * item.soluong) + `</div>
                            <div class="xoa"><a href="sua-so-luong?hanhdong=3&ma=` + item.ma + `"><i class="fa-solid fa-xmark"></i></a></div>
                        </div>
                    `
                );
            });
            
            let tien = data.reduce((prev, current) => prev + current.soluong * current.gia ,0);
            $(".so-tien").append(`$` + tien);
        });

    </script>
</html>
