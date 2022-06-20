<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đơn hàng</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

        <style>
            fieldset {
                border: none;
            }
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
                color: #000;
            }

            .thong-tin-gui {
                width: 50%;
                padding: 50px 0;
            }

            .tieu-de {
                font-size: 30px;
                font-weight: 700;
            }
            
            .dien {
                border: 1px solid #EBEBEB;
                border-radius: 3px;
                width: 80%;
                height: 40px;
            }
            
            .ten-truong {
                font-size: 16px;
                font-weight: 500;
            }
            
            .nut-tao-don {
                background: #D6763C;
                color: #fff;
                padding: 10px 15px;
                border: none;
                border-radius: 3px;
                margin-top: 20px;
            }
            
            .tien {
                display: flex;
                justify-content: space-between;
                border-bottom: 1px solid #ccc;
                padding-bottom: 20px;
            }
            
            .tien-tra {
                font-weight: 700;
                font-size: 18px;
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
        <div id="don-hang">
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
                <div class="thong-tin-gui">
                    <div class="tieu-de">Đơn hàng của bạn</div>
                    <div class="tien">
                        <div class="mo-ta-tp">Tổng tiền</div>
                        <div class="tien-tra"></div>
                    </div>
                </div>
                
                <div class="thong-tin-gui">
                    <div class="tieu-de">Thông tin người nhận</div>
                    <form action="don-hang" method="post">
                        <fieldset class="thanh-phan ten">
                            <label class="ten-truong">Tên(*)</label><br/>
                            <input type="text" class="dien" name="ten" required />
                        </fieldset>

                        <fieldset class="thanh-phan dia-chi">
                            <label class="ten-truong">Địa chỉ(*)</label><br/>
                            <input type="text" class="dien" name="diachi" required />
                        </fieldset>

                        <fieldset class="thanh-phan ">
                            <label class="ten-truong">Số điện thoại(*)</label><br/>
                            <input type="text" class="dien" name="sdt" required />
                        </fieldset>

                        <button type="submit" class="nut-tao-don">
                            Hoàn thành
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </body>
    
    <script type="text/javascript">
        let data = <%=request.getAttribute("giohang")%>;
        $(document).ready(() => {
            
            let tien = data.reduce((prev, current) => prev + current.soluong * current.gia ,0);
            $(".tien-tra").append(`$` + tien);
        });
    </script>
</html>
