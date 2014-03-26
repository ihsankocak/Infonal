$(document).ajaxStart(function() {
    $('#img').show();
}).ajaxStop(function() {
    $('#img').hide();
});

function deleteUser(userId) {
    var data = {"id": userId};
    $.ajax({
        url: "user/delete",
        type: 'POST',
        async: false,
        dataType: 'text',
        data: data,
        success: function(data) {


            location.reload();

        },
        error: function(data, status, er) {
            alert("failed- " + data + " - " + status + " - " + er);
            isValid = false;

        }
    });
}
function addUser() {

    if (!validateUser()) {
        return false;
    }

    var userId = $("#userId").val();
    var name = $("#name").val();
    var surname = $("#surname").val();
    var phoneNumber = $("#phoneNumber").val();


    var data = {"userId": userId, "name": name, "surname": surname, "phoneNumber": phoneNumber};
    $.ajax({
        url: "user/save",
        type: 'POST',
        async: false,
        dataType: 'text',
        data: data,
        success: function(data) {


            location.reload();

        },
        error: function(data, status, er) {
            alert("failed- " + data + " - " + status + " - " + er);
            isValid = false;

        }
    });
}


