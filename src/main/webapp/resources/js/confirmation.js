function openDialog(i, type) {
    if (type == "delete") {


        $("#dialog-confirm_" + i).html("Are you sure to delete?");


        $("#dialog-confirm_" + i).dialog({
            resizable: false,
            modal: true,
            title: "Delete Confirmation",
            height: 150,
            width: 200,
            buttons: {
                "Yes": function() {
                    $(this).dialog('close');
                    $("#hiddenDeleteButton_" + i).click();

                },
                "No": function() {
                    $(this).dialog('close');

                }
            }
        });

    }
    else if (type == "edit") {




        $("#dialog-edit_" + i).dialog({
            resizable: false,
            modal: true,
            title: "Edit User",
            height: 150,
            width: 200,
            buttons: {
                "Save": function() {

                    $("#userEditForm_" + i).submit();
                    if ($("#userId").val() == "-1") {

                    }
                    alert("issssubmited" + isSubmitted.toString())
                    if (isSubmitted) {
                        $(this).dialog('close');
                    }




                },
                "Cancel": function() {
                    $(this).dialog('close');

                }
            }
        });

    }
    return false;
}






$('.delClass').live("click", function() {
    var i = this.getAttribute("index");

    openDialog(i, "delete");
    return false;
});

$('.editClass').live("click", function() {
    var i = this.getAttribute("index");

    openDialog(i, "edit");
    return false;
});


