

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <style>
            a:hover {
                text-decoration: none;
                color: inherit;
            }

            .khung-trang {
                width: 1170px;
                margin: 0 auto;
                color: #000;
            }

            .dien {
                border: 1px solid #EBEBEB;
                border-radius: 3px;
                width: 80%;
                height: 30px;
            }

            .ten-truong {
                font-size: 16px;
                font-weight: 500;
                margin-top: 15px;
            }

            .nut-tao-don {
                background: #D6763C;
                color: #fff;
                padding: 10px 15px;
                border: none;
                border-radius: 3px;
                margin-top: 20px;
            }

        </style>
    </head>
    <body>
        <div id="tao-sp">
            <div class="khung-trang">
                <form action="quan-tri" method="post">
                    <h2>
                        Thêm sản phẩm
                    </h2>
                    <div>
                        <label class="ten-truong">Tên sản phẩm(*)</label><br/>
                        <input type="text" class="dien" name="ten" required />
                    </div>
                    <div>
                        <label class="ten-truong">Ảnh sản phẩm(*)</label><br/>
                        <input type="text" class="dien" name="anh" required />
                    </div>
                    <div>
                        <label class="ten-truong">Mô tả sản phẩm(*)</label><br/>
                        <input type="text" class="dien" name="mota" required />
                    </div>
                    <div>
                        <label class="ten-truong">Giá sản phẩm(*)</label><br/>
                        <input type="number" class="dien" name="gia" required />
                    </div>
                    <button type="submit" class="nut-tao-don">
                        Tạo sản phẩm
                    </button>
                </form>
            </div>
        </div>
    </body>
</html>
