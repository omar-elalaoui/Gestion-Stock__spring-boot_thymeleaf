/* Add here all your JS customizations */
$(document).ready(function () {
    $(".btn_supp").click(function (e) {
        e.preventDefault();
        $("#supp_modal .submit_supp").attr("href", $(this).attr("href"));
        $("#supp_modal").modal();
    })
})