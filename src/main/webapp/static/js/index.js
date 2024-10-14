var totalPage =0;
var pageIndex =0;
function get_category(e, id) {
    var elems = document.querySelectorAll(".active");
    [].forEach.call(elems, function (el) {
        el.classList.remove("active");
    });
    e.target.className = "item active";

    //refresh content
    switch (id) {

        case 1:
            getAllDataProduct()
            let contet_product = `
                <div>
            <h3 style="text-align: center;">List Of Product</h3>
        </div>
        <div class="_products" style="display: flex; gap: 40px; justify-content: center;">
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà phê trứng</p>
                <img src="static/uploads/pexels-dagmara-dombrovska-22732579-8070871.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="static/uploads/pexels-dagmara-dombrovska-22732579-8070871.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="static/uploads/pexels-dagmara-dombrovska-22732579-8070871.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="static/uploads/pexels-dagmara-dombrovska-22732579-8070871.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
        </div>


        <div class="_products" style="display: flex; gap: 40px; justify-content: center; margin-top: 20px;">
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="static/uploads/pexels-dagmara-dombrovska-22732579-8070871.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="static/uploads/pexels-dagmara-dombrovska-22732579-8070871.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="static/uploads/pexels-dagmara-dombrovska-22732579-8070871.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
            <div class="_item_product" style="background-color:#F9FBE7 ;">
                <p style="text-align: center;">Cà trứng</p>
                <img src="static/uploads/pexels-dagmara-dombrovska-22732579-8070871.jpg" width="250" height="300" alt="">
                <div class="_infor" style="font-size: 13px; display: flex; gap: 8px; justify-content: center;">
                    <p for="">Cà trứng muối</p>
                    <p for="">10000VND</p>
                </div>
            </div>
        </div>
        <div class="pagination" id="pagination">

                </div>
            `;
            // lấy content hiện tại --> remove
            document.getElementById('main_container').innerHTML = contet_product;
            break;
        default:
            break;
    }


}

 function getAllDataProduct(){
    let url = "http://localhost:8080/CoffeeRang_war_exploded/ServletGetAllProduct?page="+0;
     $.ajax({
        type: "GET",
        dataType: "json",
        url: url,
        success: function (data) {
         totalPage = data.totalPage;
         pageIndex = data.pageIndex;
            showPageable(totalPage,pageIndex)
        },
        error: function (error) {
            jsonValue = jQuery.parseJSON(error.responseText);
            alert("error" + error.responseText);
        }
    });
}
function showPageable(totalpage,pageIndex){
    let pagination =` <a href="#">&laquo;</a>`
    let item = Number.parseInt(1);
    if (totalpage >0){
        for (let i = 0; i < totalpage; i++) {

            pagination +=` <a href = "#" >` +(Number.parseInt(i)+item)+ `</a>`
        }
        pagination += `<a href="#">&raquo;</a>`;
    }
    console.log(pagination)
    document.getElementById("pagination").innerHTML(pagination);

}