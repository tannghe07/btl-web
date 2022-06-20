

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa sản phẩm</title>
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
                <form action="sua" method="post">
                    <h2>
                        Sửa sản phẩm
                    </h2>

                    <div>
                        <label class="ten-truong">Tên sản phẩm(*)</label><br/>
                        <input type="text" class="dien" name="ten" id="ten" value="" required />
                    </div>

                    <div>
                        <label class="ten-truong">Ảnh sản phẩm(*)</label><br/>
                        <input type="text" class="dien" name="anh" id="anh" value="" required />
                    </div>
                    
                    <div>
                        <label class="ten-truong">Mô tả sản phẩm(*)</label><br/>
                        <input type="text" class="dien" name="mota" id="mota" value="" required />
                    </div>

                    <div>
                        <label class="ten-truong">Giá sản phẩm(*)</label><br/>
                        <input type="number" class="dien" name="gia" id="gia" value="" required />
                    </div>

                    <button type="submit" class="nut-tao-don">
                        Sửa
                    </button>
                </form>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        let product = <%=request.getAttribute("sanpham")%>;

        document.getElementById("ten").value = product.ten;
        document.getElementById("anh").value = product.anh;
        document.getElementById("mota").value = product.mota;
        document.getElementById("gia").value = product.gia;
    </script>
</html>
