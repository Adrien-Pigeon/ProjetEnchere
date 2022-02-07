jQuery(document).ready(function($) {
    $('input[type="checkbox"]').on('change', function() {
        $(this).siblings('input[type="checkbox"]').prop('checked', false);
     });
     $(".buy").click(function(){
        $("#ventes").prop("checked", false);
        $("#debute").prop("checked", false);
        $("#termine").prop("checked", false);
      });
      $(".sell").click(function(){
        $("#achats").prop("checked", false);
        $("#encours").prop("checked", false);
        $("#remporter").prop("checked", false);
      });
      if($('#vente').is(':checked'))
{
    document.getElementById("achats").disabled = true;
    document.getElementById("remporter").disabled = true;
    document.getElementById("encours").disabled = true;
    document.getElementById("ventes").disabled = false;
    document.getElementById("debute").disabled = false;
    document.getElementById("termine").disabled = false;
}
else if($('#achat').is(':checked'))
{
    document.getElementById("ventes").disabled = true;
    document.getElementById("debute").disabled = true;
    document.getElementById("termine").disabled = true;
    document.getElementById("achats").disabled = false;
    document.getElementById("encours").disabled = false;
    document.getElementById("remporter").disabled = false;
}
});