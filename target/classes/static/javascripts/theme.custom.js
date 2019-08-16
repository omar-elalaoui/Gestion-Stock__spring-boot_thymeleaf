/* Add here all your JS customizations */
$(document).ready(function () {

    // supprimer les lignes de commandes
    $(document).on("click", ".delete_ligne" , function() {
        $(this).closest("tr").remove();
        console.log("clicked");
    });

    // supprimer un objet dans la base de donnes
    $(".btn_supp").click(function (e) {
        e.preventDefault();
        $("#supp_modal .submit_supp").attr("href", $(this).attr("href"));
        $("#supp_modal").modal();
    });

    // ajouter une ligne de commande
    var ligne_cmd_index=$(".cmd_lgn_size").val();
    $(".btn_nv_ligne").click(function (e) {
        var selectedProduitId= $(".produit_list_nv_ligne").val();
        var selectedText= $(".produit_list_nv_ligne").find(":selected").text();
        var selectedQnt= $(".ligne_commande_qnt").val();
        $(".lignes_commandes_trs")
            .append("<tr class='graselectedIddeX'><td width='12%' class='center'>"+selectedProduitId+"</td>" +

                "<input type='hidden' value='"+selectedProduitId+"' name='ligneCommandes["+ligne_cmd_index+"].produit.id'>" +
                "<input type='hidden' value='"+selectedQnt+"' name='ligneCommandes["+ligne_cmd_index+"].quantite'>" +

            "          <td width='12%' class='center hidden-phone'>" +
            "             <img  class='img-rounded' width='40' height='40' src='/produits/getPic?id="+selectedProduitId+"' alt=''>" +
            "          </td>" +
            "          <td>"+selectedText+"</td>" +
            "          <td>"+selectedQnt+"</td>" +
            "          <td class='center hidden-phone'>" +
            "            <a class='delete_ligne'><i class='fas fa-trash-alt text-danger'></i></a>" +
            "          </td></tr>");
        ligne_cmd_index++;
    });

});