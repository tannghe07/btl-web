
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
        <link rel="stylesheet"
              href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
              crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

        <style>
            a:hover {
                text-decoration: none;
            }
            .khung-trang {
                width: 1170px;
                margin: 0 auto;
            }

            .doanh-thu {
                padding: 30px 0;
                font-size: 26px;
            }

            .tien {
                font-weight: 700;
            }

            .san-pham {
                padding: 50px 0;
            }

            .tieu-de {
                font-size: 30px;
                font-weight: 700;
                padding-bottom: 10px;
            }

            .them {
                background: #F2994A;
                color: #fff;
                padding: 10px 15px;
                border-radius: 3px;
                margin: 15px 0;
            }

            .ds-san-pham {
                width:100%;
                border: 1px solid #eee;
                margin-top: 20px;
            }

            .cac-muc-sp {
                display:flex;
                width:100%;
                background:#000;
                padding: 5px 0;
            }

            .mo-ta-sp {
                display:flex;
                width:100%;
                border-bottom: 1px solid #eee;
                padding: 10px 0;
            }

            .chi-tiet-sp, .muc-sp {
                flex: 1 1 20%;
                text-align:center;
            }

            .muc-sp {
                text-transform:uppercase;
                color: #fff;
            }

        </style>
    </head>
    <body>
        <div id="quan-tri">
            <div class="khung-trang">
                <div class="doanh-thu">
                    Doanh thu t???m t??nh: $<span class="tien"></span>
                </div>

                <div class="tieu-de">Danh s??ch ????n h??ng</div>
                <div class="ds-san-pham">
                    <div class="cac-muc-sp">
                        <div class="muc-sp">M??</div>
                        <div class="muc-sp">T??n Kh??ch H??ng</div>
                        <div class="muc-sp">?????a ch???</div>
                        <div class="muc-sp">S???n ph???m/S??? l?????ng</div>
                        <div class="muc-sp">Th???i gian</div>
                        <div class="muc-sp">T???ng ti???n</div>
                    </div>
                    <div class="ds-chi-tiet-dh">	
                    </div>	
                </div>

                <div class="san-pham">
                    <div class="tieu-de">Danh s??ch s???n ph???m</div>
                    <a class="them" href="tao-san-pham">Th??m</a>

                    <div class="ds-san-pham">
                        <div class="cac-muc-sp">
                            <div class="muc-sp">M??</div>
                            <div class="muc-sp">T??n</div>
                            <div class="muc-sp">Gi??</div>
                            <div class="muc-sp"></div>
                        </div>
                        <div class="ds-chi-tiet-sp">	
                        </div>	
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript">
        let data = <%=request.getAttribute("danhsachSp")%>;
        let donhang = <%=request.getAttribute("dsDonHang")%>;
        function confirmm(id){
            if(confirm('b???n c?? mu???n x??a s???n ph???m n??y kh??ng?')){
                window.location.href="xoa?ma="+id;
            }
        }
        $(document).ready(() => {
            data.map(item => {
                $('.ds-chi-tiet-sp').append(`
                    <div class="mo-ta-sp">		
                        <div class="chi-tiet-sp">` + item.ma + `</div>
                        <div class="chi-tiet-sp">` + item.ten + `</div>
                        <div class="chi-tiet-sp">$` + item.gia + `</div>
                        <div class="chi-tiet-sp"><a href="#a" onclick="confirmm(` + item.ma + `)">X??a</a> <a href="sua?ma=` + item.ma + `">S???a</a></div>
                    </div>
                `)
            });

            let tongtien = donhang.reduce((prev, current) => prev + current.tien, 0);
            $(".tien").append(tongtien);
            
            donhang.map(item => {
                let sanpham = "";
                item.sanpham.map(sp => sanpham += sp.ten + "/" + sp.soluong + ", ");
                $('.ds-chi-tiet-dh').append(`
                    <div class="mo-ta-sp">		
                        <div class="chi-tiet-sp">` + item.ma + `</div>
                        <div class="chi-tiet-sp">` + item.ten + `</div>
                        <div class="chi-tiet-sp">` + item.diachi + `</div>
                        <div class="chi-tiet-sp">` + sanpham + `</div>
                        <div class="chi-tiet-sp">` + item.thoigian + `</div>
                        <div class="chi-tiet-sp">$` + item.tien + `</div>
                    </div>
                `)
            });
            
            console.log(donhang)
        });


    </script>
</html>

