function get_category(e, id) {



    var elems = document.querySelectorAll(".active");
    [].forEach.call(elems, function (el) {
        el.classList.remove("active");
    });
    e.target.className = "item active";

    //refresh content
    switch (id) {
        case 1:
            let contet_product = `
                <div>
            <h3 style="text-align: center;">List Of Product</h3>
        </div>
        <div class="_products" style="display: flex; gap: 40px; justify-content: center;">
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà phê trứng</p>
                <img src="./image/coffe1.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="./image/coffe1.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="./image/coffe1.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="./image/coffe1.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
        </div>


        <div class="_products" style="display: flex; gap: 40px; justify-content: center; margin-top: 20px;">
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="./image/coffe1.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="./image/coffe1.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="./image/coffe1.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="./image/coffe1.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
        </div>
        <div class="pagination">
                <a href="#">&laquo;</a>
                <a href="#">1</a>
                <a class="active" href="#">2</a>
                <a href="#">3</a>
                <a href="#">4</a>
                <a href="#">5</a>
                <a href="#">6</a>
                <a href="#">&raquo;</a>
                </div>
            `;
            // lấy content hiện tại --> remove
            document.getElementById('main_container').innerHTML = contet_product;
            break;
        default:
            break;
    }


}